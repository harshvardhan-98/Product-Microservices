package com.services;

import com.dao.ProductRepo;
import com.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;
    public Model addProducts(Model model){
        model.addAttribute("product",new ProductModel());
        return model;
    }
    public ProductModel saveProducts(ProductModel productModel){
        return productRepo.save(productModel);
    }

    public String getAllProducts(final Model model){
        List<ProductModel> productModelList = (List<ProductModel>) productRepo.findAll();
        model.addAttribute("productModelList",productModelList);
        return "model";
    }
}
