package Model.POJO.Reportes.InformeMensualLaboratorio;

/**
 *
 * @author Brynner
 */
public class DecimaTabla {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int muestrasTomadasRecibidasPorElLaboratorio;
    private int muestrasReferidasPorElLaboratorio;
    private int muestrasProcesadas;
    private int casosPositivosMenor5;
    private int casosPositivos5A15;
    private int casosPositivosMayorA15;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public DecimaTabla(int muestrasTomadasRecibidasPorElLaboratorio, int muestrasReferidasPorElLaboratorio, int muestrasProcesadas, int casosPositivosMenor5, int casosPositivos5A15, int casosPositivosMayorA15) {
        this.muestrasTomadasRecibidasPorElLaboratorio = muestrasTomadasRecibidasPorElLaboratorio;
        this.muestrasReferidasPorElLaboratorio = muestrasReferidasPorElLaboratorio;
        this.muestrasProcesadas = muestrasProcesadas;
        this.casosPositivosMenor5 = casosPositivosMenor5;
        this.casosPositivos5A15 = casosPositivos5A15;
        this.casosPositivosMayorA15 = casosPositivosMayorA15;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">    
    
    public int getMuestrasTomadasRecibidasPorElLaboratorio() {
        return muestrasTomadasRecibidasPorElLaboratorio;
    }

    public void setMuestrasTomadasRecibidasPorElLaboratorio(int muestrasTomadasRecibidasPorElLaboratorio) {
        this.muestrasTomadasRecibidasPorElLaboratorio = muestrasTomadasRecibidasPorElLaboratorio;
    }

    public int getMuestrasReferidasPorElLaboratorio() {
        return muestrasReferidasPorElLaboratorio;
    }

    public void setMuestrasReferidasPorElLaboratorio(int muestrasReferidasPorElLaboratorio) {
        this.muestrasReferidasPorElLaboratorio = muestrasReferidasPorElLaboratorio;
    }

    public int getMuestrasProcesadas() {
        return muestrasProcesadas;
    }

    public void setMuestrasProcesadas(int muestrasProcesadas) {
        this.muestrasProcesadas = muestrasProcesadas;
    }

    public int getCasosPositivosMenor5() {
        return casosPositivosMenor5;
    }

    public void setCasosPositivosMenor5(int casosPositivosMenor5) {
        this.casosPositivosMenor5 = casosPositivosMenor5;
    }

    public int getCasosPositivos5A15() {
        return casosPositivos5A15;
    }

    public void setCasosPositivos5A15(int casosPositivos5A15) {
        this.casosPositivos5A15 = casosPositivos5A15;
    }

    public int getCasosPositivosMayorA15() {
        return casosPositivosMayorA15;
    }

    public void setCasosPositivosMayorA15(int casosPositivosMayorA15) {
        this.casosPositivosMayorA15 = casosPositivosMayorA15;
    }
    
    // </editor-fold>
    
}