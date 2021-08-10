package com.romankukin.practice.cats.model;

import com.romankukin.practice.cats.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class CatImpl implements Cat {

  private final CatService catService;
  private final String name;

  public CatImpl(CatService catService, String name) {
    this.catService = catService;
    this.name = name;
  }

  @Override
  public void say() {
    System.out.println("Impl " + name + " says: 'meow'");
    catService.print();
  }
}
