package Utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigUtils {

    public static String getGenericValue(String configFile, String property, String defaultValue) {
        String outValue = defaultValue;
        try {
            Properties appProp = new Properties();
            appProp.load(Files.newInputStream(Paths.get(configFile)));
            outValue = appProp.getProperty(property);
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return outValue;
    }
}