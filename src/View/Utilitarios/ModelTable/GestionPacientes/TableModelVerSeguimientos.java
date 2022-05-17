package View.Utilitarios.ModelTable.GestionPacientes;

import Model.POJOPersonalizado.SeguimientoPacientePersonalizado;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelVerSeguimientos extends AbstractTableModel {

    private final String[] columnas = {"Nº", "EXAMEN", "FEC. INICIO", "HORA. INICIO", "EST. SEGUIMIENTO", "# CONTROLES"};
    private List<SeguimientoPacientePersonalizado> seguimientosPacientePersonalizados;

    public void setSeguimientosPacientePersonalizados(List<SeguimientoPacientePersonalizado> seguimientosPacientePersonalizados) {
        this.seguimientosPacientePersonalizados = seguimientosPacientePersonalizados;
        fireTableDataChanged();
    }

    public void limpiarLista() {
        if (seguimientosPacientePersonalizados != null) {
            seguimientosPacientePersonalizados.clear();
            fireTableDataChanged();
        }
    }

    @Override
    public int getRowCount() {
        return seguimientosPacientePersonalizados == null ? 0 : seguimientosPacientePersonalizados.size();
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
                return seguimientosPacientePersonalizados.get(rowIndex).getSeguimientoPaciente().getExamen().getExamenNombre();

            case 2:
                return seguimientosPacientePersonalizados.get(rowIndex).getSeguimientoPaciente().getFechaInicio();

            case 3:
                return seguimientosPacientePersonalizados.get(rowIndex).getSeguimientoPaciente().getHoraInicio();

            case 4:
                return seguimientosPacientePersonalizados.get(rowIndex).getSeguimientoPaciente().getProgreso();

            case 5:
                return seguimientosPacientePersonalizados.get(rowIndex).getTotalControles();

            default:
                return null;
        }
    }

    public SeguimientoPacientePersonalizado getSeguimientoPacientePersonalizado(final int rowIndex) {
        return seguimientosPacientePersonalizados.get(rowIndex);
    }
}