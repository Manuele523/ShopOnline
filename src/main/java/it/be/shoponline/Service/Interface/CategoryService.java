package it.be.shoponline.Service.Interface;

import it.be.shoponline.Entity.CategoryEntity;

import java.util.List;

public interface CategoryService {

    List<CategoryEntity> findAll();

    void insert(CategoryEntity entity);

    void update(CategoryEntity entity);

}
