package com.example.springapp.repo;

import com.example.springapp.entity.FiboData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FiboDataRepo extends JpaRepository<FiboData, Integer> {

}
