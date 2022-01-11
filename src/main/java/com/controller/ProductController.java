package com.controller;
import com.model.ProductModel;
import com.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ProductController {
    @Autowired

    private ProductService productService;

    @RequestMapping("/")
    public ModelAndView addCustomerViewPage(){
        ModelAndView mv=new ModelAndView("AddProducts");
        productService.addProducts(mv);
    return mv;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveProduct(@ModelAttribute("Product") final ProductModel productModel){
        ModelAndView mv=new ModelAndView("redirect:ViewProducts");
        productService.saveProducts(productModel);
        return mv;
    }

    @RequestMapping(value = "/ViewProducts")
    public ModelAndView getProduct(){
        ModelAndView mv=new ModelAndView("ViewProducts");
        productService.getAllProducts(mv);
        return mv;
    }
}