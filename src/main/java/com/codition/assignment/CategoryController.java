package com.codition.assignment;

import java.util.ArrayList;
import java.util.List;

import com.codition.assignment.models.Category;
// import com.codition.assignment.models.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

  @Autowired
  CategoryRepository categoryRepository;

  @GetMapping(value = "/category")
  public ResponseEntity<List<Category>> getCategory(@RequestParam(required = false) String param) {
    try {
      List<Category> _category = new ArrayList<Category>();

      categoryRepository.findAll().forEach(_category::add);

      if (_category.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(_category, HttpStatus.OK);
    } catch (Exception e) {

      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

  @PostMapping(value = "/category", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<Category> addCategory(@RequestBody Category entity) {
    try {
      Category _category = categoryRepository.save(entity);
      System.out.println(_category);

      return new ResponseEntity<>(_category, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

}
