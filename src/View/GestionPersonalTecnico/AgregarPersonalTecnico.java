package View.GestionPersonalTecnico;

import Model.POJO.Cuenta;
import Presenter.GestionPersonalTecnico.PresenterGestionPersonalTecnico;
import View.Utilitarios.ModelTable.GestionPersonalTecnico.TableModelPersonalesTecnicosInactivos;
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
public class AgregarPersonalTecnico extends javax.swing.JDialog implements PresenterGestionPersonalTecnico.CallBackObtenerCuentasPersonalesTecnicosInhabilitados, PresenterGestionPersonalTecnico.CallBackAgregarPersonalTecnico, PresenterGestionPersonalTecnico.CallBackEliminarPersonalTecnico {

    private final TableModelPersonalesTecnicosInactivos tableModelPersonalesTecnicosInactivos;
    private final PresenterGestionPersonalTecnico presenterGestionPersonalTecnico;

    public AgregarPersonalTecnico(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        presenterGestionPersonalTecnico = new PresenterGestionPersonalTecnico();
        presenterGestionPersonalTecnico.setCallBackObtenerCuentasPersonalesTecnicosInhabilitados(this);
        presenterGestionPersonalTecnico.setCallBackAgregarPersonalTecnico(this);
        presenterGestionPersonalTecnico.setCallBackEliminarPersonalTecnico(this);
        
        tableModelPersonalesTecnicosInactivos = new TableModelPersonalesTecnicosInactivos();
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemBioquimicosInactivos = new javax.swing.JPopupMenu();
        JMENUITEMAgregar = new javax.swing.JMenuItem();
        JMENUITEMEliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        JTXTFBuscarPersonalTecnico = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLPersonalesTecnicosInactivos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        BTNCerrar = new javax.swing.JButton();
        BTNActualizar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        JCMBXBuscarPor = new javax.swing.JComboBox<>();

        JMENUITEMAgregar.setText("Agregar");
        JMENUITEMAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMAgregarActionPerformed(evt);
            }
        });
        JPOPUPMENUItemBioquimicosInactivos.add(JMENUITEMAgregar);

        JMENUITEMEliminar.setText("Eliminar de la Lista");
        JMENUITEMEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMEliminarActionPerformed(evt);
            }
        });
        JPOPUPMENUItemBioquimicosInactivos.add(JMENUITEMEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Agregar Personal Técnico");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setMinimumSize(new java.awt.Dimension(1200, 700));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Persona"));

        JTXTFBuscarPersonalTecnico.setEnabled(false);
        JTXTFBuscarPersonalTecnico.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFBuscarPersonalTecnicoFocusGained(evt);
            }
        });
        JTXTFBuscarPersonalTecnico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFBuscarPersonalTecnicoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFBuscarPersonalTecnicoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTXTFBuscarPersonalTecnico, javax.swing.GroupLayout.DEFAULT_SIZE, 985, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTXTFBuscarPersonalTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Personas Registradas"));

        JTBLPersonalesTecnicosInactivos.setModel(tableModelPersonalesTecnicosInactivos);
        JTBLPersonalesTecnicosInactivos.setComponentPopupMenu(JPOPUPMENUItemBioquimicosInactivos);
        JTBLPersonalesTecnicosInactivos.setEnabled(false);
        JTBLPersonalesTecnicosInactivos.setRowHeight(20);
        JTBLPersonalesTecnicosInactivos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTBLPersonalesTecnicosInactivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLPersonalesTecnicosInactivosMousePressed(evt);
            }
        });
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLPersonalesTecnicosInactivos.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
        JTBLPersonalesTecnicosInactivos.getColumnModel().getColumn(1).setCellRenderer(defaultTableCellRenderer);
        JTBLPersonalesTecnicosInactivos.getColumnModel().getColumn(4).setCellRenderer(defaultTableCellRenderer);
        JTBLPersonalesTecnicosInactivos.getColumnModel().getColumn(6).setCellRenderer(defaultTableCellRenderer);
        JTBLPersonalesTecnicosInactivos.getColumnModel().getColumn(7).setCellRenderer(defaultTableCellRenderer);

        JTBLPersonalesTecnicosInactivos.getColumnModel().getColumn(0).setPreferredWidth(10);
        JTBLPersonalesTecnicosInactivos.getColumnModel().getColumn(1).setPreferredWidth(40);
        JTBLPersonalesTecnicosInactivos.getColumnModel().getColumn(2).setPreferredWidth(200);
        JTBLPersonalesTecnicosInactivos.getColumnModel().getColumn(3).setPreferredWidth(200);
        JTBLPersonalesTecnicosInactivos.getColumnModel().getColumn(4).setPreferredWidth(10);
        JTBLPersonalesTecnicosInactivos.getColumnModel().getColumn(5).setPreferredWidth(100);
        JTBLPersonalesTecnicosInactivos.getColumnModel().getColumn(6).setPreferredWidth(50);
        JTBLPersonalesTecnicosInactivos.getColumnModel().getColumn(7).setPreferredWidth(50);
        jScrollPane1.setViewportView(JTBLPersonalesTecnicosInactivos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addContainerGap())
        );

        BTNCerrar.setText("CERRAR");
        BTNCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNCerrarActionPerformed(evt);
            }
        });

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
                .addComponent(BTNCerrar)
                .addGap(18, 18, 18)
                .addComponent(BTNActualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNCerrar)
                    .addComponent(BTNActualizar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        presenterGestionPersonalTecnico.obtenerCuentasPersonalesTecnicosInhabilitados();
    }//GEN-LAST:event_formWindowOpened

    private void JTXTFBuscarPersonalTecnicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFBuscarPersonalTecnicoKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFBuscarPersonalTecnico.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFBuscarPersonalTecnicoKeyTyped

    private void JTXTFBuscarPersonalTecnicoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFBuscarPersonalTecnicoKeyReleased
        final String search = JTXTFBuscarPersonalTecnico.getText().toUpperCase();
        final TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) JTBLPersonalesTecnicosInactivos.getRowSorter();

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
    }//GEN-LAST:event_JTXTFBuscarPersonalTecnicoKeyReleased

    private void JTBLPersonalesTecnicosInactivosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLPersonalesTecnicosInactivosMousePressed
        final int currentRow = JTBLPersonalesTecnicosInactivos.rowAtPoint(evt.getPoint());
        JTBLPersonalesTecnicosInactivos.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLPersonalesTecnicosInactivosMousePressed

    private void JMENUITEMAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMAgregarActionPerformed
        final Cuenta cuenta = obtenerCuentaSeleccionada();

        int opcionSeleccionada = JOptionPane.showConfirmDialog(this, "¿Dar de alta al personal técnico?\n\nDatos:\nC.I: " + cuenta.getPersonalTecnico().getPersona().getPersonaCedulaIdentidad() + "\nApellido: " + cuenta.getPersonalTecnico().getPersona().getPersonaApellido() + "\nNombre: " + cuenta.getPersonalTecnico().getPersona().getPersonaNombre() + "\nSexo: " + cuenta.getPersonalTecnico().getPersona().getPersonaSexo() + "\nProfesión: " + cuenta.getPersonalTecnico().getPertecProfesion() + "\n\n", "SIET", JOptionPane.YES_NO_OPTION);

        if (opcionSeleccionada == 0) {
            presenterGestionPersonalTecnico.agregarPersonalTecnico(cuenta.getPersonalTecnico());
        }
    }//GEN-LAST:event_JMENUITEMAgregarActionPerformed

    private void BTNCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_BTNCerrarActionPerformed

    private void BTNActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_BTNActualizarActionPerformed

    private void JMENUITEMEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMEliminarActionPerformed
        final Cuenta cuenta = obtenerCuentaSeleccionada();

        final int option = JOptionPane.showConfirmDialog(this, "¿Estas seguro de eliminar al personal técnico?\n\nDATOS:\n\nC.I: " + cuenta.getPersonalTecnico().getPersona().getPersonaCedulaIdentidad() + "\nAPELLIDO: " + cuenta.getPersonalTecnico().getPersona().getPersonaApellido() + "\nNOMBRE: " + cuenta.getPersonalTecnico().getPersona().getPersonaNombre() + "\nSEXO: " + cuenta.getPersonalTecnico().getPersona().getPersonaSexo() + "\nPROFESION: " + cuenta.getPersonalTecnico().getPertecProfesion() + "\n\n¿Eliminar?\n\n", "SIET", JOptionPane.YES_NO_OPTION);

        if (option == 0) {
            presenterGestionPersonalTecnico.eliminarPersonalTecnico(cuenta);
        }
    }//GEN-LAST:event_JMENUITEMEliminarActionPerformed

    private void JCMBXBuscarPorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCMBXBuscarPorItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            JTXTFBuscarPersonalTecnico.requestFocus();
        }
    }//GEN-LAST:event_JCMBXBuscarPorItemStateChanged

    private void JTXTFBuscarPersonalTecnicoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFBuscarPersonalTecnicoFocusGained
        JTXTFBuscarPersonalTecnico.selectAll();
    }//GEN-LAST:event_JTXTFBuscarPersonalTecnicoFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            AgregarPersonalTecnico dialog = new AgregarPersonalTecnico(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BTNActualizar;
    private javax.swing.JButton BTNCerrar;
    private javax.swing.JComboBox<String> JCMBXBuscarPor;
    private javax.swing.JMenuItem JMENUITEMAgregar;
    private javax.swing.JMenuItem JMENUITEMEliminar;
    private javax.swing.JPopupMenu JPOPUPMENUItemBioquimicosInactivos;
    private javax.swing.JTable JTBLPersonalesTecnicosInactivos;
    private javax.swing.JTextField JTXTFBuscarPersonalTecnico;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void actualizarTabla() {
        tableModelPersonalesTecnicosInactivos.limpiarLista();
        presenterGestionPersonalTecnico.obtenerCuentasPersonalesTecnicosInhabilitados();
    }
    
    private Cuenta obtenerCuentaSeleccionada() {
        final int rowModel = JTBLPersonalesTecnicosInactivos.convertRowIndexToModel(JTBLPersonalesTecnicosInactivos.getSelectedRow());
        return tableModelPersonalesTecnicosInactivos.getCuentaBioquimico(rowModel);
    }
    
    @Override
    public void cuentasPersonalesTecnicosInhabilitadosObtenidos(final List<Cuenta> cuentas) {
        tableModelPersonalesTecnicosInactivos.setCuentas(cuentas);
        JTBLPersonalesTecnicosInactivos.setRowSorter(new TableRowSorter<>(tableModelPersonalesTecnicosInactivos));
        JTBLPersonalesTecnicosInactivos.getTableHeader().setReorderingAllowed(false);
        
        JTXTFBuscarPersonalTecnico.setEnabled(true);
        JCMBXBuscarPor.setEnabled(true);
    }

    @Override
    public void listaCuentasPersonalesTecnicosInhabilitadosVacia(final String msg) {
        JTXTFBuscarPersonalTecnico.setEnabled(false);
        JCMBXBuscarPor.setEnabled(false);
    }

    @Override
    public void errorObtenerCuentasPersonalesTecnicosInhabilitados(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerCuentasPersonalesTecnicosInhabilitados(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void personalTecnicoAgregado(final String msg) {
        actualizarTabla();
    }

    @Override
    public void errorAgregarPersonalTecnico(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoAgregarPersonalTecnico(final String msg) {
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