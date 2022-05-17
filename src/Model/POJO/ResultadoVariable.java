package Model.POJO;

/**
 *
 * @author Brynner
 */
public class ResultadoVariable {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoResultadoVariable;
    private ResultadoGeneral resultadoGeneral;
    private VariableExamen variableExamen;
    private String resultadoVariable;
    private int resultadoVariableEstado;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public ResultadoVariable(int codigoResultadoVariable, ResultadoGeneral resultadoGeneral, VariableExamen variableExamen, String resultadoVariable, int resultadoVariableEstado) {
        this.codigoResultadoVariable = codigoResultadoVariable;
        this.resultadoGeneral = resultadoGeneral;
        this.variableExamen = variableExamen;
        this.resultadoVariable = resultadoVariable;
        this.resultadoVariableEstado = resultadoVariableEstado;
    }

    public ResultadoVariable(ResultadoGeneral resultadoGeneral, VariableExamen variableExamen, String resultadoVariable, int resultadoVariableEstado) {
        this.resultadoGeneral = resultadoGeneral;
        this.variableExamen = variableExamen;
        this.resultadoVariable = resultadoVariable;
        this.resultadoVariableEstado = resultadoVariableEstado;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public int getCodigoResultadoVariable() {
        return codigoResultadoVariable;
    }

    public void setCodigoResultadoVariable(int codigoResultadoVariable) {
        this.codigoResultadoVariable = codigoResultadoVariable;
    }

    public ResultadoGeneral getResultadoGeneral() {
        return resultadoGeneral;
    }

    public void setResultadoGeneral(ResultadoGeneral resultadoGeneral) {
        this.resultadoGeneral = resultadoGeneral;
    }

    public VariableExamen getVariableExamen() {
        return variableExamen;
    }

    public void setVariableExamen(VariableExamen variableExamen) {
        this.variableExamen = variableExamen;
    }

    public String getResultadoVariable() {
        return resultadoVariable;
    }
    
    public void setResultadoVariable(String resultadoVariable) {    
        this.resultadoVariable = resultadoVariable;
    }
    
    public int getResultadoVariableEstado() {
        return resultadoVariableEstado;
    }

    public void setResultadoVariableEstado(int resultadoVariableEstado) {
        this.resultadoVariableEstado = resultadoVariableEstado;
    }
    
    // </editor-fold>    
    
}