package vista;

import controlador.Controlador;
import controlador.ControladorGraficos;
import controlador.ControladorListarUsuarios;
import controlador.ControladorRegistroCompras;
import controlador.ControladorRegistroCompras2;
import controlador.ControladorRegistroUsuario;
import controlador.ControladorRegistroVenta2;
import controlador.ControladorReportes;
import controlador.GraficoDAO;
import controlador.Notificacion;
import javax.swing.JPanel;


public class Libreria extends javax.swing.JFrame {

    Notificacion notificacion;
    RegistroVentas registroVentas;
    Reporte reportes;
    ListarUsuarios listarUsuarios;
    RegistroUsuario regitroUsuario;
    
    private RegistroCompras registroCompras;
    private ControladorRegistroCompras controladorRegistroCompras;
    private RegistroCompras2 registroCompras2;
    private ControladorRegistroCompras2 controladorRegistroCompras2;
    private ControladorRegistroVenta2 controladorRegistroVenta2;
    private ControladorReportes controladorReportes;
    private ControladorGraficos controladorGraficos;
    private ControladorListarUsuarios controladorListarUsuarios;
    private ControladorRegistroUsuario controladorRUsuario;
    private Grafico grafico;
    private GraficoDAO gdao;
   
    private RegistroVenta2 registroVenta2;
    /**
     * Creates new form Libreria
     */
    public Libreria() {
        
        registroVentas = new RegistroVentas(this, rootPaneCheckingEnabled);
        registroCompras = new RegistroCompras();
        registroCompras2 = new RegistroCompras2();
        registroVenta2 = new RegistroVenta2();
        reportes = new Reporte();
        grafico = new Grafico();
        listarUsuarios = new ListarUsuarios();
        regitroUsuario = new RegistroUsuario(this, true);
        
        Controlador c = new Controlador(registroVentas);
        controladorRegistroCompras = new ControladorRegistroCompras(registroCompras);
        controladorRegistroCompras2 = new ControladorRegistroCompras2(registroCompras2);
        controladorRegistroVenta2 = new ControladorRegistroVenta2(registroVenta2);
        controladorReportes = new ControladorReportes(reportes);
        controladorGraficos = new ControladorGraficos(grafico);
        controladorRUsuario = new ControladorRegistroUsuario(regitroUsuario);
                
        int cant = controladorRegistroCompras.getCantLibrosStock();
        notificacion = new Notificacion(this, this, 1);
        
        gdao = new GraficoDAO();
        
        initComponents();
        controladorListarUsuarios = new ControladorListarUsuarios(listarUsuarios, regitroUsuario, this);
        this.setLocationRelativeTo(null);
        inicializarConVenta();
        
        verOtrosModulos(false);
    }
    
    private void verOtrosModulos(boolean estado){
        habilitarCompras(estado);
        btnRLibro.setVisible(false);
        btnRCompra2.setVisible(estado);
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
        btnReportes = new javax.swing.JButton();
        btnGraficos = new javax.swing.JButton();
        btnListarUsuarios = new javax.swing.JButton();
        btnRLibro2 = new javax.swing.JButton();
        btnRCompra2 = new javax.swing.JButton();
        btnRLibro = new javax.swing.JButton();

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

        btnListarUsuarios.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnListarUsuarios.setText("Listar Usuarios");
        btnListarUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnListarUsuariosMouseClicked(evt);
            }
        });

        btnRLibro2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnRLibro2.setText("Registro Libro");
        btnRLibro2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRLibro2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrarVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                    .addComponent(btnReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGraficos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnListarUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRLibro2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrarVenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRLibro2)
                .addGap(11, 11, 11)
                .addComponent(btnReportes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGraficos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnListarUsuarios)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRCompra2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnRCompra2.setText("Registro Venta2");
        btnRCompra2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRCompra2MouseClicked(evt);
            }
        });

        btnRLibro.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnRLibro.setText("Registro Libro");
        btnRLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRLibroMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlBaseLibreriaLayout = new javax.swing.GroupLayout(pnlBaseLibreria);
        pnlBaseLibreria.setLayout(pnlBaseLibreriaLayout);
        pnlBaseLibreriaLayout.setHorizontalGroup(
            pnlBaseLibreriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBaseLibreriaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBaseLibreriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRCompra2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRLibro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        pnlBaseLibreriaLayout.setVerticalGroup(
            pnlBaseLibreriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBaseLibreriaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBaseLibreriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBaseLibreriaLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(btnRCompra2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRLibro)))
                .addContainerGap(59, Short.MAX_VALUE))
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

    private void btnListarUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListarUsuariosMouseClicked
        controladorListarUsuarios.inicializarListaUsuarios();
        jPanel2.removeAll();
        jPanel2.add(listarUsuarios);
        listarUsuarios.setBounds(0, 0, 798, 556);
        pnlBaseLibreria.updateUI();
    }//GEN-LAST:event_btnListarUsuariosMouseClicked

    private void btnRLibro2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRLibro2MouseClicked
        controladorRegistroCompras2.inicializarRegistroCompras();
        jPanel2.removeAll();
        jPanel2.add(registroCompras2);
        registroCompras2.setBounds(0, 0, 798, 556);
        pnlBaseLibreria.updateUI();
    }//GEN-LAST:event_btnRLibro2MouseClicked

    private void btnRCompra2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRCompra2MouseClicked
    controladorRegistroVenta2.inicializarRegistroVentas();
        jPanel2.removeAll();
        jPanel2.add(registroVenta2);
        registroVenta2.setBounds(0, 0, 798, 556);
        pnlBaseLibreria.updateUI();
    }//GEN-LAST:event_btnRCompra2MouseClicked

    public JPanel getPnlBaseLibreria() {
        return pnlBaseLibreria;
    }

    
    public void inicializarConVenta(){
        jPanel2.removeAll();
        jPanel2.add(registroVentas.getPanel());
        pnlBaseLibreria.updateUI();
    }
    
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
    private javax.swing.JButton btnListarUsuarios;
    private javax.swing.JButton btnRCompra2;
    private javax.swing.JButton btnRLibro;
    private javax.swing.JButton btnRLibro2;
    private javax.swing.JButton btnRegistrarVenta;
    private javax.swing.JButton btnReportes;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel pnlBaseLibreria;
    // End of variables declaration//GEN-END:variables

    public int cantLibrosStock() {
        return controladorRegistroCompras.getCantLibrosStock();
    }
    
    public void habilitarVentas(boolean estado){
        btnRegistrarVenta.setVisible(estado);
    }
    
    public void habilitarCompras(boolean estado){
        btnRLibro.setVisible(estado);
    }
    
    public void habilitarReportes(boolean estado){
        btnReportes.setVisible(estado);
    }
    
    public void habilitarGraficos(boolean estado){
        btnGraficos.setVisible(estado);
    }
    
    public void habilitarListaUsuarios(boolean estado){
        btnListarUsuarios.setVisible(estado);
    }
    
    public void habilitarFuncionesVendedor(boolean estado){
        habilitarVentas(estado);
        //habilitarCompras(estado);
    }
    
    public void habilitarFuncionesAdministrador(boolean estado){
        habilitarReportes(estado);
        habilitarGraficos(estado);
        habilitarListaUsuarios(estado);
    }
    public void cambiarARegistro()
    {
        jPanel2.removeAll();
        regitroUsuario.cambiarARegistro();
        jPanel2.add(regitroUsuario.getPanel());
        regitroUsuario.getPanel().setBounds(0, 0, 798, 556);
        pnlBaseLibreria.updateUI();
    }

    public void cambiarAEditar()
    {
        jPanel2.removeAll();
        regitroUsuario.cambiarAEditar();
        jPanel2.add(regitroUsuario.getPanel());
        regitroUsuario.getPanel().setBounds(0, 0, 798, 556);
        pnlBaseLibreria.updateUI();
    }
    
    public void cambiarAListar()
    {
        jPanel2.removeAll();
        jPanel2.add(listarUsuarios);
        listarUsuarios.setBounds(0, 0, 798, 556);
        pnlBaseLibreria.updateUI();
    }
}
