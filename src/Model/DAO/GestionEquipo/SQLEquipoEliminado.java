package Model.DAO.GestionEquipo;

import Model.DAO.DataBaseConfiguration;
import Model.DAO.GestionCuenta.SQLCuenta;
import Model.POJO.Conexion;
import Model.POJO.PersonalTecnico;
import Model.POJO.Equipo;
import Model.POJO.EquipoEliminado;
import Model.POJO.LogConsulta;
import Model.POJO.Persona;
import Model.POJO.Subespecialidad;
import View.Utilitarios.Utilidades;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brynner
 */
public class SQLEquipoEliminado {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final Conexion conexion = DataBaseConfiguration.CONEXION;

    private final String url = "jdbc:postgresql://" + conexion.getHost() + ":" + conexion.getPuerto() + "/" + conexion.getNombreBaseDatos();
    private final String user = conexion.getUsuario();
    private final String password = conexion.getPassword();

    private final String SQL_INSERTAR_EN_LOG = "INSERT INTO alogcon(palccoloco, falccopete, calcconeje) VALUES(nextval('palccoloco_sequence'), ?, ?)";
    private final String SQL_DAR_BAJA = "UPDATE aequipo SET caeiequest = 0 WHERE paeicodequ = ? AND caeiequest = 1";
    private final String SQL_INSERTAR_ELIMINACION = "INSERT INTO aequeli(paeecoeqel, faeecodequ, caeefeceli, caeehoreli, caeemoteli) VALUES(nextval('paeecoeqel_sequence'), ?, ?, ?, ?)";
    private final String SQL_OBTENER_EQUIPOS_ELIMINADOS = "SELECT paeecoeqel, faeecodequ, caeefeceli, caeehoreli, caeemoteli, paeicodequ, faeicopete, faeicodsub, caeiequnom, caeiequmar, caeiequmod, caeieqnuse, caeieqfead, caeiequpro, caeieqreen, caeiequint, caeiequgar, caeiequubi, caeiequobs, caeiequfot, caeiequest, paptcopete, faptcodper, captperpro, captpefein, captpehoin, captperhab, papscodper, capspeceid, capsperape, capspernom, capspersex, pasecodsub, casesubnom, casesubest FROM aequeli INNER JOIN aequipo ON aequipo.paeicodequ = aequeli.faeecodequ INNER JOIN apertec ON aequipo.faeicopete = apertec.paptcopete INNER JOIN aperson ON aperson.papscodper = apertec.faptcodper INNER JOIN asubesp ON asubesp.pasecodsub = aequipo.faeicodsub ORDER BY aequipo.paeicodequ DESC";
    private final PersonalTecnico PERSONAL_TECNICO;

    private PreparedStatement statement;
    private ResultSet resultSet;
    private Connection connection;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public SQLEquipoEliminado() {
        connection = null;
        resultSet = null;
        PERSONAL_TECNICO = Utilidades.obtenerCuentaLocal().getPersonalTecnico();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Queries">
    
    public List<EquipoEliminado> obtenerEquiposEliminados() {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_EQUIPOS_ELIMINADOS));
            
            final List<EquipoEliminado> equiposEliminados;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_EQUIPOS_ELIMINADOS);
            resultSet = statement.executeQuery();

            equiposEliminados = new ArrayList<>();
            while (resultSet.next()) {
                final int codigo_equipo_eliminacion = resultSet.getInt(1);
                final Date fecha_eliminacion = resultSet.getDate(3);
                final Time hora_eliminacion = resultSet.getTime(4);
                final String motivo_eliminacion = resultSet.getString(5);

                final int codigo_equipo = resultSet.getInt(6);
                final String equipo_nombre = resultSet.getString(9);
                final String equipo_marca = resultSet.getString(10);
                final String equipo_modelo = resultSet.getString(11);
                final String equipo_numero_serie = resultSet.getString(12);
                final Date equipo_fecha_adquisicion = resultSet.getDate(13);
                final String equipo_proveedor = resultSet.getString(14);
                final String equipo_responsable_entrega = resultSet.getString(15);
                final String equipo_integridad = resultSet.getString(16);
                final int equipo_garantia = resultSet.getInt(17);
                final String equipo_ubicacion = resultSet.getString(18);
                final String equipo_observaciones = resultSet.getString(19);
                final byte[] equipo_foto = resultSet.getBytes(20);
                final int equipo_estado = resultSet.getInt(21);

                final int codigo_personal_tecnico = resultSet.getInt(22);
                final String personal_tecnico_profesion = resultSet.getString(24);
                final Date personal_tecnico_fecha_inicio = resultSet.getDate(25);
                final Time personal_tecnico_hora_inicio = resultSet.getTime(26);
                final Boolean personal_tecnico_habilitado = resultSet.getBoolean(27);

                final int pcodigo_persona = resultSet.getInt(28);
                final String cedula_identidad = resultSet.getString(29);
                final String persona_apellido = resultSet.getString(30);
                final String persona_nombre = resultSet.getString(31);
                final String personas_sexo = resultSet.getString(32);

                final int codigo_subespecialidad = resultSet.getInt(33);
                final String subespecialidad_nombre = resultSet.getString(34);
                final int subespecialidad_estado = resultSet.getInt(35);

                final Persona persona = new Persona(pcodigo_persona, cedula_identidad, persona_apellido, persona_nombre, personas_sexo);
                final Subespecialidad subespecialidad = new Subespecialidad(codigo_subespecialidad, null, subespecialidad_nombre, subespecialidad_estado);
                final PersonalTecnico personalTecnico = new PersonalTecnico(codigo_personal_tecnico, persona, personal_tecnico_profesion, personal_tecnico_fecha_inicio, personal_tecnico_hora_inicio, personal_tecnico_habilitado);
                final Equipo equipo = new Equipo(codigo_equipo, personalTecnico, subespecialidad, equipo_nombre, equipo_marca, equipo_modelo, equipo_numero_serie, equipo_fecha_adquisicion, equipo_proveedor, equipo_responsable_entrega, equipo_integridad, equipo_garantia, equipo_ubicacion, equipo_observaciones, equipo_foto, equipo_estado);
                equiposEliminados.add(new EquipoEliminado(codigo_equipo_eliminacion, equipo, fecha_eliminacion, hora_eliminacion, motivo_eliminacion));
            }
            return equiposEliminados;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLEquipoEliminado - ObtenerEquiposEliminados: " + sqlException.getMessage());
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

    public Boolean eliminar(final EquipoEliminado equipoEliminado) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INSERTAR_ELIMINACION));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_DAR_BAJA));
            
            final Equipo equipo = equipoEliminado.getEquipo();
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(SQL_INSERTAR_ELIMINACION);
            statement.setInt(1, equipo.getCodigoEquipo());
            statement.setDate(2, equipoEliminado.getFechaEliminacion());
            statement.setTime(3, equipoEliminado.getHoraEliminacion());
            statement.setString(4, equipoEliminado.getMotivoEliminacion());

            if (statement.executeUpdate() == 1) {
                statement = connection.prepareStatement(SQL_DAR_BAJA);
                statement.setInt(1, equipo.getCodigoEquipo());

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
            System.err.println("Error en SQLEquipoEliminado - Eliminar: " + sqlException.getMessage());
            return false;
        } catch (final Exception exception) {
            System.err.println("Error en SQLEquipoEliminado - Eliminar: " + exception.getMessage());
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
    
    public Boolean insertarEnLog(final LogConsulta logConsulta) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_INSERTAR_EN_LOG);
            statement.setInt(1, logConsulta.getPersonalTecnico().getCodigoPersonalTecnico());
            statement.setString(2, logConsulta.getConsultaEjecutada());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLEquipoEliminado - InsertarEnLog: " + sqlException.getMessage());
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