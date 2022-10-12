package com.coderscampus.assignment9.web;


import com.coderscampus.assignment9.domain.Recipe;
import com.coderscampus.assignment9.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class RecipeController {

    @Autowired
    private FileService fileService;


    @GetMapping("gluten-free")
    public Collection<Recipe> getGlutenFree() throws IOException {
        return (Collection<Recipe>) fileService.getRecipes()
                                               .stream()
                                               .filter(Recipe::getGlutenFree)
                                               .collect(Collectors.toList());
    }

    @GetMapping("vegan")
    public Collection<Recipe> getVegan() throws IOException {
        return (Collection<Recipe>) fileService.getRecipes().stream().filter(Recipe::getVegan).collect(Collectors.toList());
    }

    @GetMapping("vegan-and-gluten-free")
    public Collection<Recipe> getVeganAndGlutenFree() throws IOException {
        return fileService.getRecipes()
                          .stream()
                          .filter(x -> x.getGlutenFree() && x.getVegan())
                          .collect(Collectors.toList());
    }

    @GetMapping("vegetarian")
    public Collection<Recipe> getVegetarian() throws IOException {
        return (Collection<Recipe>) fileService.getRecipes()
                                               .stream()
                                               .filter(Recipe::getVegetarian)
                                               .collect(Collectors.toList());
    }

    @GetMapping("all-recipes")
    public Collection<Recipe> getRecipes() throws IOException {
        return (Collection<Recipe>) fileService.getRecipes();
    }

}


