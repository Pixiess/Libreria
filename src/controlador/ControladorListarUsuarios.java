/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import modelo.Usuario;
import vista.ListarUsuarios;
/**
 *
 * @author USUARIO
 */
public class ControladorListarUsuarios implements MouseListener, KeyListener, FocusListener, PropertyChangeListener{
    
    private ListarUsuarios listarUsuarios;
    private UsuarioDAO usuarioDAO;
    private ArrayList<Usuario> usuariosDeLaTabla;
    private JTable tablaDeUsuarios;
    private DefaultTableModel tableModel;
    private JComboBox opciones;
    
    private final String[] titulosTabla = {"C.I.", "LOLICON", "APELLIDOS", 
        "ROL", "TELEFONO", "ESTADO"};
    
    public ControladorListarUsuarios(ListarUsuarios listarUsuarios){
        this.listarUsuarios = listarUsuarios;
        setListeners();
        tablaDeUsuarios = listarUsuarios.getTableListarUsuarios();
        tableModel = (DefaultTableModel) tablaDeUsuarios.getModel();
        System.out.println("-------------LLEGO AQUI-----------");
        
        String[] estado = {"Alta","Baja"};
        opciones = new JComboBox(estado);
        
        usuarioDAO = new UsuarioDAO();
        
        inicializarListaUsuarios();
    }
    
    public void inicializarListaUsuarios(){
        
        llenarTodosLosUsuariosTabla();
    }
    
    public void setListeners(){
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void focusGained(FocusEvent e) {
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
    }
    
    public void llenarTodosLosUsuariosTabla(){
        usuariosDeLaTabla = usuarioDAO.getListaUsuarios();
        llenarTabla();
    }
    
    private void llenarTabla(){
        Object[][] datosTabla = conseguirDatosTabla();
        tableModel.setDataVector(datosTabla, titulosTabla);
        tablaDeUsuarios.getColumnModel().getColumn(5).setCellEditor(
                new DefaultCellEditor(opciones));
        
    }
    
    private Object[][] conseguirDatosTabla(){
        Object[][] datos = new Object[usuariosDeLaTabla.size()][];
        for(int i =0; i<usuariosDeLaTabla.size(); i++){
            datos[i] = devolverDatosUsuarios(usuariosDeLaTabla.get(i));
        }
        return datos;
    }
    
    private Object[] devolverDatosUsuarios(Usuario usuario){
        Object[] respuesta = new Object[6];
        
        respuesta[0] = usuario.getCiUsuario();
        respuesta[1] = usuario.getNombres();
        respuesta[2] = usuario.getApellidos();
        respuesta[3] = usuario.getRol();
        respuesta[4] = usuario.getTelefono();
        
        if(usuario.getEstado() == 1){
            respuesta[5] = "Alta";
        }else if(usuario.getEstado() == 0){
            respuesta[5] = "Baja";
        }
        
        return respuesta;
    }
    
}
