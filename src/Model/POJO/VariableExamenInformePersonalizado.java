package Model.POJO;

/**
 *
 * @author Brynner
 */
public class VariableExamenInformePersonalizado {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoVariableExamen;
    private GrupoVariables grupoVariables;
    private String variableExamenNombre;
    private String variableExamenValorReferencia;
    private String variableExamenMetodo;
    private int variableExamenEstado;
    private boolean isMicroMetodoChagasPositivo;
    private boolean isGotaGruesaPositivo;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public VariableExamenInformePersonalizado(int codigoVariableExamen, GrupoVariables grupoVariables, String variableExamenNombre, String variableExamenValorReferencia, String variableExamenMetodo, int variableExamenEstado, boolean isMicroMetodoChagasPositivo, boolean isGotaGruesaPositivo) {
        this.codigoVariableExamen = codigoVariableExamen;
        this.grupoVariables = grupoVariables;
        this.variableExamenNombre = variableExamenNombre;
        this.variableExamenValorReferencia = variableExamenValorReferencia;
        this.variableExamenMetodo = variableExamenMetodo;
        this.variableExamenEstado = variableExamenEstado;
        this.isMicroMetodoChagasPositivo = isMicroMetodoChagasPositivo;
        this.isGotaGruesaPositivo = isGotaGruesaPositivo;
    }
    
    public VariableExamenInformePersonalizado(GrupoVariables grupoVariables, String variableExamenNombre, String variableExamenValorReferencia, String variableExamenMetodo, int variableExamenEstado, boolean isMicroMetodoChagasPositivo, boolean isGotaGruesaPositivo) {
        this.grupoVariables = grupoVariables;
        this.variableExamenNombre = variableExamenNombre;
        this.variableExamenValorReferencia = variableExamenValorReferencia;
        this.variableExamenMetodo = variableExamenMetodo;
        this.variableExamenEstado = variableExamenEstado;
        this.isMicroMetodoChagasPositivo = isMicroMetodoChagasPositivo;
        this.isGotaGruesaPositivo = isGotaGruesaPositivo;
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

    public int getVariableExamenEstado() {
        return variableExamenEstado;
    }
    
    public void setVariableExamenEstado(int variableExamenEstado) {    
        this.variableExamenEstado = variableExamenEstado;
    }
    
    public boolean isIsMicroMetodoChagasPositivo() {
        return isMicroMetodoChagasPositivo;
    }

    public void setIsMicroMetodoChagasPositivo(boolean isMicroMetodoChagasPositivo) {
        this.isMicroMetodoChagasPositivo = isMicroMetodoChagasPositivo;
    }
    
    public boolean isIsGotaGruesaPositivo() {
        return isGotaGruesaPositivo;
    }

    public void setIsGotaGruesaPositivo(boolean isGotaGruesaPositivo) {
        this.isGotaGruesaPositivo = isGotaGruesaPositivo;
    }
    
    // </editor-fold>
    
}