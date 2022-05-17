package View.GestionRecepciones;

import Model.POJO.Recepcion;
import Model.POJOPersonalizado.RecepcionPersonalizada;
import Presenter.GestionRecepciones.PresenterGestionRecepciones;
import View.GestionPacientes.ModificarPaciente;
import View.Utilitarios.ModelTable.GestionRecepciones.TableModelGestionRecepciones;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.AbstractAction;
import javax.swing.Action;
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
public class GestionRecepciones extends javax.swing.JInternalFrame implements PresenterGestionRecepciones.CallBackObtenerRecepciones, PresenterGestionRecepciones.CallBackEliminarRecepcion {

    private final TableModelGestionRecepciones tableModelGestionRecepciones;
    private final PresenterGestionRecepciones presenterGestionRecepciones;
    
    public GestionRecepciones() {

        presenterGestionRecepciones = new PresenterGestionRecepciones();
        presenterGestionRecepciones.setCallBackObtenerRecepciones(this);
        presenterGestionRecepciones.setCallBackEliminarRecepcion(this);

        tableModelGestionRecepciones = new TableModelGestionRecepciones();

        initComponents();

        JTXTFYear.addActionListener(action);
        JBTNOk.addActionListener(action);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemRecepcion = new javax.swing.JPopupMenu();
        JMENUITEMModificarPaciente = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        JMENUITEMModificarRecepcion = new javax.swing.JMenuItem();
        JMENUITEMDetallesRecepcion = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        JMENUITEMEliminarRecepcion = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        JTXTFBuscarRecepcion = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLRecepciones = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        JBTNActualizar = new javax.swing.JButton();
        JBTNNuevaRecepcion = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        JCMBXBuscarPor = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        JCMBXMes = new javax.swing.JComboBox<>();
        JTXTFYear = new javax.swing.JTextField();
        JBTNOk = new javax.swing.JButton();

        JMENUITEMModificarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/modificar_informacion.png"))); // NOI18N
        JMENUITEMModificarPaciente.setText("Modificar Paciente");
        JMENUITEMModificarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMModificarPacienteActionPerformed(evt);
            }
        });
        JPOPUPMENUItemRecepcion.add(JMENUITEMModificarPaciente);
        JPOPUPMENUItemRecepcion.add(jSeparator1);

        JMENUITEMModificarRecepcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/modificar_password.png"))); // NOI18N
        JMENUITEMModificarRecepcion.setText("Modificar Recepcion");
        JMENUITEMModificarRecepcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMModificarRecepcionActionPerformed(evt);
            }
        });
        JPOPUPMENUItemRecepcion.add(JMENUITEMModificarRecepcion);

        JMENUITEMDetallesRecepcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_detalles_recepcion.png"))); // NOI18N
        JMENUITEMDetallesRecepcion.setText("Ver Detalles de Recepción");
        JMENUITEMDetallesRecepcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMDetallesRecepcionActionPerformed(evt);
            }
        });
        JPOPUPMENUItemRecepcion.add(JMENUITEMDetallesRecepcion);
        JPOPUPMENUItemRecepcion.add(jSeparator2);

        JMENUITEMEliminarRecepcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/eliminar.png"))); // NOI18N
        JMENUITEMEliminarRecepcion.setText("Eliminar Recepción");
        JMENUITEMEliminarRecepcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMEliminarRecepcionActionPerformed(evt);
            }
        });
        JPOPUPMENUItemRecepcion.add(JMENUITEMEliminarRecepcion);

        setTitle("Gestión de Recepciones");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_recepciones.png"))); // NOI18N
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Recepción"));

        JTXTFBuscarRecepcion.setEnabled(false);
        JTXTFBuscarRecepcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFBuscarRecepcionFocusGained(evt);
            }
        });
        JTXTFBuscarRecepcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFBuscarRecepcionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFBuscarRecepcionKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTXTFBuscarRecepcion)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTXTFBuscarRecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Recepciones"));

        JTBLRecepciones.setModel(tableModelGestionRecepciones);
        JTBLRecepciones.setComponentPopupMenu(JPOPUPMENUItemRecepcion);
        JTBLRecepciones.setRowHeight(20);
        JTBLRecepciones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTBLRecepciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLRecepcionesMousePressed(evt);
            }
        });
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLRecepciones.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
        JTBLRecepciones.getColumnModel().getColumn(1).setCellRenderer(defaultTableCellRenderer);
        JTBLRecepciones.getColumnModel().getColumn(2).setCellRenderer(defaultTableCellRenderer);
        JTBLRecepciones.getColumnModel().getColumn(5).setCellRenderer(defaultTableCellRenderer);
        JTBLRecepciones.getColumnModel().getColumn(6).setCellRenderer(defaultTableCellRenderer);
        JTBLRecepciones.getColumnModel().getColumn(7).setCellRenderer(defaultTableCellRenderer);
        JTBLRecepciones.getColumnModel().getColumn(8).setCellRenderer(defaultTableCellRenderer);
        JTBLRecepciones.getColumnModel().getColumn(9).setCellRenderer(defaultTableCellRenderer);
        JTBLRecepciones.getColumnModel().getColumn(10).setCellRenderer(defaultTableCellRenderer);

        JTBLRecepciones.getColumnModel().getColumn(0).setPreferredWidth(20);
        JTBLRecepciones.getColumnModel().getColumn(1).setPreferredWidth(80);
        JTBLRecepciones.getColumnModel().getColumn(2).setPreferredWidth(80);
        JTBLRecepciones.getColumnModel().getColumn(3).setPreferredWidth(200);
        JTBLRecepciones.getColumnModel().getColumn(4).setPreferredWidth(200);
        JTBLRecepciones.getColumnModel().getColumn(5).setPreferredWidth(40);
        JTBLRecepciones.getColumnModel().getColumn(6).setPreferredWidth(20);
        JTBLRecepciones.getColumnModel().getColumn(7).setPreferredWidth(100);
        JTBLRecepciones.getColumnModel().getColumn(8).setPreferredWidth(100);
        JTBLRecepciones.getColumnModel().getColumn(9).setPreferredWidth(120);
        JTBLRecepciones.getColumnModel().getColumn(10).setPreferredWidth(120);
        jScrollPane1.setViewportView(JTBLRecepciones);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                .addContainerGap())
        );

        JBTNActualizar.setText("ACTUALIZAR");
        JBTNActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNActualizarActionPerformed(evt);
            }
        });

        JBTNNuevaRecepcion.setText("NUEVA RECEPCION");
        JBTNNuevaRecepcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNNuevaRecepcionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JBTNActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBTNNuevaRecepcion)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNActualizar)
                    .addComponent(JBTNNuevaRecepcion))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar por"));

        JCMBXBuscarPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CEDULA DE IDENTIDAD", "APELLIDO", "NOMBRE", "CODIGO REGISTRO LABORATORIO" }));
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
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JCMBXBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JCMBXBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Obtener Recepciones de"));

        JCMBXMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));
        JCMBXMes.setSelectedIndex(-1);

        JTXTFYear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFYearKeyTyped(evt);
            }
        });
        JTXTFYear.setTransferHandler(null);

        JBTNOk.setText("OK");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JCMBXMes, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFYear, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBTNOk)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCMBXMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTXTFYear, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBTNOk))
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBTNNuevaRecepcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNNuevaRecepcionActionPerformed
        final BuscarPaciente buscarPaciente = new BuscarPaciente(null, true);
        buscarPaciente.setVisible(true);

        if (!buscarPaciente.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JBTNNuevaRecepcionActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        final LocalDate localDate = LocalDate.now();
        final int month = localDate.getMonthValue();
        final int year = localDate.getYear();
        JCMBXMes.setSelectedIndex(month - 1);
        JTXTFYear.setText(String.valueOf(year));

        presenterGestionRecepciones.obtenerRecepciones(month, year);
    }//GEN-LAST:event_formInternalFrameActivated

    private void JTBLRecepcionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLRecepcionesMousePressed
        final int currentRow = JTBLRecepciones.rowAtPoint(evt.getPoint());
        JTBLRecepciones.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLRecepcionesMousePressed

    private void JTXTFBuscarRecepcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFBuscarRecepcionKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9-. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFBuscarRecepcion.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFBuscarRecepcionKeyTyped

    private void JTXTFBuscarRecepcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFBuscarRecepcionKeyReleased
        final String search = JTXTFBuscarRecepcion.getText().toUpperCase();
        final TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) JTBLRecepciones.getRowSorter();

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

            case 3:
                sorter.setRowFilter(RowFilter.regexFilter(search, 1));
                break;

            default:
                sorter.setRowFilter(RowFilter.regexFilter(search, 2));
                break;
        }
    }//GEN-LAST:event_JTXTFBuscarRecepcionKeyReleased

    private void JMENUITEMDetallesRecepcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMDetallesRecepcionActionPerformed
        final VerDetallesRecepcion verDetallesRecepcion = new VerDetallesRecepcion(null, true);
        verDetallesRecepcion.setRecepcion(obtenerRecepcionPersonalizada().getRecepcion());
        verDetallesRecepcion.setHabilitarModificacion(true);
        verDetallesRecepcion.setVisible(true);

        if (!verDetallesRecepcion.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMDetallesRecepcionActionPerformed

    private void JMENUITEMModificarRecepcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMModificarRecepcionActionPerformed
        final RecepcionPersonalizada recepcionPersonalizada = obtenerRecepcionPersonalizada();

        if (recepcionPersonalizada.getTotalExamenesPendientes() == 0) {
            JOptionPane.showMessageDialog(rootPane, "No se puede modificar la recepción. El/los resultado(s) ya fueron ingresados.", "SIET", JOptionPane.ERROR_MESSAGE);
        } else {
            final ModificarRecepcion modificarRecepcion = new ModificarRecepcion(null, true);
            modificarRecepcion.setRecepcion(obtenerRecepcionPersonalizada().getRecepcion());
            modificarRecepcion.setVisible(true);

            if (!modificarRecepcion.isVisible()) {
                actualizarTabla();
            }
        }
    }//GEN-LAST:event_JMENUITEMModificarRecepcionActionPerformed

    private void JBTNActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_JBTNActualizarActionPerformed

    private void JMENUITEMModificarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMModificarPacienteActionPerformed
        final ModificarPaciente modificarPaciente = new ModificarPaciente(null, true);
        modificarPaciente.setPaciente(obtenerRecepcionPersonalizada().getRecepcion().getPaciente());
        modificarPaciente.setVisible(true);

        if (!modificarPaciente.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMModificarPacienteActionPerformed

    private void JCMBXBuscarPorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCMBXBuscarPorItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            JTXTFBuscarRecepcion.requestFocus();
        }
    }//GEN-LAST:event_JCMBXBuscarPorItemStateChanged

    private void JTXTFYearKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFYearKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([0-9]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFYear.getText().length() >= 4) {
            evt.consume();
        } else {
            evt.setKeyChar(evt.getKeyChar());
        }
    }//GEN-LAST:event_JTXTFYearKeyTyped

    private void JTXTFBuscarRecepcionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFBuscarRecepcionFocusGained
        JTXTFBuscarRecepcion.selectAll();
    }//GEN-LAST:event_JTXTFBuscarRecepcionFocusGained

    private void JMENUITEMEliminarRecepcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMEliminarRecepcionActionPerformed
        final Recepcion recepcion = obtenerRecepcionPersonalizada().getRecepcion();
        
        int opcionSeleccionada = JOptionPane.showConfirmDialog(this, "¿Eliminar la recepción del paciente?\n\n"
                + "La recepción será eliminada del historial clínico del paciente\ny no se realizará le conteo de la recepción eliminada en el informe mensual.\n\n¿Eliminar?\n\n", "SIET", JOptionPane.YES_NO_OPTION);

        if (opcionSeleccionada == 0) {
            presenterGestionRecepciones.eliminarRecepcion(recepcion);
        }
    }//GEN-LAST:event_JMENUITEMEliminarRecepcionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBTNActualizar;
    private javax.swing.JButton JBTNNuevaRecepcion;
    private javax.swing.JButton JBTNOk;
    private javax.swing.JComboBox<String> JCMBXBuscarPor;
    private javax.swing.JComboBox<String> JCMBXMes;
    private javax.swing.JMenuItem JMENUITEMDetallesRecepcion;
    private javax.swing.JMenuItem JMENUITEMEliminarRecepcion;
    private javax.swing.JMenuItem JMENUITEMModificarPaciente;
    private javax.swing.JMenuItem JMENUITEMModificarRecepcion;
    private javax.swing.JPopupMenu JPOPUPMENUItemRecepcion;
    private javax.swing.JTable JTBLRecepciones;
    private javax.swing.JTextField JTXTFBuscarRecepcion;
    private javax.swing.JTextField JTXTFYear;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    // End of variables declaration//GEN-END:variables

    private final Action action = new AbstractAction() {
        @Override
        public void actionPerformed(final ActionEvent e) {
            tableModelGestionRecepciones.limpiarLista();
            presenterGestionRecepciones.obtenerRecepciones(JCMBXMes.getSelectedIndex() + 1, Integer.valueOf(JTXTFYear.getText()));
        }
    };

    private void actualizarTabla() {
        tableModelGestionRecepciones.limpiarLista();
        presenterGestionRecepciones.obtenerRecepciones(JCMBXMes.getSelectedIndex() + 1, Integer.valueOf(JTXTFYear.getText()));
    }

    private RecepcionPersonalizada obtenerRecepcionPersonalizada() {
        final int rowModel = JTBLRecepciones.convertRowIndexToModel(JTBLRecepciones.getSelectedRow());
        return tableModelGestionRecepciones.getRecepcionPersonalizada(rowModel);
    }

    @Override
    public void recepcionesObtenidas(final List<RecepcionPersonalizada> recepcionesPersonalizadas) {
        tableModelGestionRecepciones.setRecepcionesPersonalizadas(recepcionesPersonalizadas);
        JTBLRecepciones.setRowSorter(new TableRowSorter<>(tableModelGestionRecepciones));
        JTBLRecepciones.getTableHeader().setReorderingAllowed(false);

        JTXTFBuscarRecepcion.setEnabled(true);
        JCMBXBuscarPor.setEnabled(true);
    }

    @Override
    public void listaRecepcionesVacia(final String msg) {
        JTXTFBuscarRecepcion.setEnabled(false);
        JCMBXBuscarPor.setEnabled(false);
    }

    @Override
    public void errorObtenerRecepciones(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerRecepciones(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void recepcionEliminada(final String msg) {
        actualizarTabla();
    }

    @Override
    public void errorEliminarRecepcion(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoEliminarRecepcion(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}