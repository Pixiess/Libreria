package vista;

import javax.swing.JButton;
import javax.swing.JRadioButton;

public class TipoGrafico extends javax.swing.JDialog {

    
    public TipoGrafico(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        rdbtnCostosRealizados = new javax.swing.JRadioButton();
        rdbtnVentasRealizadas = new javax.swing.JRadioButton();
        rdbtnComparacionLibros = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(5, 5, 28));

        btnAceptar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnAceptar.setText("Aceptar");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tipo de gráfico");

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        rdbtnCostosRealizados.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup1.add(rdbtnCostosRealizados);
        rdbtnCostosRealizados.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        rdbtnCostosRealizados.setSelected(true);
        rdbtnCostosRealizados.setText("Gráfico de costos realizados");

        rdbtnVentasRealizadas.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup1.add(rdbtnVentasRealizadas);
        rdbtnVentasRealizadas.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        rdbtnVentasRealizadas.setText("Gráfico de ventas realizadas");

        rdbtnComparacionLibros.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup1.add(rdbtnComparacionLibros);
        rdbtnComparacionLibros.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        rdbtnComparacionLibros.setText("Gráfico de comparación de libros");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdbtnComparacionLibros)
                    .addComponent(rdbtnVentasRealizadas)
                    .addComponent(rdbtnCostosRealizados))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(rdbtnCostosRealizados)
                .addGap(18, 18, 18)
                .addComponent(rdbtnVentasRealizadas)
                .addGap(18, 18, 18)
                .addComponent(rdbtnComparacionLibros)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addGap(99, 99, 99))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addComponent(btnAceptar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton rdbtnComparacionLibros;
    private javax.swing.JRadioButton rdbtnCostosRealizados;
    private javax.swing.JRadioButton rdbtnVentasRealizadas;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnAceptar(){
        return btnAceptar;
    }
    
    public JRadioButton getRdbtnCostosRealizados() {
        return rdbtnCostosRealizados;
    }

    public JRadioButton getRdbtnVentasRealizadas() {
        return rdbtnVentasRealizadas;
    }

    public JRadioButton getRdbtnComparacionLibros() {
        return rdbtnComparacionLibros;
    }
    
}
