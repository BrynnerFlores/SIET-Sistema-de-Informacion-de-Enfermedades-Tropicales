package Presenter.GestionSubespecialidades;

import Model.DAO.GestionSubespecialidad.SQLSubespecialidadMuestra;
import Model.POJO.SubespecialidadMuestra;

/**
 *
 * @author Brynner
 */
public class PresenterGestionSubespecialidadMuestra {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final SQLSubespecialidadMuestra sqlSubespecialidadMuestra;

    private CallBackAsignarMuestraBiologicaSubespecialidad callBackAsignarMuestraBiologicaSubespecialidad;
    private CallBackQuitarMuestraBiologicaSubespecialidad callBackQuitarMuestraBiologicaSubespecialidad;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public PresenterGestionSubespecialidadMuestra() {
        sqlSubespecialidadMuestra = new SQLSubespecialidadMuestra();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public void setCallBackAsignarMuestraBiologicaSubespecialidad(CallBackAsignarMuestraBiologicaSubespecialidad callBackAsignarMuestraBiologicaSubespecialidad) {
        this.callBackAsignarMuestraBiologicaSubespecialidad = callBackAsignarMuestraBiologicaSubespecialidad;
    }

    public void setCallBackQuitarMuestraBiologicaSubespecialidad(CallBackQuitarMuestraBiologicaSubespecialidad callBackQuitarMuestraBiologicaSubespecialidad) {
        this.callBackQuitarMuestraBiologicaSubespecialidad = callBackQuitarMuestraBiologicaSubespecialidad;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos">
    
    public void asignarMuestraBiologicaSubespecialidad(final SubespecialidadMuestra subespecialidadMuestra) {
        try {
            if (sqlSubespecialidadMuestra.insertar(subespecialidadMuestra)) {
                callBackAsignarMuestraBiologicaSubespecialidad.muestraBiologicaSubespecialidadAsignada("Asignado correctamente.");
            } else {
                callBackAsignarMuestraBiologicaSubespecialidad.errorAsignarMuestraBiologicaSubespecialidad("Se produjo un error, vuelve a intentarlo.");
            }
        } catch (final Exception exception) {
            System.err.println("Error en PresenterGestionSubespecialidadMuestra - Asignar Muestra Biologica Subespecialidad: " + exception.getMessage());
            callBackAsignarMuestraBiologicaSubespecialidad.errorDesconocidoAsignarMuestraBiologicaSubespecialidad("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void quitarMuestraBiologicaSubespecialidad(final SubespecialidadMuestra subespecialidadMuestra) {
        try {
            if (sqlSubespecialidadMuestra.eliminar(subespecialidadMuestra)) {
                callBackQuitarMuestraBiologicaSubespecialidad.muestraBiologicaSubespecialidadQuitada("Muestra biologica quitada.");
            } else {
                callBackQuitarMuestraBiologicaSubespecialidad.errorQuitarMuestraBiologicaSubespecialidad("Se produjo un error, vuelve a intentarlo.");
            }
        } catch (final Exception exception) {
            System.err.println("Error en PresenterGestionSubespecialidadMuestra - Quitar Muestra Biologica Subespecialidad: " + exception.getMessage());
            callBackQuitarMuestraBiologicaSubespecialidad.errorDesconocidoQuitarMuestraBiologicaSubespecialidad("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Interfaces">
    
    public interface CallBackAsignarMuestraBiologicaSubespecialidad {

        void muestraBiologicaSubespecialidadAsignada(final String msg);

        void errorAsignarMuestraBiologicaSubespecialidad(final String msg);

        void errorDesconocidoAsignarMuestraBiologicaSubespecialidad(final String msg);
    }

    public interface CallBackQuitarMuestraBiologicaSubespecialidad {

        void muestraBiologicaSubespecialidadQuitada(final String msg);

        void errorQuitarMuestraBiologicaSubespecialidad(final String msg);

        void errorDesconocidoQuitarMuestraBiologicaSubespecialidad(final String msg);
    }

    // </editor-fold>
}