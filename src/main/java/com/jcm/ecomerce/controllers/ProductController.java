package com.jcm.ecomerce.controllers;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @GetMapping
    public String teste(){
        return "Ola mundo";
    }

}