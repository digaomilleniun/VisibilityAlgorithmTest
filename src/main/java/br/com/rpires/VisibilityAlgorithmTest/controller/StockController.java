package br.com.rpires.VisibilityAlgorithmTest.controller;

import br.com.rpires.VisibilityAlgorithmTest.domain.Stock;
import br.com.rpires.VisibilityAlgorithmTest.dto.ResponseMessage;
import br.com.rpires.VisibilityAlgorithmTest.service.StockService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("stock")
public class StockController {

    private StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @Operation(summary = "Upload file of products")
    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> upload(@RequestParam("file") @NotNull MultipartFile file) {
        stockService.upload(file);
        return ResponseEntity.ok(new ResponseMessage("File imported successfully"));
    }

    @Operation(summary = "Find all sizes with pagination")
    @GetMapping
    public ResponseEntity<Page<Stock>> list(@RequestParam(name = "page", required = true) Integer page,
                                            @RequestParam(name = "size", required = true) Integer size) {
        return ResponseEntity.ok(stockService.findAll(page, size));
    }
}
