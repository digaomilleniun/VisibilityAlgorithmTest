package br.com.rpires.VisibilityAlgorithmTest.controller;

import br.com.rpires.VisibilityAlgorithmTest.domain.Product;
import br.com.rpires.VisibilityAlgorithmTest.service.AvailableStockService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("availableStock")
public class AvailableStockController {

    private AvailableStockService availableStockService;

    @Autowired
    private AvailableStockController(AvailableStockService availableStockService) {
        this.availableStockService = availableStockService;
    }

    @Operation(summary = "Find all available products with pagination")
    @GetMapping
    public ResponseEntity<Page<Product>> list(@RequestParam(name = "page", required = true) Integer page,
                                              @RequestParam(name = "size", required = true) Integer size) {
        return ResponseEntity.ok(availableStockService.findAllAvailable(page, size));
    }


}
