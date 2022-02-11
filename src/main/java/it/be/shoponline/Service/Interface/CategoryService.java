package it.be.shoponline.Service.Interface;

import it.be.shoponline.Entity.CategoryEntity;

import java.util.List;

public interface CategoryService {

    List<CategoryEntity> findAll();

    CategoryEntity insert(CategoryEntity entity);

    Boolean delete(Long idCategory);

}
