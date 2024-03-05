package ru.vw.practice.lesson6.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import ru.vw.practice.lesson6.handler.RestTemplateErrorHandler;

@Configuration
@EnableConfigurationProperties(ProductRestTemplateProperties.class)
public class ProductRestTemplateConfig {
  private final ProductRestTemplateProperties productRestTemplateProperties;

  public ProductRestTemplateConfig(ProductRestTemplateProperties productRestTemplateProperties) {
    this.productRestTemplateProperties = productRestTemplateProperties;
  }
  @Bean
  public RestTemplate productRestTemplate(RestTemplateErrorHandler restTemplateErrorHandler) {
    return new RestTemplateBuilder()
            .rootUri(productRestTemplateProperties.getRootUrl())
            .setConnectTimeout(productRestTemplateProperties.getConnectTimeout())
            .setReadTimeout(productRestTemplateProperties.getReadTimeout())
            .errorHandler(restTemplateErrorHandler)
            .build();
  }

}
