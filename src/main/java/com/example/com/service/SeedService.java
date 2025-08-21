package com.example.com.service;

import com.example.com.model.Seed;

import java.util.List;

public interface SeedService {
    public List<Seed> findAllAndSearch(int page, int size, String search);

    public boolean addSeed(Seed seed);

    public boolean updateSeed(Seed seed);

    public boolean deleteSeed(Long id);

    public Seed findSeedById(Long id);

    public boolean checkExistSeedName(String search);

    public Long countAllSeed(String search);
}
