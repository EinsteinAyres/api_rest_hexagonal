package com.estudos.api_rest.adapters.inbound;

import com.estudos.api_rest.adapters.inbound.dto.ProductRequestDTO;
import com.estudos.api_rest.adapters.inbound.dto.ProductResponseDTO;
import com.estudos.api_rest.adapters.inbound.mapper.ProductMapper;
import com.estudos.api_rest.application.usecases.ProductService;
import com.estudos.api_rest.domain.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductControllerTest {

    private ProductService service;
    private ProductMapper mapper;
    private ProductController controller;

    @BeforeEach
    void setup() {
        service = mock(ProductService.class);
        mapper = mock(ProductMapper.class);
        controller = new ProductController(service, mapper);
    }

    @Test
    void shouldCreateProduct() {
        ProductRequestDTO request = new ProductRequestDTO();
        request.setName("Test");
        request.setPrice(BigDecimal.TEN);

        Product product = new Product(null, "Test", BigDecimal.TEN);
        Product saved = new Product(1L, "Test", BigDecimal.TEN);
        ProductResponseDTO response = new ProductResponseDTO(1L, "Test", BigDecimal.TEN);

        when(mapper.toEntity(request)).thenReturn(product);
        when(service.create(product)).thenReturn(saved);
        when(mapper.toResponse(saved)).thenReturn(response);

        ResponseEntity<ProductResponseDTO> result = controller.create(request);

        assertEquals(200, result.getStatusCodeValue());
        assertEquals(1L, result.getBody().getId());
    }

    @Test
    void shouldReturnProductById() {
        Product product = new Product(1L, "Test", BigDecimal.TEN);
        ProductResponseDTO response = new ProductResponseDTO(1L, "Test", BigDecimal.TEN);

        when(service.getById(1L)).thenReturn(Optional.of(product));
        when(mapper.toResponse(product)).thenReturn(response);

        ResponseEntity<ProductResponseDTO> result = controller.getById(1L);

        assertEquals(200, result.getStatusCodeValue());
        assertEquals("Test", result.getBody().getName());
    }

}
