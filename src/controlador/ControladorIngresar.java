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
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import modelo.Usuario;
import vista.Ingresar;
import vista.Inicio;
import vista.Libreria;

/**
 *
 * @author lourdes
 */
public class ControladorIngresar implements MouseListener, KeyListener, FocusListener, ActionListener {
    
    private Ingresar inicioSesion;
    private Inicio frameInicio;
    private Restriccion restriccion;
    private Usuario usuario;
    
    
    public ControladorIngresar(Ingresar ini, Inicio frameInicio){
       inicioSesion = ini;
       this.frameInicio = frameInicio;
       restriccion = new Restriccion();
       usuario = new Usuario();
       setListeners();
       //inicializarIngreso();
    }
    
    public void inicializarIngreso(){
        //frameInicio.getItemSalir().setVisible(false);
        inicioSesion.getTxtLogin().setText("");
        inicioSesion.getPswdContrasenia().setText("");
    }
    
    private void setListeners(){
        //frameInicio.getMenuInicio().addMouseListener(this);
        //frameInicio.getItemIngresar().addActionListener(this);
        //frameInicio.getItemSalir().addMouseListener(this);
        inicioSesion.getBtnAceptar().addMouseListener(this);
        inicioSesion.getTxtLogin().addKeyListener(this);
        inicioSesion.getPswdContrasenia().addKeyListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(frameInicio.getItemIngresar())){
            //mostrarIngresar();
        }else if(e.getSource().equals(frameInicio.getItemSalir())){
            //mostrarInicio();
        }else if(e.getSource().equals(inicioSesion.getBtnAceptar())){
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
        
        if (e.getSource().equals(inicioSesion.getTxtLogin())) {
            if (!restriccion.esTextoNumeroSinEspacio(caracter, 50, inicioSesion.getTxtLogin())) {
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
    
    private void mostrarIngresar(){
        inicioSesion.setVisible(true);
    }
    
    private void mostrarInicio(){
        
    }
    
    private void iniciarSesion(){        
        String contrasenia = inicioSesion.getPswdContrasenia().getText();
        String login = inicioSesion.getTxtLogin().getText();
        String rol = "";
        
        if(identificacionCorrecta(login, contrasenia)){
        Libreria libreria = new Libreria();
        if(usuario.getRol()==1){
            rol="Administrador";            
        }else{
            rol="Vendedor";
        }
        frameInicio.getPnlBaseInicio().removeAll();
        libreria.getPnlBaseLibreria().setBorder(createTitledBorder(null, 
                "Usuario: "+usuario.getNombres()+" "+usuario.getApellidos()+"   "+"Rol: "+rol,
                TitledBorder.RIGHT, TitledBorder.BELOW_TOP, null, Color.WHITE));        
        frameInicio.getPnlBaseInicio().add(libreria.getPnlBaseLibreria());
        frameInicio.getPnlBaseInicio().updateUI();
        inicioSesion.setVisible(false);
        
        frameInicio.getItemIngresar().setVisible(false);
        frameInicio.getItemSalir().setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Acceso denegado!!!\nDatos erroneos");
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
