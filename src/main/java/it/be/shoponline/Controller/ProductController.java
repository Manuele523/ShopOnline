package it.be.shoponline.Controller;

import it.be.shoponline.Controller.OutcomeType.Response;
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

    @PostMapping("/findAllByCategory")
    public Stream<ProductDTO> findAllByCategory(@RequestParam("category") String category) {
        return productManager.findAllByCategory(category);
    }

    @PostMapping("/insert")
    public Response insert(@RequestBody ProductDTO product) throws Exception {
        return Response.readOutcome(productManager.insert(product));
    }

    @PostMapping("/update")
    public Response update(@RequestBody ProductDTO product) throws Exception {
        return Response.readOutcome(productManager.update(product));
    }

}
