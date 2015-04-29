/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.TableCellEditor;
import modelo.Libro;

/**
 *
 * @author USUARIO
 */
public class EditorCampo extends AbstractCellEditor implements TableCellEditor{

    private RegistroVentas ventana;
    private JTextField costoTotal;
    ArrayList<Libro> ventas;
    boolean valueSet;
    JTable tabla;
    JTextField campos;
    int fila;
    int columna;
    
    public EditorCampo(JTextField campos, RegistroVentas ventana) {
        tabla = ventana.getVentaTabla();
        costoTotal = ventana.getCostoTotal();
        ventas = ventana.getListaPorVender();
        this.campos = campos;
        
        
        campos.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                if(!Character.isDigit(e.getKeyChar()) && e.getKeyChar() !=KeyEvent.VK_BACK_SPACE ){
                    e.consume();
                }else{
                    if(campos.getText().length() >= 7){
                        e.consume();
                    }else{
                        //System.out.println(campos.getText().length());
                        campos.setEditable(true);
                        
                    }
                }
            } 
        });
        
        campos.addFocusListener(new FocusListener(){

            @Override
            public void focusGained(FocusEvent e) {
                //System.err.println("Got focus");
                //campos.setEnabled(true);
                SwingUtilities.invokeLater( new Runnable() {
                        public void run() {
                            if ( valueSet ) {
                                campos.setCaretPosition(1);
                            }
                        }
                    });
            }
            @Override
            public void focusLost(FocusEvent e) {
                //System.out.println("Foco perdido");
                actualizarCampo();
                stopCellEditing();
            }
            
        });
        
        campos.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarCampo();
                stopCellEditing();
            }
        });
        
    }
    
    public void actualizarCampo(){
        for(Libro x : ventas){
                    if(((String)tabla.getValueAt(fila, 1)).equals(x.getNombreLibro())
                      && ((String)tabla.getValueAt(fila, 2)).equals(x.getAutorLibro())
                      ){
                    if(campos.getText().length()> 0){    
                        Integer valorActual = Integer.parseInt(campos.getText());
                        int valor = x.getStockDisponible();
                        if((valorActual > valor) || (valorActual == 0)){
                            if(valorActual > valor){
                                JOptionPane.showMessageDialog( null , "Error: La cantidad disponible es de " + valor + " unidades");
                            }else if(valorActual == 0){
                                JOptionPane.showMessageDialog( null , "Error: La cantidad minima es de 1 unidad");
                            }
                            tabla.setValueAt("1", fila, 0);
                            campos.setText("1");
                            tabla.setValueAt(x.getCostoVenta(), fila, 4);
                            
                            //return;
                        }else{
                            Double precio = Double.parseDouble((String)tabla.getValueAt(fila, 3));
                            tabla.setValueAt(valorActual*precio, fila, 4);
                            //sumar();
                        }
                    }else{
                        JOptionPane.showMessageDialog( null , "Error: Agregue un numero al campo");
                        tabla.setValueAt("1", fila, 0);
                        campos.setText("1");
                        tabla.setValueAt(x.getCostoVenta(), fila, 4);
                        //sumar();
                    }
                    sumar();
                    }
                }
        
    }

    public void sumar(){
            double suma = 0;
            for(int i = 0; i < tabla.getRowCount(); i++){
                double cantidad = Double.valueOf(tabla.getValueAt(i, 4).toString()).doubleValue();
                suma = suma + cantidad;
            }
            costoTotal.setText(String.valueOf(suma));
        }
    
    public boolean isCellEditable( EventObject eo ) {
            //System.err.println("isCellEditable");
            if ( eo instanceof KeyEvent ) {
                KeyEvent ke = (KeyEvent)eo;
                System.err.println("key event: "+ke.getKeyChar());
                campos.setText(String.valueOf(ke.getKeyChar()));
                //textField.select(1,1);
                //textField.setCaretPosition(1);
                //textField.moveCaretPosition(1);
                valueSet = true;
            } else {
                valueSet = false;
            }
            return true;
        }
    
    @Override
    public Object getCellEditorValue() {
        return (String)campos.getText();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            tabla = table;
            fila = row;
            columna = column;
            
            if ( !valueSet ) {
                campos.setText(String.valueOf(value));
            }
            SwingUtilities.invokeLater( new Runnable() {
                public void run() {
                    //System.out.println("Que pasa aqui");
                    campos.requestFocus();
                }
            });
            
            return campos;
    }
    
}
