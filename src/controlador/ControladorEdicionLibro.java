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
    private Restriccion restriccion;
    private int tablaActual;
    
    public ControladorEdicionLibro(EdicionLibro edicionLibro, ControladorRegistroCompras controlador, int tablaActual){
        this.edicionLibro = edicionLibro;
        this.controlador = controlador;
        this.restriccion = new Restriccion();
        this.tablaActual = tablaActual;
        setListeners();
        iniciarFormulario();
    }
    
    private void setListeners(){
        edicionLibro.getBtnGuardar().addMouseListener(this);
        edicionLibro.getTxtTitulo().addKeyListener(this);
        edicionLibro.getTxtAutor().addKeyListener(this);
        edicionLibro.getTxtGenero().addKeyListener(this);
        edicionLibro.getTxtCantidadMinima().addKeyListener(this);
        edicionLibro.getTxtPrecioVenta().addKeyListener(this);
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
        char caracter = e.getKeyChar();
        if (e.getSource().equals(edicionLibro.getTxtTitulo())) {
            if(!Character.isLetter(e.getKeyChar()) && !Character.isDigit(e.getKeyChar())
                    && e.getKeyChar() != ' '){
                e.consume();
            }
        } else if (e.getSource().equals(edicionLibro.getTxtAutor())) {
            if(!Character.isLetter(e.getKeyChar()) && !Character.isDigit(e.getKeyChar())
                    && e.getKeyChar() != ' '){
                e.consume();
            }
        } else if (e.getSource().equals(edicionLibro.getTxtGenero())) {
            if(!Character.isLetter(e.getKeyChar())){
                e.consume();
            }
        } else if (e.getSource().equals(edicionLibro.getTxtCantidadMinima())) {
            if (!Character.isDigit(e.getKeyChar())){
            e.consume();
            }
        } else if (e.getSource().equals(edicionLibro.getTxtPrecioVenta())) {
            if (!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != '.'){
            e.consume();
        }
            if (e.getKeyChar() == '.' && edicionLibro.getTxtPrecioVenta().getText().contains(".")){
                e.consume();
            }
            if (edicionLibro.getTxtPrecioVenta().getText().length()>6){
                e.consume();
            }
        }
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

        boolean hayEspacios = verificarEspaciosForm(titulo, autor, genero);
        
        if (titulo.length() != 0 && autor.length() != 0 && genero.length() != 0
                && prVenta > 0 && cantidadMinima > 0 && !hayEspacios){
            LibroBD libroEditado = new LibroBD(titulo, autor, genero, edicion, cantidad,
                                   cantidadMinima, prCompra, prVenta);
            
            int tituloExistente = libroEditado.verificarTituloExiste(titulo, idLibro);
            
            if (tituloExistente == 0){
                libroEditado.actualizarLibroExistente(idLibro);
            
                if(tablaActual == 1){
                    controlador.llenarTodosLosLibrosTabla();
                } else {
                    controlador.llenarStockBajoTabla();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No puede haber 2 libros con el mismo nombre");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos para guardar la edición");
        }
            //ventana.establecerDatosTabla();
        edicionLibro.dispose();
    }
    
    private boolean verificarEspaciosForm(String titulo, String autor, String genero){
        boolean verificarTitulo = verificarEsp(titulo);
        boolean verificarAutor = verificarEsp(autor);
        boolean verificarGenero = verificarEsp(genero);
        if((!verificarAutor && !verificarTitulo && !verificarGenero)){
            return false;
        } else {
            return true;
        }
    }
    
    private boolean verificarEsp(String valor){
        int i = 0;
        int contador = 0;
        while(i < valor.length()){
            if(valor.charAt(i) != ' '){
                contador++;
            }
            i++;
        }
        
        if(contador != 0){
            //si hay almenos un caracter
            return false;
        }else{
            //si hay espacios solamente
            return true;
        }
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
