package Model.DAO.GestionRecepciones;

import Model.DAO.DataBaseConfiguration;
import Model.DAO.GestionCuenta.SQLCuenta;
import Model.POJO.Conexion;
import Model.POJO.Establecimiento;
import Model.POJO.LogConsulta;
import Model.POJO.PersonalTecnico;
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
public class SQLEstablecimiento {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final Conexion conexion = DataBaseConfiguration.CONEXION;

    private final String url = "jdbc:postgresql://" + conexion.getHost() + ":" + conexion.getPuerto() + "/" + conexion.getNombreBaseDatos();
    private final String user = conexion.getUsuario();
    private final String password = conexion.getPassword();

    private final String SQL_INSERTAR_EN_LOG = "INSERT INTO alogcon(palccoloco, falccopete, calcconeje) VALUES(nextval('palccoloco_sequence'), ?, ?)";
    private final String SQL_OBTENER_ESTABLECIMIENTOS = "SELECT * FROM aestabl WHERE caeaestest = 1 ORDER BY paeacodest DESC";
    private final String SQL_INSERTAR = "INSERT INTO aestabl(paeacodest, caeaestnom, caeaesttip, caeaestare, caeaestest) VALUES(nextval('paeacodest_sequence'), ?, ?, ?, ?)";
    private final String SQL_ACTUALIZAR = "UPDATE aestabl SET caeaestnom = ?, caeaesttip = ?, caeaestare = ? WHERE paeacodest = ? AND caeaestest = 1";
    private final String SQL_ELIMINAR = "UPDATE aestabl SET caeaestest = 0 WHERE paeacodest = ? AND caeaestest = 1";
    private final String SQL_VERIFICAR_EXISTENCIA = "SELECT EXISTS (SELECT 1 FROM aestabl WHERE paeacodest != ? AND caeaestnom = ? AND caeaestest = 1)";
    private final PersonalTecnico PERSONAL_TECNICO;

    private PreparedStatement statement;
    private ResultSet resultSet;
    private Connection connection;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public SQLEstablecimiento() {
        connection = null;
        resultSet = null;
        PERSONAL_TECNICO = Utilidades.obtenerCuentaLocal().getPersonalTecnico();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Queries">
    
    public List<Establecimiento> obtenerEstablecimientos() {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_ESTABLECIMIENTOS));
            
            final List<Establecimiento> establecimientos;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_ESTABLECIMIENTOS);

            resultSet = statement.executeQuery();

            establecimientos = new ArrayList<>();

            while (resultSet.next()) {
                final int codigoEstablecimiento = resultSet.getInt(1);
                final String establecimientoNombre = resultSet.getString(2);
                final String establecimientoTipo = resultSet.getString(3);
                final String establecimientoArea = resultSet.getString(4);
                final int establecimientoEstado = resultSet.getInt(5);

                establecimientos.add(new Establecimiento(codigoEstablecimiento, establecimientoNombre, establecimientoTipo, establecimientoArea, establecimientoEstado));
            }
            return establecimientos;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLEstablecimiento - Obtener Establecimientos: " + sqlException.getMessage());
            return null;
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

    public Boolean insertar(final Establecimiento establecimiento) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INSERTAR));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_INSERTAR);
            statement.setString(1, establecimiento.getEstablecimientoNombre());
            statement.setString(2, establecimiento.getEstablecimientoTipo());
            statement.setString(3, establecimiento.getEstablecimientoArea());
            statement.setInt(4, establecimiento.getEstablecimientoEstado());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLEstablecimiento - Insertar " + sqlException.getMessage());
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

    public Boolean actualizar(final Establecimiento establecimiento) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ACTUALIZAR));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_ACTUALIZAR);
            statement.setString(1, establecimiento.getEstablecimientoNombre());
            statement.setString(2, establecimiento.getEstablecimientoTipo());
            statement.setString(3, establecimiento.getEstablecimientoArea());
            statement.setInt(4, establecimiento.getCodigoEstablecimiento());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLEstablecimiento - Actualizar: " + sqlException.getMessage());
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

    public Boolean eliminar(final Establecimiento establecimiento) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ELIMINAR));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_ELIMINAR);
            statement.setInt(1, establecimiento.getCodigoEstablecimiento());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLEstablecimiento - Eliminar: " + sqlException.getMessage());
            return false;
        } catch (final Exception exception) {
            System.err.println("Error en SQLEstablecimiento - Eliminar: " + exception.getMessage());
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

    public int verificarExistencia(final Establecimiento establecimiento) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_VERIFICAR_EXISTENCIA));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_VERIFICAR_EXISTENCIA);
            statement.setInt(1, establecimiento.getCodigoEstablecimiento());
            statement.setString(2, establecimiento.getEstablecimientoNombre());

            resultSet = statement.executeQuery();
            resultSet.next();
            final Boolean isExists = resultSet.getBoolean(1);

            if (isExists) {
                return 1;
            } else {
                return 0;
            }
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLEstablecimiento - Verificar Existencia: " + sqlException.getMessage());
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
            System.err.println("Error en SQLEstablecimiento - InsertarEnLog: " + sqlException.getMessage());
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