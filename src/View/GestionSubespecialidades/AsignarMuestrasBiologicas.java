package View.GestionSubespecialidades;

import Model.POJO.MuestraBiologica;
import Model.POJO.Subespecialidad;
import Model.POJO.SubespecialidadMuestra;
import Presenter.GestionSubespecialidades.PresenterGestionSubespecialidadMuestra;
import Presenter.GestionSubespecialidades.PresenterGestionSubespecialidades;
import View.Utilitarios.ModelTable.GestionSubespecialidades.TableModelAsignarMuestrasBiologicas;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Brynner
 */
public class AsignarMuestrasBiologicas extends javax.swing.JDialog implements PresenterGestionSubespecialidades.CallBackObtenerMuestrasBiologicasDisponibles, PresenterGestionSubespecialidadMuestra.CallBackAsignarMuestraBiologicaSubespecialidad {
    
    private final PresenterGestionSubespecialidades presenterGestionSubespecialidades;
    private final PresenterGestionSubespecialidadMuestra presenterGestionSubespecialidadMuestra;
    private final TableModelAsignarMuestrasBiologicas tableModelAsignarMuestrasBiologicas;
    
    private Subespecialidad subespecialidad;
    
    public AsignarMuestrasBiologicas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        presenterGestionSubespecialidades = new PresenterGestionSubespecialidades();
        presenterGestionSubespecialidadMuestra = new PresenterGestionSubespecialidadMuestra();
        presenterGestionSubespecialidades.setCallBackObtenerMuestrasBiologicasDisponibles(this);
        presenterGestionSubespecialidadMuestra.setCallBackAsignarMuestraBiologicaSubespecialidad(this);
        
        tableModelAsignarMuestrasBiologicas = new TableModelAsignarMuestrasBiologicas();
        
        initComponents();
    }

    public void setSubespecialidad(Subespecialidad subespecialidad) {
        this.subespecialidad = subespecialidad;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemMuestraBiologica = new javax.swing.JPopupMenu();
        JMENUITEMAsignarMuestraBiologica = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JLBLSubespecialidadNombre = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLMuestrasBiologicasDisponibles = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        JBTNCerrar = new javax.swing.JButton();
        JBTNActualizar = new javax.swing.JButton();

        JMENUITEMAsignarMuestraBiologica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/asignar.png"))); // NOI18N
        JMENUITEMAsignarMuestraBiologica.setText("Asignar Muestra Biológica");
        JMENUITEMAsignarMuestraBiologica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMAsignarMuestraBiologicaActionPerformed(evt);
            }
        });
        JPOPUPMENUItemMuestraBiologica.add(JMENUITEMAsignarMuestraBiologica);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Asignar Muestras Biológicas");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Subespecialidad"));

        jLabel1.setText("NOMBRE:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JLBLSubespecialidadNombre)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JLBLSubespecialidadNombre))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Muestras Biológicas Disponibles"));

        JTBLMuestrasBiologicasDisponibles.setModel(tableModelAsignarMuestrasBiologicas);
        JTBLMuestrasBiologicasDisponibles.setComponentPopupMenu(JPOPUPMENUItemMuestraBiologica);
        JTBLMuestrasBiologicasDisponibles.setEnabled(false);
        JTBLMuestrasBiologicasDisponibles.setRowHeight(20);
        JTBLMuestrasBiologicasDisponibles.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTBLMuestrasBiologicasDisponibles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLMuestrasBiologicasDisponiblesMousePressed(evt);
            }
        });
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLMuestrasBiologicasDisponibles.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);

        JTBLMuestrasBiologicasDisponibles.getColumnModel().getColumn(0).setPreferredWidth(40);
        JTBLMuestrasBiologicasDisponibles.getColumnModel().getColumn(1).setPreferredWidth(900);
        jScrollPane1.setViewportView(JTBLMuestrasBiologicasDisponibles);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );

        JBTNCerrar.setText("CERRAR");
        JBTNCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCerrarActionPerformed(evt);
            }
        });

        JBTNActualizar.setText("ACTUALIZAR");
        JBTNActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JBTNCerrar)
                .addGap(18, 18, 18)
                .addComponent(JBTNActualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNCerrar)
                    .addComponent(JBTNActualizar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            if (subespecialidad == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                JLBLSubespecialidadNombre.setText(subespecialidad.getSubespecialidadNombre());
                presenterGestionSubespecialidades.obtenerMuestrasBiologicasDisponibles(subespecialidad);
            }
        } catch (final HeadlessException ex) {
            System.err.println("Se produjo un error: " + ex.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTBLMuestrasBiologicasDisponiblesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLMuestrasBiologicasDisponiblesMousePressed
        final int currentRow = JTBLMuestrasBiologicasDisponibles.rowAtPoint(evt.getPoint());
        JTBLMuestrasBiologicasDisponibles.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLMuestrasBiologicasDisponiblesMousePressed

    private void JMENUITEMAsignarMuestraBiologicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMAsignarMuestraBiologicaActionPerformed
        final MuestraBiologica muestraBiologica = obtenerMuestraBiologicaSeleccionada();
        
        final int option = JOptionPane.showConfirmDialog(this, "¿Asignar la muestra biológica " + muestraBiologica.getMuestraBiologicaTipo() + " a la subespecialidad " + subespecialidad.getSubespecialidadNombre() + "?", "SIET", JOptionPane.YES_NO_OPTION);
        
        if (option == 0) {
            tableModelAsignarMuestrasBiologicas.limpiarLista();
            presenterGestionSubespecialidadMuestra.asignarMuestraBiologicaSubespecialidad(new SubespecialidadMuestra(subespecialidad, muestraBiologica, 1));
        }
    }//GEN-LAST:event_JMENUITEMAsignarMuestraBiologicaActionPerformed

    private void JBTNCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCerrarActionPerformed

    private void JBTNActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNActualizarActionPerformed
        JLBLSubespecialidadNombre.setText(subespecialidad.getSubespecialidadNombre());
        presenterGestionSubespecialidades.obtenerMuestrasBiologicasDisponibles(subespecialidad);
    }//GEN-LAST:event_JBTNActualizarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            AsignarMuestrasBiologicas dialog = new AsignarMuestrasBiologicas(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBTNActualizar;
    private javax.swing.JButton JBTNCerrar;
    private javax.swing.JLabel JLBLSubespecialidadNombre;
    private javax.swing.JMenuItem JMENUITEMAsignarMuestraBiologica;
    private javax.swing.JPopupMenu JPOPUPMENUItemMuestraBiologica;
    private javax.swing.JTable JTBLMuestrasBiologicasDisponibles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    
    private MuestraBiologica obtenerMuestraBiologicaSeleccionada() {
        final int rowModel = JTBLMuestrasBiologicasDisponibles.convertRowIndexToModel(JTBLMuestrasBiologicasDisponibles.getSelectedRow());
        return tableModelAsignarMuestrasBiologicas.getMuestraBiologica(rowModel);
    }
    
    @Override
    public void muestrasBiologicasDisponiblesObtenidas(final List<MuestraBiologica> muestrasBiologicas) {
        tableModelAsignarMuestrasBiologicas.setMuestrasBiologicas(muestrasBiologicas);
        JTBLMuestrasBiologicasDisponibles.setModel(tableModelAsignarMuestrasBiologicas);
        JTBLMuestrasBiologicasDisponibles.getTableHeader().setReorderingAllowed(false);
    }

    @Override
    public void listaMuestrasBiologicasDisponiblesVacia(final String msg) {
    }

    @Override
    public void errorObtenerMuestrasBiologicasDisponibles(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerMuestrasBiologicasDisponibles(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void muestraBiologicaSubespecialidadAsignada(String msg) {
        JLBLSubespecialidadNombre.setText(subespecialidad.getSubespecialidadNombre());
        presenterGestionSubespecialidades.obtenerMuestrasBiologicasDisponibles(subespecialidad);
    }

    @Override
    public void errorAsignarMuestraBiologicaSubespecialidad(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoAsignarMuestraBiologicaSubespecialidad(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void tablaMuestrasBiologicasVacia(final String msg) {
    }

    @Override
    public void errorVerificarTablaMuestrasBiologicasVacia(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoVerificarTablaMuestrasBiologicasVacia(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}