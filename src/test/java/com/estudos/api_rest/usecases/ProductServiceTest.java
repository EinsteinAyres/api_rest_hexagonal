package com.estudos.api_rest.usecases;

import com.estudos.api_rest.application.usecases.ProductService;
import com.estudos.api_rest.domain.model.Product;
import com.estudos.api_rest.domain.ports.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    private ProductRepository repository;
    private ProductService service;

    @BeforeEach
    void setup() {
        repository = mock(ProductRepository.class);
        service = new ProductService(repository);
    }

    @Test
    void shouldCreateProduct() {
        Product product = new Product(null, "Test", BigDecimal.TEN);
        Product saved = new Product(1L, "Test", BigDecimal.TEN);

        when(repository.save(product)).thenReturn(saved);

        Product result = service.create(product);
        assertEquals(1L, result.getId());
        assertEquals("Test", result.getName());
    }

    @Test
    void shouldReturnProductById() {
        Product product = new Product(1L, "Test", BigDecimal.TEN);
        when(repository.findById(1L)).thenReturn(Optional.of(product));

        Optional<Product> result = service.getById(1L);
        assertTrue(result.isPresent());
        assertEquals("Test", result.get().getName());
    }

    @Test
    void shouldReturnAllProducts() {
        when(repository.findAll()).thenReturn(Arrays.asList(
                new Product(1L, "A", BigDecimal.ONE),
                new Product(2L, "B", BigDecimal.TEN)));

        List<Product> result = service.getAll();
        assertEquals(2, result.size());
    }

    @Test
    void shouldDeleteProduct() {
        service.delete(1L);
        verify(repository).deleteById(1L);
    }

}
