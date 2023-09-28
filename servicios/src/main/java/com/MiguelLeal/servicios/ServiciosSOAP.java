package com.MiguelLeal.servicios;

import java.util.List;

import com.MiguelLeal.dto.Usuario;

import jakarta.jws.WebParam;


public interface ServiciosSOAP{
    
    
    public List<Usuario> getUsuarios();
     
    
    public void addUsuario(@WebParam Usuario user);

    
}
