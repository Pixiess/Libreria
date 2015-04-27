/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import modelo.Libro;
/**
 *
 * @author USUARIO
 */
public class TModelListener implements TableModelListener{

    public RegistroVentas ventana;
    //private JTable modelo;
    ArrayList<Libro> ventas;
    private JTextField costoTotal;
    
    /*public void sumar(TableModel modelo){
            double suma = 0;
            
            for(int i = 0; i< modelo.getRowCount(); i++){
                suma = suma + (double)modelo.getValueAt(i, 4);
                //System.out.println(suma);
            }
            costoTotal.setText(String.valueOf(suma));
        }*/
    
    @Override
    public void tableChanged(TableModelEvent e) {
        
        TableModel modelo = ( (TableModel) ( e.getSource() ) );
            System.out.println(modelo.getColumnCount() + " " + modelo.getRowCount());
            //modelo = ventana.getVentaTabla();
            int fila = e.getFirstRow();
            int columna = e.getColumn();
            
            //System.out.println(fila + " " + columna);
            if ( columna == 4 ) {return;}
            try{
                //obtiene valor de celda editable
                int a =  Integer.parseInt((String)modelo.getValueAt(fila,columna));
                System.out.println(a);
                //obtiene valor de celda no editable
                double b =  Double.parseDouble((String)modelo.getValueAt(fila,columna+3));
                
                
                
                modelo.setValueAt((double)a * b , fila, columna+4);
                //sumar(modelo);
                
                
            }catch (NullPointerException ex) {
            /*...*/ } 
    }
    
    
    
}
