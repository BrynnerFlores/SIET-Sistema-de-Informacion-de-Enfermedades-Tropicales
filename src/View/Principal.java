package View;

import View.Utilitarios.Utilidades;
import Model.POJO.Cuenta;
import View.Acceso.IniciarSesion;
import View.Ayuda.ManualUsuario.ManualUsuario;
import View.Configuraciones.ConexionBaseDatos;
import View.GestionPersonalTecnico.DetallesPersonalTecnico;
import View.GestionPersonalTecnico.GestionPersonalTecnico;
import View.GestionEquipos.GestionEquiposActivos.GestionEquiposActivos;
import View.GestionEquipos.GestionEquiposEliminados.GestionEquiposEliminados;
import View.GestionEquipos.GestionEquiposIntervencion.GestionEquiposIntervencion;
import View.GestionEspecialidades.GestionEspecialidades;
import View.GestionEstablecimientos.GestionEstablecimientos;
import View.GestionExamenes.GestionExamenes;
import View.GestionMuestrasBiologicas.GestionMuestrasBiologicas;
import View.GestionPacientes.GestionPacientes;
import View.GestionPerfil.CambiarPassword;
import View.GestionPerfil.ModificarInformacion;
import View.GestionReactivos.EntregasReactivos;
import View.GestionReactivos.GestionReactivos;
import View.GestionRecepciones.BuscarPaciente;
import View.GestionSubespecialidades.GestionSubespecialidades;
import View.GestionRecepciones.GestionRecepciones;
import View.GestionReportes.InformeMensualLaboratorio;
import View.Respaldo.BaseDatos.GenerarCopiaSeguridad;
import View.Utilitarios.CryptoException;
import View.Utilitarios.CryptoUtils;
import java.awt.HeadlessException;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author Brynner
 */
public class Principal extends javax.swing.JFrame {

    private Cuenta cuenta;

    public Principal() {
        initComponents();
        cuenta = Utilidades.obtenerCuentaLocal();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DSKPContenedor = new javax.swing.JDesktopPane();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        JLBLUsuario = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jLabel3 = new javax.swing.JLabel();
        JLBLEstadoCuenta = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jLabel2 = new javax.swing.JLabel();
        JLBLRolCuenta = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        JMENUITEMModificarInformacaion = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        JMENUITEMVerInformacion = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        JMENUITEMCambiarPassword = new javax.swing.JMenuItem();
        JMENUITEMCerrarSesion = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        JMENUITEMNuevaRecepcion = new javax.swing.JMenuItem();
        JMENUITEMVerRecepciones = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        JMENUITEMEstablecimientos = new javax.swing.JMenuItem();
        JMENUPacientes = new javax.swing.JMenu();
        JMENUITEMVerPacientes = new javax.swing.JMenuItem();
        JMENUPersonalTecnico = new javax.swing.JMenu();
        JMENUITEMVerPersonalTecnico = new javax.swing.JMenuItem();
        JMENUEstudios = new javax.swing.JMenu();
        JMENUITEMEspecialidades = new javax.swing.JMenuItem();
        JMENUITEMSubespecialidades = new javax.swing.JMenuItem();
        JMENUITEMExamenes = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        JMENUITEMMuestrasBiologicas = new javax.swing.JMenuItem();
        JMENULaboratorio = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        JMENUITEMReactivos = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        JMENUITEMEntregas = new javax.swing.JMenuItem();
        JMENUEquipos = new javax.swing.JMenu();
        JMENUITEMEquiposActivos = new javax.swing.JMenuItem();
        JMENUITEMEquiposEnIntervencion = new javax.swing.JMenuItem();
        JMENUITEMEquiposDadosDeBaja = new javax.swing.JMenuItem();
        JMENUReportes = new javax.swing.JMenu();
        JMENUITEMInformeMensualLaboratorio = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        JMENUITEMConexionBaseDatos = new javax.swing.JMenuItem();
        JMENURespaldos = new javax.swing.JMenu();
        JMENURespaldoBaseDatos = new javax.swing.JMenu();
        JMENUITEMGenerarCopiaSeguridad = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        JMENUITEMManualUsuario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIET - Sistema de Información de Enfermedades Tropicales");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setMinimumSize(new java.awt.Dimension(500, 500));
        setPreferredSize(new java.awt.Dimension(1400, 850));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        javax.swing.GroupLayout DSKPContenedorLayout = new javax.swing.GroupLayout(DSKPContenedor);
        DSKPContenedor.setLayout(DSKPContenedorLayout);
        DSKPContenedorLayout.setHorizontalGroup(
            DSKPContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        DSKPContenedorLayout.setVerticalGroup(
            DSKPContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jToolBar1.setFloatable(false);

        jLabel1.setText("USUARIO: ");
        jToolBar1.add(jLabel1);
        jToolBar1.add(JLBLUsuario);
        jToolBar1.add(jSeparator2);

        jLabel3.setText("ESTADO DE LA CUENTA: ");
        jToolBar1.add(jLabel3);
        jToolBar1.add(JLBLEstadoCuenta);
        jToolBar1.add(jSeparator3);

        jLabel2.setText("ROL DE LA CUENTA: ");
        jToolBar1.add(jLabel2);
        jToolBar1.add(JLBLRolCuenta);

        jMenu1.setText("Archivo");

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/mi_cuenta.png"))); // NOI18N
        jMenu4.setText("Mi Cuenta");

        JMENUITEMModificarInformacaion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/modificar_informacion.png"))); // NOI18N
        JMENUITEMModificarInformacaion.setText("Modificar Información");
        JMENUITEMModificarInformacaion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMModificarInformacaionActionPerformed(evt);
            }
        });
        jMenu4.add(JMENUITEMModificarInformacaion);
        jMenu4.add(jSeparator7);

        JMENUITEMVerInformacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_informacion.png"))); // NOI18N
        JMENUITEMVerInformacion.setText("Ver Información");
        JMENUITEMVerInformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerInformacionActionPerformed(evt);
            }
        });
        jMenu4.add(JMENUITEMVerInformacion);
        jMenu4.add(jSeparator6);

        JMENUITEMCambiarPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/modificar_password.png"))); // NOI18N
        JMENUITEMCambiarPassword.setText("Cambiar Contraseña");
        JMENUITEMCambiarPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMCambiarPasswordActionPerformed(evt);
            }
        });
        jMenu4.add(JMENUITEMCambiarPassword);

        jMenu1.add(jMenu4);

        JMENUITEMCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/cerrar_sesion.png"))); // NOI18N
        JMENUITEMCerrarSesion.setText("Cerrar Sesion");
        JMENUITEMCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMCerrarSesionActionPerformed(evt);
            }
        });
        jMenu1.add(JMENUITEMCerrarSesion);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Recepciones");

        JMENUITEMNuevaRecepcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/nueva_recepcion.png"))); // NOI18N
        JMENUITEMNuevaRecepcion.setText("Nueva Recepción");
        JMENUITEMNuevaRecepcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMNuevaRecepcionActionPerformed(evt);
            }
        });
        jMenu2.add(JMENUITEMNuevaRecepcion);

        JMENUITEMVerRecepciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_recepciones.png"))); // NOI18N
        JMENUITEMVerRecepciones.setText("Ver Recepciones");
        JMENUITEMVerRecepciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerRecepcionesActionPerformed(evt);
            }
        });
        jMenu2.add(JMENUITEMVerRecepciones);
        jMenu2.add(jSeparator4);

        JMENUITEMEstablecimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/establecimientos_salud.png"))); // NOI18N
        JMENUITEMEstablecimientos.setText("Establecimientos");
        JMENUITEMEstablecimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMEstablecimientosActionPerformed(evt);
            }
        });
        jMenu2.add(JMENUITEMEstablecimientos);

        jMenuBar1.add(jMenu2);

        JMENUPacientes.setText("Pacientes");

        JMENUITEMVerPacientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_pacientes.png"))); // NOI18N
        JMENUITEMVerPacientes.setText("Ver Pacientes");
        JMENUITEMVerPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerPacientesActionPerformed(evt);
            }
        });
        JMENUPacientes.add(JMENUITEMVerPacientes);

        jMenuBar1.add(JMENUPacientes);

        JMENUPersonalTecnico.setText("Personal Técnico");

        JMENUITEMVerPersonalTecnico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_personal_tecnico.png"))); // NOI18N
        JMENUITEMVerPersonalTecnico.setText("Ver Personal Técnico");
        JMENUITEMVerPersonalTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerPersonalTecnicoActionPerformed(evt);
            }
        });
        JMENUPersonalTecnico.add(JMENUITEMVerPersonalTecnico);

        jMenuBar1.add(JMENUPersonalTecnico);

        JMENUEstudios.setLabel("Estudios");

        JMENUITEMEspecialidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/documento.png"))); // NOI18N
        JMENUITEMEspecialidades.setLabel("Especialidades");
        JMENUITEMEspecialidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMEspecialidadesActionPerformed(evt);
            }
        });
        JMENUEstudios.add(JMENUITEMEspecialidades);

        JMENUITEMSubespecialidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/documento.png"))); // NOI18N
        JMENUITEMSubespecialidades.setText("Subespecialidades");
        JMENUITEMSubespecialidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMSubespecialidadesActionPerformed(evt);
            }
        });
        JMENUEstudios.add(JMENUITEMSubespecialidades);

        JMENUITEMExamenes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/documento.png"))); // NOI18N
        JMENUITEMExamenes.setText("Exámenes");
        JMENUITEMExamenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMExamenesActionPerformed(evt);
            }
        });
        JMENUEstudios.add(JMENUITEMExamenes);
        JMENUEstudios.add(jSeparator1);

        JMENUITEMMuestrasBiologicas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/muestras_biologicas.png"))); // NOI18N
        JMENUITEMMuestrasBiologicas.setText("Muestras Biológicas");
        JMENUITEMMuestrasBiologicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMMuestrasBiologicasActionPerformed(evt);
            }
        });
        JMENUEstudios.add(JMENUITEMMuestrasBiologicas);

        jMenuBar1.add(JMENUEstudios);

        JMENULaboratorio.setText("Laboratorio");

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_reactivos.png"))); // NOI18N
        jMenu3.setText("Reactivos");

        JMENUITEMReactivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_reactivos.png"))); // NOI18N
        JMENUITEMReactivos.setText("Reactivos");
        JMENUITEMReactivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMReactivosActionPerformed(evt);
            }
        });
        jMenu3.add(JMENUITEMReactivos);
        jMenu3.add(jSeparator5);

        JMENUITEMEntregas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_entregas.png"))); // NOI18N
        JMENUITEMEntregas.setText("Entregas");
        JMENUITEMEntregas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMEntregasActionPerformed(evt);
            }
        });
        jMenu3.add(JMENUITEMEntregas);

        JMENULaboratorio.add(jMenu3);

        JMENUEquipos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_equipos_activos.png"))); // NOI18N
        JMENUEquipos.setText("Equipos");

        JMENUITEMEquiposActivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_equipos_activos.png"))); // NOI18N
        JMENUITEMEquiposActivos.setText("Equipos Activos");
        JMENUITEMEquiposActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMEquiposActivosActionPerformed(evt);
            }
        });
        JMENUEquipos.add(JMENUITEMEquiposActivos);

        JMENUITEMEquiposEnIntervencion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_equipos_intervencion.png"))); // NOI18N
        JMENUITEMEquiposEnIntervencion.setText("Equipos en Intervencion");
        JMENUITEMEquiposEnIntervencion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMEquiposEnIntervencionActionPerformed(evt);
            }
        });
        JMENUEquipos.add(JMENUITEMEquiposEnIntervencion);

        JMENUITEMEquiposDadosDeBaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_equipos_dados_baja.png"))); // NOI18N
        JMENUITEMEquiposDadosDeBaja.setText("Equipos Dados de Baja");
        JMENUITEMEquiposDadosDeBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMEquiposDadosDeBajaActionPerformed(evt);
            }
        });
        JMENUEquipos.add(JMENUITEMEquiposDadosDeBaja);

        JMENULaboratorio.add(JMENUEquipos);

        jMenuBar1.add(JMENULaboratorio);

        JMENUReportes.setText("Reportes");

        JMENUITEMInformeMensualLaboratorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/informe_mensual_laboratorio.png"))); // NOI18N
        JMENUITEMInformeMensualLaboratorio.setText("Informe Mensual de Laboratorio");
        JMENUITEMInformeMensualLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMInformeMensualLaboratorioActionPerformed(evt);
            }
        });
        JMENUReportes.add(JMENUITEMInformeMensualLaboratorio);

        jMenuBar1.add(JMENUReportes);

        jMenu5.setText("Configuraciones");

        JMENUITEMConexionBaseDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/conexion_base_de_datos.png"))); // NOI18N
        JMENUITEMConexionBaseDatos.setText("Conexión a Base de Datos");
        JMENUITEMConexionBaseDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMConexionBaseDatosActionPerformed(evt);
            }
        });
        jMenu5.add(JMENUITEMConexionBaseDatos);

        jMenuBar1.add(jMenu5);

        JMENURespaldos.setText("Respaldos");

        JMENURespaldoBaseDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/base_de_datos.png"))); // NOI18N
        JMENURespaldoBaseDatos.setText("Base de Datos");

        JMENUITEMGenerarCopiaSeguridad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/generar_copia_seguridad.png"))); // NOI18N
        JMENUITEMGenerarCopiaSeguridad.setText("Generar Copia de Seguridad");
        JMENUITEMGenerarCopiaSeguridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMGenerarCopiaSeguridadActionPerformed(evt);
            }
        });
        JMENURespaldoBaseDatos.add(JMENUITEMGenerarCopiaSeguridad);

        JMENURespaldos.add(JMENURespaldoBaseDatos);

        jMenuBar1.add(JMENURespaldos);

        jMenu6.setText("Ayuda");

        JMENUITEMManualUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/manual_usuario_instalacion.png"))); // NOI18N
        JMENUITEMManualUsuario.setText("Manual de Instalación y de Usuario");
        JMENUITEMManualUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMManualUsuarioActionPerformed(evt);
            }
        });
        jMenu6.add(JMENUITEMManualUsuario);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(DSKPContenedor)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(DSKPContenedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JMENUITEMVerRecepcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerRecepcionesActionPerformed
        try {
            if (cuenta.getPersonalTecnico().getPertecHabilitado()) {
                final GestionRecepciones gestionRecepciones = new GestionRecepciones();

                DSKPContenedor.add(gestionRecepciones);
                gestionRecepciones.setMaximum(true);
                gestionRecepciones.show();
            } else {
                JOptionPane.showMessageDialog(null, "Ponte en contacto con el administrador para que habilite tu cuenta.", "SIET - ACCESO DENEGADO", JOptionPane.ERROR_MESSAGE);
            }
        } catch (final HeadlessException | PropertyVetoException exception) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, exception);
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JMENUITEMVerRecepcionesActionPerformed

    private void JMENUITEMNuevaRecepcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMNuevaRecepcionActionPerformed
        if (cuenta.getPersonalTecnico().getPertecHabilitado()) {
            final BuscarPaciente buscarPaciente = new BuscarPaciente(null, true);
            buscarPaciente.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Ponte en contacto con el administrador para que habilite tu cuenta.", "SIET - ACCESO DENEGADO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JMENUITEMNuevaRecepcionActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // CARGANDO LA BARRA DE ESTADO
        try {
            if (cuenta == null) {
                JOptionPane.showMessageDialog(rootPane, "Se produjo un error al obtener la cuenta local.", "SIET", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            } else {
                JLBLUsuario.setText(cuenta.getPersonalTecnico().getPersona().getPersonaApellido() + " " + cuenta.getPersonalTecnico().getPersona().getPersonaNombre());
                JLBLRolCuenta.setText(cuenta.getCuentaRol().equals("ADMIN") ? "ADMINISTRADOR" : "USUARIO");

                if (cuenta.getPersonalTecnico().getPertecHabilitado()) {
                    JLBLEstadoCuenta.setText("ACTIVO");
                    final GestionRecepciones gestionRecepciones = new GestionRecepciones();
                    DSKPContenedor.add(gestionRecepciones);
                    gestionRecepciones.setMaximum(true);
                    gestionRecepciones.setVisible(true);
                } else {
                    JLBLEstadoCuenta.setText("INACTIVO");
                }

                if (cuenta.getCuentaRol().equals("USER")) {
                    JMENUPersonalTecnico.setEnabled(false);
                    JMENUPersonalTecnico.setVisible(false);

                    JMENUEstudios.setEnabled(false);
                    JMENUEstudios.setVisible(false);

                    JMENULaboratorio.setEnabled(false);
                    JMENULaboratorio.setVisible(false);

                    JMENUReportes.setEnabled(false);
                    JMENUReportes.setVisible(false);

                    JMENURespaldos.setEnabled(false);
                    JMENURespaldos.setVisible(false);
                }
            }
        } catch (final DOMException e) {
            System.err.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
        } catch (final PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_formWindowOpened

    private void JMENUITEMVerPersonalTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerPersonalTecnicoActionPerformed
        try {
            if (cuenta.getPersonalTecnico().getPertecHabilitado()) {
                final GestionPersonalTecnico gestionBioquimicos = new GestionPersonalTecnico();
                DSKPContenedor.removeAll();
                DSKPContenedor.updateUI();
                DSKPContenedor.add(gestionBioquimicos);
                gestionBioquimicos.setMaximum(true);
                gestionBioquimicos.show();
            } else {
                JOptionPane.showMessageDialog(null, "Ponte en contacto con el administrador para que habilite tu cuenta.", "SIET - ACCESO DENEGADO", JOptionPane.ERROR_MESSAGE);
            }
        } catch (final HeadlessException | PropertyVetoException exception) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, exception);
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JMENUITEMVerPersonalTecnicoActionPerformed

    private void JMENUITEMEspecialidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMEspecialidadesActionPerformed
        try {
            if (cuenta.getPersonalTecnico().getPertecHabilitado()) {
                final GestionEspecialidades gestionEspecialidades = new GestionEspecialidades();
                DSKPContenedor.removeAll();
                DSKPContenedor.updateUI();
                DSKPContenedor.add(gestionEspecialidades);
                gestionEspecialidades.setMaximum(true);
                gestionEspecialidades.show();
            } else {
                JOptionPane.showMessageDialog(null, "Ponte en contacto con el administrador para que habilite tu cuenta.", "SIET - ACCESO DENEGADO", JOptionPane.ERROR_MESSAGE);
            }
        } catch (final HeadlessException | PropertyVetoException exception) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, exception);
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JMENUITEMEspecialidadesActionPerformed

    private void JMENUITEMSubespecialidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMSubespecialidadesActionPerformed
        try {
            if (cuenta.getPersonalTecnico().getPertecHabilitado()) {
                final GestionSubespecialidades gestionSubespecialidades = new GestionSubespecialidades();
                DSKPContenedor.removeAll();
                DSKPContenedor.updateUI();
                DSKPContenedor.add(gestionSubespecialidades);
                gestionSubespecialidades.setMaximum(true);
                gestionSubespecialidades.show();
            } else {
                JOptionPane.showMessageDialog(null, "Ponte en contacto con el administrador para que habilite tu cuenta.", "SIET - ACCESO DENEGADO", JOptionPane.ERROR_MESSAGE);
            }
        } catch (final HeadlessException | PropertyVetoException exception) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, exception);
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JMENUITEMSubespecialidadesActionPerformed

    private void JMENUITEMExamenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMExamenesActionPerformed
        try {
            if (cuenta.getPersonalTecnico().getPertecHabilitado()) {
                final GestionExamenes gestionExamenes = new GestionExamenes();
                DSKPContenedor.removeAll();
                DSKPContenedor.updateUI();
                DSKPContenedor.add(gestionExamenes);
                gestionExamenes.setMaximum(true);
                gestionExamenes.show();
            } else {
                JOptionPane.showMessageDialog(null, "Ponte en contacto con el administrador para que habilite tu cuenta.", "SIET - ACCESO DENEGADO", JOptionPane.ERROR_MESSAGE);
            }
        } catch (final HeadlessException | PropertyVetoException exception) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, exception);
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JMENUITEMExamenesActionPerformed

    private void JMENUITEMMuestrasBiologicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMMuestrasBiologicasActionPerformed
        try {
            if (cuenta.getPersonalTecnico().getPertecHabilitado()) {
                final GestionMuestrasBiologicas gestionMuestrasBiologicas = new GestionMuestrasBiologicas();
                DSKPContenedor.removeAll();
                DSKPContenedor.updateUI();
                DSKPContenedor.add(gestionMuestrasBiologicas);
                gestionMuestrasBiologicas.setMaximum(true);
                gestionMuestrasBiologicas.show();
            } else {
                JOptionPane.showMessageDialog(null, "Ponte en contacto con el administrador para que habilite tu cuenta.", "SIET - ACCESO DENEGADO", JOptionPane.ERROR_MESSAGE);
            }
        } catch (final HeadlessException | PropertyVetoException exception) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, exception);
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JMENUITEMMuestrasBiologicasActionPerformed

    private void JMENUITEMEquiposActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMEquiposActivosActionPerformed
        try {
            if (cuenta.getPersonalTecnico().getPertecHabilitado()) {
                final GestionEquiposActivos gestionEquiposActivos = new GestionEquiposActivos();
                DSKPContenedor.removeAll();
                DSKPContenedor.updateUI();
                DSKPContenedor.add(gestionEquiposActivos);
                gestionEquiposActivos.setMaximum(true);
                gestionEquiposActivos.show();
            } else {
                JOptionPane.showMessageDialog(null, "Ponte en contacto con el administrador para que habilite tu cuenta.", "SIET - ACCESO DENEGADO", JOptionPane.ERROR_MESSAGE);
            }
        } catch (final HeadlessException | PropertyVetoException exception) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, exception);
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JMENUITEMEquiposActivosActionPerformed

    private void JMENUITEMEquiposEnIntervencionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMEquiposEnIntervencionActionPerformed
        try {
            if (cuenta.getPersonalTecnico().getPertecHabilitado()) {
                final GestionEquiposIntervencion gestionEquiposIntervencion = new GestionEquiposIntervencion();
                DSKPContenedor.removeAll();
                DSKPContenedor.updateUI();
                DSKPContenedor.add(gestionEquiposIntervencion);
                gestionEquiposIntervencion.setMaximum(true);
                gestionEquiposIntervencion.show();
            } else {
                JOptionPane.showMessageDialog(null, "Ponte en contacto con el administrador para que habilite tu cuenta.", "SIET - ACCESO DENEGADO", JOptionPane.ERROR_MESSAGE);
            }
        } catch (final HeadlessException | PropertyVetoException exception) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, exception);
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JMENUITEMEquiposEnIntervencionActionPerformed

    private void JMENUITEMEquiposDadosDeBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMEquiposDadosDeBajaActionPerformed
        try {
            if (cuenta.getPersonalTecnico().getPertecHabilitado()) {
                final GestionEquiposEliminados gestionEquiposDadosBaja = new GestionEquiposEliminados();
                DSKPContenedor.removeAll();
                DSKPContenedor.updateUI();
                DSKPContenedor.add(gestionEquiposDadosBaja);
                gestionEquiposDadosBaja.setMaximum(true);
                gestionEquiposDadosBaja.show();
            } else {
                JOptionPane.showMessageDialog(null, "Ponte en contacto con el administrador para que habilite tu cuenta.", "SIET - ACCESO DENEGADO", JOptionPane.ERROR_MESSAGE);
            }
        } catch (final HeadlessException | PropertyVetoException exception) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, exception);
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JMENUITEMEquiposDadosDeBajaActionPerformed

    private void JMENUITEMVerPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerPacientesActionPerformed
        try {
            if (cuenta.getPersonalTecnico().getPertecHabilitado()) {
                final GestionPacientes gestionPacientes = new GestionPacientes();
                DSKPContenedor.removeAll();
                DSKPContenedor.updateUI();
                DSKPContenedor.add(gestionPacientes);
                gestionPacientes.setMaximum(true);
                gestionPacientes.show();
            } else {
                JOptionPane.showMessageDialog(null, "Ponte en contacto con el administrador para que habilite tu cuenta.", "SIET - ACCESO DENEGADO", JOptionPane.ERROR_MESSAGE);
            }
        } catch (final HeadlessException | PropertyVetoException exception) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, exception);
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JMENUITEMVerPacientesActionPerformed

    private void JMENUITEMCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMCerrarSesionActionPerformed
        try {
            final File file = new File("siet-user-information.encrypted");

            if (file.exists()) {
                if (file.delete()) {
                    final IniciarSesion iniciarSesion = new IniciarSesion();
                    iniciarSesion.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(jMenu1, "No se pudo eliminar el archivo \"siet-user-information.encrypted\".");
                }
            } else {
                final IniciarSesion iniciarSesion = new IniciarSesion();
                iniciarSesion.setVisible(true);
                dispose();
            }
        } catch (final HeadlessException headlessException) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, headlessException);
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JMENUITEMCerrarSesionActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            final File file = new File("siet-user-information.encrypted");

            if (file.exists()) {
                final String key = "gPyaP,;)9EbW}Gl@";
                final File decryptedFile = new File("siet-user-information.xml");
                CryptoUtils.decrypt(key, file, decryptedFile);

                final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                final Document document = documentBuilder.parse(decryptedFile);

                final boolean mantenerSesionIniciada = Boolean.parseBoolean(document.getElementsByTagName("MANTENER_SESION_INICIADA").item(0).getTextContent());

                if (mantenerSesionIniciada) {
                    if (decryptedFile.exists()) {
                        decryptedFile.delete();
                    }
                } else {
                    if (decryptedFile.exists()) {
                        decryptedFile.delete();
                        if (file.exists()) {
                            file.delete();
                        }
                    } else if (file.exists()) {
                        file.delete();
                    }
                }
            }
        } catch (final ParserConfigurationException | SAXException | IOException | CryptoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void JMENUITEMEstablecimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMEstablecimientosActionPerformed
        try {
            if (cuenta.getPersonalTecnico().getPertecHabilitado()) {
                final GestionEstablecimientos gestionEstablecimientos = new GestionEstablecimientos();
                DSKPContenedor.removeAll();
                DSKPContenedor.updateUI();
                DSKPContenedor.add(gestionEstablecimientos);
                gestionEstablecimientos.setMaximum(true);
                gestionEstablecimientos.show();
            } else {
                JOptionPane.showMessageDialog(null, "Ponte en contacto con el administrador para que habilite tu cuenta.", "SIET - ACCESO DENEGADO", JOptionPane.ERROR_MESSAGE);
            }
        } catch (final HeadlessException | PropertyVetoException exception) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, exception);
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JMENUITEMEstablecimientosActionPerformed

    private void JMENUITEMReactivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMReactivosActionPerformed
        try {
            if (cuenta.getPersonalTecnico().getPertecHabilitado()) {
                final GestionReactivos gestionReactivos = new GestionReactivos();
                DSKPContenedor.removeAll();
                DSKPContenedor.updateUI();
                DSKPContenedor.add(gestionReactivos);
                gestionReactivos.setMaximum(true);
                gestionReactivos.show();
            } else {
                JOptionPane.showMessageDialog(null, "Ponte en contacto con el administrador para que habilite tu cuenta.", "SIET - ACCESO DENEGADO", JOptionPane.ERROR_MESSAGE);
            }
        } catch (final HeadlessException | PropertyVetoException exception) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, exception);
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JMENUITEMReactivosActionPerformed

    private void JMENUITEMEntregasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMEntregasActionPerformed
        try {
            if (cuenta.getPersonalTecnico().getPertecHabilitado()) {
                final EntregasReactivos entregasReactivos = new EntregasReactivos();
                DSKPContenedor.removeAll();
                DSKPContenedor.updateUI();
                DSKPContenedor.add(entregasReactivos);
                entregasReactivos.setMaximum(true);
                entregasReactivos.show();
            } else {
                JOptionPane.showMessageDialog(null, "Ponte en contacto con el administrador para que habilite tu cuenta.", "SIET - ACCESO DENEGADO", JOptionPane.ERROR_MESSAGE);
            }
        } catch (final HeadlessException | PropertyVetoException exception) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, exception);
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JMENUITEMEntregasActionPerformed

    private void JMENUITEMVerInformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerInformacionActionPerformed
        final DetallesPersonalTecnico detallesPersonalTecnico = new DetallesPersonalTecnico(null, true);
        detallesPersonalTecnico.setCuenta(cuenta);
        detallesPersonalTecnico.setVisible(true);
    }//GEN-LAST:event_JMENUITEMVerInformacionActionPerformed

    private void JMENUITEMCambiarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMCambiarPasswordActionPerformed
        final CambiarPassword cambiarPassword = new CambiarPassword(null, true);
        cambiarPassword.setCuenta(cuenta);
        cambiarPassword.setVisible(true);
    }//GEN-LAST:event_JMENUITEMCambiarPasswordActionPerformed

    private void JMENUITEMModificarInformacaionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMModificarInformacaionActionPerformed
        final ModificarInformacion modificarInformacion = new ModificarInformacion(null, true);
        modificarInformacion.setCuenta(cuenta);
        modificarInformacion.setVisible(true);
    }//GEN-LAST:event_JMENUITEMModificarInformacaionActionPerformed

    private void JMENUITEMInformeMensualLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMInformeMensualLaboratorioActionPerformed
        final InformeMensualLaboratorio informeMensualLaboratorio = new InformeMensualLaboratorio(null, true);
        informeMensualLaboratorio.setVisible(true);
    }//GEN-LAST:event_JMENUITEMInformeMensualLaboratorioActionPerformed

    private void JMENUITEMConexionBaseDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMConexionBaseDatosActionPerformed
        final ConexionBaseDatos conexionBaseDatos = new ConexionBaseDatos(null, true);
        conexionBaseDatos.setVisible(true);
    }//GEN-LAST:event_JMENUITEMConexionBaseDatosActionPerformed

    private void JMENUITEMManualUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMManualUsuarioActionPerformed
        final ManualUsuario manualUsuario = new ManualUsuario(null, true);
        manualUsuario.setVisible(true);
    }//GEN-LAST:event_JMENUITEMManualUsuarioActionPerformed

    private void JMENUITEMGenerarCopiaSeguridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMGenerarCopiaSeguridadActionPerformed
        try {
            final GenerarCopiaSeguridad generarBackup = new GenerarCopiaSeguridad(null, true);
            generarBackup.setVisible(true);
        } catch (final Exception exception) {
            System.err.println("Error: " + exception.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JMENUITEMGenerarCopiaSeguridadActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Principal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DSKPContenedor;
    private javax.swing.JLabel JLBLEstadoCuenta;
    private javax.swing.JLabel JLBLRolCuenta;
    private javax.swing.JLabel JLBLUsuario;
    private javax.swing.JMenu JMENUEquipos;
    private javax.swing.JMenu JMENUEstudios;
    private javax.swing.JMenuItem JMENUITEMCambiarPassword;
    private javax.swing.JMenuItem JMENUITEMCerrarSesion;
    private javax.swing.JMenuItem JMENUITEMConexionBaseDatos;
    private javax.swing.JMenuItem JMENUITEMEntregas;
    private javax.swing.JMenuItem JMENUITEMEquiposActivos;
    private javax.swing.JMenuItem JMENUITEMEquiposDadosDeBaja;
    private javax.swing.JMenuItem JMENUITEMEquiposEnIntervencion;
    private javax.swing.JMenuItem JMENUITEMEspecialidades;
    private javax.swing.JMenuItem JMENUITEMEstablecimientos;
    private javax.swing.JMenuItem JMENUITEMExamenes;
    private javax.swing.JMenuItem JMENUITEMGenerarCopiaSeguridad;
    private javax.swing.JMenuItem JMENUITEMInformeMensualLaboratorio;
    private javax.swing.JMenuItem JMENUITEMManualUsuario;
    private javax.swing.JMenuItem JMENUITEMModificarInformacaion;
    private javax.swing.JMenuItem JMENUITEMMuestrasBiologicas;
    private javax.swing.JMenuItem JMENUITEMNuevaRecepcion;
    private javax.swing.JMenuItem JMENUITEMReactivos;
    private javax.swing.JMenuItem JMENUITEMSubespecialidades;
    private javax.swing.JMenuItem JMENUITEMVerInformacion;
    private javax.swing.JMenuItem JMENUITEMVerPacientes;
    private javax.swing.JMenuItem JMENUITEMVerPersonalTecnico;
    private javax.swing.JMenuItem JMENUITEMVerRecepciones;
    private javax.swing.JMenu JMENULaboratorio;
    private javax.swing.JMenu JMENUPacientes;
    private javax.swing.JMenu JMENUPersonalTecnico;
    private javax.swing.JMenu JMENUReportes;
    private javax.swing.JMenu JMENURespaldoBaseDatos;
    private javax.swing.JMenu JMENURespaldos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}