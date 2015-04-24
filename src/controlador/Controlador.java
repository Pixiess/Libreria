/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import modelo.Libro;
import vista.RegistroVentas;

/**
 *
 * @author A
 */

public class Controlador implements ActionListener, MouseListener, ChangeListener, WindowListener {

    RegistroVentas rVenta;
    
    public void setComponents(RegistroVentas rv)
    {
        rVenta = rv;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public void mouseClicked(MouseEvent e) 
    {
        Component componente = (Component)e.getSource();
        
        if(componente.isEnabled())
        {
            if(e.getSource() == rVenta.getAgregar())
                agregarL(e);
            else if(e.getSource() == rVenta.getEliminar())
                eliminarL(e);
                
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
    public void stateChanged(ChangeEvent e) {}

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {}

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) { }

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
     
    private void agregarL(MouseEvent e)
    {
       Libro libro = new Libro(1, "El Resplandor", "Stephen King", "Novela terror", 12, 30.0, 35.0);
       
       String [] datos = {"2", libro.getNombreLibro(), libro.getAutorLibro(), ""+libro.getCostoVenta(), "12"};        
       
       rVenta.anadirFilaVenta(datos);
       
       
       
       
       
    }
    
    private void eliminarL(MouseEvent e)
    {
        
        int countRow = rVenta.getVentaTabla().getRowCount();
        
        if(countRow > 0)
        {
            int row = rVenta.getVentaTabla().getSelectedRow();
            if(row >= 0)
            {
                rVenta.eliminarFilaVenta(row);
                rVenta.eliminarLibVenta(row);
            }
            else
                 JOptionPane.showMessageDialog(null, "Seleccione una fila a eliminar");
        }

    }
    
}
