package it.be.shoponline.Manager.Interface;

import it.be.shoponline.DTO.ProductDTO;

import java.util.stream.Stream;

public interface ProductManager {

    Stream<ProductDTO> findAll();

    Stream<ProductDTO> findAllByCategory(String category);

    void insert(ProductDTO product);

    void update(ProductDTO product);
}
