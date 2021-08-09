package com.romankukin.practice.cats.config;

import com.romankukin.practice.cats.model.Cat;
import com.romankukin.practice.cats.model.CatImpl;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

  @Bean
  @Scope(BeanDefinition.SCOPE_PROTOTYPE)
  @Profile("!stub && impl")
  public Cat createCatImpl(String name) {
    return new CatImpl(name);
  }

  @Bean
  @Scope(BeanDefinition.SCOPE_PROTOTYPE)
  @Profile("stub && !impl")
  public Cat createCatStub(String name) {
    return new CatStub(name);
  }
}
