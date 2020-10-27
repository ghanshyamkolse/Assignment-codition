package com.codition.assignment.models;

import java.util.List;

public class Subcategory {

  List<String> subCategory;

  public List<String> getSubCategory() {
    return subCategory;
  }

  public void setSubCategory(List<String> subCategory) {
    this.subCategory = subCategory;
  }

  @Override
  public String toString() {
    return "Subcategory [subCategory=" + subCategory + "]";
  }

  public Subcategory() {
  }

  public Subcategory(List<String> subCategory) {
    this.subCategory = subCategory;
  }

}
