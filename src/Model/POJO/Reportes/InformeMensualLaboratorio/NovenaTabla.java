package Model.POJO.Reportes.InformeMensualLaboratorio;

/**
 *
 * @author Brynner
 */
public class NovenaTabla {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int parasitologiaPositivo;
    private int parasitologiaNegativo;
    private int serologiaPositivo;
    private int serologiaNegativo;
    private int serologiaIndeterminado;
    private int serologiaConfirmada;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public NovenaTabla(int parasitologiaPositivo, int parasitologiaNegativo, int serologiaPositivo, int serologiaNegativo, int serologiaIndeterminado, int serologiaConfirmada) {
        this.parasitologiaPositivo = parasitologiaPositivo;
        this.parasitologiaNegativo = parasitologiaNegativo;
        this.serologiaPositivo = serologiaPositivo;
        this.serologiaNegativo = serologiaNegativo;
        this.serologiaIndeterminado = serologiaIndeterminado;
        this.serologiaConfirmada = serologiaConfirmada;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public int getParasitologiaPositivo() {
        return parasitologiaPositivo;
    }

    public void setParasitologiaPositivo(int parasitologiaPositivo) {
        this.parasitologiaPositivo = parasitologiaPositivo;
    }

    public int getParasitologiaNegativo() {
        return parasitologiaNegativo;
    }

    public void setParasitologiaNegativo(int parasitologiaNegativo) {
        this.parasitologiaNegativo = parasitologiaNegativo;
    }

    public int getSerologiaPositivo() {
        return serologiaPositivo;
    }

    public void setSerologiaPositivo(int serologiaPositivo) {
        this.serologiaPositivo = serologiaPositivo;
    }

    public int getSerologiaNegativo() {
        return serologiaNegativo;
    }

    public void setSerologiaNegativo(int serologiaNegativo) {
        this.serologiaNegativo = serologiaNegativo;
    }

    public int getSerologiaIndeterminado() {
        return serologiaIndeterminado;
    }

    public void setSerologiaIndeterminado(int serologiaIndeterminado) {
        this.serologiaIndeterminado = serologiaIndeterminado;
    }

    public int getSerologiaConfirmada() {
        return serologiaConfirmada;
    }

    public void setSerologiaConfirmada(int serologiaConfirmada) {
        this.serologiaConfirmada = serologiaConfirmada;
    }
    
    // </editor-fold>
    
}