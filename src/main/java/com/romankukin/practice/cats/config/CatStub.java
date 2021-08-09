package com.romankukin.practice.cats.config;

import com.romankukin.practice.cats.model.Cat;
import com.romankukin.practice.cats.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class CatStub implements Cat {

  @Autowired
  private CatService catService;

  private final String name;

  public CatStub(String name) {
    this.name = name;
  }

  @Override
  public void say() {
    System.out.println("Stub " + name + " says: 'meow-meow'");
    catService.print();
  }
}
