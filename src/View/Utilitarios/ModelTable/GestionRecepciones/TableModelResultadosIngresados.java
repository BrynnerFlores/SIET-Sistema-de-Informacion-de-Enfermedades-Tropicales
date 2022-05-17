package View.Utilitarios.ModelTable.GestionRecepciones;

import Model.POJOPersonalizado.ResultadoGeneralPersonalizado;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelResultadosIngresados extends AbstractTableModel {
    
    private final String[] columnas = {"Nº", "RESP. ANALISIS", "RESP. RESULTADOS", "NUM. MUESTRA B."};
    private List<ResultadoGeneralPersonalizado> resultadosGeneralesPersonalizados;

    public List<ResultadoGeneralPersonalizado> getResultadosGeneralesPersonalizados() {
        return resultadosGeneralesPersonalizados;
    }

    public void setResultadosGeneralesPersonalizados(List<ResultadoGeneralPersonalizado> resultadosGeneralesPersonalizados) {
        this.resultadosGeneralesPersonalizados = resultadosGeneralesPersonalizados;
        fireTableDataChanged();
    }
    
    public void limpiarLista() {
        if (resultadosGeneralesPersonalizados != null) {
            resultadosGeneralesPersonalizados.clear();
            fireTableDataChanged();
        }
    }
    
    @Override
    public int getRowCount() {
        return resultadosGeneralesPersonalizados == null ? 0 : resultadosGeneralesPersonalizados.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(final int columnIndex) {
        return columnas[columnIndex];
    }

    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;

            case 1:
                return resultadosGeneralesPersonalizados.get(rowIndex).getResultadoGeneral().getPersonalTecnicoAnalista().getPersona().getPersonaApellido() + " " + resultadosGeneralesPersonalizados.get(rowIndex).getResultadoGeneral().getPersonalTecnicoAnalista().getPersona().getPersonaNombre();

            case 2:
                return resultadosGeneralesPersonalizados.get(rowIndex).getResultadoGeneral().getPersonalTecnicoResultados().getPersona().getPersonaApellido() + " " + resultadosGeneralesPersonalizados.get(rowIndex).getResultadoGeneral().getPersonalTecnicoResultados().getPersona().getPersonaNombre();

            case 3:
                return resultadosGeneralesPersonalizados.get(rowIndex).getResultadoGeneral().getNumeroMuestraBiologica();
                
            default:
                return null;
        }
    }
    
    public ResultadoGeneralPersonalizado getResultadoGeneralPersonalizado(final int rowIndex) {
        return resultadosGeneralesPersonalizados.get(rowIndex);
    }
}