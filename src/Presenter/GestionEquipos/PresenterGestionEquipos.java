package Presenter.GestionEquipos;

import Model.DAO.GestionEquipo.SQLCaracteriztica;
import Model.DAO.GestionEquipo.SQLEquipo;
import Model.DAO.GestionEquipo.SQLEquipoEliminado;
import Model.DAO.GestionEquipo.SQLIntervencion;
import Model.POJO.Caracteriztica;
import Model.POJO.Equipo;
import Model.POJO.EquipoEliminado;
import Model.POJO.Intervencion;
import java.util.List;

/**
 *
 * @author Brynner
 */
public class PresenterGestionEquipos {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final SQLEquipo sqlEquipo;
    private final SQLEquipoEliminado sqlEquipoEliminado;
    private final SQLIntervencion sqlIntervencion;
    private final SQLCaracteriztica sqlCaracteriztica;
    
    private CallBackRegistrarEquipo callBackRegistrarEquipo;
    private CallBackAgregarCaracteriztica callBackAgregarCaracteriztica;
    private CallBackObtenerEquipos callBackObtenerEquipos;
    private CallBackObtenerCaracterizticas callBackObtenerCaracterizticas;
    private CallBackObtenerIntervencionesEquipo callBackObtenerIntervencionesEquipo;
    private CallBackVerificarExistenciaEquipo callBackVerificarExistenciaEquipo;
    private CallBackVerificarExistenciaCaracteriztica callBackVerificarExistenciaCaracteriztica;
    private CallBackModificarEquipo callBackModificarEquipo;
    private CallBackModificarCaracteriztica callBackModificarCaracteriztica;
    private CallBackEliminarCaracteriztica callBackEliminarCaracteriztica;
    private CallBackRegistrarIntervencion callBackRegistrarIntervencion;
    private CallBackEliminarEquipo callBackEliminarEquipo;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public PresenterGestionEquipos() {
        sqlEquipo = new SQLEquipo();
        sqlIntervencion = new SQLIntervencion();
        sqlCaracteriztica = new SQLCaracteriztica();
        sqlEquipoEliminado = new SQLEquipoEliminado();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public void setCallBackRegistrarEquipo(CallBackRegistrarEquipo callBackRegistrarEquipo) {
        this.callBackRegistrarEquipo = callBackRegistrarEquipo;
    }

    public void setCallBackAgregarCaracteriztica(CallBackAgregarCaracteriztica callBackAgregarCaracteriztica) {
        this.callBackAgregarCaracteriztica = callBackAgregarCaracteriztica;
    }

    public void setCallBackVerificarExistenciaEquipo(CallBackVerificarExistenciaEquipo callBackVerificarExistenciaEquipo) {
        this.callBackVerificarExistenciaEquipo = callBackVerificarExistenciaEquipo;
    }

    public void setCallBackVerificarExistenciaCaracteriztica(CallBackVerificarExistenciaCaracteriztica callBackVerificarExistenciaCaracteriztica) {
        this.callBackVerificarExistenciaCaracteriztica = callBackVerificarExistenciaCaracteriztica;
    }

    public void setCallBackModificarEquipo(CallBackModificarEquipo callBackModificarEquipo) {
        this.callBackModificarEquipo = callBackModificarEquipo;
    }

    public void setCallBackObtenerEquipos(CallBackObtenerEquipos callBackObtenerEquipos) {
        this.callBackObtenerEquipos = callBackObtenerEquipos;
    }

    public void setCallBackObtenerCaracterizticas(CallBackObtenerCaracterizticas callBackObtenerCaracterizticas) {
        this.callBackObtenerCaracterizticas = callBackObtenerCaracterizticas;
    }

    public void setCallBackObtenerIntervencionesEquipo(CallBackObtenerIntervencionesEquipo callBackObtenerIntervencionesEquipo) {
        this.callBackObtenerIntervencionesEquipo = callBackObtenerIntervencionesEquipo;
    }

    public void setCallBackModificarCaracteriztica(CallBackModificarCaracteriztica callBackModificarCaracteriztica) {
        this.callBackModificarCaracteriztica = callBackModificarCaracteriztica;
    }

    public void setCallBackEliminarCaracteriztica(CallBackEliminarCaracteriztica callBackEliminarCaracteriztica) {
        this.callBackEliminarCaracteriztica = callBackEliminarCaracteriztica;
    }

    public void setCallBackRegistrarIntervencion(CallBackRegistrarIntervencion callBackRegistrarIntervencion) {
        this.callBackRegistrarIntervencion = callBackRegistrarIntervencion;
    }

    public void setCallBackEliminarEquipo(CallBackEliminarEquipo callBackEliminarEquipo) {
        this.callBackEliminarEquipo = callBackEliminarEquipo;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos">
    
    public void registrarEquipo(final Equipo equipo) {
        try {
            final int result = sqlEquipo.verificarExistencia(equipo);

            switch (result) {
                case 0:
                    if (sqlEquipo.insertar(equipo)) {
                        callBackRegistrarEquipo.equipoRegistrado("Equipo registrado exitosamente.");
                    } else {
                        callBackRegistrarEquipo.errorRegistrarEquipo("Se produjo un error al registrar el equipo, vuelve a intentarlo.");
                    }
                    break;

                case 1:
                    callBackVerificarExistenciaEquipo.equipoExiste("Ya existe un equipo con el número de serie que ingresaste.");
                    break;

                default:
                    callBackVerificarExistenciaEquipo.errorVerificarExistenciaEquipo("Se produjo un error al verificar la existencia de algun equipo con el numero de serie que ingresaste, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionEquipo - Registrar Equipo: " + e.getMessage());
            callBackRegistrarEquipo.errorDesconocidoRegistrarEquipo("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void agregarCaracteriztica(final Caracteriztica caracteriztica) {
        try {
            final int result = sqlCaracteriztica.verificarExistencia(caracteriztica);

            switch (result) {
                case 0:
                    if (sqlCaracteriztica.insertar(caracteriztica)) {
                        callBackAgregarCaracteriztica.caracterizticaAgregada("Caracteriztica agregada exitosamente.");
                    } else {
                        callBackAgregarCaracteriztica.errorAgregarCaracteriztica("Se produjo un error al agregar la caracteriztica, vuelve a intentarlo.");
                    }
                    break;

                case 1:
                    callBackVerificarExistenciaCaracteriztica.caracterizticaExiste("Ya existe una caracteriztica similar en el equipo.");
                    break;

                default:
                    callBackVerificarExistenciaCaracteriztica.errorVerificarExistenciaCaracteriztica("Se produjo un error al verificar la existencia de la caracteriztica en el equipo, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionEquipo - Agregar Caracteriztica: " + e.getMessage());
            callBackAgregarCaracteriztica.errorDesconocidoAgregarCaracteriztica("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void obtenerEquipos() {
        try {
            final List<Equipo> equipos = sqlEquipo.obtenerEquipos();

            if (equipos == null) {
                callBackObtenerEquipos.errorObtenerEquipos("Se produjo un error al intentar obtener a los equipos, vuelve a intentarlo.");
            } else if (equipos.isEmpty()) {
                callBackObtenerEquipos.listaEquiposVacia("No se encontraron registros de equipos en la base de datos.");
            } else {
                callBackObtenerEquipos.equiposObtenidas(equipos);
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionEquipos - Obtener Equipos: " + e.getMessage());
            callBackObtenerEquipos.errorDesconocidoObtenerEquipos("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void obtenerCaracterizticas(final Equipo equipo) {
        try {
            final List<Caracteriztica> caracterizticas = sqlCaracteriztica.obtenerCaracterizticas(equipo);

            if (caracterizticas == null) {
                callBackObtenerCaracterizticas.errorObtenerCaracterizticas("Se produjo un error al intentar obtener a las caracterizticas del equipo, vuelve a intentarlo.");
            } else if (caracterizticas.isEmpty()) {
                callBackObtenerCaracterizticas.listaCaracterizticasVacia("No se encontraron registros de caracterizticas del equipo en la base de datos.");
            } else {
                callBackObtenerCaracterizticas.caracterizticasObtenidas(caracterizticas);
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionEquipo - Obtener Caracterizticas: " + e.getMessage());
            callBackObtenerCaracterizticas.errorDesconocidoObtenerCaracterizticas("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void obtenerIntervencionesEquipo(final Equipo equipo) {
        try {
            final List<Intervencion> intervenciones = sqlEquipo.obtenerIntervencionesEquipo(equipo);

            if (intervenciones == null) {
                callBackObtenerIntervencionesEquipo.errorObtenerIntervencionesEquipo("Se produjo un error al intentar obtener las intervenciónes del equipo, vuelve a intentarlo.");
            } else if (intervenciones.isEmpty()) {
                callBackObtenerIntervencionesEquipo.listaIntervencionesEquipoVacia("No se encontraron registros de intervenciones del equipo en la base de datos.");
            } else {
                callBackObtenerIntervencionesEquipo.intervencionesEquipoObtenidas(intervenciones);
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionIntervencion - Obtener Intervenciones Equipo: " + e.getMessage());
            callBackObtenerIntervencionesEquipo.errorDesconocidoObtenerIntervencionesEquipo("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void modificarEquipo(final Equipo equipo) {
        try {
            final int result = sqlEquipo.verificarExistencia(equipo);

            switch (result) {
                case 0:
                    if (sqlEquipo.actualizar(equipo)) {
                        callBackModificarEquipo.equipoModificado("Equipo modificado correctamente.");
                    } else {
                        callBackModificarEquipo.errorModificarEquipo("Se produjo un error al modificar el equipo.");
                    }
                    break;

                case 1:
                    callBackVerificarExistenciaEquipo.equipoExiste("Ya existe un equipo con el numero de serie que ingresaste.");
                    break;

                default:
                    callBackVerificarExistenciaEquipo.errorVerificarExistenciaEquipo("Se produjo un error al verificar la existencia de algun equipo con el numero de serie que ingresaste, vuelve a intentarlo.");
                    break;
            }

        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionEquipo - Modificar Equipo: " + e.getMessage());
            callBackModificarEquipo.errorDesconocidoModificarEquipo("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void modificarCaracteriztica(final Caracteriztica caracteriztica) {
        try {
            final int result = sqlCaracteriztica.verificarExistencia(caracteriztica);

            switch (result) {
                case 0:
                    if (sqlCaracteriztica.actualizar(caracteriztica)) {
                        callBackModificarCaracteriztica.caracterizticaModificada("Caracteriztica modificada correctamente.");
                    } else {
                        callBackModificarCaracteriztica.errorModificarCaracteriztica("Se produjo un error al modificar la caracteriztica.");
                    }
                    break;

                case 1:
                    callBackVerificarExistenciaCaracteriztica.caracterizticaExiste("Ya existe una caracteriztica similar en el equipo.");
                    break;

                default:
                    callBackVerificarExistenciaCaracteriztica.errorVerificarExistenciaCaracteriztica("Se produjo un error al verificar la existencia de la caracteriztica en el equipo, vuelve a intentarlo.");
                    break;
            }

        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionEquipo - Modificar Caracteriztica: " + e.getMessage());
            callBackModificarCaracteriztica.errorDesconocidoModificarCaracteriztica("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void eliminarCaracteriztica(final Caracteriztica caracteriztica) {
        try {
            if (sqlCaracteriztica.eliminar(caracteriztica)) {
                callBackEliminarCaracteriztica.caracterizticaEliminada("Caracteriztica eliminada correctamente.");
            } else {
                callBackEliminarCaracteriztica.errorEliminarCaracteriztica("Se produjo un error al eliminar la caracteriztica.");
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionEquipo - Eliminar Caracteriztica: " + e.getMessage());
            callBackEliminarCaracteriztica.errorDesconocidoEliminarCaracteriztica("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void registrarIntervencion(final Intervencion intervencion) {
        try {
            final boolean result = sqlIntervencion.insertar(intervencion);

            if (result) {
                callBackRegistrarIntervencion.intervencionRegistrada("Intervención registrada exitosamente.");
            } else {
                callBackRegistrarIntervencion.errorRegistrarIntervencion("Se produjo un error al registrar intervención, vuelve a intentarlo.");
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionEquipo - Registrar Intervencion: " + e.getMessage());
            callBackRegistrarIntervencion.errorDesconocidoRegistrarIntervencion("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void eliminarEquipo(final EquipoEliminado equipoEliminado) {
        try {
            final boolean result = sqlEquipoEliminado.eliminar(equipoEliminado);

            if (result) {
                callBackEliminarEquipo.equipoEliminado("Equipo eliminado exitosamente.");
            } else {
                callBackEliminarEquipo.errorEliminarEquipo("Se produjo un error al eliminar el equipo, vuelve a intentarlo.");
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionEquipo - Eliminar Equipo: " + e.getMessage());
            callBackEliminarEquipo.errorDesconocidoEliminarEquipo("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Interfaces">
    
    public interface CallBackVerificarExistenciaEquipo {

        void equipoExiste(final String msg);

        void errorVerificarExistenciaEquipo(final String msg);
    }

    public interface CallBackVerificarExistenciaCaracteriztica {

        void caracterizticaExiste(final String msg);

        void errorVerificarExistenciaCaracteriztica(final String msg);
    }

    public interface CallBackRegistrarEquipo {

        void equipoRegistrado(final String msg);

        void errorRegistrarEquipo(final String msg);

        void errorDesconocidoRegistrarEquipo(final String msg);
    }

    public interface CallBackAgregarCaracteriztica {

        void caracterizticaAgregada(final String msg);

        void errorAgregarCaracteriztica(final String msg);

        void errorDesconocidoAgregarCaracteriztica(final String msg);
    }

    public interface CallBackObtenerEquipos {

        void equiposObtenidas(final List<Equipo> equipos);

        void listaEquiposVacia(final String msg);

        void errorObtenerEquipos(final String msg);

        void errorDesconocidoObtenerEquipos(final String msg);
    }

    public interface CallBackObtenerCaracterizticas {

        void caracterizticasObtenidas(final List<Caracteriztica> caracterizticas);

        void listaCaracterizticasVacia(final String msg);

        void errorObtenerCaracterizticas(final String msg);

        void errorDesconocidoObtenerCaracterizticas(final String msg);
    }

    public interface CallBackObtenerIntervencionesEquipo {

        void intervencionesEquipoObtenidas(final List<Intervencion> intervenciones);

        void listaIntervencionesEquipoVacia(final String msg);

        void errorObtenerIntervencionesEquipo(final String msg);

        void errorDesconocidoObtenerIntervencionesEquipo(final String msg);
    }

    public interface CallBackModificarEquipo {

        void equipoModificado(final String msg);

        void errorModificarEquipo(final String msg);

        void errorDesconocidoModificarEquipo(final String msg);
    }

    public interface CallBackModificarCaracteriztica {

        void caracterizticaModificada(final String msg);

        void errorModificarCaracteriztica(final String msg);

        void errorDesconocidoModificarCaracteriztica(final String msg);
    }

    public interface CallBackEliminarCaracteriztica {

        void caracterizticaEliminada(final String msg);

        void errorEliminarCaracteriztica(final String msg);

        void errorDesconocidoEliminarCaracteriztica(final String msg);
    }

    public interface CallBackRegistrarIntervencion {

        void intervencionRegistrada(final String msg);

        void errorRegistrarIntervencion(final String msg);

        void errorDesconocidoRegistrarIntervencion(final String msg);
    }

    public interface CallBackEliminarEquipo {

        void equipoEliminado(final String msg);

        void errorEliminarEquipo(final String msg);

        void errorDesconocidoEliminarEquipo(final String msg);
    }

    // </editor-fold>
    
}