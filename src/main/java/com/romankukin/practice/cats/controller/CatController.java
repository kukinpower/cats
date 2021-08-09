package com.romankukin.practice.cats.controller;

import com.romankukin.practice.cats.model.Cat;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatController {

  private final ObjectProvider<Cat> catObjectProvider;

  @Autowired
  public CatController(
      ObjectProvider<Cat> catObjectProvider) {
    this.catObjectProvider = catObjectProvider;
  }

  @PostMapping("/cats/{name}")
  public void catSays(@PathVariable String name) {
    catObjectProvider.getObject(name).say();
  }
}
