package com.MiguelLeal.dto;

import java.io.Serializable;

public class Usuario implements Serializable{
    private String nombre;
    private String apellidos;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public Usuario() {
        super();
    }
    public Usuario(String nombre, String apellido) {
        super();
        this.nombre = nombre;
        this.apellidos = apellido;
    }
    
}
