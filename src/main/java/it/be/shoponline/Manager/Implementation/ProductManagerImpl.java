package it.be.shoponline.Manager.Implementation;

import it.be.shoponline.DTO.ProductDTO;
import it.be.shoponline.Enum.StatusCode;
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
    public StatusCode insert(ProductDTO product) throws Exception {
        if (productService.insert(ProductMapper.mapToEntity(product)) != null) {
            return StatusCode.OK_INSERT;
        }  else {
            return StatusCode.KO_INSERT;
        }
    }

    @Override
    public StatusCode update(ProductDTO product) throws Exception {
        if (productService.insert(ProductMapper.mapToEntity(product)) != null) {
            return StatusCode.OK_UPDATE;
        }  else {
            return StatusCode.KO_UPDATE;
        }
    }

    @Override
    public StatusCode delete(Long idProduct) {
        if (productService.delete(idProduct)) {
            return StatusCode.OK_UPDATE;
        }  else {
            return StatusCode.KO_UPDATE;
        }
    }

}
