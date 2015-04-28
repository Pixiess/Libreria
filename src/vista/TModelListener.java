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
    
    public void ajuste(TableModelEvent e){
        
        costoTotal = ventana.getCostoTotal();
        if(e.getType() == TableModelEvent.UPDATE){
            
            TableModel modelo = ( (TableModel) ( e.getSource() ) );
            
            int fila = e.getFirstRow();
            int columna = e.getColumn();
            
            if ( columna == 4 ) {
                //sumar(modelo);
                System.out.println("Hola");
                return;
            }
            try{
                
                //obtiene valor de celda editable
                int a =  Integer.parseInt((String)modelo.getValueAt(fila,columna));
                char mod = (char)a;
                //System.out.println(a);
                //obtiene valor de celda no editable
                double b =  Double.parseDouble((String)modelo.getValueAt(fila,columna+3));
                
                //restriccion
                if((a <= 0)){
                   JOptionPane.showMessageDialog( null , "Error: El valor debe ser entero positivo.");
                   modelo.setValueAt( null , fila, columna); 
                   modelo.setValueAt( null , fila, columna+3); 
                   return;
                }
                
                modelo.setValueAt((double)a * b , fila, columna+4);
                sumar(modelo);
                
                
                
            }catch (NullPointerException ex) {
            /*...*/ } 
        }
    }
    
    public void sumar(TableModel modelo){
            
            double suma = 0;
            
            for(int i = 0; i< modelo.getRowCount(); i++){
                suma = suma + (double)modelo.getValueAt(i, 4);
                
            }
            costoTotal.setText(String.valueOf(suma));
            System.out.println(suma);
            
        }
    
    @Override
    public void tableChanged(TableModelEvent e) {
        ajuste(e);
    }
    
    
    
}
