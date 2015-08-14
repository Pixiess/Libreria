/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Rectangle;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Libro;
import vista.FormularioLibro;
import vista.RegistroCompras;

/**
 *
 * @author Veymar Montaño Colqu
 */

public class ControladorRegistroCompras implements MouseListener, KeyListener, FocusListener {

    private RegistroCompras registroCompras;
    private LibroDAO libroDAO;
    private ArrayList<Libro> librosDeLaTabla;
    private JTable tablaDeLibros;
    private DefaultTableModel tableModel;
    private int cantLibrosStock;

    private final String[] titulosTabla = {"ID", "TITULO", "AUTOR", "EDICION",
        "CANTIDAD MINIMA", "STOCK ACTUAL"};
    private int filaSeleccionada;
    private int estaMarcado;
    private int idLibro;

    public ControladorRegistroCompras(RegistroCompras registroCompras) {
        this.registroCompras = registroCompras;
        setListeners();
        tablaDeLibros = registroCompras.getTableRegistroLibros();
        tableModel = (DefaultTableModel) tablaDeLibros.getModel();

        libroDAO = new LibroDAO();
        estaMarcado = -1;
        cantLibrosStock = 0;
        idLibro = -1;

        inicializarRegistroCompras();
    }

    public void inicializarRegistroCompras() {
        filaSeleccionada = -1;
        registroCompras.getBtnRadioListaLibros().doClick();
        llenarTodosLosLibrosTabla();
    }

    private void setListeners() {
        registroCompras.getTableRegistroLibros().addMouseListener(this);
        registroCompras.getBtnComprar().addMouseListener(this);
        registroCompras.getBtnEditar().addMouseListener(this);
        registroCompras.getBtnEliminar().addMouseListener(this);
        registroCompras.getBtnRadioControlStock().addMouseListener(this);
        registroCompras.getBtnRadioListaLibros().addMouseListener(this);
        registroCompras.getLabelIconoLibros().addMouseListener(this);
        registroCompras.getLabelIconoStock().addMouseListener(this);
        registroCompras.getTxtBuscarLibro().addKeyListener(this);
        registroCompras.getTxtBuscarLibro().addFocusListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(registroCompras.getBtnRadioListaLibros())) {
            llenarTodosLosLibrosTabla();
        } else if (e.getSource().equals(registroCompras.getBtnRadioControlStock())) {
            llenarStockBajoTabla();
        } else if (e.getSource().equals(registroCompras.getLabelIconoLibros())) {
            registroCompras.getBtnRadioListaLibros().doClick();
            llenarTodosLosLibrosTabla();
        } else if (e.getSource().equals(registroCompras.getLabelIconoStock())) {
            registroCompras.getBtnRadioControlStock().doClick();
            llenarStockBajoTabla();
        } else if (e.getSource().equals(tablaDeLibros)) {
            filaSeleccionada = tablaDeLibros.getSelectedRow();
            registroCompras.getLabelErrorCoincidencia().setText("");
            System.out.println("llega");
        } else if (e.getSource().equals(registroCompras.getBtnComprar())) {
            mostrarFormularioCompra();
        } else if (e.getSource() == registroCompras.getBtnEliminar()) {
            descartarLibro();
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

    }

    @Override
    public void keyReleased(KeyEvent e) {
        filaSeleccionada = libroDAO.encontrarPrimeraCoincidencia(
                registroCompras.getTxtBuscarLibro().getText(), "Por Titulo");

        if (registroCompras.getTxtBuscarLibro().getText().equals("")) {
            deslizarTablaHastaSeleccion(0);
            tablaDeLibros.clearSelection();
            registroCompras.getLabelErrorCoincidencia().setText("");
        } else if (filaSeleccionada != -1) {
            deslizarTablaHastaSeleccion(filaSeleccionada);
            registroCompras.getLabelErrorCoincidencia().setText("");
        } else {
            tablaDeLibros.clearSelection();
            registroCompras.getLabelErrorCoincidencia().setText(
                    "NO EXISTE UN LIBRO CON ESE TITULO!!");
        }

    }

    @Override
    public void focusGained(FocusEvent e) {
        registroCompras.getTxtBuscarLibro().setText("");
    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    private void llenarTodosLosLibrosTabla() {
        registroCompras.getLabelDescripcionLista().setText(
                "LISTA TOTAL DE LIBROS");
        librosDeLaTabla = libroDAO.getReportePorFiltro("Por Titulo");
        llenarTabla();
    }

    private void llenarStockBajoTabla() {
        registroCompras.getLabelDescripcionLista().setText(
                "LISTA DE LIBROS CON BAJO STOCK");
        librosDeLaTabla = libroDAO.getReportePorFiltro("Por Titulo",
                " and (cantidad <= cantidad_minima)");
        llenarTabla();
    }

    private void llenarTabla() {
        Object[][] datosTabla = conseguirDatosTabla();
        tableModel.setDataVector(datosTabla, titulosTabla);
    }

    private Object[][] conseguirDatosTabla() {
        Object[][] respuesta = new Object[librosDeLaTabla.size()][];

        for (int i = 0; i < librosDeLaTabla.size(); i++) {
            respuesta[i] = devolverDatosLibro(librosDeLaTabla.get(i));
        }
        return respuesta;
    }

    private Object[] devolverDatosLibro(Libro libro) {
        Object[] respuesta = new Object[6];

        respuesta[0] = libro.getIdLibro();
        respuesta[1] = libro.getNombreLibro();
        respuesta[2] = libro.getAutorLibro();
        respuesta[3] = libro.getEdicion();
        respuesta[4] = libro.getStockMinimo();
        respuesta[5] = libro.getStockDisponible();

        return respuesta;
    }

    private void deslizarTablaHastaSeleccion(int filaSeleccionada) {
        tablaDeLibros.getSelectionModel().setSelectionInterval(
                filaSeleccionada, filaSeleccionada);
        Rectangle rect = tablaDeLibros.getCellRect(filaSeleccionada, 0, true);
        tablaDeLibros.scrollRectToVisible(rect);
    }

    private void mostrarFormularioCompra() {
        estaMarcado = tablaDeLibros.getSelectedRow();
        Libro libro = new Libro();
        FormularioLibro formularioLibro = new FormularioLibro(new javax.swing.JFrame(), true, estaMarcado, libro);

        if (estaMarcado == -1) {
            ControladorFormularioLibro controlador1 = new ControladorFormularioLibro(formularioLibro);
            formularioLibro.setVisible(true); //JOptionPane El libro no existe, quiere realizar una nueva compra

        } else {
            Libro libroSeleccionado = buscarLibroSeleccionado();
            formularioLibro = new FormularioLibro(new javax.swing.JFrame(), true, estaMarcado, libroSeleccionado);
            ControladorFormularioLibro controlador2 = new ControladorFormularioLibro(formularioLibro);
            formularioLibro.setVisible(true);
        }
    }

    private Libro buscarLibroSeleccionado() {
        Libro res = new Libro();
        int fila = tablaDeLibros.getSelectedRow();
        int id = (Integer) tablaDeLibros.getValueAt(fila, 0);

        for (int i = 0; i < librosDeLaTabla.size(); i++) {
            if (id == librosDeLaTabla.get(i).getIdLibro()) {
                res = librosDeLaTabla.get(i);
                i = librosDeLaTabla.size();
            }
        }
        return res;
    }

    public void descartarLibro() {
        int fila = registroCompras.getTableRegistroLibros().getSelectedRow();

        if (fila >= 0) {
            Object s = ((DefaultTableModel) registroCompras.getTableRegistroLibros().getModel()).getValueAt(fila, 0);
            int idLibro = Integer.parseInt(s.toString());
            //System.out.println(s.toString());

            String sql = "UPDATE libro SET estado='" + 0 + "' WHERE id_libro='" + idLibro + "'";
            ConexionPostgresql.updateDB(sql);
            //System.out.println(cantLibrosStock);
        }

    }

    public int getCantLibrosStock() {
        librosDeLaTabla = libroDAO.getReportePorFiltro("Por Titulo",
                " and (cantidad <= cantidad_minima)");
        cantLibrosStock = librosDeLaTabla.size();
        return cantLibrosStock;
    }

}
