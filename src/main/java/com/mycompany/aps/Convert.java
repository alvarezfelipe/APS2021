package com.mycompany.aps;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.opencsv.CSVReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import org.simpleflatmapper.csv.CsvParser;
import org.simpleflatmapper.lightningcsv.CsvReader;

public class Convert {

    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private final DatabaseReference especiesRef = database.getReference().child("especies");

    private void CsvJson() throws MalformedURLException {
        URL url;
        InputStream is = null;
        BufferedReader br;

        try {
            url = new URL("http://dados.mma.gov.br/dataset/41a79b71-445f-4a6a-8c70-d46af991292a/resource/1f13b062-f3f6-4198-a4c5-3581548bebec/download/lista-de-especiesameacas-2020.csv");
            is = url.openStream();  // throws an IOException            
            br = new BufferedReader(new InputStreamReader(is));
            CsvReader csv = CsvParser.reader(br);
            CSVReader csvReader = new CSVReader(br);

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
    
}
