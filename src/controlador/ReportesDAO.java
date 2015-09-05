/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.LibroReporte;
import modelo.Venta;

/**
 *
 * @author USUARIO
 */
public class ReportesDAO {
    
    private ArrayList<LibroReporte> reportesLibros;
    
    public ArrayList<LibroReporte> getReporte(String fechaInicio, String fechaFin){
        
        reportesLibros = new ArrayList<>();
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
                LibroReporte venta = new LibroReporte();
                venta.setTitulo(rs.getString("nombre_libro"));
                venta.setEdicion(rs.getString("edicion"));
                venta.setCantidad(Integer.parseInt(rs.getString("cantidad")));
                venta.setCosto(Double.parseDouble(rs.getString("costo")));
                
                reportesLibros.add(venta);
            }
            
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return reportesLibros;
    }
    
    public ArrayList<LibroReporte> getReporteMasVendidos(String fechaInicio, String fechaFin, int n){
        
        reportesLibros = new ArrayList<>();
        String sql = "SELECT libro.id_libro, nombre_libro, edicion, "
                + "SUM(costo_parcial) as costo, SUM(cantidad_venta) as cantidad "
                + "FROM libro, detalle_venta, venta "
                + "WHERE libro.id_libro= detalle_venta.id_libro "
                + "AND detalle_venta.id_venta = venta.id_venta "
                + "AND fecha>='" + fechaInicio + "' AND fecha<='" + fechaFin + "' "
                + "GROUP BY libro.id_libro "
                + "ORDER BY cantidad DESC limit "+ n;
        
        try{
            ResultSet rs = ConexionPostgresql.consultar(sql);
            while (rs.next()){
                LibroReporte venta = new LibroReporte();
                venta.setTitulo(rs.getString("nombre_libro"));
                venta.setEdicion(rs.getString("edicion"));
                venta.setCantidad(Integer.parseInt(rs.getString("cantidad")));
                venta.setCosto(Double.parseDouble(rs.getString("costo")));
                
                reportesLibros.add(venta);
            }
            
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return reportesLibros;
    }
    
    public ArrayList<LibroReporte> getReporteLibrosComprados(String fechaInicio, String fechaFin){
        
        reportesLibros = new ArrayList<>();
        String sql = "SELECT libro.id_libro, nombre_libro, edicion, "
                + "SUM(costo_total) as costo, SUM(compra.cantidad) as cantidad "
                + "FROM libro, detalle_compra, compra "
                + "WHERE libro.id_libro= detalle_compra.id_libro "
                + "AND detalle_compra.id_compra = compra.id_compra "
                + "AND fecha_compra>='" + fechaInicio + "' AND fecha_compra<='" + fechaFin + "' "
                + "GROUP BY libro.id_libro ";
        
        try{
            ResultSet rs = ConexionPostgresql.consultar(sql);
            while (rs.next()){
                LibroReporte compra = new LibroReporte();
                //compra.setIdLibro(Integer.parseInt(rs.getString("libro.id_libro")));
                compra.setTitulo(rs.getString("nombre_libro"));
                compra.setEdicion(rs.getString("edicion"));
                compra.setCantidad(Integer.parseInt(rs.getString("cantidad")));
                compra.setCosto(Double.parseDouble(rs.getString("costo")));
                
                reportesLibros.add(compra);
            }
            
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return reportesLibros;
    }
}
