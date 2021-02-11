package net.xiaoluo.learning.shenruqianchuspringboot2.chapter3.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-11
 */
@Component
@ConfigurationProperties("database")
public class DatabaseProperties {

  // @Value("${database.driverName}")
  private String driverName;

  // @Value("${database.url}")
  private String url;

  private String username;

  private String password;

  public void setDriverName(String driverName) {
    this.driverName = driverName;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  // @Value("${database.username}")
  public void setUsername(String username) {
    this.username = username;
  }

  // @Value("${database.password}")
  public void setPassword(String password) {
    this.password = password;
  }

  public String getDriverName() {
    return driverName;
  }

  public String getUrl() {
    return url;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

}
