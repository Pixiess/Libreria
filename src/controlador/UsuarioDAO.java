/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Usuario;

/**
 *
 * @author lourdes
 */
public class UsuarioDAO {
    
    private Usuario usuario;
    private ArrayList<Usuario> registroUsuarios; 
    
    public UsuarioDAO(){
        
    }
    
    public Usuario verificarUsuario(String login, String contrasenia){
        Usuario usuario = new Usuario();
        String sql = "SELECT * FROM usuario"
                + " where login = '"+login+ "' "
                + "and contrasenia ='"+contrasenia+"'"
                + "and estado_usuario = 1";
        
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
                usuario.setEstado(Integer.parseInt(rs.getString("estado_usuario")));
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return usuario;
    }
    
    public ArrayList<Usuario> getListaUsuarios(){
        registroUsuarios = new ArrayList<>();
        
        String sql = "SELECT * FROM usuario";
        
        try {
            ResultSet rs = ConexionPostgresql.consultar(sql);
            while(rs.next()){
                Usuario unUsuario = new Usuario();
                
                unUsuario.setCiUsuario(rs.getString("ci_usuario"));
                unUsuario.setNombres(rs.getString("nombres"));
                unUsuario.setApellidos(rs.getString("apellidos"));
                unUsuario.setEmail(rs.getString("email"));
                unUsuario.setFechaNacimiento("fecha_nacimiento");
                unUsuario.setTelefono(Integer.parseInt(rs.getString("telefono")));
                unUsuario.setLogin(rs.getString("login"));
                unUsuario.setContrasenia(rs.getString("contrasenia"));
                unUsuario.setRol(Integer.parseInt(rs.getString("rol")));
                unUsuario.setEstado(Integer.parseInt(rs.getString("estado_usuario")));
                
                registroUsuarios.add(unUsuario);
            }
            
        } catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        
        return registroUsuarios;
    }
    
    public void darAlta(String ci){
        String sql = "UPDATE usuario SET estado_usuario='" + 1 + "' WHERE ci_usuario='" + ci + "'";
        ConexionPostgresql.updateDB(sql);
    }
    
    public void darBaja(String ci){
        String sql1 = "UPDATE usuario SET estado_usuario='" + 0 + "' WHERE ci_usuario='" + ci + "'";
        ConexionPostgresql.updateDB(sql1);
    }
    
}
