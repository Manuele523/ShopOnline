package it.be.shoponline.Manager.Interface;

import it.be.shoponline.DTO.CategoryDTO;
import it.be.shoponline.Enum.StatusCode;

import java.util.stream.Stream;

public interface CategoryManager {

    Stream<CategoryDTO> findAll();

    StatusCode insert(CategoryDTO category);

    StatusCode update(CategoryDTO category);

    StatusCode delete(Long idCategory);
}
