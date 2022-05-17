package View.GestionExamenes;

import Model.POJO.Examen;
import Model.POJO.Tecnica;
import Presenter.GestionExamenes.PresenterGestionExamenes;
import Presenter.GestionExamenes.PresenterGestionTecnicas;
import View.Utilitarios.ModelTable.GestionExamenes.TableModelVerTecnicasAgregadas;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Brynner
 */
public class VerTecnicasAgregadas extends javax.swing.JDialog implements PresenterGestionExamenes.CallBackObtenerTecnicasAgregadas, PresenterGestionTecnicas.CallBackEliminarTecnica {
    
    private final TableModelVerTecnicasAgregadas tableModelVerTecnicasAgregadas;
    private final PresenterGestionExamenes presenterGestionExamenes;
    private final PresenterGestionTecnicas presenterGestionTecnicas;
    private Examen examen;

    public VerTecnicasAgregadas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        tableModelVerTecnicasAgregadas = new TableModelVerTecnicasAgregadas();
        presenterGestionExamenes = new PresenterGestionExamenes();
        presenterGestionTecnicas = new PresenterGestionTecnicas();
        presenterGestionExamenes.setCallBackObtenerTecnicasAgregadas(this);
        presenterGestionTecnicas.setCallBackEliminarTecnica(this);
        
        initComponents();
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemTecnicaAsignada = new javax.swing.JPopupMenu();
        JMENUITEMModificarTecnica = new javax.swing.JMenuItem();
        JMENUITEMEliminarTecnica = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JLBLExamenNombre = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLTecnicasAgregadas = new javax.swing.JTable();
        JBTNCerrar = new javax.swing.JButton();
        JBTNActualizar = new javax.swing.JButton();
        JBTNAgregarTecnica = new javax.swing.JButton();

        JMENUITEMModificarTecnica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/modificar_password.png"))); // NOI18N
        JMENUITEMModificarTecnica.setText("Modificar Técnica");
        JMENUITEMModificarTecnica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMModificarTecnicaActionPerformed(evt);
            }
        });
        JPOPUPMENUItemTecnicaAsignada.add(JMENUITEMModificarTecnica);

        JMENUITEMEliminarTecnica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/eliminar.png"))); // NOI18N
        JMENUITEMEliminarTecnica.setText("Eliminar Técnica");
        JMENUITEMEliminarTecnica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMEliminarTecnicaActionPerformed(evt);
            }
        });
        JPOPUPMENUItemTecnicaAsignada.add(JMENUITEMEliminarTecnica);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Ver Técnicas Agregadas");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Examen"));

        jLabel1.setText("EXAMEN:");

        JLBLExamenNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(JLBLExamenNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLExamenNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Técnicas Agregadas"));

        JTBLTecnicasAgregadas.setModel(tableModelVerTecnicasAgregadas);
        JTBLTecnicasAgregadas.setComponentPopupMenu(JPOPUPMENUItemTecnicaAsignada);
        JTBLTecnicasAgregadas.setRowHeight(20);
        JTBLTecnicasAgregadas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTBLTecnicasAgregadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLTecnicasAgregadasMousePressed(evt);
            }
        });
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLTecnicasAgregadas.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);

        JTBLTecnicasAgregadas.getColumnModel().getColumn(0).setPreferredWidth(30);
        JTBLTecnicasAgregadas.getColumnModel().getColumn(1).setPreferredWidth(200);
        JTBLTecnicasAgregadas.getColumnModel().getColumn(2).setPreferredWidth(200);
        jScrollPane1.setViewportView(JTBLTecnicasAgregadas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        JBTNAgregarTecnica.setText("AGREGAR TECNICA");
        JBTNAgregarTecnica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNAgregarTecnicaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBTNCerrar)
                        .addGap(18, 18, 18)
                        .addComponent(JBTNActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBTNAgregarTecnica)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNCerrar)
                    .addComponent(JBTNActualizar)
                    .addComponent(JBTNAgregarTecnica))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            if (examen == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                JLBLExamenNombre.setText(examen.getExamenNombre());
                presenterGestionExamenes.obtenerTecnicasAgregadas(examen);
            }
        } catch (final HeadlessException headlessException) {
            System.err.println("Se produjo un error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTBLTecnicasAgregadasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLTecnicasAgregadasMousePressed
        final int currentRow = JTBLTecnicasAgregadas.rowAtPoint(evt.getPoint());
        JTBLTecnicasAgregadas.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLTecnicasAgregadasMousePressed

    private void JMENUITEMModificarTecnicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMModificarTecnicaActionPerformed
        final ModificarTecnica modificarTecnica = new ModificarTecnica(null, true);
        modificarTecnica.setTecnica(obtenerTecnicaSeleccionada());
        modificarTecnica.setVisible(true);
        
        if (!modificarTecnica.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMModificarTecnicaActionPerformed

    private void JMENUITEMEliminarTecnicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMEliminarTecnicaActionPerformed
        final Tecnica tecnica = obtenerTecnicaSeleccionada();
        
        int opcionSeleccionada = JOptionPane.showConfirmDialog(this, "¿Eliminar la técnica?\n\nDatos:\n\nTECNICA: " + tecnica.getTecnicaNombre() + "\nMETODO: " + tecnica.getTecnicaMetodo() + "\n\n¿Eliminar?\n\n", "SIET", JOptionPane.YES_NO_OPTION);

        if (opcionSeleccionada == 0) {
            presenterGestionTecnicas.eliminarTecnica(tecnica);
        }
    }//GEN-LAST:event_JMENUITEMEliminarTecnicaActionPerformed

    private void JBTNCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCerrarActionPerformed

    private void JBTNActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_JBTNActualizarActionPerformed

    private void JBTNAgregarTecnicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNAgregarTecnicaActionPerformed
        final AgregarTecnica agregarTecnica = new AgregarTecnica(null, true);
        agregarTecnica.setExamen(examen);
        agregarTecnica.setVisible(true);
        
        if (!agregarTecnica.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JBTNAgregarTecnicaActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            VerTecnicasAgregadas dialog = new VerTecnicasAgregadas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNAgregarTecnica;
    private javax.swing.JButton JBTNCerrar;
    private javax.swing.JLabel JLBLExamenNombre;
    private javax.swing.JMenuItem JMENUITEMEliminarTecnica;
    private javax.swing.JMenuItem JMENUITEMModificarTecnica;
    private javax.swing.JPopupMenu JPOPUPMENUItemTecnicaAsignada;
    private javax.swing.JTable JTBLTecnicasAgregadas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private Tecnica obtenerTecnicaSeleccionada() {
        final int rowModel = JTBLTecnicasAgregadas.convertRowIndexToModel(JTBLTecnicasAgregadas.getSelectedRow());
        return tableModelVerTecnicasAgregadas.getTecnica(rowModel);
    }
    
    private void actualizarTabla() {
        tableModelVerTecnicasAgregadas.limpiarLista();
        presenterGestionExamenes.obtenerTecnicasAgregadas(examen);
    }

    @Override
    public void tecnicasAgregadasObtenidas(final List<Tecnica> tecnicasAgregadas) {
        tableModelVerTecnicasAgregadas.setTecnicas(tecnicasAgregadas);
        JTBLTecnicasAgregadas.setRowSorter(new TableRowSorter<>(tableModelVerTecnicasAgregadas));
        JTBLTecnicasAgregadas.getTableHeader().setReorderingAllowed(false);
    }

    @Override
    public void listaTecnicasAgregadasVacia(final String msg) {
        
    }

    @Override
    public void errorObtenerTecnicasAgregadas(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerTecnicasAgregadas(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void examenEliminado(final String msg) {
        actualizarTabla();
    }

    @Override
    public void errorEliminarTecnica(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoEliminarTecnica(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}