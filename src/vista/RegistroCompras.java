/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Veymar Montaño Colqu
 */
public class RegistroCompras extends javax.swing.JPanel {

    /**
     * Creates new form RegistroCompras
     */
    public RegistroCompras() {
        initComponents();
    }

    public JLabel getLabelErrorCoincidencia() {
        return labelErrorCoincidencia;
    }

    public JLabel getLabelIconoLibros() {
        return labelIconoLibros;
    }

    public JLabel getLabelIconoStock() {
        return labelIconoStock;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupFiltro = new javax.swing.ButtonGroup();
        btnRadioListaLibros = new javax.swing.JRadioButton();
        btnRadioControlStock = new javax.swing.JRadioButton();
        panelTabla = new javax.swing.JPanel();
        jScrollPanePanelTabla = new javax.swing.JScrollPane();
        tableRegistroLibros = new javax.swing.JTable();
        panelControlesDeFiltros = new javax.swing.JPanel();
        labelTituloBuscar = new javax.swing.JLabel();
        txtBuscarLibro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        labelErrorCoincidencia = new javax.swing.JLabel();
        labelDescripcionLista = new javax.swing.JLabel();
        btnComprar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        labelIconoLibros = new javax.swing.JLabel();
        labelIconoStock = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(5, 5, 28));
        setPreferredSize(new java.awt.Dimension(798, 556));

        btnGroupFiltro.add(btnRadioListaLibros);
        btnRadioListaLibros.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRadioListaLibros.setForeground(new java.awt.Color(255, 255, 255));
        btnRadioListaLibros.setSelected(true);
        btnRadioListaLibros.setText("Lista de libros");

        btnGroupFiltro.add(btnRadioControlStock);
        btnRadioControlStock.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRadioControlStock.setForeground(new java.awt.Color(255, 255, 255));
        btnRadioControlStock.setText("Control de Stock");

        panelTabla.setLayout(null);

        tableRegistroLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "TITULO", "AUTOR", "EDICION", "CANTIDAD MINIMA", "STOCK ACTUAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableRegistroLibros.getTableHeader().setReorderingAllowed(false);
        jScrollPanePanelTabla.setViewportView(tableRegistroLibros);

        panelTabla.add(jScrollPanePanelTabla);
        jScrollPanePanelTabla.setBounds(10, 11, 750, 186);

        panelControlesDeFiltros.setBackground(new java.awt.Color(153, 153, 153));

        labelTituloBuscar.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        labelTituloBuscar.setForeground(new java.awt.Color(255, 255, 255));
        labelTituloBuscar.setText("Buscar :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("IngreseTitulo del Libro");

        labelErrorCoincidencia.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        labelErrorCoincidencia.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout panelControlesDeFiltrosLayout = new javax.swing.GroupLayout(panelControlesDeFiltros);
        panelControlesDeFiltros.setLayout(panelControlesDeFiltrosLayout);
        panelControlesDeFiltrosLayout.setHorizontalGroup(
            panelControlesDeFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelControlesDeFiltrosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelControlesDeFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelControlesDeFiltrosLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelErrorCoincidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelTituloBuscar))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        panelControlesDeFiltrosLayout.setVerticalGroup(
            panelControlesDeFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelControlesDeFiltrosLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(labelTituloBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelControlesDeFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelErrorCoincidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelControlesDeFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        labelDescripcionLista.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelDescripcionLista.setForeground(new java.awt.Color(255, 255, 255));
        labelDescripcionLista.setText("LISTA TOTAL DE LIBROS");

        btnComprar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnComprar.setText("COMPRAR");

        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarMouseClicked(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminar.setText("ELIMINAR");

        labelIconoLibros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/librosIcono.png"))); // NOI18N

        labelIconoStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/STOCKIcono.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO DE COMPRAS Y STOCK");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelDescripcionLista))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelControlesDeFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(labelIconoLibros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRadioListaLibros)
                        .addGap(122, 122, 122)
                        .addComponent(labelIconoStock)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRadioControlStock))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel1)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelIconoLibros, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelIconoStock, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRadioControlStock)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRadioListaLibros)
                        .addGap(10, 10, 10)))
                .addGap(17, 17, 17)
                .addComponent(panelControlesDeFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelDescripcionLista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.ButtonGroup btnGroupFiltro;
    private javax.swing.JRadioButton btnRadioControlStock;
    private javax.swing.JRadioButton btnRadioListaLibros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPanePanelTabla;
    private javax.swing.JLabel labelDescripcionLista;
    private javax.swing.JLabel labelErrorCoincidencia;
    private javax.swing.JLabel labelIconoLibros;
    private javax.swing.JLabel labelIconoStock;
    private javax.swing.JLabel labelTituloBuscar;
    private javax.swing.JPanel panelControlesDeFiltros;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JTable tableRegistroLibros;
    private javax.swing.JTextField txtBuscarLibro;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the btnComprar
     */
    public javax.swing.JButton getBtnComprar() {
        return btnComprar;
    }

    /**
     * @return the btnEditar
     */
    public javax.swing.JButton getBtnEditar() {
        return btnEditar;
    }

    /**
     * @return the btnEliminar
     */
    public javax.swing.JButton getBtnEliminar() {
        return btnEliminar;
    }

    /**
     * @return the btnRadioControlStock
     */
    public javax.swing.JRadioButton getBtnRadioControlStock() {
        return btnRadioControlStock;
    }

    /**
     * @return the btnRadioListaLibros
     */
    public javax.swing.JRadioButton getBtnRadioListaLibros() {
        return btnRadioListaLibros;
    }

    /**
     * @return the labelDescripcionLista
     */
    public javax.swing.JLabel getLabelDescripcionLista() {
        return labelDescripcionLista;
    }

    /**
     * @return the tableRegistroLibros
     */
    public javax.swing.JTable getTableRegistroLibros() {
        return tableRegistroLibros;
    }

    /**
     * @return the txtBuscarLibro
     */
    public javax.swing.JTextField getTxtBuscarLibro() {
        return txtBuscarLibro;
    }
}
