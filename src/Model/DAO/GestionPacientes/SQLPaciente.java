package Model.DAO.GestionPacientes;

import Model.DAO.DataBaseConfiguration;
import Model.DAO.GestionCuenta.SQLCuenta;
import Model.POJO.Conexion;
import Model.POJO.Establecimiento;
import Model.POJO.Examen;
import Model.POJO.ExamenSolicitado;
import Model.POJO.LogConsulta;
import Model.POJO.Paciente;
import Model.POJO.Persona;
import Model.POJO.PersonalTecnico;
import Model.POJO.Recepcion;
import Model.POJO.SeguimientoPaciente;
import Model.POJOPersonalizado.PacientePersonalizado;
import Model.POJOPersonalizado.RecepcionPersonalizada;
import Model.POJOPersonalizado.SeguimientoPacientePersonalizado;
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
public class SQLPaciente {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final Conexion conexion = DataBaseConfiguration.CONEXION;

    private final String url = "jdbc:postgresql://" + conexion.getHost() + ":" + conexion.getPuerto() + "/" + conexion.getNombreBaseDatos();
    private final String user = conexion.getUsuario();
    private final String password = conexion.getPassword();

    private final String SQL_INSERTAR_EN_LOG = "INSERT INTO alogcon(palccoloco, falccopete, calcconeje) VALUES(nextval('palccoloco_sequence'), ?, ?)";
    private final String SQL_OBTENER_PACIENTES = "SELECT * FROM apacien INNER JOIN aperson ON aperson.papscodper = apacien.fapicodper ORDER BY apacien.papicodpac DESC";
    private final String SQL_OBTENER_PACIENTE = "SELECT * FROM apacien INNER JOIN aperson ON aperson.papscodper = apacien.fapicodper WHERE aperson.capspeceid = ? LIMIT 1";
    private final String SQL_OBTENER_SEGUIMIENTO = "SELECT * FROM asegpac WHERE faspcodpac = ? AND faspcodexa = ? AND caspprogre = 'EN SEGUIMIENTO' LIMIT 1";
    private final String SQL_OBTENER_SEGUIMIENTOS = "SELECT * FROM asegpac INNER JOIN aexamen ON aexamen.paemcodexa = asegpac.faspcodexa WHERE faspcodpac = ?";
    private final String SQL_OBTENER_TOTAL_CONTROLES = "SELECT COUNT(*) FROM aresgen WHERE fargcosepa = ?";
    private final String SQL_OBTENER_HISTORIAL_CLINICO = "SELECT * FROM arecepc INNER JOIN apertec ON apertec.paptcopete = arecepc.farecopete INNER JOIN aperson ON aperson.papscodper = apertec.faptcodper INNER JOIN apacien ON apacien.papicodpac = arecepc.farecodpac INNER JOIN aperson aperson2 ON aperson2.papscodper = apacien.fapicodper INNER JOIN aestabl ON aestabl.paeacodest = arecepc.farecodest WHERE apacien.papicodpac = ? ORDER BY parecodrec DESC";
    private final String SQL_OBTENER_TOTAL_EXAMENES_SOLICITADOS = "SELECT COUNT(*) FROM aexasol WHERE faescodrec = ? AND faescodrec IN (SELECT parecodrec FROM arecepc WHERE careestado = 1) AND caesexsoes = 1";
    private final String SQL_OBTENER_TOTAL_EXAMENES_PENDIENTES = "SELECT COUNT(*) FROM aexasol WHERE faescodrec = ? AND caesexsoes = 1 AND paescoexso NOT IN (SELECT fargcoexso FROM aresgen) AND caesmubies != 'REFERIDO POR EL LABORATORIO'";
    private final String SQL_ACTUALIZAR_PACIENTE = "UPDATE apacien SET capipafena = ? WHERE papicodpac = ?";
    private final String SQL_ACTUALIZAR_PERSONA = "UPDATE aperson SET capspeceid = ?, capsperape = ?, capspernom = ?, capspersex = ? WHERE papscodper = ?";
    private final String SQL_VERIFICAR_SI_PACIENTE_ESTA_EN_SEGUIMIENTO = "SELECT EXISTS(SELECT 1 FROM asegpac WHERE faspcodpac = ? AND caspprogre = 'EN SEGUIMIENTO')";
    private final String SQL_VERIFICAR_EXISTENCIA = "SELECT EXISTS (SELECT 1 FROM aperson WHERE aperson.capspeceid = ? AND aperson.papscodper IN (SELECT fapicodper FROM apacien))";
    private final PersonalTecnico PERSONAL_TECNICO;
    
    private PreparedStatement statement;
    private ResultSet resultSet;
    private ResultSet resultSetAux;
    private Connection connection;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public SQLPaciente() {
        connection = null;
        resultSet = null;
        resultSetAux = null;
        PERSONAL_TECNICO = Utilidades.obtenerCuentaLocal().getPersonalTecnico();
        
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Queries">
    
    public List<PacientePersonalizado> obtenerPacientes() {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_PACIENTES));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_VERIFICAR_SI_PACIENTE_ESTA_EN_SEGUIMIENTO));
            
            final List<PacientePersonalizado> pacientesPersonalizados;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_PACIENTES);
            resultSet = statement.executeQuery();

            pacientesPersonalizados = new ArrayList<>();
            while (resultSet.next()) {
                final int pcodigo_paciente = resultSet.getInt(1);
                final Date pacienteFechaNacimiento = resultSet.getDate(3);

                final int pcodigo_persona = resultSet.getInt(4);
                final String cedula_identidad = resultSet.getString(5);
                final String persona_apellido = resultSet.getString(6);
                final String persona_nombre = resultSet.getString(7);
                final String personas_sexo = resultSet.getString(8);

                final Persona persona = new Persona(pcodigo_persona, cedula_identidad, persona_apellido, persona_nombre, personas_sexo);
                final Paciente paciente = new Paciente(pcodigo_paciente, persona, pacienteFechaNacimiento);
                
                statement = connection.prepareStatement(SQL_VERIFICAR_SI_PACIENTE_ESTA_EN_SEGUIMIENTO);
                statement.setInt(1, pcodigo_paciente);
                
                resultSetAux = statement.executeQuery();
                resultSetAux.next();
                final boolean pacientaEstaEnSeguimiento = resultSetAux.getBoolean(1);
                
                pacientesPersonalizados.add(new PacientePersonalizado(paciente, pacientaEstaEnSeguimiento));
            }
            return pacientesPersonalizados;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLPaciente - Obtener Pacientes: " + sqlException.getMessage());
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
            } catch (final SQLException ex) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Paciente obtenerPaciente(final String cedulaIdentidad) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_PACIENTE));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_PACIENTE);
            statement.setString(1, cedulaIdentidad);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                final int pcodigo_paciente = resultSet.getInt(1);
                final Date pacienteFechaNacimiento = resultSet.getDate(3);

                final int pcodigo_persona = resultSet.getInt(4);
                final String cedula_identidad = resultSet.getString(5);
                final String persona_apellido = resultSet.getString(6);
                final String persona_nombre = resultSet.getString(7);
                final String personas_sexo = resultSet.getString(8);

                final Persona persona = new Persona(pcodigo_persona, cedula_identidad, persona_apellido, persona_nombre, personas_sexo);
                return new Paciente(pcodigo_paciente, persona, pacienteFechaNacimiento);
            }
            return null;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLPaciente - Obtener Paciente: " + sqlException.getMessage());
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
    
    public List<SeguimientoPaciente> obtenerSeguimiento(final Paciente paciente, final ExamenSolicitado examenSolicitado) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_SEGUIMIENTO));
            
            final List<SeguimientoPaciente> seguimientoPaciente;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_SEGUIMIENTO);
            statement.setInt(1, paciente.getCodigoPaciente());
            statement.setInt(2, examenSolicitado.getExamen().getCodigoExamen());
            resultSet = statement.executeQuery();
            
            seguimientoPaciente = new ArrayList<>();
            if (resultSet.next()) {
                final int codigoSeguimientoPaciente = resultSet.getInt(1);
                final Date fechaInicio = resultSet.getDate(5);
                final Time horaInicio = resultSet.getTime(6);
                final Date fechaFinal = resultSet.getDate(7);
                final Time horaFinal = resultSet.getTime(8);
                final String progreso = resultSet.getString(9);
                final String detallesObservacionesInicio = resultSet.getString(10);
                final String detallesObservacionesFinal = resultSet.getString(11);
                
                seguimientoPaciente.add(new SeguimientoPaciente(codigoSeguimientoPaciente, paciente, examenSolicitado.getExamen(), examenSolicitado, fechaInicio, horaInicio, fechaFinal, horaFinal, progreso, detallesObservacionesInicio, detallesObservacionesFinal));
                
                return seguimientoPaciente;
            }
            return seguimientoPaciente;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLPaciente - Obtener Seguimiento: " + sqlException.getMessage());
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
    
    public List<SeguimientoPacientePersonalizado> obtenerSeguimientos(final Paciente paciente) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_SEGUIMIENTOS));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_TOTAL_CONTROLES));
            
            final List<SeguimientoPacientePersonalizado> seguimientosPacientePersonalizados;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_SEGUIMIENTOS);
            statement.setInt(1, paciente.getCodigoPaciente());
            resultSet = statement.executeQuery();
            
            seguimientosPacientePersonalizados = new ArrayList<>();
            while (resultSet.next()) {
                final int codigoSeguimientoPaciente = resultSet.getInt(1);
                final Date fechaInicio = resultSet.getDate(5);
                final Time horaInicio = resultSet.getTime(6);
                final Date fechaFinal = resultSet.getDate(7);
                final Time horaFinal = resultSet.getTime(8);
                final String progreso = resultSet.getString(9);
                final String detallesObservacionesInicio = resultSet.getString(10);
                final String detallesObservacionesFinal = resultSet.getString(11);
                
                final int codigoExamen = resultSet.getInt(12);
                final String examenNombre = resultSet.getString(14);
                final int examenEstado = resultSet.getInt(15);
                
                final Examen examen = new Examen(codigoExamen, null, examenNombre, examenEstado);
                final SeguimientoPaciente seguimientoPaciente = new SeguimientoPaciente(codigoSeguimientoPaciente, paciente, examen, null, fechaInicio, horaInicio, fechaFinal, horaFinal, progreso, detallesObservacionesInicio, detallesObservacionesFinal);
                
                statement = connection.prepareStatement(SQL_OBTENER_TOTAL_CONTROLES);
                statement.setInt(1, codigoSeguimientoPaciente);
                resultSetAux = statement.executeQuery();
                resultSetAux.next();
                final int TOTAL_CONTROLES = resultSetAux.getInt(1);
                
                seguimientosPacientePersonalizados.add(new SeguimientoPacientePersonalizado(seguimientoPaciente, TOTAL_CONTROLES));
            }
            return seguimientosPacientePersonalizados;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLPaciente - Obtener Seguimientos: " + sqlException.getMessage());
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
    
    public List<RecepcionPersonalizada> obtenerHistorialClinico(final Paciente paciente) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_HISTORIAL_CLINICO));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_TOTAL_EXAMENES_SOLICITADOS));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_TOTAL_EXAMENES_PENDIENTES));
            
            final List<RecepcionPersonalizada> recepcionesPersonalizadas;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_HISTORIAL_CLINICO);
            statement.setInt(1, paciente.getCodigoPaciente());
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
                
                final int codigoEstablecimiento = resultSet.getInt(39);
                final String establecimientoNombre = resultSet.getString(40);
                final String establecimientoTipo = resultSet.getString(41);
                final String establecimientoArea = resultSet.getString(42);
                final int establecimientoEstado = resultSet.getInt(43);

                
                final Persona personaPersonalTecnico = new Persona(codigoPersonaPertec, personaCedulaIdentidadPertec, personaApellidoPertec, personaNombrePertec, personaSexoPertec);
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
            System.out.print("SQLException - Error en SQLRecepcion - Obtener Historial Clinico: " + sqlException.getMessage());
            return null;
        } catch (final Exception exception) {
            System.out.print("Exception - Error en SQLRecepcion: - Obtener Historial Clinico: " + exception.getMessage());
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
    
    public Boolean actualizar(final Paciente paciente) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ACTUALIZAR_PERSONA));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ACTUALIZAR_PACIENTE));
            
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(SQL_ACTUALIZAR_PERSONA);
            statement.setString(1, paciente.getPersona().getPersonaCedulaIdentidad());
            statement.setString(2, paciente.getPersona().getPersonaApellido());
            statement.setString(3, paciente.getPersona().getPersonaNombre());
            statement.setString(4, paciente.getPersona().getPersonaSexo());
            statement.setInt(5, paciente.getPersona().getCodigoPersona());

            if (statement.executeUpdate() == 1) {
                statement = connection.prepareStatement(SQL_ACTUALIZAR_PACIENTE);
                statement.setDate(1, paciente.getPacienteFechaNacimiento());
                statement.setInt(2, paciente.getCodigoPaciente());

                if (statement.executeUpdate() == 1) {
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
            System.err.println("Error en SQLPaciente - Actualizar " + sqlException.getMessage());
            return false;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }
                
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (final SQLException ex) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int verificarExistencia(final String cedulaIdentidad) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_VERIFICAR_EXISTENCIA));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_VERIFICAR_EXISTENCIA);
            statement.setString(1, cedulaIdentidad);

            resultSet = statement.executeQuery();
            resultSet.next();
            final Boolean isExists = resultSet.getBoolean(1);
            
            return isExists ? 1 : 0;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLPaciente - Verificar Existencia: " + sqlException.getMessage());
            return -1;
        } finally {
            try {
                if (statement != null) {
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

    public Boolean insertarEnLog(final LogConsulta logConsulta) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_INSERTAR_EN_LOG);
            statement.setInt(1, logConsulta.getPersonalTecnico().getCodigoPersonalTecnico());
            statement.setString(2, logConsulta.getConsultaEjecutada());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLPaciente - InsertarEnLog: " + sqlException.getMessage());
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