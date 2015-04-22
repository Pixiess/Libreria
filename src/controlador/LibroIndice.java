/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author pcs
 */
public class LibroIndice {
   private ArrayList<Integer> indicesL;
   private String [] libros;
   private int idV;
   
   public LibroIndice(String [] libros, int idV){
       indicesL= new ArrayList<>();
       this.libros = libros;
       this.idV = idV;
       
   }
   
   public void insertarEnBD(){
       buscarIndice();
   }
   
   private void buscarIndice(){
       int i=0;
       while(i<libros.length){
           String name=libros[i];
       String sql = "SELECT id_libro FROM libro WHERE nombre_libro='" + name+ "'" ;
        
        try {
            ResultSet rs = ConexionPostgresql.consultar(sql);
            while (rs.next()) {
                indicesL.add(Integer.parseInt(rs.getString("id_libro")));
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        i++;
       }
       
       insertarEnDetalle();
   }
   
   private void insertarEnDetalle(){
       for(int i=0; i<indicesL.size(); i++){
       try {
           String sql = "INSERT INTO detalle_venta (id_venta, id_libro) VALUES ("+idV+ ", " + indicesL.get(i) + ")";
            boolean rs = ConexionPostgresql.updateDB(sql);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
       } 
   }
   

    /**
     * @return the indicesL
     */
    public ArrayList<Integer> getIndicesL() {
        return indicesL;
    }

    /**
     * @param indicesL the indicesL to set
     */
    public void setIndicesL(ArrayList<Integer> indicesL) {
        this.indicesL = indicesL;
    }
    
}
