package ru.vw.practice.lesson6.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

@ConfigurationProperties(prefix = "integration.product")
public class ProductRestTemplateProperties {
  private String rootUrl;
  private Duration connectTimeout;
  private Duration readTimeout;

  public ProductRestTemplateProperties(String rootUrl, Duration connectTimeout, Duration readTimeout) {
    this.connectTimeout = connectTimeout;
    this.rootUrl = rootUrl;
    this.readTimeout = readTimeout;
  }

  public String getRootUrl() {
    return rootUrl;
  }

  public void setRootUrl(String rootUrl) {
    this.rootUrl = rootUrl;
  }

  public Duration getConnectTimeout() {
    return connectTimeout;
  }

  public void setConnectTimeout(Duration connectTimeout) {
    this.connectTimeout = connectTimeout;
  }

  public Duration getReadTimeout() {
    return readTimeout;
  }

  public void setReadTimeout(Duration readTimeout) {
    this.readTimeout = readTimeout;
  }
}
