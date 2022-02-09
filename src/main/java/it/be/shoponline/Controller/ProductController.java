package it.be.shoponline.Controller;

import it.be.shoponline.DTO.ProductDTO;
import it.be.shoponline.Manager.Interface.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductManager productManager;

    @GetMapping("/findAll")
    public Stream<ProductDTO> findAll() {
        return productManager.findAll();
    }

    @GetMapping("/findAllByCategory")
    public Stream<ProductDTO> findAllByCategory(@RequestParam("category") String category) {
        return productManager.findAllByCategory(category);
    }

    @PostMapping("/insert")
    public void insert(@RequestBody ProductDTO product) {
        productManager.insert(product);
    }

    @PostMapping("/update")
    public void update(@RequestBody ProductDTO product) {
        productManager.update(product);
    }

}
