package com.codecool.scc.daos;

import com.opencsv.CSVReader;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.util.List;


@Component
public class FileReader {

    public List<String[]> readData(String file) throws IOException {
        CSVReader reader = new CSVReader(new java.io.FileReader(file));
        return reader.readAll();
    }

}

