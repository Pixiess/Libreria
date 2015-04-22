/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author USUARIO
 */
public class SpinnerVentas extends AbstractCellEditor implements TableCellEditor{
    
    private JSpinner spinner;
    private JTable tbl;
    private Object valorInicial;
    private Object valorActual;
    private RegistroVentas ventana;
    
    private int fila;
    private int columna;
    
    public SpinnerVentas(int intervalo, RegistroVentas ventana, int stock){
        this.ventana = ventana;
        spinner = new JSpinner();
        spinner.setModel(new SpinnerNumberModel(1, 1, stock, intervalo));
        ChangeListener listener = new ChangeListener() {
        public void stateChanged(ChangeEvent e){
            JSpinner temp = (JSpinner)e.getSource();
            ((DefaultEditor)temp.getEditor()).getTextField().setHorizontalAlignment(JTextField.LEFT);
            Integer vi = (Integer)valorInicial;
            Integer nv = (Integer)temp.getValue();
            if(vi != null){
                int sd = -1;
                valorActual = temp.getValue();
                System.out.println(valorActual);
            }
            ((DefaultEditor)temp.getEditor()).getTextField().setHorizontalAlignment(JTextField.RIGHT);
            
            
        }
        };
        spinner.addChangeListener(listener);
    }

    @Override
    public Object getCellEditorValue() {
        
        return valorActual;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        valorActual = value;
        if(valorInicial == null)
        {
            valorInicial = table.getModel().getValueAt(row, column);
            
        }
        return spinner;
    }
    
}
