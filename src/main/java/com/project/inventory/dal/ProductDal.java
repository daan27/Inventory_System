package com.project.inventory.dal;

import com.project.inventory.Entities.Products;

import java.util.List;

public interface ProductDal {
    void save(Products products) throws Exception;
    void saveAll(List<Products> products) throws Exception;
}
