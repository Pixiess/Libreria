package controlador;

import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Libro;


public class BuscarLDAO {
    

    public ArrayList<Libro>buscarLibros(Libro libro, String opcion)
    {
        ArrayList<Libro> res = new ArrayList<Libro>();

        String sql = "SELECT * FROM " + tabla(opcion, libro.getNombreLibro(), libro.getAutorLibro());
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
    
    public String tabla(String opcion, String nombre, String autor)
    {
        String res = "libro_order_by_titulo";
        
        if(opcion.equals("control stock"))
        {
            res = "control_stock_nombre";
            if(nombre.equals("") && !autor.equals(""))
                res = "control_stock_autor";
            
        }
        else
        {
            if(opcion.equals("dados de baja"))
            {
                res = "libro_dado_baja_nombre";
                if(nombre.equals("") && !autor.equals(""))
                   res = "libro_dado_baja_autor";
            }
            else
            {
                if(nombre.equals("") && !autor.equals(""))
                    res = "libro_order_by_autor";
                
            }
        }
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
            res += "lower(nombre_libro) LIKE lower('"+nombre+"%') or lower(nombre_libro) LIKE lower('% "+nombre+"%')";
            aux = true;
        }
        
        if(autor != null && !autor.equals(""))
        {
            if(aux) res += " AND ";
            res += "lower(autor_libro) LIKE lower('"+autor+"%') or lower(autor_libro) LIKE lower('% "+autor+"%')";
            aux = true;
        }
        
        if(genero != null && !genero.equals(""))
        {
            if(aux) res += " AND ";
            res += "lower(genero) LIKE lower('"+genero+"%') or lower(genero) LIKE lower('% "+genero+"%')";
            aux = true;
        }
        
        if(edicion != null && !edicion.equals(""))
        {
            if(aux) res += " AND ";
            res += "lower(edicion) LIKE lower('"+edicion+"%') or lower(edicion) LIKE lower('% "+edicion+"%')";
        }
        
        return res;
    }
    public static void main(String [] args)
    {
        Libro libro = new Libro(1, "", "S", "Novela", "", 10, 10, 10);
       // Libro libro = new Libro(1, "", "", "", "", 10, 10, 10);
        BuscarLDAO r = new BuscarLDAO();
        ArrayList<Libro>res=r.buscarLibros(libro, "libros");
        for (Libro libro1 : res) {
            System.out.println(libro1.getNombreLibro()+" "+libro1.getAutorLibro()+" "+libro1.getGenero()+" "+libro.getEdicion());
        }
        
    }
}
