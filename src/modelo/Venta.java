/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.ArrayList;

/**
 *
 * @author A
 */

public class Venta {

    private ArrayList<Libro>libros;
    
    public void anadirLibro(Libro l)
    {
        libros.add(l);
    }
    
    public void eliminarLibro(Libro l)
    {
        libros.remove(l);
    }
    
    
}
