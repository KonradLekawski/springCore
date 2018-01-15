package com.codecool.scc.views;


import java.util.List;

public class TableOutputFormatter implements OutputFormatter {

    @Override
    public void printToConsole(List<String[]> data) {

        int longestWordLen = countLongestWord(data);

        for (String[] row : data) {
            System.out.println();
            for (String elem : row) {
                System.out.printf(elem + createSpaces(elem.length(), longestWordLen));
            }
        }
    }


    private String createSpaces(int wordLen, int longestWordLen) {
        return new String(new char[longestWordLen - wordLen + 4]).replace('\0', ' ');
    }

    private int countLongestWord(List<String[]> data) {
        int longestWordLen = 0;

        for (String[] row : data) {
            for (String elem : row) {
                if (elem.length() > longestWordLen) longestWordLen = elem.length();
            }
        }
        return longestWordLen;
    }
}
