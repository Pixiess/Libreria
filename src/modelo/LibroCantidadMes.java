/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Juan Pablo
 */
public class LibroCantidadMes {
    private int idLibro;
    private String titulo;
    private String edicion;
    //Cantidad de libros vendidos durante un mes determinado
    private int cant_enero;
    private int cant_febrero;
    private int cant_marzo;
    private int cant_abril;
    private int cant_mayo;
    private int cant_junio;
    private int cant_julio;
    private int cant_agosto;
    private int cant_septiembre;
    private int cant_octubre;
    private int cant_noviembre;
    private int cant_diciembre;
    
    public LibroCantidadMes(){
    
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
    
    public int getCant_enero(){
        return cant_enero;
    }
    
    public int getCant_febrero(){
        return cant_febrero;
    }
    
    public int getCant_marzo(){
        return cant_marzo;
    }
    
    public int getCant_abril(){
        return cant_abril;
    }
    
    public int getCant_mayo(){
        return cant_mayo;
    }
    
    public int getCant_junio(){
        return cant_junio;
    }
    
    public int getCant_julio(){
        return cant_julio;
    }
    
    public int getCant_agosto(){
        return cant_agosto;
    }
    
    public int getCant_septiembre(){
        return cant_septiembre;
    }
    
    public int getCant_octubre(){
        return cant_octubre;
    }
    
    public int getCant_noviembre(){
        return cant_noviembre;
    }
    
    public int getCant_diciembre(){
        return cant_diciembre;
    }
    
    public void setCant_enero(int cant_enero){
        this.cant_enero=cant_enero;
    }
    
    public void setCant_febrero(int cant_febrero){
        this.cant_febrero=cant_febrero;
    }
    
    public void setCant_marzo(int cant_marzo){
        this.cant_marzo=cant_marzo;
    }
    
    public void setCant_abril(int cant_abril){
        this.cant_abril=cant_abril;
    }
    
    public void setCant_mayo(int cant_mayo){
        this.cant_mayo=cant_mayo;
    }
    
    public void setCant_junio(int cant_junio){
        this.cant_junio=cant_junio;
    }
    
    public void setCant_julio(int cant_julio){
        this.cant_julio=cant_julio;
    }
    
    public void setCant_agosto(int cant_agosto){
        this.cant_agosto=cant_agosto;
    }
    
    public void setCant_septiembre(int cant_septiembre){
        this.cant_septiembre=cant_septiembre;
    }
    
    public void setCant_octubre(int cant_octubre){
        this.cant_octubre=cant_octubre;
    }
    
    public void setCant_noviembre(int cant_noviembre){
        this.cant_noviembre=cant_noviembre;
    }
    
    public void setCant_diciembre(int cant_diciembre){
        this.cant_diciembre=cant_diciembre;
    }
}
