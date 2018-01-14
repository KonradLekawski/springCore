package com.codecool.controllers;

import com.codecool.services.InspectFileService;
import com.codecool.services.SimpleCsvConverter;
import org.springframework.stereotype.Component;

@Component()
public class ApplicationController {
    private InspectFileService inspectService;
    private SimpleCsvConverter csvConverter;


    public ApplicationController(InspectFileService inspectService, SimpleCsvConverter csvConverter) {
        this.inspectService = inspectService;
        this.csvConverter = csvConverter;
    }

    public void start(String[] args) {
        String file;

        if (args.length == 0) {
            System.out.println(" --- No input file defined ---");

        } else if (args.length == 1) {

            if (inspectService.checkIsCsvFormat(args[0])) {
                file = args[0];
                csvConverter.convert(file);

            }else {
                System.out.println("File type is not proper");
            }

        } else if (args.length == 2) {

            if (inspectService.checkIsCsvFormat(args[1])) {

                file = args[1];
                String formatType = args[0];

                csvConverter.convert(file, formatType);

            } else {
                System.out.println("File type is not proper");
            }
        }
    }

    public void setInspectService(InspectFileService inspectService) {
        this.inspectService = inspectService;
    }

    public void setCsvConverter(SimpleCsvConverter csvConverter) {
        this.csvConverter = csvConverter;
    }
}
