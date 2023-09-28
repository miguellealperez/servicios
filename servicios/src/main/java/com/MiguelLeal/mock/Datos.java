package com.MiguelLeal.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.MiguelLeal.dto.Usuario;

public class Datos {
    public List<Usuario> usuariosList;

    public Datos(){
        usuariosList = new ArrayList<>(Arrays.asList(
            new Usuario("Lavis", "Pa"), 
            new Usuario("Elsa", "Patero"), 
            new Usuario("Elcan", "Dado")));
        
    }

    public void adicionarUsuario(String nombre, String apellido) {
        this.adicionarUsuario( new Usuario(nombre, apellido));
    }
    public void adicionarUsuario(Usuario usuario) {
        this.usuariosList.add( usuario);
    }
}
