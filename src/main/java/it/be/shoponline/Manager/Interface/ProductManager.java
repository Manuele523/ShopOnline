package it.be.shoponline.Manager.Interface;

import it.be.shoponline.DTO.ProductDTO;
import it.be.shoponline.Enum.StatusCode;

import java.util.stream.Stream;

public interface ProductManager {

    Stream<ProductDTO> findAll();

    StatusCode insert(ProductDTO product) throws Exception;

    StatusCode update(ProductDTO product) throws Exception;

    StatusCode delete(Long idProduct);
}
