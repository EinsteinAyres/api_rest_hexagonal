package com.estudos.api_rest.adapters.outbound;

import com.estudos.api_rest.domain.model.Product;
import com.estudos.api_rest.domain.ports.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class JpaProductRepository implements ProductRepository {

    private final Map<Long, Product> database = new ConcurrentHashMap<>();
    private static long idCounter = 1;

    @Override
    public Product save(Product product) {
        if (product.getId() == null) {
            product = new Product(idCounter++, product.getName(), product.getPrice());
        }
        database.put(product.getId(), product);
        return product;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(database.get(id));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(database.values());
    }

    @Override
    public void deleteById(Long id) {
        database.remove(id);
    }

}
