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
import javax.swing.JOptionPane;
import modelo.Libro;
import vista.EdicionLibro;

/**
 *
 * @author USUARIO
 */
public class ControladorEdicionLibro implements MouseListener, KeyListener, FocusListener{

    private EdicionLibro edicionLibro;
    private ControladorRegistroCompras controlador;
    private int tablaActual;
    
    public ControladorEdicionLibro(EdicionLibro edicionLibro, ControladorRegistroCompras controlador, int tablaActual){
        this.edicionLibro = edicionLibro;
        this.controlador = controlador;
        this.tablaActual = tablaActual;
        setListeners();
        iniciarFormulario();
    }
    
    private void setListeners(){
        edicionLibro.getBtnGuardar().addMouseListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(edicionLibro.getBtnGuardar())){
            guardarCambios();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void focusGained(FocusEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void focusLost(FocusEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void guardarCambios(){
        
        int estaMarcado = edicionLibro.getFilaSeleccionada(); //variable de clase
        int idLibro = edicionLibro.getLibro().getIdLibro(); 
        //Variables que rescatan los cambios hechos en el formulario de edicion
        String titulo = edicionLibro.getTxtTitulo().getText();
        String autor = edicionLibro.getTxtAutor().getText();
        String genero = edicionLibro.getTxtGenero().getText();
        double prVenta = Double.parseDouble((String)edicionLibro.getTxtPrecioVenta().getText());
        int cantidadMinima = Integer.parseInt(edicionLibro.getTxtCantidadMinima().getText());

        //Variables que recuperan los datos que no pueden ser cambiados en el formulario de edicion
        String edicion = edicionLibro.getLibro().getEdicion();
        int cantidad = edicionLibro.getLibro().getStockDisponible();
        double prCompra = edicionLibro.getLibro().getCostoCompra();

        if(titulo.equals("") || autor.equals("") || genero.equals("") 
                || prVenta >= 0 || cantidadMinima >= 0){
            LibroBD libroEditado = new LibroBD(titulo, autor, genero, edicion, cantidad,
                                   cantidadMinima, prCompra, prVenta);
            libroEditado.actualizarLibroExistente(idLibro);
            
            if(tablaActual == 1){
                controlador.llenarTodosLosLibrosTabla();
            } else {
                controlador.llenarStockBajoTabla();
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos para guardar la edición");
        }
            //ventana.establecerDatosTabla();
        edicionLibro.dispose();
    }
    
    private void iniciarFormulario() {
        int filaSeleccionada = edicionLibro.getFilaSeleccionada();
        Libro libro = edicionLibro.getLibro();
        if(filaSeleccionada != -1){
            llenarCampos(libro);
        }
    }
    
    public void llenarCampos(Libro libro){
        String titulo=libro.getNombreLibro();
        String autor=libro.getAutorLibro();
        String genero=libro.getGenero();
        int minimo=libro.getStockMinimo();
        double prVenta=libro.getCostoVenta();
            
        edicionLibro.getTxtTitulo().setText(titulo);
        edicionLibro.getTxtAutor().setText(autor);
        edicionLibro.getTxtGenero().setText(genero);
        edicionLibro.getTxtPrecioVenta().setText(String.valueOf(prVenta));
        edicionLibro.getTxtCantidadMinima().setText(String.valueOf(minimo));
    }
    
}
