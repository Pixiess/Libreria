/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import controlador.ConexionPostgresql;
import controlador.Controlador;
import controlador.LibroIndice;
import controlador.VentaBD;
import java.awt.Window;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import modelo.JavaPdf;
import modelo.Libro;

/**
 *
 * @author Alejandra
 */

public class RegistroVentas extends javax.swing.JDialog 
{       
    private DefaultTableModel tablaVentas;
    private String[] cabecera;
    //boolean[] editables;
    private ArrayList<Libro> ventas;    
    private ArrayList<Integer>lventas;
    private ArrayList<Integer> idVentas;
    private SpinnerVentas cnt;
    
    /**
     * Creates new form RegistroVentas
     */
    public RegistroVentas(java.awt.Frame parent, boolean modal, Controlador c)
    {
        
        super(parent, modal);
        initComponents();
        setListeners(c);
        this.setLocationRelativeTo(null);
        
        tablaVentas = (DefaultTableModel)ventaJTable.getModel();
        
        lventas = new ArrayList<Integer>();
        ventas = new ArrayList<Libro>();
        idVentas = new ArrayList<Integer>();
        establecerTabla();
        ponerFecha();
        SpinnerVentas cnt = new SpinnerVentas(1,this, 1000);
        ventaJTable.getColumn("Cantidad").setCellEditor(cnt);
    }
    
    private void setListeners(Controlador c)
    {
        eliminarJB.addMouseListener(c);
        btnFactura.addMouseListener(c);
    }
    
    public void establecerTabla(){
        ventaJTable.setRowHeight(30);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        DCliente = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtCliente = new javax.swing.JTextField();
        txtNit = new javax.swing.JTextField();
        agregarJB = new javax.swing.JButton();
        TablaJPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ventaJTable = new javax.swing.JTable();
        btnFactura = new javax.swing.JButton();
        eliminarJB = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Ventas");

        jPanel1.setBackground(new java.awt.Color(5, 5, 28));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRO DE VENTAS");

        DCliente.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Cliente :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("NIT/CI  :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Fecha :");

        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });
        txtCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClienteKeyTyped(evt);
            }
        });

        txtNit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNitKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout DClienteLayout = new javax.swing.GroupLayout(DCliente);
        DCliente.setLayout(DClienteLayout);
        DClienteLayout.setHorizontalGroup(
            DClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DClienteLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(DClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(DClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DClienteLayout.createSequentialGroup()
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNit, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        DClienteLayout.setVerticalGroup(
            DClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DClienteLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(DClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(DClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtNit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        agregarJB.setText("Agregar Libro");
        agregarJB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregarJBMouseClicked(evt);
            }
        });

        ventaJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cantidad", "Nombre", "Autor", "Precio", "PrecioTotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ventaJTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(ventaJTable);
        if (ventaJTable.getColumnModel().getColumnCount() > 0) {
            ventaJTable.getColumnModel().getColumn(0).setHeaderValue("Cantidad");
            ventaJTable.getColumnModel().getColumn(1).setHeaderValue("Nombre");
            ventaJTable.getColumnModel().getColumn(2).setHeaderValue("Autor");
            ventaJTable.getColumnModel().getColumn(3).setHeaderValue("Precio");
            ventaJTable.getColumnModel().getColumn(4).setHeaderValue("PrecioTotal");
        }

        javax.swing.GroupLayout TablaJPanelLayout = new javax.swing.GroupLayout(TablaJPanel);
        TablaJPanel.setLayout(TablaJPanelLayout);
        TablaJPanelLayout.setHorizontalGroup(
            TablaJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        TablaJPanelLayout.setVerticalGroup(
            TablaJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TablaJPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnFactura.setText("Generar Factura");
        btnFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFacturaMouseClicked(evt);
            }
        });
        btnFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturaActionPerformed(evt);
            }
        });

        eliminarJB.setText("Eliminar Libro");
        eliminarJB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarJBMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 255, 255));
        jLabel5.setText("TOTAL A PAGAR :");

        txtTotal.setEditable(false);
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(agregarJB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(eliminarJB)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(TablaJPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFactura, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarJB)
                    .addComponent(eliminarJB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TablaJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(27, 27, 27)
                .addComponent(btnFactura)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed

    }//GEN-LAST:event_txtTotalActionPerformed

    
    private void eliminarJBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarJBMouseClicked
     /*   int row = getSelectedRow();
        if(row >= 0)
        {
            eliminarLibVenta(row);
            eliminarFilaVenta(row);
        }*/
    }//GEN-LAST:event_eliminarJBMouseClicked

    private void agregarJBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarJBMouseClicked
        
        BuscadorLibros buscadorLibros = new BuscadorLibros(new javax.swing.JDialog(), true);
                buscadorLibros.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        Window buscador = e.getWindow();
                        if(buscador instanceof JDialog)
                            ((JDialog)buscador).dispose();
                    }
                });
                buscadorLibros.setVisible(true);
                
        Libro libro = buscadorLibros.getLibroBuscado();
       //Libro libro = new Libro(1, "El Resplandor", "Stephen King", "Novela terror", 12, 30.0, 35.0);
        
       Object [] datos = {1, libro.getNombreLibro(), libro.getAutorLibro(), ""+libro.getCostoVenta(), 0};        
       
       int id = libro.getIdLibro();
       
       if(!contiene(id))
       {
            anadirFilaVenta(datos);
            anadirLibVenta(id);
            ventas.add(libro);
            //int total = suma();
            //this.txtTotal.setText( String.valueOf(total) );
       }
       else
       {
           JOptionPane.showMessageDialog(null, "Usted ya agrego el libro");

       }
       
       
    }//GEN-LAST:event_agregarJBMouseClicked
       
    
    private void btnFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturaActionPerformed

    }//GEN-LAST:event_btnFacturaActionPerformed

    private void btnFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFacturaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFacturaMouseClicked

    private void txtClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteKeyTyped
        
        if (Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtClienteKeyTyped

    private void txtNitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNitKeyTyped

        if (!Character.isDigit(evt.getKeyChar()) || txtNit.getText().length()>9) {
            evt.consume();
        }
        
    }//GEN-LAST:event_txtNitKeyTyped

     private void ponerFecha() {
        Date fec = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = sdf.format(fec);
        txtFecha.setText(fecha);
        txtFecha.setEditable(false);
    }
                                              

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DCliente;
    private javax.swing.JPanel TablaJPanel;
    private javax.swing.JButton agregarJB;
    private javax.swing.JButton btnFactura;
    private javax.swing.JButton eliminarJB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNit;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTable ventaJTable;
    // End of variables declaration//GEN-END:variables

    public JButton getAgregar()
    {
        return agregarJB;
    }
    
    public JButton getEliminar()
    {
        return eliminarJB;
    }
    
    public JButton getFactura(){
        return btnFactura;
    }
    
    public JTable getVentaTabla()
    {
        return ventaJTable;
    }
    
    public int getSelectedRow()
    {
        return ventaJTable.getSelectedRow();
    }
    
    public JPanel getPanel()
    {
        return jPanel1;
    }
    
    public JTextField getFecha(){
        return txtFecha;
    }
    
    public JTextField getCliente(){
        return txtCliente;
    }
    
    public JTextField getNit(){
        return txtNit;
    }
    
    public JTextField getCostoTotal()
    {
        return txtTotal;
    }
    
    public void anadirFilaVenta(Object [] dataRow)
    {
	((DefaultTableModel)ventaJTable.getModel()).addRow(dataRow);
    }
    
    public void eliminarFilaVenta(int rowIndex)
    {
        ((DefaultTableModel)ventaJTable.getModel()).removeRow(rowIndex);
    }
    
    public void anadirLibVenta(int id)
    {
        lventas.add(id);
    }
    
    public void eliminarLibVenta(int pos)
    {
        lventas.remove(pos);
    }
    
    private boolean contiene(int id)
    {
        Collections.sort(lventas);
        
        if(lventas.contains(id))
            return true;
        
        return false;
    }
    
    public ArrayList<Libro> getListaPorVender(){
        return ventas;
    }
    
    public ArrayList<Integer> getIdVentas(){
        return idVentas;
    }
    
    public ArrayList<Integer> getLventas(){
        return lventas;
    }
    
    public void iniciarLventas(){
        lventas = new ArrayList<>();
    }
    
    
    public void deleteAllRows()
    {
        int count = ventaJTable.getRowCount();
        for( int i = count - 1; i >= 0; i-- ) 
            eliminarFilaVenta(i);
    
        lventas = new ArrayList<>();
    }
    
    
    public void setComponents()
    {
        txtCliente.setText("");
        txtNit.setText("");
        txtTotal.setText("0.00");
        deleteAllRows();
    }
}
