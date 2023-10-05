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

    // @WebMethod(operationName = "obtener")
    // public List<Usuario> getUsuarios() {

    //     return datos.usuariosList;
    // }

    // @WebMethod(operationName = "adicionar")
    // public void addUsuario(@WebParam Usuario usuario) {
    //     datos.adicionarUsuario(usuario);
    // }

    // @WebMethod(operationName = "obtenerUniversidades")
    // public UniversidadesWrapper getUniversidades() {
    //     UniversidadesWrapper wrapper = new UniversidadesWrapper();
    //     for (Map.Entry<String, Universidad> entry : datos.universidadesList.entrySet()) {
    //         UniversidadesWrapper.UniversidadEntry uniEntry = new UniversidadesWrapper.UniversidadEntry();
    //         uniEntry.setKey(entry.getKey());
    //         uniEntry.setValue(entry.getValue());
    //         wrapper.getEntries().add(uniEntry);
    //     }
    //     return wrapper;
    // }

    // @WebMethod(operationName = "adicionarUniversidad")
    // public void addUniversidad(@WebParam Universidad universidad) {
    //     datos.adicionarUniversidad(universidad);
    // }

    // @WebMethod(operationName = "consultaUniversidad")
    // public Universidad consulta(@WebParam String nit) {
    //     return new Universidad("nit", "nit");
    // }

    // @WebMethod(operationName = "dataIn")
    // public DatosEntrada DataIn(@WebParam String cedula) {
    //     return new DatosEntrada(123, "28/9/23");
    // }

    // @WebMethod(operationName = "consultaSaldo")
    // public DatosSalida DataOut(@WebParam DatosEntrada datos) {
    //     // System.out.println(datos.getCedula());
    //     return new DatosSalida(23, 123, new Banco(123, "Miguel"));
    // }

    @WebMethod(operationName = "consultaVehiculoPlaca")
    public VehiculoEntity getVehiculo(@WebParam String placa) {
        return vehiculoService.getVehiculo(placa);
    }

    @WebMethod(operationName = "ConsultaTodosVehiculosExistentes")
    public List<VehiculoEntity> getVehiculos1() {
        return vehiculoService.getVehiculos();
    }

    @WebMethod(operationName = "adicionarVehiculo")
    public String addVehiCulo1(@WebParam VehiculoEntity vehiculo) {
        return vehiculoService.saveVehiculo(vehiculo);
    }

    @WebMethod(operationName = "eliminarVehiculo")
    public String deleteVehiculo(@WebParam String placa) {
        return vehiculoService.deleteVehiculo(placa);
    }

    @WebMethod(operationName = "actualizarVehiculo")
    public VehiculoEntity updateVehiculo(@WebParam VehiculoEntity vehiculo) {
        return vehiculoService.updateVehiculo(vehiculo);
    }

    // @WebMethod(operationName = "VehiculoEntityaVehiculoDTO")
    // public Vehiculo VehiculoEntityaVehiculoDTO(@WebParam VehiculoEntity vehiculo) {
    //     return modelMapper.map(vehiculo, Vehiculo.class);
    // }

    // @WebMethod(operationName = "VehiculoDTOaVehiculoEntity")
    // public VehiculoEntity VehiculoDTOaVehiculoEntity(@WebParam Vehiculo vehiculo) {
    //     return modelMapper.map(vehiculo, VehiculoEntity.class);
    // }

    // @WebMethod(operationName = "VehiculoEntityaVehiculoDTOList")
    // public List<Vehiculo> VehiculoEntityaVehiculoDTOList(@WebParam List<VehiculoEntity> vehiculos) {
    //     return vehiculos.stream().map(vehiculo -> modelMapper.map(vehiculo, Vehiculo.class))
    //             .collect(java.util.stream.Collectors.toList());
    // }

    @WebMethod(operationName = "VehiculoDTOaVehiculoEntityList")
    public List<VehiculoEntity> VehiculoDTOaVehiculoEntityList() {
        HashMap<String, Vehiculo> vehiculos = datos.VehiculosList;
        List<Vehiculo> vehiculos1 = vehiculos.values().stream().collect(java.util.stream.Collectors.toList());
        List<VehiculoEntity> entities = vehiculos1.stream()
                .map(vehiculo -> modelMapper.map(vehiculo, VehiculoEntity.class))
                .collect(java.util.stream.Collectors.toList());

        // Guardar cada VehiculoEntity en la base de datos
        entities.forEach(vehiculoService::saveVehiculo);

        return entities;
    }

    @WebMethod(operationName = "consultarVehiculosDTO")
    public VehiculosWrapper getVehiculos() {
        VehiculosWrapper wrapper = new VehiculosWrapper();
        for (Map.Entry<String, Vehiculo> entry : datos.VehiculosList.entrySet()) {
            VehiculosWrapper.VehiculoEntry vehEntry = new VehiculosWrapper.VehiculoEntry();
            vehEntry.setKey(entry.getKey());
            vehEntry.setValue(entry.getValue());
            wrapper.getEntries().add(vehEntry);
        }
        return wrapper;
    }

    // @WebMethod(operationName = "adicionarVehiculo")
    // public void addVehiculo(@WebParam Vehiculo vehiculo) {
    //     datos.adicionarVehiculo(vehiculo);
    // }

    // @WebMethod(operationName = "ConsultaValorSeguroVehiculoExistentePorPlaca")
    // public long consultaValorSeguroVehiculo(@WebParam String placa) {
    // if (datos.VehiculosList.get(placa) == null) {
    //     return "No existe el vehiculo".hashCode();
    // }
    // if (datos.VehiculosList.get(placa).getModelo() < 2010) {
    //     return datos.VehiculosList.get(placa).getPrecio() * 5 / 100;
    // }
    // if (datos.VehiculosList.get(placa).getModelo() < 2015) {
    //     return datos.VehiculosList.get(placa).getPrecio() * 7 / 100;
    // }
    // if (datos.VehiculosList.get(placa).getModelo() < 2020) {
    //     return datos.VehiculosList.get(placa).getPrecio() * 9 / 100;
    // }
    // if (datos.VehiculosList.get(placa).getModelo() > 2021) {
    //     return datos.VehiculosList.get(placa).getPrecio() * 11 / 100;
    // }
    // return datos.VehiculosList.get(placa).getPrecio() * 1 / 100;
    // }

    // calcular Seguro con VehiculoDTO utilizando VehiculoEntity
    @WebMethod(operationName = "calcularSeguroVehiculoPorPlaca")
    public String calcularImpuesto(@WebParam(name = "Placa") String placa) {
        return vehiculoService.calcSeguroVehiculo(placa);
    }
}