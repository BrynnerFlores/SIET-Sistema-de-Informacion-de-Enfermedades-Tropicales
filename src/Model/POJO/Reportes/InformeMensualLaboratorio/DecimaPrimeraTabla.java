package Model.POJO.Reportes.InformeMensualLaboratorio;

/**
 *
 * @author Brynner
 */
public class DecimaPrimeraTabla {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int muestrasTomadasRecibidasPorElLaboratorioMasculino;
    private int muestrasTomadasRecibidasPorElLaboratorioFemenino;
    private int muestrasProcesadasMasculino;
    private int muestrasProcesadasFemenino;
    private int casosPositivosMasculino;
    private int casosPositivosFemenino;
    private int casosPositivosEmbarazadas;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public DecimaPrimeraTabla(int muestrasTomadasRecibidasPorElLaboratorioMasculino, int muestrasTomadasRecibidasPorElLaboratorioFemenino, int muestrasProcesadasMasculino, int muestrasProcesadasFemenino, int casosPositivosMasculino, int casosPositivosFemenino, int casosPositivosEmbarazadas) {
        this.muestrasTomadasRecibidasPorElLaboratorioMasculino = muestrasTomadasRecibidasPorElLaboratorioMasculino;
        this.muestrasTomadasRecibidasPorElLaboratorioFemenino = muestrasTomadasRecibidasPorElLaboratorioFemenino;
        this.muestrasProcesadasMasculino = muestrasProcesadasMasculino;
        this.muestrasProcesadasFemenino = muestrasProcesadasFemenino;
        this.casosPositivosMasculino = casosPositivosMasculino;
        this.casosPositivosFemenino = casosPositivosFemenino;
        this.casosPositivosEmbarazadas = casosPositivosEmbarazadas;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">    
    
    public int getMuestrasTomadasRecibidasPorElLaboratorioMasculino() {
        return muestrasTomadasRecibidasPorElLaboratorioMasculino;
    }

    public void setMuestrasTomadasRecibidasPorElLaboratorioMasculino(int muestrasTomadasRecibidasPorElLaboratorioMasculino) {
        this.muestrasTomadasRecibidasPorElLaboratorioMasculino = muestrasTomadasRecibidasPorElLaboratorioMasculino;
    }

    public int getMuestrasTomadasRecibidasPorElLaboratorioFemenino() {
        return muestrasTomadasRecibidasPorElLaboratorioFemenino;
    }

    public void setMuestrasTomadasRecibidasPorElLaboratorioFemenino(int muestrasTomadasRecibidasPorElLaboratorioFemenino) {
        this.muestrasTomadasRecibidasPorElLaboratorioFemenino = muestrasTomadasRecibidasPorElLaboratorioFemenino;
    }

    public int getMuestrasProcesadasMasculino() {
        return muestrasProcesadasMasculino;
    }

    public void setMuestrasProcesadasMasculino(int muestrasProcesadasMasculino) {
        this.muestrasProcesadasMasculino = muestrasProcesadasMasculino;
    }

    public int getMuestrasProcesadasFemenino() {
        return muestrasProcesadasFemenino;
    }

    public void setMuestrasProcesadasFemenino(int muestrasProcesadasFemenino) {
        this.muestrasProcesadasFemenino = muestrasProcesadasFemenino;
    }

    public int getCasosPositivosMasculino() {
        return casosPositivosMasculino;
    }

    public void setCasosPositivosMasculino(int casosPositivosMasculino) {
        this.casosPositivosMasculino = casosPositivosMasculino;
    }

    public int getCasosPositivosFemenino() {
        return casosPositivosFemenino;
    }

    public void setCasosPositivosFemenino(int casosPositivosFemenino) {
        this.casosPositivosFemenino = casosPositivosFemenino;
    }

    public int getCasosPositivosEmbarazadas() {
        return casosPositivosEmbarazadas;
    }

    public void setCasosPositivosEmbarazadas(int casosPositivosEmbarazadas) {
        this.casosPositivosEmbarazadas = casosPositivosEmbarazadas;
    }
    
    // </editor-fold>
    
}