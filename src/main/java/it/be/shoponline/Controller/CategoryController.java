package it.be.shoponline.Controller;

import it.be.shoponline.DTO.CategoryDTO;
import it.be.shoponline.Manager.Interface.CategoryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    @Autowired
    private CategoryManager categoryManager;

    @GetMapping("/findAll")
    public Stream<CategoryDTO> findAll() {
        return categoryManager.findAll();
    }

    @PostMapping("/insert")
    public void insert(@RequestBody CategoryDTO category) {
        categoryManager.insert(category);
    }

    @PostMapping("/update")
    public void update(@RequestBody CategoryDTO category) {
        categoryManager.update(category);
    }

}
