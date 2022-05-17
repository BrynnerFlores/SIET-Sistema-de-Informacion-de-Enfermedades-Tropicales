package View.Utilitarios.ModelTable.GestionPacientes;

import Model.POJOPersonalizado.PacientePersonalizado;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelGestionPacientes extends AbstractTableModel {

    private final String[] columnas = {"Nº", "HIST. CLINICO", "C.I", "APELLIDO", "NOMBRE", "SEXO", "¿EN SEGUIMIENTO?"};
    private List<PacientePersonalizado> pacientesPersonalizados;

    public void setPacientesPersonalizados(List<PacientePersonalizado> pacientesPersonalizados) {
        this.pacientesPersonalizados = pacientesPersonalizados;
        fireTableDataChanged();
    }

    public void limpiarLista() {
        if (pacientesPersonalizados != null) {
            pacientesPersonalizados.clear();
            fireTableDataChanged();
        }
    }

    @Override
    public int getRowCount() {
        return pacientesPersonalizados == null ? 0 : pacientesPersonalizados.size();
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
                return pacientesPersonalizados.get(rowIndex).getPaciente().getCodigoPaciente();

            case 2:
                return pacientesPersonalizados.get(rowIndex).getPaciente().getPersona().getPersonaCedulaIdentidad();

            case 3:
                return pacientesPersonalizados.get(rowIndex).getPaciente().getPersona().getPersonaApellido();

            case 4:
                return pacientesPersonalizados.get(rowIndex).getPaciente().getPersona().getPersonaNombre();

            case 5:
                return pacientesPersonalizados.get(rowIndex).getPaciente().getPersona().getPersonaSexo();
                
            case 6:
                return pacientesPersonalizados.get(rowIndex).isPacienteEnSeguimiento() ? "SI" : "NO";

            default:
                return null;
        }
    }

    public PacientePersonalizado getPacientePersonalizado(final int rowIndex) {
        return pacientesPersonalizados.get(rowIndex);
    }
}