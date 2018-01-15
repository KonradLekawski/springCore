package com.codecool.scc.services;

import org.springframework.stereotype.Component;

@Component
public class InspectFileService {

    public boolean checkIsCsvFormat(String filePath) {

        if (filePath.contains("/")) {

            String[] path = filePath.split("/");
            String fileName = path[path.length - 1];

            return checkIsFileNameProper(fileName);
        }
        return checkIsFileNameProper(filePath);
    }

    private boolean checkIsFileNameProper(String name) {

        String[] splitedName = name.split("\\.");

        if(splitedName.length == 2) {

            int prefixLen = splitedName[0].length();
            String sufix = splitedName[1];

            if(prefixLen > 0 && sufix.toLowerCase().equals("csv")) {
                return true;
            }
        }
        return false;
    }
}
