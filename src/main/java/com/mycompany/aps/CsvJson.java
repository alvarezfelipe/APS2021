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
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.simpleflatmapper.csv.CsvParser;
import org.simpleflatmapper.lightningcsv.CsvReader;

public class CsvJson {

    public CsvJson() {

    }

//    public CsvJson(boolean clear) throws MalformedURLException, CsvValidationException{
//        csvJson(clear);
//    }
    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private final DatabaseReference especiesRef = database.getReference().child("base");

    public void csvJson() throws MalformedURLException {
        URL url;        
        BufferedReader br;

        try {
//            url = new URL("http://dados.mma.gov.br/dataset/41a79b71-445f-4a6a-8c70-d46af991292a/resource/1f13b062-f3f6-4198-a4c5-3581548bebec/download/lista-de-especiesameacas-2020.csv");
//            is = url.openStream();  // throws an IOException            
//            br = new BufferedReader(new InputStreamReader(is));
//            CsvReader csv = CsvParser.reader(br);
//            CSVReader csvReader = new CSVReader(br);
//
//            JsonFactory jsonFactory = new JsonFactory();
//
//            Iterator<String[]> iterator = csv.iterator();
//            String[] headers = iterator.next();
//
//            try (JsonGenerator jsonGenerator = jsonFactory.createGenerator(System.out)) {
//
//                jsonGenerator.writeStartArray();
//
//                while (iterator.hasNext()) {
//                    jsonGenerator.writeStartObject();
//                    String[] values = iterator.next();
//                    int nbCells = Math.min(values.length, headers.length);
//                    for (int i = 0; i < nbCells; i++) {
//                        jsonGenerator.writeFieldName(headers[i]);
//                        jsonGenerator.writeString(values[i]);
//
//
//                    }
//                    jsonGenerator.writeEndObject();
//                }
//                jsonGenerator.writeEndArray();
//            }
            String site = "http://dados.mma.gov.br/dataset/41a79b71-445f-4a6a-8c70-d46af991292a/resource/1f13b062-f3f6-4198-a4c5-3581548bebec/download/lista-de-especies-ameacas-2020.csv";

            url = new URL(site);
            br = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));
            CSVReader csv = new CSVReader(br, ';');

            // Reading Records One by One in a String array
            String[] nextRecord;
            csv.readNext();

            int i = 0;
            Map<String, Model> base = new HashMap<>();
            while ((nextRecord = csv.readNext()) != null) {
                i++;

                Integer numero = new Integer(i);

                //Create the Object Espécies
                Model especie = new Model();

                especie.setFaunaFlora(nextRecord[0]);
                especie.setGrupo(nextRecord[1]);
                especie.setFamilia(nextRecord[2]);
                especie.setEspecie(nextRecord[3]);
                especie.setNomeComum(nextRecord[4]);
                especie.setCatAmeaca(nextRecord[5]);
                especie.setSiglaCatAmeaca(nextRecord[6]);
                especie.setBioma(nextRecord[7]);
                especie.setPrincAmeaca(nextRecord[8]);
                especie.setAreaProtegida(nextRecord[9]);
                especie.setPanConversacao(nextRecord[10]);
                especie.setOrdPesqueiro(nextRecord[11]);
                especie.setNivelProtecao(nextRecord[12]);
                especie.setEspecieExclusiva(nextRecord[13]);
                especie.setEstado(nextRecord[14]);

                base.put(numero.toString(), especie);

            }
            especiesRef.setValueAsync(base);
        } catch (IOException err) {
            //System.out.println(err);
        }
    }

}
