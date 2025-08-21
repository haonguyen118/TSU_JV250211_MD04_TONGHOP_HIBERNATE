package com.example.com.repository;

import com.example.com.model.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CategoryRepositoryIpm implements CategoryRepository {
    //tiêm bean EntityManager
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Category> findAll() {
        return entityManager.createQuery("from Category", Category.class).getResultList();
    }

    @Override
    public Category findById(Long categoryId) {
        return entityManager.createQuery("from Category where id = :category_id", Category.class)
                .setParameter("category_id", categoryId).getSingleResult();
    }

    @Override
    @Transactional
    public boolean save(Category category) {
        try {
            entityManager.persist(category);
            return true;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }

    @Override
    @Transactional
    public boolean update(Category category) {
        try {
            entityManager.merge(category);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
       try{
           entityManager.remove(findById(id));
           return true;
       }catch (Exception e) {
           e.printStackTrace();
           return false;
       }
    }

    @Override
    public boolean checkExistCategoryName(String categoryName) {
        Long count = entityManager.createQuery("select count(id) from  Category c where catalogName = :categoryName", Long.class)
                .setParameter("categoryName", categoryName).getSingleResult();
        if (count > 0) {
            return true;
        }else {
            return false;
        }
    }
}
