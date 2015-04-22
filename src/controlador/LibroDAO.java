/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import modelo.Libro;
import vista.BuscadorLibros;

/**
 *
 * @author Veymar Montaño Colqu
 */
public class LibroDAO {
    private boolean primeraFila;
    private boolean ultimaFila;
    
    private String tituloErroneo;
    
    private ArrayList<Libro> registroLibros;
    
    public LibroDAO() {        
        primeraFila = true;
        ultimaFila = false;
        
        tituloErroneo = "·";
    }
    
    public void reiniciarTituloErroneo(){
        tituloErroneo = "·";
    }
    
    
    //por defecto tendrá todos los datos en la tabla
    public ArrayList<Libro> getReportePorFiltro(String filtro){
        registroLibros = new ArrayList<>();
        String[] filtroYTabla = obtenerModoDeOrden(filtro);
        String sql = "SELECT * FROM " + filtroYTabla[1] 
                + " order by "+filtroYTabla[0];//+
                //" limit 21;";
        
        try {
            ResultSet rs = ConexionPostgresql.consultar(sql);
            while (rs.next()) {
                Libro libro = new Libro();
                libro.setAutorLibro(rs.getString("autor_libro"));
                libro.setCostoCompra(Double.parseDouble(rs.getString("costo_compra")));
                libro.setCostoVenta(Double.parseDouble(rs.getString("costo_venta")));
                libro.setDireccionImagen(rs.getString("imagen"));
                libro.setGenero(rs.getString("genero"));
                libro.setIdLibro(Integer.parseInt(rs.getString("id_libro")));
                libro.setNombreLibro(rs.getString("nombre_libro"));
                libro.setStockDisponible(Integer.parseInt(rs.getString("cantidad")));
                libro.setStockMinimo(Integer.parseInt(rs.getString("cantidad_minima")));
                
                registroLibros.add(libro);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        
        return registroLibros;
    }
    
    private String[] obtenerModoDeOrden(String filtro){
        String[] respuesta = new String[2];
        switch(filtro){
            case "Por Titulo" : respuesta[0] = "nombre_libro"; 
                respuesta[1] = "libro_order_by_titulo"; break;
            case "Por Autor" : respuesta[0] = "autor_libro"; 
                respuesta[1] = "libro_order_by_autor"; break;
            case "Por Tema" : respuesta[0] = "genero"; 
                respuesta[1] = "libro_order_by_genero"; break;
        }
        
        return respuesta;
    }
    
    public int encontrarPrimeraCoincidencia(String texto, String filtro){
        int respuesta = -1;
        if(!texto.startsWith(tituloErroneo)){            
            switch(filtro){
                case "Por Titulo":respuesta = buscarPorTitulo(texto);break;
                case "Por Tema":respuesta = buscarPorTema(texto);break;
                case "Por Autor":respuesta = buscarPorAutor(texto);break;
            }
        }
        
        if(respuesta == -1)
            tituloErroneo = texto;
        
        return respuesta;
    }
    
    private int buscarPorTitulo(String texto){
        int respuesta = -1;
        String cadena = "";
        for (int i = 0; i < registroLibros.size(); i++) {
            cadena = (registroLibros.get(i).getNombreLibro()).toLowerCase();
            if(cadena.startsWith(texto.toLowerCase())){
                //System.out.println(texto+ " encontroooo "+i+" "+registroLibros.get(i).getNombreLibro());
                respuesta = i;
                break;
            }
        }
        
        return respuesta;
    }
    private int buscarPorTema(String texto){
        int respuesta = -1;
        String cadena = "";
        for (int i = 0; i < registroLibros.size(); i++) {
            cadena = (registroLibros.get(i).getGenero()).toLowerCase();
            if(cadena.startsWith(texto.toLowerCase())){
                //System.out.println(texto+ " encontroooo "+i+" "+registroLibros.get(i).getNombreLibro());
                respuesta = i;
                break;
            }
        }
        
        return respuesta;
    }
    private int buscarPorAutor(String texto){
        int respuesta = -1;
        String cadena = "";
        for (int i = 0; i < registroLibros.size(); i++) {
            cadena = (registroLibros.get(i).getAutorLibro()).toLowerCase();
            if(cadena.startsWith(texto.toLowerCase())){
                //System.out.println(texto+ " encontroooo "+i+" "+registroLibros.get(i).getNombreLibro());
                respuesta = i;
                break;
            }
        }
        
        return respuesta;
    }
}
