package gourgeossandwich.config;

import java.io.InputStream;
import java.util.Properties;

public final class PropertiesConfig {

    public static final Properties properties;

    static {
        properties = new Properties();
        try {
            ClassLoader classLoader = PropertiesConfig.class.getClassLoader();
            InputStream propStream = classLoader.getResourceAsStream("application.properties");
            properties.load(propStream);
        } catch (Exception e) {
            System.out.println("Error loading properties file.");
        }
    }
}
