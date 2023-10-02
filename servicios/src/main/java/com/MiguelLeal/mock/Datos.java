package com.MiguelLeal.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.MiguelLeal.dto.Universidad;
import com.MiguelLeal.dto.Usuario;
import com.MiguelLeal.dto.Vehiculo;

public class Datos {
    public List<Usuario> usuariosList;
    public HashMap<String, Universidad> universidadesList;
    public HashMap<String, Vehiculo> VehiculosList;

    
    public Datos(List<Usuario> usuariosList, HashMap<String, Universidad> universidadesList,
            HashMap<String, Vehiculo> vehiculosList) {
        this.usuariosList = usuariosList;
        this.universidadesList = universidadesList;
        this.VehiculosList = vehiculosList;
    }

    public Datos() {
        this.usuariosList = new ArrayList<>(Arrays.asList(
                new Usuario("Lavis", "Pa"),
                new Usuario("Elsa", "Patero"),
                new Usuario("Elcan", "Dado")));

        this.universidadesList = new HashMap<>();
        this.universidadesList.put("289.359.248-5", new Universidad("Universidad de los Andes", "289.359.248-5"));
        this.universidadesList.put("665.566.685-6", new Universidad("Universidad de Antioquia", "665.566.685-6"));
        this.universidadesList.put("985.255.856-7", new Universidad("Universidad Nacional", "985.255.856-7"));

        this.VehiculosList = new HashMap<>();
        this.VehiculosList.put("ABC123", new Vehiculo("ABC123", 2010, 100000000));
        this.VehiculosList.put("DEF456", new Vehiculo("DEF456", 2015, 200000000));
        this.VehiculosList.put("GHI789", new Vehiculo("GHI789", 2020, 300000000));
        this.VehiculosList.put("JKL012", new Vehiculo("JKL012", 2021, 400000000));
        this.VehiculosList.put("MNO345", new Vehiculo("MNO345", 2021, 500000000));
        this.VehiculosList.put("PQR678", new Vehiculo("PQR678", 2021, 600000000));

        // this.universidadesList = new ArrayList<>(Arrays.asList(
        //         new Universidad("Universidad de los Andes", "289.359.248-5"),
        //         new Universidad("Universidad de Antioquia", "665.566.685-6"),
        //         new Universidad("Universidad Nacional", "985.255.856-7")));
    }
    public void consultarVehiculo(String placa) {
        this.VehiculosList.get(placa);
    }
    
    public void adicionarVehiculo(String placa, int modelo, long precio) {
        this.adicionarVehiculo(new Vehiculo(placa, modelo, precio));
    }

    public void adicionarVehiculo(Vehiculo vehiculo) {
        this.VehiculosList.put(vehiculo.getPlaca(), vehiculo);
    }
    
    public void adicionarUniversidad(String nombre, String nit) {
        this.adicionarUniversidad(new Universidad(nombre, nit));
    }
    
    public void adicionarUniversidad(Universidad universidad) {
        this.universidadesList.put(universidad.getNit(), universidad);
    }

    public void adicionarUsuario(String nombre, String apellido) {
        this.adicionarUsuario( new Usuario(nombre, apellido));
    }
    public void adicionarUsuario(Usuario usuario) {
        this.usuariosList.add( usuario);
    }
}
