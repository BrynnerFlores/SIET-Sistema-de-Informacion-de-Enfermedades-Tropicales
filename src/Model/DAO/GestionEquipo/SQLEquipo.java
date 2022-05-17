package Model.DAO.GestionEquipo;

import Model.DAO.DataBaseConfiguration;
import Model.DAO.GestionCuenta.SQLCuenta;
import Model.POJO.Conexion;
import Model.POJO.PersonalTecnico;
import Model.POJO.Equipo;
import Model.POJO.Intervencion;
import Model.POJO.LogConsulta;
import Model.POJO.Persona;
import Model.POJO.Subespecialidad;
import View.Utilitarios.Utilidades;
import java.io.ByteArrayInputStream;
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
public class SQLEquipo {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final Conexion conexion = DataBaseConfiguration.CONEXION;

    private final String url = "jdbc:postgresql://" + conexion.getHost() + ":" + conexion.getPuerto() + "/" + conexion.getNombreBaseDatos();
    private final String user = conexion.getUsuario();
    private final String password = conexion.getPassword();

    private final String SQL_INSERTAR_EN_LOG = "INSERT INTO alogcon(palccoloco, falccopete, calcconeje) VALUES(nextval('palccoloco_sequence'), ?, ?)";
    private final String SQL_INSERTAR = "INSERT INTO aequipo(paeicodequ, faeicopete, faeicodsub, caeiequnom, caeiequmar, caeiequmod, caeieqnuse, caeieqfead, caeiequpro, caeieqreen, caeiequint, caeiequgar, caeiequubi, caeiequobs, caeiequfot , caeiequest) VALUES(nextval('paeicodequ_sequence'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String SQL_OBTENER_EQUIPOS = "SELECT paeicodequ, faeicopete, faeicodsub, caeiequnom, caeiequmar, caeiequmod, caeieqnuse, caeieqfead, caeiequpro, caeieqreen, caeiequint, caeiequgar, caeiequubi, caeiequobs, caeiequfot, caeiequest, paptcopete, faptcodper, captperpro, captpefein, captpehoin, captperhab, papscodper, capspeceid, capsperape, capspernom, capspersex, pasecodsub, casesubnom, casesubest FROM aequipo INNER JOIN apertec ON aequipo.faeicopete = apertec.paptcopete INNER JOIN aperson ON aperson.papscodper = apertec.faptcodper INNER JOIN asubesp ON asubesp.pasecodsub = aequipo.faeicodsub WHERE paeicodequ NOT IN (SELECT faiecodequ FROM ainterv WHERE caieintest = 1) AND aequipo.caeiequest = 1 ORDER BY aequipo.paeicodequ DESC";
    private final String SQL_OBTENER_INTERVENCIONES_EQUIPO = "SELECT paiecodint, faiecodequ, caieinfein, caieinhoin, caieinfefi, caieinhofi, caieintcau, caieintrre, caieindeac, caieintobs, caieintest, paeicodequ, faeicopete, faeicodsub, caeiequnom, caeiequmar, caeiequmod, caeieqnuse, caeieqfead, caeiequpro, caeiequint, caeiequgar, caeiequobs, caeiequest, paptcopete, faptcodper, captperpro, captpefein, captpehoin, captperhab, papscodper, capspeceid, capsperape, capspernom, capspersex, pasecodsub, casesubnom, casesubest FROM ainterv INNER JOIN aequipo ON ainterv.faiecodequ = aequipo.paeicodequ INNER JOIN apertec ON aequipo.faeicopete = apertec.paptcopete INNER JOIN aperson ON aperson.papscodper = apertec.faptcodper INNER JOIN asubesp ON asubesp.pasecodsub = aequipo.faeicodsub WHERE ainterv.faiecodequ = ? AND ainterv.caieintest = 0 ORDER BY paiecodint DESC";
    private final String SQL_ACTUALIZAR = "UPDATE aequipo SET faeicopete = ?, faeicodsub = ?, caeiequnom = ?, caeiequmar = ?, caeiequmod = ?, caeieqnuse = ?, caeieqfead = ?, caeiequpro = ?, caeieqreen = ?, caeiequint = ?, caeiequgar = ?, caeiequubi = ?, caeiequobs = ?, caeiequfot = ? WHERE paeicodequ = ? AND caeiequest = 1";
    private final String SQL_VERIFICAR_EXISTENCIA = "SELECT EXISTS (SELECT 1 FROM aequipo WHERE paeicodequ != ? AND caeieqnuse = ? AND caeiequest = 1)";
    private final PersonalTecnico PERSONAL_TECNICO;

    private PreparedStatement statement;
    private ResultSet resultSet;
    private Connection connection;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public SQLEquipo() {
        connection = null;
        resultSet = null;
        PERSONAL_TECNICO = Utilidades.obtenerCuentaLocal().getPersonalTecnico();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Queries">
    
    public Boolean insertar(final Equipo equipo) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INSERTAR));
            
            final PersonalTecnico personalTecnico = equipo.getPersonalTecnico();
            final Subespecialidad subespecialidad = equipo.getSubespecialidad();
            
            connection = DriverManager.getConnection(url, user, password);
            
            statement = connection.prepareStatement(SQL_INSERTAR);
            statement.setInt(1, personalTecnico.getCodigoPersonalTecnico());
            statement.setInt(2, subespecialidad.getCodigoSubespecialidad());
            statement.setString(3, equipo.getEquipoNombre());
            statement.setString(4, equipo.getEquipoMarca());
            statement.setString(5, equipo.getEquipoModelo());
            statement.setString(6, equipo.getEquipoNumeroSerie());
            statement.setDate(7, equipo.getEquipoFechaAdquisicion());
            statement.setString(8, equipo.getEquipoProveedor());
            statement.setString(9, equipo.getEquipoResponsableEntrega());
            statement.setString(10, equipo.getEquipoIntegridad());
            statement.setInt(11, equipo.getEquipoGarantia());
            statement.setString(12, equipo.getEquipoUbicacion());
            statement.setString(13, equipo.getEquipoObservaciones());
            statement.setBinaryStream(14, new ByteArrayInputStream(equipo.getEquipoFoto()));
            statement.setInt(15, equipo.getEquipoEstado());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLEquipo - Insertar: " + sqlException.getMessage());
            return false;
        } catch (final Exception exception) {
            System.err.println("Error en SQLEquipo - Insertar: " + exception.getMessage());
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

    public List<Equipo> obtenerEquipos() {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_EQUIPOS));
            
            final List<Equipo> equipos;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_EQUIPOS);
            resultSet = statement.executeQuery();

            equipos = new ArrayList<>();
            while (resultSet.next()) {
                final int codigo_equipo = resultSet.getInt(1);
                final String equipo_nombre = resultSet.getString(4);
                final String equipo_marca = resultSet.getString(5);
                final String equipo_modelo = resultSet.getString(6);
                final String equipo_numero_serie = resultSet.getString(7);
                final Date equipo_fecha_adquisicion = resultSet.getDate(8);
                final String equipo_proveedor = resultSet.getString(9);
                final String equipo_responsable_entrega = resultSet.getString(10);
                final String equipo_integridad = resultSet.getString(11);
                final int equipo_garantia = resultSet.getInt(12);
                final String equipo_ubicacion = resultSet.getString(13);
                final String equipo_observaciones = resultSet.getString(14);
                final byte[] equipo_foto = resultSet.getBytes(15);
                final int equipo_estado = resultSet.getInt(16);

                final int codigo_personal_tecnico = resultSet.getInt(17);
                final String personal_tecnico_profesion = resultSet.getString(19);
                final Date personal_tecnico_fecha_inicio = resultSet.getDate(20);
                final Time personal_tecnico_hora_inicio = resultSet.getTime(21);
                final Boolean personal_tecnico_habilitado = resultSet.getBoolean(22);

                final int pcodigo_persona = resultSet.getInt(23);
                final String cedula_identidad = resultSet.getString(24);
                final String persona_apellido = resultSet.getString(25);
                final String persona_nombre = resultSet.getString(26);
                final String personas_sexo = resultSet.getString(27);

                final int codigo_subespecialidad = resultSet.getInt(28);
                final String subespecialidad_nombre = resultSet.getString(29);
                final int subespecialidad_estado = resultSet.getInt(30);

                final Persona persona = new Persona(pcodigo_persona, cedula_identidad, persona_apellido, persona_nombre, personas_sexo);
                final Subespecialidad subespecialidad = new Subespecialidad(codigo_subespecialidad, null, subespecialidad_nombre, subespecialidad_estado);
                final PersonalTecnico personalTecnico = new PersonalTecnico(codigo_personal_tecnico, persona, personal_tecnico_profesion, personal_tecnico_fecha_inicio, personal_tecnico_hora_inicio, personal_tecnico_habilitado);
                final Equipo equipo = new Equipo(codigo_equipo, personalTecnico, subespecialidad, equipo_nombre, equipo_marca, equipo_modelo, equipo_numero_serie, equipo_fecha_adquisicion, equipo_proveedor, equipo_responsable_entrega, equipo_integridad, equipo_garantia, equipo_ubicacion, equipo_observaciones, equipo_foto, equipo_estado);

                equipos.add(equipo);
            }
            return equipos;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLEquipo - ObtenerEquipos: " + sqlException.getMessage());
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

    public List<Intervencion> obtenerIntervencionesEquipo(final Equipo equipo) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_INTERVENCIONES_EQUIPO));
            
            final List<Intervencion> intervenciones;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_INTERVENCIONES_EQUIPO);
            statement.setInt(1, equipo.getCodigoEquipo());
            resultSet = statement.executeQuery();

            intervenciones = new ArrayList<>();
            while (resultSet.next()) {
                final int codigo_intervencion = resultSet.getInt(1);
                final Date intervencion_fecha_inicio = resultSet.getDate(3);
                final Time intervencion_hora_inicio = resultSet.getTime(4);
                final Date intervencion_fecha_final = resultSet.getDate(5);
                final Time intervencion_hora_final = resultSet.getTime(6);
                final String intervencion_causa = resultSet.getString(7);
                final String intervencion_tabajo_realizado = resultSet.getString(8);
                final String intervencion_descripcion_actividad = resultSet.getString(9);
                final String intervencion_observaciones = resultSet.getString(10);
                final int intervervencion_estado = resultSet.getInt(11);
                
                intervenciones.add(new Intervencion(codigo_intervencion, equipo, intervencion_fecha_inicio, intervencion_hora_inicio, intervencion_fecha_final, intervencion_hora_final, intervencion_causa, intervencion_tabajo_realizado, intervencion_descripcion_actividad, intervencion_observaciones, intervervencion_estado));
            }
            return intervenciones;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLIntervencion - ObtenerTodos: " + sqlException.getMessage());
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

    public Boolean actualizar(final Equipo equipo) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ACTUALIZAR));
            
            final PersonalTecnico personalTecnico = equipo.getPersonalTecnico();
            final Subespecialidad subespecialidad = equipo.getSubespecialidad();
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_ACTUALIZAR);
            statement.setInt(1, personalTecnico.getCodigoPersonalTecnico());
            statement.setInt(2, subespecialidad.getCodigoSubespecialidad());
            statement.setString(3, equipo.getEquipoNombre());
            statement.setString(4, equipo.getEquipoMarca());
            statement.setString(5, equipo.getEquipoModelo());
            statement.setString(6, equipo.getEquipoNumeroSerie());
            statement.setDate(7, equipo.getEquipoFechaAdquisicion());
            statement.setString(8, equipo.getEquipoProveedor());
            statement.setString(9, equipo.getEquipoResponsableEntrega());
            statement.setString(10, equipo.getEquipoIntegridad());
            statement.setInt(11, equipo.getEquipoGarantia());
            statement.setString(12, equipo.getEquipoUbicacion());
            statement.setString(13, equipo.getEquipoObservaciones());
            statement.setBinaryStream(14, new ByteArrayInputStream(equipo.getEquipoFoto()));
            statement.setInt(15, equipo.getCodigoEquipo());
            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLEquipo - Actualizar: " + sqlException.getMessage());
            return false;
        } catch (final Exception exception) {
            System.err.println("Error en SQLEquipo - Actualizar: " + exception.getMessage());
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

    public int verificarExistencia(final Equipo equipo) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_VERIFICAR_EXISTENCIA));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_VERIFICAR_EXISTENCIA);
            statement.setInt(1, equipo.getCodigoEquipo());
            statement.setString(2, equipo.getEquipoNumeroSerie());

            resultSet = statement.executeQuery();
            resultSet.next();
            final Boolean isExists = resultSet.getBoolean(1);

            if (isExists) {
                return 1;
            } else {
                return 0;
            }
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLEquipo - Verificar Existencia: " + sqlException.getMessage());
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
            System.err.println("Error en SQLEquipo - InsertarEnLog: " + sqlException.getMessage());
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