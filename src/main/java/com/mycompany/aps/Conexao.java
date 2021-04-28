package com.mycompany.aps;

import com.google.auth.oauth2.GoogleCredentials;
import javax.swing.JOptionPane;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    public static void IniciarConexao() {
        String dataBase = "https://aps2021especies-default-rtdb.firebaseio.com";
        FileInputStream refreshToken = null;

        try {
            refreshToken = new FileInputStream("serviceAccount.json");
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(refreshToken))
                    .setDatabaseUrl(dataBase)
                    .build();

            FirebaseApp.initializeApp(options);
            JOptionPane.showMessageDialog(null, "Conectado com sucesso");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                refreshToken.close();
            } catch (IOException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }
}
