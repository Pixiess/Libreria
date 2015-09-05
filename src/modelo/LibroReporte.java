/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author lourdes
 */
public class LibroReporte {
    private int idLibro;
    private String titulo;
    private String edicion;
    private int cantidad;
    private double costo;
    
    public LibroReporte(){
        
    }

    public LibroReporte(int idLibro, String titulo, String edicion, int cantidad, double costo) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.edicion = edicion;
        this.cantidad = cantidad;
        this.costo = costo;
    }
    
    public int getIdLibro(){
        return idLibro;
    }
    
    public void setIdLibro(int idLibro){
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    
       
}
