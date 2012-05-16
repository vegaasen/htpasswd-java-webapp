package com.vegaasen.htpasswd.util;

import java.net.URL;
import java.util.Properties;

/**
 * @author vegaasen
 */
public class PropertiesUtil {

    public static Properties loadProperties() throws Exception {
        Properties loadedProperties = new Properties();

        URL systemLocation = ClassLoader.getSystemResource("system.properties");
        
        loadedProperties.load(systemLocation.openStream());

        return loadedProperties;
    }
}
