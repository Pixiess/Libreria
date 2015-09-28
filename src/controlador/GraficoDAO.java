package controlador;

import java.sql.ResultSet;
import java.util.Calendar;


public class GraficoDAO {
    
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
    
    public int [] [] cantidadLibros(int n)
    {
       int [][] res = new int [n][12];
       
       return res;
    }
    
}
