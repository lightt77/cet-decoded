package com.abhishek.cetdecoded.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

public class PropertiesFileReader
{
    private static Properties properties;
    //private final static String PROPERTIES_FILE_PATH = "src/main/resources/application.properties";
    private static String PROPERTIES_FILE_PATH;

    static
    {
        try
        {
            PROPERTIES_FILE_PATH = PropertiesFileReader.class.getClassLoader().getResource("application.properties").toURI().getPath();
        }
        catch (URISyntaxException e)
        {
            e.printStackTrace();
        }

        properties = new Properties();
        try
        {
            properties.load(new FileInputStream(PROPERTIES_FILE_PATH));
        }
        catch (IOException e)
        {
            // TODO: log exception stacktrace
            e.printStackTrace();
        }
    }

    public static String getProperty(String key)
    {
        return properties.getProperty(key);
    }
}
