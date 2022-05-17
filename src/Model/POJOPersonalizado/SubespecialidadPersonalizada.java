package Model.POJOPersonalizado;

import Model.POJO.Subespecialidad;

/**
 *
 * @author Brynner
 */
public class SubespecialidadPersonalizada {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private Subespecialidad subespecialidad;
    private int totalMuestrasBiologicas;
    private int totalEnfermedades;
    private int totalExamenes;
    

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public SubespecialidadPersonalizada(Subespecialidad subespecialidad, int totalMuestrasBiologicas, int totalEnfermedades, int totalExamenes) {
        this.subespecialidad = subespecialidad;
        this.totalMuestrasBiologicas = totalMuestrasBiologicas;
        this.totalEnfermedades = totalEnfermedades;
        this.totalExamenes = totalExamenes;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public Subespecialidad getSubespecialidad() {
        return subespecialidad;
    }

    public void setSubespecialidad(Subespecialidad subespecialidad) {
        this.subespecialidad = subespecialidad;
    }

    public int getTotalMuestrasBiologicas() {
        return totalMuestrasBiologicas;
    }

    public void setTotalMuestrasBiologicas(int totalMuestrasBiologicas) {
        this.totalMuestrasBiologicas = totalMuestrasBiologicas;
    }

    public int getTotalEnfermedades() {
        return totalEnfermedades;
    }

    public void setTotalEnfermedades(int totalEnfermedades) {
        this.totalEnfermedades = totalEnfermedades;
    }

    public int getTotalExamenes() {
        return totalExamenes;
    }

    public void setTotalExamenes(int totalExamenes) {
        this.totalExamenes = totalExamenes;
    }
    
    // </editor-fold>
}