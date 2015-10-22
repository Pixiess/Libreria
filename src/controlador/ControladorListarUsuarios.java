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
import modelo.Usuario;
import vista.Libreria;
import vista.ListarUsuarios;
import vista.RegistroUsuario;



public class ControladorListarUsuarios implements MouseListener, KeyListener, FocusListener, PropertyChangeListener
{
    private Libreria lib;
    private ListarUsuarios listarUsuarios;
    private RegistroUsuario registroUsuario;
    private RegistroDAO registro;
    private UsuarioDAO usuarioDAO;

    private ArrayList<Usuario> usuariosDeLaTabla;
    private JTable tablaDeUsuarios;
    private DefaultTableModel tableModel;
    private JComboBox opciones;
    
    private final String[] titulosTabla = {"C.I.", "LOLICON", "APELLIDOS", 
        "ROL", "TELEFONO", "ESTADO"};
    
    public ControladorListarUsuarios(ListarUsuarios listarUsuarios, RegistroUsuario registroUsuario, Libreria lib)
    {
        this.listarUsuarios = listarUsuarios;
        this.registroUsuario = registroUsuario;
        this.lib = lib;
        
        setListeners();
        
        tablaDeUsuarios = listarUsuarios.getTableListarUsuarios();
        tableModel = (DefaultTableModel) tablaDeUsuarios.getModel();
        System.out.println("-------------LLEGO AQUI-----------");
        
        String[] estado = {"Alta","Baja"};
        opciones = new JComboBox(estado);
        
        usuarioDAO = new UsuarioDAO();
        registro = new RegistroDAO();
        
        inicializarListaUsuarios();
    }
    
    public void inicializarListaUsuarios(){
        
        llenarTodosLosUsuariosTabla();
    }
    
    public void setListeners(){
        listarUsuarios.getBtnRegistrarUsuario().addMouseListener(this);
        listarUsuarios.getBtnEditarUsuario().addMouseListener(this);
        registroUsuario.getBtnAceptar().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(listarUsuarios.getBtnRegistrarUsuario())) cambiarRegistro();
        else 
        {
            if(e.getSource().equals(listarUsuarios.getBtnEditarUsuario())) cambiarAEditar();
            else
            {
                if(e.getSource().equals(registroUsuario.getBtnAceptar())) cambiarAListar();
            }
        }
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

    private void cambiarRegistro()
    {
        lib.cambiarARegistro();
    }
    private void cambiarAEditar()
    {
        lib.cambiarAEditar();
    }
    private void cambiarAListar()
    {
        String [] datos = obtenerDatos();
        
        if(registroUsuario.getTipo().equals("Registrar"))
        {
            registro.registrarUsuario(datos);
        }
        else
        {
            registro.actualizarUsuario(datos);
        }
        
        lib.cambiarAListar();
    }

    private String[] obtenerDatos() 
    {
        String [] datos = new String [9];
        datos[0] = registroUsuario.getLogin();
        datos[1] = registroUsuario.getContrasenia();
        datos[2] = registroUsuario.getNombres();
        datos[3] = registroUsuario.getApellidos();
        datos[4] = registroUsuario.getFecha();
        datos[5] = ""+registroUsuario.getTelefono();
        datos[6] = registroUsuario.getCorreo();
        datos[7] = ""+registroUsuario.getCi();
        String rol = registroUsuario.getRol();
        if(rol.equals("Administrador"))
            datos[8] = "1";
        else
            datos[8] = "2";
        return datos;
    }
}
