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

    public String saveVehiculo(VehiculoEntity vehiculo) {
        if (vehiculoRepo.findById(vehiculo.getPlaca()).orElse(null) != null) {
            return "Vehiculo ya existe";
        }else if(vehiculo.getPlaca().length() != 6){
            return "Placa debe tener 6 caracteres";
        }else if(vehiculo.getModelo() < 1950 || vehiculo.getModelo() > 2022){
            return "Modelo debe estar entre 1950 y 2022";
        }else if(vehiculo.getPrecio() < 0){
            return "Precio debe ser mayor a 0";
        }
        vehiculoRepo.save(vehiculo);
        return "Vehiculo guardado: " + vehiculo.getPlaca();
    }

    public String deleteVehiculo(String placa) {
        vehiculoRepo.deleteById(placa);
        return "Vehiculo eliminado: " + placa;
    }

    public VehiculoEntity updateVehiculo(VehiculoEntity vehiculo) {
        VehiculoEntity existingVehiculo = vehiculoRepo.findById(vehiculo.getPlaca()).orElse(null);
        if (existingVehiculo == null) {
            return null;
        }
        existingVehiculo.setModelo(vehiculo.getModelo());
        existingVehiculo.setMarca(vehiculo.getMarca());
        existingVehiculo.setPrecio(vehiculo.getPrecio());
        return vehiculoRepo.save(existingVehiculo);
    }

    public Long calcImpuestoVehiculo(Long valorVehiCulo) {
        return (long) (valorVehiCulo * 0.2);
    }

    public Long calcImpuestoGobiernoVehiculo(Long valorVehiCulo) {
        return (long) (valorVehiCulo * 0.1);
    }

    public String calcSeguroVehiculo(String placa) {
        VehiculoEntity vehiculo = vehiculoRepo.findById(placa).orElse(null);
        if (vehiculo == null) {
            return "Vehiculo no encontrado";
        }
        if (vehiculo.getModelo() < 2010) {
            return calcImpuestoVehiculo(vehiculo.getPrecio() * 5 / 100).toString();
        }else if (vehiculo.getModelo() < 2015) {
            return calcImpuestoVehiculo(vehiculo.getPrecio() * 7 / 100).toString();
        }else if (vehiculo.getModelo() < 2020) {
            return calcImpuestoVehiculo(vehiculo.getPrecio() * 9 / 100).toString();
        }else if (vehiculo.getModelo() > 2021) {
            return calcImpuestoVehiculo(vehiculo.getPrecio() * 11 / 100).toString();
        }
        return calcImpuestoVehiculo(vehiculo.getPrecio()).toString();
    }

}
