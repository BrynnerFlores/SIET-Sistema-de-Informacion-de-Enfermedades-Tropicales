package View.Utilitarios.ModelTable.GestionRecepciones;

import Model.POJOPersonalizado.ExamenSolicitadoPersonalizado;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelDetallesRecepciones extends AbstractTableModel {
    
    private final String[] columnas = {"Nº", "EXAMEN", "MUESTRA BIOLOGICA", "# MUESTRAS BIOLOGICAS", "ESTADO MUESTRA", "# RESULTS. INGRESADOS"};
    private List<ExamenSolicitadoPersonalizado> examenesSolicitadosPersonalizados;

    public void setExamenesSolicitadosPersonalizados(List<ExamenSolicitadoPersonalizado> examenesSolicitadosPersonalizados) {
        this.examenesSolicitadosPersonalizados = examenesSolicitadosPersonalizados;
        fireTableDataChanged();
    }
    
    public List<ExamenSolicitadoPersonalizado> getExamenesSolicitadosPersonalizados() {
        return examenesSolicitadosPersonalizados;
    }
    
    public void limpiarLista() {
        if (examenesSolicitadosPersonalizados != null) {
            examenesSolicitadosPersonalizados.clear();
            fireTableDataChanged();
        }
    }
    
    @Override
    public int getRowCount() {
        return examenesSolicitadosPersonalizados == null ? 0 : examenesSolicitadosPersonalizados.size();
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
                return examenesSolicitadosPersonalizados.get(rowIndex).getExamenSolicitado().getExamen().getExamenNombre();

            case 2:
                return examenesSolicitadosPersonalizados.get(rowIndex).getExamenSolicitado().getMuestraBiologica().getMuestraBiologicaTipo();

            case 3:
                return examenesSolicitadosPersonalizados.get(rowIndex).getExamenSolicitado().getTotalMuestrasBiologicas();
                
            case 4:
                return examenesSolicitadosPersonalizados.get(rowIndex).getExamenSolicitado().getMuestraBiologicaEstado();
                
            case 5:
                return examenesSolicitadosPersonalizados.get(rowIndex).getTotalResultadosIngresados();

            default:
                return null;
        }
    }
    
    public ExamenSolicitadoPersonalizado getExamenSolicitadoPersonalizado(final int rowIndex) {
        return examenesSolicitadosPersonalizados.get(rowIndex);
    }
}