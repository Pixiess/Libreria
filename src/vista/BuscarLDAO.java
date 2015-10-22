package vista;

import controlador.ConexionPostgresql;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Libro;


public class BuscarLDAO {
    

    public ArrayList<Libro>buscarLibros(Libro libro, String opcion)
    {
        ArrayList<Libro> res = new ArrayList<Libro>();

        String sql = "SELECT * FROM " + tabla(opcion);
        String where = where(libro);
        
        if(!where.equals(""))
            sql += " WHERE "+where;
        
        try {
            ResultSet rs = ConexionPostgresql.consultar(sql);
            while (rs.next()) {
                Libro libro2 = new Libro();
                libro2.setAutorLibro(rs.getString("autor_libro"));
                libro2.setCostoCompra(Double.parseDouble(rs.getString("costo_compra")));
                libro2.setCostoVenta(Double.parseDouble(rs.getString("costo_venta")));
                libro2.setGenero(rs.getString("genero"));
                libro2.setEdicion(rs.getString("edicion"));
                libro2.setIdLibro(Integer.parseInt(rs.getString("id_libro")));
                libro2.setNombreLibro(rs.getString("nombre_libro"));
                libro2.setStockDisponible(Integer.parseInt(rs.getString("cantidad")));
                libro2.setStockMinimo(Integer.parseInt(rs.getString("cantidad_minima")));
 
                res.add(libro2);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        
        return res;
    }
    
    public String tabla(String opcion)
    {
        String res = "libro_order_by_titulo";
        
        if(opcion.equals("control stock"))
            res = "control_stock";
        else
            if(opcion.equals("dados de baja"))
                res = "libro_dado_baja";
        
        return res;
    }

    private String where(Libro libro) 
    {
        String res = "";
        
        String nombre = libro.getNombreLibro();
        String autor = libro.getAutorLibro();
        String genero = libro.getGenero();
        String edicion = libro.getEdicion();
      
        boolean aux = false;
        
        if(nombre != null && !nombre.equals(""))
        {
            res += "nombre_libro = '"+nombre+"'";
            aux = true;
        }
        
        if(autor != null && !autor.equals(""))
        {
            if(aux) res += " AND ";
            res += "autor_libro = '"+autor+"'";
            aux = true;
        }
        
        if(genero != null && !genero.equals(""))
        {
            if(aux) res += " AND ";
            res += "genero = '"+genero+"'";
            aux = true;
        }
        
        if(edicion != null && !edicion.equals(""))
        {
            if(aux) res += " AND ";
            res += "edicion = '"+edicion+"'";
        }
        
        return res;
    }
    public static void main(String [] args)
    {
        //Libro libro = new Libro(1, "", "Stephen King", "Novela", "", 10, 10, 10);
        Libro libro = new Libro(1, "", "", "", "", 10, 10, 10);
        BuscarLDAO r = new BuscarLDAO();
        ArrayList<Libro>res=r.buscarLibros(libro, "libros");
        for (Libro libro1 : res) {
            System.out.println(libro1.getNombreLibro()+" "+libro1.getAutorLibro()+" "+libro1.getGenero()+" "+libro.getEdicion());
        }
        
    }
}
