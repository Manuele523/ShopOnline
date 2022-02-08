package it.be.shoponline.Mapper;

import it.be.shoponline.DTO.ProductDTO;
import it.be.shoponline.Entity.ProductEntity;


public class ProductMapper extends Mapper {

    public static ProductDTO mapToProductDTO(ProductEntity entity) {
       return mapper.convertValue(entity, ProductDTO.class);
    }

    public static ProductEntity mapToProductEntity(ProductDTO dto) {
        return mapper.convertValue(dto, ProductEntity.class);
    }

}

