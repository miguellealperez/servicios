package com.MiguelLeal.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MiguelLeal.Entity.VehiculoEntity;
import com.MiguelLeal.Repo.VehiculoRepo;

@Service
public class VehiculoService {
    @Autowired
    private VehiculoRepo vehiculoRepo;

    public VehiculoRepo getVehiculoRepo() {
        return vehiculoRepo;
    }

    public void setVehiculoRepo(VehiculoRepo vehiculoRepo) {
        this.vehiculoRepo = vehiculoRepo;
    }

    public List<VehiculoEntity> getVehiculos() {
        return vehiculoRepo.findAll();
    }

    public VehiculoEntity getVehiculo(String placa) {
        return vehiculoRepo.findById(placa).orElse(null);
    }

    public VehiculoEntity saveVehiculo(VehiculoEntity vehiculo) {
        return vehiculoRepo.save(vehiculo);
    }

    public String deleteVehiculo(String placa) {
        vehiculoRepo.deleteById(placa);
        return "Vehiculo eliminado: " + placa;
    }

    public VehiculoEntity updateVehiculo(VehiculoEntity vehiculo) {
        VehiculoEntity existingVehiculo = vehiculoRepo.findById(vehiculo.getPlaca()).orElse(null);
        existingVehiculo.setModelo(vehiculo.getModelo());
        existingVehiculo.setPrecio(vehiculo.getPrecio());
        return vehiculoRepo.save(existingVehiculo);
    }
}
