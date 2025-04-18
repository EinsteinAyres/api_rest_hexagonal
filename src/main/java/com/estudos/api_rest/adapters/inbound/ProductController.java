package com.estudos.api_rest.adapters.inbound;

import com.estudos.api_rest.adapters.inbound.dto.ProductRequestDTO;
import com.estudos.api_rest.adapters.inbound.dto.ProductResponseDTO;
import com.estudos.api_rest.adapters.inbound.mapper.ProductMapper;
import com.estudos.api_rest.application.usecases.ProductService;
import com.estudos.api_rest.domain.model.Product;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> create(@Valid @RequestBody ProductRequestDTO request) {
        Product product = new Product(null, request.getName(), request.getPrice());
        Product saved = service.create(product);
        return ResponseEntity.ok(new ProductResponseDTO(saved.getId(), saved.getName(), saved.getPrice()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(p -> new ProductResponseDTO(p.getId(), p.getName(), p.getPrice()))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAll() {
        List<ProductResponseDTO> list = service.getAll().stream()
                .map(p -> new ProductResponseDTO(p.getId(), p.getName(), p.getPrice()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
