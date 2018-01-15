package com.codecool.scc.controllers;

import com.codecool.scc.exeptions.ArgsLenException;
import com.codecool.scc.exeptions.NotCsvException;
import com.codecool.scc.exeptions.WrongTypeException;
import com.codecool.scc.services.SimpleCsvConverter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component()
public class ApplicationController {
    private SimpleCsvConverter csvConverter;


    public ApplicationController(SimpleCsvConverter csvConverter) {
        this.csvConverter = csvConverter;
    }

    public void start(String[] args) throws WrongTypeException, NotCsvException, ArgsLenException, IOException {

        String file;

        switch (args.length) {

            case 1:
                file = args[0];
                csvConverter.convert(file);
                break;

            case 2:
                file = args[1];
                String formatType = args[0];
                csvConverter.convert(file, formatType);
                break;

            default:
                throw new ArgsLenException("Length of arguments is not proper");
        }
    }

    public void setCsvConverter(SimpleCsvConverter csvConverter) {
        this.csvConverter = csvConverter;
    }
}
