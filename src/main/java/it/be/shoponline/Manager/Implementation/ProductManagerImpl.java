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
    public Stream<ProductDTO> findAll() {
        return productService.findAll().stream().map(ProductMapper::mapToDTO);
    }

    @Override
    public Stream<ProductDTO> findAllByCategory(String category) {
        return productService.findAllByCategory(category).stream().map(ProductMapper::mapToDTO);
    }

    @Override
    public void insert(ProductDTO product) {
        productService.insert(ProductMapper.mapToEntity(product));
    }

    @Override
    public void update(ProductDTO product) {
        productService.update(ProductMapper.mapToEntity(product));
    }

}
