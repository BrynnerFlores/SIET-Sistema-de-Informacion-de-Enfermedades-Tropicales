package Model.DAO.GestionEspecialidad;

import Model.DAO.DataBaseConfiguration;
import Model.DAO.GestionCuenta.SQLCuenta;
import Model.POJO.Conexion;
import Model.POJO.Especialidad;
import Model.POJO.LogConsulta;
import Model.POJO.PersonalTecnico;
import Model.POJO.Subespecialidad;
import Model.POJOPersonalizado.EspecialidadPersonalizada;
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
public class SQLEspecialidad {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final Conexion conexion = DataBaseConfiguration.CONEXION;

    private final String url = "jdbc:postgresql://" + conexion.getHost() + ":" + conexion.getPuerto() + "/" + conexion.getNombreBaseDatos();
    private final String user = conexion.getUsuario();
    private final String password = conexion.getPassword();

    private final String SQL_INSERTAR = "INSERT INTO aespeci(paeecodesp, caeeespnom, caeeespest) VALUES(nextval('paeecodesp_sequence'), ?, ?)";
    
    private final String SQL_INSERTAR_EN_LOG = "INSERT INTO alogcon(palccoloco, falccopete, calcconeje) VALUES(nextval('palccoloco_sequence'), ?, ?)";
    
    private final String SQL_OBTENER_TODOS = "SELECT * FROM aespeci WHERE caeeespest = 1 ORDER BY paeecodesp";
    private final String SQL_OBTENER_TOTAL_SUBESPECIALIDADES_ASIGNADAS = "SELECT COUNT(*) FROM asubesp WHERE fasecodesp = ? AND casesubest = 1";
    private final String SQL_OBTENER_SUBESPECIALIDADES_ASIGNADAS = "SELECT * FROM asubesp WHERE fasecodesp = ? AND casesubest = 1";
    private final String SQL_ACTUALIZAR = "UPDATE aespeci SET caeeespnom = ? WHERE paeecodesp = ? AND caeeespest = 1";
    private final String SQL_ELIMINAR = "UPDATE aespeci SET caeeespest = 0 WHERE paeecodesp = ? AND caeeespest = 1";
    private final String SQL_VERIFICAR_EXISTENCIA = "SELECT EXISTS (SELECT 1 FROM aespeci WHERE paeecodesp != ? AND caeeespnom = ? AND caeeespest = 1)";
    private final String SQL_VERIFICAR_TABLA_VACIA_SUBESPECIALIDADES = "SELECT CASE WHEN EXISTS (SELECT 1 FROM asubesp) THEN 1 ELSE 0 end";
    private final PersonalTecnico PERSONAL_TECNICO;

    private PreparedStatement statement;
    private ResultSet resultSet;
    private ResultSet resultSetAux;
    private Connection connection;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public SQLEspecialidad() {
        connection = null;
        resultSet = null;
        resultSetAux = null;
        
        PERSONAL_TECNICO = Utilidades.obtenerCuentaLocal().getPersonalTecnico();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Queries">
    
    public Boolean insertar(final Especialidad especialidad) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INSERTAR));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_INSERTAR);
            statement.setString(1, especialidad.getEspecialidadNombre());
            statement.setInt(2, especialidad.getEspecialidadEstado());
            
            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLEspecialidad - Insertar: " + sqlException.getMessage());
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

    public List<EspecialidadPersonalizada> obtenerTodos() {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_TODOS));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_TOTAL_SUBESPECIALIDADES_ASIGNADAS));
            
            final List<EspecialidadPersonalizada> especialidadesPersonalizadas;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_TODOS);
            resultSet = statement.executeQuery();

            especialidadesPersonalizadas = new ArrayList<>();
            while (resultSet.next()) {
                final int codigo_especialidad = resultSet.getInt(1);
                final String especialidad_nombre = resultSet.getString(2);
                final int especialidad_estado = resultSet.getInt(3);

                final Especialidad especialidad = new Especialidad(codigo_especialidad, especialidad_nombre, especialidad_estado);

                statement = connection.prepareStatement(SQL_OBTENER_TOTAL_SUBESPECIALIDADES_ASIGNADAS);
                statement.setInt(1, especialidad.getCodigoEspecialidad());
                resultSetAux = statement.executeQuery();

                resultSetAux.next();

                final int totalSubespecialidadesAsignadas = resultSetAux.getInt(1);

                especialidadesPersonalizadas.add(new EspecialidadPersonalizada(especialidad, totalSubespecialidadesAsignadas));
            }
            return especialidadesPersonalizadas;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLEspecialidad: " + sqlException.getMessage());
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

    public List<Subespecialidad> obtenerSubespecialidadesAsignadas(final Especialidad especialidad) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_SUBESPECIALIDADES_ASIGNADAS));
            
            final List<Subespecialidad> subespecialidades;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_SUBESPECIALIDADES_ASIGNADAS);
            statement.setInt(1, especialidad.getCodigoEspecialidad());
            resultSet = statement.executeQuery();

            subespecialidades = new ArrayList<>();
            while (resultSet.next()) {
                final int codigo_subespecialidad = resultSet.getInt(1);
                final String subespecialidad_nombre = resultSet.getString(3);
                final int subespecialidad_estado = resultSet.getInt(4);

                subespecialidades.add(new Subespecialidad(codigo_subespecialidad, especialidad, subespecialidad_nombre, subespecialidad_estado));
            }
            return subespecialidades;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLSubespecialidad - ObtenerEspecialidadesAsignadas(): " + sqlException.getMessage());
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

    public Boolean actualizar(final Especialidad especialidad) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ACTUALIZAR));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_ACTUALIZAR);
            statement.setString(1, especialidad.getEspecialidadNombre());
            statement.setInt(2, especialidad.getCodigoEspecialidad());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLEspecialidad - Actualizar: " + sqlException.getMessage());
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

    public Boolean eliminar(final Especialidad especialidad) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ELIMINAR));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_ELIMINAR);
            statement.setInt(1, especialidad.getCodigoEspecialidad());
            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLEspecialidad - Eliminar: " + sqlException.getMessage());
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

    public int verificarExistencia(final Especialidad especialidad) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_VERIFICAR_EXISTENCIA));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_VERIFICAR_EXISTENCIA);
            statement.setInt(1, especialidad.getCodigoEspecialidad());
            statement.setString(2, especialidad.getEspecialidadNombre());

            resultSet = statement.executeQuery();
            resultSet.next();
            final Boolean isExists = resultSet.getBoolean(1);

            if (isExists) {
                return 1;
            } else {
                return 0;
            }
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLEspecialidad - Verificar Existencia: " + sqlException.getMessage());
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

    public int verificarTablaVaciaSubespecialidades() {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_VERIFICAR_TABLA_VACIA_SUBESPECIALIDADES));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_VERIFICAR_TABLA_VACIA_SUBESPECIALIDADES);

            resultSet = statement.executeQuery();
            resultSet.next();
            final Boolean isTablaVacia = resultSet.getBoolean(1);

            if (isTablaVacia) {
                return 1;
            } else {
                return 0;
            }
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLEspecialidad - Verificar Tabla Vacia Subespecialidades: " + sqlException.getMessage());
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
            System.err.println("Error en SQLEspecialidad - InsertarEnLog: " + sqlException.getMessage());
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