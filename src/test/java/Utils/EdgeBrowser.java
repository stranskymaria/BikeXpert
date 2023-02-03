package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EdgeBrowser extends Browser{

    public EdgeBrowser() {
        WebDriverManager.edgedriver().setup();
        this.driver = new EdgeDriver();
    }

}