package View.GestionExamenes;

import Model.POJO.Examen;
import Model.POJO.ExamenPosibleResultado;
import Presenter.GestionExamenes.PresenterGestionExamenes;
import Presenter.GestionExamenes.PresenterGestionPosiblesResultados;
import View.Utilitarios.ModelTable.GestionExamenes.TableModelVerPosiblesResultados;
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
public class VerPosiblesResultados extends javax.swing.JDialog implements PresenterGestionExamenes.CallBackObtenerPosiblesResultados, PresenterGestionPosiblesResultados.CallBackEliminarPosibleResultado {
    
    private final TableModelVerPosiblesResultados tableModelVerPosiblesResultados;
    private final PresenterGestionExamenes presenterGestionExamenes;
    private final PresenterGestionPosiblesResultados presenterGestionPosiblesResultados;
    private Examen examen;
    
    public VerPosiblesResultados(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        tableModelVerPosiblesResultados = new TableModelVerPosiblesResultados();
        presenterGestionExamenes = new PresenterGestionExamenes();
        presenterGestionPosiblesResultados = new PresenterGestionPosiblesResultados();
        presenterGestionExamenes.setCallBackObtenerPosiblesResultados(this);
        presenterGestionPosiblesResultados.setCallBackEliminarPosibleResultado(this);
        
        initComponents();
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemPosibleResultado = new javax.swing.JPopupMenu();
        JMENUITEMModifcarPosibleResultado = new javax.swing.JMenuItem();
        JMENUITEMElimnarPosibleResultado = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JLBLExamenNombre = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLPosiblesResultados = new javax.swing.JTable();
        JBTNCerrar = new javax.swing.JButton();
        JBTNAgregarPosibleResultado = new javax.swing.JButton();
        JBTNActualizar = new javax.swing.JButton();

        JMENUITEMModifcarPosibleResultado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/modificar_password.png"))); // NOI18N
        JMENUITEMModifcarPosibleResultado.setText("Modificar");
        JMENUITEMModifcarPosibleResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMModifcarPosibleResultadoActionPerformed(evt);
            }
        });
        JPOPUPMENUItemPosibleResultado.add(JMENUITEMModifcarPosibleResultado);

        JMENUITEMElimnarPosibleResultado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/eliminar.png"))); // NOI18N
        JMENUITEMElimnarPosibleResultado.setText("Eliminar");
        JMENUITEMElimnarPosibleResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMElimnarPosibleResultadoActionPerformed(evt);
            }
        });
        JPOPUPMENUItemPosibleResultado.add(JMENUITEMElimnarPosibleResultado);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Ver Posibles Resultados");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Examen"));

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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLExamenNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Posibles Resultados del Examen"));

        JTBLPosiblesResultados.setModel(tableModelVerPosiblesResultados);
        JTBLPosiblesResultados.setComponentPopupMenu(JPOPUPMENUItemPosibleResultado);
        JTBLPosiblesResultados.setRowHeight(20);
        JTBLPosiblesResultados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLPosiblesResultados.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
        JTBLPosiblesResultados.getColumnModel().getColumn(1).setCellRenderer(defaultTableCellRenderer);

        JTBLPosiblesResultados.getColumnModel().getColumn(0).setPreferredWidth(20);
        JTBLPosiblesResultados.getColumnModel().getColumn(1).setPreferredWidth(40);
        JTBLPosiblesResultados.getColumnModel().getColumn(2).setPreferredWidth(400);
        JTBLPosiblesResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLPosiblesResultadosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(JTBLPosiblesResultados);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JBTNCerrar.setText("CERRAR");
        JBTNCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCerrarActionPerformed(evt);
            }
        });

        JBTNAgregarPosibleResultado.setText("AGREGAR POSIBLE RESULTADO");
        JBTNAgregarPosibleResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNAgregarPosibleResultadoActionPerformed(evt);
            }
        });

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
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBTNCerrar)
                        .addGap(18, 18, 18)
                        .addComponent(JBTNActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBTNAgregarPosibleResultado)))
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
                    .addComponent(JBTNAgregarPosibleResultado)
                    .addComponent(JBTNActualizar))
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
                presenterGestionExamenes.obtenerPosiblesResultados(examen);
            }
        } catch (final HeadlessException headlessException) {
            System.err.println("Error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTBLPosiblesResultadosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLPosiblesResultadosMousePressed
        final int currentRow = JTBLPosiblesResultados.rowAtPoint(evt.getPoint());
        JTBLPosiblesResultados.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLPosiblesResultadosMousePressed

    private void JMENUITEMModifcarPosibleResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMModifcarPosibleResultadoActionPerformed
        final ModificarPosibleResultado modificarPosibleResultado = new ModificarPosibleResultado(null, true);
        modificarPosibleResultado.setExamenPosibleResultado(obtenerPosibleResultadoSeleccionado());
        modificarPosibleResultado.setVisible(true);
        
        if (!modificarPosibleResultado.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMModifcarPosibleResultadoActionPerformed

    private void JMENUITEMElimnarPosibleResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMElimnarPosibleResultadoActionPerformed
        final ExamenPosibleResultado examenPosibleResultado = obtenerPosibleResultadoSeleccionado();
        
        int opcionSeleccionada = JOptionPane.showConfirmDialog(this, "¿Eliminar posible resultado del examen?\n\nDatos:\n"
                + "\n\nPOSIBLE RESULTADO: " + examenPosibleResultado.getPosibleResultadoNombre() + "\n\n¿Eliminar?\n\n", "SIET", JOptionPane.YES_NO_OPTION);

        if (opcionSeleccionada == 0) {
            presenterGestionPosiblesResultados.eliminarPosibleResultado(examenPosibleResultado);
        }
    }//GEN-LAST:event_JMENUITEMElimnarPosibleResultadoActionPerformed

    private void JBTNCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCerrarActionPerformed

    private void JBTNAgregarPosibleResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNAgregarPosibleResultadoActionPerformed
        final AgregarPosiblesResultados agregarPosiblesResultados = new AgregarPosiblesResultados(null, true);
        agregarPosiblesResultados.setExamen(examen);
        agregarPosiblesResultados.setVisible(true);
        
        if (!agregarPosiblesResultados.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JBTNAgregarPosibleResultadoActionPerformed

    private void JBTNActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_JBTNActualizarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            VerPosiblesResultados dialog = new VerPosiblesResultados(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNAgregarPosibleResultado;
    private javax.swing.JButton JBTNCerrar;
    private javax.swing.JLabel JLBLExamenNombre;
    private javax.swing.JMenuItem JMENUITEMElimnarPosibleResultado;
    private javax.swing.JMenuItem JMENUITEMModifcarPosibleResultado;
    private javax.swing.JPopupMenu JPOPUPMENUItemPosibleResultado;
    private javax.swing.JTable JTBLPosiblesResultados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void actualizarTabla() {
        tableModelVerPosiblesResultados.limpiarLista();
        presenterGestionExamenes.obtenerPosiblesResultados(examen);
    }

    private ExamenPosibleResultado obtenerPosibleResultadoSeleccionado() {
        final int rowModel = JTBLPosiblesResultados.convertRowIndexToModel(JTBLPosiblesResultados.getSelectedRow());
        return tableModelVerPosiblesResultados.getExamenPosibleResultado(rowModel);
    }

    @Override
    public void posiblesResultadosObtenidos(final List<ExamenPosibleResultado> examenesPosiblesResultados) {
        tableModelVerPosiblesResultados.setExamenesPosiblesResultados(examenesPosiblesResultados);
        JTBLPosiblesResultados.getTableHeader().setReorderingAllowed(false);
    }

    @Override
    public void listaPosiblesResultadosVacia(final String msg) {
    }

    @Override
    public void errorObtenerPosiblesResultados(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerPosiblesResultados(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void posibleResultadoEliminado(final String msg) {
        actualizarTabla();
    }

    @Override
    public void errorEliminarPosibleResultado(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoEliminarPosibleResultado(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}