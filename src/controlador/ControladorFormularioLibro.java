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
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Libro;
import vista.FormularioLibro;

/**
 *
 * @author Lourdes
 */
public class ControladorFormularioLibro implements MouseListener, KeyListener, FocusListener {
    
    private FormularioLibro formularioLibro;
    private Restriccion restriccion;
    
    public ControladorFormularioLibro(FormularioLibro formularioLibro){
        this.formularioLibro = formularioLibro;
        restriccion = new Restriccion();
        setListeners();
        iniciarFormulario();
    }

    private void setListeners() {
        formularioLibro.getBtnAgregar().addMouseListener(this);
        formularioLibro.getBtnLimpiar().addMouseListener(this);
        formularioLibro.getTxtTitulo().addKeyListener(this);
        formularioLibro.getTxtAutor().addKeyListener(this);
        formularioLibro.getTxtGenero().addKeyListener(this);
        formularioLibro.getTxtEdicion().addKeyListener(this);
        formularioLibro.getTxtCantidad().addKeyListener(this);
        formularioLibro.getTxtPrecioCompra().addKeyListener(this);
        formularioLibro.getTxtPrecioVenta().addKeyListener(this);
        formularioLibro.getTxtCantidadMinima().addKeyListener(this);
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
        
        if (e.getSource().equals(formularioLibro.getTxtTitulo())) {
            if (!restriccion.esTextoNumero(caracter, 50, formularioLibro.getTxtTitulo())) {
                e.consume();
            }
        } else if (e.getSource().equals(formularioLibro.getTxtAutor())) {
            if (!restriccion.esTexto(caracter, 50, formularioLibro.getTxtAutor())) {
                e.consume();
            }
        } else if (e.getSource().equals(formularioLibro.getTxtGenero())) {
            if (!restriccion.esTexto(caracter, 30, formularioLibro.getTxtGenero())) {
                e.consume();
            }
        } else if (e.getSource().equals(formularioLibro.getTxtEdicion())) {
            if (!restriccion.esTexto(caracter, 20, formularioLibro.getTxtEdicion())) {
                e.consume();
            }
        } else if (e.getSource().equals(formularioLibro.getTxtCantidad())) {
            if (!restriccion.esEntero(caracter, 4, formularioLibro.getTxtCantidad())) {
                e.consume();
            }

        } else if (e.getSource().equals(formularioLibro.getTxtPrecioCompra())) {
            if (!restriccion.esDecimal(caracter, 7, formularioLibro.getTxtPrecioCompra())) {
                e.consume();
            }
        } else if (e.getSource().equals(formularioLibro.getTxtPrecioVenta())) {
            if (!restriccion.esDecimal(caracter, 7, formularioLibro.getTxtPrecioVenta())) {
                e.consume();
            }
        } else if (e.getSource().equals(formularioLibro.getTxtCantidadMinima())) {
            if (!restriccion.esEntero(caracter, 3, formularioLibro.getTxtCantidadMinima())) {
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
    
    private void registrarCompra() {
        //Validar todos los campos y campos vacios
        int estaMarcado = formularioLibro.getFilaSeleccionada(); //variable de clase
        int idLibro = formularioLibro.getLibro().getIdLibro();  //variable de clase
        
        String titulo=formularioLibro.getTxtTitulo().getText();
        String autor=formularioLibro.getTxtAutor().getText();
        String genero=formularioLibro.getTxtGenero().getText();
        String edicion=formularioLibro.getTxtEdicion().getText();
        String cantidadText = formularioLibro.getTxtCantidad().getText();
        String minimoText = formularioLibro.getTxtCantidadMinima().getText();
        String prCompraText = formularioLibro.getTxtPrecioCompra().getText();
        String prVentaText = formularioLibro.getTxtPrecioVenta().getText();
               
        if (titulo.equals("") || autor.equals("") || genero.equals("") || edicion.equals("")
                || cantidadText.equals("") || minimoText.equals("") || prCompraText.equals("")
                || prVentaText.equals("")) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos para registrar la compra");

        } else if (titulo.startsWith(" ") || autor.startsWith(" ") || genero.startsWith(" ")
                || edicion.startsWith(" ") || prCompraText.startsWith(".")
                || prVentaText.startsWith(".") || prCompraText.startsWith("0")
                || prVentaText.startsWith("0") || cantidadText.startsWith("0")
                || minimoText.startsWith("0")) {
            JOptionPane.showMessageDialog(null, "Llene correctamente los campos\n "
                    + "Evite comenzar con espacios, puntos\n o valor cero");
        } else {   
            int cantidad=Integer.parseInt(formularioLibro.getTxtCantidad().getText());
            int minimo=Integer.parseInt(formularioLibro.getTxtCantidadMinima().getText());
            double prCompra=Double.parseDouble(formularioLibro.getTxtPrecioCompra().getText());
            double prVenta=Double.parseDouble(formularioLibro.getTxtPrecioVenta().getText());
            String fecha = formularioLibro.getTxtFecha().getText();
            double total = cantidad*prCompra;
            
            
            DecimalFormatSymbols dfs = new DecimalFormatSymbols();
            dfs.setDecimalSeparator('.');
            DecimalFormat df = new DecimalFormat("0.00", dfs);
            prCompra = Double.parseDouble(df.format(prCompra));
            prVenta = Double.parseDouble(df.format(prVenta));
            
            LibroBD libro = new LibroBD(titulo, autor, genero, edicion, cantidad,
                                            minimo, prCompra, prVenta); 
            if(estaMarcado == -1){
               
               libro.insertarLibroNuevo();
            }
            else{
               libro.insertarLibroExistente(idLibro);
            } 
            
            //Poner insercion a compra y detalle compra 
            CompraDAO compra = new CompraDAO(fecha, cantidad, total);
            compra.insertarCompraBD();
            int idCompra = compra.getUltimaCompra();
            
            int idLibro1 = libro.getIdLibro(titulo, autor, genero, edicion);            
            DetalleCompraDAO detalleCompra = new DetalleCompraDAO(idLibro1, idCompra);
            detalleCompra.insertarDetalleCompraBD();
            
            formularioLibro.dispose();
        }
        
    }
    
    private void iniciarFormulario() {
        int filaSeleccionada = formularioLibro.getFilaSeleccionada();
        Libro libro = formularioLibro.getLibro();
        if(filaSeleccionada != -1){
            llenarFormulario(libro);
            restringirCampos();
        }
        ponerFecha();
    }
    
    private void llenarFormulario(Libro libro){
            //int id = libro.getIdLibro();
            String titulo=libro.getNombreLibro();
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
            formularioLibro.getTxtPrecioCompra().setText(String.valueOf(prCompra));
            formularioLibro.getTxtPrecioVenta().setText(String.valueOf(prVenta));
            formularioLibro.getTxtCantidadMinima().setText(String.valueOf(minimo));
                    
    }
    
    private void restringirCampos(){
        formularioLibro.getTxtTitulo().setEditable(false);
        formularioLibro.getTxtAutor().setEditable(false);
        formularioLibro.getTxtGenero().setEditable(false);
        //txtCantidadMinima.setEditable(false);
        //formularioLibro.getTxtPrecioCompra().setEditable(false);
        //formularioLibro.getTxtPrecioVenta().setEditable(false);
    }
    
    private void ponerFecha() {
        Date fec = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = sdf.format(fec);
        formularioLibro.getTxtFecha().setText(fecha);
        formularioLibro.getTxtFecha().setEditable(false);
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
