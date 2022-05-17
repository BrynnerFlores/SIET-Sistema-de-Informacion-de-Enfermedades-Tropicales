package Model.POJOPersonalizado;

import Model.POJO.GrupoVariables;

/**
 *
 * @author Brynner
 */
public class GrupoVariablesPersonalizado {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private GrupoVariables grupoVariables;
    private int totalVariables;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public GrupoVariablesPersonalizado(GrupoVariables grupoVariables, int totalVariables) {
        this.grupoVariables = grupoVariables;
        this.totalVariables = totalVariables;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public GrupoVariables getGrupoVariables() {
        return grupoVariables;
    }

    public int getTotalVariables() {
        return totalVariables;
    }

    // </editor-fold>
}