package io.github.jast90.jdbc.client.operation;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

/**
 * @author zhangzhiwen
 * @Description:
 * @date 2021/12/10 13:52
 */
public class DbConfig {
    private String url;
    private String username;
    private String password;

    public DbConfig() {
        try {
            Configurations configurations = new Configurations();
            PropertiesConfiguration properties = configurations.properties("db.properties");
            this.url = properties.getString("url");
            this.username=properties.getString("username");
            this.password=properties.getString("password");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
