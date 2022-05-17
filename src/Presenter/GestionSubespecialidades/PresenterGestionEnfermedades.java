package Presenter.GestionSubespecialidades;

import Model.DAO.GestionSubespecialidad.SQLEnfermedad;
import Model.POJO.Enfermedad;

/**
 *
 * @author Brynner
 */
public class PresenterGestionEnfermedades {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final SQLEnfermedad sqlEnfermedad;
    
    private CallBackVerificarExistenciaEnfermedad callBackVerificarExistenciaEnfermedad;
    private CallBackAgregarEnfermedad callBackAgregarEnfermedad;
    private CallBackModificarEnfermedad callBackModificarEnfermedad;
    private CallBackEliminarEnfermedad callBackEliminarEnfermedad;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public PresenterGestionEnfermedades() {
        sqlEnfermedad = new SQLEnfermedad();
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public void setCallBackVerificarExistenciaEnfermedad(CallBackVerificarExistenciaEnfermedad callBackVerificarExistenciaEnfermedad) {
        this.callBackVerificarExistenciaEnfermedad = callBackVerificarExistenciaEnfermedad;
    }

    public void setCallBackAgregarEnfermedad(CallBackAgregarEnfermedad callBackAgregarEnfermedad) {
        this.callBackAgregarEnfermedad = callBackAgregarEnfermedad;
    }

    public void setCallBackModificarEnfermedad(CallBackModificarEnfermedad callBackModificarEnfermedad) {
        this.callBackModificarEnfermedad = callBackModificarEnfermedad;
    }
    
    public void setCallBackEliminarEnfermedad(CallBackEliminarEnfermedad callBackEliminarEnfermedad) {
        this.callBackEliminarEnfermedad = callBackEliminarEnfermedad;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos">
    
    public void agregarEnfermedad(final Enfermedad enfermedad) {
        try {
            final int result = sqlEnfermedad.verificarExistencia(enfermedad);

            switch (result) {
                case 0:
                    if (sqlEnfermedad.insertar(enfermedad)) {
                        callBackAgregarEnfermedad.enfermedadAgregada("Enfermedad Agregada.");
                    } else {
                        callBackAgregarEnfermedad.errorAgregarEnfermedad("Se produjo un error, vuelve a intentarlo.");
                    }
                    break;

                case 1:
                    callBackVerificarExistenciaEnfermedad.existeEnfermedad("Ya existe una enfermedad con el mismo nombre que ingresaste.");
                    break;

                default:
                    callBackVerificarExistenciaEnfermedad.errorVerificarExistenciaEnfermedad("Se produjo un error al verificar la existencia, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Error en:\nClase = PresenterGestionEnfermedades\nMetodo = Agregar Enfermedad\nError = " + e.getMessage());
            callBackAgregarEnfermedad.errorDesconocidoAgregarEnfermedad("Se produjo un error desconocido, vuelve a intentarlo. Si el error persiste, contactate con el desarrollador.");
        }
    }
    
    public void modificarEnfermedad(final Enfermedad enfermedad) {
        try {
            final int result = sqlEnfermedad.verificarExistencia(enfermedad);

            switch (result) {
                case 0:
                    if (sqlEnfermedad.actualizar(enfermedad)) {
                        callBackModificarEnfermedad.enfermedadModificada("Enfermedad Modificada.");
                    } else {
                        callBackModificarEnfermedad.errorModificarEnfermedad("Se produjo un error al modificar la enfermedad.");
                    }
                    break;

                case 1:
                    callBackVerificarExistenciaEnfermedad.existeEnfermedad("Ya existe una enfermedad con el mismo nombre que ingresaste.");
                    break;

                default:
                    callBackVerificarExistenciaEnfermedad.errorVerificarExistenciaEnfermedad("Se produjo un error al verificar la existencia, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionEnfermedades - Modificar Enfermedad: " + e.getMessage());
            callBackModificarEnfermedad.errorDesconocidoModificarEnfermedad("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }
    
    public void eliminarEnfermedad(final Enfermedad enfermedad) {
        try {
            if (sqlEnfermedad.eliminar(enfermedad)) {
                callBackEliminarEnfermedad.enfermedadEliminada("Enfermedad Eliminada.");
            } else {
                callBackEliminarEnfermedad.errorEliminarEnfermedad("Se produjo un error al eliminar la enfermedad.");
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionEnfermedades - Eliminar Enfermedad: " + e.getMessage());
            callBackEliminarEnfermedad.errorDesconocidoEliminarEnfermedad("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Interfaces">
    
    public interface CallBackAgregarEnfermedad {

        void enfermedadAgregada(final String msg);

        void errorAgregarEnfermedad(final String msg);

        void errorDesconocidoAgregarEnfermedad(final String msg);
    }
    
    public interface CallBackModificarEnfermedad {

        void enfermedadModificada(final String msg);

        void errorModificarEnfermedad(final String msg);

        void errorDesconocidoModificarEnfermedad(final String msg);
    }
    
    public interface CallBackEliminarEnfermedad {

        void enfermedadEliminada(final String msg);

        void errorEliminarEnfermedad(final String msg);

        void errorDesconocidoEliminarEnfermedad(final String msg);
    }

    public interface CallBackVerificarExistenciaEnfermedad {

        void existeEnfermedad(final String msg);

        void errorVerificarExistenciaEnfermedad(final String msg);
    }

    // </editor-fold>
    
}