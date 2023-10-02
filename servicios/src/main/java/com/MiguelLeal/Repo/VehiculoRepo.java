package com.MiguelLeal.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MiguelLeal.Entity.VehiculoEntity;

@Repository
public interface VehiculoRepo extends JpaRepository<VehiculoEntity, String> {
    
}
