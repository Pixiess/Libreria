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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Venta;
import vista.Reportes;

/**
 *
 * @author juan ricaldi
 */
public class ControladorReportes implements MouseListener, KeyListener, FocusListener{
    
    private Reportes reportes;
    private ReportesDAO reporteDAO;
    private ArrayList<Venta> librosDeLaTabla;
    private JTable tablaLibrosVendidos;
    private DefaultTableModel tableModel;
    private final String[] titulosTabla = {"TITULO", "EDICION",
        "CANTIDAD VENDIDA", "GANANCIA POR LIBRO"};
    
    public ControladorReportes(Reportes reportes){
        this.reportes = reportes;
        setListeners();
        tablaLibrosVendidos = reportes.getTableReportes();
        tableModel = (DefaultTableModel) tablaLibrosVendidos.getModel();
        reporteDAO = new ReportesDAO();
        
        inicializarTablasReportes();
    }
    
    public void inicializarTablasReportes(){
        ponerFechas();
        consultarTabla();
    }
    
    private void consultarTabla(){
        String fechaInicio = reportes.getTxtFechaInicio().getText();
        String fechaFin = reportes.getTxtFechaFin().getText();
        
        if (fechaInicio.length() != 0 && fechaFin.length() != 0){
            llenarLibrosTabla(fechaInicio, fechaFin);
        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos para realizar la consulta");
        }
        
    }
    
    private void setListeners(){
        reportes.getTableReportes().addMouseListener(this);
        reportes.getBtnConsultar().addMouseListener(this);
        reportes.getTxtFechaInicio().addKeyListener(this);
        reportes.getTxtFechaFin().addKeyListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(reportes.getBtnConsultar())) {
            consultarTabla();
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
        
    }

    @Override
    public void focusGained(FocusEvent e) {
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        
    }
    
    public void llenarLibrosTabla(String fechaInicio, String fechaFin){
        librosDeLaTabla = reporteDAO.getReporte(fechaInicio, fechaFin);
        llenarTabla();
    }
    
    public void llenarLibrosTablaMasVendidos(String fechaInicio, String fechaFin, int n){
        librosDeLaTabla = reporteDAO.getReporteMasVendidos(fechaInicio, fechaFin, n);
        llenarTabla();
    }
    
    private void llenarTabla(){
        Object[][] datosTabla = conseguirDatosTabla();
        tableModel.setDataVector(datosTabla, titulosTabla);
    }
    
    private Object[][] conseguirDatosTabla(){
        Object[][] respuesta = new Object[librosDeLaTabla.size()][];

        for (int i = 0; i < librosDeLaTabla.size(); i++) {
            respuesta[i] = devolverDatosLibro(librosDeLaTabla.get(i));
        }
        return respuesta;
    }
    
    private Object[] devolverDatosLibro(Venta venta) {
        Object[] respuesta = new Object[4];

        respuesta[0] = venta.getNombreLibro();
        respuesta[1] = venta.getEdicionLibro();
        respuesta[2] = venta.getCantidad();
        respuesta[3] = venta.getCostoParcial();

        return respuesta;
    }
    
    private void ponerFechas() {
        Date fec = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = sdf.format(fec);
        reportes.getTxtFechaFin().setText(fecha);
        reportes.getTxtFechaInicio().setText("01/08/2015");
    }
    
    public Reportes getReportes(){
        return reportes;
    }
}
