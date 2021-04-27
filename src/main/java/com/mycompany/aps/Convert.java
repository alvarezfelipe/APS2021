package com.mycompany.aps;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.WriteResult;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.simpleflatmapper.csv.CsvParser;
import org.simpleflatmapper.lightningcsv.CsvReader;

public class Convert {

    public void CsvJson() {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String line;
        FileInputStream fis = null;

        try {
            ArrayList<String> lista = new ArrayList<>();
            url = new URL("http://dados.mma.gov.br/dataset/41a79b71-445f-4a6a-8c70-d46af991292a/resource/1f13b062-f3f6-4198-a4c5-3581548bebec/download/lista-de-especiesameacas-2020.csv");
            is = url.openStream();  // throws an IOException            
            br = new BufferedReader(new InputStreamReader(is));
            CsvReader csv = CsvParser.reader(br);

            JsonFactory jsonFactory = new JsonFactory();

            Iterator<String[]> iterator = csv.iterator();
            String[] headers = iterator.next();

            try (JsonGenerator jsonGenerator = jsonFactory.createGenerator(System.out)) {

                jsonGenerator.writeStartArray();

                while (iterator.hasNext()) {
                    jsonGenerator.writeStartObject();
                    String[] values = iterator.next();
                    int nbCells = Math.min(values.length, headers.length);
                    for (int i = 0; i < nbCells; i++) {
                        jsonGenerator.writeFieldName(headers[i]);
                        jsonGenerator.writeString(values[i]);
                    }
                    jsonGenerator.writeEndObject();
                }
                jsonGenerator.writeEndArray();                
            }

        } catch (IOException err) {
            System.out.println(err);
        }
    }

    public static void main(String[] args) {
        Convert conv = new Convert();
        conv.CsvJson();

    }
}
