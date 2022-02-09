package it.be.shoponline.Mapper;

import it.be.shoponline.DTO.ProductDTO;
import it.be.shoponline.Entity.ProductEntity;


public class ProductMapper extends Mapper {

    public static ProductDTO mapToDTO(ProductEntity entity) {
        return mapper.convertValue(entity, ProductDTO.class);
    }

    public static ProductEntity mapToEntity(ProductDTO dto) {
        return mapper.convertValue(dto, ProductEntity.class);
    }

}

