package Model.POJOPersonalizado;

import Model.POJO.Examen;

/**
 *
 * @author Brynner
 */
public class ExamenPersonalizado {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private Examen examen;
    private int totalPosiblesResultados;
    private int totalTecnicas;
    private int totalGrupoVariables;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public ExamenPersonalizado(Examen examen, int totalPosiblesResultados, int totalTecnicas, int totalGrupoVariables) {
        this.examen = examen;
        this.totalPosiblesResultados = totalPosiblesResultados;
        this.totalTecnicas = totalTecnicas;
        this.totalGrupoVariables = totalGrupoVariables;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public int getTotalPosiblesResultados() {
        return totalPosiblesResultados;
    }

    public void setTotalPosiblesResultados(int totalPosiblesResultados) {
        this.totalPosiblesResultados = totalPosiblesResultados;
    }

    public int getTotalTecnicas() {
        return totalTecnicas;
    }

    public void setTotalTecnicas(int totalTecnicas) {
        this.totalTecnicas = totalTecnicas;
    }

    public int getTotalGrupoVariables() {
        return totalGrupoVariables;
    }

    public void setTotalGrupoVariables(int totalGrupoVariables) {
        this.totalGrupoVariables = totalGrupoVariables;
    }
    
    // </editor-fold>
    
}