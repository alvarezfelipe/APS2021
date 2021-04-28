
package com.mycompany.aps;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TableConsultas extends AbstractTableModel{
    
    private ArrayList<Model> linhas;
    String[] coluna;
    
    public TableConsultas(ArrayList<Model> linha, String[] coluna){
        linhas = linha;
        this.coluna = coluna;
    }    
    
    //Apresenta o numero de linhas
    @Override
    public int getRowCount() {
        return linhas.size();
    }
    
    //Conta qtde de colunas
    @Override
    public int getColumnCount() {
        return coluna.length;
    }

    @Override
    public String getColumnName(int colunaIndice){
        return coluna[colunaIndice];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Model dados = (Model) linhas.get(rowIndex);
        
        switch (columnIndex){
            case 0:
                return dados.getEspecie();
            case 1:
                return dados.getNomeComum();
            case 2:
                return dados.getFaunaFlora();
            case 3:
                return dados.getGrupo();
            case 4:
                return dados.getFamilia();
            case 5:
                return dados.getCatAmeaca();
            case 6:
                return dados.getSiglaCatAmeaca();
            default:
                return null;
        }
    }
    
    public void addLista(ArrayList<Model> dados) {
        int listaAntiga = getRowCount();

        //Adiciona linas 
        linhas.addAll(dados);

        //Aqui reportamos a mudança para o JTable, assim ele pode se redesenhar, para visualizarmos a alteração
        fireTableRowsInserted(listaAntiga, getRowCount() - 1);
    }
    
}
