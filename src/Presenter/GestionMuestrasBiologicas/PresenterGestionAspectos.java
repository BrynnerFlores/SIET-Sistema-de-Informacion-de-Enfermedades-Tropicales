package Presenter.GestionMuestrasBiologicas;

import Model.DAO.GestionMuestraBiologica.SQLAspectoCalidad;
import Model.POJO.AspectoCalidad;

/**
 *
 * @author Brynner
 */
public class PresenterGestionAspectos {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final SQLAspectoCalidad sqlAspecto;

    private CallBackAgregarAspecto callBackAgregarAspecto;
    private CallBackModificarAspecto callBackModificarAspecto;
    private CallBackEliminarAspecto callBackEliminarAspecto;
    private CallBackVerificarExistencia callBackVerificarExistencia;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public PresenterGestionAspectos() {
        sqlAspecto = new SQLAspectoCalidad();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public void setCallBackAgregarAspecto(CallBackAgregarAspecto callBackAgregarAspecto) {
        this.callBackAgregarAspecto = callBackAgregarAspecto;
    }

    public void setCallBackVerificarExistencia(CallBackVerificarExistencia callBackVerificarExistencia) {
        this.callBackVerificarExistencia = callBackVerificarExistencia;
    }

    public void setCallBackEliminarAspecto(CallBackEliminarAspecto callBackEliminarAspecto) {
        this.callBackEliminarAspecto = callBackEliminarAspecto;
    }

    public void setCallBackModificarAspecto(CallBackModificarAspecto callBackModificarAspecto) {
        this.callBackModificarAspecto = callBackModificarAspecto;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos">
    
    public void agregarAspecto(final AspectoCalidad aspecto) {
        try {
            final int result = sqlAspecto.verificarExistencia(aspecto);

            switch (result) {
                case 0:
                    if (sqlAspecto.insertar(aspecto)) {
                        callBackAgregarAspecto.aspectoAgregado("Aspecto agregado exitosamente.");
                    } else {
                        callBackAgregarAspecto.errorAgregarAspecto("Se produjo un error al agregar el aspecto, vuelve a intentarlo.");
                    }
                    break;

                case 1:
                    callBackVerificarExistencia.aspectoExiste("Ya existe un aspecto del mismo tipo que ingresaste.");
                    break;

                default:
                    callBackVerificarExistencia.errorVerificarExistencia("Se produjo un error, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionAspectos - Agregar Aspecto: " + e.getMessage());
            callBackAgregarAspecto.errorDesconocidoAgregarAspecto("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void modificarAspecto(final AspectoCalidad aspecto) {
        try {
            final int result = sqlAspecto.verificarExistencia(aspecto);

            switch (result) {
                case 0:
                    if (sqlAspecto.actualizar(aspecto)) {
                        callBackModificarAspecto.aspectoModificado("Aspecto modificado correctamente.");
                    } else {
                        callBackModificarAspecto.errorModificarAspecto("Se produjo un error al modificar el aspecto de la muestra biologica.");
                    }
                    break;

                case 1:
                    callBackVerificarExistencia.aspectoExiste("Ya existe un aspecto del mismo tipo que ingresaste.");
                    break;

                default:
                    callBackVerificarExistencia.errorVerificarExistencia("Se produjo un error, vuelve a intentarlo.");
                    break;
            }

        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionAspectos - Modificar Aspecto: " + e.getMessage());
            callBackModificarAspecto.errorDesconocidoModificarAspecto("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void eliminarAspecto(final AspectoCalidad aspecto) {
        try {
            if (sqlAspecto.eliminar(aspecto)) {
                callBackEliminarAspecto.aspectoEliminado("Aspecto/Calidad eliminado.");
            } else {
                callBackEliminarAspecto.errorEliminarAspecto("Se produjo un error al eliminar el aspecto, vuelve a intentarlo.");
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionAspectos - Eliminar Aspecto: " + e.getMessage());
            callBackEliminarAspecto.errorDesconocidoEliminarAspecto("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Interfaces">
    
    public interface CallBackVerificarExistencia {

        void aspectoExiste(final String msg);

        void errorVerificarExistencia(final String msg);
    }

    public interface CallBackModificarAspecto {

        void aspectoModificado(final String msg);

        void errorModificarAspecto(final String msg);

        void errorDesconocidoModificarAspecto(final String msg);
    }

    public interface CallBackEliminarAspecto {

        void aspectoEliminado(final String msg);

        void errorEliminarAspecto(final String msg);

        void errorDesconocidoEliminarAspecto(final String msg);
    }

    public interface CallBackAgregarAspecto {

        void aspectoAgregado(final String msg);

        void errorAgregarAspecto(final String msg);

        void errorDesconocidoAgregarAspecto(final String msg);
    }

    // </editor-fold>
    
}