package View.Utilitarios.ModelTable.GestionRecepciones;

import Model.POJO.ResultadoVariable;
import Model.POJO.VariableExamen;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import org.apache.commons.lang3.math.NumberUtils;

/**
 *
 * @author Brynner
 */
public class TableModelResultadosVariables extends AbstractTableModel {

    private final String[] columnas = {"Nº", "VARIABLE", "RESULTADO", "VALOR NORMAL", "METODO"};
    private final boolean isEditable;
    private List<ResultadoVariable> resultadosVariables;

    public TableModelResultadosVariables(boolean isEditable) {
        this.isEditable = isEditable;
    }

    public void setResultadosVariables(List<ResultadoVariable> resultadosVariables) {
        this.resultadosVariables = resultadosVariables;
        fireTableDataChanged();
    }

    public List<ResultadoVariable> getResultadosVariables() {
        return resultadosVariables;
    }

    public void limpiarLista() {
        resultadosVariables.clear();
        fireTableDataChanged();
    }

    public boolean resultadosVacios() {
        final int size = resultadosVariables == null ? 0 : resultadosVariables.size();
        boolean isResultadosVacios = true;
        for (int i = 0; i < size; i++) {
            if (resultadosVariables.get(i).getResultadoVariable() != null && !resultadosVariables.get(i).getResultadoVariable().trim().isEmpty()) {
                isResultadosVacios = false;
                break;
            }
        }
        return isResultadosVacios;
    }

    public List<ResultadoVariable> obtenerResultadoVariablesNoVacias() {
        final List<ResultadoVariable> resultadosVariables = new ArrayList<>();
        if (this.resultadosVariables != null) {
            this.resultadosVariables.forEach((resultadoVariable) -> {
                if (resultadoVariable.getResultadoVariable() != null && !resultadoVariable.getResultadoVariable().trim().isEmpty()) {
                    resultadosVariables.add(resultadoVariable);
                }
            });
        }
        return resultadosVariables;
    }

    public int getRowPosition(final String parameters) {
        final int size = resultadosVariables.size();
        for (int i = 0; i < size; i++) {
            if (resultadosVariables.get(i).getVariableExamen().getVariableExamenNombre().equals(parameters)) {
                return i;
            }
        }
        return -1;
    }

    private Object getTotalLeucocitos() {
        final int size = resultadosVariables.size();
        Object totalLeucocitos = null;
        for (int i = 0; i < size; i++) {
            if (resultadosVariables.get(i).getVariableExamen().getVariableExamenNombre().equals("LEUCOCITOS")) {
                totalLeucocitos = resultadosVariables.get(i).getResultadoVariable();
                break;
            }
        }
        return totalLeucocitos;
    }

    private double calcularPorcentaje() {
        final int rowPositionMielocitosFLR = getRowPosition("MIELOCITOS FLR");
        final int rowPositionMetamielocitosFLR = getRowPosition("METAMIELOCITOS FLR");
        final int rowPositionCayadosFLR = getRowPosition("CAYADOS FLR");
        final int rowPositionSegmentadosFLR = getRowPosition("SEGMENTADOS FLR");
        final int rowPositionLinfocitosFLR = getRowPosition("LINFOCITOS FLR");
        final int rowPositionMonocitosFLR = getRowPosition("MONOCITOS FLR");
        final int rowPositionBasofilosFLR = getRowPosition("BASOFILOS FLR");
        final int rowPositionEosinofilosFLR = getRowPosition("EOSINOFILOS FLR");

        final double totalMielocitosFLR = getValueAt(rowPositionMielocitosFLR, 2) == null ? 0 : NumberUtils.isParsable((String) getValueAt(rowPositionMielocitosFLR, 2)) ? Double.parseDouble(String.valueOf(getValueAt(rowPositionMielocitosFLR, 2))) : 0;
        final double totalMetamielocitosFLR = getValueAt(rowPositionMetamielocitosFLR, 2) == null ? 0 : NumberUtils.isParsable((String) getValueAt(rowPositionMetamielocitosFLR, 2)) ? Double.parseDouble(String.valueOf(getValueAt(rowPositionMetamielocitosFLR, 2))) : 0;
        final double totalCayadosFLR = getValueAt(rowPositionCayadosFLR, 2) == null ? 0 : NumberUtils.isParsable((String) getValueAt(rowPositionCayadosFLR, 2)) ? Double.parseDouble(String.valueOf(getValueAt(rowPositionCayadosFLR, 2))) : 0;
        final double totalSegmentadosFLR = getValueAt(rowPositionSegmentadosFLR, 2) == null ? 0 : NumberUtils.isParsable((String) getValueAt(rowPositionSegmentadosFLR, 2)) ? Double.parseDouble(String.valueOf(getValueAt(rowPositionSegmentadosFLR, 2))) : 0;
        final double totalLinfocitosFLR = getValueAt(rowPositionLinfocitosFLR, 2) == null ? 0 : NumberUtils.isParsable((String) getValueAt(rowPositionLinfocitosFLR, 2)) ? Double.parseDouble(String.valueOf(getValueAt(rowPositionLinfocitosFLR, 2))) : 0;
        final double totalMonocitosFLR = getValueAt(rowPositionMonocitosFLR, 2) == null ? 0 : NumberUtils.isParsable((String) getValueAt(rowPositionMonocitosFLR, 2)) ? Double.parseDouble(String.valueOf(getValueAt(rowPositionMonocitosFLR, 2))) : 0;
        final double totalBasofilosFLR = getValueAt(rowPositionBasofilosFLR, 2) == null ? 0 : NumberUtils.isParsable((String) getValueAt(rowPositionBasofilosFLR, 2)) ? Double.parseDouble(String.valueOf(getValueAt(rowPositionBasofilosFLR, 2))) : 0;
        final double totalEosinofilosFLR = getValueAt(rowPositionEosinofilosFLR, 2) == null ? 0 : NumberUtils.isParsable((String) getValueAt(rowPositionEosinofilosFLR, 2)) ? Double.parseDouble(String.valueOf(getValueAt(rowPositionEosinofilosFLR, 2))) : 0;

        return (totalMielocitosFLR + totalMetamielocitosFLR + totalCayadosFLR + totalSegmentadosFLR + totalLinfocitosFLR + totalMonocitosFLR + totalBasofilosFLR + totalEosinofilosFLR);
    }

    private Object getTotalHematocrito() {
        final int size = resultadosVariables.size();
        Object totalHematocrito = -1;
        for (int i = 0; i < size; i++) {
            if (resultadosVariables.get(i).getVariableExamen().getVariableExamenNombre().equals("HEMATOCRITO")) {
                totalHematocrito = resultadosVariables.get(i).getResultadoVariable();
                break;
            }
        }
        return totalHematocrito;
    }

    @Override
    public int getRowCount() {
        return resultadosVariables == null ? 0 : resultadosVariables.size();
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
        final VariableExamen variableExamen = resultadosVariables.get(rowIndex).getVariableExamen();

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;

            case 1:
                return variableExamen.getVariableExamenNombre();

            case 2:
                return resultadosVariables.get(rowIndex).getResultadoVariable();

            case 3:
                return variableExamen.getVariableExamenValorReferencia();

            case 4:
                return variableExamen.getVariableExamenMetodo();

            default:
                return null;
        }
    }

    @Override
    public void setValueAt(final Object resultado, final int rowIndex, final int columnIndex) {
        if (columnIndex == 2) {
            final ResultadoVariable resultadoVariable = getResultadoVariable(rowIndex);
            switch (resultadoVariable.getVariableExamen().getGrupoVariables().getExamen().getExamenNombre()) {
                case "HEMOGRAMA":
                case "HEMOGRAMA COMPLETO": {
                    final Object leucocitosAux = getTotalLeucocitos();
                    switch (String.valueOf(getValueAt(rowIndex, columnIndex - 1))) {
                        case "HEMATOCRITO":
                            if (NumberUtils.isParsable(String.valueOf(resultado))) {
                                final Object valorMinimoAux = resultadoVariable.getVariableExamen().getVariableValorMinimo();
                                final Object valorMaximoAux = resultadoVariable.getVariableExamen().getVariableValorMaximo();

                                if (valorMinimoAux == null || valorMaximoAux == null) {
                                    JOptionPane.showMessageDialog(null, "La variable HEMATOCRITO no tiene definido un valor mínimo y/o máximo.", "SIET", JOptionPane.ERROR_MESSAGE);
                                } else {
                                    final double hematocrito = Double.parseDouble(resultado.toString());
                                    final int valorMinimo = Integer.valueOf(valorMinimoAux.toString());
                                    final int valorMaximo = Integer.valueOf(valorMaximoAux.toString());

                                    if (hematocrito < valorMinimo || hematocrito > valorMaximo) {
                                        JOptionPane.showMessageDialog(null, "El resultado de HEMATOCRITO no puede ser menor a: " + valorMinimo + ", ni mayor a: " + valorMaximo, "SIET", JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        final int rowPositionHematies = getRowPosition("HEMATIES");
                                        final int rowPositionHemoglobina = getRowPosition("HEMOGLOBINA");
                                        
                                        resultadoVariable.setResultadoVariable(resultado.toString());
                                        resultadosVariables.set(rowIndex, resultadoVariable);
                                        
                                        resultadosVariables.get(rowPositionHematies).setResultadoVariable(String.valueOf(hematocrito * 11 * 10000));
                                        resultadosVariables.get(rowPositionHemoglobina).setResultadoVariable(String.valueOf(Math.round((hematocrito / 3) * 10.0) / 10.0));
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "El valor de Hematocrito debe ser un número.", "SIET", JOptionPane.ERROR_MESSAGE);
                            }
                            break;

                        case "LEUCOCITOS":
                            if (NumberUtils.isParsable(String.valueOf(resultado))) {
                                final Object valorMinimoAux = resultadoVariable.getVariableExamen().getVariableValorMinimo();
                                final Object valorMaximoAux = resultadoVariable.getVariableExamen().getVariableValorMaximo();
                                if (valorMinimoAux == null || valorMaximoAux == null) {
                                    JOptionPane.showMessageDialog(null, "La variable LEUCOCITOS no tiene definido un valor mínimo y/o máximo.", "SIET", JOptionPane.ERROR_MESSAGE);
                                } else {
                                    final double resultadoConvertido = Double.parseDouble(resultado.toString());
                                    final int valorMinimo = Integer.valueOf(valorMinimoAux.toString());
                                    final int valorMaximo = Integer.valueOf(valorMaximoAux.toString());
                                    if (resultadoConvertido < valorMinimo || resultadoConvertido > valorMaximo) {
                                        JOptionPane.showMessageDialog(null, "El resultado de LEUCOCITOS no puede ser menor a: " + valorMinimo + ", ni mayor a: " + valorMaximo, "SIET", JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        resultadoVariable.setResultadoVariable(resultado.toString());
                                        resultadosVariables.set(rowIndex, resultadoVariable);
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "El valor de Leucocitos debe ser un número.", "SIET", JOptionPane.ERROR_MESSAGE);
                            }
                            break;

                        case "MIELOCITOS FLR":
                            if (leucocitosAux == null) {
                                JOptionPane.showMessageDialog(null, "No se pudo encontrar la variable o el valor de la variable leucocitos.", "SIET", JOptionPane.ERROR_MESSAGE);
                            } else if (NumberUtils.isParsable(String.valueOf(resultado))) {
                                final Object valorMinimoAux = resultadoVariable.getVariableExamen().getVariableValorMinimo();
                                final Object valorMaximoAux = resultadoVariable.getVariableExamen().getVariableValorMaximo();
                                if (valorMinimoAux == null || valorMaximoAux == null) {
                                    JOptionPane.showMessageDialog(null, "La variable MIELOCITOS FLR no tiene definido un valor mínimo y/o máximo.", "SIET", JOptionPane.ERROR_MESSAGE);
                                } else {
                                    final double resultadoConvertido = Double.parseDouble(resultado.toString());
                                    final int valorMinimo = Integer.valueOf(valorMinimoAux.toString());
                                    final int valorMaximo = Integer.valueOf(valorMaximoAux.toString());
                                    if (resultadoConvertido < valorMinimo || resultadoConvertido > valorMaximo) {
                                        JOptionPane.showMessageDialog(null, "El resultado de MIELOCITOS FLR no puede ser menor a: " + valorMinimo + ", ni mayor a: " + valorMaximo, "SIET", JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        final int rowPositionMielocitosFLA = getRowPosition("MIELOCITOS FLA");
                                        if (rowPositionMielocitosFLA == -1) {
                                            JOptionPane.showMessageDialog(null, "No se pudo encontrar la variable MIELOCITOS FLA.", "SIET", JOptionPane.ERROR_MESSAGE);
                                        } else {
                                            final int rowIndexParameterPorcentaje = getRowPosition("PORCENTAJE");
                                            if (rowIndexParameterPorcentaje == -1) {
                                                JOptionPane.showMessageDialog(null, "No se pudo encontrar la variable PORCENTAJE.", "SIET", JOptionPane.ERROR_MESSAGE);
                                            } else {
                                                resultadoVariable.setResultadoVariable(resultado.toString());
                                                resultadosVariables.set(rowIndex, resultadoVariable);

                                                final double porcentaje = calcularPorcentaje();
                                                resultadosVariables.get(rowIndexParameterPorcentaje).setResultadoVariable(String.valueOf(porcentaje));

                                                final int leucocitos = (int) Double.parseDouble(leucocitosAux.toString());
                                                final double total = (leucocitos * Double.parseDouble(resultado.toString())) / 100;
                                                resultadosVariables.get(rowPositionMielocitosFLA).setResultadoVariable(String.valueOf(total));
                                            }
                                        }
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "El valor de MIELOCITOS FLR debe ser un número.", "SIET", JOptionPane.ERROR_MESSAGE);
                            }
                            break;

                        case "METAMIELOCITOS FLR":
                            if (leucocitosAux == null) {
                                JOptionPane.showMessageDialog(null, "No se pudo encontrar la variable o el valor de la variable leucocitos.", "SIET", JOptionPane.ERROR_MESSAGE);
                            } else if (NumberUtils.isParsable(String.valueOf(resultado))) {
                                final Object valorMinimoAux = resultadoVariable.getVariableExamen().getVariableValorMinimo();
                                final Object valorMaximoAux = resultadoVariable.getVariableExamen().getVariableValorMaximo();
                                if (valorMinimoAux == null || valorMaximoAux == null) {
                                    JOptionPane.showMessageDialog(null, "La variable METAMIELOCITOS FLR no tiene definido un valor mínimo y/o máximo.", "SIET", JOptionPane.ERROR_MESSAGE);
                                } else {
                                    final double resultadoConvertido = Double.parseDouble(resultado.toString());
                                    final int valorMinimo = Integer.valueOf(valorMinimoAux.toString());
                                    final int valorMaximo = Integer.valueOf(valorMaximoAux.toString());
                                    if (resultadoConvertido < valorMinimo || resultadoConvertido > valorMaximo) {
                                        JOptionPane.showMessageDialog(null, "El resultado de METAMIELOCITOS FLR no puede ser menor a: " + valorMinimo + ", ni mayor a: " + valorMaximo, "SIET", JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        final int rowPositionMetamielocitosFLA = getRowPosition("METAMIELOCITOS FLA");
                                        if (rowPositionMetamielocitosFLA == -1) {
                                            JOptionPane.showMessageDialog(null, "No se pudo encontrar la variable METAMIELOCITOS FLA.", "SIET", JOptionPane.ERROR_MESSAGE);
                                        } else {
                                            final int rowIndexParameterPorcentaje = getRowPosition("PORCENTAJE");
                                            if (rowIndexParameterPorcentaje == -1) {
                                                JOptionPane.showMessageDialog(null, "No se pudo encontrar la variable PORCENTAJE.", "SIET", JOptionPane.ERROR_MESSAGE);
                                            } else {
                                                resultadoVariable.setResultadoVariable(resultado.toString());
                                                resultadosVariables.set(rowIndex, resultadoVariable);

                                                final double porcentaje = calcularPorcentaje();
                                                resultadosVariables.get(rowIndexParameterPorcentaje).setResultadoVariable(String.valueOf(porcentaje));

                                                final int leucocitos = (int) Double.parseDouble(leucocitosAux.toString());
                                                final double total = (leucocitos * Double.parseDouble(resultado.toString())) / 100;
                                                resultadosVariables.get(rowPositionMetamielocitosFLA).setResultadoVariable(String.valueOf(total));
                                            }
                                        }
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "El valor de METAMIELOCITOS FLR debe ser un número.", "SIET", JOptionPane.ERROR_MESSAGE);
                            }
                            break;

                        case "CAYADOS FLR":
                            if (leucocitosAux == null) {
                                JOptionPane.showMessageDialog(null, "No se pudo encontrar la variable o el valor de la variable leucocitos.", "SIET", JOptionPane.ERROR_MESSAGE);
                            } else if (NumberUtils.isParsable(String.valueOf(resultado))) {
                                final Object valorMinimoAux = resultadoVariable.getVariableExamen().getVariableValorMinimo();
                                final Object valorMaximoAux = resultadoVariable.getVariableExamen().getVariableValorMaximo();
                                if (valorMinimoAux == null || valorMaximoAux == null) {
                                    JOptionPane.showMessageDialog(null, "La variable CAYADOS FLR no tiene definido un valor mínimo y/o máximo.", "SIET", JOptionPane.ERROR_MESSAGE);
                                } else {
                                    final double resultadoConvertido = Double.parseDouble(resultado.toString());
                                    final int valorMinimo = Integer.valueOf(valorMinimoAux.toString());
                                    final int valorMaximo = Integer.valueOf(valorMaximoAux.toString());
                                    if (resultadoConvertido < valorMinimo || resultadoConvertido > valorMaximo) {
                                        JOptionPane.showMessageDialog(null, "El resultado de CAYADOS FLR no puede ser menor a: " + valorMinimo + ", ni mayor a: " + valorMaximo, "SIET", JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        final int rowPositionCayadosFLA = getRowPosition("CAYADOS FLA");
                                        if (rowPositionCayadosFLA == -1) {
                                            JOptionPane.showMessageDialog(null, "No se pudo encontrar la variable CAYADOS FLA.", "SIET", JOptionPane.ERROR_MESSAGE);
                                        } else {
                                            final int rowIndexParameterPorcentaje = getRowPosition("PORCENTAJE");
                                            if (rowIndexParameterPorcentaje == -1) {
                                                JOptionPane.showMessageDialog(null, "No se pudo encontrar la variable PORCENTAJE.", "SIET", JOptionPane.ERROR_MESSAGE);
                                            } else {
                                                resultadoVariable.setResultadoVariable(resultado.toString());
                                                resultadosVariables.set(rowIndex, resultadoVariable);

                                                final double porcentaje = calcularPorcentaje();
                                                resultadosVariables.get(rowIndexParameterPorcentaje).setResultadoVariable(String.valueOf(porcentaje));

                                                final int leucocitos = (int) Double.parseDouble(leucocitosAux.toString());
                                                final double total = (leucocitos * Double.parseDouble(resultado.toString())) / 100;
                                                resultadosVariables.get(rowPositionCayadosFLA).setResultadoVariable(String.valueOf(total));
                                            }
                                        }
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "El valor de CAYADOS FLR debe ser un número.", "SIET", JOptionPane.ERROR_MESSAGE);
                            }
                            break;

                        case "SEGMENTADOS FLR":
                            if (leucocitosAux == null) {
                                JOptionPane.showMessageDialog(null, "No se pudo encontrar la variable o el valor de la variable leucocitos.", "SIET", JOptionPane.ERROR_MESSAGE);
                            } else if (NumberUtils.isParsable(String.valueOf(resultado))) {
                                final Object valorMinimoAux = resultadoVariable.getVariableExamen().getVariableValorMinimo();
                                final Object valorMaximoAux = resultadoVariable.getVariableExamen().getVariableValorMaximo();
                                if (valorMinimoAux == null || valorMaximoAux == null) {
                                    JOptionPane.showMessageDialog(null, "La variable SEGMENTADOS FLR no tiene definido un valor mínimo y/o máximo.", "SIET", JOptionPane.ERROR_MESSAGE);
                                } else {
                                    final double resultadoConvertido = Double.parseDouble(resultado.toString());
                                    final int valorMinimo = Integer.valueOf(valorMinimoAux.toString());
                                    final int valorMaximo = Integer.valueOf(valorMaximoAux.toString());
                                    if (resultadoConvertido < valorMinimo || resultadoConvertido > valorMaximo) {
                                        JOptionPane.showMessageDialog(null, "El resultado de SEGMENTADOS FLR no puede ser menor a: " + valorMinimo + ", ni mayor a: " + valorMaximo, "SIET", JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        final int rowPositionSegmentadosFLA = getRowPosition("SEGMENTADOS FLA");
                                        if (rowPositionSegmentadosFLA == -1) {
                                            JOptionPane.showMessageDialog(null, "No se pudo encontrar la variable SEGMENTADOS FLA.", "SIET", JOptionPane.ERROR_MESSAGE);
                                        } else {
                                            final int rowIndexParameterPorcentaje = getRowPosition("PORCENTAJE");
                                            if (rowIndexParameterPorcentaje == -1) {
                                                JOptionPane.showMessageDialog(null, "No se pudo encontrar la variable PORCENTAJE.", "SIET", JOptionPane.ERROR_MESSAGE);
                                            } else {
                                                resultadoVariable.setResultadoVariable(resultado.toString());
                                                resultadosVariables.set(rowIndex, resultadoVariable);

                                                final double porcentaje = calcularPorcentaje();
                                                resultadosVariables.get(rowIndexParameterPorcentaje).setResultadoVariable(String.valueOf(porcentaje));

                                                final int leucocitos = (int) Double.parseDouble(leucocitosAux.toString());
                                                final double total = (leucocitos * Double.parseDouble(resultado.toString())) / 100;
                                                resultadosVariables.get(rowPositionSegmentadosFLA).setResultadoVariable(String.valueOf(total));
                                            }
                                        }
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "El valor de SEGMENTADOS FLR debe ser un número.", "SIET", JOptionPane.ERROR_MESSAGE);
                            }
                            break;

                        case "LINFOCITOS FLR":
                            if (leucocitosAux == null) {
                                JOptionPane.showMessageDialog(null, "No se pudo encontrar la variable o el valor de la variable leucocitos.", "SIET", JOptionPane.ERROR_MESSAGE);
                            } else if (NumberUtils.isParsable(String.valueOf(resultado))) {
                                final Object valorMinimoAux = resultadoVariable.getVariableExamen().getVariableValorMinimo();
                                final Object valorMaximoAux = resultadoVariable.getVariableExamen().getVariableValorMaximo();
                                if (valorMinimoAux == null || valorMaximoAux == null) {
                                    JOptionPane.showMessageDialog(null, "La variable LINFOCITOS FLR no tiene definido un valor mínimo y/o máximo.", "SIET", JOptionPane.ERROR_MESSAGE);
                                } else {
                                    final double resultadoConvertido = Double.parseDouble(resultado.toString());
                                    final int valorMinimo = Integer.valueOf(valorMinimoAux.toString());
                                    final int valorMaximo = Integer.valueOf(valorMaximoAux.toString());
                                    if (resultadoConvertido < valorMinimo || resultadoConvertido > valorMaximo) {
                                        JOptionPane.showMessageDialog(null, "El resultado de LINFOCITOS FLR no puede ser menor a: " + valorMinimo + ", ni mayor a: " + valorMaximo, "SIET", JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        final int rowPositionLinfocitosFLA = getRowPosition("LINFOCITOS FLA");
                                        if (rowPositionLinfocitosFLA == -1) {
                                            JOptionPane.showMessageDialog(null, "No se pudo encontrar la variable LINFOCITOS FLA.", "SIET", JOptionPane.ERROR_MESSAGE);
                                        } else {
                                            final int rowIndexParameterPorcentaje = getRowPosition("PORCENTAJE");
                                            if (rowIndexParameterPorcentaje == -1) {
                                                JOptionPane.showMessageDialog(null, "No se pudo encontrar la variable PORCENTAJE.", "SIET", JOptionPane.ERROR_MESSAGE);
                                            } else {
                                                resultadoVariable.setResultadoVariable(resultado.toString());
                                                resultadosVariables.set(rowIndex, resultadoVariable);

                                                final double porcentaje = calcularPorcentaje();
                                                resultadosVariables.get(rowIndexParameterPorcentaje).setResultadoVariable(String.valueOf(porcentaje));

                                                final int leucocitos = (int) Double.parseDouble(leucocitosAux.toString());
                                                final double total = (leucocitos * Double.parseDouble(resultado.toString())) / 100;
                                                resultadosVariables.get(rowPositionLinfocitosFLA).setResultadoVariable(String.valueOf(total));
                                            }
                                        }
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "El valor de LINFOCITOS FLR debe ser un número.", "SIET", JOptionPane.ERROR_MESSAGE);
                            }
                            break;

                        case "MONOCITOS FLR":
                            if (leucocitosAux == null) {
                                JOptionPane.showMessageDialog(null, "No se pudo encontrar la variable o el valor de la variable leucocitos.", "SIET", JOptionPane.ERROR_MESSAGE);
                            } else if (NumberUtils.isParsable(String.valueOf(resultado))) {
                                final Object valorMinimoAux = resultadoVariable.getVariableExamen().getVariableValorMinimo();
                                final Object valorMaximoAux = resultadoVariable.getVariableExamen().getVariableValorMaximo();
                                if (valorMinimoAux == null || valorMaximoAux == null) {
                                    JOptionPane.showMessageDialog(null, "La variable MONOCITOS FLR no tiene definido un valor mínimo y/o máximo.", "SIET", JOptionPane.ERROR_MESSAGE);
                                } else {
                                    final double resultadoConvertido = Double.parseDouble(resultado.toString());
                                    final int valorMinimo = Integer.valueOf(valorMinimoAux.toString());
                                    final int valorMaximo = Integer.valueOf(valorMaximoAux.toString());
                                    if (resultadoConvertido < valorMinimo || resultadoConvertido > valorMaximo) {
                                        JOptionPane.showMessageDialog(null, "El resultado de MONOCITOS FLR no puede ser menor a: " + valorMinimo + ", ni mayor a: " + valorMaximo, "SIET", JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        final int rowPositionMonocitosFLA = getRowPosition("MONOCITOS FLA");
                                        if (rowPositionMonocitosFLA == -1) {
                                            JOptionPane.showMessageDialog(null, "No se pudo encontrar la variable MONOCITOS FLA.", "SIET", JOptionPane.ERROR_MESSAGE);
                                        } else {
                                            final int rowIndexParameterPorcentaje = getRowPosition("PORCENTAJE");
                                            if (rowIndexParameterPorcentaje == -1) {
                                                JOptionPane.showMessageDialog(null, "No se pudo encontrar la variable PORCENTAJE.", "SIET", JOptionPane.ERROR_MESSAGE);
                                            } else {
                                                resultadoVariable.setResultadoVariable(resultado.toString());
                                                resultadosVariables.set(rowIndex, resultadoVariable);

                                                final double porcentaje = calcularPorcentaje();
                                                resultadosVariables.get(rowIndexParameterPorcentaje).setResultadoVariable(String.valueOf(porcentaje));

                                                final int leucocitos = (int) Double.parseDouble(leucocitosAux.toString());
                                                final double total = (leucocitos * Double.parseDouble(resultado.toString())) / 100;
                                                resultadosVariables.get(rowPositionMonocitosFLA).setResultadoVariable(String.valueOf(total));
                                            }
                                        }
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "El valor de MONOCITOS FLR debe ser un número.", "SIET", JOptionPane.ERROR_MESSAGE);
                            }
                            break;

                        case "BASOFILOS FLR":
                            if (leucocitosAux == null) {
                                JOptionPane.showMessageDialog(null, "No se pudo encontrar la variable o el valor de la variable leucocitos.", "SIET", JOptionPane.ERROR_MESSAGE);
                            } else if (NumberUtils.isParsable(String.valueOf(resultado))) {
                                final Object valorMinimoAux = resultadoVariable.getVariableExamen().getVariableValorMinimo();
                                final Object valorMaximoAux = resultadoVariable.getVariableExamen().getVariableValorMaximo();
                                if (valorMinimoAux == null || valorMaximoAux == null) {
                                    JOptionPane.showMessageDialog(null, "La variable BASOFILOS FLR no tiene definido un valor mínimo y/o máximo.", "SIET", JOptionPane.ERROR_MESSAGE);
                                } else {
                                    final double resultadoConvertido = Double.parseDouble(resultado.toString());
                                    final int valorMinimo = Integer.valueOf(valorMinimoAux.toString());
                                    final int valorMaximo = Integer.valueOf(valorMaximoAux.toString());
                                    if (resultadoConvertido < valorMinimo || resultadoConvertido > valorMaximo) {
                                        JOptionPane.showMessageDialog(null, "El resultado de BASOFILOS FLR no puede ser menor a: " + valorMinimo + ", ni mayor a: " + valorMaximo, "SIET", JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        final int rowPositionBasofilosFLA = getRowPosition("BASOFILOS FLA");
                                        if (rowPositionBasofilosFLA == -1) {
                                            JOptionPane.showMessageDialog(null, "No se pudo encontrar la variable BASOFILOS FLA.", "SIET", JOptionPane.ERROR_MESSAGE);
                                        } else {
                                            final int rowIndexParameterPorcentaje = getRowPosition("PORCENTAJE");
                                            if (rowIndexParameterPorcentaje == -1) {
                                                JOptionPane.showMessageDialog(null, "No se pudo encontrar la variable PORCENTAJE.", "SIET", JOptionPane.ERROR_MESSAGE);
                                            } else {
                                                resultadoVariable.setResultadoVariable(resultado.toString());
                                                resultadosVariables.set(rowIndex, resultadoVariable);

                                                final double porcentaje = calcularPorcentaje();
                                                resultadosVariables.get(rowIndexParameterPorcentaje).setResultadoVariable(String.valueOf(porcentaje));

                                                final int leucocitos = (int) Double.parseDouble(leucocitosAux.toString());
                                                final double total = (leucocitos * Double.parseDouble(resultado.toString())) / 100;
                                                resultadosVariables.get(rowPositionBasofilosFLA).setResultadoVariable(String.valueOf(total));
                                            }
                                        }
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "El valor de BASOFILOS FLR debe ser un número.", "SIET", JOptionPane.ERROR_MESSAGE);
                            }
                            break;

                        case "EOSINOFILOS FLR":
                            if (leucocitosAux == null) {
                                JOptionPane.showMessageDialog(null, "No se pudo encontrar la variable o el valor de la variable leucocitos.", "SIET", JOptionPane.ERROR_MESSAGE);
                            } else if (NumberUtils.isParsable(String.valueOf(resultado))) {
                                final Object valorMinimoAux = resultadoVariable.getVariableExamen().getVariableValorMinimo();
                                final Object valorMaximoAux = resultadoVariable.getVariableExamen().getVariableValorMaximo();
                                if (valorMinimoAux == null || valorMaximoAux == null) {
                                    JOptionPane.showMessageDialog(null, "La variable EOSINOFILOS FLR no tiene definido un valor mínimo y/o máximo.", "SIET", JOptionPane.ERROR_MESSAGE);
                                } else {
                                    final double resultadoConvertido = Double.parseDouble(resultado.toString());
                                    final int valorMinimo = Integer.valueOf(valorMinimoAux.toString());
                                    final int valorMaximo = Integer.valueOf(valorMaximoAux.toString());
                                    if (resultadoConvertido < valorMinimo || resultadoConvertido > valorMaximo) {
                                        JOptionPane.showMessageDialog(null, "El resultado de EOSINOFILOS FLR no puede ser menor a: " + valorMinimo + ", ni mayor a: " + valorMaximo, "SIET", JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        final int rowPositionEosinofilosFLA = getRowPosition("EOSINOFILOS FLA");
                                        if (rowPositionEosinofilosFLA == -1) {
                                            JOptionPane.showMessageDialog(null, "No se pudo encontrar la variable EOSINOFILOS FLA.", "SIET", JOptionPane.ERROR_MESSAGE);
                                        } else {
                                            final int rowIndexParameterPorcentaje = getRowPosition("PORCENTAJE");
                                            if (rowIndexParameterPorcentaje == -1) {
                                                JOptionPane.showMessageDialog(null, "No se pudo encontrar la variable PORCENTAJE.", "SIET", JOptionPane.ERROR_MESSAGE);
                                            } else {
                                                resultadoVariable.setResultadoVariable(resultado.toString());
                                                resultadosVariables.set(rowIndex, resultadoVariable);

                                                final double porcentaje = calcularPorcentaje();
                                                resultadosVariables.get(rowIndexParameterPorcentaje).setResultadoVariable(String.valueOf(porcentaje));

                                                final int leucocitos = (int) Double.parseDouble(leucocitosAux.toString());
                                                final double total = (leucocitos * Double.parseDouble(resultado.toString())) / 100;
                                                resultadosVariables.get(rowPositionEosinofilosFLA).setResultadoVariable(String.valueOf(total));
                                            }
                                        }
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "El valor de EOSINOFILOS FLR debe ser un número.", "SIET", JOptionPane.ERROR_MESSAGE);
                            }
                            break;

                        case "GRUPO SANGUINEO Y FACTOR RH":
                            switch (String.valueOf(resultado)) {
                                case "1":
                                case "'O' POSITIVO": {
                                    resultadosVariables.get(rowIndex).setResultadoVariable("'O' POSITIVO");
                                }
                                break;

                                case "2":
                                case "'O' NEGATIVO": {
                                    resultadosVariables.get(rowIndex).setResultadoVariable("'O' NEGATIVO");
                                }
                                break;

                                case "3":
                                case "'A' POSITIVO": {
                                    resultadosVariables.get(rowIndex).setResultadoVariable("'A' POSITIVO");
                                }
                                break;

                                case "4":
                                case "'A' NEGATIVO": {
                                    resultadosVariables.get(rowIndex).setResultadoVariable("'A' NEGATIVO");
                                }
                                break;

                                case "5":
                                case "'B' POSITIVO": {
                                    resultadosVariables.get(rowIndex).setResultadoVariable("'B' POSITIVO");
                                }
                                break;

                                case "6":
                                case "'B' NEGATIVO": {
                                    resultadosVariables.get(rowIndex).setResultadoVariable("'B' NEGATIVO");
                                }
                                break;

                                case "7":
                                case "'AB' POSITIVO": {
                                    resultadosVariables.get(rowIndex).setResultadoVariable("'AB' POSITIVO");
                                }
                                break;

                                case "8":
                                case "'AB' NEGATIVO": {
                                    resultadosVariables.get(rowIndex).setResultadoVariable("'AB' NEGATIVO");
                                }
                                break;

                                default:
                                    resultadosVariables.get(rowIndex).setResultadoVariable("");
                                    break;

                            }
                            break;

                        case "GOTA GRUESA":
                        case "MICROMETODO CHAGAS": {
                            switch (String.valueOf(resultado)) {
                                case "1":
                                case "POSITIVO": {
                                    resultadosVariables.get(rowIndex).setResultadoVariable("POSITIVO");
                                }
                                break;

                                case "2":
                                case "NEGATIVO": {
                                    resultadosVariables.get(rowIndex).setResultadoVariable("NEGATIVO");
                                }
                                break;

                                default:
                                    resultadosVariables.get(rowIndex).setResultadoVariable("");
                                    break;
                            }
                        }
                        break;

                        default:
                            if (resultadoVariable.getVariableExamen().getVariableTipoVariable().equals("TEXTO")) {
                                resultadosVariables.get(rowIndex).setResultadoVariable(resultado.toString());
                            } else if (resultadoVariable.getVariableExamen().getVariableTipoVariable().equals("NUMERICO")) {
                                if (NumberUtils.isParsable(resultado.toString())) {
                                    final Object valorMinimoAux = resultadoVariable.getVariableExamen().getVariableValorMinimo();
                                    final Object valorMaximoAux = resultadoVariable.getVariableExamen().getVariableValorMaximo();
                                    if (valorMinimoAux == null || valorMaximoAux == null) {
                                        JOptionPane.showMessageDialog(null, "La variable: " + resultadoVariable.getVariableExamen().getVariableExamenNombre() + " no tiene definido un valor mínimo y/o máximo.", "SIET", JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        final double resultadoConvertido = Double.parseDouble(resultado.toString());
                                        final int valorMinimo = Integer.valueOf(valorMinimoAux.toString());
                                        final int valorMaximo = Integer.valueOf(valorMaximoAux.toString());
                                        if (resultadoConvertido < valorMinimo || resultadoConvertido > valorMaximo) {
                                            JOptionPane.showMessageDialog(null, "El resultado de la variable: " + resultadoVariable.getVariableExamen().getVariableExamenNombre() + " no puede ser menor a: " + valorMinimo + ", ni mayor a: " + valorMaximo, "SIET", JOptionPane.ERROR_MESSAGE);
                                        } else {
                                            resultadosVariables.get(rowIndex).setResultadoVariable(resultado.toString());
                                        }
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "El resultado de la variable: " + resultadoVariable.getVariableExamen().getVariableExamenNombre() + " debe ser un número.", "SIET", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            break;
                    }
                }
                break;

                case "HAI ELISA CHAGAS":
                case "HAI CHAGAS": {
                    switch (String.valueOf(getValueAt(rowIndex, columnIndex - 1))) {
                        case "HAI":
                            switch (String.valueOf(resultado)) {
                                case "N":
                                case "n":
                                case "NEGATIVO": {
                                    resultadosVariables.get(rowIndex).setResultadoVariable("NEGATIVO");
                                }
                                break;

                                case "1":
                                case "1/16 dils": {
                                    resultadosVariables.get(rowIndex).setResultadoVariable("1/16 dils");
                                }
                                break;

                                case "2":
                                case "1/32 dils": {
                                    resultadosVariables.get(rowIndex).setResultadoVariable("1/32 dils");
                                }
                                break;

                                case "3":
                                case "1/64 dils": {
                                    resultadosVariables.get(rowIndex).setResultadoVariable("1/64 dils");
                                }
                                break;

                                case "4":
                                case "1/128 dils": {
                                    resultadosVariables.get(rowIndex).setResultadoVariable("1/128 dils");
                                }
                                break;

                                case "5":
                                case "1/256 dils": {
                                    resultadosVariables.get(rowIndex).setResultadoVariable("1/256 dils");
                                }
                                break;

                                case "6":
                                case "1/512 dils": {
                                    resultadosVariables.get(rowIndex).setResultadoVariable("1/512 dils");
                                }
                                break;

                                case "7":
                                case "1/1024 dils": {
                                    resultadosVariables.get(rowIndex).setResultadoVariable("1/1024 dils");
                                }
                                    break;

                                case "8":
                                case "1/2048 dils": {
                                    resultadosVariables.get(rowIndex).setResultadoVariable("1/2048 dils");
                                }
                                break;

                                default:
                                    resultadosVariables.get(rowIndex).setResultadoVariable("");
                                    break;
                            }
                            break;

                        default:
                            resultadosVariables.get(rowIndex).setResultadoVariable(resultado.toString());
                            break;
                    }
                }
                break;

                default:
                    if (resultadoVariable.getVariableExamen().getVariableTipoVariable().equals("TEXTO")) {
                        resultadosVariables.get(rowIndex).setResultadoVariable(resultado.toString());
                    } else if (resultadoVariable.getVariableExamen().getVariableTipoVariable().equals("NUMERICO")) {
                        if (NumberUtils.isParsable(resultado.toString())) {
                            final Object valorMinimoAux = resultadoVariable.getVariableExamen().getVariableValorMinimo();
                            final Object valorMaximoAux = resultadoVariable.getVariableExamen().getVariableValorMaximo();
                            if (valorMinimoAux == null || valorMaximoAux == null) {
                                JOptionPane.showMessageDialog(null, "La variable: " + resultadoVariable.getVariableExamen().getVariableExamenNombre() + " no tiene definido un valor mínimo y/o máximo.", "SIET", JOptionPane.ERROR_MESSAGE);
                            } else {
                                final double resultadoConvertido = Double.parseDouble(resultado.toString());
                                final int valorMinimo = Integer.valueOf(valorMinimoAux.toString());
                                final int valorMaximo = Integer.valueOf(valorMaximoAux.toString());
                                if (resultadoConvertido < valorMinimo || resultadoConvertido > valorMaximo) {
                                    JOptionPane.showMessageDialog(null, "El resultado de la variable: " + resultadoVariable.getVariableExamen().getVariableExamenNombre() + " no puede ser menor a: " + valorMinimo + ", ni mayor a: " + valorMaximo, "SIET", JOptionPane.ERROR_MESSAGE);
                                } else {
                                    resultadosVariables.get(rowIndex).setResultadoVariable(resultado.toString());
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El resultado de la variable: " + resultadoVariable.getVariableExamen().getVariableExamenNombre() + " debe ser un número.", "SIET", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
            }
        }
        fireTableDataChanged();
    }
    
    @Override
    public boolean isCellEditable(final int rowIndex, final int columnIndex) {
        if (isEditable) {
            if (columnIndex == 2) {
                if (getResultadoVariable(rowIndex).getVariableExamen().getGrupoVariables().getExamen().getExamenNombre().equals("EXAMEN GENERAL DE ORINA")) {
                    switch (String.valueOf(getValueAt(rowIndex, columnIndex - 1))) {
                        case "FORMULA LEUCOCITARIA RELATIVA":
                        case "FORMULA LEUCOCITARIA ABSOLUTA":
                        case "HEMOGLOBINA":
                        case "PORCENTAJE":
                        case "MIELOCITOS FLA":
                        case "METAMIELOCITOS FLA":
                        case "CAYADOS FLA":
                        case "SEGMENTADOS FLA":
                        case "LINFOCITOS FLA":
                        case "MONOCITOS FLA":
                        case "BASOFILOS FLA":
                        case "EOSINOFILOS FLA": {
                            return false;
                        }

                        default:
                            return true;
                    }
                } else {
                    switch (String.valueOf(getValueAt(rowIndex, columnIndex - 1))) {
                        case "FORMULA LEUCOCITARIA RELATIVA":
                        case "FORMULA LEUCOCITARIA ABSOLUTA":
                        case "HEMATIES":
                        case "HEMOGLOBINA":
                        case "PORCENTAJE":
                        case "MIELOCITOS FLA":
                        case "METAMIELOCITOS FLA":
                        case "CAYADOS FLA":
                        case "SEGMENTADOS FLA":
                        case "LINFOCITOS FLA":
                        case "MONOCITOS FLA":
                        case "BASOFILOS FLA":
                        case "EOSINOFILOS FLA": {
                            return false;
                        }

                        default:
                            return true;
                    }
                }
            } else {
                return false;
            }
        }
        return false;
    }
    
    public ResultadoVariable getResultadoVariable(final int rowIndex) {
        return resultadosVariables.get(rowIndex);
    }
}