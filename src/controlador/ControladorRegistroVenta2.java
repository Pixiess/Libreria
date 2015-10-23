/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import modelo.Libro;
import modelo.UsuarioActual;
import vista.ActualizarCliente;
import vista.JTextFieldP;
import vista.RegistroVenta2;
import vista.RegistroVentas;

/**
 *
 * @author pcs
 */
public class ControladorRegistroVenta2 implements ActionListener, MouseListener, ChangeListener, WindowListener, KeyListener{

    private RegistroVenta2 registroVentas;
    
    private JScrollPane scrollPanel;
    private JTable tablaDesplegable;
    private DefaultTableModel modeloTablaDesplegable;
    //private final String[] titulosTabla = {"ID","TITULO","EDICION","TEMA","AUTOR"};
    private final String[] titulosTabla = {"TITULO","AUTOR","GENERO","EDICION",
                  "CANTIDAD","COMPRA","VENTA","MINIMO"};
    private ArrayList<Libro> librosDeLaTabla;
    private ArrayList<Libro> librosCarritoVenta;
    private ArrayList<String>libros; //Donde Ale compara buscador
    
    private Restriccion restriccion;
    private int bandera;
    
    private JTextFieldP txtTitulo;
    private JTextFieldP txtAutor;
    private JTextFieldP txtGenero;
    private JTextFieldP txtEdicion;
    private JTextFieldP txtCantidad;
    private JTextFieldP txtPrecio;
    
    
    private String fechaTabla;
    private JTextField txtNit;
    private JTextField txtCliente;
    private JTextField txtTotal;
    
    private JComboBox comboBoxBuscarEn;    
    
    private JButton btnAgregar;
    private JButton btnLimpiar;
    private JButton btnEliminar;
    private JButton btnFactura;
    
    private JTable tablaVenta; //tabla carrtitoVenta
    
    public ControladorRegistroVenta2(RegistroVenta2 registroVentas) {
        this.registroVentas = registroVentas;
        setComponents();
        
        inicializarRegistroVentas();
    }

    public void inicializarRegistroVentas() {
        scrollPanel.setVisible(false);
        restriccion =new Restriccion();
        librosDeLaTabla = new ArrayList();
        librosCarritoVenta = new ArrayList();
        libros = new ArrayList<String>();
        fechaTabla = ponerFecha();
        limpiarCampos();
        txtPrecio.setEditable(false);
    }
    
    private void limpiarCampos(){
        txtNit.setText("");
        txtCliente.setText("");
        txtTotal.setText("0.00");
        
        limpiar();
    }
    
    public void limpiar(){
        comboBoxBuscarEn.setSelectedIndex(0);
        
        txtTitulo.setText("");
        txtAutor.setText("");
        txtGenero.setText("");
        txtEdicion.setText("");
        txtPrecio.setText("");
        
        txtCantidad.setText("");
        
        
    }
    
    private String ponerFecha() {        
        Date fec = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = sdf.format(fec);
        return fecha;
    }
    
    private void setComponents(){
        txtTitulo = registroVentas.getTxtTitulo();
        txtAutor = registroVentas.getTxtAutor();
        txtGenero = registroVentas.getTxtGenero();
        txtEdicion = registroVentas.getTxtEdicion();
        txtPrecio = registroVentas.getTxtPrecio();
        txtCantidad = registroVentas.getTxtCantidad();
        
        txtNit = registroVentas.getTxtNit();
        txtCliente = registroVentas.getTxtCliente();
        txtTotal = registroVentas.getTxtTotal();
                
        comboBoxBuscarEn = registroVentas.getComboBoxBuscarEn();
        btnAgregar = registroVentas.getBtnAgregar();
        btnLimpiar = registroVentas.getBtnLimpiar();
        btnEliminar = registroVentas.getBtnEliminar();
        btnFactura = registroVentas.getBtnVender();
        scrollPanel = registroVentas.getScrollPanel();
        tablaDesplegable = registroVentas.getTablaDesplegable();
        modeloTablaDesplegable = (DefaultTableModel)tablaDesplegable.getModel();
        tablaVenta = registroVentas.getTablaVenta();
        
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
        txtCantidad.addKeyListener(this);
        txtPrecio.addKeyListener(this);
        txtNit.addKeyListener(this);
        txtCliente.addKeyListener(this);
        
        tablaDesplegable.addMouseListener(this);
        
        btnAgregar.addMouseListener(this);
        btnLimpiar.addMouseListener(this);
        btnEliminar.addMouseListener(this);
        btnFactura.addMouseListener(this);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        mostrarTabla();
        enviarDatosBuscador();        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ocultarTabla();
        
        if (e.getSource().equals(tablaDesplegable)) {
            llenarLibroSeleccionado();
            deshabilitarCampos();
        }else if (e.getSource().equals(btnAgregar)){
               aniadirLibroCarrito();
               habilitarCampos();
        }else if (e.getSource().equals(btnLimpiar)) {
                limpiar();
                habilitarCampos();
        }else if (e.getSource().equals(btnFactura)) {
                registrarVenta();
        } else if (e.getSource().equals(btnEliminar)) {
               eliminarFilaTabla();
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
    public void stateChanged(ChangeEvent e) {
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char caracter = e.getKeyChar();
        if (e.getSource().equals(txtCliente)) {
            if (!restriccion.esTexto(e.getKeyChar(), 50, txtCliente)) {
                e.consume();
            }
        } else if (e.getSource().equals(txtNit)) {
            if (!Character.isDigit(e.getKeyChar()) || txtNit.getText().length() > 9) {
                e.consume();
            }
        } else if (e.getSource().equals(txtTitulo)) {
            if (!restriccion.esTextoNumero(caracter, 50, txtTitulo)) {
                e.consume();
            }
        } else if (e.getSource().equals(txtAutor)) {
            if (!restriccion.esTexto(caracter, 50, txtAutor)) {
                e.consume();
            }
        } else if (e.getSource().equals(txtGenero)) {
            if (!restriccion.esTexto(caracter, 30, txtGenero)) {
                e.consume();
            }
        } else if (e.getSource().equals(txtEdicion)) {
            if (!restriccion.esTexto(caracter, 20, txtEdicion)) {
                e.consume();
            }
        } else if (e.getSource().equals(txtCantidad)) {
            if (!restriccion.esEntero(caracter, 5, txtCantidad)) {
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
        if (e.getSource().equals(txtNit)) {
            if(txtNit.getText().length() > 5 || txtNit.getText().length() > 8){
                buscarCliente(txtNit.getText());
            }
            if(txtNit.getText().length() < 1){
                txtCliente.setText("");               
            }
        }       
    }
    
    private void mostrarTabla(){
        scrollPanel.setVisible(true);
    }
    
    private void ocultarTabla(){
        scrollPanel.setVisible(false);
    }
    
    private void enviarDatosBuscador(){
        
        String opcion = "";
        if(comboBoxBuscarEn.getSelectedIndex()==0){
            opcion="listaLibros";
        }
        if(comboBoxBuscarEn.getSelectedIndex()==1){
            opcion="dados de baja";
        }
        
        
        
        Libro datosLibro = new Libro(0,"","","","",0,0,0);
        datosLibro.setNombreLibro(registroVentas.getTxtTitulo().getText());
        datosLibro.setAutorLibro(registroVentas.getTxtAutor().getText());
        datosLibro.setGenero(registroVentas.getTxtGenero().getText());
        datosLibro.setEdicion(registroVentas.getTxtEdicion().getText());
        
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
            librosCarritoVenta.add(libroSeleccionado);
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
        txtTitulo.setText(libro.getNombreLibro());
        txtAutor.setText(libro.getAutorLibro());
        txtGenero.setText(libro.getGenero());
        txtEdicion.setText(libro.getEdicion());
        //registroCompras.getTxtCantidad().setText(""+libro.getStockDisponible());
        txtCantidad.setText("1");
        //registroCompras.getTxtPrecioCompra().setText(""+libro.getCostoCompra());
        txtPrecio.setText(""+libro.getCostoVenta());
        //registroCompras.getTxtCantidadMinima().setText(""+libro.getStockMinimo());
    }
    
    private boolean estaEnLista(Libro libro){
        boolean res=false;
        
        for(int i =0; i<librosCarritoVenta.size(); i++){
            int id = librosCarritoVenta.get(i).getIdLibro();
            if(id == libro.getIdLibro()){
                res = true;
                i=librosCarritoVenta.size();
            }
        }
        return res;
        
    }
    
    //ANIADIR LIBRO AL CARRITO
    private void aniadirLibroCarrito()
    {
        if(librosCarritoVenta.size()>0){
        int ultimoLibro = librosCarritoVenta.size()-1;
                
        Libro libro = librosCarritoVenta.get(ultimoLibro);
        
            if(!libros.contains(libro.getNombreLibro()+" "+libro.getEdicion()))
            {
                libros.add(libro.getNombreLibro()+" "+libro.getEdicion());
                limpiar();
                ponerEnTabla(libro);
                
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Ya agrego el libro anteriormente");
            }
        }else{
             JOptionPane.showMessageDialog(null, "Debe agregar un libro");
        }  
        
                
    }
    
    
    private void ponerEnTabla(Libro libro){
        Object[] dato = {1, libro.getNombreLibro(), libro.getAutorLibro(), libro.getEdicion(), libro.getCostoVenta(), 0.0};
        anadirFilaCompra(dato);
    }
    
    private void anadirFilaCompra(Object[] dato) 
    {
        ((DefaultTableModel) tablaVenta.getModel()).addRow(dato);
    }
   
    //DESHABILITAR CAMPOS
    private void deshabilitarCampos(){
        txtTitulo.setEditable(false);
        txtAutor.setEditable(false);
        txtGenero.setEditable(false);
        txtEdicion.setEditable(false);
        txtCantidad.setEditable(true);
        txtPrecio.setEditable(false);
    }
    
    private void habilitarCampos(){
        txtTitulo.setEditable(true);
        txtAutor.setEditable(true);
        txtGenero.setEditable(true);
        txtEdicion.setEditable(true);
        txtCantidad.setEditable(true);
        txtPrecio.setEditable(true);
        
        if(librosCarritoVenta.size()>0){
           int ul = librosCarritoVenta.size()-1;
           librosCarritoVenta.remove(ul);
        }
    }
    
    private void eliminarFilaCompra(int fila) 
    {
        ((DefaultTableModel) tablaVenta.getModel()).removeRow(fila);
    }  
    
    //REGISTRAR VENTA
    private void registrarVenta() {

        if (txtCliente.getText().equals("")
                || txtNit.getText().equals("")
                || txtTotal.getText().equals("0.0")
                || txtTotal.getText().equals("0.00")) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos para registrar la venta");
        } else if (txtCliente.getText().startsWith(" ")) {
            JOptionPane.showMessageDialog(null, "Llene correctamente los campos\n "
                    + "Evite comenzar con espacios");
        } else {

            //Para obtener las entradas
            String cliente = txtCliente.getText();
            String fecha = fechaTabla;
            String nit = txtNit.getText();
            String vendedor = UsuarioActual.usuarioActual.getNombres() + " " +
                    UsuarioActual.usuarioActual.getApellidos();
            String total = txtTotal.getText();

            if (txtNit.getText().length() == 7
                    || txtNit.getText().length() == 10) {
                //Sacar datos de tabla
                String[] tablaTitulo = {"Cantidad", "Nombre", "Autor", "Precio",
                    "Precio Total"};
                int rows = tablaVenta.getRowCount();
                int columns = tablaVenta.getColumnCount();

                Object[][] tabla = new Object[rows][columns];

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        tabla[i][j] = tablaVenta.getValueAt(i, j);
                    }
                }

                //Sacar nombres de libros, para insercion en BD, detalle_venta
                //Sacar precio parcial para insertar a detalle_venta
                String[] libros = new String[rows];
                String[] parciales = new String[rows];
                Integer[] cantidades = new Integer[rows];
                int n = 1;  //Columna de nombres
                int p = 4;  //Columna de precios
                int c = 0;  //Columna de cantidades
                for (int k = 0; k < rows; k++) {
                    libros[k] = (String) tablaVenta.getValueAt(k, n);
                    parciales[k] = String.valueOf(tablaVenta.getValueAt(k, p));
                    cantidades[k] = Integer.parseInt((String) tablaVenta.getValueAt(k, c));
                }

                //Poner datos en BD, cliente, venta
                insertarBD(cliente, nit, fecha, total, libros, parciales, cantidades);

                //Enviamos detalle de venta para pdf
                int ultimoId = librosCarritoVenta.size() - 1;
                //int idV = librosCarritoVenta.get(ultimoId).getIdLibro();

                File rutaDestino = null;
                CrearFactura pdfFactura = new CrearFactura("Libreria", null);
                rutaDestino = pdfFactura.destino();
                pdfFactura.setDestino(rutaDestino);

                if (rutaDestino != null) {
                    if (bandera == 0) {
                        pdfFactura.generarFactura(fecha, cliente, nit, vendedor, tabla, total,
                                rows, columns, tablaTitulo);
                    } else {
                        String sql = "SELECT nombre FROM cliente WHERE ci='" + nit + "'";
                        String nombreBD = "";
                        try {
                            ResultSet rs = ConexionPostgresql.consultar(sql);
                            while (rs.next()) {
                                nombreBD = rs.getString("nombre");
                            }
                        } catch (Exception ex) {
                            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
                            System.exit(0);
                        }
                        pdfFactura.generarFactura(fecha, nombreBD, nit, vendedor, tabla, total,
                                rows, columns, tablaTitulo);
                    }

                    pdfFactura.mostrarFactura();
                    //Limpiar el registro
                    reanudar();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un número de CI/NIT válido");
            }

        }
    }

    private void insertarBD(String nombre, String ci, String fecha, String total,
            String[] libros, String[] parciales, Integer[] cantidades) {
        String ciUsuario ="6946808";
        //Para la confirmar si el cliente ha sido registrado anteriormente
        int n = buscarNitBD(ci);

        if (n == 0) {

            String sql = "INSERT INTO cliente (ci, nombre) VALUES ('" + ci + "', '"
                    + nombre + "')";
            ConexionPostgresql.updateDB(sql);
            bandera = 0;
        }

        if (n == 1) {
            mostrarActualizarCliente(ci, nombre);
        }

        String sql2 = "INSERT INTO venta (ci_usuario, ci, id_libreria, fecha, total) VALUES ('"
                +ciUsuario+"', '"+ ci + "', '" + 1 + "', '" + fecha + "', " + total + ")";
        ConexionPostgresql.updateDB(sql2);

        //Para la inserción en detalle_Venta
        VentaDAO vt = new VentaDAO();
        int fin = vt.getVentas().size();
        int idV = vt.getVentas().get(fin - 1).getIdVenta();
        System.out.println("El último id_venta es: " + idV);
        //rVenta.getIdVentas().add(idV);
        insertarDetalle(libros, idV, parciales, cantidades);

    }

    private int buscarNitBD(String ci) {
        int res = 0;
        String sql = "SELECT ci FROM cliente WHERE ci='" + ci + "'";
        try {
            ResultSet rs = ConexionPostgresql.consultar(sql);
            while (rs.next()) {
                res++;
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return res;
    }

    private void mostrarActualizarCliente(String ci, String nombre) {
        String sql = "SELECT nombre FROM cliente WHERE ci='" + ci + "'";
        String nombreBD = "";
        try {
            ResultSet rs = ConexionPostgresql.consultar(sql);
            while (rs.next()) {
                nombreBD = rs.getString("nombre");
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        if (!nombreBD.equals(nombre)) {
            ActualizarCliente t = new ActualizarCliente(nombreBD);
            int option = JOptionPane.showConfirmDialog(registroVentas, t, "Actualizar Cliente", 0);
            //bandera =1;
            switch (option) {
                case JOptionPane.OK_OPTION:
                    cambiarNombre(ci, nombre);
                    break;
                default:
                    bandera = 1;
                    break;
            }
        } else {
            bandera = 0;
        }

    }

    private void cambiarNombre(String ci, String nombre) {
        String sql = "UPDATE cliente SET nombre='" + nombre + "' WHERE ci='" + ci + "'";
        ConexionPostgresql.updateDB(sql);
        bandera = 0;

    }

    private void insertarDetalle(String[] libros, int idV, String[] parciales,
            Integer[] cantidades) {
        //System.out.println("Entra a insertar detalle");
        ArrayList<Integer> idLibros = darIdLibrosVenta();
        DetalleDAO lb = new DetalleDAO(libros, idV, parciales, cantidades, idLibros);
        lb.insertarEnBD();
        lb.actualizarCantidad();

    }
    
    private ArrayList<Integer> darIdLibrosVenta(){
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i=0; i< librosCarritoVenta.size(); i++){
            res.add(librosCarritoVenta.get(i).getIdLibro());
        }
        
        return res;
    }
      

    public void reanudar() {
        eliminarFilas();
    }

    public void eliminarFilas() {
        int cant = tablaVenta.getRowCount();
        for (int i = cant - 1; i >= 0; i--) {
            eliminarFilaVenta(i);
        }
        inicializarRegistroVentas();
    }

    
    //ELIMINAR FILA TABLA
    private void eliminarFilaTabla()
    {
        int cantFila = tablaVenta.getRowCount();
        if (cantFila > 0)
        {
            int fila = tablaVenta.getSelectedRow();
            
            tablaVenta.editingStopped(null);
            
            if (fila >= 0) 
            { 
                String aux = tablaVenta.getValueAt(fila, 1).toString()+" "+tablaVenta.getValueAt(fila, 3).toString();
                 
                libros.remove(aux);
                eliminarFilaVenta(fila);
                if(libros.size()>fila)
                    librosCarritoVenta.remove(fila);
                               
            } 
            else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
            }
         }
    }
    
    
    public void eliminarFilaVenta(int rowIndex) {
        
        ((DefaultTableModel) tablaVenta.getModel()).removeRow(rowIndex);
    }

    public void sumar() {
        double costoTotal = 0;
        for (int i = 0; i < tablaVenta.getRowCount(); i++) {
            String costoPorLibros = tablaVenta.getValueAt(i, 4).toString();
            double costoLibros = Double.valueOf(costoPorLibros).doubleValue();
            costoTotal = costoTotal + costoLibros;
        }
        txtTotal.setText((String.valueOf(costoTotal)));
    }
    
    //EVENTOS DE LOS CAMPOS
     private void buscarCliente(String nit){
        String sql = "SELECT nombre FROM cliente WHERE ci='" + nit + "'";
        String nombre = "";
        try {
            ResultSet rs = ConexionPostgresql.consultar(sql);
            while (rs.next()) {
                nombre = rs.getString("nombre");
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        if (!nombre.equals("")) {
            txtCliente.setText(nombre);
        }
    }
    
}
