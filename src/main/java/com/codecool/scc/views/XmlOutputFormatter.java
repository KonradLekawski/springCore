package com.codecool.scc.views;


import java.util.List;

public class XmlOutputFormatter implements OutputFormatter {

    @Override
    public void printToConsole(List<String[]> data) {

        for (String[] row : data) {
            System.out.println("<line>");
            for (String elem : row) {
                String value = "<value>" + elem + "</value>";
                System.out.println("    " + value);
            }
            System.out.println("</line>");
        }
    }

}
