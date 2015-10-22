package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Usuario;
import modelo.UsuarioActual;
import vista.Libreria;
import vista.ListarUsuarios;
import vista.RegistroUsuario;



public class ControladorListarUsuarios implements MouseListener, KeyListener, FocusListener, PropertyChangeListener, ActionListener
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
    
    private final String[] titulosTabla = {"C.I.", "NOMBRE", "APELLIDO", "ROL", "TELEFONO", "ESTADO"};
    
    public ControladorListarUsuarios(ListarUsuarios listarUsuarios, RegistroUsuario registroUsuario, Libreria lib)
    {
        this.listarUsuarios = listarUsuarios;
        this.registroUsuario = registroUsuario;
        this.lib = lib;
        
        tablaDeUsuarios = listarUsuarios.getTableListarUsuarios();
        tableModel = (DefaultTableModel) tablaDeUsuarios.getModel();
        System.out.println("-------------LLEGO AQUI-----------");
        
        String[] estado = {"Alta","Baja"};
        opciones = new JComboBox(estado);
        
        usuarioDAO = new UsuarioDAO();
        registro = new RegistroDAO();
        
        inicializarListaUsuarios();
        setListeners();
    }
    
    public void inicializarListaUsuarios(){
        
        llenarTodosLosUsuariosTabla();
    }
    
    public void setListeners(){
        listarUsuarios.getBtnRegistrarUsuario().addMouseListener(this);
        listarUsuarios.getBtnEditarUsuario().addMouseListener(this);
        registroUsuario.getBtnAceptar().addMouseListener(this);
        registroUsuario.getBtnRegresar().addMouseListener(this);
        opciones.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(opciones)){
            actualizarEstadoUsuario();
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(listarUsuarios.getBtnRegistrarUsuario())) 
        {
            registroUsuario.limpiarCampos();
            cambiarRegistro();
        }
        else 
        {
            if(e.getSource().equals(listarUsuarios.getBtnEditarUsuario()))
            {
                if(llenarCampos())
                    cambiarAEditar();
            }
            else
            {
                if(e.getSource().equals(registroUsuario.getBtnAceptar())) 
                {
                    if(registroUsuario.getTipo().equals("Registrar"))
                    {
                        if(registrar())
                        {
                            registroUsuario.limpiarCampos();
                            llenarTabla();
                        }
                    }
                    else
                    {
                        if(editar())
                        {
                            registroUsuario.limpiarCampos();
                            llenarTabla();
                        }
                    }
                }
                else
                {
                    if(e.getSource().equals(registroUsuario.getBtnRegresar()))
                    {
                        registroUsuario.limpiarCampos();
                        lib.cambiarAListar();
                    }
                }
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
  
    private String[] obtenerDatos() 
    {
        String [] datos = new String [9];
        datos[0] = registroUsuario.getLogin();
        datos[1] = registroUsuario.getContrasenia();
        datos[2] = registroUsuario.getNombres();
        datos[3] = registroUsuario.getApellidos();
        datos[4] = registroUsuario.getFecha();
        datos[5] = registroUsuario.getTelefono();
        datos[6] = registroUsuario.getCorreo();
        datos[7] = registroUsuario.getCi();
        String rol = registroUsuario.getRol();
        if(rol.equals("Administrador"))
            datos[8] = "1";
        else
            datos[8] = "2";
        return datos;
    }

    private boolean registrarOEditar()
    {
       String [] datos = obtenerDatos();
       if( datos[0]!=null && !datos[0].equals("") && datos[1]!=null && !datos[1].equals("") && datos[2]!=null && !datos[2].equals("") &&
           datos[3]!=null && !datos[3].equals("") && datos[4]!=null && !datos[4].equals("") && datos[5]!=null && !datos[5].equals("") &&
           datos[6]!=null && !datos[6].equals("") && datos[7]!=null && !datos[7].equals("") && datos[8]!=null && !datos[8].equals(""))
       {
           if(validarCorreo(datos[6]))
           {
               return true;
           }
           else
           {
                JOptionPane.showMessageDialog(null, "Debe ingresar un correo valido");
           }
       }
       else
       {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos");
       }
       return false;
    
    }
    
     public static boolean validarCorreo(String correo) 
     {
        String patron = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(correo);
        
        return matcher.matches();
 
    }

    private boolean registrar() 
    {
        String [] datos = obtenerDatos();
        if(registrarOEditar() && registro.registrarUsuario(datos))
        {
            lib.cambiarAListar();
            return true;
        }
        return false;
        
    }

    private boolean editar() 
    {
        if(registrarOEditar())
        {
            registro.actualizarUsuario(obtenerDatos());
            lib.cambiarAListar();
            return true;
        }
        return false;
    }

    private boolean llenarCampos(){

        int cantFila = tablaDeUsuarios.getRowCount();
        if (cantFila > 0)
        {
            int row = tablaDeUsuarios.getSelectedRow();
            
            if (row >= 0) 
            {
                String ci = tablaDeUsuarios.getValueAt(row, 0).toString();
                String [] datos = registro.obtenerUsuario(ci);
                registroUsuario.actualizarDatos(datos);
                return true;
                
            } 
            else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
            }
         }
        return false;
    }
    
    private void actualizarEstadoUsuario(){
        int fila = tablaDeUsuarios.getSelectedRow();
        
        if(fila!=-1){
           String ci = (String)tablaDeUsuarios.getValueAt(fila, 0);
           String ciUsuarioActual = UsuarioActual.usuarioActual.getCiUsuario();
           
           if(!ci.equals(ciUsuarioActual)){
               opciones.setEnabled(true);
               
               if(opciones.getSelectedIndex() == 0){
                   usuarioDAO.darAlta(ci);
               }else{
                   usuarioDAO.darBaja(ci);
               }
               
           }else{
               opciones.setEnabled(false);
           }
           
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }
    
}
