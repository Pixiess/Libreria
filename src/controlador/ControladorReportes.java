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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.LibroReporte;
import org.jdesktop.swingx.JXDatePicker;
import vista.Reporte;
import vista.ReporteLibrosComprados;
import vista.ReporteLibrosVendidos;
import vista.TipoReporte;

/**
 *
 * @author juan ricaldi
 */
public class ControladorReportes implements MouseListener, KeyListener, FocusListener{
    
    private Reporte reportes;
    private TipoReporte selectorReporte;
    private int reporteElegido;
    private ReportesDAO reporteDAO;
    private ArrayList<LibroReporte> librosDeLaTabla;
    private JTable tablaLibros;
    private DefaultTableModel tablaModelo;
    private final String[] titulosTablaVenta= {"TITULO", "EDICION",
        "CANTIDAD VENDIDA", "GANANCIA POR LIBRO"};
    private final String[] titulosTablaCompra = {"TITULO", "EDICION",
        "CANTIDAD COMPRADA", "COSTO DE LIBRO"};
    
    public ControladorReportes(Reporte reportes){
        this.reportes = reportes;
        selectorReporte = new TipoReporte(new javax.swing.JFrame(), true);
        reporteDAO = new ReportesDAO();
        setListeners();
        tablaLibros = new JTable();
        tablaModelo = (DefaultTableModel) tablaLibros.getModel();
        
        
        //inicializarTablasReportes();
    }
    
    public void inicializarTablasReportes(){
 
    }
    
    private void setListeners(){
        reportes.getBtnElegir().addMouseListener(this);
        reportes.getBtnActualizar().addMouseListener(this);
        reportes.getBtnPdf().addMouseListener(this);
        selectorReporte.getBtnAceptar().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(reportes.getBtnElegir())) {
            mostrarSelectorReporte();
        } else if (e.getSource().equals(reportes.getBtnActualizar())){
            consultarTabla();
        } else if (e.getSource().equals(reportes.getBtnPdf())){
            generarPdf();
        } else if (e.getSource().equals(selectorReporte.getBtnAceptar())){
            elegirReporte();
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
    
    private void mostrarSelectorReporte(){
        selectorReporte.setVisible(true);
    }
    
    private void consultarTabla(){
        String fechaInicio = reportes.getFecha(reportes.getJXDPDesde());
        String fechaFin = reportes.getFecha(reportes.getJXDPHasta());
        
        if(reporteElegido == 1){
            llenarLibrosTablaMasVendidos(fechaInicio, fechaFin, 4);
        }
        else if(reporteElegido == 2){
            llenarLibrosTablaComprados(fechaInicio, fechaFin);
        }
        else if(reporteElegido == 3){
            llenarLibrosTablaVendidos(fechaInicio, fechaFin);
        }
        
    }
        
    public void llenarLibrosTablaVendidos(String fechaInicio, String fechaFin){
        librosDeLaTabla = reporteDAO.getReporte(fechaInicio, fechaFin);
        llenarTabla();
    }
    
    public void llenarLibrosTablaMasVendidos(String fechaInicio, String fechaFin, int n){
        librosDeLaTabla = reporteDAO.getReporteMasVendidos(fechaInicio, fechaFin, n);
        llenarTabla();
    }
    
    private void llenarLibrosTablaComprados(String fechaInicio, String fechaFin){
        librosDeLaTabla = reporteDAO.getReporteLibrosComprados(fechaInicio, fechaFin);
        llenarTabla();
    }
    
    private void llenarTabla(){
        Object[][] datosTabla = conseguirDatosTabla();
        if(reporteElegido == 2){
           tablaModelo.setDataVector(datosTabla, titulosTablaCompra); 
        }else{
            tablaModelo.setDataVector(datosTabla, titulosTablaVenta); 
        }
    }
    
    private Object[][] conseguirDatosTabla(){
        Object[][] respuesta = new Object[librosDeLaTabla.size()][];

        for (int i = 0; i < librosDeLaTabla.size(); i++) {
            respuesta[i] = devolverDatosLibro(librosDeLaTabla.get(i));
        }
        return respuesta;
    }
    
    private Object[] devolverDatosLibro(LibroReporte venta) {
        Object[] respuesta = new Object[4];

        respuesta[0] = venta.getTitulo();
        respuesta[1] = venta.getEdicion();
        respuesta[2] = venta.getCantidad();
        respuesta[3] = venta.getCosto();

        return respuesta;
    }
    
    private void elegirReporte(){
        if(selectorReporte.getRdbtnLibrosMasVendidos().isSelected()){
            reportes.getPnlBaseTabla().removeAll();
            reporteElegido = 1;
            ReporteLibrosVendidos reporteVenta = new ReporteLibrosVendidos();
            tablaLibros = reporteVenta.getTablaLibrosVendidos();
            tablaModelo = (DefaultTableModel)tablaLibros.getModel();
            reportes.getPnlBaseTabla().add(reporteVenta);
            reportes.getPnlBaseTabla().updateUI();
            selectorReporte.dispose();
        }
        else if(selectorReporte.getRdbtnLibrosComprados().isSelected()){
            reportes.getPnlBaseTabla().removeAll();
            reporteElegido = 2;
            ReporteLibrosComprados reporteCompra = new ReporteLibrosComprados();            
            tablaLibros = reporteCompra.getTablaLibrosComprados();
            tablaModelo = (DefaultTableModel)tablaLibros.getModel();
            reportes.getPnlBaseTabla().add(reporteCompra);
            reportes.getPnlBaseTabla().updateUI();
            selectorReporte.dispose();
        }
        else if(selectorReporte.getRdbtnLibrosVendidos().isSelected()){
            reportes.getPnlBaseTabla().removeAll();
            reporteElegido = 3;
            ReporteLibrosVendidos reporteVenta = new ReporteLibrosVendidos();
            tablaLibros = reporteVenta.getTablaLibrosVendidos();
            tablaModelo = (DefaultTableModel)tablaLibros.getModel();
            reportes.getPnlBaseTabla().add(reporteVenta);
            reportes.getPnlBaseTabla().updateUI();
            selectorReporte.dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "Escoja una opción");
        }
        
    }
    
    private void generarPdf(){
        
    }
}
