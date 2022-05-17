package Model.POJO.Reportes.ResultadoExamen;

/**
 *
 * @author Brynner
 */
public class TablaParametros {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private String grupoParametro;
    private String parametro;
    private String parametroResultado;
    private String parametroValorNormal;
    private String parametrosMetodo;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public TablaParametros(String grupoParametro, String parametro, String parametroResultado, String parametroValorNormal, String parametrosMetodo) {
        this.grupoParametro = grupoParametro;
        this.parametro = parametro;
        this.parametroResultado = parametroResultado;
        this.parametroValorNormal = parametroValorNormal;
        this.parametrosMetodo = parametrosMetodo;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters">
    
    public String getGrupoParametro() {
        return grupoParametro;
    }

    public String getParametro() {
        return parametro;
    }

    public String getParametroResultado() {
        return parametroResultado;
    }

    public String getParametroValorNormal() {
        return parametroValorNormal;
    }

    public String getParametrosMetodo() {
        return parametrosMetodo;
    }

    // </editor-fold>
    
}