package View.GestionPacientes;

import Model.POJO.Paciente;
import Model.POJOPersonalizado.PacientePersonalizado;
import Presenter.GestionPacientes.PresenterGestionPacientes;
import View.Utilitarios.ModelTable.GestionPacientes.TableModelGestionPacientes;
import java.awt.event.ItemEvent;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Brynner
 */
public class GestionPacientes extends javax.swing.JInternalFrame implements PresenterGestionPacientes.CallBackObtenerPacientes {

    private final TableModelGestionPacientes tableModelGestionPacientes;
    private final PresenterGestionPacientes presenterGestionPacientes;

    public GestionPacientes() {

        presenterGestionPacientes = new PresenterGestionPacientes();
        presenterGestionPacientes.setCallBackObtenerPacientes(this);
        
        tableModelGestionPacientes = new TableModelGestionPacientes();

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemPaciente = new javax.swing.JPopupMenu();
        JMENUITEMModificarPaciente = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        JMENUITEMVerSeguimientos = new javax.swing.JMenuItem();
        JMENUITEMVerHistorialClinico = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        JTXTFBuscarPaciente = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLPacientes = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        BTNActualizar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        JCMBXBuscarPor = new javax.swing.JComboBox<>();

        JMENUITEMModificarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/modificar_informacion.png"))); // NOI18N
        JMENUITEMModificarPaciente.setText("Modificar Paciente");
        JMENUITEMModificarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMModificarPacienteActionPerformed(evt);
            }
        });
        JPOPUPMENUItemPaciente.add(JMENUITEMModificarPaciente);
        JPOPUPMENUItemPaciente.add(jSeparator1);

        JMENUITEMVerSeguimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_seguimiento.png"))); // NOI18N
        JMENUITEMVerSeguimientos.setText("Ver Seguimientos");
        JMENUITEMVerSeguimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerSeguimientosActionPerformed(evt);
            }
        });
        JPOPUPMENUItemPaciente.add(JMENUITEMVerSeguimientos);

        JMENUITEMVerHistorialClinico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_recepciones.png"))); // NOI18N
        JMENUITEMVerHistorialClinico.setText("Ver Historial Clínico");
        JMENUITEMVerHistorialClinico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerHistorialClinicoActionPerformed(evt);
            }
        });
        JPOPUPMENUItemPaciente.add(JMENUITEMVerHistorialClinico);

        setTitle("Gestión de Pacientes");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_pacientes.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(1200, 700));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Paciente"));

        JTXTFBuscarPaciente.setEnabled(false);
        JTXTFBuscarPaciente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFBuscarPacienteFocusGained(evt);
            }
        });
        JTXTFBuscarPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFBuscarPacienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFBuscarPacienteKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTXTFBuscarPaciente)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTXTFBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pacientes"));

        JTBLPacientes.setModel(tableModelGestionPacientes);
        JTBLPacientes.setComponentPopupMenu(JPOPUPMENUItemPaciente);
        JTBLPacientes.setEnabled(false);
        JTBLPacientes.setRowHeight(20);
        JTBLPacientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTBLPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLPacientesMousePressed(evt);
            }
        });
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLPacientes.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
        JTBLPacientes.getColumnModel().getColumn(1).setCellRenderer(defaultTableCellRenderer);
        JTBLPacientes.getColumnModel().getColumn(2).setCellRenderer(defaultTableCellRenderer);
        JTBLPacientes.getColumnModel().getColumn(5).setCellRenderer(defaultTableCellRenderer);
        JTBLPacientes.getColumnModel().getColumn(6).setCellRenderer(defaultTableCellRenderer);

        JTBLPacientes.getColumnModel().getColumn(0).setPreferredWidth(10);
        JTBLPacientes.getColumnModel().getColumn(1).setPreferredWidth(40);
        JTBLPacientes.getColumnModel().getColumn(2).setPreferredWidth(50);
        JTBLPacientes.getColumnModel().getColumn(3).setPreferredWidth(200);
        JTBLPacientes.getColumnModel().getColumn(4).setPreferredWidth(200);
        JTBLPacientes.getColumnModel().getColumn(5).setPreferredWidth(10);
        JTBLPacientes.getColumnModel().getColumn(6).setPreferredWidth(20);
        jScrollPane1.setViewportView(JTBLPacientes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1132, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                .addContainerGap())
        );

        BTNActualizar.setText("ACTUALIZAR");
        BTNActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTNActualizar)
                .addContainerGap(1079, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BTNActualizar)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar por"));

        JCMBXBuscarPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CEDULA DE IDENTIDAD", "APELLIDO", "NOMBRE" }));
        JCMBXBuscarPor.setEnabled(false);
        JCMBXBuscarPor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCMBXBuscarPorItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JCMBXBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JCMBXBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        presenterGestionPacientes.obtenerPacientes();
    }//GEN-LAST:event_formInternalFrameActivated

    private void JTXTFBuscarPacienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFBuscarPacienteKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFBuscarPaciente.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFBuscarPacienteKeyTyped

    private void JTXTFBuscarPacienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFBuscarPacienteKeyReleased
        final String search = JTXTFBuscarPaciente.getText().toUpperCase();
        final TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) JTBLPacientes.getRowSorter();

        final int selectedIndex = JCMBXBuscarPor.getSelectedIndex();

        switch (selectedIndex) {
            case 0:
                sorter.setRowFilter(RowFilter.regexFilter(search, 2));
                break;

            case 1:
                sorter.setRowFilter(RowFilter.regexFilter(search, 3));
                break;

            case 2:
                sorter.setRowFilter(RowFilter.regexFilter(search, 4));
                break;

            default:
                sorter.setRowFilter(RowFilter.regexFilter(search, 2));
                break;
        }
    }//GEN-LAST:event_JTXTFBuscarPacienteKeyReleased

    private void JTBLPacientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLPacientesMousePressed
        final int currentRow = JTBLPacientes.rowAtPoint(evt.getPoint());
        JTBLPacientes.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLPacientesMousePressed

    private void BTNActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_BTNActualizarActionPerformed

    private void JMENUITEMModificarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMModificarPacienteActionPerformed
        final ModificarPaciente modificarPaciente = new ModificarPaciente(null, true);
        modificarPaciente.setPaciente(obtenerPacienteSeleccionado());
        modificarPaciente.setVisible(true);

        if (!modificarPaciente.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMModificarPacienteActionPerformed

    private void JMENUITEMVerSeguimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerSeguimientosActionPerformed
        final VerSeguimientos verSeguimientos = new VerSeguimientos(null, true);
        verSeguimientos.setPaciente(obtenerPacienteSeleccionado());
        verSeguimientos.setVisible(true);
        
        if (!verSeguimientos.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMVerSeguimientosActionPerformed

    private void JMENUITEMVerHistorialClinicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerHistorialClinicoActionPerformed
        final VerHistorialClinico verHistorialClinico = new VerHistorialClinico(null, true);
        verHistorialClinico.setPaciente(obtenerPacienteSeleccionado());
        verHistorialClinico.setVisible(true);
    }//GEN-LAST:event_JMENUITEMVerHistorialClinicoActionPerformed

    private void JCMBXBuscarPorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCMBXBuscarPorItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            JTXTFBuscarPaciente.requestFocus();
        }
    }//GEN-LAST:event_JCMBXBuscarPorItemStateChanged

    private void JTXTFBuscarPacienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFBuscarPacienteFocusGained
        JTXTFBuscarPaciente.selectAll();
    }//GEN-LAST:event_JTXTFBuscarPacienteFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNActualizar;
    private javax.swing.JComboBox<String> JCMBXBuscarPor;
    private javax.swing.JMenuItem JMENUITEMModificarPaciente;
    private javax.swing.JMenuItem JMENUITEMVerHistorialClinico;
    private javax.swing.JMenuItem JMENUITEMVerSeguimientos;
    private javax.swing.JPopupMenu JPOPUPMENUItemPaciente;
    private javax.swing.JTable JTBLPacientes;
    private javax.swing.JTextField JTXTFBuscarPaciente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables

    private void actualizarTabla() {
        tableModelGestionPacientes.limpiarLista();
        presenterGestionPacientes.obtenerPacientes();
    }
    
    private Paciente obtenerPacienteSeleccionado() {
        final int rowModel = JTBLPacientes.convertRowIndexToModel(JTBLPacientes.getSelectedRow());
        return tableModelGestionPacientes.getPacientePersonalizado(rowModel).getPaciente();
    }

    @Override
    public void pacientesObtenidos(final List<PacientePersonalizado> pacientesPersonalizados) {
        tableModelGestionPacientes.setPacientesPersonalizados(pacientesPersonalizados);
        JTBLPacientes.setRowSorter(new TableRowSorter<>(tableModelGestionPacientes));
        JTBLPacientes.getTableHeader().setReorderingAllowed(false);
        
        JTXTFBuscarPaciente.setEnabled(true);
        JCMBXBuscarPor.setEnabled(true);
    }

    @Override
    public void listaPacientesVacia(final String msg) {
        JTXTFBuscarPaciente.setEnabled(false);
        JCMBXBuscarPor.setEnabled(false);
    }

    @Override
    public void errorObtenerPacientes(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerPacientes(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}