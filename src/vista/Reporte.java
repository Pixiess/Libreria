package vista;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
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

        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        JpanelPrincipal = new javax.swing.JPanel();
        lblTituloReportes = new javax.swing.JLabel();
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
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fecha);
        calendario.add(Calendar.MONTH, -1);
        fecha = calendario.getTime(); 
        JXDPDesde.setDate(fecha);
        Desde = new javax.swing.JLabel();
        Desde1 = new javax.swing.JLabel();
        pnlBaseTabla = new javax.swing.JPanel();
        btnPdf = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnElegir = new javax.swing.JButton();
        labelMasVendidos = new javax.swing.JLabel();
        spinnerCantidadMasVendidos = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(792, 556));

        JpanelPrincipal.setBackground(new java.awt.Color(5, 5, 28));

        lblTituloReportes.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        lblTituloReportes.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloReportes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloReportes.setText("TITULO DE LOS REPORTES ");

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

        javax.swing.GroupLayout pnlBaseTablaLayout = new javax.swing.GroupLayout(pnlBaseTabla);
        pnlBaseTabla.setLayout(pnlBaseTablaLayout);
        pnlBaseTablaLayout.setHorizontalGroup(
            pnlBaseTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 772, Short.MAX_VALUE)
        );
        pnlBaseTablaLayout.setVerticalGroup(
            pnlBaseTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 335, Short.MAX_VALUE)
        );

        btnPdf.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnPdf.setText("Generar pdf");
        btnPdf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPdfMouseClicked(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarMouseClicked(evt);
            }
        });

        btnElegir.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnElegir.setText("Elegir Reporte");
        btnElegir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnElegirMouseClicked(evt);
            }
        });
        btnElegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirActionPerformed(evt);
            }
        });

        labelMasVendidos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelMasVendidos.setForeground(new java.awt.Color(255, 255, 255));
        labelMasVendidos.setText("Cantidad de libros más vendidos:");

        spinnerCantidadMasVendidos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        spinnerCantidadMasVendidos.setModel(new javax.swing.SpinnerNumberModel(5, 1, 15, 1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TOTAL");

        javax.swing.GroupLayout JpanelPrincipalLayout = new javax.swing.GroupLayout(JpanelPrincipal);
        JpanelPrincipal.setLayout(JpanelPrincipalLayout);
        JpanelPrincipalLayout.setHorizontalGroup(
            JpanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTituloReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBaseTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpanelPrincipalLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(labelMasVendidos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spinnerCantidadMasVendidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnElegir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnActualizar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpanelPrincipalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(JpanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPdf, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpanelPrincipalLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        JpanelPrincipalLayout.setVerticalGroup(
            JpanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloReportes)
                .addGap(18, 18, 18)
                .addComponent(panelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JpanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnElegir)
                    .addComponent(labelMasVendidos)
                    .addComponent(spinnerCantidadMasVendidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlBaseTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JpanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPdf)
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

    private void btnPdfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPdfMouseClicked


    }//GEN-LAST:event_btnPdfMouseClicked

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarMouseClicked

    private void btnElegirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnElegirMouseClicked
         //TipoReporte tp = new TipoReporte(null, true);
         //tp.setVisible(true);
    }//GEN-LAST:event_btnElegirMouseClicked

    private void btnElegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnElegirActionPerformed

    public JXDatePicker getJXDPDesde() {
        return JXDPDesde;
    }

    public JXDatePicker getJXDPHasta() {
        return JXDPHasta;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public JButton getBtnElegir() {
        return btnElegir;
    }

    public JButton getBtnPdf() {
        return btnPdf;
    }

    public JPanel getPnlBaseTabla() {
        return pnlBaseTabla;
    }

    public JLabel getLblTituloReportes() {
        return lblTituloReportes;
    }

    public JTextField getTxtTotal() {
        return txtTotal;
    }
     
    

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Desde;
    private javax.swing.JLabel Desde1;
    private org.jdesktop.swingx.JXDatePicker JXDPDesde;
    private org.jdesktop.swingx.JXDatePicker JXDPHasta;
    private javax.swing.JPanel JpanelPrincipal;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnElegir;
    private javax.swing.JButton btnPdf;
    private javax.swing.JPanel fDesde;
    private javax.swing.JPanel fHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JLabel labelMasVendidos;
    private javax.swing.JLabel lblTituloReportes;
    private javax.swing.JPanel panelFormulario;
    private javax.swing.JPanel pnlBaseTabla;
    private javax.swing.JSpinner spinnerCantidadMasVendidos;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
 
    public String getFecha(JXDatePicker fecha) {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String res = format.format(fecha.getDate());
        return res;
    }
    
    public JSpinner getSpinnerCantidadMasVendidos(){
        return spinnerCantidadMasVendidos;
    }
    
    public JLabel getLabelMasVendidos(){
        return labelMasVendidos;
    }
   
}
