package View.GestionRecepciones;

import Model.POJO.PersonalTecnico;
import Model.POJO.Paciente;
import Model.POJO.Persona;
import Model.POJO.Recepcion;
import Model.POJOPersonalizado.ExamenSolicitadoPersonalizado;
import Presenter.GestionRecepciones.PresenterGestionRecepciones;
import View.Utilitarios.ModelTable.GestionRecepciones.TableModelDetallesRecepciones;
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
public class VerDetallesRecepcion extends javax.swing.JDialog implements PresenterGestionRecepciones.CallBackObtenerExamenesSolicitados {

    private final PresenterGestionRecepciones presenterGestionRecepciones;
    private final TableModelDetallesRecepciones tableModelDetallesRecepciones;

    private boolean habilitarModificacion;

    private Recepcion recepcion;

    public VerDetallesRecepcion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        presenterGestionRecepciones = new PresenterGestionRecepciones();
        presenterGestionRecepciones.setCallBackObtenerExamenesSolicitados(this);

        tableModelDetallesRecepciones = new TableModelDetallesRecepciones();

        habilitarModificacion = false;

        initComponents();
    }

    public void setHabilitarModificacion(boolean habilitarModificacion) {
        this.habilitarModificacion = habilitarModificacion;
    }

    public void setRecepcion(Recepcion recepcion) {
        this.recepcion = recepcion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemExamenSolicitado = new javax.swing.JPopupMenu();
        JMENUITEMIngresarResultados = new javax.swing.JMenuItem();
        JMENUITEMIniciarSeguimiento = new javax.swing.JMenuItem();
        JSEPARATOR1 = new javax.swing.JPopupMenu.Separator();
        JMENUITEMVerResultadosIngresados = new javax.swing.JMenuItem();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        JLBLCedulaIdentidad = new javax.swing.JLabel();
        JLBLApellido = new javax.swing.JLabel();
        JLBLNombre = new javax.swing.JLabel();
        JLBLSexo = new javax.swing.JLabel();
        JLBLPacienteEdad = new javax.swing.JLabel();
        JLBLPacienteFechaNacimiento = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        JLBLMujerEmbarazada = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JLBLMujerParto = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JLBLMujerPostParto = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JLBLNumeroDiasSintomas = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        JLBLFechaProcesamiento = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        JLBLHoraRecepcion = new javax.swing.JLabel();
        JLBLFechaRecepcion = new javax.swing.JLabel();
        JLBLEstablecimiento = new javax.swing.JLabel();
        JLBLSolicitante = new javax.swing.JLabel();
        JLBLRecepcionista = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        JLBLCodigoRegistroLaboratorio = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLExamenes = new javax.swing.JTable();
        JBTNActualizar = new javax.swing.JButton();
        JBTNAceptar = new javax.swing.JButton();

        JMENUITEMIngresarResultados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/modificar_password.png"))); // NOI18N
        JMENUITEMIngresarResultados.setText("Ingresar Resultados");
        JMENUITEMIngresarResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMIngresarResultadosActionPerformed(evt);
            }
        });
        JPOPUPMENUItemExamenSolicitado.add(JMENUITEMIngresarResultados);

        JMENUITEMIniciarSeguimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/iniciar.png"))); // NOI18N
        JMENUITEMIniciarSeguimiento.setText("Iniciar Seguimiento");
        JMENUITEMIniciarSeguimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMIniciarSeguimientoActionPerformed(evt);
            }
        });
        JPOPUPMENUItemExamenSolicitado.add(JMENUITEMIniciarSeguimiento);
        JPOPUPMENUItemExamenSolicitado.add(JSEPARATOR1);

        JMENUITEMVerResultadosIngresados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_detalles_recepcion.png"))); // NOI18N
        JMENUITEMVerResultadosIngresados.setText("Ver Resultados Ingresados");
        JMENUITEMVerResultadosIngresados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerResultadosIngresadosActionPerformed(evt);
            }
        });
        JPOPUPMENUItemExamenSolicitado.add(JMENUITEMVerResultadosIngresados);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Detalles de Recepción");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Paciente"));

        jLabel1.setText("CEDULA DE IDENTIDAD:");

        jLabel2.setText("APELLIDO(S):");

        jLabel3.setText("NOMBRE(S):");

        jLabel4.setText("SEXO:");

        jLabel14.setText("EDAD:");

        JLBLCedulaIdentidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLApellido.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLSexo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLPacienteEdad.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLPacienteFechaNacimiento.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel17.setText("FEC. NACIMIENTO:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(JLBLCedulaIdentidad, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(JLBLApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(JLBLNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(JLBLSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLBLPacienteFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(JLBLPacienteEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLCedulaIdentidad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLBLPacienteFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLBLPacienteEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Paciente"));

        jLabel5.setText("¿MUJER EMBARAZADA?");

        JLBLMujerEmbarazada.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("¿PARTO?");

        JLBLMujerParto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setText("¿POST PARTO?");

        JLBLMujerPostParto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("Nº DIAS DE SINTOMAS:");

        JLBLNumeroDiasSintomas.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setText("FEC. DE PROCESAMIENTO:");

        JLBLFechaProcesamiento.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(JLBLMujerEmbarazada, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(JLBLMujerParto, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(JLBLMujerPostParto, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(JLBLNumeroDiasSintomas, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(JLBLFechaProcesamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLMujerEmbarazada, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLMujerParto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLMujerPostParto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLNumeroDiasSintomas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLFechaProcesamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Recepción"));

        jLabel9.setText("RECEPCIONISTA:");

        jLabel10.setText("SOLICITADO POR:");

        jLabel11.setText("EST. DE SALUD:");

        jLabel12.setText("FECHA RECEPCION:");

        jLabel13.setText("HORA RECEPCION:");

        JLBLHoraRecepcion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLFechaRecepcion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLEstablecimiento.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLSolicitante.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLRecepcionista.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setText("NUMERO DE REGISTRO DE LABORATORIO:");

        JLBLCodigoRegistroLaboratorio.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(JLBLFechaRecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLBLHoraRecepcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(JLBLCodigoRegistroLaboratorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(JLBLRecepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(JLBLSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(JLBLEstablecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLRecepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLEstablecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLBLFechaRecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLBLHoraRecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLCodigoRegistroLaboratorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Exámenes Solicitados"));

        JTBLExamenes.setModel(tableModelDetallesRecepciones);
        JTBLExamenes.setComponentPopupMenu(JPOPUPMENUItemExamenSolicitado);
        JTBLExamenes.setRowHeight(20);
        JTBLExamenes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTBLExamenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLExamenesMousePressed(evt);
            }
        });
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLExamenes.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
        JTBLExamenes.getColumnModel().getColumn(3).setCellRenderer(defaultTableCellRenderer);
        JTBLExamenes.getColumnModel().getColumn(5).setCellRenderer(defaultTableCellRenderer);

        JTBLExamenes.getColumnModel().getColumn(0).setPreferredWidth(40);
        JTBLExamenes.getColumnModel().getColumn(1).setPreferredWidth(350);
        JTBLExamenes.getColumnModel().getColumn(2).setPreferredWidth(150);
        JTBLExamenes.getColumnModel().getColumn(3).setPreferredWidth(150);
        JTBLExamenes.getColumnModel().getColumn(4).setPreferredWidth(180);
        JTBLExamenes.getColumnModel().getColumn(5).setPreferredWidth(150);
        jScrollPane1.setViewportView(JTBLExamenes);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addContainerGap())
        );

        JBTNActualizar.setText("ACTUALIZAR");
        JBTNActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNActualizarActionPerformed(evt);
            }
        });

        JBTNAceptar.setText("ACEPTAR");
        JBTNAceptar.setToolTipText("");
        JBTNAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBTNActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBTNAceptar))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNActualizar)
                    .addComponent(JBTNAceptar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            if (recepcion == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                if (!habilitarModificacion) {
                    JMENUITEMIngresarResultados.setEnabled(false);
                    JMENUITEMIngresarResultados.setVisible(false);
                    JSEPARATOR1.setVisible(false);
                    JMENUITEMIniciarSeguimiento.setEnabled(false);
                    JMENUITEMIniciarSeguimiento.setVisible(false);
                }

                final Paciente paciente = recepcion.getPaciente();
                final Persona persona = paciente.getPersona();
                final PersonalTecnico bioquimicoRecepcionista = recepcion.getPersonalTecnico();
                final Persona personaRecepcionista = bioquimicoRecepcionista.getPersona();

                JLBLCedulaIdentidad.setText(persona.getPersonaCedulaIdentidad());
                JLBLApellido.setText(persona.getPersonaApellido());
                JLBLNombre.setText(persona.getPersonaNombre());
                JLBLPacienteFechaNacimiento.setText(paciente.getPacienteFechaNacimiento().toString());
                JLBLPacienteEdad.setText(String.valueOf(recepcion.getEdadPacienteYears() + " Años " + recepcion.getEdadPacienteMeses() + " Meses " + recepcion.getEdadPacienteDias() + " Días"));
                JLBLSexo.setText(persona.getPersonaSexo().equals("M") ? "MASCULINO" : "FEMENINO");
                JLBLMujerEmbarazada.setText(recepcion.isMujerEmbarazada() ? "SI" : "NO");
                JLBLMujerParto.setText(recepcion.isMujerParto() ? "SI" : "NO");
                JLBLMujerPostParto.setText(recepcion.isMujerPostParto() ? "SI" : "NO");
                JLBLNumeroDiasSintomas.setText(recepcion.getNumeroDiasSintomas() == 0 ? "" : String.valueOf(recepcion.getNumeroDiasSintomas()));
                JLBLFechaProcesamiento.setText(recepcion.getFechaProcesamiento() == null ? "" : recepcion.getFechaProcesamiento().toString());
                JLBLRecepcionista.setText(personaRecepcionista.getPersonaApellido() + " " + personaRecepcionista.getPersonaNombre());
                JLBLSolicitante.setText(recepcion.getSolicitante());
                JLBLEstablecimiento.setText(recepcion.getEstablecimiento().getEstablecimientoNombre());
                JLBLFechaRecepcion.setText(recepcion.getFechaRecepcion().toString());
                JLBLHoraRecepcion.setText(recepcion.getHoraRecepcion().toString());
                JLBLCodigoRegistroLaboratorio.setText(recepcion.getCodigoRegistroLaboratorio());

                presenterGestionRecepciones.obtenerExamenesSolicitados(recepcion);
            }
        } catch (final HeadlessException ex) {
            System.err.println("Se produjo un error: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTBLExamenesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLExamenesMousePressed
        final int currentRow = JTBLExamenes.rowAtPoint(evt.getPoint());
        JTBLExamenes.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLExamenesMousePressed

    private void JBTNActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_JBTNActualizarActionPerformed

    private void JBTNAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNAceptarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNAceptarActionPerformed

    private void JMENUITEMIngresarResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMIngresarResultadosActionPerformed
        if (obtenerExamenSolicitadoPersonalizadoSeleccionado().getExamenSolicitado().getMuestraBiologicaEstado().equals("REFERIDO POR EL LABORATORIO")) {
            JOptionPane.showMessageDialog(rootPane, "No se puede ingresar resultados a este examen por que fue REFERIDO POR EL LABORATORIO.", "SIET", JOptionPane.ERROR_MESSAGE);
        } else {
            if (obtenerExamenSolicitadoPersonalizadoSeleccionado().getExamenSolicitado().getTotalMuestrasBiologicas() == obtenerExamenSolicitadoPersonalizadoSeleccionado().getTotalResultadosIngresados()) {
                JOptionPane.showMessageDialog(rootPane, "Ya no se puede ingresar mas resultados.", "SIET", JOptionPane.ERROR_MESSAGE);
            } else {
                final IngresarResultados ingresarResultados = new IngresarResultados(null, true);
                ingresarResultados.setExamenSolicitado(obtenerExamenSolicitadoPersonalizadoSeleccionado().getExamenSolicitado());
                ingresarResultados.setVisible(true);

                if (!ingresarResultados.isVisible()) {
                    actualizarTabla();
                }
            }
        }
    }//GEN-LAST:event_JMENUITEMIngresarResultadosActionPerformed

    private void JMENUITEMVerResultadosIngresadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerResultadosIngresadosActionPerformed
        final VerResultadosIngresados verResultadosIngresado = new VerResultadosIngresados(null, true);
        verResultadosIngresado.setHabilitarModificacion(habilitarModificacion);
        verResultadosIngresado.setExamenSolicitado(obtenerExamenSolicitadoPersonalizadoSeleccionado().getExamenSolicitado());
        verResultadosIngresado.setVisible(true);
    }//GEN-LAST:event_JMENUITEMVerResultadosIngresadosActionPerformed

    private void JMENUITEMIniciarSeguimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMIniciarSeguimientoActionPerformed
        final ExamenSolicitadoPersonalizado examenSolicitadoPersonalizado = obtenerExamenSolicitadoPersonalizadoSeleccionado();

        if (examenSolicitadoPersonalizado.getExamenSolicitado().getExamen().getExamenNombre().endsWith("BACILOSCOPIA")) {
            if (examenSolicitadoPersonalizado.getExamenSolicitado().getMuestraBiologicaEstado().equals("REFERIDO POR EL LABORATORIO")) {
                JOptionPane.showMessageDialog(rootPane, "No se puede iniciar un seguimiento a este examen por que fue REFERIDO POR EL LABORATORIO.", "SIET", JOptionPane.ERROR_MESSAGE);
            } else {
                if (examenSolicitadoPersonalizado.getTotalResultadosIngresados() < examenSolicitadoPersonalizado.getExamenSolicitado().getTotalMuestrasBiologicas()) {
                    JOptionPane.showMessageDialog(rootPane, "No se puede iniciar un seguimiento mientras no se carguen resultados.", "SIET", JOptionPane.ERROR_MESSAGE);
                } else {
                    final IniciarSeguimiento iniciarSeguimiento = new IniciarSeguimiento(null, true);
                    iniciarSeguimiento.setExamenSolicitado(examenSolicitadoPersonalizado.getExamenSolicitado());
                    iniciarSeguimiento.setVisible(true);
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "No se permiten realizar seguimientos en este examen.", "SIET", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JMENUITEMIniciarSeguimientoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            VerDetallesRecepcion dialog = new VerDetallesRecepcion(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNAceptar;
    private javax.swing.JButton JBTNActualizar;
    private javax.swing.JLabel JLBLApellido;
    private javax.swing.JLabel JLBLCedulaIdentidad;
    private javax.swing.JLabel JLBLCodigoRegistroLaboratorio;
    private javax.swing.JLabel JLBLEstablecimiento;
    private javax.swing.JLabel JLBLFechaProcesamiento;
    private javax.swing.JLabel JLBLFechaRecepcion;
    private javax.swing.JLabel JLBLHoraRecepcion;
    private javax.swing.JLabel JLBLMujerEmbarazada;
    private javax.swing.JLabel JLBLMujerParto;
    private javax.swing.JLabel JLBLMujerPostParto;
    private javax.swing.JLabel JLBLNombre;
    private javax.swing.JLabel JLBLNumeroDiasSintomas;
    private javax.swing.JLabel JLBLPacienteEdad;
    private javax.swing.JLabel JLBLPacienteFechaNacimiento;
    private javax.swing.JLabel JLBLRecepcionista;
    private javax.swing.JLabel JLBLSexo;
    private javax.swing.JLabel JLBLSolicitante;
    private javax.swing.JMenuItem JMENUITEMIngresarResultados;
    private javax.swing.JMenuItem JMENUITEMIniciarSeguimiento;
    private javax.swing.JMenuItem JMENUITEMVerResultadosIngresados;
    private javax.swing.JPopupMenu JPOPUPMENUItemExamenSolicitado;
    private javax.swing.JPopupMenu.Separator JSEPARATOR1;
    private javax.swing.JTable JTBLExamenes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void actualizarTabla() {
        tableModelDetallesRecepciones.limpiarLista();
        presenterGestionRecepciones.obtenerExamenesSolicitados(recepcion);
    }

    private ExamenSolicitadoPersonalizado obtenerExamenSolicitadoPersonalizadoSeleccionado() {
        final int rowModel = JTBLExamenes.convertRowIndexToModel(JTBLExamenes.getSelectedRow());
        return tableModelDetallesRecepciones.getExamenSolicitadoPersonalizado(rowModel);
    }

    @Override
    public void examenesSolicitadosObtenidos(final List<ExamenSolicitadoPersonalizado> examenesSolicitadosPersonalizados) {
        tableModelDetallesRecepciones.setExamenesSolicitadosPersonalizados(examenesSolicitadosPersonalizados);
        JTBLExamenes.getTableHeader().setReorderingAllowed(false);
    }

    @Override
    public void listaExamenesSolicitadosVacia(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorObtenerExamenesSolicitados(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerExamenesSolicitados(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}