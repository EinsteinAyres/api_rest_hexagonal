package com.estudos.api_rest.adapters.inbound.mapper;

import com.estudos.api_rest.adapters.inbound.dto.ProductRequestDTO;
import com.estudos.api_rest.adapters.inbound.dto.ProductResponseDTO;
import com.estudos.api_rest.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public class ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    public Product toEntity(ProductRequestDTO dto) {
        return null;
    }

    public ProductResponseDTO toResponse(Product product) {
        return null;
    }

}
