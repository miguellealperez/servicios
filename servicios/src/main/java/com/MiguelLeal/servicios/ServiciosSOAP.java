package com.MiguelLeal.servicios;

import java.util.List;

import com.MiguelLeal.dto.Usuario;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;


public interface ServiciosSOAP{
    
    
    public List<Usuario> getUsuarios();
     
    
    public void addUsuario(@WebParam Usuario user);

    
}
