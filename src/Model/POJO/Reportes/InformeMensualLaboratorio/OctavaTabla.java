package Model.POJO.Reportes.InformeMensualLaboratorio;

/**
 *
 * @author Brynner
 */
public class OctavaTabla {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int muestrasTomadasRecibidasPorElLaboratorio;
    private int muestrasReferidasPorElLaboratorio;
    private int muestrasProcesadas;
    private int resultadoPositivo;
    private int resultadoNegativo;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">    
    
    public OctavaTabla(int muestrasTomadasRecibidasPorElLaboratorio, int muestrasReferidasPorElLaboratorio, int muestrasProcesadas, int resultadoPositivo, int resultadoNegativo) {
        this.muestrasTomadasRecibidasPorElLaboratorio = muestrasTomadasRecibidasPorElLaboratorio;
        this.muestrasReferidasPorElLaboratorio = muestrasReferidasPorElLaboratorio;
        this.muestrasProcesadas = muestrasProcesadas;
        this.resultadoPositivo = resultadoPositivo;
        this.resultadoNegativo = resultadoNegativo;
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

    public int getResultadoPositivo() {
        return resultadoPositivo;
    }

    public void setResultadoPositivo(int resultadoPositivo) {
        this.resultadoPositivo = resultadoPositivo;
    }

    public int getResultadoNegativo() {
        return resultadoNegativo;
    }

    public void setResultadoNegativo(int resultadoNegativo) {
        this.resultadoNegativo = resultadoNegativo;
    }

    // </editor-fold>
    
}