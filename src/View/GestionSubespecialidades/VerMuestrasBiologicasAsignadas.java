package View.GestionSubespecialidades;

import Model.POJO.Subespecialidad;
import Model.POJO.SubespecialidadMuestra;
import Presenter.GestionSubespecialidades.PresenterGestionSubespecialidadMuestra;
import Presenter.GestionSubespecialidades.PresenterGestionSubespecialidades;
import View.Utilitarios.ModelTable.GestionSubespecialidades.TableModelReasignarMuestrasBiologicas;
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
public class VerMuestrasBiologicasAsignadas extends javax.swing.JDialog implements PresenterGestionSubespecialidades.CallBackObtenerMuestrasBiologicasAsignadas, PresenterGestionSubespecialidadMuestra.CallBackQuitarMuestraBiologicaSubespecialidad {
    
    private final TableModelReasignarMuestrasBiologicas tableModelReasignarMuestrasBiologicas;
    private final PresenterGestionSubespecialidades presenterGestionSubespecialidades;
    private final PresenterGestionSubespecialidadMuestra presenterGestionSubespecialidadMuestra;
    
    private Subespecialidad subespecialidad;
    
    public VerMuestrasBiologicasAsignadas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        presenterGestionSubespecialidades = new PresenterGestionSubespecialidades();
        presenterGestionSubespecialidadMuestra = new PresenterGestionSubespecialidadMuestra();
        presenterGestionSubespecialidades.setCallBackObtenerMuestrasBiologicasAsignadas(this);
        presenterGestionSubespecialidadMuestra.setCallBackQuitarMuestraBiologicaSubespecialidad(this);
        
        tableModelReasignarMuestrasBiologicas = new TableModelReasignarMuestrasBiologicas();
        
        initComponents();
    }
    
    public void setSubespecialidad(Subespecialidad subespecialidad) {
        this.subespecialidad = subespecialidad;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemMuestrasBiologicas = new javax.swing.JPopupMenu();
        JMENUITEMQuitarMuestraBiologica = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JLBLSubespecialidadNombre = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLMuestrasBiologicasAsignadas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        JBTNCerrar = new javax.swing.JButton();
        JBTNActualizar = new javax.swing.JButton();

        JMENUITEMQuitarMuestraBiologica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/quitar.png"))); // NOI18N
        JMENUITEMQuitarMuestraBiologica.setText("Quitar Muestra Biológica");
        JMENUITEMQuitarMuestraBiologica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMQuitarMuestraBiologicaActionPerformed(evt);
            }
        });
        JPOPUPMENUItemMuestrasBiologicas.add(JMENUITEMQuitarMuestraBiologica);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Muestras Biológicas Asignadas");
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Muestras Biológicas Asignadas"));

        JTBLMuestrasBiologicasAsignadas.setModel(tableModelReasignarMuestrasBiologicas);
        JTBLMuestrasBiologicasAsignadas.setComponentPopupMenu(JPOPUPMENUItemMuestrasBiologicas);
        JTBLMuestrasBiologicasAsignadas.setEnabled(false);
        JTBLMuestrasBiologicasAsignadas.setRowHeight(20);
        JTBLMuestrasBiologicasAsignadas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTBLMuestrasBiologicasAsignadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLMuestrasBiologicasAsignadasMousePressed(evt);
            }
        });
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLMuestrasBiologicasAsignadas.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);

        JTBLMuestrasBiologicasAsignadas.getColumnModel().getColumn(0).setPreferredWidth(40);
        JTBLMuestrasBiologicasAsignadas.getColumnModel().getColumn(1).setPreferredWidth(900);
        jScrollPane1.setViewportView(JTBLMuestrasBiologicasAsignadas);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
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
                presenterGestionSubespecialidades.obtenerMuestrasBiologicasAsignadas(subespecialidad);
            }
        } catch (final HeadlessException headlessException) {
            System.err.println("Se produjo un error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTBLMuestrasBiologicasAsignadasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLMuestrasBiologicasAsignadasMousePressed
        final int currentRow = JTBLMuestrasBiologicasAsignadas.rowAtPoint(evt.getPoint());
        JTBLMuestrasBiologicasAsignadas.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLMuestrasBiologicasAsignadasMousePressed

    private void JMENUITEMQuitarMuestraBiologicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMQuitarMuestraBiologicaActionPerformed
       final SubespecialidadMuestra subespecialidadMuestra = obtenerSubespecialidadMuestraSeleccionada();
        
        final int option = JOptionPane.showConfirmDialog(this, "¿Quitar la muestra biológica " + subespecialidadMuestra.getMuestraBiologica().getMuestraBiologicaTipo() + " de la subespecialidad " + subespecialidad.getSubespecialidadNombre() + "?", "SIET", JOptionPane.YES_NO_OPTION);
        
        if (option == 0) {
            presenterGestionSubespecialidadMuestra.quitarMuestraBiologicaSubespecialidad(subespecialidadMuestra);
        }
    }//GEN-LAST:event_JMENUITEMQuitarMuestraBiologicaActionPerformed

    private void JBTNCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCerrarActionPerformed

    private void JBTNActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_JBTNActualizarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            VerMuestrasBiologicasAsignadas dialog = new VerMuestrasBiologicasAsignadas(new javax.swing.JFrame(), true);
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
    private javax.swing.JMenuItem JMENUITEMQuitarMuestraBiologica;
    private javax.swing.JPopupMenu JPOPUPMENUItemMuestrasBiologicas;
    private javax.swing.JTable JTBLMuestrasBiologicasAsignadas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    
    private void actualizarTabla() {
        tableModelReasignarMuestrasBiologicas.limpiarLista();
        presenterGestionSubespecialidades.obtenerMuestrasBiologicasAsignadas(subespecialidad);
    }
    
    private SubespecialidadMuestra obtenerSubespecialidadMuestraSeleccionada() {
        final int rowModel = JTBLMuestrasBiologicasAsignadas.convertRowIndexToModel(JTBLMuestrasBiologicasAsignadas.getSelectedRow());
        return tableModelReasignarMuestrasBiologicas.getSubespecialidadMuestra(rowModel);
    }
    @Override
    public void muestrasBiologicasAsignadasObtenidas(final List<SubespecialidadMuestra> subespecialidadesMuestras) {
        tableModelReasignarMuestrasBiologicas.setSubespecialidadesMuestras(subespecialidadesMuestras);
        JTBLMuestrasBiologicasAsignadas.getTableHeader().setReorderingAllowed(false);
    }

    @Override
    public void listaMuestrasBiologicasAsignadasVacia(final String msg) {
    }

    @Override
    public void errorObtenerMuestrasBiologicasAsignadas(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerMuestrasBiologicasAsignadas(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void muestraBiologicaSubespecialidadQuitada(final String msg) {
        actualizarTabla();
    }

    @Override
    public void errorQuitarMuestraBiologicaSubespecialidad(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoQuitarMuestraBiologicaSubespecialidad(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}