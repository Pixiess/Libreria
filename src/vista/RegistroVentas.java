package vista;

import controlador.Restriccion;
import java.awt.Window;
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
import modelo.Libro;

public class RegistroVentas extends javax.swing.JDialog {

    private DefaultTableModel tablaVentas;
    private String[] cabecera;
    private ArrayList<Libro> ventas;
    private ArrayList<Integer> lventas;
    private ArrayList<Integer> idVentas;

    /**
     * Creates new form RegistroVentas
     */
    public RegistroVentas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(null);

        tablaVentas = (DefaultTableModel) ventaJTable.getModel();
        lventas = new ArrayList<Integer>();
        ventas = new ArrayList<Libro>();
        idVentas = new ArrayList<Integer>();

        establecerTabla();
 

    }

    public void establecerTabla() {
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
        btnAgregar = new javax.swing.JButton();
        TablaJPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ventaJTable = new javax.swing.JTable();
        btnFactura = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnEditarCantidad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Ventas");

        jPanel1.setBackground(new java.awt.Color(5, 5, 28));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
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
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        btnAgregar.setText("Agregar Libro");
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
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
                false, false, false, false, false
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

        btnEliminar.setText("Eliminar Libro");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
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

        btnEditarCantidad.setText("Editar Cantidad");
        btnEditarCantidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarCantidadMouseClicked(evt);
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
                                .addComponent(btnAgregar)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditarCantidad)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar)
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
                    .addComponent(btnAgregar)
                    .addComponent(btnEliminar)
                    .addComponent(btnEditarCantidad))
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
   
    }//GEN-LAST:event_txtClienteActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed

    }//GEN-LAST:event_txtTotalActionPerformed


    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked

    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked

    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturaActionPerformed

    }//GEN-LAST:event_btnFacturaActionPerformed

    private void btnFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFacturaMouseClicked
   
    }//GEN-LAST:event_btnFacturaMouseClicked

    private void txtClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteKeyTyped

    }//GEN-LAST:event_txtClienteKeyTyped

    private void txtNitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNitKeyTyped

    }//GEN-LAST:event_txtNitKeyTyped

    private void btnEditarCantidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarCantidadMouseClicked
        int countRow = getVentaTabla().getRowCount();
        if (countRow > 0) {
            int row = getVentaTabla().getSelectedRow();
            if (row >= 0) {
                editarCantidadLibro(row);
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para editar la cantidad");
            }
        }
    }//GEN-LAST:event_btnEditarCantidadMouseClicked

    public void sumar() {
        double costoTotal = 0;
        for (int i = 0; i < tablaVentas.getRowCount(); i++) {
            String costoPorLibros = tablaVentas.getValueAt(i, 4).toString();
            double costoLibros = Double.valueOf(costoPorLibros).doubleValue();
            costoTotal = costoTotal + costoLibros;
        }
        txtTotal.setText(String.valueOf(costoTotal));
    }

    private void editarCantidadLibro(int row) {
        EdicionCantidad edicionCantidad = new EdicionCantidad(new javax.swing.JDialog(), true, this, row);
        edicionCantidad.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {

                Window buscador = e.getWindow();
                if (buscador instanceof JDialog) {
                    ((JDialog) buscador).dispose();
                }
            }
        });
        edicionCantidad.setVisible(true);
    }




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DCliente;
    private javax.swing.JPanel TablaJPanel;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditarCantidad;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFactura;
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

    public JButton getAgregar() {
        return btnAgregar;
    }

    public JButton getEliminar() {
        return btnEliminar;
    }

    public JButton getFactura() {
        return btnFactura;
    }

    public JTable getVentaTabla() {
        return ventaJTable;
    }

    public int getSelectedRow() {
        return ventaJTable.getSelectedRow();
    }

    public JPanel getPanel() {
        return jPanel1;
    }

    public JTextField getFecha() {
        return txtFecha;
    }

    public JTextField getCliente() {
        return txtCliente;
    }

    public JTextField getNit() {
        return txtNit;
    }

    public JTextField getCostoTotal() {
        return txtTotal;
    }

    public DefaultTableModel getTablaVentas() {
        return tablaVentas;
    }

    public JTextField getTxtFecha() {
        return txtFecha;
    }

    public void anadirFilaVenta(Object[] dataRow) {
        ((DefaultTableModel) ventaJTable.getModel()).addRow(dataRow);
    }

    public void eliminarFilaVenta(int rowIndex) {
        ((DefaultTableModel) ventaJTable.getModel()).removeRow(rowIndex);
    }

    public void anadirLibVenta(int id) {
        lventas.add(id);
    }

    public void eliminarLibVenta(int pos) {
        lventas.remove(pos);
    }

    public boolean contiene(int id) {
        Collections.sort(lventas);
        if (lventas.contains(id)) {
            return true;
        }
        return false;
    }

    public ArrayList<Libro> getListaPorVender() {
        return ventas;
    }

    public ArrayList<Integer> getIdVentas() {
        return idVentas;
    }

    public ArrayList<Integer> getLventas() {
        return lventas;
    }

    public void iniciarLventas() {
        lventas = new ArrayList<>();
    }

    public void anadirListaPorVender(Libro l) {
        ventas.add(l);
    }

    public void deleteAllRows() {
        int count = ventaJTable.getRowCount();
        for (int i = count - 1; i >= 0; i--) {
            eliminarFilaVenta(i);
        }

        lventas = new ArrayList<>();
    }

    public void setComponents() {
        txtCliente.setText("");
        txtNit.setText("");
        txtTotal.setText("0.00");
        deleteAllRows();
    }

    public void setTxtTotal(String s) {
        txtTotal.setText(s);
    }
    
}
