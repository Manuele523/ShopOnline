package it.be.shoponline.Manager.Interface;

import it.be.shoponline.DTO.CategoryDTO;

import java.util.stream.Stream;

public interface CategoryManager {

    Stream<CategoryDTO> findAll();

    void insert(CategoryDTO category);

    void update(CategoryDTO category);
}
