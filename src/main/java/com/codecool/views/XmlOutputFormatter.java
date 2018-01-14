package com.codecool.views;


import java.util.List;

public class XmlOutputFormatter implements OutputFormatter {

    @Override
    public void printToConsole(List<String[]> data) {

        String[] values = data.get(0);

        for (int i = 1; i < data.size(); i++) {
            System.out.println("<line>");
            for (int j = 0; j < values.length; j++) {
                String value = "<" + values[j] + ">" + data.get(i)[j] + "</" + values[j] + ">";
                System.out.println("    " + value);
            }
            System.out.println("</line>");
        }
    }

}
