package com.example.com.repository;

import com.example.com.model.Seed;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class SeedRepositoryIpm implements SeedRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Seed> findAllAndSearch(int page, int size, String search) {
        int offset = (page > 0) ? (page - 1) * size : 0;
        if (search != null && !search.isEmpty()) {
            return entityManager.createQuery("from Seed s where s.seedName like :search", Seed.class)
                    .setParameter("search","%"+ search+"%")
                    .setFirstResult(offset)
                    .setMaxResults(size)
                    .getResultList();
        }else {
            return entityManager.createQuery("from Seed s",Seed.class)
                    .setFirstResult(offset)
                    .setMaxResults(size)
                    .getResultList();
        }
    }

    @Override
    @Transactional
    public boolean save(Seed seed) {
        try {
            entityManager.persist(seed);
            return true;
        }catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }

    @Override

    public boolean update(Seed seed) {
        try {
            entityManager.merge(seed);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override

    public boolean deleteById(Long id) {
        try {
            entityManager.remove(findById(id));
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkExistSeedName(String seedName) {
        Long count = entityManager.createQuery("select count(id) from  Seed where seedName = :seedName", Long.class)
                .setParameter("seedName",seedName).getSingleResult();
        if (count > 0) {
            return true;
        }else {
            return false;
        }
    }



    @Override
    public Long countAllSeeds(String search) {
        if (search != null && !search.isEmpty()) {
            return entityManager.createQuery("select count(id) from Seed s where s.seedName like :search", Long.class)
                    .setParameter("search", "%" + search + "%").getSingleResult();
        } else {
            return entityManager.createQuery("select count(id) from Seed", Long.class).getSingleResult();
        }
    }

    @Override
    public Seed findById(Long id) {
        return entityManager.createQuery("from Seed where id=:id", Seed.class)
                .setParameter("id", id).getSingleResult();
    }
}
