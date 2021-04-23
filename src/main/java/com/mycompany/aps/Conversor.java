package com.mycompany.aps;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import java.io.BufferedReader;
import java.io.FileReader;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Conversor {
    
    
    public void run() throws IOException, CsvException{
        String database = "D:\\Downloads\\lista-de-especies-ameacas-2020.csv";
        Reader reader = Files.newBufferedReader(Paths.get(database));
    }
    
}
