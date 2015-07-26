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
 * @author lourdes
 */
public class DetalleDAO {

    private ArrayList<Integer> indicesL;
    private String[] parciales;
    private Integer[] cantidades;
    private String[] libros;
    private int idV;

    public DetalleDAO(String[] libros, int idV, String[] parciales, Integer[] cantidades) {
        indicesL = new ArrayList<>();
        this.parciales = parciales;
        this.libros = libros;
        this.cantidades = cantidades;
        this.idV = idV;

    }

    public void insertarEnBD() {
        buscarIndice();
    }

    private void buscarIndice() {
        int i = 0;
        while (i < libros.length) {
            String name = libros[i];
            String sql = "SELECT id_libro FROM libro WHERE nombre_libro='" + name + "'";

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

    private void insertarEnDetalle() {
        for (int i = 0; i < indicesL.size(); i++) {
            Double cp = Double.parseDouble(parciales[i]);
            try {
                String sql = "INSERT INTO detalle_venta (id_venta, id_libro, "
                                    + "costo_parcial) VALUES (" + idV + ", " 
                                    + indicesL.get(i) + ", " + cp + ")";
                //String sql = "INSERT INTO detalle_venta (id_venta, id_libro) VALUES ("+idV+ ", " + indicesL.get(i) + ")";
                boolean rs = ConexionPostgresql.updateDB(sql);
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
        }
    }

    public void actualizarCantidad() {
        int i = 0;
        while (i < indicesL.size()) {

            int idL = indicesL.get(i);
            String sql = "UPDATE libro SET cantidad=cantidad - " + cantidades[i] 
                                            + " WHERE id_libro='" + idL + "'";

            ConexionPostgresql.updateDB(sql);
            //System.out.println("El indice del libro es:" + idL + "cantidad: " + cantidades[i]);
            i++;

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
