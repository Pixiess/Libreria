/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.sql.ResultSet;
import modelo.Usuario;

/**
 *
 * @author lourdes
 */
public class UsuarioDAO {
    
    private Usuario usuario;
    
    public UsuarioDAO(){
        
    }
    
    public Usuario verificarUsuario(String login, String contrasenia){
        Usuario usuario = new Usuario();
        String sql = "SELECT * FROM usuario"
                + " where login = '"+login+ "' and contrasenia ='"+contrasenia+"'";
        
        try {
            ResultSet rs = ConexionPostgresql.consultar(sql);
            while (rs.next()) {
                   //Asegurar que sólo haya un usuario
                usuario.setCiUsuario(rs.getString("ci_usuario"));
                usuario.setNombres(rs.getString("nombres"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setEmail(rs.getString("email"));
                usuario.setFechaNacimiento("fecha_nacimiento");
                usuario.setTelefono(Integer.parseInt(rs.getString("telefono")));
                usuario.setLogin(rs.getString("login"));
                usuario.setContrasenia(rs.getString("contrasenia"));
                usuario.setRol(Integer.parseInt(rs.getString("rol")));
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return usuario;
    }
}
