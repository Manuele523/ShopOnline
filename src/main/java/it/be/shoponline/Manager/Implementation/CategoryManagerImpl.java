package it.be.shoponline.Manager.Implementation;

import it.be.shoponline.DTO.CategoryDTO;
import it.be.shoponline.DTO.ProductDTO;
import it.be.shoponline.Manager.Interface.CategoryManager;
import it.be.shoponline.Manager.Interface.ProductManager;
import it.be.shoponline.Mapper.CategoryMapper;
import it.be.shoponline.Mapper.ProductMapper;
import it.be.shoponline.Service.Interface.CategoryService;
import it.be.shoponline.Service.Interface.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class CategoryManagerImpl implements CategoryManager {

    @Autowired
    private CategoryService categoryService;

    @Override
    public Stream<CategoryDTO> findAll() {
        return categoryService.findAll().stream().map(CategoryMapper::mapToDTO);
    }

    @Override
    public void insert(CategoryDTO category) {
        categoryService.insert(CategoryMapper.mapToEntity(category));
    }

    @Override
    public void update(CategoryDTO category) {
        categoryService.update(CategoryMapper.mapToEntity(category));
    }

}
