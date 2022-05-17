package View.Utilitarios.ModelTable.GestionExamenes;

import Model.POJO.VariableExamen;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelVerVariables extends AbstractTableModel {

    private final String[] columnas = {"Nº", "VARIABLE", "VALOR DE REFERENCIA", "METODO", "TIPO VARIABLE", "VALOR MIN", "VALOR MAX"};
    private List<VariableExamen> variablesExamen;

    public void setVariablesExamen(List<VariableExamen> variablesExamen) {
        this.variablesExamen = variablesExamen;
        fireTableDataChanged();
    }

    public void limpiarLista() {
        if (variablesExamen != null) {
            variablesExamen.clear();
            fireTableDataChanged();
        }
    }

    @Override
    public int getRowCount() {
        return variablesExamen == null ? 0 : variablesExamen.size();
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
        final VariableExamen variableExamen = variablesExamen.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;

            case 1:
                return variableExamen.getVariableExamenNombre();

            case 2:
                return variableExamen.getVariableExamenValorReferencia();

            case 3:
                return variableExamen.getVariableExamenMetodo();

            case 4:
                return variableExamen.getVariableTipoVariable();

            case 5:
                return variableExamen.getVariableValorMinimo();

            case 6:
                return variableExamen.getVariableValorMaximo();

            default:
                return null;
        }
    }

    public VariableExamen getVariableExamen(final int rowIndex) {
        return variablesExamen.get(rowIndex);
    }
}