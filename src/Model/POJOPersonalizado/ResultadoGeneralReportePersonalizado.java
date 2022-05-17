package Model.POJOPersonalizado;

import Model.POJO.ParasitoEncontrado;
import Model.POJO.ResultadoGeneral;
import Model.POJO.TecnicaAplicada;
import java.util.List;

/**
 *
 * @author Brynner
 */
public class ResultadoGeneralReportePersonalizado {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private ResultadoGeneral resultadoGeneral;
    private List<GrupoVariablesInformePersonalizado> grupoVariablesInformePersonalizado;
    private List<ParasitoEncontrado> parasitosEncontrados;
    private List<TecnicaAplicada> tecnicasAplicadas;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public ResultadoGeneralReportePersonalizado(ResultadoGeneral resultadoGeneral, List<GrupoVariablesInformePersonalizado> grupoVariablesInformePersonalizado, List<ParasitoEncontrado> parasitosEncontrados, List<TecnicaAplicada> tecnicasAplicadas) {
        this.resultadoGeneral = resultadoGeneral;
        this.grupoVariablesInformePersonalizado = grupoVariablesInformePersonalizado;
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

    public List<GrupoVariablesInformePersonalizado> getGrupoVariablesInformePersonalizado() {
        return grupoVariablesInformePersonalizado;
    }

    public void setGrupoVariablesInformePersonalizado(List<GrupoVariablesInformePersonalizado> grupoVariablesInformePersonalizado) {
        this.grupoVariablesInformePersonalizado = grupoVariablesInformePersonalizado;
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