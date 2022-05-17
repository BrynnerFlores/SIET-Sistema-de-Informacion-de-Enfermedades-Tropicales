package Model.POJOPersonalizado;

import Model.POJO.GrupoVariables;
import Model.POJO.VariableExamenInformePersonalizado;
import java.util.List;

/**
 *
 * @author Brynner
 */
public class GrupoVariablesInformePersonalizado {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private GrupoVariables grupoVariables;
    private List<VariableExamenInformePersonalizado> variablesExamenInformePersonalizado;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">

    public GrupoVariablesInformePersonalizado(GrupoVariables grupoVariables, List<VariableExamenInformePersonalizado> variablesExamenInformePersonalizado) {
        this.grupoVariables = grupoVariables;
        this.variablesExamenInformePersonalizado = variablesExamenInformePersonalizado;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public GrupoVariables getGrupoVariables() {
        return grupoVariables;
    }

    public void setGrupoVariables(GrupoVariables grupoVariables) {
        this.grupoVariables = grupoVariables;
    }
    
    public List<VariableExamenInformePersonalizado> getVariablesExamenInformePersonalizado() {
        return variablesExamenInformePersonalizado;
    }

    public void setVariablesExamenInformePersonalizado(List<VariableExamenInformePersonalizado> variablesExamenInformePersonalizado) {
        this.variablesExamenInformePersonalizado = variablesExamenInformePersonalizado;
    }
    
    // </editor-fold>
    
}