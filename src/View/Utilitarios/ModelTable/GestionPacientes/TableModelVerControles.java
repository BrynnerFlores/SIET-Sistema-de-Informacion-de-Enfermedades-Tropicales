package View.Utilitarios.ModelTable.GestionPacientes;

import Model.POJO.ExamenSolicitado;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelVerControles extends AbstractTableModel {

    private final String[] columnas = {"Nº", "EXAMEN", "MUESTRA B.", "FEC. RECEP", "HORA RECEP", "EST. MUESTRA B"};
    private List<ExamenSolicitado> examenesSolcitados;

    public void setExamenesSolcitados(List<ExamenSolicitado> examenesSolcitados) {
        this.examenesSolcitados = examenesSolcitados;
        fireTableDataChanged();
    }

    public void limpiarLista() {
        if (examenesSolcitados != null) {
            examenesSolcitados.clear();
            fireTableDataChanged();
        }
    }

    @Override
    public int getRowCount() {
        return examenesSolcitados == null ? 0 : examenesSolcitados.size();
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
                return examenesSolcitados.get(rowIndex).getExamen().getExamenNombre();

            case 2:
                return examenesSolcitados.get(rowIndex).getMuestraBiologica().getMuestraBiologicaTipo();

            case 3:
                return examenesSolcitados.get(rowIndex).getRecepcion().getFechaRecepcion();

            case 4:
                return examenesSolcitados.get(rowIndex).getRecepcion().getHoraRecepcion();

            case 5:
                return examenesSolcitados.get(rowIndex).getMuestraBiologicaEstado();

            default:
                return null;
        }
    }

    public ExamenSolicitado getExamenSolicitado(final int rowIndex) {
        return examenesSolcitados.get(rowIndex);
    }
}