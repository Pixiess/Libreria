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
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import modelo.JavaPdf;
import modelo.Libro;
import vista.ActualizarCliente;
import vista.RegistroVentas;

/**
 *
 * @author A
 */
public class Controlador implements ActionListener, MouseListener, ChangeListener, WindowListener {

    RegistroVentas rVenta;
    int bandera;

    public void setComponents(RegistroVentas rv) {
        rVenta = rv;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
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
        Libro libro = new Libro(1, "El Resplandor", "Stephen King", "Novela terror", 12, 30.0, 35.0);

        String[] datos = {"2", libro.getNombreLibro(), libro.getAutorLibro(), "" + libro.getCostoVenta(), "12"};

        rVenta.anadirFilaVenta(datos);

    }

    private void eliminarL(MouseEvent e) {

        int countRow = rVenta.getVentaTabla().getRowCount();

        if (countRow > 0) {
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
                JavaPdf miPdf = new JavaPdf("factura", "Libreria", idV);

                if (bandera == 0) {
                    miPdf.generarFactura(fecha, cliente, nit, tabla, total, 
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
                    miPdf.generarFactura(fecha, nombreBD, nit, tabla, total, 
                            rows, columns, tablaTitulo);
                }

                miPdf.shownPdf();

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
        DetalleDAO lb = new DetalleDAO(libros, idV, parciales, cantidades);
        lb.insertarEnBD();
        lb.actualizarCantidad();

    }

    public void reanudar() {
        rVenta.getCliente().setText("");
        rVenta.getNit().setText("");
        rVenta.getCostoTotal().setText("0.00");
        deleteAllRows();
    }

    public void deleteAllRows() {
        int count = rVenta.getVentaTabla().getRowCount();
        for (int i = count - 1; i >= 0; i--) {
            eliminarFilaVenta(i);
        }
        rVenta.iniciarLventas();
    }

    public void eliminarFilaVenta(int rowIndex) {
        ((DefaultTableModel) rVenta.getVentaTabla().getModel()).removeRow(rowIndex);
    }
}
