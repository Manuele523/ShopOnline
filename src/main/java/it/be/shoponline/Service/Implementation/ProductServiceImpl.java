package it.be.shoponline.Service.Implementation;

import it.be.shoponline.Entity.ProductEntity;
import it.be.shoponline.Enum.TypeCategory;
import it.be.shoponline.Repository.ProductRepository;
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
public class ProductServiceImpl implements ProductService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    private CriteriaBuilder criteriaBuilder;
    private CriteriaQuery<ProductEntity> criteriaQuery;
    private Root<ProductEntity> root;

    private void setupCriteriaBuilderSelect() {
        try {
            criteriaBuilder = entityManager.getCriteriaBuilder();

            criteriaQuery = criteriaBuilder.createQuery(ProductEntity.class);
            root = criteriaQuery.from(ProductEntity.class);
            criteriaQuery.select(root);
        } catch (Exception e) {
            System.out.println("Error in ProductManagerImpl.setupCriteriaBuilder!");
        }
    }

    @Override
    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<ProductEntity> findAllByCategory(String category) {
        setupCriteriaBuilderSelect();
        criteriaQuery.where(criteriaBuilder.like(root.get("category").get("name"), "%" + TypeCategory.getEnumByName(category) + "%"));

        TypedQuery<ProductEntity> query = entityManager.createQuery(criteriaQuery);
        try {
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Error in ProductManagerImpl.findAllProductByCategory!");
        }
        return null;
    }

    @Override
    @Transactional
    public void insert(ProductEntity entity) {
        productRepository.save(entity);
    }

    @Override
    public void update(ProductEntity entity) {
        productRepository.save(entity);
    }

}
