/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Libro;

/**
 *
 * @author lourdes
 */
public class LibroBD {
    //REstringir cantidad y mìnimo, precio de copra yventa no puede ser 0
     private String titulo;
     private String autor;
     private String genero;
     private String edicion;
     private int cantidad;
     private int minimo;
     private double prCompra;
     private double prVenta;
     private ArrayList<Integer> indices;
    
    public LibroBD(Libro libro) {
        this.titulo = libro.getNombreLibro();
        this.autor = libro.getAutorLibro();
        this.genero = libro.getGenero();
        this.edicion = libro.getEdicion();
        this.cantidad = 1;
        this.minimo = libro.getStockMinimo();
        this.prCompra = libro.getCostoCompra();
        this.prVenta = libro.getCostoVenta();
        indices = new ArrayList<>();
        
    }
    
    public LibroBD(String titulo, String autor, String genero, String edicion, 
            int cantidad, int minimo, double prCompra, double prVenta) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.edicion = edicion;
        this.cantidad = cantidad;
        this.minimo = minimo;
        this.prCompra = prCompra;
        this.prVenta = prVenta;
        indices = new ArrayList<>();
        
    }
    
    public void insertarLibroNuevo(){
        
        int idLibroBuscado = consultarIdLibro();
        
        if(idLibroBuscado == -1){
            int idLibro = buscarIdDisponible();
        
            String sql="INSERT INTO libro (id_libro, nombre_libro, autor_libro, genero, edicion, "
                + "cantidad, costo_compra, costo_venta, cantidad_minima, estado) "
                + "VALUES ("+idLibro+", '"+titulo+"', '"+autor+"', '"+genero+"', '"+edicion+
                "', "+cantidad+", "+prCompra+", "+prVenta+","+minimo+", "+"1)";
            ConexionPostgresql.updateDB(sql);
        }else{
            insertarLibroExistente(idLibroBuscado);
        }
    }
    
    public void insertarLibroExistente(int id){
        //ver si edicion es nueva en caso de cambiar, poner commo insertarLibroNuevo
        boolean res= edicionDiferente(id);
         if(res==true){
             insertarLibroNuevo();
         }else{
             String sql = "UPDATE libro SET cantidad=cantidad + "+cantidad +
                     ", costo_compra="+prCompra+", costo_venta="+prVenta+
                     ", cantidad_minima="+minimo+" WHERE id_libro='" + id+ "'" ;
            ConexionPostgresql.updateDB(sql);
         }
        
    }
    
    public void actualizarLibroExistente(int id){
        String sql = "UPDATE libro SET nombre_libro='" + titulo 
                + "', autor_libro='" + autor 
                + "', genero='" + genero 
                + "',costo_venta='" + prVenta 
                + "', cantidad_minima='" + minimo
                + "' WHERE id_libro='" + id + "'";
        ConexionPostgresql.updateDB(sql);
    }
    
    private int consultarIdLibro(){
        int res = -1;
        String sql = "SELECT id_libro FROM libro "
                + "WHERE nombre_libro='" + titulo + "' and autor_libro='"+autor+"' "
                + "and genero='"+genero+"' and edicion='"+edicion+"'" ;
        try {
            ResultSet rs = ConexionPostgresql.consultar(sql);
            while (rs.next()) {
                res = Integer.parseInt(rs.getString("id_libro"));
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        
        return res;
    }
    
    private int buscarIdDisponible(){
        int res = 0;
        
        String sql = "SELECT max(id_libro)+1 as id FROM libro" ;
        
        try {
            ResultSet rs = ConexionPostgresql.consultar(sql);
            while (rs.next()) {
                res = Integer.parseInt(rs.getString("id"));
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        
        return res;
    }
    
    private boolean edicionDiferente(int id){
        boolean res=false;
        //Consultar edicion según id
        String sql = "SELECT edicion FROM libro WHERE id_libro='" + id+ "'" ;
            String edicionBD ="";
            try {
                ResultSet rs = ConexionPostgresql.consultar(sql);
                while (rs.next()) {
                edicionBD= rs.getString("edicion");   
                }
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            
            if(!edicionBD.equals(edicion)){
                res=true;
            }
        
        return res;
    }
        
}
