package com.vegaasen.htpasswd.util;

import org.apache.log4j.Logger;

import java.net.URL;
import java.util.Properties;

/**
 * @author vegaasen
 */
public class PropertiesUtil {

    private static final Logger LOGGER = Logger.getLogger(PropertiesUtil.class);

    public static Properties loadProperties() throws Exception {
        Properties loadedProperties = new Properties();

        URL systemLocation = ClassLoader.getSystemResource("system.properties");
        if(systemLocation!=null) {
            LOGGER.info("Loading the fetched URLStream");
            loadedProperties.load(systemLocation.openStream());
        }

        return loadedProperties;
    }
}
