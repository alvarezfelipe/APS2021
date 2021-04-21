package com.mycompany.aps;

import com.mycompany.aps.Janela;
import static com.mycompany.aps.Conexao.iniciarConexao;

public class Main {
    public static void main(String[] args) {
        iniciarConexao();
        
        new Janela().setVisible(true);
    }
}
