package Model.POJOPersonalizado;

import Model.POJO.ExamenSolicitado;

/**
 *
 * @author Brynner
 */
public class ExamenSolicitadoPersonalizado {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private ExamenSolicitado examenSolicitado;
    private int totalResultadosIngresados;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public ExamenSolicitadoPersonalizado(ExamenSolicitado examenSolicitado, int totalResultadosIngresados) {
        this.examenSolicitado = examenSolicitado;
        this.totalResultadosIngresados = totalResultadosIngresados;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public ExamenSolicitado getExamenSolicitado() {
        return examenSolicitado;
    }

    public void setExamenSolicitado(ExamenSolicitado examenSolicitado) {
        this.examenSolicitado = examenSolicitado;
    }

    public int getTotalResultadosIngresados() {
        return totalResultadosIngresados;
    }

    public void setTotalResultadosIngresados(int totalResultadosIngresados) {
        this.totalResultadosIngresados = totalResultadosIngresados;
    }
    
    // </editor-fold>
    
}