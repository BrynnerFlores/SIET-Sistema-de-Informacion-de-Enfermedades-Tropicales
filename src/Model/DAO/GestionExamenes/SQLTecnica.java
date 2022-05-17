package Model.DAO.GestionExamenes;

import Model.DAO.DataBaseConfiguration;
import Model.DAO.GestionCuenta.SQLCuenta;
import Model.POJO.Conexion;
import Model.POJO.LogConsulta;
import Model.POJO.PersonalTecnico;
import Model.POJO.Tecnica;
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
public class SQLTecnica {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final Conexion conexion = DataBaseConfiguration.CONEXION;

    private final String url = "jdbc:postgresql://" + conexion.getHost() + ":" + conexion.getPuerto() + "/" + conexion.getNombreBaseDatos();
    private final String user = conexion.getUsuario();
    private final String password = conexion.getPassword();

    private final String SQL_INSERTAR_EN_LOG = "INSERT INTO alogcon(palccoloco, falccopete, calcconeje) VALUES(nextval('palccoloco_sequence'), ?, ?)";
    private final String SQL_INSERTAR = "INSERT INTO atecnic(patncodtec, fatncodexa, catntecnom, catntecmet, catntecest) VALUES(nextval('patncodtec_sequence'), ?, ?, ?, ?)";
    private final String SQL_ACTUALIZAR = "UPDATE atecnic SET catntecnom = ?, catntecmet = ? WHERE patncodtec = ? AND catntecest = 1";
    private final String SQL_ELIMINAR_TECNICA = "UPDATE atecnic SET catntecest = 0 WHERE patncodtec = ? AND catntecest = 1";
    private final String SQL_VERIFICAR_EXISTENCIA = "SELECT EXISTS (SELECT 1 FROM atecnic WHERE patncodtec != ? AND fatncodexa = ? AND catntecnom = ? AND catntecmet = ? AND catntecest = 1)";
    private final PersonalTecnico PERSONAL_TECNICO;

    private PreparedStatement statement;
    private ResultSet resultSet;
    private Connection connection;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public SQLTecnica() {
        connection = null;
        resultSet = null;
        PERSONAL_TECNICO = Utilidades.obtenerCuentaLocal().getPersonalTecnico();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Queries">
    
    public Boolean insertar(final Tecnica tecnica) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INSERTAR));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_INSERTAR);
            statement.setInt(1, tecnica.getExamen().getCodigoExamen());
            statement.setString(2, tecnica.getTecnicaNombre());
            statement.setString(3, tecnica.getTecnicaMetodo());
            statement.setInt(4, tecnica.getTecnicaEstado());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLTecnica - Insertar: " + sqlException.getMessage());
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
    
    public Boolean actualizar(final Tecnica tecnica) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ACTUALIZAR));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_ACTUALIZAR);
            statement.setString(1, tecnica.getTecnicaNombre());
            statement.setString(2, tecnica.getTecnicaMetodo());
            statement.setInt(3, tecnica.getCodigoTecnica());
            
            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLTecnica - Actualizar: " + sqlException.getMessage());
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
    
    public Boolean eliminar(final Tecnica tecnica) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ELIMINAR_TECNICA));
            
            connection = DriverManager.getConnection(url, user, password);
            
            statement = connection.prepareStatement(SQL_ELIMINAR_TECNICA);
            statement.setInt(1, tecnica.getCodigoTecnica());
            
            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLTecnica - Eliminar: " + sqlException.getMessage());
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
    
    public int verificarExistencia(final Tecnica tecnica) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INSERTAR));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_VERIFICAR_EXISTENCIA);
            statement.setInt(1, tecnica.getCodigoTecnica());
            statement.setInt(2, tecnica.getExamen().getCodigoExamen());
            statement.setString(3, tecnica.getTecnicaNombre());
            statement.setString(4, tecnica.getTecnicaMetodo());

            resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getBoolean(1) ? 1 : 0;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLTecnica - Verificar Existencia: " + sqlException.getMessage());
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
            System.err.println("Error en SQLTecnica - InsertarEnLog: " + sqlException.getMessage());
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