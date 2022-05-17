package Presenter.GestionRecepciones;

import Model.DAO.GestionRecepciones.SQLExamenSolicitado;
import Model.POJO.ExamenSolicitado;
import Model.POJOPersonalizado.ResultadoGeneralPersonalizado;
import java.util.List;

/**
 *
 * @author Brynner
 */
public class PresenterGestionExamenesSolicitados {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final SQLExamenSolicitado sqlExamenSolicitado;
    
    private CallBackObtenerResultadosGenerales callBackObtenerResultadosGenerales;
    private CallBackObtenerResultadoGeneral callBackObtenerResultadoGeneral;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public PresenterGestionExamenesSolicitados() {
        sqlExamenSolicitado = new SQLExamenSolicitado();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public void setCallBackObtenerResultadosGenerales(CallBackObtenerResultadosGenerales callBackObtenerResultadosGenerales) {
        this.callBackObtenerResultadosGenerales = callBackObtenerResultadosGenerales;
    }

    public void setCallBackObtenerResultadoGeneral(CallBackObtenerResultadoGeneral callBackObtenerResultadoGeneral) {
        this.callBackObtenerResultadoGeneral = callBackObtenerResultadoGeneral;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos">
    
    public void obtenerResultadosGenerales(final ExamenSolicitado examenSolicitado) {
        try {
            final List<ResultadoGeneralPersonalizado> resultadosGeneralesPersonalizados = sqlExamenSolicitado.obtenerResultadosGenerales(examenSolicitado);
            if (resultadosGeneralesPersonalizados == null) {
                callBackObtenerResultadosGenerales.errorObtenerResultadosGenerales("Se produjo un error, vuelve a intentarlo.");
            } else if (resultadosGeneralesPersonalizados.isEmpty()){
                callBackObtenerResultadosGenerales.listaResultadosGeneralesVacia("No se encontraron resultados ingresados.");
            } else {
                callBackObtenerResultadosGenerales.resultadosGeneralesObtenidos(resultadosGeneralesPersonalizados);
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionExamenesSolicitados - Obtener Resultados Generales: " + e.getMessage());
            callBackObtenerResultadosGenerales.errorDesconocidoObtenerResultadosGenerales("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }
    
    public void obtenerResultadoGeneral(final ExamenSolicitado examenSolicitado) {
        try {
            final ResultadoGeneralPersonalizado resultadoGeneralPersonalizado = sqlExamenSolicitado.obtenerResultadoGeneral(examenSolicitado);
            if (resultadoGeneralPersonalizado == null) {
                callBackObtenerResultadoGeneral.errorObtenerResultadoGeneral("Se produjo un error, vuelve a intentarlo.");
            } else {
                callBackObtenerResultadoGeneral.resultadoGeneralObtenido(resultadoGeneralPersonalizado);
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionExamenesSolicitados - Obtener Resultado General: " + e.getMessage());
            callBackObtenerResultadoGeneral.errorDesconocidoObtenerResultadoGeneral("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Interfaces">
    
    public interface CallBackObtenerResultadosGenerales {

        void resultadosGeneralesObtenidos(final List<ResultadoGeneralPersonalizado> resultadosGeneralesPersonalizados);
        
        void listaResultadosGeneralesVacia(final String msg);

        void errorObtenerResultadosGenerales(final String msg);

        void errorDesconocidoObtenerResultadosGenerales(final String msg);
    }
    
    public interface CallBackObtenerResultadoGeneral {

        void resultadoGeneralObtenido (final ResultadoGeneralPersonalizado resultadoGeneralPersonalizado);

        void errorObtenerResultadoGeneral(final String msg);

        void errorDesconocidoObtenerResultadoGeneral(final String msg);
    }
    
    // </editor-fold>
    
}