package View.GestionExamenes;

import Model.POJO.Examen;
import Model.POJO.GrupoVariables;
import Model.POJO.VariableExamen;
import Presenter.GestionExamenes.PresenterGestionGrupoVariables;
import Presenter.GestionExamenes.PresenterGestionVariablesExamen;
import View.Utilitarios.ModelTable.GestionExamenes.TableModelVerVariables;
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
public class VerVariables extends javax.swing.JDialog implements PresenterGestionGrupoVariables.CallBackObtenerVariables, PresenterGestionVariablesExamen.CallBackEliminarVariableExamen {
    
    private final TableModelVerVariables tableModelVerVariables;
    private final PresenterGestionGrupoVariables presenterGestionGrupoVariables;
    private final PresenterGestionVariablesExamen presenterGestionVariablesExamen;
    private GrupoVariables grupoVariables;
    
    public VerVariables(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        presenterGestionGrupoVariables = new PresenterGestionGrupoVariables();
        presenterGestionVariablesExamen = new PresenterGestionVariablesExamen();
        presenterGestionGrupoVariables.setCallBackObtenerVariables(this);
        presenterGestionVariablesExamen.setCallBackEliminarVariableExamen(this);
        
        tableModelVerVariables = new TableModelVerVariables();
        
        initComponents();
    }

    public void setGrupoVariables(GrupoVariables grupoVariables) {
        this.grupoVariables = grupoVariables;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemVariableExamen = new javax.swing.JPopupMenu();
        JMENUITEMModificarVariable = new javax.swing.JMenuItem();
        JMENUITEMEliminarVariable = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JLBLGrupoVariablesNombre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JLBLExamenNombre = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLVariables = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        JBTNCerrar = new javax.swing.JButton();
        JBTNActualizar = new javax.swing.JButton();
        JBTNCrearVariable = new javax.swing.JButton();

        JMENUITEMModificarVariable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/modificar_password.png"))); // NOI18N
        JMENUITEMModificarVariable.setText("Modificar Variable");
        JMENUITEMModificarVariable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMModificarVariableActionPerformed(evt);
            }
        });
        JPOPUPMENUItemVariableExamen.add(JMENUITEMModificarVariable);

        JMENUITEMEliminarVariable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/eliminar.png"))); // NOI18N
        JMENUITEMEliminarVariable.setText("Eliminar Variable");
        JMENUITEMEliminarVariable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMEliminarVariableActionPerformed(evt);
            }
        });
        JPOPUPMENUItemVariableExamen.add(JMENUITEMEliminarVariable);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Variables del Grupo");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Grupo"));

        jLabel1.setText("NOMBRE DEL GRUPO:");

        jLabel2.setText("NOMBRE DEL EXAMEN:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLBLGrupoVariablesNombre)
                    .addComponent(JLBLExamenNombre))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JLBLGrupoVariablesNombre))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JLBLExamenNombre))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Variables del Grupo"));

        JTBLVariables.setModel(tableModelVerVariables);
        JTBLVariables.setComponentPopupMenu(JPOPUPMENUItemVariableExamen);
        JTBLVariables.setEnabled(false);
        JTBLVariables.setRowHeight(20);
        JTBLVariables.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTBLVariables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLVariablesMousePressed(evt);
            }
        });
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLVariables.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);

        JTBLVariables.getColumnModel().getColumn(0).setPreferredWidth(10);
        JTBLVariables.getColumnModel().getColumn(1).setPreferredWidth(200);
        JTBLVariables.getColumnModel().getColumn(2).setPreferredWidth(150);
        JTBLVariables.getColumnModel().getColumn(3).setPreferredWidth(150);
        JTBLVariables.getColumnModel().getColumn(4).setPreferredWidth(100);
        JTBLVariables.getColumnModel().getColumn(5).setPreferredWidth(50);
        JTBLVariables.getColumnModel().getColumn(6).setPreferredWidth(50);
        jScrollPane1.setViewportView(JTBLVariables);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
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

        JBTNCrearVariable.setText("CREAR VARIABLE");
        JBTNCrearVariable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCrearVariableActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 677, Short.MAX_VALUE)
                .addComponent(JBTNCrearVariable)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNCerrar)
                    .addComponent(JBTNActualizar)
                    .addComponent(JBTNCrearVariable))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
            if (grupoVariables == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                final Examen examen = grupoVariables.getExamen();
                JLBLGrupoVariablesNombre.setText(grupoVariables.getGrupoVariableNombre());
                JLBLExamenNombre.setText(examen.getExamenNombre());
                presenterGestionGrupoVariables.obtenerVariables(grupoVariables);
            }
        } catch (final HeadlessException headlessException) {
            System.err.println("Se produjo un error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(this, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTBLVariablesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLVariablesMousePressed
        final int currentRow = JTBLVariables.rowAtPoint(evt.getPoint());
        JTBLVariables.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLVariablesMousePressed

    private void JMENUITEMModificarVariableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMModificarVariableActionPerformed
        final VariableExamen variableExamen = obtenerVariableExamenSeleccionado();
        
        final ModificarVariableExamen modificarVariableExamen = new ModificarVariableExamen(null, true);
        modificarVariableExamen.setVariableExamen(variableExamen);
        modificarVariableExamen.setVisible(true);
        
        if (!modificarVariableExamen.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMModificarVariableActionPerformed

    private void JMENUITEMEliminarVariableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMEliminarVariableActionPerformed
        final VariableExamen variableExamen = obtenerVariableExamenSeleccionado();
        
        final int option = JOptionPane.showConfirmDialog(this, "¿Eliminar variable?\n\nDatos:\n\nVARIABLE: " + variableExamen.getVariableExamenNombre() + "\nVALOR DE REFERENCIA: " + variableExamen.getVariableExamenValorReferencia() + "\n\n¿Eliminar?\n\n", "SIET", JOptionPane.YES_NO_OPTION);
        
        if (option == 0) {
            presenterGestionVariablesExamen.eliminarVariableExamen(variableExamen);
        }
    }//GEN-LAST:event_JMENUITEMEliminarVariableActionPerformed

    private void JBTNCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCerrarActionPerformed

    private void JBTNActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_JBTNActualizarActionPerformed

    private void JBTNCrearVariableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCrearVariableActionPerformed
        final CrearVariable crearVariable = new CrearVariable(null, true);
        crearVariable.setGrupoVariables(grupoVariables);
        crearVariable.setVisible(true);
        
        if (!crearVariable.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JBTNCrearVariableActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            VerVariables dialog = new VerVariables(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNCrearVariable;
    private javax.swing.JLabel JLBLExamenNombre;
    private javax.swing.JLabel JLBLGrupoVariablesNombre;
    private javax.swing.JMenuItem JMENUITEMEliminarVariable;
    private javax.swing.JMenuItem JMENUITEMModificarVariable;
    private javax.swing.JPopupMenu JPOPUPMENUItemVariableExamen;
    private javax.swing.JTable JTBLVariables;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void actualizarTabla() {
        tableModelVerVariables.limpiarLista();
        presenterGestionGrupoVariables.obtenerVariables(grupoVariables);
    }
    
    private VariableExamen obtenerVariableExamenSeleccionado() {
        final int rowModel = JTBLVariables.convertRowIndexToModel(JTBLVariables.getSelectedRow());
        return tableModelVerVariables.getVariableExamen(rowModel);
    }
    
    @Override
    public void variablesObtenidas(final List<VariableExamen> variablesExamen) {
        tableModelVerVariables.setVariablesExamen(variablesExamen);
        JTBLVariables.getTableHeader().setReorderingAllowed(false);
    }

    @Override
    public void listaVariablesVacia(final String msg) {
    }

    @Override
    public void errorObtenerVariables(final String msg) {
        JOptionPane.showMessageDialog(this, msg,"SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerVariables(final String msg) {
        JOptionPane.showMessageDialog(this, msg,"SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void variableExamenEliminada(final String msg) {
        actualizarTabla();
    }

    @Override
    public void errorEliminarVariableExamen(final String msg) {
        JOptionPane.showMessageDialog(this, msg,"SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoEliminarVariableExamen(final String msg) {
        JOptionPane.showMessageDialog(this, msg,"SIET", JOptionPane.ERROR_MESSAGE);
    }
}