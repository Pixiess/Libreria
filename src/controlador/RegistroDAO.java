package controlador;
 
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class RegistroDAO {
    
    public static boolean registrarUsuario(String [] datos)
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
                + login + "', '" + contrasena + "', " + rol +", 1 )";
        
            ConexionPostgresql.updateDB(sql);
            return true;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Ya existe un usuario con el ci proporcionado");
            return false;
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
        
        String sql = "UPDATE usuario SET contrasenia = '"+contrasena+"', nombres = '"+nombres+"', apellidos = '"+apellidos+
                    "', telefono = "+telefono+", email = '"+correo+"', rol = "+rol
                    +" WHERE ci_usuario = '" + ci+ "'" ;
       
        ConexionPostgresql.updateDB(sql);
    }

    public String[] obtenerUsuario(String ci) 
    {
       String [] datos = new String [10];
       
       String sql = "SELECT * FROM usuario where ci_usuario = '"+ci+"'";
       try {
            ResultSet rs = ConexionPostgresql.consultar(sql);
            while (rs.next())
            {
                datos[0] = rs.getString("login");
                datos[1] = rs.getString("contrasenia");
                datos[2] = rs.getString("nombres");
                datos[3] = rs.getString("apellidos");
                datos[4] = rs.getString("fecha_nacimiento");
                datos[5] = rs.getString("telefono");
                datos[6] = rs.getString("email");
                datos[7] = ci;
                datos[8] = rs.getString("rol");
                datos[9] = rs.getString("estado_usuario");
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
       return datos;
    }
 
}
