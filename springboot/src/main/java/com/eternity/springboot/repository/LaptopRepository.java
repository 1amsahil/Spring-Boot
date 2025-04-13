package com.eternity.springboot.repository;

import com.eternity.springboot.model.Laptop;
import org.springframework.stereotype.Repository;

@Repository
public class LaptopRepository {

    public void save(Laptop lap)
    {
        System.out.println("Laptop Added");
    }
}
