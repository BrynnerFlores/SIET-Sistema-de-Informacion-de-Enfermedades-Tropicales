package View.GestionExamenes;

import Model.POJO.Examen;
import Model.POJO.GrupoVariables;
import Model.POJOPersonalizado.GrupoVariablesPersonalizado;
import Presenter.GestionExamenes.PresenterGestionGrupoVariables;
import Presenter.GestionExamenes.PresenterGestionExamenes;
import View.Utilitarios.ModelTable.GestionExamenes.TableModelVerGrupoVariables;
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
public class VerGruposVariables extends javax.swing.JDialog implements PresenterGestionExamenes.CallBackObtenerGruposVariables, PresenterGestionGrupoVariables.CallBackCrearGrupoVariables, PresenterGestionGrupoVariables.CallBackEliminarGrupoVariables {
    
    private final TableModelVerGrupoVariables tableModelVerGrupoVariables;
    private final PresenterGestionExamenes presenterGestionExamenes;
    private final PresenterGestionGrupoVariables presenterGestionGrupoVariables;
    private Examen examen;
    
    public VerGruposVariables(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        presenterGestionExamenes = new PresenterGestionExamenes();
        presenterGestionGrupoVariables = new PresenterGestionGrupoVariables();
        presenterGestionExamenes.setCallBackObtenerGruposVariables(this);
        presenterGestionGrupoVariables.setCallBackCrearGrupoVariables(this);
        presenterGestionGrupoVariables.setCallBackEliminarGrupoVariables(this);
        
        tableModelVerGrupoVariables = new TableModelVerGrupoVariables();
        
        initComponents();
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemGrupoVariables = new javax.swing.JPopupMenu();
        JMENUITEMCrearVariable = new javax.swing.JMenuItem();
        JMENUITEMVerVariables = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        JMENUITEMModificarGrupo = new javax.swing.JMenuItem();
        JMENUITEMEliminarGrupo = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JLBLExamenNombre = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLGrupoVariables = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        JBTNCerrar = new javax.swing.JButton();
        JBTNCrearGrupo = new javax.swing.JButton();
        JBTNActualizar = new javax.swing.JButton();

        JMENUITEMCrearVariable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/nuevo_documento.png"))); // NOI18N
        JMENUITEMCrearVariable.setText("Crear Variable");
        JMENUITEMCrearVariable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMCrearVariableActionPerformed(evt);
            }
        });
        JPOPUPMENUItemGrupoVariables.add(JMENUITEMCrearVariable);

        JMENUITEMVerVariables.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_detalles_recepcion.png"))); // NOI18N
        JMENUITEMVerVariables.setText("Ver Variables");
        JMENUITEMVerVariables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerVariablesActionPerformed(evt);
            }
        });
        JPOPUPMENUItemGrupoVariables.add(JMENUITEMVerVariables);
        JPOPUPMENUItemGrupoVariables.add(jSeparator1);

        JMENUITEMModificarGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/modificar_password.png"))); // NOI18N
        JMENUITEMModificarGrupo.setText("Modificar Grupo");
        JMENUITEMModificarGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMModificarGrupoActionPerformed(evt);
            }
        });
        JPOPUPMENUItemGrupoVariables.add(JMENUITEMModificarGrupo);

        JMENUITEMEliminarGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/eliminar.png"))); // NOI18N
        JMENUITEMEliminarGrupo.setText("Eliminar Grupo");
        JMENUITEMEliminarGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMEliminarGrupoActionPerformed(evt);
            }
        });
        JPOPUPMENUItemGrupoVariables.add(JMENUITEMEliminarGrupo);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Ver Grupo de Variables");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Examen"));

        jLabel1.setText("NOMBRE:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JLBLExamenNombre)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JLBLExamenNombre))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Grupos de Variables"));

        JTBLGrupoVariables.setModel(tableModelVerGrupoVariables);
        JTBLGrupoVariables.setComponentPopupMenu(JPOPUPMENUItemGrupoVariables);
        JTBLGrupoVariables.setEnabled(false);
        JTBLGrupoVariables.setRowHeight(20);
        JTBLGrupoVariables.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTBLGrupoVariables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLGrupoVariablesMousePressed(evt);
            }
        });
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLGrupoVariables.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
        JTBLGrupoVariables.getColumnModel().getColumn(2).setCellRenderer(defaultTableCellRenderer);

        JTBLGrupoVariables.getColumnModel().getColumn(0).setPreferredWidth(40);
        JTBLGrupoVariables.getColumnModel().getColumn(1).setPreferredWidth(500);
        JTBLGrupoVariables.getColumnModel().getColumn(2).setPreferredWidth(150);
        jScrollPane1.setViewportView(JTBLGrupoVariables);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addContainerGap())
        );

        JBTNCerrar.setText("CERRAR");
        JBTNCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCerrarActionPerformed(evt);
            }
        });

        JBTNCrearGrupo.setText("CREAR GRUPO");
        JBTNCrearGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCrearGrupoActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBTNCrearGrupo)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNCerrar)
                    .addComponent(JBTNCrearGrupo)
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            if (examen == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                JLBLExamenNombre.setText(examen.getExamenNombre());
                presenterGestionExamenes.obtenerGruposVariables(examen);
            }
        } catch (final HeadlessException headlessException) {
            System.err.println("Se produjo un error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTBLGrupoVariablesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLGrupoVariablesMousePressed
        final int currentRow = JTBLGrupoVariables.rowAtPoint(evt.getPoint());
        JTBLGrupoVariables.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLGrupoVariablesMousePressed

    private void JMENUITEMCrearVariableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMCrearVariableActionPerformed
        final GrupoVariables grupoVariables = obtenerGrupoVariablesSeleccionado();
        
        final CrearVariable crearVariable = new CrearVariable(null, true);
        crearVariable.setGrupoVariables(grupoVariables);
        crearVariable.setVisible(true);
        
        if (!crearVariable.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMCrearVariableActionPerformed

    private void JMENUITEMVerVariablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerVariablesActionPerformed
        final GrupoVariables grupoVariables = obtenerGrupoVariablesSeleccionado();
        
        final VerVariables verVariables = new VerVariables(null, true);
        verVariables.setGrupoVariables(grupoVariables);
        verVariables.setVisible(true);
        
        if (!verVariables.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMVerVariablesActionPerformed

    private void JMENUITEMModificarGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMModificarGrupoActionPerformed
        final GrupoVariables grupoVariables = obtenerGrupoVariablesSeleccionado();
        
        final ModificarGrupoVariables modificarGrupoVariables = new ModificarGrupoVariables(null, true);
        modificarGrupoVariables.setGrupoVariables(grupoVariables);
        modificarGrupoVariables.setVisible(true);
        
        if (!modificarGrupoVariables.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMModificarGrupoActionPerformed

    private void JMENUITEMEliminarGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMEliminarGrupoActionPerformed
        final GrupoVariables grupoVariables = obtenerGrupoVariablesSeleccionado();
        
        int opcionSeleccionada = JOptionPane.showConfirmDialog(this, "¿Eliminar Grupo de Variables?\n\nDatos:\n\n"
                + "\nGRUPO DE VARIABLE: " + grupoVariables.getGrupoVariableNombre() + "\n\n¿Eliminar?\n\n", "SIET", JOptionPane.YES_NO_OPTION);

        if (opcionSeleccionada == 0) {
            presenterGestionGrupoVariables.eliminarGrupoVariables(grupoVariables);
        }
    }//GEN-LAST:event_JMENUITEMEliminarGrupoActionPerformed

    private void JBTNCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCerrarActionPerformed

    private void JBTNActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_JBTNActualizarActionPerformed

    private void JBTNCrearGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCrearGrupoActionPerformed
        final CrearGrupoVariables crearGrupoVariables = new CrearGrupoVariables(null, true);
        crearGrupoVariables.setExamen(examen);
        crearGrupoVariables.setVisible(true);
        
        if (!crearGrupoVariables.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JBTNCrearGrupoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            VerGruposVariables dialog = new VerGruposVariables(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNCrearGrupo;
    private javax.swing.JLabel JLBLExamenNombre;
    private javax.swing.JMenuItem JMENUITEMCrearVariable;
    private javax.swing.JMenuItem JMENUITEMEliminarGrupo;
    private javax.swing.JMenuItem JMENUITEMModificarGrupo;
    private javax.swing.JMenuItem JMENUITEMVerVariables;
    private javax.swing.JPopupMenu JPOPUPMENUItemGrupoVariables;
    private javax.swing.JTable JTBLGrupoVariables;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables

    private void actualizarTabla() {
        tableModelVerGrupoVariables.limpiarLista();
        presenterGestionExamenes.obtenerGruposVariables(examen);
    }
    private GrupoVariables obtenerGrupoVariablesSeleccionado() {
        final int rowModel = JTBLGrupoVariables.convertRowIndexToModel(JTBLGrupoVariables.getSelectedRow());
        return tableModelVerGrupoVariables.getGrupoVariables(rowModel);
    }
    
    @Override
    public void gruposVariablesObtenidos(final List<GrupoVariablesPersonalizado> gruposVariablesPersonalizados) {
        tableModelVerGrupoVariables.setGruposVariablesPersonalizados(gruposVariablesPersonalizados);
        JTBLGrupoVariables.getTableHeader().setReorderingAllowed(false);
    }

    @Override
    public void listaGruposVariablesVacia(final String msg) {
    }

    @Override
    public void errorObtenerGruposVariables(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerGruposVariables(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void grupoVariablesCreado(final String msg) {
        dispose();
    }

    @Override
    public void errorCrearGrupoVariables(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoCrearGrupoVariables(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void grupoVariablesEliminado(final String msg) {
        actualizarTabla();
    }

    @Override
    public void errorEliminarGrupoVariables(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoEliminarGrupoVariables(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}