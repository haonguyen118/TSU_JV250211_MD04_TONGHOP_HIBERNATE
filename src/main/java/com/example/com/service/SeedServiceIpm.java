package com.example.com.service;

import com.example.com.model.Seed;
import com.example.com.repository.SeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SeedServiceIpm implements SeedService{

    @Autowired
    private SeedRepository seedRepository;

    @Override
    public List<Seed> findAllAndSearch(int page, int size, String search) {
        return seedRepository.findAllAndSearch( page,size,search );
    }

    @Override
    @Transactional
    public boolean addSeed(Seed seed) {
       return seedRepository.save(seed);
    }

    @Override
    @Transactional
    public boolean updateSeed(Seed seed) {
       return seedRepository.update(seed);
    }

    @Override
    @Transactional
    public boolean deleteSeed(Long id) {
        return seedRepository.deleteById(id);
    }

    @Override
    public Seed findSeedById(Long id) {
        return seedRepository.findById(id);
    }

    @Override
    public boolean checkExistSeedName(String searchName) {
        return seedRepository.checkExistSeedName(searchName);
    }

    @Override
    public Long countAllSeed(String searchName) {
        return seedRepository.countAllSeeds(searchName);
    }
}
