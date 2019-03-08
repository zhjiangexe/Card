package com.jiang.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public CommandLineRunner demo() {
    return (args) -> {
      System.out.println("start");
    };
  }

  @Autowired
  private MessageSource messageSource;

  @Bean
  public LocalValidatorFactoryBean getValidator() {
    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
    bean.setValidationMessageSource(messageSource);
    return bean;
  }

  @Bean
  public CorsFilter corsFilter() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration config = new CorsConfiguration();
    config.setAllowedOrigins(Collections.singletonList("*"));
    config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
    config.setAllowedHeaders(Collections.singletonList("*"));
    config.setMaxAge(1800L);
    config.setAllowCredentials(true);
    source.registerCorsConfiguration("/api/**", config);
    source.registerCorsConfiguration("/management/**", config);
    source.registerCorsConfiguration("/v2/api-docs", config);
    return new CorsFilter(source);
  }
}
