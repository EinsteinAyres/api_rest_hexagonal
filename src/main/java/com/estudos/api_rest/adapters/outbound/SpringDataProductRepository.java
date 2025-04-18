package com.estudos.api_rest.adapters.outbound;

import com.estudos.api_rest.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataProductRepository extends JpaRepository<Product, Long> {
}
