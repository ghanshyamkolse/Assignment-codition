package com.codition.assignment.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "category")
public class Category {

  String categoryName;

  Subcategory subCategory;

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public Subcategory getSubCategory() {
    return subCategory;
  }

  public void setSubCategory(Subcategory subCategory) {
    this.subCategory = subCategory;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
    result = prime * result + ((subCategory == null) ? 0 : subCategory.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Category other = (Category) obj;
    if (categoryName == null) {
      if (other.categoryName != null)
        return false;
    } else if (!categoryName.equals(other.categoryName))
      return false;
    if (subCategory == null) {
      if (other.subCategory != null)
        return false;
    } else if (!subCategory.equals(other.subCategory))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Category [categoryName=" + categoryName + ", subCategory=" + subCategory + "]";
  }

  public Category() {
  }

  public Category(String categoryName, Subcategory subCategory) {
    this.categoryName = categoryName;
    this.subCategory = subCategory;
  }

}
