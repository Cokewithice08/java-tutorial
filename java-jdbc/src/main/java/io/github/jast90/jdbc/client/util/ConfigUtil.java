package io.github.jast90.jdbc.client.util;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhangzhiwen
 * @Description:
 * @date 2021/12/10 14:14
 */
public class ConfigUtil {
    private static Map<String,PropertiesConfiguration> cache = new ConcurrentHashMap();

    public static <T> T get(String file,String key,Class<T> tClass){
        try {
            cache.putIfAbsent(file, new Configurations().properties(file));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        PropertiesConfiguration propertiesConfiguration = cache.get(file);
        return propertiesConfiguration.get(tClass, key);
    }


}
