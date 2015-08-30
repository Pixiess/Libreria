/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Venta;

/**
 *
 * @author USUARIO
 */
public class ReportesDAO {
    
    private ArrayList<Venta> librosVendidos;
    
    public ArrayList<Venta> getReporte(String fechaInicio, String fechaFin){
        
        librosVendidos = new ArrayList<>();
        String sql = "SELECT libro.id_libro, nombre_libro, edicion, "
                + "SUM(costo_parcial) as costo, SUM(cantidad_venta) as cantidad "
                + "FROM libro, detalle_venta, venta "
                + "WHERE libro.id_libro= detalle_venta.id_libro "
                + "AND detalle_venta.id_venta = venta.id_venta "
                + "AND fecha>='" + fechaInicio + "' AND fecha<='" + fechaFin + "' "
                + "GROUP BY libro.id_libro ";
        
        try{
            ResultSet rs = ConexionPostgresql.consultar(sql);
            while (rs.next()){
                Venta venta = new Venta();
                venta.setNombreLibro(rs.getString("nombre_libro"));
                venta.setEdicionLibro(rs.getString("edicion"));
                venta.setCantidad(Integer.parseInt(rs.getString("cantidad")));
                venta.setCostoParcial(Double.parseDouble(rs.getString("costo")));
                
                librosVendidos.add(venta);
            }
            
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return librosVendidos;
    }
}
