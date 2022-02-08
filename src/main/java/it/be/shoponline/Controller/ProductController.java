package it.be.shoponline.Controller;

import it.be.shoponline.DTO.ProductDTO;
import it.be.shoponline.Manager.Interface.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductManager productManager;

    @GetMapping("/findAllProduct")
    public Stream<ProductDTO> findAllProduct() {
        return productManager.findAllProduct();
    }

    @GetMapping("/findAllProductByCategory")
    public Stream<ProductDTO> findAllProductByCategory(@RequestParam("category") String category) {
        return productManager.findAllProductByCategory(category);
    }

    @PostMapping("/insertProduct")
    public void insertProduct(@RequestBody ProductDTO product) {
        productManager.insertProduct(product);
    }

    @PostMapping("/updateProduct")
    public void updateProduct(@RequestBody ProductDTO product) {
        productManager.updateProduct(product);
    }

}
