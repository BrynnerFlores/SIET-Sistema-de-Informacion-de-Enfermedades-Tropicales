package Presenter.GestionMuestrasBiologicas;

import Model.DAO.GestionMuestraBiologica.SQLParasito;
import Model.POJO.Parasito;

/**
 *
 * @author Brynner
 */
public class PresenterGestionParasitos {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final SQLParasito sqlParasito;
    
    private CallBackAgregarParasito callBackAgregarParasito;
    private CallBackModificarParasito callBackModificarParasito;
    private CallBackEliminarParasito callBackEliminarParasito;
    private CallBackVerificarExistencia callBackVerificarExistencia;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public PresenterGestionParasitos() {
        sqlParasito = new SQLParasito();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public void setCallBackAgregarParasito(CallBackAgregarParasito callBackAgregarParasito) {
        this.callBackAgregarParasito = callBackAgregarParasito;
    }

    public void setCallBackModificarParasito(CallBackModificarParasito callBackModificarParasito) {
        this.callBackModificarParasito = callBackModificarParasito;
    }

    public void setCallBackEliminarParasito(CallBackEliminarParasito callBackEliminarParasito) {
        this.callBackEliminarParasito = callBackEliminarParasito;
    }

    public void setCallBackVerificarExistencia(CallBackVerificarExistencia callBackVerificarExistencia) {
        this.callBackVerificarExistencia = callBackVerificarExistencia;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos">
    
    public void agregarParasito(final Parasito parasito) {
        try {
            final int result = sqlParasito.verificarExistencia(parasito);

            switch (result) {
                case 0:
                    if (sqlParasito.insertar(parasito)) {
                        callBackAgregarParasito.parasitoAgregado("Parásito agregado.");
                    } else {
                        callBackAgregarParasito.errorAgregarParasito("Se produjo un error, vuelve a intentarlo.");
                    }
                    break;

                case 1:
                    callBackVerificarExistencia.parasitoExiste("Ya existe un parásito con el mismo nombre que ingresaste.");
                    break;

                default:
                    callBackVerificarExistencia.errorVerificarExistencia("Se produjo un error, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionParasitos - Agregar Parasito: " + e.getMessage());
            callBackAgregarParasito.errorDesconocidoAgregarParasito("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void modificarParasito(final Parasito parasito) {
        try {
            final int result = sqlParasito.verificarExistencia(parasito);

            switch (result) {
                case 0:
                    if (sqlParasito.actualizar(parasito)) {
                        callBackModificarParasito.parasitoModificado("Parásito modificado.");
                    } else {
                        callBackModificarParasito.errorModificarParasito("Se produjo un error, vuelve a intentarlo.");
                    }
                    break;

                case 1:
                    callBackVerificarExistencia.parasitoExiste("Ya existe un parasito con el mismo nombre que ingresaste.");
                    break;

                default:
                    callBackVerificarExistencia.errorVerificarExistencia("Se produjo un error, vuelve a intentarlo.");
                    break;
            }

        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionParasitos - Modificar Parasito: " + e.getMessage());
            callBackModificarParasito.errorDesconocidoModificarParasito("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void eliminarParasito(final Parasito parasito) {
        try {
            if (sqlParasito.eliminar(parasito)) {
                callBackEliminarParasito.parasitoEliminado("Parásito eliminado.");
            } else {
                callBackEliminarParasito.errorEliminarParasito("Se produjo un error, vuelve a intentarlo.");
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionParasitos - Eliminar Parásito: " + e.getMessage());
            callBackEliminarParasito.errorDesconocidoEliminarParasito("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Interfaces">
    
    public interface CallBackVerificarExistencia {

        void parasitoExiste(final String msg);

        void errorVerificarExistencia(final String msg);
    }

    public interface CallBackModificarParasito {

        void parasitoModificado(final String msg);

        void errorModificarParasito(final String msg);

        void errorDesconocidoModificarParasito(final String msg);
    }

    public interface CallBackEliminarParasito {

        void parasitoEliminado(final String msg);

        void errorEliminarParasito(final String msg);

        void errorDesconocidoEliminarParasito(final String msg);
    }

    public interface CallBackAgregarParasito {

        void parasitoAgregado(final String msg);

        void errorAgregarParasito(final String msg);

        void errorDesconocidoAgregarParasito(final String msg);
    }

    // </editor-fold>
    
}