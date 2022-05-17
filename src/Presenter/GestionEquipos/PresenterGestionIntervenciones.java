package Presenter.GestionEquipos;

import Model.DAO.GestionEquipo.SQLIntervencion;
import Model.POJO.Intervencion;
import java.util.List;

/**
 *
 * @author Brynner
 */
public class PresenterGestionIntervenciones {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final SQLIntervencion sqlIntervencion;

    private CallBackObtenerIntervenciones callBackObtenerIntervenciones;
    private CallBackModificarIntervencion callBackModificarIntervencion;
    private CallBackFinalizarIntervencion callBackFinalizarIntervencion;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public PresenterGestionIntervenciones() {
        sqlIntervencion = new SQLIntervencion();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public void setCallBackObtenerIntervenciones(CallBackObtenerIntervenciones callBackObtenerIntervenciones) {
        this.callBackObtenerIntervenciones = callBackObtenerIntervenciones;
    }

    public void setCallBackModificarIntervencion(CallBackModificarIntervencion callBackModificarIntervencion) {
        this.callBackModificarIntervencion = callBackModificarIntervencion;
    }

    public void setCallBackFinalizarIntervencion(CallBackFinalizarIntervencion callBackFinalizarIntervencion) {
        this.callBackFinalizarIntervencion = callBackFinalizarIntervencion;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos">
    
    public void obtenerIntervenciones() {
        try {
            final List<Intervencion> intervenciones = sqlIntervencion.obtenerTodos();

            if (intervenciones == null) {
                callBackObtenerIntervenciones.errorObtenerIntervenciones("Se produjo un error al intentar obtener las intervenciónes, vuelve a intentarlo.");
            } else if (intervenciones.isEmpty()) {
                callBackObtenerIntervenciones.listaIntervencionesVacia("No se encontraron registros de intervenciones en la base de datos.");
            } else {
                callBackObtenerIntervenciones.intervencionesObtenidas(intervenciones);
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionIntervencion - Obtener Intervenciones: " + e.getMessage());
            callBackObtenerIntervenciones.errorDesconocidoObtenerIntervenciones("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void modificarIntervencion(final Intervencion intervencion) {
        try {
            final boolean result = sqlIntervencion.actualizar(intervencion);

            if (result) {
                callBackModificarIntervencion.intervencionModificada("Intervención modificada correctamente.");
            } else {
                callBackModificarIntervencion.errorModificarIntervencion("Se produjo un error al modificar la intervención, vuelve a intentarlo.");
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionIntervencion - Modificar Intervencion: " + e.getMessage());
            callBackModificarIntervencion.errorDesconocidoModificarIntervencion("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void finalizarIntervencion(final Intervencion intervencion) {
        try {
            final boolean result = sqlIntervencion.finalizar(intervencion);

            if (result) {
                callBackFinalizarIntervencion.intervencionFinalizada("Intervención finalizada correctamente.");
            } else {
                callBackFinalizarIntervencion.errorFinalizarIntervencion("Se produjo un error al finalizar la intervención, vuelve a intentarlo.");
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionIntervencion - Finalizar Intervencion: " + e.getMessage());
            callBackFinalizarIntervencion.errorDesconocidoFinalizarIntervencion("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Interfaces">
    
    public interface CallBackObtenerIntervenciones {

        void intervencionesObtenidas(final List<Intervencion> intervenciones);

        void listaIntervencionesVacia(final String msg);

        void errorObtenerIntervenciones(final String msg);

        void errorDesconocidoObtenerIntervenciones(final String msg);
    }

    public interface CallBackModificarIntervencion {

        void intervencionModificada(final String msg);

        void errorModificarIntervencion(final String msg);

        void errorDesconocidoModificarIntervencion(final String msg);
    }

    public interface CallBackFinalizarIntervencion {

        void intervencionFinalizada(final String msg);

        void errorFinalizarIntervencion(final String msg);

        void errorDesconocidoFinalizarIntervencion(final String msg);
    }

    // </editor-fold>
}