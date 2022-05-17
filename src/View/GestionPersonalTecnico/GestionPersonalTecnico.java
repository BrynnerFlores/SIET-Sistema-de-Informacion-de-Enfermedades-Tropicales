package View.GestionPersonalTecnico;

import View.Utilitarios.Utilidades;
import Model.POJO.Cuenta;
import Presenter.GestionPersonalTecnico.PresenterGestionPersonalTecnico;
import View.Utilitarios.ModelTable.GestionPersonalTecnico.TableModelPersonalesTecnicosActivos;
import java.awt.HeadlessException;
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
public class GestionPersonalTecnico extends javax.swing.JInternalFrame implements PresenterGestionPersonalTecnico.CallBackObtenerCuentasPersonalesTecnicosHabilitados, PresenterGestionPersonalTecnico.CallBackReestablecerPassword, PresenterGestionPersonalTecnico.CallBackEliminarPersonalTecnico {

    private final TableModelPersonalesTecnicosActivos tableModelPersonalesTecnicosActivos;
    private final PresenterGestionPersonalTecnico presenterGestionPersonalTecnico;
    private Cuenta cuenta;

    public GestionPersonalTecnico() {
        
        presenterGestionPersonalTecnico = new PresenterGestionPersonalTecnico();
        presenterGestionPersonalTecnico.setCallBackObtenerCuentasPersonalesTecnicosHabilitados(this);
        presenterGestionPersonalTecnico.setCallBackReestablecerPassword(this);
        presenterGestionPersonalTecnico.setCallBackEliminarPersonalTecnico(this);
        
        tableModelPersonalesTecnicosActivos = new TableModelPersonalesTecnicosActivos();
        
        initComponents();
        
        cuenta = Utilidades.obtenerCuentaLocal();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemBioquimicos = new javax.swing.JPopupMenu();
        JMENUITEMMostrarDetalles = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        JMENUITEMReestablecerPassword = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        JMENUITEMEliminarPersonalTecnico = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        JTXTFBuscarPersonalTecnicoActivos = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLPersonalesTecnicosHabilitados = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        BTNActualizar = new javax.swing.JButton();
        BTNAgregarPersonalTecnico = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        JCMBXBuscarPor = new javax.swing.JComboBox<>();

        JMENUITEMMostrarDetalles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_informacion.png"))); // NOI18N
        JMENUITEMMostrarDetalles.setText("Mostrar Detalles");
        JMENUITEMMostrarDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMMostrarDetallesActionPerformed(evt);
            }
        });
        JPOPUPMENUItemBioquimicos.add(JMENUITEMMostrarDetalles);
        JPOPUPMENUItemBioquimicos.add(jSeparator1);

        JMENUITEMReestablecerPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/reestablecer_password.png"))); // NOI18N
        JMENUITEMReestablecerPassword.setText("Reestablecer Contraseña");
        JMENUITEMReestablecerPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMReestablecerPasswordActionPerformed(evt);
            }
        });
        JPOPUPMENUItemBioquimicos.add(JMENUITEMReestablecerPassword);
        JPOPUPMENUItemBioquimicos.add(jSeparator2);

        JMENUITEMEliminarPersonalTecnico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/eliminar.png"))); // NOI18N
        JMENUITEMEliminarPersonalTecnico.setText("Eliminar Personal Técnico");
        JMENUITEMEliminarPersonalTecnico.setToolTipText("");
        JMENUITEMEliminarPersonalTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMEliminarPersonalTecnicoActionPerformed(evt);
            }
        });
        JPOPUPMENUItemBioquimicos.add(JMENUITEMEliminarPersonalTecnico);

        setResizable(true);
        setTitle("Gestión de Personal Técnico");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_personal_tecnico.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(900, 600));
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Personal Técnico"));

        JTXTFBuscarPersonalTecnicoActivos.setEnabled(false);
        JTXTFBuscarPersonalTecnicoActivos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFBuscarPersonalTecnicoActivosFocusGained(evt);
            }
        });
        JTXTFBuscarPersonalTecnicoActivos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFBuscarPersonalTecnicoActivosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFBuscarPersonalTecnicoActivosKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTXTFBuscarPersonalTecnicoActivos)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTXTFBuscarPersonalTecnicoActivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Personal Técnico"));

        JTBLPersonalesTecnicosHabilitados.setModel(tableModelPersonalesTecnicosActivos);
        JTBLPersonalesTecnicosHabilitados.setComponentPopupMenu(JPOPUPMENUItemBioquimicos);
        JTBLPersonalesTecnicosHabilitados.setEnabled(false);
        JTBLPersonalesTecnicosHabilitados.setRowHeight(20);
        JTBLPersonalesTecnicosHabilitados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTBLPersonalesTecnicosHabilitados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLPersonalesTecnicosHabilitadosMousePressed(evt);
            }
        });
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLPersonalesTecnicosHabilitados.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
        JTBLPersonalesTecnicosHabilitados.getColumnModel().getColumn(1).setCellRenderer(defaultTableCellRenderer);
        JTBLPersonalesTecnicosHabilitados.getColumnModel().getColumn(4).setCellRenderer(defaultTableCellRenderer);
        JTBLPersonalesTecnicosHabilitados.getColumnModel().getColumn(6).setCellRenderer(defaultTableCellRenderer);
        JTBLPersonalesTecnicosHabilitados.getColumnModel().getColumn(7).setCellRenderer(defaultTableCellRenderer);

        JTBLPersonalesTecnicosHabilitados.getColumnModel().getColumn(0).setPreferredWidth(10);
        JTBLPersonalesTecnicosHabilitados.getColumnModel().getColumn(1).setPreferredWidth(40);
        JTBLPersonalesTecnicosHabilitados.getColumnModel().getColumn(2).setPreferredWidth(200);
        JTBLPersonalesTecnicosHabilitados.getColumnModel().getColumn(3).setPreferredWidth(200);
        JTBLPersonalesTecnicosHabilitados.getColumnModel().getColumn(4).setPreferredWidth(10);
        JTBLPersonalesTecnicosHabilitados.getColumnModel().getColumn(5).setPreferredWidth(100);
        JTBLPersonalesTecnicosHabilitados.getColumnModel().getColumn(6).setPreferredWidth(50);
        JTBLPersonalesTecnicosHabilitados.getColumnModel().getColumn(7).setPreferredWidth(50);
        jScrollPane1.setViewportView(JTBLPersonalesTecnicosHabilitados);

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

        BTNAgregarPersonalTecnico.setText("AGREGAR");
        BTNAgregarPersonalTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNAgregarPersonalTecnicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTNActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BTNAgregarPersonalTecnico)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNAgregarPersonalTecnico)
                    .addComponent(BTNActualizar))
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
        try {
            if (cuenta == null) {
                JOptionPane.showMessageDialog(rootPane, "Se produjo un error al obtener la cuenta local.", "SIET", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            } else {
                presenterGestionPersonalTecnico.obtenerCuentasPersonalesTecnicosHabilitados(cuenta);
            }
        } catch (final HeadlessException exception) {
            System.err.println("Se produjo un error: " + exception.getMessage() );
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }//GEN-LAST:event_formInternalFrameActivated

    private void JTXTFBuscarPersonalTecnicoActivosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFBuscarPersonalTecnicoActivosKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFBuscarPersonalTecnicoActivos.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFBuscarPersonalTecnicoActivosKeyTyped

    private void JTXTFBuscarPersonalTecnicoActivosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFBuscarPersonalTecnicoActivosKeyReleased
        final String search = JTXTFBuscarPersonalTecnicoActivos.getText();
        final TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) JTBLPersonalesTecnicosHabilitados.getRowSorter();

        final int selectedIndex = JCMBXBuscarPor.getSelectedIndex();

        switch (selectedIndex) {
            case 0:
                sorter.setRowFilter(RowFilter.regexFilter(search, 1));
                break;

            case 1:
                sorter.setRowFilter(RowFilter.regexFilter(search, 2));
                break;

            case 2:
                sorter.setRowFilter(RowFilter.regexFilter(search, 3));
                break;

            default:
                sorter.setRowFilter(RowFilter.regexFilter(search, 1));
                break;
        }
    }//GEN-LAST:event_JTXTFBuscarPersonalTecnicoActivosKeyReleased

    private void JTBLPersonalesTecnicosHabilitadosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLPersonalesTecnicosHabilitadosMousePressed
        final int currentRow = JTBLPersonalesTecnicosHabilitados.rowAtPoint(evt.getPoint());
        JTBLPersonalesTecnicosHabilitados.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLPersonalesTecnicosHabilitadosMousePressed

    private void JMENUITEMMostrarDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMMostrarDetallesActionPerformed
        final Cuenta cuenta = obtenerCuentaPersonalTecnicoSeleccionado();
        
        final DetallesPersonalTecnico detallesBioquimico = new DetallesPersonalTecnico(null, true);
        detallesBioquimico.setCuenta(cuenta);
        detallesBioquimico.setVisible(true);
    }//GEN-LAST:event_JMENUITEMMostrarDetallesActionPerformed

    private void JMENUITEMEliminarPersonalTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMEliminarPersonalTecnicoActionPerformed
        final Cuenta cuenta = obtenerCuentaPersonalTecnicoSeleccionado();

        final int option = JOptionPane.showConfirmDialog(this, "¿Estas seguro de eliminar al personal técnico?\n\nDATOS:\n\nC.I: " + cuenta.getPersonalTecnico().getPersona().getPersonaCedulaIdentidad() + "\nAPELLIDO: " + cuenta.getPersonalTecnico().getPersona().getPersonaApellido() + "\nNOMBRE: " + cuenta.getPersonalTecnico().getPersona().getPersonaNombre() + "\nSEXO: " + cuenta.getPersonalTecnico().getPersona().getPersonaSexo() + "\nPROFESION: " + cuenta.getPersonalTecnico().getPertecProfesion() + "\n\n¿Eliminar?\n\n", "SIET", JOptionPane.YES_NO_OPTION);
        
        if (option == 0) {
            presenterGestionPersonalTecnico.eliminarPersonalTecnico(cuenta);
        }
    }//GEN-LAST:event_JMENUITEMEliminarPersonalTecnicoActionPerformed

    private void BTNActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_BTNActualizarActionPerformed

    private void BTNAgregarPersonalTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNAgregarPersonalTecnicoActionPerformed
        final AgregarPersonalTecnico agregarPersonalTecnico = new AgregarPersonalTecnico(null, true);
        agregarPersonalTecnico.setVisible(true);
        if (!agregarPersonalTecnico.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_BTNAgregarPersonalTecnicoActionPerformed

    private void JCMBXBuscarPorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCMBXBuscarPorItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            JTXTFBuscarPersonalTecnicoActivos.requestFocus();
        }
    }//GEN-LAST:event_JCMBXBuscarPorItemStateChanged

    private void JMENUITEMReestablecerPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMReestablecerPasswordActionPerformed
        final Cuenta cuenta = obtenerCuentaPersonalTecnicoSeleccionado();
        final int option = JOptionPane.showConfirmDialog(this, "¿Estas seguro de reestablecer la contraseña del personal técnico?\n\nDATOS:\n\nC.I: " + cuenta.getPersonalTecnico().getPersona().getPersonaCedulaIdentidad() + "\nAPELLIDO: " + cuenta.getPersonalTecnico().getPersona().getPersonaApellido() + "\nNOMBRE: " + cuenta.getPersonalTecnico().getPersona().getPersonaNombre() + "\nSEXO: " + cuenta.getPersonalTecnico().getPersona().getPersonaSexo() + "\nPROFESION: " + cuenta.getPersonalTecnico().getPertecProfesion() + "\n\n¿Reestablecer contraseña?\n\n", "SIET", JOptionPane.YES_NO_OPTION);
        
        if (option == 0) {
            presenterGestionPersonalTecnico.reestablecerPassword(cuenta);
        }
    }//GEN-LAST:event_JMENUITEMReestablecerPasswordActionPerformed

    private void JTXTFBuscarPersonalTecnicoActivosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFBuscarPersonalTecnicoActivosFocusGained
        JTXTFBuscarPersonalTecnicoActivos.selectAll();
    }//GEN-LAST:event_JTXTFBuscarPersonalTecnicoActivosFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNActualizar;
    private javax.swing.JButton BTNAgregarPersonalTecnico;
    private javax.swing.JComboBox<String> JCMBXBuscarPor;
    private javax.swing.JMenuItem JMENUITEMEliminarPersonalTecnico;
    private javax.swing.JMenuItem JMENUITEMMostrarDetalles;
    private javax.swing.JMenuItem JMENUITEMReestablecerPassword;
    private javax.swing.JPopupMenu JPOPUPMENUItemBioquimicos;
    private javax.swing.JTable JTBLPersonalesTecnicosHabilitados;
    private javax.swing.JTextField JTXTFBuscarPersonalTecnicoActivos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    // End of variables declaration//GEN-END:variables

    private void actualizarTabla() {
        tableModelPersonalesTecnicosActivos.limpiarLista();
        presenterGestionPersonalTecnico.obtenerCuentasPersonalesTecnicosHabilitados(cuenta);
        
    }
    private Cuenta obtenerCuentaPersonalTecnicoSeleccionado() {
        final int rowModel = JTBLPersonalesTecnicosHabilitados.convertRowIndexToModel(JTBLPersonalesTecnicosHabilitados.getSelectedRow());
        return tableModelPersonalesTecnicosActivos.getCuentaBioquimico(rowModel);
    }
    @Override
    public void cuentasPersonalesTecnicosHabilitadosObtenidos(final List<Cuenta> cuentas) {
        tableModelPersonalesTecnicosActivos.setCuentas(cuentas);
        JTBLPersonalesTecnicosHabilitados.setRowSorter(new TableRowSorter<>(tableModelPersonalesTecnicosActivos));
        JTBLPersonalesTecnicosHabilitados.getTableHeader().setReorderingAllowed(false);
        
        JTXTFBuscarPersonalTecnicoActivos.setEnabled(true);
        JCMBXBuscarPor.setEnabled(true);
    }

    @Override
    public void listaCuentasPersonalesTecnicosHabilitadosVacia(final String msg) {
        JTXTFBuscarPersonalTecnicoActivos.setEnabled(false);
        JCMBXBuscarPor.setEnabled(false);
    }

    @Override
    public void errorObtenerCuentasPersonalesTecnicosHabilitados(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerCuentasPersonalesTecnicosHabilitados(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
    
    @Override
    public void passwordReestablecido(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void errorReestablecerPassword(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoReestablecerPassword(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
    @Override
    public void personalTecnicoEliminado() {
        actualizarTabla();
    }

    @Override
    public void errorEliminarPersonalTecnico(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoEliminarPersonalTecnico(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}