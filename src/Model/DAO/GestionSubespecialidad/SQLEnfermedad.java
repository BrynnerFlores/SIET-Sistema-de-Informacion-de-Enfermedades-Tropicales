package Model.DAO.GestionSubespecialidad;

import Model.DAO.DataBaseConfiguration;
import Model.DAO.GestionCuenta.SQLCuenta;
import Model.POJO.Conexion;
import Model.POJO.Enfermedad;
import Model.POJO.LogConsulta;
import Model.POJO.PersonalTecnico;
import View.Utilitarios.Utilidades;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brynner
 */
public class SQLEnfermedad {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final Conexion conexion = DataBaseConfiguration.CONEXION;

    private final String url = "jdbc:postgresql://" + conexion.getHost() + ":" + conexion.getPuerto() + "/" + conexion.getNombreBaseDatos();
    private final String user = conexion.getUsuario();
    private final String password = conexion.getPassword();

    private final String SQL_INSERTAR_EN_LOG = "INSERT INTO alogcon(palccoloco, falccopete, calcconeje) VALUES(nextval('palccoloco_sequence'), ?, ?)";
    private final String SQL_INSERTAR = "INSERT INTO aenferm(paeecodenf, faeecodsub, caeeenfnom, caeeenfest) VALUES(nextval('paeecodenf_sequence'), ?, ?, ?)";
    private final String SQL_ACTUALIZAR = "UPDATE aenferm SET faeecodsub = ?, caeeenfnom = ? WHERE paeecodenf = ? AND caeeenfest = 1";
    private final String SQL_ELIMINAR = "UPDATE aenferm SET caeeenfest = 0 WHERE paeecodenf = ? AND caeeenfest = 1";
    private final String SQL_VERIFICAR_EXISTENCIA = "SELECT EXISTS (SELECT 1 FROM aenferm WHERE paeecodenf != ? AND faeecodsub = ? AND caeeenfnom = ? AND caeeenfest = 1)";
    private final PersonalTecnico PERSONAL_TECNICO;

    private PreparedStatement statement;
    private ResultSet resultSet;
    private Connection connection;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public SQLEnfermedad() {
        connection = null;
        resultSet = null;
        PERSONAL_TECNICO = Utilidades.obtenerCuentaLocal().getPersonalTecnico();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Queries">
    
    public Boolean insertar(final Enfermedad enfermedad) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INSERTAR));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_INSERTAR);
            statement.setInt(1, enfermedad.getSubespecialidad().getCodigoSubespecialidad());
            statement.setString(2, enfermedad.getEnfermedadNombre());
            statement.setInt(3, enfermedad.getEnfermedadEstado());
            
            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLEnfermedad - Insertar: " + sqlException.getMessage());
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

    public Boolean actualizar(final Enfermedad enfermedad) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ACTUALIZAR));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_ACTUALIZAR);
            statement.setInt(1, enfermedad.getSubespecialidad().getCodigoSubespecialidad());
            statement.setString(2, enfermedad.getEnfermedadNombre());
            statement.setInt(3, enfermedad.getCodigoEnfermedad());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLEnfermedad - Actualizar: " + sqlException.getMessage());
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

    public Boolean eliminar(final Enfermedad enfermedad) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ELIMINAR));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_ELIMINAR);
            statement.setInt(1, enfermedad.getCodigoEnfermedad());
            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLEnfermedad - Eliminar: " + sqlException.getMessage());
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

    public int verificarExistencia(final Enfermedad enfermedad) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_VERIFICAR_EXISTENCIA));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_VERIFICAR_EXISTENCIA);
            statement.setInt(1, enfermedad.getCodigoEnfermedad());
            statement.setInt(2, enfermedad.getSubespecialidad().getCodigoSubespecialidad());
            statement.setString(3, enfermedad.getEnfermedadNombre());
            
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
    
    public Boolean insertarEnLog(final LogConsulta logConsulta) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_INSERTAR_EN_LOG);
            statement.setInt(1, logConsulta.getPersonalTecnico().getCodigoPersonalTecnico());
            statement.setString(2, logConsulta.getConsultaEjecutada());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLEnfermedad - InsertarEnLog: " + sqlException.getMessage());
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