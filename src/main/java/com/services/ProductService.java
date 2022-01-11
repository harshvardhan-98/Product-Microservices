package com.services;

import com.dao.ProductRepo;
import com.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;
    public void addProducts(ModelAndView model){
//        model.addAttribute("product",new ProductModel());
        model.addObject("product",new ProductModel());
    }
    public ProductModel saveProducts(ProductModel productModel){
        return productRepo.save(productModel);
    }

    public void getAllProducts(final ModelAndView model){
        List<ProductModel> productModelList = (List<ProductModel>) productRepo.findAll();
/*
        model.addAttribute("productModelList",productModelList);
*/
        model.addObject("productModelList",productModelList);
    }
}
