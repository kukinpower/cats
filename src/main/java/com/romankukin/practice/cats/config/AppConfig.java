package com.romankukin.practice.cats.config;

import com.romankukin.practice.cats.model.Cat;
import com.romankukin.practice.cats.model.CatImpl;
import com.romankukin.practice.cats.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

  private final CatService catService;

  @Autowired
  public AppConfig(CatService catService) {
    this.catService = catService;
  }

  @Bean
  @Scope(BeanDefinition.SCOPE_PROTOTYPE)
  @Profile("!stub && impl")
  public Cat createCatImpl(String name) {
    return new CatImpl(catService, name);
  }

  @Bean
  @Scope(BeanDefinition.SCOPE_PROTOTYPE)
  @Profile("stub && !impl")
  public Cat createCatStub(String name) {
    return new CatStub(catService, name);
  }
}
