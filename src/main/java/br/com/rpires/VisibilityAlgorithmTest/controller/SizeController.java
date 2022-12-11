package br.com.rpires.VisibilityAlgorithmTest.controller;

import br.com.rpires.VisibilityAlgorithmTest.domain.Size;
import br.com.rpires.VisibilityAlgorithmTest.dto.ResponseMessage;
import br.com.rpires.VisibilityAlgorithmTest.service.SizeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("size")
public class SizeController {

    private SizeService sizeService;

    public SizeController(SizeService sizeService) {
        this.sizeService = sizeService;
    }

    @Operation(summary = "Upload file of products")
    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> upload(@RequestParam("file") @NotNull MultipartFile file) {
        sizeService.upload(file);
        return ResponseEntity.ok(new ResponseMessage("File imported successfully"));
    }

    @Operation(summary = "Find all sizes with pagination")
    @GetMapping
    public ResponseEntity<Page<Size>> list(@RequestParam(name = "page", required = true) Integer page,
                                           @RequestParam(name = "size", required = true) Integer size) {
        return ResponseEntity.ok(sizeService.findAll(page, size));
    }
}
