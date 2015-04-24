/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Veymar Montaño Colqu
 */
public class Libro {
    private int idLibro;
    private String nombreLibro;
    private String autorLibro;
    private String genero;
    private int stockDisponible;
    private double costoCompra;
    private double costoVenta;
    private int stockMinimo;
    private String direccionImagen;
    private double costoParcial;

    public Libro()
    {
        
    }
    
    public Libro(int id, String n, String a, String g, int stock, double cc, double cv)
    {
        idLibro = id;
        nombreLibro = n;
        autorLibro = a;
        genero = g;
        stockDisponible = stock;
        costoCompra = cc;
        costoVenta = cv;
        costoParcial = 0;
    
    }
    
    /**
     * @return the idLibro
     */
    public int getIdLibro() {
        return idLibro;
    }

    /**
     * @param idLibro the idMuestra to set
     */
    public void setIdLibro(int idMuestra) {
        this.idLibro = idMuestra;
    }

    /**
     * @return the nombreLibro
     */
    public String getNombreLibro() {
        return nombreLibro;
    }

    /**
     * @param nombreLibro the nombreLibro to set
     */
    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    /**
     * @return the autorLibro
     */
    public String getAutorLibro() {
        return autorLibro;
    }

    /**
     * @param autorLibro the autorLibro to set
     */
    public void setAutorLibro(String autorLibro) {
        this.autorLibro = autorLibro;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the stockDisponible
     */
    public int getStockDisponible() {
        return stockDisponible;
    }

    /**
     * @param stockDisponible the stockDisponible to set
     */
    public void setStockDisponible(int stockDisponible) {
        this.stockDisponible = stockDisponible;
    }

    /**
     * @return the costoCompra
     */
    public double getCostoCompra() {
        return costoCompra;
    }

    /**
     * @param costoCompra the costoCompra to set
     */
    public void setCostoCompra(double costoCompra) {
        this.costoCompra = costoCompra;
    }

    /**
     * @return the costoVenta
     */
    public double getCostoVenta() {
        return costoVenta;
    }

    /**
     * @param costoVenta the costoVenta to set
     */
    public void setCostoVenta(double costoVenta) {
        this.costoVenta = costoVenta;
    }

    /**
     * @return the stockMinimo
     */
    public int getStockMinimo() {
        return stockMinimo;
    }

    /**
     * @param stockMinimo the stockMinimo to set
     */
    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    /**
     * @return the direccionImagen
     */
    public String getDireccionImagen() {
        return direccionImagen;
    }

    /**
     * @param direccionImagen the direccionImagen to set
     */
    public void setDireccionImagen(String direccionImagen) {
        this.direccionImagen = direccionImagen;
    }
    
    public void setCostoParcial(double parcial){
        costoParcial = parcial;
    }
    
    public double getCostoParcial(){
        return costoParcial;
    }
    
}
