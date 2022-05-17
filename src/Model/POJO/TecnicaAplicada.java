package Model.POJO;

/**
 *
 * @author Brynner
 */
public class TecnicaAplicada {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoTecnicaAplicada;
    private ResultadoGeneral resultadoGeneral;
    private Tecnica tecnica;
    private int tecnicaAplicadaEstado;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public TecnicaAplicada(int codigoTecnicaAplicada, ResultadoGeneral resultadoGeneral, Tecnica tecnica, int tecnicaAplicadaEstado) {
        this.codigoTecnicaAplicada = codigoTecnicaAplicada;
        this.resultadoGeneral = resultadoGeneral;
        this.tecnica = tecnica;
        this.tecnicaAplicadaEstado = tecnicaAplicadaEstado;
    }
    
    public TecnicaAplicada(ResultadoGeneral resultadoGeneral, Tecnica tecnica, int tecnicaAplicadaEstado) {
        this.resultadoGeneral = resultadoGeneral;
        this.tecnica = tecnica;
        this.tecnicaAplicadaEstado = tecnicaAplicadaEstado;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public int getCodigoTecnicaAplicada() {
        return codigoTecnicaAplicada;
    }

    public void setCodigoTecnicaAplicada(int codigoTecnicaAplicada) {
        this.codigoTecnicaAplicada = codigoTecnicaAplicada;
    }

    public ResultadoGeneral getResultadoGeneral() {
        return resultadoGeneral;
    }

    public void setResultadoGeneral(ResultadoGeneral resultadoGeneral) {
        this.resultadoGeneral = resultadoGeneral;
    }

    public Tecnica getTecnica() {
        return tecnica;
    }

    public void setTecnica(Tecnica tecnica) {
        this.tecnica = tecnica;
    }

    public int getTecnicaAplicadaEstado() {
        return tecnicaAplicadaEstado;
    }

    public void setTecnicaAplicadaEstado(int tecnicaAplicadaEstado) {
        this.tecnicaAplicadaEstado = tecnicaAplicadaEstado;
    }
    
    // </editor-fold>
    
}