package it.be.shoponline.Manager.Implementation;

import it.be.shoponline.DTO.ProductDTO;
import it.be.shoponline.Manager.Interface.ProductManager;
import it.be.shoponline.Mapper.ProductMapper;
import it.be.shoponline.Service.Interface.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class ProductManagerImpl implements ProductManager {

    @Autowired
    private ProductService productService;

    @Override
    public Stream<ProductDTO> findAllProduct() {
        return productService.findAllProduct().stream().map(ProductMapper::mapToProductDTO);
    }

    @Override
    public Stream<ProductDTO> findAllProductByCategory(String category) {
        return productService.findAllProductByCategory(category).stream().map(ProductMapper::mapToProductDTO);
    }

    @Override
    public void insertProduct(ProductDTO product) {
        productService.insertProduct(ProductMapper.mapToProductEntity(product));
    }

    @Override
    public void updateProduct(ProductDTO product) {
        productService.updateProduct(ProductMapper.mapToProductEntity(product));
    }

}
