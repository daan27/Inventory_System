package com.project.inventory.services;

import com.project.inventory.Entities.Products;

import java.util.List;

public interface ProductService  {

    void saveAll (List<Products>products) throws Exception;
}
