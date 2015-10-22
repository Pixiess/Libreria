/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Rectangle;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Libro;
import vista.EdicionLibro;
import vista.FormularioLibro;
import vista.JTextFieldP;
import vista.RegistroCompras;
import vista.RegistroCompras2;

/**
 *
 * @author Veymar Montaño Colqu
 */
public class ControladorRegistroCompras2 implements ActionListener, MouseListener, KeyListener, FocusListener, PropertyChangeListener{

    private RegistroCompras2 registroCompras;
    
    private JScrollPane scrollPanel;
    private JTable tablaDesplegable;
    private final String[] titulosTabla = {"TITULO","AUTOR","GENERO","EDICION",
                  "CATIDAD","COMPRA","VENTA","MINIMO"};
    
    private JTextFieldP txtTitulo;
    private JTextFieldP txtAutor;
    private JTextFieldP txtGenero;
    private JTextFieldP txtEdicion;
    private JTextFieldP txtCantidad;
    private JTextFieldP txtPrecioCompra;
    private JTextFieldP txtPrecioVenta;
    private JTextFieldP txtCantidadMinima;
    
    private JComboBox comboBoxBuscarEn;    
    
    private JButton btnLimpiar;
    private JButton btnAgregar;
    
    public ControladorRegistroCompras2(RegistroCompras2 registroCompras) {
        this.registroCompras = registroCompras;
        setComponents();
        
        inicializarRegistroCompras();
    }

    public void inicializarRegistroCompras() {
        scrollPanel.setVisible(false);
        limpiar();
    }
    
    public void limpiar(){
        comboBoxBuscarEn.setSelectedIndex(0);
        
        txtTitulo.setText("");
        txtAutor.setText("");
        txtGenero.setText("");
        txtEdicion.setText("");
        txtCantidad.setText("");
        txtPrecioCompra.setText("");
        txtPrecioVenta.setText("");
        txtCantidadMinima.setText("");
    }
    
    private void setComponents(){
        txtTitulo = registroCompras.getTxtTitulo();
        txtAutor = registroCompras.getTxtAutor();
        txtGenero = registroCompras.getTxtGenero();
        txtEdicion = registroCompras.getTxtEdicion();
        txtCantidad = registroCompras.getTxtCantidad();
        txtPrecioCompra = registroCompras.getTxtPrecioCompra();
        txtPrecioVenta = registroCompras.getTxtPrecioVenta();
        txtCantidadMinima = registroCompras.getTxtCantidadMinima();
        
        comboBoxBuscarEn = registroCompras.getComboBoxBuscarEn();
        btnAgregar = registroCompras.getBtnAgregar();
        btnLimpiar = registroCompras.getBtnLimpiar();
        scrollPanel = registroCompras.getScrollPanel();
        tablaDesplegable = registroCompras.getTablaDesplegable();
        
        setListeners();
    }
    
    private void setListeners() {
        txtTitulo.addActionListener(this);
        txtAutor.addActionListener(this);
        txtGenero.addActionListener(this);
        txtEdicion.addActionListener(this);
        
        txtTitulo.addMouseListener(this);
        txtAutor.addMouseListener(this);
        txtGenero.addMouseListener(this);
        txtEdicion.addMouseListener(this); 
        
        txtTitulo.addKeyListener(this);
        txtAutor.addKeyListener(this);
        txtGenero.addKeyListener(this);
        txtEdicion.addKeyListener(this); 
        
        btnLimpiar.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ocultarTabla();
        
        if(e.getSource().equals(btnLimpiar)){
            limpiar();
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
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
            ocultarTabla();
        }
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

    @Override
    public void actionPerformed(ActionEvent e) {
        mostrarTabla();
    }
    
    private void mostrarTabla(){
        scrollPanel.setVisible(true);
    }
    
    private void ocultarTabla(){
        scrollPanel.setVisible(false);
    }

}
