package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (input == null){
                throw new RuntimeException("config.properties file is not found!");
            }
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key){
        // First the system property (for CI/CD), then the properties file.
        String value = System.getProperty(key);
        if (value == null){
            value = properties.getProperty(key);
        }
        return value;
    }


    public static boolean isHeadless(){
        return Boolean.parseBoolean(get("headless"));
    }


    public static int getSlowMo(){
        return Integer.parseInt(get("slowMo"));
    }



}


