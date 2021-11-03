package com.example.springbootproductmanagement.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ProductForm {
    private Long id;

    @NotEmpty(message = "không được để trống")
    private String name;

    @NotNull
    private double price;

    @NotNull
    private String description;

    private MultipartFile image;

    private Category category;
}
