package com.eternity.springboot.service;

import com.eternity.springboot.model.Laptop;
import com.eternity.springboot.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepository repo;

    public void addLaptop(Laptop lap)
    {
        repo.save(lap);
    }
}
