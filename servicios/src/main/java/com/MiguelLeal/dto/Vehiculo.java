package com.MiguelLeal.dto;

import java.io.Serializable;

public class Vehiculo implements Serializable {
    private String placa;
    private int modelo;
    private long precio;

    public Vehiculo(String placa, int modelo, long precio) {
        this.placa = placa;
        this.modelo = modelo;
        this.precio = precio;
    }

    public Vehiculo() {
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public Long calcularImpuesto() {
        return (long) (this.precio * 0.1);
    }

    public Long calcularDescuento() {
        return (long) (this.precio * 0.05);
    }

    public Long calcularTotal() {
        return this.precio + this.calcularImpuesto() - this.calcularDescuento();
    }

    
    
}
