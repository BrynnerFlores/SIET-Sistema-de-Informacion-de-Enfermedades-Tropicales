package View.Utilitarios.ModelTable.GestionExamenes;

import Model.POJO.Examen;
import Model.POJOPersonalizado.ExamenPersonalizado;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelGestionExamenes extends AbstractTableModel {

    private final String[] columnas = {"Nº", "CODIGO", "EXAMEN", "SUBESPECIALIDAD", "ESPECIALIDAD", "# GRUPO DE VARIABLES", "# POSIBLES RESULTADOS", "# TECNICAS"};
    private List<ExamenPersonalizado> examenesPersonalizados;

    public void setExamenes(List<ExamenPersonalizado> examenesPersonalizados) {
        this.examenesPersonalizados = examenesPersonalizados;
        fireTableDataChanged();
    }

    public void limpiarLista() {
        if (examenesPersonalizados != null) {
            examenesPersonalizados.clear();
            fireTableDataChanged();
        }
    }

    @Override
    public int getRowCount() {
        return examenesPersonalizados == null ? 0 : examenesPersonalizados.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int colunIndex) {
        return columnas[colunIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        final Examen examen = examenesPersonalizados.get(rowIndex).getExamen();

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;

            case 1:
                return examen.getCodigoExamen();

            case 2:
                return examen.getExamenNombre();

            case 3:
                return examen.getSubespecialidad().getSubespecialidadNombre();
                
            case 4:
                return examen.getSubespecialidad().getEspecialidad().getEspecialidadNombre();
                
            case 5:
                return examenesPersonalizados.get(rowIndex).getTotalGrupoVariables();
                
            case 6:
                return examenesPersonalizados.get(rowIndex).getTotalPosiblesResultados();
                
            case 7:
                return examenesPersonalizados.get(rowIndex).getTotalTecnicas();

            default:
                return null;
        }
    }

    public Examen getExamen(final int rowIndex) {
        return examenesPersonalizados.get(rowIndex).getExamen();
    }
}