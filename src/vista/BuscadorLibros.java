/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.LibroDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Vector;
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
     */
    public BuscadorLibros(JDialog parent, boolean modal) {
        super(parent, modal);
        
        controladorLibro = new LibroDAO();
        
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        tableModel = (DefaultTableModel)table_registroLibros.getModel();
        TableColumn columna = table_registroLibros.getColumn("ID");
        columna.setMinWidth(60);
        columna.setMaxWidth(60);                
                        
        btnRadio_titulo.setSelected(true);
        txt_buscar.setText(POR_TITULO);

        label_anterior.setEnabled(false);
        filtroActual = "Por Titulo";//Nos dice que actualmente esta seleccionado titulo
                
        titulosTabla = new String[]{"ID","TITULO","TEMA","AUTOR"};                       
        
        establecerDatosTabla(btnRadio_titulo);
        
        table_registroLibros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table_registroLibros.getSelectionModel().setSelectionInterval(0, 0);
        
        añadirEventoALaTabla();
    }
    
    private void añadirEventoALaTabla(){
        table_registroLibros.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                filaSeleccionada =  table_registroLibros.getSelectedRow();
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
        jPanel1 = new javax.swing.JPanel();
        laber_seleccionar = new javax.swing.JLabel();
        btn_OK = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnRadio_titulo = new javax.swing.JRadioButton();
        btnRadio_autor = new javax.swing.JRadioButton();
        btnRadio_tema = new javax.swing.JRadioButton();
        txt_buscar = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_registroLibros = new javax.swing.JTable();
        label_anterior = new javax.swing.JLabel();
        label_siguiente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Libro..");

        jPanel1.setBackground(new java.awt.Color(5, 5, 28));

        laber_seleccionar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        laber_seleccionar.setForeground(new java.awt.Color(255, 255, 255));
        laber_seleccionar.setText("Seleccione el libro que busca:");

        btn_OK.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_OK.setText("OK");
        btn_OK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_OKMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar por:");

        btnGroup_filtro.add(btnRadio_titulo);
        btnRadio_titulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRadio_titulo.setText("Por Titulo");
        btnRadio_titulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRadio_tituloMouseClicked(evt);
            }
        });

        btnGroup_filtro.add(btnRadio_autor);
        btnRadio_autor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRadio_autor.setText("Por Autor");
        btnRadio_autor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRadio_autorMouseClicked(evt);
            }
        });

        btnGroup_filtro.add(btnRadio_tema);
        btnRadio_tema.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRadio_tema.setText("Por Tema");
        btnRadio_tema.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRadio_temaMouseClicked(evt);
            }
        });

        txt_buscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_buscarFocusGained(evt);
            }
        });
        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnRadio_titulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
                                .addComponent(btnRadio_tema)
                                .addGap(212, 212, 212)
                                .addComponent(btnRadio_autor)
                                .addGap(216, 216, 216))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(85, 85, 85))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRadio_titulo)
                    .addComponent(btnRadio_autor)
                    .addComponent(btnRadio_tema))
                .addGap(18, 18, 18)
                .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.setLayout(null);

        table_registroLibros.setModel(new javax.swing.table.DefaultTableModel(
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
        table_registroLibros.getTableHeader().setReorderingAllowed(false);
        table_registroLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_registroLibrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_registroLibros);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(10, 11, 905, 186);

        label_anterior.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_anterior.setText("<<ANTERIOR REGISTRO");
        label_anterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_anteriorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_anteriorMouseExited(evt);
            }
        });
        jPanel3.add(label_anterior);
        label_anterior.setBounds(80, 210, 149, 15);

        label_siguiente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_siguiente.setText("SIGUIENTE REGISTRO >>");
        label_siguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_siguienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_siguienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_siguienteMouseExited(evt);
            }
        });
        jPanel3.add(label_siguiente);
        label_siguiente.setBounds(680, 210, 153, 15);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_OK, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(407, 407, 407))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(laber_seleccionar)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(laber_seleccionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btn_OK, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnRadio_tituloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRadio_tituloMouseClicked
        if(!filtroActual.equals("Por Titulo")){
            filtroActual = "Por Titulo";
            controladorLibro.reiniciarTituloErroneo();//sirve para optimizar la busqueda de filas
            setAbleControles(false);
            txt_buscar.setText(POR_TITULO);
            establecerDatosTabla(btnRadio_titulo);
            table_registroLibros.getSelectionModel().setSelectionInterval(0, 0);
        }
    }//GEN-LAST:event_btnRadio_tituloMouseClicked

    private void btnRadio_autorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRadio_autorMouseClicked
        if(!filtroActual.equals("Por Autor")){
            filtroActual = "Por Autor";
            controladorLibro.reiniciarTituloErroneo();
            setAbleControles(false);
            txt_buscar.setText(POR_AUTOR);
            establecerDatosTabla(btnRadio_autor); 
            table_registroLibros.getSelectionModel().setSelectionInterval(0, 0);
        }
    }//GEN-LAST:event_btnRadio_autorMouseClicked

    private void btnRadio_temaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRadio_temaMouseClicked
        if(!filtroActual.equals("Por Tema")){
            filtroActual = "Por Tema";            
            controladorLibro.reiniciarTituloErroneo();
            setAbleControles(false);
            txt_buscar.setText(POR_TEMA);
            establecerDatosTabla(btnRadio_tema);  
            table_registroLibros.getSelectionModel().setSelectionInterval(0, 0);
        }
    }//GEN-LAST:event_btnRadio_temaMouseClicked

    private void txt_buscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_buscarFocusGained
        txt_buscar.setText("");
    }//GEN-LAST:event_txt_buscarFocusGained

    private void table_registroLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_registroLibrosMouseClicked
        int fila = table_registroLibros.rowAtPoint(evt.getPoint());
        if(fila>=0){

        }
    }//GEN-LAST:event_table_registroLibrosMouseClicked

    private void label_anteriorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_anteriorMouseEntered
        label_anterior.setForeground(Color.BLUE);
        fuenteOriginalLabel = label_anterior.getFont();
        anchoOriginalLabel = label_anterior.getWidth();
        label_anterior.setFont(new Font(fuenteOriginalLabel.getFamily(),fuenteOriginalLabel.getStyle(),fuenteOriginalLabel.getSize()+2));
        label_anterior.setSize(label_anterior.getWidth()+30,
                label_anterior.getHeight());
    }//GEN-LAST:event_label_anteriorMouseEntered

    private void label_anteriorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_anteriorMouseExited
        label_anterior.setForeground(Color.black);
        label_anterior.setFont(fuenteOriginalLabel);
        label_anterior.setSize(anchoOriginalLabel, label_anterior.getHeight());
    }//GEN-LAST:event_label_anteriorMouseExited

    private void label_siguienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_siguienteMouseEntered
        label_siguiente.setForeground(Color.BLUE);
        fuenteOriginalLabel = label_siguiente.getFont();
        anchoOriginalLabel = label_siguiente.getWidth();
        label_siguiente.setFont(new Font(fuenteOriginalLabel.getFamily(),fuenteOriginalLabel.getStyle(),fuenteOriginalLabel.getSize()+2));
        label_siguiente.setSize(label_siguiente.getWidth()+35,
                label_siguiente.getHeight());
    }//GEN-LAST:event_label_siguienteMouseEntered

    private void label_siguienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_siguienteMouseExited
        label_siguiente.setForeground(Color.black);
        label_siguiente.setFont(fuenteOriginalLabel);
        label_siguiente.setSize(anchoOriginalLabel, label_siguiente.getHeight());        
    }//GEN-LAST:event_label_siguienteMouseExited

    private void label_siguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_siguienteMouseClicked
        
    }//GEN-LAST:event_label_siguienteMouseClicked

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
        filaSeleccionada = controladorLibro.encontrarPrimeraCoincidencia(txt_buscar.getText(),filtroActual);
        if(filaSeleccionada != -1)
            table_registroLibros.getSelectionModel().setSelectionInterval(filaSeleccionada, filaSeleccionada);
        else if(txt_buscar.getText().equals("")){
            table_registroLibros.getSelectionModel().setSelectionInterval(0, 0);
            filaSeleccionada = 0;
        }
        
        Rectangle rect = table_registroLibros.getCellRect(filaSeleccionada, 0, true);
        table_registroLibros.scrollRectToVisible(rect);
        //table_registroLibros.clearSelection();
        //table_registroLibros.setRowSelectionInterval(row, row);
        //tableModel.fireTableDataChanged();
    }//GEN-LAST:event_txt_buscarKeyReleased

    private void btn_OKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_OKMouseClicked
        dispose();
    }//GEN-LAST:event_btn_OKMouseClicked

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
    private javax.swing.ButtonGroup btnGroup_filtro;
    private javax.swing.JRadioButton btnRadio_autor;
    private javax.swing.JRadioButton btnRadio_tema;
    private javax.swing.JRadioButton btnRadio_titulo;
    private javax.swing.JButton btn_OK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_anterior;
    private javax.swing.JLabel label_siguiente;
    private javax.swing.JLabel laber_seleccionar;
    private javax.swing.JTable table_registroLibros;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
