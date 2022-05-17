package Presenter.GestionExamenes;


import Model.DAO.GestionExamenes.SQLTecnica;
import Model.POJO.Tecnica;

/**
 *
 * @author Brynner
 */
public class PresenterGestionTecnicas {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final SQLTecnica sqlTecnica;
    
    private CallBackVerificarExistenciaTecnica callBackVerificarExistenciaTecnica;
    private CallBackAgregarTecnica callBackAgregarTecnica;
    private CallBackModificarTecnica callBackModificarTecnica;
    private CallBackEliminarTecnica callBackEliminarTecnica;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public PresenterGestionTecnicas() {
        sqlTecnica = new SQLTecnica();
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public void setCallBackVerificarExistenciaTecnica(CallBackVerificarExistenciaTecnica callBackVerificarExistenciaTecnica) {
        this.callBackVerificarExistenciaTecnica = callBackVerificarExistenciaTecnica;
    }

    public void setCallBackAgregarTecnica(CallBackAgregarTecnica callBackAgregarTecnica) {
        this.callBackAgregarTecnica = callBackAgregarTecnica;
    }

    public void setCallBackModificarTecnica(CallBackModificarTecnica callBackModificarTecnica) {
        this.callBackModificarTecnica = callBackModificarTecnica;
    }
    
    public void setCallBackEliminarTecnica(CallBackEliminarTecnica callBackEliminarTecnica) {    
        this.callBackEliminarTecnica = callBackEliminarTecnica;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos">
    
    public void agregarTecnica(final Tecnica tecnica) {
        try {
            final int result = sqlTecnica.verificarExistencia(tecnica);

            switch (result) {
                case 0:
                    if (sqlTecnica.insertar(tecnica)) {
                        callBackAgregarTecnica.examenAgregado("Tecnica agregada.");
                    } else {
                        callBackAgregarTecnica.errorAgregarTecnica("Se produjo un error, vuelve a intentarlo.");
                    }
                    break;

                case 1:
                    callBackVerificarExistenciaTecnica.examenExiste("Ya existe una técnica con el mismo nombre que ingresaste.");
                    break;

                default:
                    callBackVerificarExistenciaTecnica.errorVerificarExistenciaTecnica("Se produjo un error al verificar la existencia, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionTecnica - Agregar Tecnica: " + e.getMessage());
            callBackAgregarTecnica.errorDesconocidoAgregarTecnica("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void modificarTecnica(final Tecnica tecnica) {
        try {
            final int result = sqlTecnica.verificarExistencia(tecnica);

            switch (result) {
                case 0:
                    if (sqlTecnica.actualizar(tecnica)) {
                        callBackModificarTecnica.examenModificado("Tecnica modificada.");
                    } else {
                        callBackModificarTecnica.errorModificarTecnica("Se produjo un error al modificar la técnica.");
                    }
                    break;

                case 1:
                    callBackVerificarExistenciaTecnica.examenExiste("Ya existe una técnica con el mismo nombre que ingresaste.");
                    break;

                default:
                    callBackVerificarExistenciaTecnica.errorVerificarExistenciaTecnica("Se produjo un error al verificar la existencia, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionTecnicas - Modificar Tecnica: " + e.getMessage());
            callBackModificarTecnica.errorDesconocidoModificarTecnica("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }
    
    public void eliminarTecnica(final Tecnica examen) {
        try {
            if (sqlTecnica.eliminar(examen)) {
                callBackEliminarTecnica.examenEliminado("Técnica Eliminada.");
            } else {
                callBackEliminarTecnica.errorEliminarTecnica("Se produjo un error al eliminar la técnica.");
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionTecnica - Eliminar Tecnica: " + e.getMessage());
            callBackEliminarTecnica.errorDesconocidoEliminarTecnica("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Interfaces">
    
    public interface CallBackVerificarExistenciaTecnica {

        void examenExiste(final String msg);

        void errorVerificarExistenciaTecnica(final String msg);
    }

    public interface CallBackAgregarTecnica {

        void examenAgregado(final String msg);

        void errorAgregarTecnica(final String msg);

        void errorDesconocidoAgregarTecnica(final String msg);
    }

    public interface CallBackModificarTecnica {

        void examenModificado(final String msg);

        void errorModificarTecnica(final String msg);

        void errorDesconocidoModificarTecnica(final String msg);
    }
    
    public interface CallBackEliminarTecnica {

        void examenEliminado(final String msg);

        void errorEliminarTecnica(final String msg);

        void errorDesconocidoEliminarTecnica(final String msg);
    }
    
    // </editor-fold>
    
}