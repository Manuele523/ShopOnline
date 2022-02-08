package it.be.shoponline.Service.Interface;

import it.be.shoponline.Entity.ProductEntity;

import java.util.List;

public interface ProductService {

    List<ProductEntity> findAllProduct();

    List<ProductEntity> findAllProductByCategory(String category);

    void insertProduct(ProductEntity mapToProductEntity);

    void updateProduct(ProductEntity mapToProductEntity);
}
