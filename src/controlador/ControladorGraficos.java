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
import javax.swing.JSpinner;
import org.jfree.chart.ChartPanel;
import vista.Grafico;
import vista.TipoGrafico;

/**
 *
 * @author USUARIO
 */
public class ControladorGraficos implements MouseListener, KeyListener, FocusListener{
    
    private Grafico grafico;
    private GraficoDAO graficoDAO;
    private TipoGrafico selectorGrafico;
    private int graficoElegido;
    private String [] tituloLibros;
    private int [][] librosMasVen;
    
    public ControladorGraficos(Grafico grafico){
        this.grafico = grafico;
        selectorGrafico = new TipoGrafico(new javax.swing.JFrame(), true);
        graficoDAO = new GraficoDAO();
        setListeners();
        
        inicializarGraficos();
    }
    
    public void inicializarGraficos(){
        graficoElegido = 1;
        ChartPanel panel = CrearGrafico.generarGraficoBarras(graficoDAO.costosCompraMes());
        grafico.getPanelBase().removeAll();
        grafico.getPanelBase().add(panel);
        grafico.getlblTituloGraficos().setText("GRAFICO DE COSTOS REALIZADOS");
        panel.setBounds(0, 0, 770, 445);
        grafico.getPanelBase().updateUI();
        
        inicializarGrafLibMasVendidos();
    }
    
    public void inicializarGrafLibMasVendidos(){
        JSpinner spinner = grafico.getSpinnerCantidadMasVendidos();
        ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField()
                .setEditable(false);
        setControlesGraficoMasVendidos(false);
    }
    
    public void setListeners(){
        grafico.getBtnElegirGrafico().addMouseListener(this);
        grafico.getBtnActualizar().addMouseListener(this);
        selectorGrafico.getBtnAceptar().addMouseListener(this);
    }
    
    public void setControlesGraficoMasVendidos(boolean estado){
        grafico.getSpinnerCantidadMasVendidos().setVisible(estado);
        grafico.getLabelMasVendidos().setVisible(estado);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(grafico.getBtnElegirGrafico())) {
            mostrarSelectorTipoGrafico();
        } else if (e.getSource().equals(grafico.getBtnActualizar())) {
            mostrarGrafico();
        } else if (e.getSource().equals(selectorGrafico.getBtnAceptar())) {
            elegirGrafico();
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
    
    private void mostrarSelectorTipoGrafico(){
        selectorGrafico.setVisible(true);
    }
    
    private void mostrarGrafico(){
        if (graficoElegido == 1) {
            ChartPanel panel = CrearGrafico.generarGraficoBarras(graficoDAO.costosCompraMes());
            grafico.getlblTituloGraficos().setText("GRAFICO DE COSTOS REALIZADOS");
            grafico.getPanelBase().removeAll();
            grafico.getPanelBase().add(panel);
            panel.setBounds(0, 0, 770, 445);
            grafico.getPanelBase().updateUI();
            System.out.println("Grafica correctamente");
        } else if (graficoElegido == 2) {
            grafico.getlblTituloGraficos().setText("GRAFICO DE VENTAS REALIZADAS");
            System.out.println("donde esta este grafico?");
        } else if (graficoElegido == 3) {
            grafico.getlblTituloGraficos().setText("GRAFICO DE COMPARACION DE LIBROS");
            librosMasVen = graficoDAO.getLibrosMasVendidos(Integer.parseInt
        (grafico.getSpinnerCantidadMasVendidos().getValue().toString()));
            tituloLibros = graficoDAO.libros;
            ChartPanel panelGrafico = CrearGrafico.generarGraficoDobleEje(librosMasVen, tituloLibros);
            grafico.getPanelBase().removeAll();
            grafico.getPanelBase().add(panelGrafico);
            panelGrafico.setBounds(0, 0, 770, 445);
            grafico.getPanelBase().updateUI();
        }
    }
    
    private void elegirGrafico(){
        if (selectorGrafico.getRdbtnCostosRealizados().isSelected()){
            graficoElegido = 1;
            selectorGrafico.dispose();
            setControlesGraficoMasVendidos(false);
        } else if (selectorGrafico.getRdbtnVentasRealizadas().isSelected()) {
            graficoElegido = 2;
            selectorGrafico.dispose();
            setControlesGraficoMasVendidos(false);
        } else if (selectorGrafico.getRdbtnComparacionLibros().isSelected()) {
            graficoElegido = 3;
            selectorGrafico.dispose();
            setControlesGraficoMasVendidos(true);
        } else {
            JOptionPane.showMessageDialog(null, "Escoja una opción");
        }
    }
    
}
