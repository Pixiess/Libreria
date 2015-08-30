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
public class Venta {

    private int idVenta;
    private String ci;
    private int idLibreria;
    private String fecha;
    private double total;
    //agregado para la tabla de reportes
    private int idLibro;
    private String nombreLibro;
    private String edicionLibro;
    private int cantidad;
    private double costoParcial;

    /**
     * @return the idVenta
     */
    public int getIdVenta() {
        return idVenta;
    }

    /**
     * @param idVenta the idVenta to set
     */
    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    /**
     * @return the ci
     */
    public String getCi() {
        return ci;
    }

    /**
     * @param ci the ci to set
     */
    public void setCi(String ci) {
        this.ci = ci;
    }

    /**
     * @return the idLibreria
     */
    public int getIdLibreria() {
        return idLibreria;
    }

    /**
     * @param idLibreria the idLibreria to set
     */
    public void setIdLibreria(int idLibreria) {
        this.idLibreria = idLibreria;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }
    
    public int getIdLibro(){
        return idLibro;
    }
    
    public void setIdLibro(int idLibro){
        this.idLibro = idLibro;
    }
    
    public String getNombreLibro(){
        return nombreLibro;
    }
    
    public void setNombreLibro(String nombreLibro){
        this.nombreLibro = nombreLibro;
    }
    
    public String getEdicionLibro(){
        return edicionLibro;
    }
    
    public void setEdicionLibro(String edicionLibro){
        this.edicionLibro = edicionLibro;
    }
    
    public int getCantidad(){
        return cantidad;
    }
    
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    
    public double getCostoParcial(){
        return costoParcial;
    }
    
    public void setCostoParcial(double costoParcial){
        this.costoParcial = costoParcial;
    }

}
