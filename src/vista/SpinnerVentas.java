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
import java.awt.event.KeyEvent;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author USUARIO
 */
public class SpinnerVentas extends DefaultCellEditor implements TableCellEditor{
    
    private JSpinner spinner;
    private Object valorInicial;
    private Object valorActual;
    private RegistroVentas ventana;
    private JTextField costoTotal;
    JSpinner.DefaultEditor editor;
    JTextField textField;
    boolean valueSet;
    private JTable tabla;
    
    private int fila;
    private int columna;
        // Initializes the spinner.
        public SpinnerVentas(int intervalo, RegistroVentas ventana, int stock) {
            super(new JTextField());
            tabla = ventana.getVentaTabla();
            spinner = new JSpinner();
            costoTotal = ventana.getCostoTotal();
            spinner.setModel(new SpinnerNumberModel(1, 1, stock, intervalo));
            editor = ((JSpinner.DefaultEditor)spinner.getEditor());
            textField = editor.getTextField();
            textField.addFocusListener( new FocusListener() {
                public void focusGained( FocusEvent fe ) {
                    System.err.println("Got focus");
                    //textField.setSelectionStart(0);
                    //textField.setSelectionEnd(1);
                    SwingUtilities.invokeLater( new Runnable() {
                        public void run() {
                            if ( valueSet ) {
                                textField.setCaretPosition(1);
                            }
                        }
                    });
                }
                public void focusLost( FocusEvent fe ) {
                }
            });
            textField.addActionListener( new ActionListener() {
                public void actionPerformed( ActionEvent ae ) {
                    stopCellEditing();
                }
            });
            spinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e){
                Integer valorActual = (Integer)spinner.getValue();
                Double precio = Double.parseDouble((String)tabla.getValueAt(fila, 3));
                tabla.setValueAt(valorActual*precio, fila, 4);
                double acum = valorActual*precio;
                costoTotal.setText(String.valueOf(acum));
            }
        });
        }

        // Prepares the spinner component and returns it.
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column
        ) {
            tabla = table;
            fila = row;
            columna = column;
            
            if ( !valueSet ) {
                spinner.setValue(value);
            }
            SwingUtilities.invokeLater( new Runnable() {
                public void run() {
                    textField.requestFocus();
                }
            });
            return spinner;
        }

        public boolean isCellEditable( EventObject eo ) {
            System.err.println("isCellEditable");
            if ( eo instanceof KeyEvent ) {
                KeyEvent ke = (KeyEvent)eo;
                System.err.println("key event: "+ke.getKeyChar());
                textField.setText(String.valueOf(ke.getKeyChar()));
                //textField.select(1,1);
                //textField.setCaretPosition(1);
                //textField.moveCaretPosition(1);
                valueSet = true;
            } else {
                valueSet = false;
            }
            return true;
        }

        // Returns the spinners current value.
        public Object getCellEditorValue() {
            return spinner.getValue();
        }

        public boolean stopCellEditing() {
            System.err.println("Stopping edit");
            try {
                editor.commitEdit();
                spinner.commitEdit();
            } catch ( java.text.ParseException e ) {
                JOptionPane.showMessageDialog(null,
                    "Invalid value, discarding.");
            }
            return super.stopCellEditing();
        }
        
}

