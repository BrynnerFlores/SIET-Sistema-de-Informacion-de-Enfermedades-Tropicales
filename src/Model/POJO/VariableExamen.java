package Model.POJO;

/**
 *
 * @author Brynner
 */
public class VariableExamen {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoVariableExamen;
    private GrupoVariables grupoVariables;
    private String variableExamenNombre;
    private String variableExamenValorReferencia;
    private String variableExamenMetodo;
    private String variableTipoVariable;
    private Object variableValorMinimo;
    private Object variableValorMaximo;
    private int variableExamenEstado;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public VariableExamen(int codigoVariableExamen, GrupoVariables grupoVariables, String variableExamenNombre, String variableExamenValorReferencia, String variableExamenMetodo, String variableTipoVariable, Object variableValorMinimo, Object variableValorMaximo, int variableExamenEstado) {
        this.codigoVariableExamen = codigoVariableExamen;
        this.grupoVariables = grupoVariables;
        this.variableExamenNombre = variableExamenNombre;
        this.variableExamenValorReferencia = variableExamenValorReferencia;
        this.variableExamenMetodo = variableExamenMetodo;
        this.variableTipoVariable = variableTipoVariable;
        this.variableValorMinimo = variableValorMinimo;
        this.variableValorMaximo = variableValorMaximo;
        this.variableExamenEstado = variableExamenEstado;
    }
    
    public VariableExamen(GrupoVariables grupoVariables, String variableExamenNombre, String variableExamenValorReferencia, String variableExamenMetodo, String variableTipoVariable, Object variableValorMinimo, Object variableValorMaximo, int variableExamenEstado) {
        this.grupoVariables = grupoVariables;
        this.variableExamenNombre = variableExamenNombre;
        this.variableExamenValorReferencia = variableExamenValorReferencia;
        this.variableExamenMetodo = variableExamenMetodo;
        this.variableTipoVariable = variableTipoVariable;
        this.variableValorMinimo = variableValorMinimo;
        this.variableValorMaximo = variableValorMaximo;
        this.variableExamenEstado = variableExamenEstado;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public int getCodigoVariableExamen() {
        return codigoVariableExamen;
    }

    public void setCodigoVariableExamen(int codigoVariableExamen) {
        this.codigoVariableExamen = codigoVariableExamen;
    }

    public GrupoVariables getGrupoVariables() {
        return grupoVariables;
    }

    public void setGrupoVariables(GrupoVariables grupoVariables) {
        this.grupoVariables = grupoVariables;
    }

    public String getVariableExamenNombre() {
        return variableExamenNombre;
    }

    public void setVariableExamenNombre(String variableExamenNombre) {
        this.variableExamenNombre = variableExamenNombre;
    }
    
    public String getVariableExamenValorReferencia() {
        return variableExamenValorReferencia;
    }

    public void setVariableExamenValorReferencia(String variableExamenValorReferencia) {
        this.variableExamenValorReferencia = variableExamenValorReferencia;
    }

    public String getVariableExamenMetodo() {
        return variableExamenMetodo;
    }

    public void setVariableExamenMetodo(String variableExamenMetodo) {
        this.variableExamenMetodo = variableExamenMetodo;
    }

    public String getVariableTipoVariable() {
        return variableTipoVariable;
    }

    public void setVariableTipoVariable(String variableTipoVariable) {
        this.variableTipoVariable = variableTipoVariable;
    }

    public Object getVariableValorMinimo() {
        return variableValorMinimo;
    }

    public void setVariableValorMinimo(Object variableValorMinimo) {
        this.variableValorMinimo = variableValorMinimo;
    }

    public Object getVariableValorMaximo() {
        return variableValorMaximo;
    }

    public void setVariableValorMaximo(Object variableValorMaximo) {
        this.variableValorMaximo = variableValorMaximo;
    }

    public int getVariableExamenEstado() {
        return variableExamenEstado;
    }
    
    public void setVariableExamenEstado(int variableExamenEstado) {    
        this.variableExamenEstado = variableExamenEstado;
    }
    
    // </editor-fold>
    
}