
package controlador;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import vista.RegistroUsuario;


public class ControladorRegistroUsuario implements MouseListener, KeyListener, FocusListener 
{
    private RegistroUsuario registroUsuario;
    private Restriccion restriccion;
    
     public ControladorRegistroUsuario (RegistroUsuario registroUsuario){
        this.registroUsuario = registroUsuario;
        restriccion = new Restriccion();
        setListeners();
        
    }
    
    private void setListeners()
    {
        registroUsuario.getTxtNombreUsuario().addKeyListener(this);
        registroUsuario.getPassContrasena().addKeyListener(this);
        registroUsuario.getTxtNombres().addKeyListener(this);
        registroUsuario.getTxtApellidos().addKeyListener(this);
        registroUsuario.getTxtTelefono().addKeyListener(this);
        registroUsuario.getTxtCorreo().addKeyListener(this);
        registroUsuario.getTxtCi().addKeyListener(this);
        registroUsuario.getBtnAceptar().addMouseListener(this);
    }
     
    @Override
    public void mouseClicked(MouseEvent e) 
    {
       if(e.getSource().equals(registroUsuario.getBtnAceptar())){
            registrar();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void keyTyped(KeyEvent e)
    {
        char caracter = e.getKeyChar();
 
       if (e.getSource().equals(registroUsuario.getTxtNombreUsuario())) {
            if (!restriccion.esTextoNumero(caracter, 30, registroUsuario.getTxtNombreUsuario())) {
                e.consume();
            }
        } else if (e.getSource().equals(registroUsuario.getPassContrasena())) {
            if (!restriccion.esTextoNumero(caracter, 30, registroUsuario.getPassContrasena())) {
                e.consume();
            }
        } else if (e.getSource().equals(registroUsuario.getTxtNombres())) {
            if (!restriccion.esTexto(caracter, 50, registroUsuario.getTxtNombres())) {
                e.consume();
            }
        } else if (e.getSource().equals(registroUsuario.getTxtApellidos())) {
            if (!restriccion.esTexto(caracter, 50, registroUsuario.getTxtApellidos())) {
                e.consume();
            }
        } else if (e.getSource().equals(registroUsuario.getTxtTelefono())) {
            if (!restriccion.esEntero(caracter, 8, registroUsuario.getTxtTelefono())) {
                e.consume();
            }
        } else if (e.getSource().equals(registroUsuario.getTxtCorreo())) {
            if (!restriccion.esCorreo(caracter, 30, registroUsuario.getTxtCorreo())) {
                e.consume();
            }
        } else if (e.getSource().equals(registroUsuario.getTxtCi())) {
            if (!restriccion.esEntero(caracter, 7, registroUsuario.getTxtCi())) {
                e.consume();
            }
        } 
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void focusGained(FocusEvent e) {}

    @Override
    public void focusLost(FocusEvent e) {}

    private void registrar()
    {
        
    }
    
}
