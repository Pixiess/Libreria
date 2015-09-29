package vista;

import controlador.Controlador;
import controlador.ControladorGraficos;
import controlador.ControladorRegistroCompras;
import controlador.ControladorReportes;
import controlador.CrearGrafico;
import controlador.GraficoDAO;
import controlador.Notificacion;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;

public class Libreria extends javax.swing.JFrame {

    Notificacion notificacion;
    RegistroVentas registroVentas;
    Reporte reportes;
    
    private RegistroCompras registroCompras;
    private ControladorRegistroCompras controladorRegistroCompras;
    private ControladorReportes controladorReportes;
    private ControladorGraficos controladorGraficos;
    private Grafico grafico;
    private GraficoDAO gdao;
   
    /**
     * Creates new form Libreria
     */
    public Libreria() {
        
        registroVentas = new RegistroVentas(this, rootPaneCheckingEnabled);
        registroCompras = new RegistroCompras();
        reportes = new Reporte();
        grafico = new Grafico();
        
        Controlador c = new Controlador(registroVentas);
        controladorRegistroCompras = new ControladorRegistroCompras(registroCompras);
        controladorReportes = new ControladorReportes(reportes);
        controladorGraficos = new ControladorGraficos(grafico);
                
        int cant = controladorRegistroCompras.getCantLibrosStock();
        notificacion = new Notificacion(this, this, 1);
        
        gdao = new GraficoDAO();
         
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBaseLibreria = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnRegistrarVenta = new javax.swing.JButton();
        btnRLibro = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        btnGraficos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlBaseLibreria.setBackground(new java.awt.Color(5, 5, 28));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 792, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        btnRegistrarVenta.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnRegistrarVenta.setText("Registrar Venta");
        btnRegistrarVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarVentaMouseClicked(evt);
            }
        });

        btnRLibro.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnRLibro.setText("Registro Libro");
        btnRLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRLibroMouseClicked(evt);
            }
        });

        btnReportes.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnReportes.setText("Reportes");
        btnReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReportesMouseClicked(evt);
            }
        });

        btnGraficos.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnGraficos.setText("Graficos");
        btnGraficos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGraficosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRLibro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrarVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGraficos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrarVenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRLibro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReportes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGraficos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlBaseLibreriaLayout = new javax.swing.GroupLayout(pnlBaseLibreria);
        pnlBaseLibreria.setLayout(pnlBaseLibreriaLayout);
        pnlBaseLibreriaLayout.setHorizontalGroup(
            pnlBaseLibreriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBaseLibreriaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        pnlBaseLibreriaLayout.setVerticalGroup(
            pnlBaseLibreriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBaseLibreriaLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlBaseLibreriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlBaseLibreria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBaseLibreria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarVentaMouseClicked
        registroVentas.setComponents();
        jPanel2.removeAll();
        jPanel2.add(registroVentas.getPanel());
        pnlBaseLibreria.updateUI();
    }//GEN-LAST:event_btnRegistrarVentaMouseClicked

    private void btnRLibroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRLibroMouseClicked
        controladorRegistroCompras.inicializarRegistroCompras();
        jPanel2.removeAll();
        jPanel2.add(registroCompras);
        registroCompras.setBounds(0, 0, 798, 556);
        pnlBaseLibreria.updateUI();
    }//GEN-LAST:event_btnRLibroMouseClicked

    private void rLibroJBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rLibroJBMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rLibroJBMouseClicked

    private void btnReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseClicked
        controladorReportes.inicializarTablasReportes();
        jPanel2.removeAll();
        jPanel2.add(reportes);
        reportes.setBounds(0, 0, 798, 556);        
        pnlBaseLibreria.updateUI();
    }//GEN-LAST:event_btnReportesMouseClicked

    private void btnGraficosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGraficosMouseClicked
        controladorGraficos.inicializarGraficos();
        jPanel2.removeAll();
        jPanel2.add(grafico);
        grafico.setBounds(0, 0, 798, 556);  
        pnlBaseLibreria.updateUI();
    }//GEN-LAST:event_btnGraficosMouseClicked

    public JPanel getPnlBaseLibreria() {
        return pnlBaseLibreria;
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Libreria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Libreria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Libreria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Libreria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Libreria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGraficos;
    private javax.swing.JButton btnRLibro;
    private javax.swing.JButton btnRegistrarVenta;
    private javax.swing.JButton btnReportes;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel pnlBaseLibreria;
    // End of variables declaration//GEN-END:variables

    public int cantLibrosStock() {
        return controladorRegistroCompras.getCantLibrosStock();
    }
}
