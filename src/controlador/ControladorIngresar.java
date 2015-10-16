/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static javax.swing.BorderFactory.createTitledBorder;
import static javax.swing.BorderFactory.createTitledBorder;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import modelo.Usuario;
import vista.Ingresar;
import vista.Inicio;
import vista.Libreria;
import vista.PanelInicio;

/**
 *
 * @author lourdes
 */
public class ControladorIngresar implements MouseListener, KeyListener, FocusListener, ActionListener {
   
    private Inicio frameInicio;
    private PanelInicio inicio;
    private Libreria libreria;
    private Restriccion restriccion;
    private Usuario usuario;
    
    
    public ControladorIngresar(Inicio frameInicio, PanelInicio inicioLogin){
    
       this.frameInicio = frameInicio;
       restriccion = new Restriccion();
       inicio = inicioLogin;
       libreria = new Libreria();
       usuario = new Usuario();
       setListeners();
    }
    
    public void inicializarIngreso(){
        inicio.getTxtLogin().setText("");
        inicio.getPswdContrasenia().setText("");
    }
    
    private void setListeners(){
        frameInicio.getItemSalir().addActionListener(this);        
        inicio.getBtnIngresar().addMouseListener(this);
        inicio.getTxtLogin().addKeyListener(this);
        inicio.getPswdContrasenia().addKeyListener(this);       
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(frameInicio.getItemSalir())){
            mostrarInicio();
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(inicio.getBtnIngresar())){
            iniciarSesion();
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
        char caracter = e.getKeyChar();
        
        if (e.getSource().equals(inicio.getTxtLogin())) {
            if (!restriccion.esTextoNumeroSinEspacio(caracter, 50, inicio.getTxtLogin())) {
                e.consume();
            }
        }
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
    
    private void mostrarInicio(){
        inicializarIngreso();
        frameInicio.getPnlBaseInicio().removeAll();
        frameInicio.getPnlBaseInicio().add(inicio);
        frameInicio.getPnlBaseInicio().updateUI();
        frameInicio.getMenuInicio().setVisible(false);
    }
    
    private void iniciarSesion(){        
        String contrasenia = inicio.getPswdContrasenia().getText();
        String login = inicio.getTxtLogin().getText();
        String rol = "";
        
        if(identificacionCorrecta(login, contrasenia)){
        if(usuario.getRol()==1){
            rol="Administrador";            
        }else{
            rol="Vendedor";
        }
        frameInicio.getPnlBaseInicio().removeAll();
        libreria.getPnlBaseLibreria().setBorder(createTitledBorder(null, 
                "Usuario: "+usuario.getNombres()+" "+usuario.getApellidos()+"   "+"Rol: "+rol,
                TitledBorder.RIGHT, TitledBorder.BELOW_TOP, null, Color.WHITE)); 
        libreria.inicializarConVenta();
        frameInicio.getPnlBaseInicio().add(libreria.getPnlBaseLibreria());
        frameInicio.getPnlBaseInicio().updateUI();
        frameInicio.getMenuInicio().setVisible(true);
        
        }else{
            JOptionPane.showMessageDialog(null, "Acceso denegado!!!\nDatos erroneos");
            inicializarIngreso();
        }
         
    }
    
    private boolean identificacionCorrecta(String login, String contrasenia){
        boolean res=false;
        Usuario usuarioIdentificado = new Usuario();
        //Consultar a BD sobre usuario
        UsuarioDAO usuarioEntrante = new UsuarioDAO();
        usuarioIdentificado = usuarioEntrante.verificarUsuario(login, contrasenia);
           
        if(!usuarioIdentificado.getCiUsuario().equals("")){
            res = true;
            usuario = usuarioIdentificado;
        }        
        return res;
    }

    
    
}
