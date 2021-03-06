/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Restriccion;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Veymar Montaño Colqu
 */

public class RegistroCompras2 extends JPanel {
    private JScrollPane scrollPanel;
    
    private JPanel panelTabla;
    private JPanel pnlTablaCompra;
    private JScrollPane scrollTabla;
    private JScrollPane pane;
    private JTable tablaDesplegable;
    private JTable tablaCompra;
    
    private final String[] titulosTabla = {"TITULO","AUTOR","GENERO","EDICION",
                  "CANTIDAD","COMPRA","VENTA","MINIMO"};
    
    private JTextFieldP txtTitulo;
    private JTextFieldP txtAutor;
    private JTextFieldP txtGenero;
    private JTextFieldP txtEdicion;
    private JTextFieldP txtCantidad;
    private JTextFieldP txtPrecioCompra;
    private JTextFieldP txtPrecioVenta;
    private JTextFieldP txtCantidadMinima;
    
    private JButton btnLimpiar;
    private JButton btnAgregar;

    JTextField campo = new JTextField();
    private Restriccion restriccion;
    
    /**
     * Creates new form RegistroCompras
     */
    public RegistroCompras2() {
        restriccion = new Restriccion();
        initComponents();
        initOtherComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        labelTituloBuscar = new javax.swing.JLabel();
        comboBoxBuscarEn = new javax.swing.JComboBox();
        btnEliminar = new javax.swing.JButton();
        btnComprar1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(5, 5, 28));
        setPreferredSize(new java.awt.Dimension(798, 556));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO DE COMPRAS Y STOCK");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel1);
        jLabel1.setBounds(252, 11, 372, 59);

        labelTituloBuscar.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        labelTituloBuscar.setForeground(new java.awt.Color(255, 255, 255));
        labelTituloBuscar.setText("Buscar :");
        add(labelTituloBuscar);
        labelTituloBuscar.setBounds(46, 74, 82, 25);

        comboBoxBuscarEn.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "lista de libros", "control de stock", "libros dados de baja" }));
        add(comboBoxBuscarEn);
        comboBoxBuscarEn.setBounds(47, 105, 170, 30);

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setMaximumSize(new java.awt.Dimension(89, 26));
        btnEliminar.setMinimumSize(new java.awt.Dimension(89, 26));
        btnEliminar.setPreferredSize(new java.awt.Dimension(89, 26));
        add(btnEliminar);
        btnEliminar.setBounds(600, 530, 90, 25);

        btnComprar1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnComprar1.setText("Comprar");
        btnComprar1.setPreferredSize(null);
        add(btnComprar1);
        btnComprar1.setBounds(700, 530, 90, 26);
    }// </editor-fold>//GEN-END:initComponents

    private void initOtherComponents() {
        txtTitulo = new JTextFieldP();
        txtAutor = new JTextFieldP();
        txtGenero = new JTextFieldP();
        txtEdicion = new JTextFieldP();
        txtCantidad = new JTextFieldP();
        txtPrecioCompra = new JTextFieldP();
        txtPrecioVenta = new JTextFieldP();
        txtCantidadMinima = new JTextFieldP();
        

        panelTabla = new JPanel();
        scrollPanel = new JScrollPane();
        tablaDesplegable = new JTable();
        scrollTabla = new JScrollPane();
        
        panelTabla.setPreferredSize(new Dimension(900, 275));
        panelTabla.setLayout(null);
        
        DefaultTableModel tableModel = (DefaultTableModel)tablaDesplegable.getModel();
        tableModel.setDataVector(null, titulosTabla);
        
        tableModel = (DefaultTableModel)tablaDesplegable.getModel();
        tableModel.setDataVector(null, titulosTabla);
        
        TableColumnModel columnModel = tablaDesplegable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(200);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(130);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(100);
        columnModel.getColumn(5).setPreferredWidth(100);
        columnModel.getColumn(6).setPreferredWidth(100);
        columnModel.getColumn(7).setPreferredWidth(100);
        
        scrollTabla.setViewportView(tablaDesplegable);
        panelTabla.add(scrollTabla);
        scrollTabla.setBounds(0, 0, 900, 275);
        
        scrollPanel.setViewportView(panelTabla);
        add(scrollPanel);
        scrollPanel.setBounds(47, 166, 748, 300);
        scrollPanel.setVisible(false);

        
        btnLimpiar = new JButton("Limpiar");
        btnAgregar = new JButton("Agregar");

        btnLimpiar.setFont(new Font("Tahoma", 1, 13));
        btnAgregar.setFont(new Font("Tahoma", 1, 13));
        
        txtTitulo.setPlaceholder("titulo");
        add(txtTitulo);
        txtTitulo.setBounds(47, 140, 190, 30);
        
        txtAutor.setPlaceholder("autor");
        add(txtAutor);
        txtAutor.setBounds(233, 140, 190, 30);

        txtGenero.setPlaceholder("genero");
        add(txtGenero);
        txtGenero.setBounds(419, 140, 190, 30);

        txtEdicion.setPlaceholder("edición");
        add(txtEdicion);
        txtEdicion.setBounds(605, 140, 190, 30);

        txtCantidad.setPlaceholder("cantidad");
        add(txtCantidad);
        txtCantidad.setBounds(47, 170, 125, 30);

        txtPrecioCompra.setPlaceholder("precio de compra");
        add(txtPrecioCompra);
        txtPrecioCompra.setBounds(168, 170, 125, 30);

        txtPrecioVenta.setPlaceholder("precio de venta");
        add(txtPrecioVenta);
        txtPrecioVenta.setBounds(289, 170, 125, 30);

        txtCantidadMinima.setPlaceholder("cantidad mínima");
        add(txtCantidadMinima);
        txtCantidadMinima.setBounds(410, 170, 125, 30);
        
        add(btnLimpiar);
        btnLimpiar.setBounds(600, 170, 90, 30);
        
        add(btnAgregar);
        btnAgregar.setBounds(700, 170, 90, 30);
        
        pnlTablaCompra = new JPanel();
        add(pnlTablaCompra);
        
        pnlTablaCompra.setBounds(50, 220, 740, 290);
        tablaCompra = new JTable();

        tablaCompra.setModel(new DefaultTableModel(
            new Object [][] {
                
            },
            new String [] {
                "TITULO", "AUTOR", "GENERO", "EDICION", "CANTIDAD", "COSTO COMPRA"
            }
        ) 
        {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }   
        });
        
        
        TableColumn columna = tablaCompra.getColumnModel().getColumn(4);
        columna.setCellEditor(new DefaultCellEditor (campo));
        campo.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char caracter = e.getKeyChar();
                if(!restriccion.esEntero(caracter, 3, campo)){
                    e.consume();
                } else {
                    campo.setEditable(true);
                }
            }
        });
        campo.addFocusListener(new java.awt.event.FocusAdapter(){
            public void focusLost (java.awt.event.FocusEvent evt){
                if(campo.getText().length() == 0){
                    campo.setText("1");
                    campo.setVisible(true);
                    System.out.println("No se puede salir de foco");
                    
                    campo.requestFocus();
                }
            }
        });
        
        tablaCompra.setRowHeight(25);
        //tablaCompra.getColumnModel().getColumn(4).setPreferredWidth(5);
        tablaCompra.setPreferredSize(new Dimension(725, 250));
        tablaCompra.getTableHeader().setReorderingAllowed(false);

        tablaCompra.setPreferredScrollableViewportSize(tablaCompra.getPreferredSize());
        pane = new JScrollPane(tablaCompra);
        pnlTablaCompra.add(pane);
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprar1;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox comboBoxBuscarEn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelTituloBuscar;
    // End of variables declaration//GEN-END:variables

    public JTextFieldP getTxtTitulo() {
        return txtTitulo;
    }

    public JTextFieldP getTxtAutor() {
        return txtAutor;
    }

    public JTextFieldP getTxtGenero() {
        return txtGenero;
    }

    public JTextFieldP getTxtEdicion() {
        return txtEdicion;
    }

    public JTextFieldP getTxtCantidad() {
        return txtCantidad;
    }

    public JTextFieldP getTxtPrecioCompra() {
        return txtPrecioCompra;
    }

    public JTextFieldP getTxtPrecioVenta() {
        return txtPrecioVenta;
    }

    public JTextFieldP getTxtCantidadMinima() {
        return txtCantidadMinima;
    }

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JTable getTablaDesplegable() {
        return tablaDesplegable;
    }

    public JScrollPane getScrollPanel() {
        return scrollPanel;
    }

    public JComboBox getComboBoxBuscarEn() {
        return comboBoxBuscarEn;
    }
    
    public JButton getBtnEliminar()
    {
        return btnEliminar;
    }
    
    public JTable getTablaCompra()
    {
        return tablaCompra;
    }

    public JButton getBtnComprar1() {
        return btnComprar1;
    }
    
    
    public void anadirFilaCompra(Object[] dato) 
     {
        ((DefaultTableModel) tablaCompra.getModel()).addRow(dato);
    }
    public void eliminarFilaCompra(int fila) 
    {
        System.out.println(tablaCompra.getRowCount()+" "+fila);
        ((DefaultTableModel) tablaCompra.getModel()).removeRow(fila);
    }     
     
}
