package com.codecool.scc.views;

import java.util.List;

public class JsonOutputFormatter implements OutputFormatter {

    @Override
    public void printToConsole(List<String[]> data) {
        int valuesLen = data.get(0).length;

        for (String[] aData : data) {
            System.out.println("{");
            for (int j = 0; j < valuesLen; j++) {
                String value = '"' + "value" + j + ':' + '"' + ": " + '"' + aData[j] + '"';
                if (j == valuesLen - 1) {
                    System.out.println("    " + value);
                } else {
                    System.out.println("    " + value + ",");
                }
            }
            System.out.println("}");
        }
    }

}
