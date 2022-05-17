package View.GestionSubespecialidades;

import Model.POJO.Especialidad;
import Model.POJO.Subespecialidad;
import Model.POJOPersonalizado.EspecialidadPersonalizada;
import Presenter.GestionEspecialidades.PresenterGestionEspecialidades;
import Presenter.GestionSubespecialidades.PresenterGestionSubespecialidades;
import View.Utilitarios.ModeloItemComboBox.ItemEspecialidad;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
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
public class ModificarSubespecialidad extends javax.swing.JDialog implements PresenterGestionEspecialidades.CallBackObtenerEspecialidades, PresenterGestionSubespecialidades.CallBackVerificarExistenciaSubespecialidad, PresenterGestionSubespecialidades.CallBackModificarSubespecialidad {
    
    private final PresenterGestionEspecialidades presenterGestionEspecialidades;
    private final PresenterGestionSubespecialidades presenterGestionSubespecialidades;
    private Subespecialidad subespecialidad;
    
    public ModificarSubespecialidad(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        initComponents();
        
        presenterGestionEspecialidades = new PresenterGestionEspecialidades();
        presenterGestionSubespecialidades = new PresenterGestionSubespecialidades();
        presenterGestionEspecialidades.setCallBackObtenerEspecialidades(this);
        presenterGestionSubespecialidades.setCallBackVerificarExistenciaSubespecialidad(this);
        presenterGestionSubespecialidades.setCallBackModificarSubespecialidad(this);
        JTXTFSubespecialidadNombre.addActionListener(action);
        JBTNGuardar.addActionListener(action);
    }

    public void setSubespecialidad(Subespecialidad subespecialidad) {
        this.subespecialidad = subespecialidad;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JTXTFSubespecialidadNombre = new javax.swing.JTextField();
        JBTNCancelar = new javax.swing.JButton();
        JBTNGuardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        JCMBXEspecialidad = new javax.swing.JComboBox<>();
        JLBLContadorSubespecialidadNombre = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Modificar Subespecialidad");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Modificar Subespecialidad"));

        jLabel1.setText("Nombre de la Subespecialidad:");

        JTXTFSubespecialidadNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFSubespecialidadNombreFocusGained(evt);
            }
        });
        JTXTFSubespecialidadNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFSubespecialidadNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFSubespecialidadNombreKeyTyped(evt);
            }
        });
        JTXTFSubespecialidadNombre.setTransferHandler(null);

        JBTNCancelar.setText("CANCELAR");
        JBTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarActionPerformed(evt);
            }
        });

        JBTNGuardar.setText("GUARDAR");

        jLabel2.setText("Especialidad:");

        JLBLContadorSubespecialidadNombre.setText("0");

        jLabel4.setText("/50");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTXTFSubespecialidadNombre)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JBTNCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
                        .addComponent(JBTNGuardar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(JCMBXEspecialidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorSubespecialidadNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(JLBLContadorSubespecialidadNombre))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFSubespecialidadNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JCMBXEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNCancelar)
                    .addComponent(JBTNGuardar))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            if (subespecialidad == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                JTXTFSubespecialidadNombre.setText(subespecialidad.getSubespecialidadNombre());
                JLBLContadorSubespecialidadNombre.setText(String.valueOf(JTXTFSubespecialidadNombre.getText().length()));
                presenterGestionEspecialidades.obtenerEspecialidades();
                JCMBXEspecialidad.setSelectedIndex(obtenerEspecialidadSeleccionada(subespecialidad.getEspecialidad()));
            }
        } catch (final HeadlessException ex) {
            System.err.println("Se produjo un error: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Se produjo un error desconocido. Vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTXTFSubespecialidadNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFSubespecialidadNombreKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z\\\\.()* ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFSubespecialidadNombre.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFSubespecialidadNombreKeyTyped

    private void JBTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCancelarActionPerformed

    private void JTXTFSubespecialidadNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFSubespecialidadNombreKeyReleased
        JLBLContadorSubespecialidadNombre.setText(String.valueOf(JTXTFSubespecialidadNombre.getText().length()));
    }//GEN-LAST:event_JTXTFSubespecialidadNombreKeyReleased

    private void JTXTFSubespecialidadNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFSubespecialidadNombreFocusGained
        JTXTFSubespecialidadNombre.selectAll();
    }//GEN-LAST:event_JTXTFSubespecialidadNombreFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            ModificarSubespecialidad dialog = new ModificarSubespecialidad(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNGuardar;
    private javax.swing.JComboBox<ItemEspecialidad> JCMBXEspecialidad;
    private javax.swing.JLabel JLBLContadorSubespecialidadNombre;
    private javax.swing.JTextField JTXTFSubespecialidadNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private int obtenerEspecialidadSeleccionada(final Especialidad especialidad) {
        final int size = JCMBXEspecialidad.getModel().getSize();
        
        for (int i = 0; i < size; i++) {
            if (JCMBXEspecialidad.getItemAt(i).getCodigoEspecialidad() == especialidad.getCodigoEspecialidad()) {
                return i;
            }
        }
        return -1;
    }
    
    private final Action action = new AbstractAction() {
        @Override
        public void actionPerformed(final ActionEvent ae) {
            final String subespecialidad_nombre = JTXTFSubespecialidadNombre.getText();

            if (subespecialidad_nombre.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingresa el nombre para la subespecialidad.", "SIET", JOptionPane.INFORMATION_MESSAGE);
            } else if (JCMBXEspecialidad.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Selecciona a que especialidad corresponde la subespecialidad.", "SIET", JOptionPane.INFORMATION_MESSAGE);
                JCMBXEspecialidad.requestFocus();
            } else {
                final ItemEspecialidad itemEspecialidad = (ItemEspecialidad) JCMBXEspecialidad.getSelectedItem();
                final Especialidad especialidad = new Especialidad(itemEspecialidad.getCodigoEspecialidad(), itemEspecialidad.getEspecialidadNombre(), itemEspecialidad.getEspecialidadEstado());
                subespecialidad.setEspecialidad(especialidad);
                subespecialidad.setSubespecialidadNombre(subespecialidad_nombre);
                presenterGestionSubespecialidades.modificarSubespecialidad(subespecialidad);
            }
        }
    };
    
    @Override
    public void especialidadesObtenidas(final List<EspecialidadPersonalizada> especialidadesPersonalizadas) {
        final DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
        especialidadesPersonalizadas.forEach((especialidadPersonalizada) -> {
            defaultComboBoxModel.addElement(new ItemEspecialidad(especialidadPersonalizada.getEspecialidad().getCodigoEspecialidad(), especialidadPersonalizada.getEspecialidad().getEspecialidadNombre(), especialidadPersonalizada.getEspecialidad().getEspecialidadEstado()));
        });
        JCMBXEspecialidad.setModel(defaultComboBoxModel);
        JCMBXEspecialidad.setSelectedIndex(-1);
    }

    @Override
    public void listaEspecialidadesVacia(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorObtenerEspecialidades(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerEspecialidades(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
    
    @Override
    public void existeSubespecialidad(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorVerificarExistenciaSubespecialidad(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
    
    @Override
    public void subespecialidadModificada(final String msg) {
        dispose();
    }

    @Override
    public void errorModificarSubespecialidad(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoModificarSubespecialidad(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}