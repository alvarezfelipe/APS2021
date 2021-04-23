package com.mycompany.aps;

import static com.mycompany.aps.Conexao.IniciarConexao;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        IniciarConexao();

        new Janela().setVisible(true);
    }
}
