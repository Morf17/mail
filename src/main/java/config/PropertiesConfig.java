package config;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static org.testng.Assert.fail;

public class PropertiesConfig {

    private static Properties properties;

    public static String get(String key) {
        if (properties == null) {
            init();
        }
        return properties.getProperty(key);
    }

    private static void init() {
        File configFile = new File("src/main/resources/config.properties");
        try {
            properties = new Properties();
            properties.load(new FileInputStream(configFile));
        } catch (IOException e) {
            fail("Error open config file: " + e.getMessage());
        }
    }

}
