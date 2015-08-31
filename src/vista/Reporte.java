package vista;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jdesktop.swingx.JXDatePicker;

public class Reporte extends javax.swing.JPanel {

    public Reporte() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDatePickerUtil1 = new org.jdatepicker.util.JDatePickerUtil();
        jDatePickerUtil2 = new org.jdatepicker.util.JDatePickerUtil();
        jDatePickerUtil3 = new org.jdatepicker.util.JDatePickerUtil();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        JpanelPrincipal = new javax.swing.JPanel();
        jLabel = new javax.swing.JLabel();
        panelFormulario = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        fHasta = new javax.swing.JPanel();
        JXDPHasta = new org.jdesktop.swingx.JXDatePicker();
        SimpleDateFormat formater= new SimpleDateFormat("dd-MM-yyyy");
        JXDPHasta.setFormats(formater);
        JXDPHasta.getEditor().setEditable(false);
        Date fecha = new Date();
        JXDPHasta.setDate(fecha);
        fDesde = new javax.swing.JPanel();
        JXDPDesde = new org.jdesktop.swingx.JXDatePicker();
        JXDPDesde.setFormats(formater);
        JXDPDesde.getEditor().setEditable(false);
        JXDPDesde.setDate(fecha);
        Desde = new javax.swing.JLabel();
        Desde1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnPdf1 = new javax.swing.JButton();
        btnGTabla = new javax.swing.JButton();
        btnCambiar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(792, 556));

        JpanelPrincipal.setBackground(new java.awt.Color(5, 5, 28));

        jLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel.setForeground(new java.awt.Color(255, 255, 255));
        jLabel.setText("TITULO DE LOS REPORTES ");

        panelFormulario.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fechas :");

        fHasta.setBackground(new java.awt.Color(5, 5, 28));

        javax.swing.GroupLayout fHastaLayout = new javax.swing.GroupLayout(fHasta);
        fHasta.setLayout(fHastaLayout);
        fHastaLayout.setHorizontalGroup(
            fHastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fHastaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JXDPHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        fHastaLayout.setVerticalGroup(
            fHastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JXDPHasta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        fDesde.setBackground(new java.awt.Color(5, 5, 28));

        javax.swing.GroupLayout fDesdeLayout = new javax.swing.GroupLayout(fDesde);
        fDesde.setLayout(fDesdeLayout);
        fDesdeLayout.setHorizontalGroup(
            fDesdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JXDPDesde, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
        );
        fDesdeLayout.setVerticalGroup(
            fDesdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JXDPDesde, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Desde.setBackground(new java.awt.Color(5, 5, 28));
        Desde.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        Desde.setText("Desde");
        Desde.setToolTipText("");

        Desde1.setBackground(new java.awt.Color(5, 5, 28));
        Desde1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        Desde1.setText("Hasta");
        Desde1.setToolTipText("");

        javax.swing.GroupLayout panelFormularioLayout = new javax.swing.GroupLayout(panelFormulario);
        panelFormulario.setLayout(panelFormularioLayout);
        panelFormularioLayout.setHorizontalGroup(
            panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(75, 75, 75)
                .addComponent(Desde)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(Desde1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        panelFormularioLayout.setVerticalGroup(
            panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(Desde))
                    .addComponent(Desde1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 382, Short.MAX_VALUE)
        );

        btnPdf1.setText("Generar pdf");
        btnPdf1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPdf1MouseClicked(evt);
            }
        });

        btnGTabla.setText("Generar Reporte");
        btnGTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGTablaMouseClicked(evt);
            }
        });

        btnCambiar.setText("Cambiar Reporte");
        btnCambiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCambiarMouseClicked(evt);
            }
        });
        btnCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JpanelPrincipalLayout = new javax.swing.GroupLayout(JpanelPrincipal);
        JpanelPrincipal.setLayout(JpanelPrincipalLayout);
        JpanelPrincipalLayout.setHorizontalGroup(
            JpanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelPrincipalLayout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(jLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(JpanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpanelPrincipalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(JpanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPdf1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpanelPrincipalLayout.createSequentialGroup()
                                .addComponent(btnCambiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnGTabla)))))
                .addContainerGap())
        );
        JpanelPrincipalLayout.setVerticalGroup(
            JpanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel)
                .addGap(18, 18, 18)
                .addComponent(panelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JpanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGTabla)
                    .addComponent(btnCambiar))
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPdf1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPdf1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPdf1MouseClicked


    }//GEN-LAST:event_btnPdf1MouseClicked

    private void btnGTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGTablaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGTablaMouseClicked

    private void btnCambiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCambiarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCambiarMouseClicked

    private void btnCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCambiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Desde;
    private javax.swing.JLabel Desde1;
    private org.jdesktop.swingx.JXDatePicker JXDPDesde;
    private org.jdesktop.swingx.JXDatePicker JXDPHasta;
    private javax.swing.JPanel JpanelPrincipal;
    private javax.swing.JButton btnCambiar;
    private javax.swing.JButton btnGTabla;
    private javax.swing.JButton btnPdf1;
    private javax.swing.JPanel fDesde;
    private javax.swing.JPanel fHasta;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil1;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil2;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil3;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JPanel panelFormulario;
    // End of variables declaration//GEN-END:variables

    public String getFecha(JXDatePicker fecha) {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String res = format.format(fecha.getDate());
        return res;

    }
}
