/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Venta;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author lourdes
 */
public class VentaDAO {

    private ArrayList<Venta> ventas;

    public VentaDAO() {
        ventas = new ArrayList<>();
    }

    /**
     * @return the ventas
     */
    public ArrayList<Venta> getVentas() {
        consultarVenta();
        return ventas;
    }

    private void consultarVenta() {
        String sql = "SELECT * FROM venta";

        try {
            ResultSet rs = ConexionPostgresql.consultar(sql);
            while (rs.next()) {
                Venta venta = new Venta();
                venta.setIdVenta(Integer.parseInt(rs.getString("id_venta")));
                //venta.setCi(Integer.parseInt(rs.getString("ci")));
                venta.setCi(rs.getString("ci"));
                venta.setIdLibreria(Integer.parseInt(rs.getString("id_libreria")));
                venta.setFecha(rs.getString("fecha"));
                venta.setTotal(Double.parseDouble(rs.getString("total")));
                //System.out.println("Entra de consulta");
                ventas.add(venta);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            //System.exit(0);
        }
    }

    /**
     * @param ventas the ventas to set
     */
    public void setVentas(ArrayList<Venta> ventas) {
        this.ventas = ventas;
    }

}
