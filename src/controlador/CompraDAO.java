/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.sql.ResultSet;


/**
 *
 * @author lourdes
 */
public class CompraDAO {
    
    private String fecha;
    private int cantidad;
    private double total;
   

    public CompraDAO(String fecha, int cantidad, double total) {
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.total = total;
    }
    
    public void insertarCompraBD(){
        
        String sql="INSERT INTO compra (fecha_compra, cantidad, costo_total) "
                + "VALUES ('"+fecha+"', "+cantidad+", "+total+")";
            ConexionPostgresql.updateDB(sql);
    }
    
    public int getUltimaCompra(){
        int res = 0;
        
        String sql = "SELECT max(id_compra) as id FROM compra" ;
        
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
}
