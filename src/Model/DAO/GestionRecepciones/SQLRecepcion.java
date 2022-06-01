package Model.DAO.GestionRecepciones;

import Model.DAO.DataBaseConfiguration;
import Model.DAO.GestionCuenta.SQLCuenta;
import Model.POJO.Conexion;
import Model.POJO.PersonalTecnico;
import Model.POJO.Establecimiento;
import Model.POJO.Examen;
import Model.POJO.ExamenSolicitado;
import Model.POJO.LogConsulta;
import Model.POJO.MuestraBiologica;
import Model.POJO.Paciente;
import Model.POJO.Persona;
import Model.POJO.Recepcion;
import Model.POJO.Subespecialidad;
import Model.POJOPersonalizado.ExamenSolicitadoPersonalizado;
import Model.POJOPersonalizado.RecepcionPersonalizada;
import View.Utilitarios.Utilidades;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brynner
 */
public class SQLRecepcion {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final Conexion conexion = DataBaseConfiguration.CONEXION;

    private final String url = "jdbc:postgresql://" + conexion.getHost() + ":" + conexion.getPuerto() + "/" + conexion.getNombreBaseDatos();
    private final String user = conexion.getUsuario();
    private final String password = conexion.getPassword();
    
    private final String SQL_INSERTAR_EN_LOG = "INSERT INTO alogcon(palccoloco, falccopete, calcconeje) VALUES(nextval('palccoloco_sequence'), ?, ?)";
    private final String SQL_INSERTAR_PERSONA = "INSERT INTO aperson(papscodper, capspeceid, capsperape, capspernom, capspersex) VALUES(nextval('papscodper_sequence'), ?, ?, ?, ?)";
    private final String SQL_INSERTAR_PACIENTE = "INSERT INTO apacien(papicodpac, fapicodper, capipafena) VALUES(nextval('papicodpac_sequence'), ?, ?)";
    private final String SQL_INSERTAR_RECEPCION = "INSERT INTO arecepc(parecodrec, farecopete, farecodpac, farecodest, carecorela, careedpaye, careedpame, careedpadi, caremujemb, caremujpar, caremupopa, carenudisi, carefecpro, caresolici, carefecrec, carehorrec, careestado) VALUES(nextval('parecodrec_sequence'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String SQL_INSERTAR_EXAMEN_SOLICITADO = "INSERT INTO aexasol(paescoexso, faescodrec, faescodexa, faescomubi, caestomubi, caesmubies, caesexsoes) VALUES(nextval('paescoexso_sequence'), ?, ?, ?, ?, ?, ?)";

    private final String SQL_OBTENER_RECEPCIONES = "SELECT * FROM arecepc INNER JOIN apertec ON apertec.paptcopete = arecepc.farecopete INNER JOIN aperson ON aperson.papscodper = apertec.faptcodper INNER JOIN apacien ON apacien.papicodpac = arecepc.farecodpac INNER JOIN aperson aperson2 ON aperson2.papscodper = apacien.fapicodper INNER JOIN aestabl ON aestabl.paeacodest = arecepc.farecodest WHERE careestado = 1 AND date_part('month', carefecrec) = ? AND date_part('year', carefecrec) = ? ORDER BY parecodrec DESC";
    private final String SQL_OBTENER_TOTAL_EXAMENES_SOLICITADOS = "SELECT COUNT(*) FROM aexasol WHERE faescodrec = ? AND faescodrec IN (SELECT parecodrec FROM arecepc WHERE careestado = 1) AND caesexsoes = 1";
    private final String SQL_OBTENER_TOTAL_EXAMENES_PENDIENTES = "SELECT COUNT(*) FROM aexasol WHERE faescodrec = ? AND caesexsoes = 1 AND paescoexso NOT IN (SELECT fargcoexso FROM aresgen)";
    private final String SQL_OBTENER_EXAMENES_SOLICITADOS = "SELECT * FROM aexasol INNER JOIN aexamen ON aexamen.paemcodexa = aexasol.faescodexa INNER JOIN asubesp ON asubesp.pasecodsub = aexamen.faemcodsub INNER JOIN amuebio ON amuebio.pambcomubi = aexasol.faescomubi WHERE aexasol.faescodrec = ? AND aexasol.caesexsoes = 1 ORDER BY aexasol.paescoexso DESC";
    private final String SQL_OBTENER_TOTAL_RESULTADOS_INGRESADOS = "SELECT COUNT(*) FROM aresgen WHERE fargcoexso = ?";
    private final String SQL_OBTENER_YEAR_SERVER = "SELECT date_part('year', CURRENT_DATE)";
    private final String SQL_OBTENER_ULTIMO_CODIGO_REGISTRO_LABORATORIO = "SELECT carecorela FROM arecepc ORDER BY parecodrec DESC LIMIT 1";
    
    private final String SQL_ACTUALIZAR_EXAMENES_SOLICITADOS = "UPDATE aexasol SET faescodexa = ?, faescomubi = ?, caestomubi = ?, caesmubies = ? WHERE paescoexso = ? AND caesexsoes = 1";
    private final String SQL_ACTUALIZAR_RECEPCION = "UPDATE arecepc SET farecodest = ?, careedpaye = ?, careedpame = ?, careedpadi = ?, caremujemb = ?, caremujpar = ?, caremupopa = ?, carenudisi = ?, carefecpro = ?, caresolici = ?, carefecrec = ?, carehorrec = ? WHERE parecodrec = ? AND careestado = 1";

    private final String SQL_ELIMINAR_RECEPCION = "UPDATE arecepc SET careestado = 0 WHERE parecodrec = ?";
    private final String SQL_ELIMINAR_EXAMEN_SOLICITADO = "UPDATE aexasol SET caesexsoes = 0 WHERE paescoexso = ? AND caesexsoes = 1";
    
    private final String SQL_VERIFICAR_TABLA_VACIA_RECEPCIONES = "SELECT CASE WHEN EXISTS (SELECT 1 FROM arecepc) THEN TRUE ELSE FALSE END";
    private final String SQL_VERIFICAR_PERMITIR_MODIFICACION = "SELECT CASE WHEN ((SELECT EXTRACT(EPOCH FROM(CURRENT_TIMESTAMP - (SELECT CONCAT((SELECT carefecrec FROM arecepc WHERE parecodrec = ?),' ',(SELECT carehorrec FROM arecepc WHERE parecodrec = ?))::timestamp)))/3600) > 48) THEN TRUE ELSE FALSE END";
    
    private final PersonalTecnico PERSONAL_TECNICO;
        
    private PreparedStatement statement;
    private ResultSet resultSet;
    private ResultSet resultSetAux;
    private Connection connection;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public SQLRecepcion() {
        connection = null;
        resultSet = null;
        resultSetAux = null;
        PERSONAL_TECNICO = Utilidades.obtenerCuentaLocal().getPersonalTecnico();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Queries">
    
    public Boolean insertar(final List<ExamenSolicitado> examenesSolicitados) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INSERTAR_PERSONA));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INSERTAR_PACIENTE));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INSERTAR_RECEPCION));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INSERTAR_EXAMEN_SOLICITADO));
            
            final Recepcion recepcion = examenesSolicitados.get(0).getRecepcion();
            final Paciente paciente = recepcion.getPaciente();
            final Persona persona = paciente.getPersona();
            final Establecimiento establecimiento = recepcion.getEstablecimiento();

            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);

            if (persona.getCodigoPersona() == -1) {
                statement = connection.prepareStatement(SQL_INSERTAR_PERSONA, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, persona.getPersonaCedulaIdentidad());
                statement.setString(2, persona.getPersonaApellido());
                statement.setString(3, persona.getPersonaNombre());
                statement.setString(4, persona.getPersonaSexo());

                if (statement.executeUpdate() == 1) {
                    resultSet = statement.getGeneratedKeys();
                    resultSet.next();
                    final int CODIGO_PERSONA = resultSet.getInt(1);

                    statement = connection.prepareStatement(SQL_INSERTAR_PACIENTE, Statement.RETURN_GENERATED_KEYS);
                    statement.setInt(1, CODIGO_PERSONA);
                    statement.setDate(2, paciente.getPacienteFechaNacimiento());

                    if (statement.executeUpdate() == 1) {
                        resultSet = statement.getGeneratedKeys();
                        resultSet.next();
                        final int CODIGO_PACIENTE = resultSet.getInt(1);

                        statement = connection.prepareStatement(SQL_INSERTAR_RECEPCION, Statement.RETURN_GENERATED_KEYS);
                        statement.setInt(1, recepcion.getPersonalTecnico().getCodigoPersonalTecnico());
                        statement.setInt(2, CODIGO_PACIENTE);
                        statement.setInt(3, establecimiento.getCodigoEstablecimiento());
                        statement.setString(4, recepcion.getCodigoRegistroLaboratorio());
                        statement.setInt(5, recepcion.getEdadPacienteYears());
                        statement.setInt(6, recepcion.getEdadPacienteMeses());
                        statement.setInt(7, recepcion.getEdadPacienteDias());
                        statement.setBoolean(8, recepcion.isMujerEmbarazada());
                        statement.setBoolean(9, recepcion.isMujerParto());
                        statement.setBoolean(10, recepcion.isMujerPostParto());
                        statement.setInt(11, recepcion.getNumeroDiasSintomas());
                        statement.setDate(12, recepcion.getFechaProcesamiento());
                        statement.setString(13, recepcion.getSolicitante());
                        statement.setDate(14, recepcion.getFechaRecepcion());
                        statement.setTime(15, recepcion.getHoraRecepcion());
                        statement.setInt(16, recepcion.getEstado());

                        if (statement.executeUpdate() == 1) {
                            resultSet = statement.getGeneratedKeys();
                            resultSet.next();
                            final int CODIGO_RECEPCION = resultSet.getInt(1);

                            statement = connection.prepareStatement(SQL_INSERTAR_EXAMEN_SOLICITADO);
                            boolean inserted = true;

                            for (final ExamenSolicitado examenSolicitado : examenesSolicitados) {
                                statement.setInt(1, CODIGO_RECEPCION);
                                statement.setInt(2, examenSolicitado.getExamen().getCodigoExamen());
                                statement.setInt(3, examenSolicitado.getMuestraBiologica().getCodigoMuestraBiologica());
                                statement.setInt(4, examenSolicitado.getTotalMuestrasBiologicas());
                                statement.setString(5, examenSolicitado.getMuestraBiologicaEstado());
                                statement.setInt(6, examenSolicitado.getExamenSolicitadoEstado());

                                if (statement.executeUpdate() != 1) {
                                    inserted = false;
                                    break;
                                }
                            }

                            if (inserted) {
                                connection.commit();
                                return true;
                            } else {
                                connection.rollback();
                                return false;
                            }
                        } else {
                            connection.rollback();
                            return false;
                        }
                    } else {
                        connection.rollback();
                        return false;
                    }
                } else {
                    connection.rollback();
                    return false;
                }
            } else {
                statement = connection.prepareStatement(SQL_INSERTAR_RECEPCION, Statement.RETURN_GENERATED_KEYS);
                statement.setInt(1, recepcion.getPersonalTecnico().getCodigoPersonalTecnico());
                statement.setInt(2, paciente.getCodigoPaciente());
                statement.setInt(3, establecimiento.getCodigoEstablecimiento());
                statement.setString(4, recepcion.getCodigoRegistroLaboratorio());
                statement.setInt(5, recepcion.getEdadPacienteYears());
                statement.setInt(6, recepcion.getEdadPacienteMeses());
                statement.setInt(7, recepcion.getEdadPacienteDias());
                statement.setBoolean(8, recepcion.isMujerEmbarazada());
                statement.setBoolean(9, recepcion.isMujerParto());
                statement.setBoolean(10, recepcion.isMujerPostParto());
                statement.setInt(11, recepcion.getNumeroDiasSintomas());
                statement.setDate(12, recepcion.getFechaProcesamiento());
                statement.setString(13, recepcion.getSolicitante());
                statement.setDate(14, recepcion.getFechaRecepcion());
                statement.setTime(15, recepcion.getHoraRecepcion());
                statement.setInt(16, recepcion.getEstado());

                if (statement.executeUpdate() == 1) {
                    resultSet = statement.getGeneratedKeys();
                    resultSet.next();
                    final int CODIGO_RECEPCION = resultSet.getInt(1);

                    statement = connection.prepareStatement(SQL_INSERTAR_EXAMEN_SOLICITADO);
                    boolean inserted = true;

                    for (final ExamenSolicitado examenSolicitado : examenesSolicitados) {
                        statement.setInt(1, CODIGO_RECEPCION);
                        statement.setInt(2, examenSolicitado.getExamen().getCodigoExamen());
                        statement.setInt(3, examenSolicitado.getMuestraBiologica().getCodigoMuestraBiologica());
                        statement.setInt(4, examenSolicitado.getTotalMuestrasBiologicas());
                        statement.setString(5, examenSolicitado.getMuestraBiologicaEstado());
                        statement.setInt(6, examenSolicitado.getExamenSolicitadoEstado());

                        if (statement.executeUpdate() != 1) {
                            inserted = false;
                            break;
                        }
                    }

                    if (inserted) {
                        connection.commit();
                        return true;
                    } else {
                        connection.rollback();
                        return false;
                    }
                } else {
                    connection.rollback();
                    return false;
                }
            }

        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLRecepcion - Insertar " + sqlException.getMessage());
            return false;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }

                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                }

                if (connection != null && !statement.isClosed()) {
                    connection.close();
                }
            } catch (final SQLException ex) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public List<RecepcionPersonalizada> obtenerRecepciones(final int month, final int year) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_RECEPCIONES));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_TOTAL_EXAMENES_SOLICITADOS));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_TOTAL_EXAMENES_PENDIENTES));
            final List<RecepcionPersonalizada> recepcionesPersonalizadas;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_RECEPCIONES);
            statement.setInt(1, month);
            statement.setInt(2, year);
            resultSet = statement.executeQuery();

            recepcionesPersonalizadas = new ArrayList<>();
            while (resultSet.next()) {
                final int codigoRecepcion = resultSet.getInt(1);
                final String codigoRegistroLaboratorio = resultSet.getString(5);
                final int edadPacienteYears = resultSet.getInt(6);
                final int edadPacienteMeses = resultSet.getInt(7);
                final int edadPacienteDias = resultSet.getInt(8);
                final boolean mujerEmbarazada = resultSet.getBoolean(9);
                final boolean mujerParto = resultSet.getBoolean(10);
                final boolean mujerPostParto = resultSet.getBoolean(11);
                final int numeroDiasSintoma = resultSet.getInt(12);
                final Date fechaProcesamiento = resultSet.getDate(13);
                final String solicitante = resultSet.getString(14);
                final Date fechaRecepcion = resultSet.getDate(15);
                final Time horaRecepcion = resultSet.getTime(16);
                final int estado = resultSet.getInt(17);

                final int codigoPersonalTecnico = resultSet.getInt(18);
                final String pertecProfesion = resultSet.getString(20);
                final Date pertecFechaInicio = resultSet.getDate(21);
                final Time pertecHoraInicio = resultSet.getTime(22);
                final boolean pertecHabilitado = resultSet.getBoolean(25);

                final int codigoPersonaPertec = resultSet.getInt(26);
                final String personaCedulaIdentidadPertec = resultSet.getString(27);
                final String personaApellidoPertec = resultSet.getString(28);
                final String personaNombrePertec = resultSet.getString(29);
                final String personaSexoPertec = resultSet.getString(30);

                final int codigoPaciente = resultSet.getInt(31);
                final Date pacienteFechaNacimiento = resultSet.getDate(33);
                
                final int codigoPersonaPaciente = resultSet.getInt(34);
                final String personaCedulaIdentidadPaciente = resultSet.getString(35);
                final String personaApellidoPaciente = resultSet.getString(36);
                final String personaNombrePaciente = resultSet.getString(37);
                final String personaSexoPaciente = resultSet.getString(38);

                final int codigoEstablecimiento = resultSet.getInt(39);
                final String establecimientoNombre = resultSet.getString(40);
                final String establecimientoTipo = resultSet.getString(41);
                final String establecimientoArea = resultSet.getString(42);
                final int establecimientoEstado = resultSet.getInt(43);

                final Persona personaPaciente = new Persona(codigoPersonaPaciente, personaCedulaIdentidadPaciente, personaApellidoPaciente, personaNombrePaciente, personaSexoPaciente);
                final Persona personaPersonalTecnico = new Persona(codigoPersonaPertec, personaCedulaIdentidadPertec, personaApellidoPertec, personaNombrePertec, personaSexoPertec);
                final Paciente paciente = new Paciente(codigoPaciente, personaPaciente, pacienteFechaNacimiento);
                final PersonalTecnico personalTecnico = new PersonalTecnico(codigoPersonalTecnico, personaPersonalTecnico, pertecProfesion, pertecFechaInicio, pertecHoraInicio, pertecHabilitado);
                final Establecimiento establecimiento = new Establecimiento(codigoEstablecimiento, establecimientoNombre, establecimientoTipo, establecimientoArea, establecimientoEstado);
                
                final Recepcion recepcion = new Recepcion(codigoRecepcion, personalTecnico, paciente, establecimiento, codigoRegistroLaboratorio, edadPacienteYears, edadPacienteMeses, edadPacienteDias, mujerEmbarazada, mujerParto, mujerPostParto, numeroDiasSintoma, fechaProcesamiento, solicitante, fechaRecepcion, horaRecepcion, estado);

                statement = connection.prepareStatement(SQL_OBTENER_TOTAL_EXAMENES_SOLICITADOS);
                statement.setInt(1, recepcion.getCodigoRecepcion());
                resultSetAux = statement.executeQuery();
                resultSetAux.next();
                final int totalExamenesSolicitados = resultSetAux.getInt(1);

                statement = connection.prepareStatement(SQL_OBTENER_TOTAL_EXAMENES_PENDIENTES);
                statement.setInt(1, recepcion.getCodigoRecepcion());
                resultSetAux = statement.executeQuery();
                resultSetAux.next();
                final int totalExamenesPendiente = resultSetAux.getInt(1);

                recepcionesPersonalizadas.add(new RecepcionPersonalizada(recepcion, totalExamenesSolicitados, totalExamenesPendiente));
            }
            return recepcionesPersonalizadas;

        } catch (final SQLException sqlException) {
            System.out.print("SQLException - Error en SQLRecepcion - Obtener Recepciones: " + sqlException.getMessage());
            return null;
        } catch (final Exception exception) {
            System.out.print("Exception - Error en SQLRecepcion: - Obtener Recepciones: " + exception.getMessage());
            return null;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }

                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                }

                if (resultSetAux != null && !resultSetAux.isClosed()) {
                    resultSetAux.close();
                }

                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (final SQLException sqlException) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, sqlException);
            }
        }
    }
    
    public List<ExamenSolicitadoPersonalizado> obtenerExamenesSolicitados(final Recepcion recepcion) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_EXAMENES_SOLICITADOS));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_TOTAL_RESULTADOS_INGRESADOS));
            
            final List<ExamenSolicitadoPersonalizado> examenesSolicitadosPersonalizados;

            connection = DriverManager.getConnection(url, user, password);

            statement = connection.prepareStatement(SQL_OBTENER_EXAMENES_SOLICITADOS);
            statement.setInt(1, recepcion.getCodigoRecepcion());

            resultSet = statement.executeQuery();

            examenesSolicitadosPersonalizados = new ArrayList<>();
            while (resultSet.next()) {
                final int codigoExamenSolicitado = resultSet.getInt(1);
                final int totalMuestrasBiologicas = resultSet.getInt(5);
                final String muestraBiologicaEstad = resultSet.getString(6);
                final int examenSolicitadoEstado = resultSet.getInt(7);

                final int codigoExamen = resultSet.getInt(8);
                final String examenNombre = resultSet.getString(10);
                final int examenEstado = resultSet.getInt(11);

                final int codigoSubespecialidad = resultSet.getInt(12);
                final String subespecialidadNombre = resultSet.getString(14);
                final int subespecialidadEstado = resultSet.getInt(15);

                final int codigoMuestraBiologica = resultSet.getInt(16);
                final String muestraBiologicaTipo = resultSet.getString(17);
                final int muestraBiologicaEstado = resultSet.getInt(18);

                final MuestraBiologica muestraBiologica = new MuestraBiologica(codigoMuestraBiologica, muestraBiologicaTipo, muestraBiologicaEstado);
                final Subespecialidad subespecialidad = new Subespecialidad(codigoSubespecialidad, null, subespecialidadNombre, subespecialidadEstado);
                final Examen examen = new Examen(codigoExamen, subespecialidad, examenNombre, examenEstado);
                final ExamenSolicitado examenSolicitado = new ExamenSolicitado(codigoExamenSolicitado, recepcion, examen, muestraBiologica, totalMuestrasBiologicas, muestraBiologicaEstad, examenSolicitadoEstado);
                
                statement = connection.prepareStatement(SQL_OBTENER_TOTAL_RESULTADOS_INGRESADOS);
                statement.setInt(1, examenSolicitado.getCodigoExamenSolicitado());
                resultSetAux = statement.executeQuery();
                
                final int TOTAL_RESULTADOS_INGRESADOS = resultSetAux.next()? resultSetAux.getInt(1) : -1;
                
                examenesSolicitadosPersonalizados.add(new ExamenSolicitadoPersonalizado(examenSolicitado, TOTAL_RESULTADOS_INGRESADOS));
            }
            return examenesSolicitadosPersonalizados;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLRecepcion - Obtener Examenes Solicitados: " + sqlException.getMessage());
            return null;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }

                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                }

                if (resultSetAux != null && !resultSetAux.isClosed()) {
                    resultSetAux.close();
                }

                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (final SQLException sqlException) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, sqlException);
            }

        }
    }
    
    public int obtenerYearServer() {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_YEAR_SERVER));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_YEAR_SERVER);

            resultSet = statement.executeQuery();
            resultSet.next();
            
            final String yearServer = resultSet.getString(1);
            
            return yearServer.length() == 4 ? Integer.valueOf(yearServer) : -1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLRecepcion - Obtener Year Server: " + sqlException.getMessage());
            return -1;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }
                
                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                }
                
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }

            } catch (final SQLException sqlException) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, sqlException);
            }
        }
    }
    
    public String obtenerUltimoCodigoRegsitroLaboratorio() {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_ULTIMO_CODIGO_REGISTRO_LABORATORIO));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_ULTIMO_CODIGO_REGISTRO_LABORATORIO);

            resultSet = statement.executeQuery();
            resultSet.next();
            
            return resultSet.getString(1);
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLRecepcion - Obtener Ultimo Codigo Registro Laboratorio: " + sqlException.getMessage());
            return null;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }
                
                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                }
                
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }

            } catch (final SQLException sqlException) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, sqlException);
            }
        }
    }
    
    public Boolean actualizar(final List<ExamenSolicitado> examenesSolicitados) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ACTUALIZAR_RECEPCION));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INSERTAR_EXAMEN_SOLICITADO));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ELIMINAR_EXAMEN_SOLICITADO));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ACTUALIZAR_EXAMENES_SOLICITADOS));
            final Recepcion recepcion = examenesSolicitados.get(0).getRecepcion();

            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
            
            statement = connection.prepareStatement(SQL_ACTUALIZAR_RECEPCION);
            statement.setInt(1, recepcion.getEstablecimiento().getCodigoEstablecimiento());
            statement.setInt(2, recepcion.getEdadPacienteYears());
            statement.setInt(3, recepcion.getEdadPacienteMeses());
            statement.setInt(4, recepcion.getEdadPacienteDias());
            statement.setBoolean(5, recepcion.isMujerEmbarazada());
            statement.setBoolean(6, recepcion.isMujerParto());
            statement.setBoolean(7, recepcion.isMujerPostParto());
            statement.setInt(8, recepcion.getNumeroDiasSintomas());
            statement.setDate(9, recepcion.getFechaProcesamiento());
            statement.setString(10, recepcion.getSolicitante());
            statement.setDate(11, recepcion.getFechaRecepcion());
            statement.setTime(12, recepcion.getHoraRecepcion());
            statement.setInt(13, recepcion.getCodigoRecepcion());

            if (statement.executeUpdate() == 1) {
                boolean updated = true;

                for (final ExamenSolicitado examenSolicitado : examenesSolicitados) {
                    if (examenSolicitado.getCodigoExamenSolicitado() == 0 && examenSolicitado.getExamenSolicitadoEstado() == 1) {
                        statement = connection.prepareStatement(SQL_INSERTAR_EXAMEN_SOLICITADO);

                        statement.setInt(1, examenSolicitado.getRecepcion().getCodigoRecepcion());
                        statement.setInt(2, examenSolicitado.getExamen().getCodigoExamen());
                        statement.setInt(3, examenSolicitado.getMuestraBiologica().getCodigoMuestraBiologica());
                        statement.setInt(4, examenSolicitado.getTotalMuestrasBiologicas());
                        statement.setString(5, examenSolicitado.getMuestraBiologicaEstado());
                        statement.setInt(6, examenSolicitado.getExamenSolicitadoEstado());
                    } else if (examenSolicitado.getCodigoExamenSolicitado() != 0 && examenSolicitado.getExamenSolicitadoEstado() == 0) {
                        statement = connection.prepareStatement(SQL_ELIMINAR_EXAMEN_SOLICITADO);

                        statement.setInt(1, examenSolicitado.getCodigoExamenSolicitado());
                    } else {
                        statement = connection.prepareStatement(SQL_ACTUALIZAR_EXAMENES_SOLICITADOS);

                        statement.setInt(1, examenSolicitado.getExamen().getCodigoExamen());
                        statement.setInt(2, examenSolicitado.getMuestraBiologica().getCodigoMuestraBiologica());
                        statement.setInt(3, examenSolicitado.getTotalMuestrasBiologicas());
                        statement.setString(4, examenSolicitado.getMuestraBiologicaEstado());
                        statement.setInt(5, examenSolicitado.getCodigoExamenSolicitado());
                    }
                    
                    final int result = statement.executeUpdate();
                    if (result > 1 || result < 1) {
                        updated = false;
                        break;
                    }
                }

                if (updated) {
                    connection.commit();
                    return true;
                } else {
                    connection.rollback();
                    return false;
                }
            } else {
                connection.rollback();
                return false;
            }
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLRecepcion - Actualizar " + sqlException.getMessage());
            return false;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }

                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                }

                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (final SQLException ex) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean eliminarRecepcion(final Recepcion recepcion) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ELIMINAR_RECEPCION));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_ELIMINAR_RECEPCION);
            statement.setInt(1, recepcion.getCodigoRecepcion());
            
            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLRecepcion - Eliminar Recepcion: " + sqlException.getMessage());
            return false;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }
                
                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                }
                
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }

            } catch (final SQLException sqlException) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, sqlException);
            }
        }
    }
    
    public int verificarTablaVaciaRecepciones() {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_VERIFICAR_TABLA_VACIA_RECEPCIONES));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_VERIFICAR_TABLA_VACIA_RECEPCIONES);

            resultSet = statement.executeQuery();
            resultSet.next();
            
            return resultSet.getBoolean(1) ? 0 : 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLRecepcion - Verificar Tabla Vacia Recepciones: " + sqlException.getMessage());
            return -1;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }

                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }

            } catch (final SQLException sqlException) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, sqlException);
            }
        }
    }
    
    public int verificarPermitirModificacion(final Recepcion recepcion) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_VERIFICAR_PERMITIR_MODIFICACION));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_VERIFICAR_PERMITIR_MODIFICACION);
            statement.setInt(1, recepcion.getCodigoRecepcion());
            statement.setInt(2, recepcion.getCodigoRecepcion());
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                if (resultSet.getBoolean(1)) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return -1;
            }
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLRecepcion - Verificar Permitir Modificacion: " + sqlException.getMessage());
            return -1;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }

                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                }

                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (final SQLException sqlException) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, sqlException);
            }
        }
    }
    
    public Boolean insertarEnLog(final LogConsulta logConsulta) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_INSERTAR_EN_LOG);
            statement.setInt(1, logConsulta.getPersonalTecnico().getCodigoPersonalTecnico());
            statement.setString(2, logConsulta.getConsultaEjecutada());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLRecepcion - InsertarEnLog: " + sqlException.getMessage());
            return false;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }

                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (final SQLException sqlException) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, sqlException);
            }
        }
    }
    
    // </editor-fold>
    
}