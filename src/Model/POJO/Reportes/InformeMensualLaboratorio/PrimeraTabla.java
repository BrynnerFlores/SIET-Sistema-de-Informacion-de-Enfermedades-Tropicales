package Model.POJO.Reportes.InformeMensualLaboratorio;

/**
 *
 * @author Brynner
 */
public class PrimeraTabla {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int totalMuestrasTomadasEnElLaboratorio;
    private int totalMuestrasReferidasAlLaboratorio;
    private int totalMuestrasReferidasPorLaboratorio;
    private int totalMuestrasProcesadas;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">

    public PrimeraTabla(int totalMuestrasTomadasEnElLaboratorio, int totalMuestrasReferidasAlLaboratorio, int totalMuestrasReferidasPorLaboratorio, int totalMuestrasProcesadas) {
        this.totalMuestrasTomadasEnElLaboratorio = totalMuestrasTomadasEnElLaboratorio;
        this.totalMuestrasReferidasAlLaboratorio = totalMuestrasReferidasAlLaboratorio;
        this.totalMuestrasReferidasPorLaboratorio = totalMuestrasReferidasPorLaboratorio;
        this.totalMuestrasProcesadas = totalMuestrasProcesadas;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters">
    
    public int getTotalMuestrasTomadasEnElLaboratorio() {
        return totalMuestrasTomadasEnElLaboratorio;
    }

    public void setTotalMuestrasTomadasEnElLaboratorio(int totalMuestrasTomadasEnElLaboratorio) {
        this.totalMuestrasTomadasEnElLaboratorio = totalMuestrasTomadasEnElLaboratorio;
    }

    public int getTotalMuestrasReferidasAlLaboratorio() {
        return totalMuestrasReferidasAlLaboratorio;
    }

    public void setTotalMuestrasReferidasAlLaboratorio(int totalMuestrasReferidasAlLaboratorio) {
        this.totalMuestrasReferidasAlLaboratorio = totalMuestrasReferidasAlLaboratorio;
    }

    public int getTotalMuestrasReferidasPorLaboratorio() {
        return totalMuestrasReferidasPorLaboratorio;
    }

    public void setTotalMuestrasReferidasPorLaboratorio(int totalMuestrasReferidasPorLaboratorio) {
        this.totalMuestrasReferidasPorLaboratorio = totalMuestrasReferidasPorLaboratorio;
    }

    public int getTotalMuestrasProcesadas() {
        return totalMuestrasProcesadas;
    }

    public void setTotalMuestrasProcesadas(int totalMuestrasProcesadas) {
        this.totalMuestrasProcesadas = totalMuestrasProcesadas;
    }
    
    // </editor-fold>
}