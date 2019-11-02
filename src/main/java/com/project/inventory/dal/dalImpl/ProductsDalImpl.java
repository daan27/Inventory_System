package com.project.inventory.dal.dalImpl;

import com.project.inventory.Entities.Products;
import com.project.inventory.dal.ProductDal;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

public class ProductsDalImpl implements ProductDal {

    private final MongoTemplate mongoTemplate;

    public ProductsDalImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void save(Products products) throws Exception {
        mongoTemplate.save(products);
    }

    @Override
    public void saveAll(List<Products> productsList) throws Exception {
        for (Products products : productsList){
            save(products);
        }
    }
}
