package View.Utilitarios.ModelTable.GestionExamenes;

import Model.POJO.ExamenPosibleResultado;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelVerPosiblesResultados extends AbstractTableModel {

    private final String[] columnas = {"Nº", "CODIGO", "RESULTADO"};
    private List<ExamenPosibleResultado> examenesPosiblesResultados;

    public void setExamenesPosiblesResultados(List<ExamenPosibleResultado> examenesPosiblesResultados) {
        this.examenesPosiblesResultados = examenesPosiblesResultados;
        fireTableDataChanged();
    }
    
    public void limpiarLista() {
        if (examenesPosiblesResultados != null) {
            examenesPosiblesResultados.clear();
            fireTableDataChanged();
        }
    }
    
    @Override
    public int getRowCount() {
        return examenesPosiblesResultados == null ? 0 : examenesPosiblesResultados.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(final int column) {
        return columnas[column];
    }

    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;

            case 1:
                return examenesPosiblesResultados.get(rowIndex).getCodigoPosibleResultado();

            case 2:
                return examenesPosiblesResultados.get(rowIndex).getPosibleResultadoNombre();

            default:
                return null;
        }
    }
    
    public ExamenPosibleResultado getExamenPosibleResultado(final int roxIndex) {
        return examenesPosiblesResultados.get(roxIndex);
    }
}