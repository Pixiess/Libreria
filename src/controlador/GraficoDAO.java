package controlador;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import modelo.LibroCantidadMes;


public class GraficoDAO {
    
    private ArrayList<LibroCantidadMes> librosVendMes;
    public static String [] libros;
    
    public double [] costosCompraMes()
    {
        int anio = Calendar.getInstance().get(Calendar.YEAR);
        int n = Calendar.getInstance().get(Calendar.MONTH);
        double [] res = new double [n+1];
        String sql = "SELECT C.fecha_compra, C.costo_total FROM compra AS C WHERE extract(year from C.fecha_compra)=" + anio ;

            try 
            {
                ResultSet rs = ConexionPostgresql.consultar(sql);
                while (rs.next())
                {
                    String valor = rs.getString("costo_total");
                    int mes = rs.getDate("fecha_compra").getMonth();
                    res[mes] += Double.parseDouble(valor);
                }
            } 
            catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
        
        return res;
    }
    
    public double [] ingresosVentaMes()
    {
        int anio = Calendar.getInstance().get(Calendar.YEAR);
        int n = Calendar.getInstance().get(Calendar.MONTH);
        double [] res = new double [n+1];
        String sql = "SELECT v.fecha, v.total FROM venta AS v WHERE extract(year from v.fecha)=" + anio ;

            try 
            {
                ResultSet rs = ConexionPostgresql.consultar(sql);
                while (rs.next())
                {
                    String valor = rs.getString("total");
                    int mes = rs.getDate("fecha").getMonth();
                    res[mes] += Double.parseDouble(valor);
                }
            } 
            catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
        
        return res;
    }
    
    public int [] [] cantidadLibros(int n)
    {
       int [][] res = new int [n][12];
       
       return res;
    }
    
    public int [][] getLibrosMasVendidos(int n){
        int anio = Calendar.getInstance().get(Calendar.YEAR);
        int mes = Calendar.getInstance().get(Calendar.MONTH);
        librosVendMes = new ArrayList<LibroCantidadMes>();
        String sql = "SELECT libro.id_libro, nombre_libro, edicion "
                + "FROM libro, detalle_venta, venta "
                + "WHERE libro.id_libro= detalle_venta.id_libro "
                + "AND detalle_venta.id_venta = venta.id_venta "
                + "AND extract(year from fecha)=" + anio + " "
                + "GROUP BY libro.id_libro "
                + "ORDER BY cantidad DESC limit " + n;
        try {
            ResultSet rs = ConexionPostgresql.consultar(sql);
            while (rs.next()){
                LibroCantidadMes libroVenPorMes = new LibroCantidadMes();
                libroVenPorMes.setIdLibro(Integer.parseInt(rs.getString("id_libro")));
                libroVenPorMes.setTitulo(rs.getString("nombre_libro"));
                libroVenPorMes.setEdicion(rs.getString("edicion"));
                librosVendMes.add(libroVenPorMes);
            }
            
        } catch(Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        
        System.out.println(librosVendMes.size());
        
        for(int x = 0; x<librosVendMes.size(); x++){
            String id = Integer.toString(librosVendMes.get(x).getIdLibro());
            String sql_cada_libro = "SELECT extract(month from fecha) as mes, "
                    + "SUM(cantidad_venta) as cantidad "
                    + "FROM libro, detalle_venta, venta "
                    + "WHERE libro.id_libro= detalle_venta.id_libro "
                    + "AND detalle_venta.id_venta = venta.id_venta "
                    + "AND libro.id_libro='" + id + "'"
                    + "GROUP BY mes ";
            try {
                ResultSet res = ConexionPostgresql.consultar(sql_cada_libro);
                while(res.next()){
                    int numero_mes = Integer.parseInt(res.getString("mes"));
                    switch(numero_mes)
                    {
                        case 1: 
                            librosVendMes.get(x).setCant_enero(Integer.parseInt(res.getString("cantidad"))); break;
                        case 2: 
                            librosVendMes.get(x).setCant_febrero(Integer.parseInt(res.getString("cantidad"))); break;
                        case 3: 
                            librosVendMes.get(x).setCant_marzo(Integer.parseInt(res.getString("cantidad")));  break;
                        case 4:
                            librosVendMes.get(x).setCant_abril(Integer.parseInt(res.getString("cantidad"))); break;
                        case 5: 
                            librosVendMes.get(x).setCant_mayo(Integer.parseInt(res.getString("cantidad"))); break;
                        case 6:
                            librosVendMes.get(x).setCant_junio(Integer.parseInt(res.getString("cantidad"))); break;
                        case 7:
                            librosVendMes.get(x).setCant_julio(Integer.parseInt(res.getString("cantidad"))); break;
                        case 8:
                            librosVendMes.get(x).setCant_agosto(Integer.parseInt(res.getString("cantidad"))); break;
                        case 9: 
                            librosVendMes.get(x).setCant_septiembre(Integer.parseInt(res.getString("cantidad"))); break;
                        case 10: 
                            librosVendMes.get(x).setCant_octubre(Integer.parseInt(res.getString("cantidad"))); break;
                        case 11:
                             librosVendMes.get(x).setCant_noviembre(Integer.parseInt(res.getString("cantidad"))); break;
                        case 12: 
                            librosVendMes.get(x).setCant_diciembre(Integer.parseInt(res.getString("cantidad"))); break;
                    }
                }
            } catch(Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }

            System.out.print(librosVendMes.get(x).getIdLibro() + "  ");
            System.out.print(librosVendMes.get(x).getTitulo() + "  ");
            System.out.print(librosVendMes.get(x).getCant_enero() + "  ");
            System.out.print(librosVendMes.get(x).getCant_febrero() + "  ");
            System.out.print(librosVendMes.get(x).getCant_marzo() + "  ");
            System.out.print(librosVendMes.get(x).getCant_abril() + "  ");
            System.out.print(librosVendMes.get(x).getCant_mayo() + "  ");
            System.out.print(librosVendMes.get(x).getCant_junio() + "  ");
            System.out.print(librosVendMes.get(x).getCant_julio() + "  ");
            System.out.print(librosVendMes.get(x).getCant_agosto() + "  ");
            System.out.print(librosVendMes.get(x).getCant_septiembre() + "  ");
            System.out.print(librosVendMes.get(x).getCant_octubre() + "  ");
            System.out.print(librosVendMes.get(x).getCant_noviembre() + "  ");
            System.out.println(librosVendMes.get(x).getCant_diciembre());
        }
        int [] [] res = new int [librosVendMes.size()][12];
        libros = new String [librosVendMes.size()];
        for(int i = 0; i<librosVendMes.size(); i++)
        {
            libros[i] = librosVendMes.get(i).getTitulo();
            res[i][0] += librosVendMes.get(i).getCant_enero();
            res[i][1] += librosVendMes.get(i).getCant_febrero();
            res[i][2] += librosVendMes.get(i).getCant_marzo();
            res[i][3] += librosVendMes.get(i).getCant_abril();
            res[i][4] += librosVendMes.get(i).getCant_mayo();
            res[i][5] += librosVendMes.get(i).getCant_junio();
            res[i][6] += librosVendMes.get(i).getCant_julio();
            res[i][7] += librosVendMes.get(i).getCant_agosto();
            res[i][8] += librosVendMes.get(i).getCant_septiembre();
            res[i][9] += librosVendMes.get(i).getCant_octubre();
            res[i][10] += librosVendMes.get(i).getCant_noviembre();
            res[i][11] += librosVendMes.get(i).getCant_diciembre();
        }
        
        return res;
       // return librosVendMes;
    }
    
}
