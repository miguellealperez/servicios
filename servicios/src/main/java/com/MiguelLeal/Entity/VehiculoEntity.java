package com.MiguelLeal.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
// Clase que representa la tabla vehiculo en la base de datos
@Table(name = "vehiculo")
public class VehiculoEntity {
    // Atributos de la clase
    @Id
    @Column(name = "vehi_placa")
    private String placa;
    @Column(name = "vehi_modelo")
    private int modelo;
    @Column(name = "vehi_marca")
    private String marca;
    @Column(name = "vehi_precio")
    private long precio;
}
