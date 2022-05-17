package View.GestionRecepciones;

import Model.POJO.Cuenta;
import Model.POJO.ExamenSolicitado;
import Model.POJOPersonalizado.ResultadoGeneralPersonalizado;
import Presenter.GestionRecepciones.PresenterGestionExamenesSolicitados;
import Presenter.GestionRecepciones.PresenterGestionResultadoGeneral;
import View.Utilitarios.Utilidades;
import View.Utilitarios.ModelTable.GestionRecepciones.TableModelResultadosIngresados;
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
public class VerResultadosIngresados extends javax.swing.JDialog implements PresenterGestionExamenesSolicitados.CallBackObtenerResultadosGenerales, PresenterGestionResultadoGeneral.CallBackVerificarPermitirModificacion {

    private final TableModelResultadosIngresados tableModelResultadosIngresados;
    private final PresenterGestionExamenesSolicitados presenterGestionExamenesSolicitados;
    private final PresenterGestionResultadoGeneral presenterGestionResultadoGeneral;
    private final Cuenta cuenta;
    private boolean habilitarModificacion;
    private ExamenSolicitado examenSolicitado;

    public VerResultadosIngresados(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        tableModelResultadosIngresados = new TableModelResultadosIngresados();
        presenterGestionExamenesSolicitados = new PresenterGestionExamenesSolicitados();
        presenterGestionResultadoGeneral = new PresenterGestionResultadoGeneral();
        presenterGestionExamenesSolicitados.setCallBackObtenerResultadosGenerales(this);
        presenterGestionResultadoGeneral.setCallBackVerificarPermitirModificacion(this);

        cuenta = Utilidades.obtenerCuentaLocal();
        
        habilitarModificacion = false;

        initComponents();
    }

    public void setHabilitarModificacion(boolean habilitarModificacion) {
        this.habilitarModificacion = habilitarModificacion;
    }

    public void setExamenSolicitado(ExamenSolicitado examenSolicitado) {
        this.examenSolicitado = examenSolicitado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemResultadosIngresados = new javax.swing.JPopupMenu();
        JMENUITEMModificarResultados = new javax.swing.JMenuItem();
        JMENUITEMVerResultados = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JLBLExamenNombre = new javax.swing.JLabel();
        JLBLMuestraBiologica = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JLBLTotalMuestrasRecibidos = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JLBLEstadoMuestraBiologica = new javax.swing.JLabel();
        JBTNCerrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLResultadosIngresados = new javax.swing.JTable();
        JBTNActualizar = new javax.swing.JButton();

        JMENUITEMModificarResultados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/modificar_password.png"))); // NOI18N
        JMENUITEMModificarResultados.setText("Modificar Resultados");
        JMENUITEMModificarResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMModificarResultadosActionPerformed(evt);
            }
        });
        JPOPUPMENUItemResultadosIngresados.add(JMENUITEMModificarResultados);

        JMENUITEMVerResultados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_informacion.png"))); // NOI18N
        JMENUITEMVerResultados.setText("Ver Resultados");
        JMENUITEMVerResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerResultadosActionPerformed(evt);
            }
        });
        JPOPUPMENUItemResultadosIngresados.add(JMENUITEMVerResultados);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Resultados Ingresados");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Muestra Biológica"));

        jLabel1.setText("EXAMEN SOLICITADO:");

        jLabel2.setText("MUESTRA BIOLOGICA:");

        JLBLExamenNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLMuestraBiologica.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("TOTAL MUESTRAS RECIBIDAS:");

        JLBLTotalMuestrasRecibidos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setText("ESTADO DE LA MUESTRA:");

        JLBLEstadoMuestraBiologica.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(JLBLExamenNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLBLMuestraBiologica, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLBLTotalMuestrasRecibidos, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(JLBLEstadoMuestraBiologica, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLBLExamenNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLBLMuestraBiologica, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLBLTotalMuestrasRecibidos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLBLEstadoMuestraBiologica, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JBTNCerrar.setText("CERRAR");
        JBTNCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCerrarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados Ingresados"));

        JTBLResultadosIngresados.setModel(tableModelResultadosIngresados);
        JTBLResultadosIngresados.setComponentPopupMenu(JPOPUPMENUItemResultadosIngresados);
        JTBLResultadosIngresados.setRowHeight(20);
        JTBLResultadosIngresados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTBLResultadosIngresados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLResultadosIngresadosMousePressed(evt);
            }
        });
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLResultadosIngresados.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
        JTBLResultadosIngresados.getColumnModel().getColumn(3).setCellRenderer(defaultTableCellRenderer);

        JTBLResultadosIngresados.getColumnModel().getColumn(0).setPreferredWidth(40);
        JTBLResultadosIngresados.getColumnModel().getColumn(1).setPreferredWidth(250);
        JTBLResultadosIngresados.getColumnModel().getColumn(2).setPreferredWidth(250);
        JTBLResultadosIngresados.getColumnModel().getColumn(3).setPreferredWidth(150);
        jScrollPane1.setViewportView(JTBLResultadosIngresados);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JBTNActualizar.setText("ACTUALIZAR");
        JBTNActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNActualizarActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JBTNCerrar)
                                .addGap(18, 18, 18)
                                .addComponent(JBTNActualizar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                    .addComponent(JBTNActualizar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            if (examenSolicitado == null || cuenta == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                if (!habilitarModificacion) {
                    JMENUITEMModificarResultados.setEnabled(false);
                    JMENUITEMModificarResultados.setVisible(false);
                }
                
                JLBLExamenNombre.setText(examenSolicitado.getExamen().getExamenNombre());
                JLBLTotalMuestrasRecibidos.setText(String.valueOf(examenSolicitado.getTotalMuestrasBiologicas()));
                JLBLMuestraBiologica.setText(examenSolicitado.getMuestraBiologica().getMuestraBiologicaTipo());
                JLBLEstadoMuestraBiologica.setText(examenSolicitado.getMuestraBiologicaEstado());
                presenterGestionExamenesSolicitados.obtenerResultadosGenerales(examenSolicitado);
            }
        } catch (final HeadlessException ex) {
            System.err.println("Se produjo un error: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTBLResultadosIngresadosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLResultadosIngresadosMousePressed
        final int currentRow = JTBLResultadosIngresados.rowAtPoint(evt.getPoint());
        JTBLResultadosIngresados.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLResultadosIngresadosMousePressed

    private void JMENUITEMModificarResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMModificarResultadosActionPerformed
        presenterGestionResultadoGeneral.verificarPermitirModificacion(obtenerResultadoGeneralPersonalizadoSeleccionado());
    }//GEN-LAST:event_JMENUITEMModificarResultadosActionPerformed

    private void JMENUITEMVerResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerResultadosActionPerformed
        final VerDetallesResultadosIngresados verDetallesResultadosIngresados = new VerDetallesResultadosIngresados(null, true);
        verDetallesResultadosIngresados.setResultadoGeneralPersonalizado(obtenerResultadoGeneralPersonalizadoSeleccionado());
        verDetallesResultadosIngresados.setVisible(true);

        if (!verDetallesResultadosIngresados.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMVerResultadosActionPerformed

    private void JBTNCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCerrarActionPerformed

    private void JBTNActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_JBTNActualizarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            VerResultadosIngresados dialog = new VerResultadosIngresados(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel JLBLEstadoMuestraBiologica;
    private javax.swing.JLabel JLBLExamenNombre;
    private javax.swing.JLabel JLBLMuestraBiologica;
    private javax.swing.JLabel JLBLTotalMuestrasRecibidos;
    private javax.swing.JMenuItem JMENUITEMModificarResultados;
    private javax.swing.JMenuItem JMENUITEMVerResultados;
    private javax.swing.JPopupMenu JPOPUPMENUItemResultadosIngresados;
    private javax.swing.JTable JTBLResultadosIngresados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private ResultadoGeneralPersonalizado obtenerResultadoGeneralPersonalizadoSeleccionado() {
        final int rowModel = JTBLResultadosIngresados.convertRowIndexToModel(JTBLResultadosIngresados.getSelectedRow());
        return tableModelResultadosIngresados.getResultadoGeneralPersonalizado(rowModel);
    }

    private void actualizarTabla() {
        tableModelResultadosIngresados.limpiarLista();
        presenterGestionExamenesSolicitados.obtenerResultadosGenerales(examenSolicitado);
    }

    @Override
    public void resultadosGeneralesObtenidos(final List<ResultadoGeneralPersonalizado> resultadoGeneralesPersonalizados) {
        tableModelResultadosIngresados.setResultadosGeneralesPersonalizados(resultadoGeneralesPersonalizados);
        JTBLResultadosIngresados.getTableHeader().setReorderingAllowed(false);
    }

    @Override
    public void listaResultadosGeneralesVacia(final String msg) {
    }

    @Override
    public void errorObtenerResultadosGenerales(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerResultadosGenerales(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void permisoConcedido() {
        final ResultadoGeneralPersonalizado resultadoGeneralPersonalizado = obtenerResultadoGeneralPersonalizadoSeleccionado();

        if (cuenta.getCuentaRol().equals("ADMIN") || resultadoGeneralPersonalizado.getResultadoGeneral().getPersonalTecnicoResultados().getCodigoPersonalTecnico() == cuenta.getPersonalTecnico().getCodigoPersonalTecnico()) {
            final ModificarResultados modificarResultados = new ModificarResultados(null, true);
            modificarResultados.setResultadoGeneralPersonalizado(resultadoGeneralPersonalizado);
            modificarResultados.setVisible(true);

            if (!modificarResultados.isVisible()) {
                actualizarTabla();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Solo el que ingreso los resultados y/o el administrador pueden modificar los resultados.", "SIET", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void permisoNegado(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorVerificarPermitirModificacion(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoVerificarPermitirModificacion(String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}