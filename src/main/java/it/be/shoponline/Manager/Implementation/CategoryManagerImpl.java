package it.be.shoponline.Manager.Implementation;

import it.be.shoponline.DTO.CategoryDTO;
import it.be.shoponline.Enum.StatusCode;
import it.be.shoponline.Manager.Interface.CategoryManager;
import it.be.shoponline.Mapper.CategoryMapper;
import it.be.shoponline.Service.Interface.CategoryService;
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
    public StatusCode insert(CategoryDTO category) {
        if (categoryService.insert(CategoryMapper.mapToEntity(category)) != null) {
            return StatusCode.OK_INSERT;
        } else {
            return StatusCode.KO_INSERT;
        }
    }

    @Override
    public StatusCode update(CategoryDTO category) {
        if (categoryService.insert(CategoryMapper.mapToEntity(category)) != null) {
            return StatusCode.OK_UPDATE;
        } else {
            return StatusCode.KO_UPDATE;
        }
    }

    @Override
    public StatusCode delete(Long idCategory) {
        if (categoryService.delete(idCategory)) {
            return StatusCode.OK_DELETE;
        } else {
            return StatusCode.KO_DELETE;
        }
    }

}
