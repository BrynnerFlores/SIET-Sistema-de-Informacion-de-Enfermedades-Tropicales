package View.GestionEquipos.GestionEquiposActivos;

import Model.POJO.PersonalTecnico;
import Model.POJO.Equipo;
import Model.POJO.Subespecialidad;
import Model.POJOPersonalizado.SubespecialidadPersonalizada;
import Presenter.GestionEquipos.PresenterGestionEquipos;
import Presenter.GestionSubespecialidades.PresenterGestionSubespecialidades;
import View.Utilitarios.Utilidades;
import View.Utilitarios.ModeloItemComboBox.ItemSubespecialidad;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Brynner
 */
public class RegistrarEquipo extends javax.swing.JDialog implements PresenterGestionSubespecialidades.CallBackObtenerSubespecialidades, PresenterGestionEquipos.CallBackVerificarExistenciaEquipo, PresenterGestionEquipos.CallBackRegistrarEquipo {

    public static ImageIcon equipoFoto;
    public static boolean fotoCambiada;
    private final PresenterGestionSubespecialidades presenterGestionSubespecialidades;
    private final PresenterGestionEquipos presenterGestionEquipos;
    private final PersonalTecnico personalTecnicoAdministrador;

    public RegistrarEquipo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();

        presenterGestionSubespecialidades = new PresenterGestionSubespecialidades();
        presenterGestionEquipos = new PresenterGestionEquipos();
        presenterGestionSubespecialidades.setCallBackObtenerSubespecialidades(this);
        presenterGestionEquipos.setCallBackVerificarExistenciaEquipo(this);
        presenterGestionEquipos.setCallBackRegistrarEquipo(this);

        personalTecnicoAdministrador = Utilidades.obtenerCuentaLocal().getPersonalTecnico();

        JTXTFEquipoNombre.addActionListener(action);
        JTXTFEquipoMarca.addActionListener(action);
        JTXTFEquipoModelo.addActionListener(action);
        JTXTFEquipoNumeroSerie.addActionListener(action);
        JTXTFEquipoResponsableEntrega.addActionListener(action);
        JTXTFEquipoProveedor.addActionListener(action);
        JTXTFEquipoGarantia.addActionListener(action);
        JBTNRegistrar.addActionListener(action);
        equipoFoto = new ImageIcon(new ImageIcon(getClass().getResource("/View/icons/placeholder.png")).getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
        fotoCambiada = false;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTXTAREAEquipoObservaciones = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        JBTNCancelar = new javax.swing.JButton();
        JBTNRegistrar = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        JLBLContadorEquipoObservaciones = new javax.swing.JLabel();
        JLBLEquipoResponsable = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        JTXTFEquipoNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JTXTFEquipoMarca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JTXTFEquipoModelo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JTXTFEquipoNumeroSerie = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        JDATECHOOSEREquipoFechaAdquisicion = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        JTXTFEquipoProveedor = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        JTXTFEquipoResponsableEntrega = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        JTXTFEquipoGarantia = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        JCMBXAreaServicio = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        JLBLContadorEquipoNombre = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        JLBLContadorEquipoMarca = new javax.swing.JLabel();
        JLBLContadorEquipoModelo = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        JLBLContadorEquipoNumeroSerie = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        JLBLContadorEquipoProveedor = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        JLBLContadorEquipoResponsableEntrega = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        JLBLContadorEquipoTiempoGarantia = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        JBTNAbrirCamara = new javax.swing.JButton();
        JBTNAbrirGaleria = new javax.swing.JButton();
        JBTNEliminarFoto = new javax.swing.JButton();
        JCMBXEquipoIntegridad = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        JCMBXEquipoUbicacion = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        JLBLEquipoFoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Registrar Equipo");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registrar Nuevo Equipo"));

        jLabel13.setText("OBSERVACIONES:");

        JTXTAREAEquipoObservaciones.setColumns(20);
        JTXTAREAEquipoObservaciones.setLineWrap(true);
        JTXTAREAEquipoObservaciones.setRows(5);
        JTXTAREAEquipoObservaciones.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTAREAEquipoObservacionesFocusGained(evt);
            }
        });
        JTXTAREAEquipoObservaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTXTAREAEquipoObservacionesKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTAREAEquipoObservacionesKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTAREAEquipoObservacionesKeyTyped(evt);
            }
        });
        JTXTAREAEquipoObservaciones.setTransferHandler(null);
        JTXTAREAEquipoObservaciones.getDocument().putProperty("filterNewlines", Boolean.TRUE);
        jScrollPane1.setViewportView(JTXTAREAEquipoObservaciones);

        jLabel11.setText("RESPONSABLE:");

        JBTNCancelar.setText("CANCELAR");
        JBTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarActionPerformed(evt);
            }
        });

        JBTNRegistrar.setText("REGISTRAR");

        jLabel22.setText("/150");

        JLBLContadorEquipoObservaciones.setText("0");

        JLBLEquipoResponsable.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("NOMBRE:");

        JTXTFEquipoNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFEquipoNombreFocusGained(evt);
            }
        });
        JTXTFEquipoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFEquipoNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFEquipoNombreKeyTyped(evt);
            }
        });
        JTXTFEquipoNombre.setTransferHandler(null);

        jLabel2.setText("MARCA:");

        JTXTFEquipoMarca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFEquipoMarcaFocusGained(evt);
            }
        });
        JTXTFEquipoMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFEquipoMarcaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFEquipoMarcaKeyTyped(evt);
            }
        });
        JTXTFEquipoMarca.setTransferHandler(null);

        jLabel3.setText("MODELO:");

        JTXTFEquipoModelo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFEquipoModeloFocusGained(evt);
            }
        });
        JTXTFEquipoModelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFEquipoModeloKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFEquipoModeloKeyTyped(evt);
            }
        });
        JTXTFEquipoModelo.setTransferHandler(null);

        jLabel4.setText("SERIE:");

        JTXTFEquipoNumeroSerie.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFEquipoNumeroSerieFocusGained(evt);
            }
        });
        JTXTFEquipoNumeroSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFEquipoNumeroSerieKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFEquipoNumeroSerieKeyTyped(evt);
            }
        });
        JTXTFEquipoNumeroSerie.setTransferHandler(null);

        jLabel5.setText("FECHA DE ADQUISICION:");

        JDATECHOOSEREquipoFechaAdquisicion.setDate(Calendar.getInstance().getTime());
        JDATECHOOSEREquipoFechaAdquisicion.setDateFormatString("yyyy-MM-dd");
        JDATECHOOSEREquipoFechaAdquisicion.setMaxSelectableDate(Calendar.getInstance().getTime());

        jLabel6.setText("PROVEEDOR:");

        JTXTFEquipoProveedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFEquipoProveedorFocusGained(evt);
            }
        });
        JTXTFEquipoProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFEquipoProveedorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFEquipoProveedorKeyTyped(evt);
            }
        });
        JTXTFEquipoProveedor.setTransferHandler(null);

        jLabel12.setText("ENTREGADO POR:");

        JTXTFEquipoResponsableEntrega.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFEquipoResponsableEntregaFocusGained(evt);
            }
        });
        JTXTFEquipoResponsableEntrega.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFEquipoResponsableEntregaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFEquipoResponsableEntregaKeyTyped(evt);
            }
        });
        JTXTFEquipoResponsableEntrega.setTransferHandler(null);

        jLabel7.setText("TIEMPO DE GARANTIA (AÑOS):");

        JTXTFEquipoGarantia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFEquipoGarantiaFocusGained(evt);
            }
        });
        JTXTFEquipoGarantia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFEquipoGarantiaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFEquipoGarantiaKeyTyped(evt);
            }
        });
        JTXTFEquipoGarantia.setTransferHandler(null);

        jLabel10.setText("AREA DE SERVICIO:");

        jLabel15.setText("/50");

        JLBLContadorEquipoNombre.setText("0");

        jLabel16.setText("/20");

        JLBLContadorEquipoMarca.setText("0");

        JLBLContadorEquipoModelo.setText("0");

        jLabel17.setText("/20");

        JLBLContadorEquipoNumeroSerie.setText("0");

        jLabel18.setText("/20");

        JLBLContadorEquipoProveedor.setText("0");

        jLabel19.setText("/50");

        JLBLContadorEquipoResponsableEntrega.setText("0");

        jLabel20.setText("/50");

        JLBLContadorEquipoTiempoGarantia.setText("0");

        jLabel21.setText("/2");

        jLabel8.setText("FOTO DEL EQUIPO:");

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        JBTNAbrirCamara.setText("CAMARA");
        JBTNAbrirCamara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNAbrirCamaraActionPerformed(evt);
            }
        });
        jPanel2.add(JBTNAbrirCamara);

        JBTNAbrirGaleria.setText("GALERIA");
        JBTNAbrirGaleria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNAbrirGaleriaActionPerformed(evt);
            }
        });
        jPanel2.add(JBTNAbrirGaleria);

        JBTNEliminarFoto.setText("ELIMINAR");
        JBTNEliminarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNEliminarFotoActionPerformed(evt);
            }
        });
        jPanel2.add(JBTNEliminarFoto);

        JCMBXEquipoIntegridad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BUENO", "REGULAR", "MALO" }));
        JCMBXEquipoIntegridad.setSelectedIndex(-1);

        jLabel9.setText("INTEGRIDAD:");

        JCMBXEquipoUbicacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LABORATORIO", "ALMACEN" }));
        JCMBXEquipoUbicacion.setSelectedIndex(-1);

        jLabel14.setText("UBICACION:");

        JLBLEquipoFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLBLEquipoResponsable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JCMBXAreaServicio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JLBLContadorEquipoNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JLBLContadorEquipoMarca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JLBLContadorEquipoModelo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JLBLContadorEquipoNumeroSerie)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JLBLContadorEquipoProveedor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JLBLContadorEquipoResponsableEntrega)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JLBLContadorEquipoTiempoGarantia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21))
                            .addComponent(jLabel5)
                            .addComponent(jLabel10)
                            .addComponent(JTXTFEquipoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTXTFEquipoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTXTFEquipoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTXTFEquipoNumeroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JDATECHOOSEREquipoFechaAdquisicion, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTXTFEquipoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTXTFEquipoResponsableEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTXTFEquipoGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JCMBXEquipoIntegridad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JCMBXEquipoUbicacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel14))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(JLBLEquipoFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorEquipoObservaciones)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(JBTNCancelar)
                                .addGap(444, 444, 444)
                                .addComponent(JBTNRegistrar))
                            .addComponent(jLabel11))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel15)
                            .addComponent(JLBLContadorEquipoNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTXTFEquipoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel16)
                            .addComponent(JLBLContadorEquipoMarca))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTXTFEquipoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel17)
                            .addComponent(JLBLContadorEquipoModelo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTXTFEquipoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel18)
                            .addComponent(JLBLContadorEquipoNumeroSerie))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTXTFEquipoNumeroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JDATECHOOSEREquipoFechaAdquisicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel19)
                            .addComponent(JLBLContadorEquipoProveedor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTXTFEquipoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel20)
                            .addComponent(JLBLContadorEquipoResponsableEntrega))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTXTFEquipoResponsableEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel21)
                            .addComponent(JLBLContadorEquipoTiempoGarantia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTXTFEquipoGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JCMBXAreaServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLBLEquipoFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JCMBXEquipoUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JCMBXEquipoIntegridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLEquipoResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel22)
                    .addComponent(JLBLContadorEquipoObservaciones))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNCancelar)
                    .addComponent(JBTNRegistrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            if (personalTecnicoAdministrador == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                JLBLEquipoFoto.setIcon(equipoFoto);
                JLBLEquipoResponsable.setText(personalTecnicoAdministrador.getPersona().getPersonaApellido() + " " + personalTecnicoAdministrador.getPersona().getPersonaNombre());
                presenterGestionSubespecialidades.obtenerSubespecialidades();
            }
        } catch (final HeadlessException headlessException) {
            System.err.println("Error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(this, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTXTFEquipoNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFEquipoNombreKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9-. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFEquipoNombre.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFEquipoNombreKeyTyped

    private void JTXTFEquipoMarcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFEquipoMarcaKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFEquipoMarca.getText().length() >= 20) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFEquipoMarcaKeyTyped

    private void JTXTFEquipoModeloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFEquipoModeloKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9-/ ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFEquipoModelo.getText().length() >= 20) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFEquipoModeloKeyTyped

    private void JTXTFEquipoNumeroSerieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFEquipoNumeroSerieKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9-]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFEquipoNumeroSerie.getText().length() >= 20) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFEquipoNumeroSerieKeyTyped

    private void JTXTFEquipoProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFEquipoProveedorKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFEquipoProveedor.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFEquipoProveedorKeyTyped

    private void JTXTAREAEquipoObservacionesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREAEquipoObservacionesKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTAREAEquipoObservaciones.getText().length() >= 150) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTAREAEquipoObservacionesKeyTyped

    private void JBTNAbrirGaleriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNAbrirGaleriaActionPerformed
        try {
            final JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            final FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("*.PNG", "png");
            jFileChooser.setFileFilter(fileNameExtensionFilter);
            final int selection = jFileChooser.showOpenDialog(this);

            if (selection == JFileChooser.APPROVE_OPTION) {
                final File file = jFileChooser.getSelectedFile();
                final String pathImageCustom = file.getAbsolutePath();
                equipoFoto = new ImageIcon(new ImageIcon(pathImageCustom).getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
                JLBLEquipoFoto.setIcon(equipoFoto);
            }
        } catch (final HeadlessException exception) {
            System.err.println("Error Registrar Equipo: " + exception.getMessage());
            JOptionPane.showMessageDialog(this, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JBTNAbrirGaleriaActionPerformed

    private void JBTNEliminarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNEliminarFotoActionPerformed
        equipoFoto = new ImageIcon(new ImageIcon(getClass().getResource("/View/icons/placeholder.png")).getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
        JLBLEquipoFoto.setIcon(equipoFoto);
    }//GEN-LAST:event_JBTNEliminarFotoActionPerformed

    private void JBTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCancelarActionPerformed

    private void JTXTFEquipoGarantiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFEquipoGarantiaKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([0-9]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFEquipoGarantia.getText().length() >= 2) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFEquipoGarantiaKeyTyped

    private void JBTNAbrirCamaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNAbrirCamaraActionPerformed
        try {
            final Camara camara = new Camara(null, true);
            camara.setRegistrar(1);
            camara.setVisible(true);

            if (!camara.isVisible()) {
                if (fotoCambiada) {
                    JLBLEquipoFoto.setIcon(equipoFoto);
                }
            }
        } catch (final Exception exception) {
            System.err.println("Error: " + exception.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JBTNAbrirCamaraActionPerformed

    private void JTXTFEquipoResponsableEntregaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFEquipoResponsableEntregaKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFEquipoResponsableEntrega.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFEquipoResponsableEntregaKeyTyped

    private void JTXTFEquipoNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFEquipoNombreKeyReleased
        JLBLContadorEquipoNombre.setText(String.valueOf(JTXTFEquipoNombre.getText().length()));
    }//GEN-LAST:event_JTXTFEquipoNombreKeyReleased

    private void JTXTFEquipoMarcaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFEquipoMarcaKeyReleased
        JLBLContadorEquipoMarca.setText(String.valueOf(JTXTFEquipoMarca.getText().length()));
    }//GEN-LAST:event_JTXTFEquipoMarcaKeyReleased

    private void JTXTFEquipoModeloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFEquipoModeloKeyReleased
        JLBLContadorEquipoModelo.setText(String.valueOf(JTXTFEquipoModelo.getText().length()));
    }//GEN-LAST:event_JTXTFEquipoModeloKeyReleased

    private void JTXTFEquipoNumeroSerieKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFEquipoNumeroSerieKeyReleased
        JLBLContadorEquipoNumeroSerie.setText(String.valueOf(JTXTFEquipoNumeroSerie.getText().length()));
    }//GEN-LAST:event_JTXTFEquipoNumeroSerieKeyReleased

    private void JTXTFEquipoProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFEquipoProveedorKeyReleased
        JLBLContadorEquipoProveedor.setText(String.valueOf(JTXTFEquipoProveedor.getText().length()));
    }//GEN-LAST:event_JTXTFEquipoProveedorKeyReleased

    private void JTXTFEquipoResponsableEntregaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFEquipoResponsableEntregaKeyReleased
        JLBLContadorEquipoResponsableEntrega.setText(String.valueOf(JTXTFEquipoResponsableEntrega.getText().length()));
    }//GEN-LAST:event_JTXTFEquipoResponsableEntregaKeyReleased

    private void JTXTFEquipoGarantiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFEquipoGarantiaKeyReleased
        JLBLContadorEquipoTiempoGarantia.setText(String.valueOf(JTXTFEquipoGarantia.getText().length()));
    }//GEN-LAST:event_JTXTFEquipoGarantiaKeyReleased

    private void JTXTAREAEquipoObservacionesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREAEquipoObservacionesKeyReleased
        JLBLContadorEquipoObservaciones.setText(String.valueOf(JTXTAREAEquipoObservaciones.getText().length()));
    }//GEN-LAST:event_JTXTAREAEquipoObservacionesKeyReleased

    private void JTXTAREAEquipoObservacionesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREAEquipoObservacionesKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            evt.consume();
        }
    }//GEN-LAST:event_JTXTAREAEquipoObservacionesKeyPressed

    private void JTXTFEquipoNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFEquipoNombreFocusGained
        JTXTFEquipoNombre.selectAll();
    }//GEN-LAST:event_JTXTFEquipoNombreFocusGained

    private void JTXTFEquipoMarcaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFEquipoMarcaFocusGained
        JTXTFEquipoMarca.selectAll();
    }//GEN-LAST:event_JTXTFEquipoMarcaFocusGained

    private void JTXTFEquipoModeloFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFEquipoModeloFocusGained
        JTXTFEquipoModelo.selectAll();
    }//GEN-LAST:event_JTXTFEquipoModeloFocusGained

    private void JTXTFEquipoNumeroSerieFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFEquipoNumeroSerieFocusGained
        JTXTFEquipoNumeroSerie.selectAll();
    }//GEN-LAST:event_JTXTFEquipoNumeroSerieFocusGained

    private void JTXTFEquipoProveedorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFEquipoProveedorFocusGained
        JTXTFEquipoProveedor.selectAll();
    }//GEN-LAST:event_JTXTFEquipoProveedorFocusGained

    private void JTXTFEquipoResponsableEntregaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFEquipoResponsableEntregaFocusGained
        JTXTFEquipoResponsableEntrega.selectAll();
    }//GEN-LAST:event_JTXTFEquipoResponsableEntregaFocusGained

    private void JTXTFEquipoGarantiaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFEquipoGarantiaFocusGained
        JTXTFEquipoGarantia.selectAll();
    }//GEN-LAST:event_JTXTFEquipoGarantiaFocusGained

    private void JTXTAREAEquipoObservacionesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTAREAEquipoObservacionesFocusGained
        JTXTAREAEquipoObservaciones.selectAll();
    }//GEN-LAST:event_JTXTAREAEquipoObservacionesFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            RegistrarEquipo dialog = new RegistrarEquipo(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNAbrirCamara;
    private javax.swing.JButton JBTNAbrirGaleria;
    private javax.swing.JButton JBTNCancelar;
    private javax.swing.JButton JBTNEliminarFoto;
    private javax.swing.JButton JBTNRegistrar;
    private javax.swing.JComboBox<ItemSubespecialidad> JCMBXAreaServicio;
    private javax.swing.JComboBox<String> JCMBXEquipoIntegridad;
    private javax.swing.JComboBox<String> JCMBXEquipoUbicacion;
    private com.toedter.calendar.JDateChooser JDATECHOOSEREquipoFechaAdquisicion;
    private javax.swing.JLabel JLBLContadorEquipoMarca;
    private javax.swing.JLabel JLBLContadorEquipoModelo;
    private javax.swing.JLabel JLBLContadorEquipoNombre;
    private javax.swing.JLabel JLBLContadorEquipoNumeroSerie;
    private javax.swing.JLabel JLBLContadorEquipoObservaciones;
    private javax.swing.JLabel JLBLContadorEquipoProveedor;
    private javax.swing.JLabel JLBLContadorEquipoResponsableEntrega;
    private javax.swing.JLabel JLBLContadorEquipoTiempoGarantia;
    private javax.swing.JLabel JLBLEquipoFoto;
    private javax.swing.JLabel JLBLEquipoResponsable;
    private javax.swing.JTextArea JTXTAREAEquipoObservaciones;
    private javax.swing.JTextField JTXTFEquipoGarantia;
    private javax.swing.JTextField JTXTFEquipoMarca;
    private javax.swing.JTextField JTXTFEquipoModelo;
    private javax.swing.JTextField JTXTFEquipoNombre;
    private javax.swing.JTextField JTXTFEquipoNumeroSerie;
    private javax.swing.JTextField JTXTFEquipoProveedor;
    private javax.swing.JTextField JTXTFEquipoResponsableEntrega;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private BufferedImage getBufferedImage(final Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        final Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        return bimage;
    }

    private final Action action = new AbstractAction() {
        @Override
        public void actionPerformed(final ActionEvent ae) {
            try {
                final String equipoNombre = JTXTFEquipoNombre.getText();
                final String equipoMarca = JTXTFEquipoMarca.getText();
                final String equipoModelo = JTXTFEquipoModelo.getText();
                final String equipoNumeroSerie = JTXTFEquipoNumeroSerie.getText();
                final Date equipoFechaAdquisicion = JDATECHOOSEREquipoFechaAdquisicion.getDate() == null ? null : Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(JDATECHOOSEREquipoFechaAdquisicion.getDate()));
                final String equipoProveedor = JTXTFEquipoProveedor.getText();
                final String equipoResponsableEntrega = JTXTFEquipoResponsableEntrega.getText();
                final int equipoGarantia = JTXTFEquipoGarantia.getText().trim().isEmpty() ? -1 : Integer.valueOf(JTXTFEquipoGarantia.getText());
                final ItemSubespecialidad itemSubespecialidad = JCMBXAreaServicio.getSelectedIndex() == -1 ? null : (ItemSubespecialidad) JCMBXAreaServicio.getSelectedItem();
                final String equipoIntegridad = JCMBXEquipoIntegridad.getSelectedIndex() == -1 ? "" : JCMBXEquipoIntegridad.getSelectedItem().toString();
                final String equipoUbicacion = JCMBXEquipoUbicacion.getSelectedIndex() == -1 ? null : JCMBXEquipoUbicacion.getSelectedItem().toString();
                final String equipoObservaciones = JTXTAREAEquipoObservaciones.getText();

                if (equipoNombre.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingresa el nombre del equipo.", "SIET", JOptionPane.ERROR_MESSAGE);
                } else if (equipoMarca.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingresa la marca del equipo.", "SIET", JOptionPane.ERROR_MESSAGE);
                } else if (equipoModelo.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingresa el modelo del equipo.", "SIET", JOptionPane.ERROR_MESSAGE);
                } else if (equipoNumeroSerie.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingresa número de serie del equipo.", "SIET", JOptionPane.ERROR_MESSAGE);
                } else if (equipoFechaAdquisicion == null) {
                    JOptionPane.showMessageDialog(null, "Ingresa la fecha en la que se está obteniendo el equipo.", "SIET", JOptionPane.ERROR_MESSAGE);
                } else if (equipoProveedor.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingresa el proveedor del equipo.", "SIET", JOptionPane.ERROR_MESSAGE);
                } else if (equipoResponsableEntrega.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingresa el responsable de la entrega del equipo.", "SIET", JOptionPane.ERROR_MESSAGE);
                } else if (equipoGarantia == -1) {
                    JOptionPane.showMessageDialog(null, "Ingresa la garantia del equipo.", "SIET", JOptionPane.ERROR_MESSAGE);
                } else if (equipoUbicacion.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Selecciona la ubicación del equipo.", "SIET", JOptionPane.ERROR_MESSAGE);
                } else if (itemSubespecialidad == null) {
                    JOptionPane.showMessageDialog(null, "Selecciona el area de servicio del equipo.", "SIET", JOptionPane.ERROR_MESSAGE);
                } else if (equipoIntegridad.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Selecciona la integridad del equipo.", "SIET", JOptionPane.ERROR_MESSAGE);
                } else {
                    final BufferedImage bufferedImage = getBufferedImage(equipoFoto.getImage());
                    final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ImageIO.write(bufferedImage, "PNG", byteArrayOutputStream);
                    final byte[] equipoFoto = byteArrayOutputStream.toByteArray();

                    final Subespecialidad subespecialidad = new Subespecialidad(itemSubespecialidad.getCodigoSubespecialidad(), itemSubespecialidad.getEspecialidad(), itemSubespecialidad.getSubespecialidadNombre(), itemSubespecialidad.getSubespecialidadEstado());
                    presenterGestionEquipos.registrarEquipo(new Equipo(personalTecnicoAdministrador, subespecialidad, equipoNombre, equipoMarca, equipoModelo, equipoNumeroSerie, equipoFechaAdquisicion, equipoProveedor, equipoResponsableEntrega, equipoIntegridad, equipoGarantia, equipoUbicacion, equipoObservaciones, equipoFoto, 1));
                }
            } catch (final HeadlessException | NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                System.err.println("Error registrar equipo: " + exception.getMessage());
            } catch (final IOException ex) {
                Logger.getLogger(RegistrarEquipo.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                System.err.println("Error registrar equipo: " + ex.getMessage());
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
        JCMBXAreaServicio.setModel(defaultComboBoxModel);
        JCMBXAreaServicio.setSelectedIndex(-1);
    }

    @Override
    public void listaSubespecialidadesVacia(final String msg) {
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
    public void equipoExiste(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorVerificarExistenciaEquipo(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void equipoRegistrado(final String msg) {
        dispose();
    }

    @Override
    public void errorRegistrarEquipo(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoRegistrarEquipo(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}