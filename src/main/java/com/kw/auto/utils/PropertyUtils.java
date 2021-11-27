package com.kw.auto.utils;

import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.Properties;

@Log4j2
public final class PropertyUtils {
    public static final String BASE_URL = "base.url";
    private static final Properties ENV_PROPERTIES = System.getProperties();
    private PropertyUtils() { }

    static {
        try {
            ENV_PROPERTIES.load(PropertyUtils.class
                    .getResourceAsStream("/properties/main.properties"));
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public static Properties getProperties() {
        return ENV_PROPERTIES;
    }

}
