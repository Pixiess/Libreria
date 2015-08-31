package controlador;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import modelo.Libro;
import vista.ActualizarCliente;
import vista.BuscadorLibros;
import vista.RegistroVentas;

public class Controlador implements ActionListener, MouseListener, ChangeListener, WindowListener {

    RegistroVentas rVenta;
    int bandera;

    public Controlador(RegistroVentas rv)
    {
        rVenta = rv;
        setListeners();
    }
     
    private void setListeners() {
        rVenta.getEliminar().addMouseListener(this);
        rVenta.getFactura().addMouseListener(this);
        rVenta.getAgregar().addMouseListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        Component componente = (Component) e.getSource();

        if (componente.isEnabled()) {
            if (e.getSource() == rVenta.getAgregar()) {
                agregarL(e);
            } else if (e.getSource() == rVenta.getEliminar()) {
                eliminarL(e);
            } else if (e.getSource() == rVenta.getFactura()) {
                registrarVenta(e);
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

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

    private void agregarL(MouseEvent e) {
        BuscadorLibros buscadorLibros = new BuscadorLibros(new javax.swing.JDialog(), true);
                buscadorLibros.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        
                        Window buscador = e.getWindow();
                        if(buscador instanceof JDialog)
                            ((JDialog)buscador).dispose();
                    }
                });
                buscadorLibros.setVisible(true);
                
        Libro libro = buscadorLibros.getLibroBuscado();
        if(libro!=null){ 
            Object [] datos = {"1", libro.getNombreLibro(), libro.getAutorLibro(), 
                                  ""+libro.getCostoVenta(), ""+libro.getCostoVenta()};        
            int id = libro.getIdLibro();
            if(!rVenta.contiene(id))
            {
                rVenta.anadirFilaVenta(datos);
                rVenta.anadirLibVenta(id);
                libro.setCostoParcial(libro.getCostoVenta());
                rVenta.anadirListaPorVender(libro);
                sumar();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Usted ya agrego el libro");
            }
        }
        
    }

    private void eliminarL(MouseEvent e) {
         
        int cantFila = rVenta.getVentaTabla().getRowCount();

        if (cantFila > 0) {
            int row = rVenta.getVentaTabla().getSelectedRow();
            if (row >= 0) {

                rVenta.eliminarFilaVenta(row);
                rVenta.eliminarLibVenta(row);
                rVenta.sumar();

            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila a eliminar por si acaso");
            }
        }
        //rVenta.sumar();
    }

    private void registrarVenta(MouseEvent e) {

        if (rVenta.getCliente().getText().equals("")
                || rVenta.getNit().getText().equals("")
                || rVenta.getCostoTotal().getText().equals("0.0")
                || rVenta.getCostoTotal().getText().equals("0.00")) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos para registrar la venta");
        }else if (rVenta.getCliente().getText().startsWith(" ")) {
            JOptionPane.showMessageDialog(null, "Llene correctamente los campos\n "
                    + "Evite comenzar con espacios");
        } else {

            //Para obtener las entradas
            String cliente = rVenta.getCliente().getText();
            String fecha = rVenta.getFecha().getText();
            String nit = rVenta.getNit().getText();
            String total = rVenta.getCostoTotal().getText();

            if (rVenta.getNit().getText().length() == 7
                    || rVenta.getNit().getText().length() == 10) {
                //Sacar datos de tabla
                String[] tablaTitulo = {"Cantidad", "Nombre", "Autor", "Precio",
                    "Precio Total"};
                int rows = rVenta.getVentaTabla().getRowCount();
                int columns = rVenta.getVentaTabla().getColumnCount();

                Object[][] tabla = new Object[rows][columns];

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        tabla[i][j] = rVenta.getVentaTabla().getValueAt(i, j);
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
                    libros[k] = (String) rVenta.getVentaTabla().getValueAt(k, n);
                    parciales[k] = String.valueOf(rVenta.getVentaTabla().getValueAt(k, p));
                    cantidades[k] = Integer.parseInt((String) rVenta.getVentaTabla().getValueAt(k, c));
                }

                //Poner datos en BD, cliente, venta
                insertarBD(cliente, nit, fecha, total, libros, parciales, cantidades);

                //Enviamos detalle de venta para pdf
                int ultimoId = rVenta.getIdVentas().size() - 1;
                int idV = rVenta.getIdVentas().get(ultimoId);
                
                File rutaDestino = null;
                CrearFactura pdfFactura = new CrearFactura("Libreria", null);
                rutaDestino = pdfFactura.destino();
                pdfFactura.setDestino(rutaDestino);
                
                if (bandera == 0) {
                    pdfFactura.generarFactura(fecha, cliente, nit, tabla, total,
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
                    pdfFactura.generarFactura(fecha, nombreBD, nit, tabla, total,
                            rows, columns, tablaTitulo);
                }

                pdfFactura.mostrarFactura();

                //Limpiar el registro
                reanudar();
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un número de CI/NIT válido");
            }

        }
    }

    private void insertarBD(String nombre, String ci, String fecha, String total,
            String[] libros, String[] parciales, Integer[] cantidades) {

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

        String sql2 = "INSERT INTO venta (ci, id_libreria, fecha, total) VALUES ('"
                + ci + "', '" + 1 + "', '" + fecha + "', " + total + ")";
        ConexionPostgresql.updateDB(sql2);

        //Para la inserción en detalle_Venta
        VentaDAO vt = new VentaDAO();
        int fin = vt.getVentas().size();
        int idV = vt.getVentas().get(fin - 1).getIdVenta();
        System.out.println("El último id_venta es: " + idV);
        rVenta.getIdVentas().add(idV);
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
            int option = JOptionPane.showConfirmDialog(rVenta, t, "Actualizar Cliente", 0);
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
        ArrayList<Integer> idLibros=rVenta.getLventas();
        DetalleDAO lb = new DetalleDAO(libros, idV, parciales, cantidades, idLibros);
        lb.insertarEnBD();
        lb.actualizarCantidad();

    }

    public void reanudar() {
        rVenta.getCliente().setText("");
        rVenta.getNit().setText("");
        rVenta.getCostoTotal().setText("0.00");
        eliminarFilas();
    }

    public void eliminarFilas() {
        int cant = rVenta.getVentaTabla().getRowCount();
        for (int i = cant - 1; i >= 0; i--) {
            eliminarFilaVenta(i);
        }
        rVenta.iniciarLventas();
    }

    public void eliminarFilaVenta(int rowIndex) {
        ((DefaultTableModel) rVenta.getVentaTabla().getModel()).removeRow(rowIndex);
    }
    
    public void sumar(){
        double costoTotal = 0;
        for(int i = 0; i < rVenta.getTablaVentas().getRowCount(); i++)
        {
            String costoPorLibros = rVenta.getTablaVentas().getValueAt(i, 4).toString();
            double costoLibros = Double.valueOf(costoPorLibros).doubleValue();
            costoTotal = costoTotal + costoLibros;
        }
        rVenta.setTxtTotal(String.valueOf(costoTotal));
    }
}
