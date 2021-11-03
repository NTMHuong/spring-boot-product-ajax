package com.example.springbootproductmanagement.controller;

import com.example.springbootproductmanagement.model.Product;
import com.example.springbootproductmanagement.model.ProductForm;
import com.example.springbootproductmanagement.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductRestController {
    @Value("${file-upload}")
    private String fileUpload;

    @Autowired
    private IProductService productService;

    @GetMapping("/list")
    public ModelAndView getAllProductPage() {
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(ProductForm product) throws IOException {
        Product product1 = new Product();
        product1.setId(product.getId());
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setDescription(product.getDescription());
        MultipartFile multipartFile = product.getImage();
        String fileName = multipartFile.getOriginalFilename();
        FileCopyUtils.copy(fileName.getBytes(), new File(fileUpload + fileName));
        product1.setImage(fileName);
        return new ResponseEntity<>(productService.save(product1), HttpStatus.CREATED);
    }

    //Thêm phương thức hiển thị danh sách sản phẩm vào trong SmartphoneController
    @GetMapping
    public ResponseEntity<Page<Product>> showAll(@RequestParam(name = "q", required = false) Optional<String> q, @PageableDefault(size = 3) Pageable pageable) {
        Page<Product> products;
        if (!q.isPresent()) {
            products = productService.findAll(pageable);
        } else {
            products = productService.findAllByNameContaining(q.get(), pageable);
        }
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            if (product.getId() == null) {
                product.setId(id);
            }
            productService.save(product);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.remove(id);
        return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
    }
}
