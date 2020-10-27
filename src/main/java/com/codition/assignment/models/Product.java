package com.codition.assignment.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class Product {

  @Id
  private String id;
  private String productName = "item";
  private double price = 10.00;
  private String description = "any description";

  Category productCategory;

  public Product() {
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Category getProductCategory() {
    return productCategory;
  }

  public void setProductCategory(Category productCategory) {
    this.productCategory = productCategory;
  }

  @Override
  public String toString() {
    return "Product [description=" + description + ", id=" + id + ", price=" + price + ", productCategory="
        + productCategory + ", productName=" + productName + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((description == null) ? 0 : description.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    long temp;
    temp = Double.doubleToLongBits(price);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + ((productCategory == null) ? 0 : productCategory.hashCode());
    result = prime * result + ((productName == null) ? 0 : productName.hashCode());
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
    Product other = (Product) obj;
    if (description == null) {
      if (other.description != null)
        return false;
    } else if (!description.equals(other.description))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
      return false;
    if (productCategory == null) {
      if (other.productCategory != null)
        return false;
    } else if (!productCategory.equals(other.productCategory))
      return false;
    if (productName == null) {
      if (other.productName != null)
        return false;
    } else if (!productName.equals(other.productName))
      return false;
    return true;
  }

  public Product(String id, String productName, double price, String description, Category productCategory) {
    this.id = id;
    this.productName = productName;
    this.price = price;
    this.description = description;
    this.productCategory = productCategory;
  }

}
