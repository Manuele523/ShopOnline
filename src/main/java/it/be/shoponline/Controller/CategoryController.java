package it.be.shoponline.Controller;

import it.be.shoponline.Controller.OutcomeType.Response;
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
    public Response insert(@RequestBody CategoryDTO category) {
        return Response.readOutcome(categoryManager.insert(category));
    }

    @PutMapping("/update")
    public Response update(@RequestBody CategoryDTO category) {
        return Response.readOutcome(categoryManager.update(category));
    }

    @DeleteMapping("/delete")
    public Response delete(@RequestParam("id") Long idCategory) throws Exception {
        return Response.readOutcome(categoryManager.delete(idCategory));
    }

}
