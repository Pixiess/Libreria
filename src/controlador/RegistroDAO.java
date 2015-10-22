package controlador;
 
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
        
        String sql = "INSERT INTO usuario (ci_usuario, nombres, apellidos, email, fecha_nacimiento, telefono, login, contrasenia, rol) VALUES ('"
                +ci+"', '"+ nombres + "', '" + apellidos + "', '" + correo + "', '" + fechaN + "', " + telefono + ", '" + login + "', '" + contrasena + "', " + rol +")";
        
        ConexionPostgresql.updateDB(sql);
        
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
        
        String sql = "UPDATE usuario SET login = '" +login + "', contrasenia = '"+contrasena+
                    "', telefono = "+telefono+", email = '"+correo+"', rol = "+rol+" WHERE ci_usuario = '" + ci+ "'" ;
       // System.out.println(sql);
        ConexionPostgresql.updateDB(sql);
    }
    public static void main(String [] args)
    {
        String [] datos = {"brian8", "brian7", "Brian", "Molko", "22-11-1976", "7176539", "brian8@gmail.com", "123431", "1"};
        actualizarUsuario(datos);
    }
}
