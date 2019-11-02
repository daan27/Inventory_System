package com.project.inventory.controllers;

import com.project.inventory.Entities.Products;
import com.project.inventory.model.ApiResponse;
import com.project.inventory.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/upload")
public class UploadController  {

    @Autowired
    private ProductService productService;

    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

    @PostMapping(value = "/uploadProducts", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse uploadProduct(@RequestBody List<Products> products, HttpServletResponse response){
        ApiResponse apiResponse = new ApiResponse();

        try{
            productService.saveAll(products);
        }catch (Exception e ){
            e.printStackTrace();
            apiResponse.setSuccessful(false);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }

        return apiResponse;
    }


}
