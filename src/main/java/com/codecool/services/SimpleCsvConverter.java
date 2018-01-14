package com.codecool.services;

import com.codecool.daos.FileReader;
import com.codecool.views.OutputFormatter;
import com.codecool.views.OutputFormatterFactory;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class SimpleCsvConverter {

    private FileReader fileReader;
    private OutputFormatterFactory factory;

    public SimpleCsvConverter(FileReader fileReader, OutputFormatterFactory factory) {
        this.factory = factory;
        this.fileReader = fileReader;
    }

    public void convert(String file, String outputFormat) {

        List<String[]> data = fileReader.readData(file);

        OutputFormatter formatter = this.factory.createByFormat(outputFormat);

        if(formatter != null) {
            formatter.printToConsole(data);
        } else {
            System.out.println("wrong format");
        }
    }

    public void convert(String  file) {

        OutputFormatter formatter = this.factory.createByFormat("table");

        List<String[]> data = fileReader.readData(file);
        formatter.printToConsole(data);
    }

    public void setFileReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public void setFactory(OutputFormatterFactory factory) {
        this.factory = factory;
    }

}

