package com.MiguelLeal.servicios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.MiguelLeal.dto.Banco;
import com.MiguelLeal.dto.DatosEntrada;
import com.MiguelLeal.dto.DatosSalida;
import com.MiguelLeal.dto.Universidad;
import com.MiguelLeal.dto.UniversidadesWrapper;
import com.MiguelLeal.dto.Usuario;
import com.MiguelLeal.mock.Datos;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(serviceName = "usuarios")
public class SOAPImplementacion {
    private Datos datos = new Datos();

    @WebMethod(operationName = "obtener")
    public List<Usuario> getUsuarios() {

        return datos.usuariosList;
    }

    @WebMethod(operationName = "adicionar")
    public void addUsuario(@WebParam Usuario usuario) {
        datos.adicionarUsuario(usuario);
    }

    @WebMethod(operationName = "obtenerUniversidades")
    public UniversidadesWrapper getUniversidades() {
        UniversidadesWrapper wrapper = new UniversidadesWrapper();
        for (Map.Entry<String, Universidad> entry : datos.universidadesList.entrySet()) {
            UniversidadesWrapper.UniversidadEntry uniEntry = new UniversidadesWrapper.UniversidadEntry();
            uniEntry.setKey(entry.getKey());
            uniEntry.setValue(entry.getValue());
            wrapper.getEntries().add(uniEntry);
        }
        return wrapper;
    }

    @WebMethod(operationName = "adicionarUniversidad")
    public void addUniversidad(@WebParam Universidad universidad) {
        datos.adicionarUniversidad(universidad);
    }

    @WebMethod(operationName = "consultaUniversidad")
    public Universidad consulta(@WebParam String nit) {
        return new Universidad("nit", "nit");
    }

    @WebMethod(operationName = "dataIn")
    public DatosEntrada DataIn(@WebParam String cedula) {
        return new DatosEntrada(123, "28/9/23");
    }

    @WebMethod(operationName = "consultaSaldo")
    public DatosSalida DataOut(@WebParam DatosEntrada datos) {
        // System.out.println(datos.getCedula());
        return new DatosSalida(23, 123, new Banco(123, "Miguel"));
    }

}