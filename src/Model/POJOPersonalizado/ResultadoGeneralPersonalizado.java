package Model.POJOPersonalizado;

import Model.POJO.ParasitoEncontrado;
import Model.POJO.ResultadoGeneral;
import Model.POJO.ResultadoVariable;
import Model.POJO.TecnicaAplicada;
import java.util.List;

/**
 *
 * @author Brynner
 */
public class ResultadoGeneralPersonalizado {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private ResultadoGeneral resultadoGeneral;
    private List<ResultadoVariable> resultadosVariables;
    private List<ParasitoEncontrado> parasitosEncontrados;
    private List<TecnicaAplicada> tecnicasAplicadas;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public ResultadoGeneralPersonalizado(ResultadoGeneral resultadoGeneral, List<ResultadoVariable> resultadosVariables, List<ParasitoEncontrado> parasitosEncontrados, List<TecnicaAplicada> tecnicasAplicadas) {
        this.resultadoGeneral = resultadoGeneral;
        this.resultadosVariables = resultadosVariables;
        this.parasitosEncontrados = parasitosEncontrados;
        this.tecnicasAplicadas = tecnicasAplicadas;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public ResultadoGeneral getResultadoGeneral() {
        return resultadoGeneral;
    }

    public void setResultadoGeneral(ResultadoGeneral resultadoGeneral) {
        this.resultadoGeneral = resultadoGeneral;
    }

    public List<ResultadoVariable> getResultadosVariables() {
        return resultadosVariables;
    }

    public void setResultadosVariables(List<ResultadoVariable> resultadosVariables) {
        this.resultadosVariables = resultadosVariables;
    }

    public List<ParasitoEncontrado> getParasitosEncontrados() {
        return parasitosEncontrados;
    }

    public void setParasitosEncontrados(List<ParasitoEncontrado> parasitosEncontrados) {
        this.parasitosEncontrados = parasitosEncontrados;
    }
    
    public List<TecnicaAplicada> getTecnicasAplicadas() {
        return tecnicasAplicadas;
    }

    public void setTecnicasAplicadas(List<TecnicaAplicada> tecnicasAplicadas) {
        this.tecnicasAplicadas = tecnicasAplicadas;
    }
    
    // </editor-fold>
    
}