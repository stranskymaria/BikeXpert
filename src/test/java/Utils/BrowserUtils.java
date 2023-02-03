package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {

    public static WebDriver getBrowser(String browser, String configFile) {

        switch (browser.toLowerCase()) {
            case ("chrome") : {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                // Use this for accepting self-signed or other insecure certificates in the test env
                options.setAcceptInsecureCerts(GenericUtils.getInsecureCertOptions(configFile));

                // Start browser in headless mode (without a visible UI) with the app in the background
                options.setHeadless(GenericUtils.getHeadlessMode(configFile));

                // Setting a proxy server
                if(GenericUtils.isProxyEnabled(configFile)) {
                    Proxy proxy = new Proxy();
                    proxy.setHttpProxy(
                            ConfigUtils.getGenericValue(configFile,"proxyAddress", "127.0.0.1") + ":" +
                                    ConfigUtils.getGenericValue(configFile, "proxyPort", "8081"));
                    options.setProxy(proxy);

                }

                // Setting a fixed download directory
                if(GenericUtils.isDownloadDirectoryEnabled(configFile)) {
                    Map<String, Object> preferences = new HashMap<>();
                    preferences.put("download.default_directory", ConstantUtils.DOWNLOAD_DIRECTORY);
                    options.setExperimentalOption("prefs", preferences);
                }

                if(GenericUtils.startMaximized(configFile)) {
                    // Start the browser maximized
                    options.addArguments("--start-maximized");
                }

                if (GenericUtils.enableExtension(configFile)) {
                    // Add an extension
                    options.addExtensions(new File(ConstantUtils.EXTENSION_FOLDER + "\\" +
                            ConfigUtils.getGenericValue(configFile, "extensionName", "extension_10_22_2_0.crx")));
                }

                return new ChromeDriver(options);
            }
            case ("firefox") : {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                FirefoxProfile profile = new FirefoxProfile();
                if(GenericUtils.startMaximized(configFile)) {
                    options.addArguments("--start-maximized");
                }

                if(GenericUtils.isDownloadDirectoryEnabled(configFile)) {
                    profile.setPreference("browser.download.dir", ConstantUtils.DOWNLOAD_DIRECTORY);
                }

                if(GenericUtils.enableExtension(configFile)) {
                    profile.addExtension(new File(ConstantUtils.EXTENSION_FOLDER + "\\" +
                            ConfigUtils.getGenericValue(configFile, "extensionName", "ether_metamask-10.22.2.xpi")
                    ));
                }

                options.setHeadless(GenericUtils.getHeadlessMode(configFile));
                options.setAcceptInsecureCerts(GenericUtils.getInsecureCertOptions(configFile));

                options.setProfile(profile);
                WebDriver driver = new FirefoxDriver(options);

                if(GenericUtils.startMaximized(configFile)) {
                    driver.manage().window().maximize();
                }
                driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigUtils.getGenericValue(configFile, "implicitTimeout", "10")), TimeUnit.SECONDS);
                return driver;
            }
            case ("edge") : {
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            }
            default : {
                System.out.println("Driver is not supported officially, please be careful");
                return WebDriverManager.getInstance(browser).getWebDriver();
            }
        }
    }

    public static Browser getBrowser(BrowserTypes browserType) {
        switch(browserType.toString()) {
            case ("CHROME") : {
                return new ChromeBrowser();
            }
            case("FIREFOX") : {
                return new FirefoxBrowser();
            }
            case("EDGE") : {
                return new EdgeBrowser();
            }
            default : {
                System.out.println("Browser not supported");
                return null;
            }
        }
    }

    public static String getBrowserExternal(String propName) {
        // Take all the system environment names and values
        Map<String, String> env = System.getenv();
        // Check if the property is set
        if (env.containsKey(propName)) {
            System.out.println("Running from ENV variable with browser: " + System.getenv(propName));
            return System.getenv(propName).toLowerCase();
        }
        else {
            return "CHROME";
        }
    }
}