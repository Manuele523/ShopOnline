package it.be.shoponline.Service.Interface;

import it.be.shoponline.Entity.ProductEntity;

import java.util.List;

public interface ProductService {

    List<ProductEntity> findAll();

    List<ProductEntity> findAllByCategory(String category);

    ProductEntity insert(ProductEntity entity) throws Exception;

}
