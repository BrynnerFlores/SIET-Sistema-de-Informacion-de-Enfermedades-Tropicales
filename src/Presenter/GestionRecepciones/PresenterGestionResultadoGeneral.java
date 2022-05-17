package Presenter.GestionRecepciones;

import Model.DAO.GestionRecepciones.SQLResultadoGeneral;
import Model.POJOPersonalizado.ResultadoGeneralPersonalizado;

/**
 *
 * @author Brynner
 */
public class PresenterGestionResultadoGeneral {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final SQLResultadoGeneral sqlResultadoGeneral;
    
    private CallBackRegistrarResultadoGeneral callBackRegistrarResultadoGeneral;
    private CallBackModificarResultadoGeneral callBackModificarResultadoGeneral;
    private CallBackVerificarResultadoExiste callBackVerificarResultadoExiste;
    private CallBackVerificarPermitirModificacion callBackVerificarPermitirModificacion;
    private CallBackVerificarSiResultadoEsAntecedente callBackVerificarSiResultadoEsAntecedente;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public PresenterGestionResultadoGeneral() {
        sqlResultadoGeneral = new SQLResultadoGeneral();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public void setCallBackRegistrarResultadoGeneral(CallBackRegistrarResultadoGeneral callBackRegistrarResultadoGeneral) {
        this.callBackRegistrarResultadoGeneral = callBackRegistrarResultadoGeneral;
    }

    public void setCallBackModificarResultadoGeneral(CallBackModificarResultadoGeneral callBackModificarResultadoGeneral) {
        this.callBackModificarResultadoGeneral = callBackModificarResultadoGeneral;
    }

    public void setCallBackVerificarResultadoExiste(CallBackVerificarResultadoExiste callBackVerificarResultadoExiste) {
        this.callBackVerificarResultadoExiste = callBackVerificarResultadoExiste;
    }

    public void setCallBackVerificarPermitirModificacion(CallBackVerificarPermitirModificacion callBackVerificarPermitirModificacion) {
        this.callBackVerificarPermitirModificacion = callBackVerificarPermitirModificacion;
    }

    public void setCallBackVerificarSiResultadoEsAntecedente(CallBackVerificarSiResultadoEsAntecedente callBackVerificarSiResultadoEsAntecedente) {
        this.callBackVerificarSiResultadoEsAntecedente = callBackVerificarSiResultadoEsAntecedente;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos">
    
    public void registrarResultadoAnalisis(final ResultadoGeneralPersonalizado resultadoGeneralPersonalizado) {
        try {
            final int result = sqlResultadoGeneral.verificarResultadoExiste(resultadoGeneralPersonalizado);

            switch (result) {
                case 0:
                    if (sqlResultadoGeneral.insertar(resultadoGeneralPersonalizado)) {
                        callBackRegistrarResultadoGeneral.resultadoAnalisisRegistrado("Resultado de Análisis Registrado.");
                    } else {
                        callBackRegistrarResultadoGeneral.errorRegistrarResultadoAnalisis("Se produjo un error, vuelve a intentarlo.");
                    }
                    break;

                case 1:
                    callBackVerificarResultadoExiste.resultadoExiste("La " + resultadoGeneralPersonalizado.getResultadoGeneral().getNumeroMuestraBiologica() + " ya tiene resultados ingresados.");
                    break;

                default:
                    callBackVerificarResultadoExiste.errorVerificarExistenciaResultado("Se produjo un error, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionResultadoGeneral - Registrar Resultado General: " + e.getMessage());
            callBackRegistrarResultadoGeneral.errorDesconocidoRegistrarResultadoAnalisis("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void modificarResultadoGeneral(final ResultadoGeneralPersonalizado resultadoGeneralPersonalizado) {
        try {
            final int resultadoPermitirModificacion = sqlResultadoGeneral.verificarPermitirModificacion(resultadoGeneralPersonalizado);

            switch (resultadoPermitirModificacion) {
                case -1:
                    callBackVerificarPermitirModificacion.errorVerificarPermitirModificacion("Se produjo un error, vuelve a intentarlo.");
                    break;

                case 0:
                    if (resultadoGeneralPersonalizado.getResultadoGeneral().getSeguimientoPaciente() == null) {
                        final int existeResultado = sqlResultadoGeneral.verificarResultadoExiste(resultadoGeneralPersonalizado);

                        switch (existeResultado) {
                            case 0:
                                final boolean result = sqlResultadoGeneral.actualizar(resultadoGeneralPersonalizado);

                                if (result) {
                                    callBackModificarResultadoGeneral.resultadoGeneralModificado("Resultados Modificados.");
                                } else {
                                    callBackModificarResultadoGeneral.errorModificarResultadoGeneral("Se produjo un error, vuelve a intentarlo.");
                                }
                                break;

                            case 1:
                                callBackVerificarResultadoExiste.resultadoExiste("La " + resultadoGeneralPersonalizado.getResultadoGeneral().getNumeroMuestraBiologica() + " ya tiene resultados cargados.");
                                break;

                            default:
                                callBackVerificarResultadoExiste.errorVerificarExistenciaResultado("Se produjo un error, vuelve a intentarlo.");
                                break;
                        }
                    } else {
                        final int resultadoEsAntecedente = sqlResultadoGeneral.verificarSiResultadoEsAntecedente(resultadoGeneralPersonalizado);

                        switch (resultadoEsAntecedente) {
                            case 0:
                                final boolean result = sqlResultadoGeneral.actualizar(resultadoGeneralPersonalizado);

                                if (result) {
                                    callBackModificarResultadoGeneral.resultadoGeneralModificado("Resultados Modificados.");
                                } else {
                                    callBackModificarResultadoGeneral.errorModificarResultadoGeneral("Se produjo un error, vuelve a intentarlo.");
                                }
                                break;

                            case 1:
                                callBackVerificarSiResultadoEsAntecedente.esAntecedente("Este resultado de exámen no puede incorporarse al seguimiento porque es un antecedente del seguimiento.");
                                break;

                            default:
                                callBackVerificarSiResultadoEsAntecedente.errorVerificarSiResultadoEsAntecedente("Se produjo un error, vuelve a intentarlo.");
                                break;
                        }
                    }

                    break;

                case 1:
                    callBackVerificarPermitirModificacion.permisoNegado("No es posible modificar los resultados. El plazo de 48 horas expiró.");
                    break;

                default:
                    callBackVerificarPermitirModificacion.errorVerificarPermitirModificacion("Se produjo un error, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionResultadoGeneral - Modificar Resultado General: " + e.getMessage());
            callBackModificarResultadoGeneral.errorDesconocidoModificarResultadoGeneral("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void verificarPermitirModificacion(final ResultadoGeneralPersonalizado resultadoGeneralPersonalizado) {
        try {
            final int resultadoPermitirModificacion = sqlResultadoGeneral.verificarPermitirModificacion(resultadoGeneralPersonalizado);

            switch (resultadoPermitirModificacion) {
                case -1:
                    callBackVerificarPermitirModificacion.errorVerificarPermitirModificacion("Se produjo un error, vuelve a intentarlo.");
                    break;

                case 0:
                    callBackVerificarPermitirModificacion.permisoConcedido();
                    break;

                case 1:
                    callBackVerificarPermitirModificacion.permisoNegado("No es posible modificar los resultados. El plazo de 48 horas expiró.");
                    break;

                default:
                    callBackVerificarPermitirModificacion.errorVerificarPermitirModificacion("Se produjo un error, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionResultadoGeneral - Verificar Permitir Modificacion Resultado General: " + e.getMessage());
            callBackVerificarPermitirModificacion.errorDesconocidoVerificarPermitirModificacion("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Interfaces">
    
    public interface CallBackRegistrarResultadoGeneral {

        void resultadoAnalisisRegistrado(final String msg);

        void errorRegistrarResultadoAnalisis(final String msg);

        void errorDesconocidoRegistrarResultadoAnalisis(final String msg);
    }

    public interface CallBackModificarResultadoGeneral {

        void resultadoGeneralModificado(final String msg);

        void errorModificarResultadoGeneral(final String msg);

        void errorDesconocidoModificarResultadoGeneral(final String msg);

    }

    public interface CallBackVerificarResultadoExiste {

        void resultadoExiste(final String msg);

        void errorVerificarExistenciaResultado(final String msg);

    }

    public interface CallBackVerificarPermitirModificacion {

        void permisoConcedido();

        void permisoNegado(final String msg);

        void errorVerificarPermitirModificacion(final String msg);
        
        void errorDesconocidoVerificarPermitirModificacion(final String msg);

    }

    public interface CallBackVerificarSiResultadoEsAntecedente {

        void esAntecedente(final String msg);

        void errorVerificarSiResultadoEsAntecedente(final String msg);

    }

    // </editor-fold>
    
}