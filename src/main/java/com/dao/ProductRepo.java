package com.dao;

import com.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<ProductModel, Long> {

}
