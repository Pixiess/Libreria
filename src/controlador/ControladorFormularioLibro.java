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
import modelo.Libro;
import vista.FormularioLibro;

/**
 *
 * @author Lourdes
 */
public class ControladorFormularioLibro implements MouseListener, KeyListener, FocusListener {
    private FormularioLibro formularioLibro;
    
    public ControladorFormularioLibro(FormularioLibro formularioLibro){
        this.formularioLibro = formularioLibro;
        setListeners();
        iniciarFormulario();
    }


    private void setListeners() {
        formularioLibro.getBtnAgregar().addMouseListener(this);
        formularioLibro.getBtnLimpiar().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(formularioLibro.getBtnAgregar())){
            registrarCompra();
        }
        else if(e.getSource().equals(formularioLibro.getBtnLimpiar())){
            limpiarRegistro();
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
    
    private void registrarCompra() {
        //Validar todos los campos y campos vacios
        int estaMarcado = formularioLibro.getFilaSeleccionada(); //variable de clase
        int idLibro = formularioLibro.getLibro().getIdLibro();  //variable de clase
        
        String titulo=formularioLibro.getTxtTitulo().getText();
        String autor=formularioLibro.getTxtAutor().getText();
        String genero=formularioLibro.getTxtGenero().getText();
        String edicion=formularioLibro.getTxtEdicion().getText();
        int cantidad=Integer.parseInt(formularioLibro.getTxtCantidad().getText());
        int minimo=Integer.parseInt(formularioLibro.getTxtCantidadMinima().getText());
        double prCompra=Double.parseDouble(formularioLibro.getTxtPrecioCompra().getText());
        double prVenta=Double.parseDouble(formularioLibro.getTxtPrecioVenta().getText());
        
        if(titulo.equals("") || autor.equals("") || genero.equals("") 
                || cantidad > 0 || minimo > 0 || prCompra > 0 || prVenta > 0){
            
            LibroBD libro = new LibroBD(titulo, autor, genero, edicion, cantidad,
                                            minimo, prCompra, prVenta); 
            if(estaMarcado == -1){
               
               libro.insertarLibroNuevo();
            }
            else{
               libro.insertarLibroExistente(idLibro);
            }        
        }
        formularioLibro.dispose();
    }
    
    private void iniciarFormulario() {
        int filaSeleccionada = formularioLibro.getFilaSeleccionada();
        Libro libro = formularioLibro.getLibro();
        if(filaSeleccionada != -1){
            llenarFormulario(libro);
            restringirCampos();
        }
    }
    
    private void llenarFormulario(Libro libro){
            //int id = libro.getIdLibro();
            String titulo=libro.getNombreLibro();
            System.out.println("Titulo: "+libro.getNombreLibro());
            String autor=libro.getAutorLibro();
            String genero=libro.getGenero();
            String edicion=libro.getEdicion();
            int minimo=libro.getStockMinimo();
            double prCompra=libro.getCostoCompra();
            double prVenta=libro.getCostoVenta();
            
            formularioLibro.getTxtTitulo().setText(titulo);
            formularioLibro.getTxtAutor().setText(autor);
            formularioLibro.getTxtGenero().setText(genero);
            formularioLibro.getTxtEdicion().setText(edicion);
            formularioLibro.getTxtCantidad().setText("1");
            formularioLibro.getTxtPrecioCompra().setText(String.valueOf(prVenta));
            formularioLibro.getTxtPrecioVenta().setText(String.valueOf(prCompra));
            formularioLibro.getTxtCantidadMinima().setText(String.valueOf(minimo));
            
            System.out.println("Text del formulario: "+formularioLibro.getTxtCantidadMinima().getText());
            
            
        
    }
    
    private void restringirCampos(){
        formularioLibro.getTxtTitulo().setEditable(false);
        formularioLibro.getTxtAutor().setEditable(false);
        formularioLibro.getTxtGenero().setEditable(false);
        //txtCantidadMinima.setEditable(false);
        formularioLibro.getTxtPrecioCompra().setEditable(false);
        formularioLibro.getTxtPrecioVenta().setEditable(false);
    }
    
    private void limpiarRegistro() {
        formularioLibro.getTxtTitulo().setText("");
        formularioLibro.getTxtAutor().setText("");
        formularioLibro.getTxtGenero().setText("");
        formularioLibro.getTxtEdicion().setText("");
        formularioLibro.getTxtCantidad().setText("");
        formularioLibro.getTxtPrecioCompra().setText("");
        formularioLibro.getTxtPrecioVenta().setText("");
        formularioLibro.getTxtCantidadMinima().setText("");
        
        //habilitar todo
        formularioLibro.getTxtTitulo().setEditable(true);
        formularioLibro.getTxtAutor().setEditable(true);
        formularioLibro.getTxtGenero().setEditable(true);
        //txtCantidadMinima.setEditable(false);
        formularioLibro.getTxtPrecioCompra().setEditable(true);
        formularioLibro.getTxtPrecioVenta().setEditable(true);
        
        Libro libro = new Libro();
        formularioLibro= new FormularioLibro(new javax.swing.JFrame(), true, -1, libro);
    }
}
