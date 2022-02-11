package it.be.shoponline.Service.Implementation;

import it.be.shoponline.Entity.CategoryEntity;
import it.be.shoponline.Entity.ProductEntity;
import it.be.shoponline.Enum.TypeCategory;
import it.be.shoponline.Repository.CategoryRepository;
import it.be.shoponline.Repository.ProductRepository;
import it.be.shoponline.Service.Interface.CategoryService;
import it.be.shoponline.Service.Interface.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CategoryRepository categoryRepository;

    private CriteriaBuilder criteriaBuilder;
    private CriteriaQuery<CategoryEntity> criteriaQuery;
    private Root<CategoryEntity> root;

    private void setupCriteriaBuilderSelect() {
        try {
            criteriaBuilder = entityManager.getCriteriaBuilder();

            criteriaQuery = criteriaBuilder.createQuery(CategoryEntity.class);
            root = criteriaQuery.from(CategoryEntity.class);
            criteriaQuery.select(root);
        } catch (Exception e) {
            System.out.println("Error in ProductManagerImpl.setupCriteriaBuilder!");
        }
    }

    @Override
    public List<CategoryEntity> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional
    public CategoryEntity insert(CategoryEntity entity) {
        try {
            return categoryRepository.save(entity);
        } catch (Exception e) {
            System.out.println("Error during insert of new Category!");
        }
        return null;
    }

    @Override
    public Boolean delete(Long idCategory) {
        try {
            categoryRepository.deleteById(idCategory);
            return true;
        } catch (Exception e) {
            System.out.println("Error during delete of Category!");
        }
        return null;
    }

}
