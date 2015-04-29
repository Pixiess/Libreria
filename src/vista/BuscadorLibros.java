/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.LibroDAO;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.Libro;

/**
 *
 * @author Veymar Montaño Colqu
 */
public class BuscadorLibros extends javax.swing.JDialog {
    private LibroDAO controladorLibro;
    private String[] titulosTabla;
    
    private String filtroDeBusquedaActual;//Nos dice que filtro De Busqueda esta activado actualmente
    
    private DefaultTableModel tableModel;
    private Font fuenteOriginalLabel;//fuente auxiliar para cambiar los controles atras y adelante
    private int anchoOriginalLabel;//ancho auxiliar para cambiar los controles atras y adelante
    
    private final String POR_TITULO="Ingrese título del libro";
    private final String POR_AUTOR="Ingrese autor del libro";
    private final String POR_TEMA="Ingrese tema del libro";
    
    private ArrayList<Libro>registroLibros;
    private String filtroActual;
    private int filaSeleccionada;
    /**
     * Creates new form BuscadorLibros
     * @param parent
     * @param modal
     */
    public BuscadorLibros(JDialog parent, boolean modal) {
        super(parent, modal);
        
        controladorLibro = new LibroDAO();
        
        initComponents();
        System.out.println("hola");
        this.setLocationRelativeTo(null);
        
        tableModel = (DefaultTableModel)tableRegistroLibros.getModel();
        TableColumn columna = tableRegistroLibros.getColumn("ID");
        columna.setMinWidth(60);
        columna.setMaxWidth(60);                
                        
        btnRadioTitulo.setSelected(true);
        txtBuscar.setText(POR_TITULO);

        filtroActual = "Por Titulo";//Nos dice que actualmente esta seleccionado titulo
                
        titulosTabla = new String[]{"ID","TITULO","TEMA","AUTOR"};                       
        
        establecerDatosTabla(btnRadioTitulo);
        
        tableRegistroLibros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableRegistroLibros.getSelectionModel().setSelectionInterval(0, 0);
        
        añadirEventoALaTabla();
    }
    
    private void añadirEventoALaTabla(){
        tableRegistroLibros.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                filaSeleccionada =  tableRegistroLibros.getSelectedRow();
              /*String selectedData = null;

              int[] selectedRow = table.getSelectedRows();
              int[] selectedColumns = table.getSelectedColumns();

              for (int i = 0; i < selectedRow.length; i++) {
                for (int j = 0; j < selectedColumns.length; j++) {
                  selectedData = (String) table.getValueAt(selectedRow[i], selectedColumns[j]);
                }
              }
              System.out.println("Selected: " + selectedData);*/
            }

          });
    }
    
    public Libro getLibroBuscado(){
        return registroLibros.get(filaSeleccionada);
    }
    
    private void establecerDatosTabla(JRadioButton radiobuttonOpcion){
        registroLibros = controladorLibro.getReportePorFiltro(radiobuttonOpcion.getText());
        
        filaSeleccionada = 0;
        
        Object[][] arregloDatosLibro = conseguirDatosLibro(registroLibros);
        tableModel.setDataVector(arregloDatosLibro, titulosTabla);
        
        setAbleControles(true);
    }
    
    private Object[][] conseguirDatosLibro(ArrayList<Libro> registroLibros){
        Object[][] respuesta = new Object[registroLibros.size()][];
        
        for (int i = 0; i < respuesta.length; i++) {
            respuesta[i] = convertirLibroAArreglo(registroLibros.get(i));
        }
        
        return respuesta;
    }
    
    private Object[] convertirLibroAArreglo(Libro libro){
        Object [] respuesta = new Object[4];
        
        respuesta[0] = libro.getIdLibro();
        respuesta[1] = libro.getNombreLibro();
        respuesta[2] = libro.getGenero();
        respuesta[3] = libro.getAutorLibro();
        
        return respuesta;
    }
    
    public void setAbleControles(boolean estadoControles){
        /*btnRadio_autor.setEnabled(estadoControles);
        btnRadio_tema.setEnabled(estadoControles);
        btnRadio_titulo.setEnabled(estadoControles);
        //txt_buscar.setEnabled(estadoControles);
        label_anterior.setEnabled(estadoControles);
        label_siguiente.setEnabled(estadoControles);*/
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroup_filtro = new javax.swing.ButtonGroup();
        panelContenedorPrincipal = new javax.swing.JPanel();
        laberSeleccionar = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        panelControlesDeFiltros = new javax.swing.JPanel();
        labelTituloBuscar = new javax.swing.JLabel();
        btnRadioTitulo = new javax.swing.JRadioButton();
        btnRadioAutor = new javax.swing.JRadioButton();
        btnRadioTema = new javax.swing.JRadioButton();
        txtBuscar = new javax.swing.JTextField();
        panelTabla = new javax.swing.JPanel();
        jScrollPanePanelTabla = new javax.swing.JScrollPane();
        tableRegistroLibros = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Libro..");

        panelContenedorPrincipal.setBackground(new java.awt.Color(5, 5, 28));

        laberSeleccionar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        laberSeleccionar.setForeground(new java.awt.Color(255, 255, 255));
        laberSeleccionar.setText("Seleccione el libro que busca:");

        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAceptar.setText("ACEPTAR");
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });

        panelControlesDeFiltros.setBackground(new java.awt.Color(153, 153, 153));

        labelTituloBuscar.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        labelTituloBuscar.setForeground(new java.awt.Color(255, 255, 255));
        labelTituloBuscar.setText("Buscar por:");

        btnGroup_filtro.add(btnRadioTitulo);
        btnRadioTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRadioTitulo.setText("Por Titulo");
        btnRadioTitulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRadioTituloMouseClicked(evt);
            }
        });

        btnGroup_filtro.add(btnRadioAutor);
        btnRadioAutor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRadioAutor.setText("Por Autor");
        btnRadioAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRadioAutorMouseClicked(evt);
            }
        });

        btnGroup_filtro.add(btnRadioTema);
        btnRadioTema.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRadioTema.setText("Por Tema");
        btnRadioTema.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRadioTemaMouseClicked(evt);
            }
        });

        txtBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarFocusGained(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelControlesDeFiltrosLayout = new javax.swing.GroupLayout(panelControlesDeFiltros);
        panelControlesDeFiltros.setLayout(panelControlesDeFiltrosLayout);
        panelControlesDeFiltrosLayout.setHorizontalGroup(
            panelControlesDeFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelControlesDeFiltrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelControlesDeFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelControlesDeFiltrosLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelControlesDeFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelControlesDeFiltrosLayout.createSequentialGroup()
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelControlesDeFiltrosLayout.createSequentialGroup()
                                .addComponent(btnRadioTitulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
                                .addComponent(btnRadioTema)
                                .addGap(212, 212, 212)
                                .addComponent(btnRadioAutor)
                                .addGap(216, 216, 216))))
                    .addGroup(panelControlesDeFiltrosLayout.createSequentialGroup()
                        .addComponent(labelTituloBuscar)
                        .addGap(85, 85, 85))))
        );
        panelControlesDeFiltrosLayout.setVerticalGroup(
            panelControlesDeFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelControlesDeFiltrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTituloBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelControlesDeFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRadioTitulo)
                    .addComponent(btnRadioAutor)
                    .addComponent(btnRadioTema))
                .addGap(18, 18, 18)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        panelTabla.setLayout(null);

        tableRegistroLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "TITULO", "TEMA", "AUTOR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableRegistroLibros.getTableHeader().setReorderingAllowed(false);
        tableRegistroLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRegistroLibrosMouseClicked(evt);
            }
        });
        jScrollPanePanelTabla.setViewportView(tableRegistroLibros);

        panelTabla.add(jScrollPanePanelTabla);
        jScrollPanePanelTabla.setBounds(10, 11, 905, 186);

        javax.swing.GroupLayout panelContenedorPrincipalLayout = new javax.swing.GroupLayout(panelContenedorPrincipal);
        panelContenedorPrincipal.setLayout(panelContenedorPrincipalLayout);
        panelContenedorPrincipalLayout.setHorizontalGroup(
            panelContenedorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContenedorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(laberSeleccionar)
                    .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelControlesDeFiltros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(395, 395, 395))
        );
        panelContenedorPrincipalLayout.setVerticalGroup(
            panelContenedorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelControlesDeFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(laberSeleccionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedorPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedorPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRadioTituloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRadioTituloMouseClicked
        if(!filtroActual.equals("Por Titulo")){
            filtroActual = "Por Titulo";
            controladorLibro.reiniciarTituloErroneo();//sirve para optimizar la busqueda de filas
            setAbleControles(false);
            txtBuscar.setText(POR_TITULO);
            establecerDatosTabla(btnRadioTitulo);
            tableRegistroLibros.getSelectionModel().setSelectionInterval(0, 0);
            deslizarTablaHastaSeleccion(0);
        }
    }//GEN-LAST:event_btnRadioTituloMouseClicked

    private void btnRadioAutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRadioAutorMouseClicked
        if(!filtroActual.equals("Por Autor")){
            filtroActual = "Por Autor";
            controladorLibro.reiniciarTituloErroneo();
            setAbleControles(false);
            txtBuscar.setText(POR_AUTOR);
            establecerDatosTabla(btnRadioAutor); 
            tableRegistroLibros.getSelectionModel().setSelectionInterval(0, 0);
            deslizarTablaHastaSeleccion(0);
        }
    }//GEN-LAST:event_btnRadioAutorMouseClicked

    private void btnRadioTemaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRadioTemaMouseClicked
        if(!filtroActual.equals("Por Tema")){
            filtroActual = "Por Tema";            
            controladorLibro.reiniciarTituloErroneo();
            setAbleControles(false);
            txtBuscar.setText(POR_TEMA);
            establecerDatosTabla(btnRadioTema);  
            tableRegistroLibros.getSelectionModel().setSelectionInterval(0, 0);
            deslizarTablaHastaSeleccion(0);
        }
    }//GEN-LAST:event_btnRadioTemaMouseClicked

    private void txtBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusGained
        txtBuscar.setText("");
    }//GEN-LAST:event_txtBuscarFocusGained

    private void tableRegistroLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableRegistroLibrosMouseClicked
        int fila = tableRegistroLibros.rowAtPoint(evt.getPoint());
        if(fila>=0){

        }
    }//GEN-LAST:event_tableRegistroLibrosMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        filaSeleccionada = controladorLibro.encontrarPrimeraCoincidencia(txtBuscar.getText(),filtroActual);
        if(filaSeleccionada != -1){
            tableRegistroLibros.getSelectionModel().setSelectionInterval(filaSeleccionada, filaSeleccionada);
            deslizarTablaHastaSeleccion(filaSeleccionada);
        }            
        else 
        if(txtBuscar.getText().equals("")){
            tableRegistroLibros.getSelectionModel().setSelectionInterval(0, 0);
            filaSeleccionada = 0;
            deslizarTablaHastaSeleccion(filaSeleccionada);
        }                
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        dispose();
    }//GEN-LAST:event_btnAceptarMouseClicked
    
    
    private void deslizarTablaHastaSeleccion(int filaSeleccionada){
        Rectangle rect = tableRegistroLibros.getCellRect(filaSeleccionada, 0, true);
        tableRegistroLibros.scrollRectToVisible(rect);
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
            java.util.logging.Logger.getLogger(BuscadorLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscadorLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscadorLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscadorLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BuscadorLibros dialog = new BuscadorLibros(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
                System.out.println(dialog.getLibroBuscado().getNombreLibro());
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.ButtonGroup btnGroup_filtro;
    private javax.swing.JRadioButton btnRadioAutor;
    private javax.swing.JRadioButton btnRadioTema;
    private javax.swing.JRadioButton btnRadioTitulo;
    private javax.swing.JScrollPane jScrollPanePanelTabla;
    private javax.swing.JLabel labelTituloBuscar;
    private javax.swing.JLabel laberSeleccionar;
    private javax.swing.JPanel panelContenedorPrincipal;
    private javax.swing.JPanel panelControlesDeFiltros;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JTable tableRegistroLibros;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
