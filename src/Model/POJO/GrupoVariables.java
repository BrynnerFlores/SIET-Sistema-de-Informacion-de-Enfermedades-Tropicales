package Model.POJO;

/**
 *
 * @author Brynner
 */
public class GrupoVariables {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoGrupoVariable;
    private Examen examen;
    private String grupoVariableNombre;
    private int grupoVariableEstado;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public GrupoVariables(int codigoGrupoVariable, Examen examen, String grupoVariableNombre, int grupoVariableEstado) {
        this.codigoGrupoVariable = codigoGrupoVariable;
        this.examen = examen;
        this.grupoVariableNombre = grupoVariableNombre;
        this.grupoVariableEstado = grupoVariableEstado;
    }
    
    public GrupoVariables(Examen examen, String grupoVariableNombre, int grupoVariableEstado) {
        this.examen = examen;
        this.grupoVariableNombre = grupoVariableNombre;
        this.grupoVariableEstado = grupoVariableEstado;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public int getCodigoGrupoVariable() {
        return codigoGrupoVariable;
    }

    public void setCodigoGrupoVariable(int codigoGrupoVariable) {
        this.codigoGrupoVariable = codigoGrupoVariable;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public String getGrupoVariableNombre() {
        return grupoVariableNombre;
    }

    public void setGrupoVariableNombre(String grupoVariableNombre) {
        this.grupoVariableNombre = grupoVariableNombre;
    }

    public int getGrupoVariableEstado() {
        return grupoVariableEstado;
    }

    public void setGrupoVariableEstado(int grupoVariableEstado) {
        this.grupoVariableEstado = grupoVariableEstado;
    }
    
    // </editor-fold>
    
}