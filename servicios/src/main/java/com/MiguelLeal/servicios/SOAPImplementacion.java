package com.MiguelLeal.servicios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MiguelLeal.Entity.VehiculoEntity;
import com.MiguelLeal.Service.VehiculoService;
import com.MiguelLeal.dto.Banco;
import com.MiguelLeal.dto.DatosEntrada;
import com.MiguelLeal.dto.DatosSalida;
import com.MiguelLeal.dto.Universidad;
import com.MiguelLeal.dto.UniversidadesWrapper;
import com.MiguelLeal.dto.Usuario;
import com.MiguelLeal.dto.Vehiculo;
import com.MiguelLeal.dto.VehiculosWrapper;
import com.MiguelLeal.mock.Datos;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(serviceName = "usuarios")
@Service
public class SOAPImplementacion {
    private final Datos datos = new Datos();
    private final VehiculoService vehiculoService;
    private final ModelMapper modelMapper;

    @Autowired
    public SOAPImplementacion(VehiculoService vehiculoService, ModelMapper modelMapper) {
        this.vehiculoService = vehiculoService;
        this.modelMapper = modelMapper;
    }


    @WebMethod(operationName = "consultaVehiculoPlaca")
    public VehiculoEntity getVehiculo(@WebParam(name = "DigitePlaca") String placa) {
        return vehiculoService.getVehiculo(placa);
    }

    @WebMethod(operationName = "consultaTodosVehiculosExistentes")
    public List<VehiculoEntity> getVehiculos1() {
        return vehiculoService.getVehiculos();
    }

    @WebMethod(operationName = "adicionarVehiculo")
    public String addVehiCulo1(@WebParam(name = "DigiteDatosVehiculo") VehiculoEntity vehiculo) {
        return vehiculoService.saveVehiculo(vehiculo);
    }

    @WebMethod(operationName = "eliminarVehiculo")
    public String deleteVehiculo(@WebParam(name = "DigitePlaca") String placa) {
        return vehiculoService.deleteVehiculo(placa);
    }

    @WebMethod(operationName = "actualizarVehiculo")
    public String updateVehiculo(@WebParam(name = "DigiteDatosVehiculo") VehiculoEntity vehiculo) {
        return vehiculoService.updateVehiculo(vehiculo);
    }

    // @WebMethod(operationName = "VehiculoDTOaVehiculoEntityList")
    // public List<VehiculoEntity> VehiculoDTOaVehiculoEntityList() {
    //     HashMap<String, Vehiculo> vehiculos = datos.VehiculosList;
    //     List<Vehiculo> vehiculos1 = vehiculos.values().stream().collect(java.util.stream.Collectors.toList());
    //     List<VehiculoEntity> entities = vehiculos1.stream()
    //             .map(vehiculo -> modelMapper.map(vehiculo, VehiculoEntity.class))
    //             .collect(java.util.stream.Collectors.toList());

    //     // Guardar cada VehiculoEntity en la base de datos
    //     entities.forEach(vehiculoService::saveVehiculo);

    //     return entities;
    // }

    // @WebMethod(operationName = "consultarVehiculosDTO")
    // public VehiculosWrapper getVehiculos() {
    //     VehiculosWrapper wrapper = new VehiculosWrapper();
    //     for (Map.Entry<String, Vehiculo> entry : datos.VehiculosList.entrySet()) {
    //         VehiculosWrapper.VehiculoEntry vehEntry = new VehiculosWrapper.VehiculoEntry();
    //         vehEntry.setKey(entry.getKey());
    //         vehEntry.setValue(entry.getValue());
    //         wrapper.getEntries().add(vehEntry);
    //     }
    //     return wrapper;
    // }

    // calcular Seguro con VehiculoDTO utilizando VehiculoEntity
    // @WebMethod(operationName = "calcularSeguroVehiculoPorPlaca")
    // public String calcularImpuesto(@WebParam(name = "DigitePlaca") String placa) {
    //     return vehiculoService.calcSeguroVehiculo(placa);
    // }

    //calcula el impuesto de un vehiculo
    @WebMethod(operationName = "calcularImpuestoVehiculoPorPlaca")
    public long calcularSeguro(@WebParam(name = "DigitePlaca") String placa) {
        return vehiculoService.calcImpuestoGobiernoVehiculo(vehiculoService.getVehiculo(placa).getPrecio());
    }

    //calcular SOAT
    @WebMethod(operationName = "calcularSOATVehiculoPorPlaca")
    public String calcularSOAT(@WebParam(name = "DigitePlaca") String placa) {
        return vehiculoService.calcSeguroObligatorio(placa);
    }

    //calcular seguro todo riesgp
    @WebMethod(operationName = "calcularSeguroTodoRiesgoVehiculoPorPlaca")
    public String calcularSeguroTodoRiesgo(@WebParam(name = "DigitePlaca") String placa) {
        return vehiculoService.calcSeguroObligatorio(placa);
    }
}