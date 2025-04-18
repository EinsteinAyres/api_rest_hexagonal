package com.estudos.api_rest.adapters.outbound;

import com.estudos.api_rest.domain.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ProductRepositoryImplTest {

    private SpringDataProductRepository jpaRepository;
    private ProductRepositoryImpl repository;

    @BeforeEach
    void setup() {
        jpaRepository = mock(SpringDataProductRepository.class);
        repository = new ProductRepositoryImpl(jpaRepository);
    }

    @Test
    void shouldSaveProduct() {
        Product product = new Product(null, "Test", BigDecimal.TEN);
        Product saved = new Product(1L, "Test", BigDecimal.TEN);

        when(jpaRepository.save(product)).thenReturn(saved);

        Product result = repository.save(product);
        assertEquals(1L, result.getId());
    }

    @Test
    void shouldFindById() {
        Product product = new Product(1L, "Test", BigDecimal.TEN);
        when(jpaRepository.findById(1L)).thenReturn(Optional.of(product));

        Optional<Product> result = repository.findById(1L);
        assertTrue(result.isPresent());
    }

    @Test
    void shouldFindAll() {
        when(jpaRepository.findAll()).thenReturn(Arrays.asList(
                new Product(1L, "A", BigDecimal.ONE),
                new Product(2L, "B", BigDecimal.TEN)));

        List<Product> result = repository.findAll();
        assertEquals(2, result.size());
    }

    @Test
    void shouldDeleteById() {
        repository.deleteById(1L);
        verify(jpaRepository).deleteById(1L);
    }

}
