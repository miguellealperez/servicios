package com.MiguelLeal.Entity;

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
    private String placa;

    private int modelo;
    private long precio;
}
