package View.GestionReactivos;

import Model.POJO.ReactivoEntrega;
import Model.POJO.ReactivoLote;
import Presenter.GestionReactivos.PresenterGestionReactivosEntregas;
import View.Utilitarios.ModelTable.GestionReactivos.TableModelReactivosLotes;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
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
public class VerDetallesEntrega extends javax.swing.JDialog implements PresenterGestionReactivosEntregas.CallBackObtenerLotes {

    private final TableModelReactivosLotes tableModelReactivosLotes;
    private final PresenterGestionReactivosEntregas presenterGestionReactivosEntregas;
    
    private ReactivoEntrega reactivoEntrega;

    public VerDetallesEntrega(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        presenterGestionReactivosEntregas = new PresenterGestionReactivosEntregas();
        presenterGestionReactivosEntregas.setCallBackObtenerLotes(this);

        tableModelReactivosLotes = new TableModelReactivosLotes();

        initComponents();
    }

    public void setReactivoEntrega(ReactivoEntrega reactivoEntrega) {
        this.reactivoEntrega = reactivoEntrega;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemReactivoLote = new javax.swing.JPopupMenu();
        JMENUITEMVerDetallesLote = new javax.swing.JMenuItem();
        jPanel4 = new javax.swing.JPanel();
        JBTNActualizar = new javax.swing.JButton();
        JBTNRegistrarLote = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        JTXTFBuscarLote = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        JCMBXBuscarPor = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLReactivoLotes = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JLBLBioquimico = new javax.swing.JLabel();
        JLBLProveedor = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JLBLFechaEntrega = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JLBLHoraEntrega = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTXTAREAObervaciones = new javax.swing.JTextArea();

        JMENUITEMVerDetallesLote.setText("Ver Detalles del Lote");
        JMENUITEMVerDetallesLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerDetallesLoteActionPerformed(evt);
            }
        });
        JPOPUPMENUItemReactivoLote.add(JMENUITEMVerDetallesLote);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Detalles de la Entrega");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        JBTNActualizar.setText("ACTUALIZAR");
        JBTNActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNActualizarActionPerformed(evt);
            }
        });

        JBTNRegistrarLote.setText("REGISTRAR LOTE");
        JBTNRegistrarLote.setToolTipText("");
        JBTNRegistrarLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNRegistrarLoteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JBTNActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBTNRegistrarLote)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNActualizar)
                    .addComponent(JBTNRegistrarLote))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Lote"));

        JTXTFBuscarLote.setEnabled(false);
        JTXTFBuscarLote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFBuscarLoteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFBuscarLoteKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTXTFBuscarLote)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTXTFBuscarLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar por"));

        JCMBXBuscarPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LOTE" }));
        JCMBXBuscarPor.setEnabled(false);
        JCMBXBuscarPor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCMBXBuscarPorItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JCMBXBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JCMBXBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lotes"));

        JTBLReactivoLotes.setModel(tableModelReactivosLotes);
        JTBLReactivoLotes.setComponentPopupMenu(JPOPUPMENUItemReactivoLote);
        JTBLReactivoLotes.setRowHeight(20);
        JTBLReactivoLotes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTBLReactivoLotes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLReactivoLotesMousePressed(evt);
            }
        });
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLReactivoLotes.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
        JTBLReactivoLotes.getColumnModel().getColumn(1).setCellRenderer(defaultTableCellRenderer);
        JTBLReactivoLotes.getColumnModel().getColumn(3).setCellRenderer(defaultTableCellRenderer);
        JTBLReactivoLotes.getColumnModel().getColumn(4).setCellRenderer(defaultTableCellRenderer);
        JTBLReactivoLotes.getColumnModel().getColumn(5).setCellRenderer(defaultTableCellRenderer);
        JTBLReactivoLotes.getColumnModel().getColumn(6).setCellRenderer(defaultTableCellRenderer);
        JTBLReactivoLotes.getColumnModel().getColumn(7).setCellRenderer(defaultTableCellRenderer);

        JTBLReactivoLotes.getColumnModel().getColumn(0).setPreferredWidth(10);
        JTBLReactivoLotes.getColumnModel().getColumn(1).setPreferredWidth(60);
        JTBLReactivoLotes.getColumnModel().getColumn(2).setPreferredWidth(100);
        JTBLReactivoLotes.getColumnModel().getColumn(3).setPreferredWidth(100);
        JTBLReactivoLotes.getColumnModel().getColumn(4).setPreferredWidth(60);
        JTBLReactivoLotes.getColumnModel().getColumn(5).setPreferredWidth(100);
        JTBLReactivoLotes.getColumnModel().getColumn(6).setPreferredWidth(100);
        JTBLReactivoLotes.getColumnModel().getColumn(7).setPreferredWidth(80);
        JTBLReactivoLotes.getColumnModel().getColumn(8).setPreferredWidth(100);
        jScrollPane1.setViewportView(JTBLReactivoLotes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1023, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Lotes", jPanel7);

        jLabel1.setText("ENTREGADO A:");

        jLabel2.setText("RECIBIDO DE:");

        JLBLBioquimico.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLProveedor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("FECHA DE ENTREGA:");

        JLBLFechaEntrega.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("HORA DE ENTREGA:");

        JLBLHoraEntrega.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("OBSERVACIONES:");

        JTXTAREAObervaciones.setColumns(20);
        JTXTAREAObervaciones.setLineWrap(true);
        JTXTAREAObervaciones.setRows(5);
        JTXTAREAObervaciones.setEditable(false);
        jScrollPane2.setViewportView(JTXTAREAObervaciones);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JLBLFechaEntrega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                            .addComponent(JLBLBioquimico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLBLHoraEntrega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                            .addComponent(JLBLProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLBLBioquimico, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLBLProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLBLFechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLBLHoraEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Detalles de Entrega", jPanel8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            if (reactivoEntrega == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                JLBLBioquimico.setText(reactivoEntrega.getPersonalTecnico().getPersona().getPersonaApellido() + " " + reactivoEntrega.getPersonalTecnico().getPersona().getPersonaNombre());
                JLBLProveedor.setText(reactivoEntrega.getProveedor());
                JLBLFechaEntrega.setText(reactivoEntrega.getFechaEntrega().toString());
                JLBLHoraEntrega.setText(reactivoEntrega.getHoraEntrega().toString());
                JTXTAREAObervaciones.setText(reactivoEntrega.getObservaciones());

                presenterGestionReactivosEntregas.obtenerLotes(reactivoEntrega);
            }
        } catch (final HeadlessException headlessException) {
            System.err.println("Se produjo un error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTBLReactivoLotesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLReactivoLotesMousePressed
        final int currentRow = JTBLReactivoLotes.rowAtPoint(evt.getPoint());
        JTBLReactivoLotes.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLReactivoLotesMousePressed

    private void JBTNActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_JBTNActualizarActionPerformed

    private void JBTNRegistrarLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNRegistrarLoteActionPerformed
        final RegistrarLote registrarLote = new RegistrarLote(null, true);
        registrarLote.setReactivoEntrega(reactivoEntrega);
        registrarLote.setVisible(true);

        if (!registrarLote.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JBTNRegistrarLoteActionPerformed

    private void JTXTFBuscarLoteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFBuscarLoteKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFBuscarLote.getText().length() >= 10) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFBuscarLoteKeyTyped

    private void JCMBXBuscarPorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCMBXBuscarPorItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            JTXTFBuscarLote.requestFocus();
        }
    }//GEN-LAST:event_JCMBXBuscarPorItemStateChanged

    private void JTXTFBuscarLoteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFBuscarLoteKeyReleased
        final String search = JTXTFBuscarLote.getText();
        final TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) JTBLReactivoLotes.getRowSorter();

        final int selectedIndex = JCMBXBuscarPor.getSelectedIndex();

        switch (selectedIndex) {
            case 0:
                sorter.setRowFilter(RowFilter.regexFilter(search, 1));
                break;

            default:
                sorter.setRowFilter(RowFilter.regexFilter(search, 1));
                break;
        }
    }//GEN-LAST:event_JTXTFBuscarLoteKeyReleased

    private void JMENUITEMVerDetallesLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerDetallesLoteActionPerformed
        final VerDetallesLote verDetallesLote = new VerDetallesLote(null, true);
        verDetallesLote.setReactivoLote(obtenerReactivoLoteSeleccionado());
        verDetallesLote.setVisible(true);
    }//GEN-LAST:event_JMENUITEMVerDetallesLoteActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            VerDetallesEntrega dialog = new VerDetallesEntrega(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNRegistrarLote;
    private javax.swing.JComboBox<String> JCMBXBuscarPor;
    private javax.swing.JLabel JLBLBioquimico;
    private javax.swing.JLabel JLBLFechaEntrega;
    private javax.swing.JLabel JLBLHoraEntrega;
    private javax.swing.JLabel JLBLProveedor;
    private javax.swing.JMenuItem JMENUITEMVerDetallesLote;
    private javax.swing.JPopupMenu JPOPUPMENUItemReactivoLote;
    private javax.swing.JTable JTBLReactivoLotes;
    private javax.swing.JTextArea JTXTAREAObervaciones;
    private javax.swing.JTextField JTXTFBuscarLote;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

    private void actualizarTabla() {
        tableModelReactivosLotes.limpiarLista();
        presenterGestionReactivosEntregas.obtenerLotes(reactivoEntrega);
    }

    private ReactivoLote obtenerReactivoLoteSeleccionado() {
        final int rowModel = JTBLReactivoLotes.convertRowIndexToModel(JTBLReactivoLotes.getSelectedRow());
        return tableModelReactivosLotes.getReactivoLote(rowModel);
    }

    @Override
    public void lotesObtenidos(final List<ReactivoLote> reactivosLotes) {
        tableModelReactivosLotes.setReactivosLotes(reactivosLotes);
        JTBLReactivoLotes.setRowSorter(new TableRowSorter<>(tableModelReactivosLotes));
        JTBLReactivoLotes.getTableHeader().setReorderingAllowed(false);

        JTXTFBuscarLote.setEnabled(true);
        JCMBXBuscarPor.setEnabled(true);
    }

    @Override
    public void listaLotesVacia(final String msg) {
        JTXTFBuscarLote.setEnabled(false);
        JCMBXBuscarPor.setEnabled(false);
    }

    @Override
    public void errorObtenerLotes(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerLotes(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}