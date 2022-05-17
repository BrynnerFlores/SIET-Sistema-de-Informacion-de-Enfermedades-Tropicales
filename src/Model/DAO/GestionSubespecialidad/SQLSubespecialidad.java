package Model.DAO.GestionSubespecialidad;

import Model.DAO.DataBaseConfiguration;
import Model.DAO.GestionCuenta.SQLCuenta;
import Model.POJO.Conexion;
import Model.POJO.Enfermedad;
import Model.POJO.Especialidad;
import Model.POJO.LogConsulta;
import Model.POJO.MuestraBiologica;
import Model.POJO.PersonalTecnico;
import Model.POJO.Subespecialidad;
import Model.POJO.SubespecialidadMuestra;
import Model.POJOPersonalizado.SubespecialidadPersonalizada;
import View.Utilitarios.Utilidades;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brynner
 */
public class SQLSubespecialidad {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final Conexion conexion = DataBaseConfiguration.CONEXION;

    private final String url = "jdbc:postgresql://" + conexion.getHost() + ":" + conexion.getPuerto() + "/" + conexion.getNombreBaseDatos();
    private final String user = conexion.getUsuario();
    private final String password = conexion.getPassword();

    private final String SQL_INSERTAR_EN_LOG = "INSERT INTO alogcon(palccoloco, falccopete, calcconeje) VALUES(nextval('palccoloco_sequence'), ?, ?)";
    private final String SQL_INSERTAR = "INSERT INTO asubesp(pasecodsub, fasecodesp, casesubnom, casesubest) VALUES(nextval('pasecodsub_sequence'), ?, ?, ?)";
    private final String SQL_OBTENER_TODOS = "SELECT * FROM asubesp INNER JOIN aespeci ON aespeci.paeecodesp = asubesp.fasecodesp WHERE casesubest = 1 ORDER BY pasecodsub";
    private final String SQL_OBTENER_TOTAL_MUESTRAS_BIOLOGICAS_ASIGNADAS = "SELECT COUNT(*) FROM asubmue WHERE fasmcodsub = ? AND fasmcodsub IN (SELECT pasecodsub FROM asubesp WHERE casesubest = 1) AND casmsumues = 1";
    private final String SQL_OBTENER_TOTAL_ENFERMEDADES_AGREGADAS = "SELECT COUNT(*) FROM aenferm WHERE faeecodsub = ? AND caeeenfest = 1";
    private final String SQL_OBTENER_TOTAL_EXAMENES_ASIGNADOS = "SELECT COUNT(*) FROM aexamen WHERE faemcodsub = ? AND faemcodsub IN (SELECT pasecodsub FROM asubesp WHERE casesubest = 1) AND caemexaest = 1";
    private final String SQL_OBTENER_MUESTRAS_BIOLOGICAS_DISPONIBLES = "SELECT pambcomubi, cambmubiti, cambmubies FROM amuebio WHERE pambcomubi NOT IN (SELECT fasmcomubi FROM asubmue WHERE fasmcodsub = ? AND casmsumues = 1) AND cambmubies = 1 ORDER BY pambcomubi";
    private final String SQL_OBTENER_MUESTRAS_BIOLOGICAS_ASIGNADAS = "SELECT * FROM asubmue INNER JOIN amuebio ON amuebio.pambcomubi = asubmue.fasmcomubi WHERE fasmcodsub = ? AND casmsumues = 1";
    private final String SQL_OBTENER_ENFERMEDADES = "SELECT * FROM aenferm WHERE faeecodsub = ? AND caeeenfest = 1 ORDER BY paeecodenf ASC";
    private final String SQL_ACTUALIZAR = "UPDATE asubesp SET fasecodesp =?, casesubnom = ? WHERE pasecodsub = ? AND casesubest = 1";
    private final String SQL_ELIMINAR = "UPDATE asubesp SET casesubest = 0 WHERE pasecodsub = ? AND casesubest = 1";
    private final String SQL_VERIFICAR_EXISTENCIA = "SELECT EXISTS (SELECT 1 FROM asubesp WHERE pasecodsub != ? AND casesubnom = ? AND fasecodesp = ? AND casesubest = 1)";
    private final String SQL_VERIFICAR_TABLA_VACIA_MUESTRA_BIOLOGICA = "SELECT CASE WHEN EXISTS (SELECT 1 FROM amuebio) THEN 1 ELSE 0 end";
    private final PersonalTecnico PERSONAL_TECNICO;
    
    private PreparedStatement statement;
    private ResultSet resultSet;
    private ResultSet resultSetAux;
    private Connection connection;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public SQLSubespecialidad() {
        connection = null;
        resultSet = null;
        resultSetAux = null;
        PERSONAL_TECNICO = Utilidades.obtenerCuentaLocal().getPersonalTecnico();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Queries">
    
    public Boolean insertar(final Subespecialidad subespecialidad) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INSERTAR));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_INSERTAR);
            statement.setInt(1, subespecialidad.getEspecialidad().getCodigoEspecialidad());
            statement.setString(2, subespecialidad.getSubespecialidadNombre());
            statement.setInt(3, subespecialidad.getSubespecialidadEstado());
            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLSubespecialidad - Insertar: " + sqlException.getMessage());
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

    public List<SubespecialidadPersonalizada> obtenerTodos() {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_TODOS));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_TOTAL_MUESTRAS_BIOLOGICAS_ASIGNADAS));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_TOTAL_ENFERMEDADES_AGREGADAS));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_TOTAL_EXAMENES_ASIGNADOS));
            
            final List<SubespecialidadPersonalizada> subespecialidadesPersonalizadas;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_TODOS);
            resultSet = statement.executeQuery();

            subespecialidadesPersonalizadas = new ArrayList<>();
            while (resultSet.next()) {
                final int codigo_subespecialidad = resultSet.getInt(1);
                final String subespecialidad_nombre = resultSet.getString(3);
                final int subespecialidad_estado = resultSet.getInt(4);
                
                final int codigoEspecialidad = resultSet.getInt(5);
                final String especialidadNombre = resultSet.getString(6);
                final int especialidadEstado = resultSet.getInt(7);
                
                final Especialidad especialidad = new Especialidad(codigoEspecialidad, especialidadNombre, especialidadEstado);
                final Subespecialidad subespecialidad = new Subespecialidad(codigo_subespecialidad, especialidad, subespecialidad_nombre, subespecialidad_estado);
                
                // OBTENIENDO EL TOTAL DE MUESTRAS BIOLOGICAS ASIGNADAS
                statement = connection.prepareStatement(SQL_OBTENER_TOTAL_MUESTRAS_BIOLOGICAS_ASIGNADAS);
                statement.setInt(1, subespecialidad.getCodigoSubespecialidad());
                resultSetAux = statement.executeQuery();

                resultSetAux.next();

                final int totalMuestrasBiologicasAsignadas = resultSetAux.getInt(1);
                
                // OBTENIENDO EL TOTAL DE ENFERMEDADES AGREGADAS
                statement = connection.prepareStatement(SQL_OBTENER_TOTAL_ENFERMEDADES_AGREGADAS);
                statement.setInt(1, subespecialidad.getCodigoSubespecialidad());
                resultSetAux = statement.executeQuery();

                resultSetAux.next();

                final int totalEnfermedadesAgregadas = resultSetAux.getInt(1);
                
                // OBTENIENDO EL TOTAL DE EXAMENES ASIGNADOS
                statement = connection.prepareStatement(SQL_OBTENER_TOTAL_EXAMENES_ASIGNADOS);
                statement.setInt(1, subespecialidad.getCodigoSubespecialidad());
                resultSetAux = statement.executeQuery();

                resultSetAux.next();

                final int totalExamenesAsignados = resultSetAux.getInt(1);
                
                subespecialidadesPersonalizadas.add(new SubespecialidadPersonalizada(subespecialidad, totalMuestrasBiologicasAsignadas, totalEnfermedadesAgregadas, totalExamenesAsignados));
            }
            return subespecialidadesPersonalizadas;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLSubespecialidad - ObtenerTodos: " + sqlException.getMessage());
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

    public List<MuestraBiologica> obtenerMuestrasBiologicasDisponibles(final Subespecialidad subespecialidad) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_MUESTRAS_BIOLOGICAS_DISPONIBLES));
            
            final List<MuestraBiologica> muestrasBiologicas;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_MUESTRAS_BIOLOGICAS_DISPONIBLES);
            statement.setInt(1, subespecialidad.getCodigoSubespecialidad());
            resultSet = statement.executeQuery();

            muestrasBiologicas = new ArrayList<>();
            while (resultSet.next()) {
                final int codigo_muestra_biologica = resultSet.getInt(1);
                final String muestra_biologica_tipo = resultSet.getString(2);
                final int muestra_biologica_estado = resultSet.getInt(3);
                final MuestraBiologica muestraBiologica = new MuestraBiologica(codigo_muestra_biologica, muestra_biologica_tipo, muestra_biologica_estado);
                muestrasBiologicas.add(muestraBiologica);
            }
            return muestrasBiologicas;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLSubespecialidad - Obtener Muestras Biologicas Disponibles: " + sqlException.getMessage());
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

    public List<SubespecialidadMuestra> obtenerMuestrasBiologicasAsignadas(final Subespecialidad subespecialidad) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_MUESTRAS_BIOLOGICAS_ASIGNADAS));
            
            final List<SubespecialidadMuestra> subespecialidadesMuestras;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_MUESTRAS_BIOLOGICAS_ASIGNADAS);
            statement.setInt(1, subespecialidad.getCodigoSubespecialidad());
            resultSet = statement.executeQuery();

            subespecialidadesMuestras = new ArrayList<>();
            while (resultSet.next()) {
                final int codigo_subespecialidad_muestra = resultSet.getInt(1);
                final int subespecialidad_muestra_estado = resultSet.getInt(4);

                final int codigo_muestra_biologica = resultSet.getInt(5);
                final String muestra_biologica_tipo = resultSet.getString(6);
                final int muestra_biologica_estado = resultSet.getInt(7);

                final MuestraBiologica muestraBiologica = new MuestraBiologica(codigo_muestra_biologica, muestra_biologica_tipo, muestra_biologica_estado);

                subespecialidadesMuestras.add(new SubespecialidadMuestra(codigo_subespecialidad_muestra, subespecialidad, muestraBiologica, subespecialidad_muestra_estado));
            }
            return subespecialidadesMuestras;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLSubespecialidad - ObtenerMuestrasBiologicasAsignadas: " + sqlException.getMessage());
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
    
    public List<Enfermedad> obtenerEnfermedades(final Subespecialidad subespecialidad) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_ENFERMEDADES));
            
            final List<Enfermedad> enfermedades;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_ENFERMEDADES);
            statement.setInt(1, subespecialidad.getCodigoSubespecialidad());
            resultSet = statement.executeQuery();

            enfermedades = new ArrayList<>();
            while (resultSet.next()) {
                final int codigoEnfermdad = resultSet.getInt(1);
                final String enfermedadNombre = resultSet.getString(3);
                final int enfermedadEstado = resultSet.getInt(4);
                
                enfermedades.add(new Enfermedad(codigoEnfermdad, subespecialidad, enfermedadNombre, enfermedadEstado));
            }
            return enfermedades;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLSubespecialidad - Obtener Enfermedades: " + sqlException.getMessage());
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

    public Boolean actualizar(final Subespecialidad subespecialidad) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ACTUALIZAR));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_ACTUALIZAR);
            statement.setInt(1, subespecialidad.getEspecialidad().getCodigoEspecialidad());
            statement.setString(2, subespecialidad.getSubespecialidadNombre());
            statement.setInt(3, subespecialidad.getCodigoSubespecialidad());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLSubespecialidad - Actualizar: " + sqlException.getMessage());
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

    public Boolean eliminar(final Subespecialidad subespecialidad) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ELIMINAR));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_ELIMINAR);
            statement.setInt(1, subespecialidad.getCodigoSubespecialidad());
            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLSubespecialidad - Eliminar: " + sqlException.getMessage());
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

    public int verificarExistencia(final Subespecialidad subespecialidad) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_VERIFICAR_EXISTENCIA));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_VERIFICAR_EXISTENCIA);
            statement.setInt(1, subespecialidad.getCodigoSubespecialidad());
            statement.setString(2, subespecialidad.getSubespecialidadNombre());
            statement.setInt(3, subespecialidad.getEspecialidad().getCodigoEspecialidad());
            
            resultSet = statement.executeQuery();
            resultSet.next();
            
            return resultSet.getBoolean(1) ? 1 : 0;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLSubspecialidad - Verificar Existencia: " + sqlException.getMessage());
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

    public int verificarTablaVaciaMuestrasBiologicas() {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_VERIFICAR_TABLA_VACIA_MUESTRA_BIOLOGICA));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_VERIFICAR_TABLA_VACIA_MUESTRA_BIOLOGICA);

            resultSet = statement.executeQuery();
            resultSet.next();
            
            return resultSet.getBoolean(1) ? 1 : 0;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLSubspecialidad - Verificar Tabla Vacia Muestras Biologicas: " + sqlException.getMessage());
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

    public Boolean insertarEnLog(final LogConsulta logConsulta) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_INSERTAR_EN_LOG);
            statement.setInt(1, logConsulta.getPersonalTecnico().getCodigoPersonalTecnico());
            statement.setString(2, logConsulta.getConsultaEjecutada());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLSubespecialidad - InsertarEnLog: " + sqlException.getMessage());
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