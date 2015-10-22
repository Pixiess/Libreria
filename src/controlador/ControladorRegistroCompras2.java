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
    private DefaultTableModel modeloTablaDesplegable;
    private final String[] titulosTabla = {"TITULO","AUTOR","GENERO","EDICION",
                  "CANTIDAD","COMPRA","VENTA","MINIMO"};
    private ArrayList<Libro> librosDeLaTabla;
    private ArrayList<Libro> librosCarritoCompra;
    
    private Restriccion restriccion;
    
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
        restriccion =new Restriccion();
        librosDeLaTabla = new ArrayList();
        librosCarritoCompra = new ArrayList();
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
        modeloTablaDesplegable = (DefaultTableModel)tablaDesplegable.getModel();
        
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
        
        tablaDesplegable.addMouseListener(this);
        
        btnLimpiar.addMouseListener(this);
        btnAgregar.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ocultarTabla();
        
        if(e.getSource().equals(btnLimpiar)){
            limpiar();
        } else if (e.getSource().equals(tablaDesplegable)) {
            llenarLibroSeleccionado();
        } else if(e.getSource().equals(btnAgregar)){
            aniadirLibroCarrito();
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
        
        if (e.getSource().equals(registroCompras.getTxtTitulo())) {
            if (!restriccion.esTextoNumero(caracter, 50, registroCompras.getTxtTitulo())) {
                e.consume();
            }
        } else if (e.getSource().equals(registroCompras.getTxtAutor())) {
            if (!restriccion.esTexto(caracter, 50, registroCompras.getTxtAutor())) {
                e.consume();
            }
        } else if (e.getSource().equals(registroCompras.getTxtGenero())) {
            if (!restriccion.esTexto(caracter, 30, registroCompras.getTxtGenero())) {
                e.consume();
            }
        } else if (e.getSource().equals(registroCompras.getTxtEdicion())) {
            if (!restriccion.esTexto(caracter, 20, registroCompras.getTxtEdicion())) {
                e.consume();
            }
        } else if (e.getSource().equals(txtCantidad)) {
            if (!restriccion.esEntero(caracter, 7, txtCantidad)) {
                e.consume();
            }
        } else if (e.getSource().equals(registroCompras.getTxtPrecioCompra())) {
            if (!restriccion.esDecimal(caracter, 7, registroCompras.getTxtPrecioCompra())) {
                e.consume();
            }
        } else if (e.getSource().equals(registroCompras.getTxtPrecioVenta())) {
            if (!restriccion.esDecimal(caracter, 7, registroCompras.getTxtPrecioVenta())) {
                e.consume();
            }
        } else if (e.getSource().equals(registroCompras.getTxtCantidadMinima())) {
            if (!restriccion.esEntero(caracter, 3, registroCompras.getTxtCantidadMinima())) {
                e.consume();
            }
        }
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
        capturarLetras();
    }
    
    private void mostrarTabla(){
        scrollPanel.setVisible(true);
    }
    
    private void ocultarTabla(){
        scrollPanel.setVisible(false);
    }
    
    //PRIMERA PARTE CAPTURA DE DATOS
    private void capturarLetras(){
        
        String opcion = "";
        if(comboBoxBuscarEn.getSelectedIndex()==0){
            opcion="listaLibros";
        }
        if(comboBoxBuscarEn.getSelectedIndex()==1){
            opcion="control stock";
        }
        if(comboBoxBuscarEn.getSelectedIndex()==2){
            opcion="dados de baja";
        }
        
        
        Libro datosLibro = new Libro(0,"","","","",0,0,0);
        datosLibro.setNombreLibro(registroCompras.getTxtTitulo().getText());
        datosLibro.setAutorLibro(registroCompras.getTxtAutor().getText());
        datosLibro.setGenero(registroCompras.getTxtGenero().getText());
        datosLibro.setEdicion(registroCompras.getTxtEdicion().getText()); 
        
        BuscarLDAO buscadorLibros = new BuscarLDAO();
        ArrayList<Libro> libros = buscadorLibros.buscarLibros(datosLibro, opcion);
        librosDeLaTabla = libros;
        
        llenarLibrosTabla(libros);        
    }
    
    private void llenarLibrosTabla(ArrayList<Libro> libros){
        ArrayList<Libro> librosTabla = libros;
        llenarTabla(librosTabla);
    }
    
    private void llenarTabla(ArrayList<Libro> libros) {
        Object[][] datosTabla = conseguirDatosTabla(libros);
        modeloTablaDesplegable.setDataVector(datosTabla, titulosTabla);
    }

    private Object[][] conseguirDatosTabla(ArrayList<Libro> librosTabla) {
        Object[][] respuesta = new Object[librosTabla.size()][];

        for (int i = 0; i < librosTabla.size(); i++) {
            respuesta[i] = devolverDatosLibro(librosTabla.get(i));
        }
        return respuesta;
    }

    private Object[] devolverDatosLibro(Libro libro) {
        Object[] respuesta = new Object[8];

        //respuesta[0] = libro.getIdLibro();
        respuesta[0] = libro.getNombreLibro();
        respuesta[1] = libro.getAutorLibro();
        respuesta[2] = libro.getGenero();  
        respuesta[3] = libro.getEdicion();            
        respuesta[4] = libro.getStockDisponible();
        //respuesta[4] = txtCantidad.getText();  
        respuesta[5] = libro.getCostoCompra();
        respuesta[6] = libro.getCostoVenta();
        respuesta[7] = libro.getStockMinimo();

        return respuesta;
    }
    
    private void llenarLibroSeleccionado() {
        int filaSeleccionada = tablaDesplegable.getSelectedRow();
        if (filaSeleccionada == -1) {
            //JOptionPane.showMessageDialog(null, "Seleccione una fila para editar el libro");
        } else {
            Libro libroSeleccionado = buscarLibroSeleccionado();
            llenarCampos(libroSeleccionado);
            //registroCompras.getTxtStockDisponible().setEditable(false);
        }
    }

    private Libro buscarLibroSeleccionado() {
        Libro res = new Libro();
        int fila = tablaDesplegable.getSelectedRow();
        
        res = librosDeLaTabla.get(fila);
        return res;
    }
    
    private void llenarCampos(Libro libro){
        registroCompras.getTxtTitulo().setText(libro.getNombreLibro());
        registroCompras.getTxtAutor().setText(libro.getAutorLibro());
        registroCompras.getTxtGenero().setText(libro.getGenero());
        registroCompras.getTxtEdicion().setText(libro.getEdicion());
        //registroCompras.getTxtCantidad().setText(""+libro.getStockDisponible());
        registroCompras.getTxtCantidad().setText("1");
        registroCompras.getTxtPrecioCompra().setText(""+libro.getCostoCompra());
        registroCompras.getTxtPrecioVenta().setText(""+libro.getCostoVenta());
        registroCompras.getTxtCantidadMinima().setText(""+libro.getStockMinimo());
    }
    
    //CUARTA PARTE AAÑADIR LIBRO AL CARRITO DE COMPRAS
    private void aniadirLibroCarrito(){
        Libro libro = new Libro();
        
        String titulo=registroCompras.getTxtTitulo().getText();
        String autor=registroCompras.getTxtAutor().getText();
        String genero=registroCompras.getTxtGenero().getText();
        String edicion=registroCompras.getTxtEdicion().getText();
        //String stockDisponible=registroCompras.getTxtStockDisponible().getText();
        String cantidadText = registroCompras.getTxtCantidad().getText();       
        String prCompraText = registroCompras.getTxtPrecioCompra().getText();
        String prVentaText = registroCompras.getTxtPrecioVenta().getText();
        String minimoText = registroCompras.getTxtCantidadMinima().getText();
        
        
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
        //libro.setIdLibro();
        libro.setNombreLibro(registroCompras.getTxtTitulo().getText());
        libro.setAutorLibro(registroCompras.getTxtAutor().getText());
        libro.setGenero(registroCompras.getTxtGenero().getText());      
        libro.setEdicion(registroCompras.getTxtEdicion().getText());         
        //libro.setStockDisponible(Integer.parseInt(registroCompras.getTxtStockDisponible().getText()));
        libro.setCantidadCompra(Integer.parseInt(registroCompras.getTxtCantidad().getText()));
        libro.setCostoCompra(Double.parseDouble(registroCompras.getTxtPrecioCompra().getText()));
        libro.setCostoVenta(Double.parseDouble(registroCompras.getTxtPrecioVenta().getText()));
        libro.setStockMinimo(Integer.parseInt(registroCompras.getTxtCantidadMinima().getText()));
        
        librosCarritoCompra.add(libro);
        limpiar();
        }
        
        verLibrosCarrito();  //solo para comprobar
                
    }
    
    private void verLibrosCarrito(){
        
        for (int i = 0; i< librosCarritoCompra.size(); i++){
            System.out.println(librosCarritoCompra.get(i).getNombreLibro());
        }
    }
   
    public ArrayList<Libro> getLibrosCarrito(){
        return librosCarritoCompra;
    }
}
