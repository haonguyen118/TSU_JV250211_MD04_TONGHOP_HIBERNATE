package com.example.com.repository;

import com.example.com.model.Seed;

import java.util.List;

public interface SeedRepository {
    List<Seed> findAllAndSearch(int page, int size, String search);

    boolean save(Seed seed);

    boolean update(Seed seed);

    boolean deleteById(Long id);

    boolean checkExistSeedName(String seedName);

    Long countAllSeeds(String seedName);

    Seed findById(Long id);


}
