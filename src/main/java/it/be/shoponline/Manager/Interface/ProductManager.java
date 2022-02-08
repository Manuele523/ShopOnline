package it.be.shoponline.Manager.Interface;

import it.be.shoponline.DTO.ProductDTO;

import java.util.List;
import java.util.stream.Stream;

public interface ProductManager {

    Stream<ProductDTO> findAllProduct();

    Stream<ProductDTO> findAllProductByCategory(String category);

    void insertProduct(ProductDTO product);

    void updateProduct(ProductDTO product);
}
