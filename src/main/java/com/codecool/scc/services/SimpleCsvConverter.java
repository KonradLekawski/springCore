package com.codecool.scc.services;

import com.codecool.scc.exeptions.NotCsvException;
import com.codecool.scc.exeptions.WrongTypeException;
import com.codecool.scc.views.OutputFormatterFactory;
import com.codecool.scc.daos.FileReader;
import com.codecool.scc.views.OutputFormatter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class SimpleCsvConverter {

    private FileReader fileReader;
    private OutputFormatterFactory factory;
    private InspectFileService fileService;

    public SimpleCsvConverter(FileReader fileReader, OutputFormatterFactory factory, InspectFileService fileService) {
        this.factory = factory;
        this.fileReader = fileReader;
        this.fileService = fileService;
    }

    public void convert(String file, String outputFormat) throws WrongTypeException, NotCsvException, IOException {

        if (fileService.checkIsCsvFormat(file)) {
            List<String[]> data = fileReader.readData(file);
            OutputFormatter formatter = this.factory.createByFormat(outputFormat);
            formatter.printToConsole(data);
        } else {
            throw new NotCsvException("file is not in CSV format");
        }
    }
    public void convert(String  file) throws WrongTypeException, NotCsvException, IOException {

        if (fileService.checkIsCsvFormat(file)) {
            OutputFormatter formatter = this.factory.createByFormat("table");
            List<String[]> data = fileReader.readData(file);
            formatter.printToConsole(data);
        } else {
            throw new NotCsvException("file is not in CSV format");
        }
    }

    public void setFileReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public void setFactory(OutputFormatterFactory factory) {
        this.factory = factory;
    }

    public void setFileService(InspectFileService fileService) {
        this.fileService = fileService;
    }

}

