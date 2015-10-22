package controlador;
 
import java.sql.ResultSet;

public class RegistroDAO {
    
    public static void registrarUsuario(String [] datos)
    {
        String login = datos[0];
        String contrasena = datos[1];
        String nombres = datos[2];
        String apellidos = datos[3];
        String fechaN = datos[4];
        int telefono = Integer.parseInt(datos[5]);
        String correo = datos[6];
        String ci = datos[7];
        int rol = Integer.parseInt(datos[8]);
        
        String verificar = "SELECT count(*) FROM usuario where ci_usuario = '"+ci+"'";
        int v = 0;
        try {
            ResultSet rs = ConexionPostgresql.consultar(verificar);
            while (rs.next()) {
                v = Integer.parseInt(rs.getString("count"));
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        if(v == 0)
        {
            String sql = "INSERT INTO usuario (ci_usuario, nombres, apellidos, email, fecha_nacimiento, telefono, login, contrasenia, rol, estado_usuario) VALUES ('"
                +ci+"', '"+ nombres + "', '" + apellidos + "', '" + correo + "', '" + fechaN + "', " + telefono + ", '" 
                + login + "', '" + contrasena + "', " + rol +", 0 )";
        
            ConexionPostgresql.updateDB(sql);
        }
       
        
        
    }
    public static void actualizarUsuario(String [] datos)
    {
        String login = datos[0];
        String contrasena = datos[1];
        String nombres = datos[2];
        String apellidos = datos[3];
        String fechaN = datos[4];
        int telefono = Integer.parseInt(datos[5]);
        String correo = datos[6];
        String ci = datos[7];
        int rol = Integer.parseInt(datos[8]);
        
        String sql = "UPDATE usuario SET contrasenia = '"+contrasena+
                    "', telefono = "+telefono+", email = '"+correo+"', rol = "+rol+" WHERE ci_usuario = '" + ci+ "'" ;
       // System.out.println(sql);
        ConexionPostgresql.updateDB(sql);
    }
    public static void main(String [] args)
    {
        String [] datos = {"brian8", "brian7", "Brian", "Molko", "22-11-1976", "7176539", "brian8@gmail.com", "123431", "1"};
        registrarUsuario(datos);
        //actualizarUsuario(datos);
    }
}
