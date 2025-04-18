package com.estudos.api_rest.adapters.inbound.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ProductResponseDTO {

    private Long id;
    private String name;
    private BigDecimal price;

    public ProductResponseDTO() {}

    public ProductResponseDTO(Long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

}
