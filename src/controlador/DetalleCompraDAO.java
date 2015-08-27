/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

/**
 *
 * @author pcs
 */
public class DetalleCompraDAO {
    
    private int idLibro;
    private int idCompra;
    
    public DetalleCompraDAO(){
        
    }

    public DetalleCompraDAO(int idLibro, int idCompra) {
        this.idLibro = idLibro;
        this.idCompra = idCompra;
    }
    
    public void insertarDetalleCompraBD(){
        
        String sql="INSERT INTO detalle_compra (id_libro, id_compra) "
                + "VALUES ("+idLibro+", "+idCompra+")";
            ConexionPostgresql.updateDB(sql);
    }
    
    
    
}
