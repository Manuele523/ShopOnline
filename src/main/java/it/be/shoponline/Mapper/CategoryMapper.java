package it.be.shoponline.Mapper;

import it.be.shoponline.DTO.CategoryDTO;
import it.be.shoponline.Entity.CategoryEntity;


public class CategoryMapper extends Mapper {

    public static CategoryDTO mapToDTO(CategoryEntity entity) {
       return mapper.convertValue(entity, CategoryDTO.class);
    }

    public static CategoryEntity mapToEntity(CategoryDTO dto) {
        return mapper.convertValue(dto, CategoryEntity.class);
    }

}

