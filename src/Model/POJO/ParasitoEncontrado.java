package Model.POJO;

/**
 *
 * @author Brynner
 */
public class ParasitoEncontrado {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoParasitoEncontrado;
    private ResultadoGeneral resultadoGeneral;
    private Parasito parasito;
    private String parasitoTipoObservacion;
    private int parasitoEncontradoEstado;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public ParasitoEncontrado(int codigoParasitoEncontrado, ResultadoGeneral resultadoGeneral, Parasito parasito, String parasitoTipoObservacion, int parasitoEncontradoEstado) {
        this.codigoParasitoEncontrado = codigoParasitoEncontrado;
        this.resultadoGeneral = resultadoGeneral;
        this.parasito = parasito;
        this.parasitoTipoObservacion = parasitoTipoObservacion;
        this.parasitoEncontradoEstado = parasitoEncontradoEstado;
    }
    
    public ParasitoEncontrado(ResultadoGeneral resultadoGeneral, Parasito parasito, String parasitoTipoObservacion, int parasitoEncontradoEstado) {
        this.resultadoGeneral = resultadoGeneral;
        this.parasito = parasito;
        this.parasitoTipoObservacion = parasitoTipoObservacion;
        this.parasitoEncontradoEstado = parasitoEncontradoEstado;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public int getCodigoParasitoEncontrado() {
        return codigoParasitoEncontrado;
    }

    public void setCodigoParasitoEncontrado(int codigoParasitoEncontrado) {
        this.codigoParasitoEncontrado = codigoParasitoEncontrado;
    }

    public ResultadoGeneral getResultadoGeneral() {
        return resultadoGeneral;
    }

    public void setResultadoGeneral(ResultadoGeneral resultadoGeneral) {
        this.resultadoGeneral = resultadoGeneral;
    }

    public Parasito getParasito() {
        return parasito;
    }

    public void setParasito(Parasito parasito) {
        this.parasito = parasito;
    }

    public String getParasitoTipoObservacion() {
        return parasitoTipoObservacion;
    }

    public void setParasitoTipoObservacion(String parasitoTipoObservacion) {
        this.parasitoTipoObservacion = parasitoTipoObservacion;
    }

    public int getParasitoEncontradoEstado() {
        return parasitoEncontradoEstado;
    }

    public void setParasitoEncontradoEstado(int parasitoEncontradoEstado) {
        this.parasitoEncontradoEstado = parasitoEncontradoEstado;
    }
    
    // </editor-fold>
    
}