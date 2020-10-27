package com.codition.assignment;

import java.util.ArrayList;
import java.util.List;

import com.codition.assignment.models.Product;
// import com.mongodb.client.model.Sorts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping(value = "/test")
    public String getMethodName() {
        return "ok tested";
    }

    @GetMapping(value = "/products")
    public ResponseEntity<List<Product>> getProducts() {
        try {
            List<Product> _product = new ArrayList<Product>();

            productRepository.findAll().forEach(_product::add);

            if (_product.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(_product, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(value = "/product/{id}")
    public Product getMethodName(@RequestParam(required = false) String param) {
        return new Product(param, param, 0, param, null);
    }

    @PostMapping(value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Product> addProduct(@RequestBody Product entity) {
        try {
            Product _product = productRepository.save(entity);
            System.out.println(_product);

            return new ResponseEntity<>(_product, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping(value = "product/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product entity) {
        try {
            Product _product = null;
            if (productRepository.existsById(id)) {
                _product = productRepository.save(entity);
            }

            return new ResponseEntity<>(_product, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
