package com.MiguelLeal.servicios;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MiguelLeal.Entity.VehiculoEntity;
import com.MiguelLeal.Service.VehiculoService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(serviceName = "usuarios")
@Service
public class SOAPImplementacion {
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