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
 * @author USUARIO
 */
public class ListaVentas {
    
    
    //Este metodo es transitorio, es decir, desde aqui debes modificar para agregar libros
    //desde el buscador hasta la ventana del registro de ventas, lo unico que hago yo es llamar
    //a todos los libros registrados para poder trabajar las celdas
    public ArrayList<Libro> getLibrosAgregados(){
        ArrayList<Libro> listaVenta = new ArrayList<Libro>();
        String sql = "SELECT * FROM libro";
        try{
            ResultSet rs = ConexionPostgresql.consultar(sql);
            while(rs.next()){
                Libro porVenderse = new Libro();
                porVenderse.setStockDisponible(Integer.parseInt(rs.getString("cantidad")));
                porVenderse.setStockMinimo(Integer.parseInt(rs.getString("cantidad_minima")));
                
                porVenderse.setNombreLibro(rs.getString("nombre_libro"));
                porVenderse.setAutorLibro(rs.getString("autor_libro"));
                porVenderse.setCostoVenta(Double.parseDouble(rs.getString("costo_venta")));
                listaVenta.add(porVenderse);
            }
            
        }catch(Exception e){
            System.out.println("Error en la consulta para la tabla de ventas");
            System.exit(0);
        }
        
        return listaVenta;
    }
    
}
