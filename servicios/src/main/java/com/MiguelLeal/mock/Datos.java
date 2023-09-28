package com.MiguelLeal.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.MiguelLeal.dto.Universidad;
import com.MiguelLeal.dto.Usuario;

public class Datos {
    public List<Usuario> usuariosList;
    public HashMap<String, Universidad> universidadesList;


    public Datos(List<Usuario> usuariosList, HashMap<String, Universidad>universidadesList) {
        this.usuariosList = usuariosList;
        this.universidadesList = universidadesList;
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


        // this.universidadesList = new ArrayList<>(Arrays.asList(
        //         new Universidad("Universidad de los Andes", "289.359.248-5"),
        //         new Universidad("Universidad de Antioquia", "665.566.685-6"),
        //         new Universidad("Universidad Nacional", "985.255.856-7")));
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
