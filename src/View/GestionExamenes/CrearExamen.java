package View.GestionExamenes;

import Model.POJO.Examen;
import Model.POJO.Subespecialidad;
import Model.POJOPersonalizado.SubespecialidadPersonalizada;
import Presenter.GestionExamenes.PresenterGestionExamenes;
import Presenter.GestionSubespecialidades.PresenterGestionSubespecialidades;
import View.Utilitarios.ModeloItemComboBox.ItemSubespecialidad;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Brynner
 */
public class CrearExamen extends javax.swing.JDialog implements PresenterGestionSubespecialidades.CallBackObtenerSubespecialidades, PresenterGestionExamenes.CallBackVerificarExistenciaExamen, PresenterGestionExamenes.CallBackCrearExamen {
    
    private final PresenterGestionExamenes presenterGestionExamenes;
    private final PresenterGestionSubespecialidades presenterGestionSubespecialidades;
    
    public CrearExamen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        presenterGestionExamenes = new PresenterGestionExamenes();
        presenterGestionSubespecialidades = new PresenterGestionSubespecialidades();
        presenterGestionSubespecialidades.setCallBackObtenerSubespecialidades(this);
        presenterGestionExamenes.setCallBackVerificarExistenciaExamen(this);
        presenterGestionExamenes.setCallBackCrearExamen(this);
        JTXTFExamenNombre.addActionListener(action);
        JBTNCrear.addActionListener(action);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JTXTFExamenNombre = new javax.swing.JTextField();
        JBTNCancelar = new javax.swing.JButton();
        JBTNCrear = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        JCMBXSubespecialidades = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        JLBLEspecialidad = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JLBLContadorExamenNombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Crear Examen");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevo Examen"));

        jLabel1.setText("Nombre del Examen:");

        JTXTFExamenNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFExamenNombreFocusGained(evt);
            }
        });
        JTXTFExamenNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFExamenNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFExamenNombreKeyTyped(evt);
            }
        });
        JTXTFExamenNombre.setTransferHandler(null);

        JBTNCancelar.setText("CANCELAR");
        JBTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarActionPerformed(evt);
            }
        });

        JBTNCrear.setText("CREAR");

        jLabel2.setText("Subespecialidad:");

        JCMBXSubespecialidades.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCMBXSubespecialidadesItemStateChanged(evt);
            }
        });

        jLabel3.setText("Especialidad:");

        JLBLEspecialidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("/50");

        JLBLContadorExamenNombre.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTXTFExamenNombre)
                    .addComponent(JCMBXSubespecialidades, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JBTNCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
                        .addComponent(JBTNCrear))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(JLBLEspecialidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorExamenNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(JLBLContadorExamenNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFExamenNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JCMBXSubespecialidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNCancelar)
                    .addComponent(JBTNCrear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JTXTFExamenNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFExamenNombreKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9-/,+() ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFExamenNombre.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFExamenNombreKeyTyped

    private void JBTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCancelarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        presenterGestionSubespecialidades.obtenerSubespecialidades();
    }//GEN-LAST:event_formWindowOpened

    private void JCMBXSubespecialidadesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCMBXSubespecialidadesItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            final ItemSubespecialidad itemSubespecialidad = (ItemSubespecialidad) JCMBXSubespecialidades.getSelectedItem();
            JLBLEspecialidad.setText(itemSubespecialidad.getEspecialidad().getEspecialidadNombre());
        }
    }//GEN-LAST:event_JCMBXSubespecialidadesItemStateChanged

    private void JTXTFExamenNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFExamenNombreKeyReleased
        JLBLContadorExamenNombre.setText(String.valueOf(JTXTFExamenNombre.getText().length()));
    }//GEN-LAST:event_JTXTFExamenNombreKeyReleased

    private void JTXTFExamenNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFExamenNombreFocusGained
        JTXTFExamenNombre.selectAll();
    }//GEN-LAST:event_JTXTFExamenNombreFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            CrearExamen dialog = new CrearExamen(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNCancelar;
    private javax.swing.JButton JBTNCrear;
    private javax.swing.JComboBox<ItemSubespecialidad> JCMBXSubespecialidades;
    private javax.swing.JLabel JLBLContadorExamenNombre;
    private javax.swing.JLabel JLBLEspecialidad;
    private javax.swing.JTextField JTXTFExamenNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private final Action action = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            final String examen_nombre = JTXTFExamenNombre.getText();
            final int selectedIndex = JCMBXSubespecialidades.getSelectedIndex();
            if (examen_nombre.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingresa un nombre para el nuevo examen.", "SIET", JOptionPane.ERROR_MESSAGE);
            } else if (selectedIndex == -1) {
                JOptionPane.showMessageDialog(null, "Selecciona a que subespecialidad corresponde el nuevo examen.", "SIET", JOptionPane.ERROR_MESSAGE);
            } else {
                final ItemSubespecialidad itemSubespecialidad = (ItemSubespecialidad) JCMBXSubespecialidades.getSelectedItem(); 
                final Subespecialidad subespecialidad = new Subespecialidad(itemSubespecialidad.getCodigoSubespecialidad(), itemSubespecialidad.getEspecialidad(), itemSubespecialidad.getSubespecialidadNombre(), itemSubespecialidad.getSubespecialidadEstado());
                final Examen examen = new Examen(subespecialidad, examen_nombre.toUpperCase(), 1);
                presenterGestionExamenes.crearExamen(examen);
            }
        }
    };
    
    @Override
    public void subespecialidadesObtenidas(final List<SubespecialidadPersonalizada> subespecialidadesPersonalizadas) {
        final DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
        subespecialidadesPersonalizadas.forEach((subespecialidadPersonalizada) -> {
            final Subespecialidad subespecialidad = subespecialidadPersonalizada.getSubespecialidad();
            defaultComboBoxModel.addElement(new ItemSubespecialidad(subespecialidad.getCodigoSubespecialidad(), subespecialidad.getEspecialidad(), subespecialidad.getSubespecialidadNombre(), subespecialidad.getSubespecialidadEstado()));
        });
        JCMBXSubespecialidades.setModel(defaultComboBoxModel);
        JCMBXSubespecialidades.setSelectedIndex(-1);
    }

    @Override
    public void listaSubespecialidadesVacia(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void errorObtenerSubespecialidades(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerSubespecialidades(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
    
    @Override
    public void examenExiste(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorVerificarExistenciaExamen(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void examenCreado(final String msg) {
        dispose();
    }

    @Override
    public void errorCrearExamen(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoCrearExamen(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}