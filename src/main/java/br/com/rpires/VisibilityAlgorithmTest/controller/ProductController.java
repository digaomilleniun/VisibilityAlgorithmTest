package br.com.rpires.VisibilityAlgorithmTest.controller;

import br.com.rpires.VisibilityAlgorithmTest.domain.Product;
import br.com.rpires.VisibilityAlgorithmTest.dto.ResponseMessage;
import br.com.rpires.VisibilityAlgorithmTest.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Upload file of products")
    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> upload(@RequestParam("file") @NotNull MultipartFile file) {
        productService.upload(file);
        return ResponseEntity.ok(new ResponseMessage("File imported successfully"));
    }

    @Operation(summary = "Find all products with pagination")
    @GetMapping
    public ResponseEntity<Page<Product>> list(@RequestParam(name = "page", required = true) Integer page,
                                              @RequestParam(name = "size", required = true) Integer size) {
        return ResponseEntity.ok(productService.findAll(page, size));
    }


}
