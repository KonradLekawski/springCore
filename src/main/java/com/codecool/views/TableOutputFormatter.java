package com.codecool.views;


import java.util.List;

public class TableOutputFormatter implements OutputFormatter {

    @Override
    public void printToConsole(List<String[]> data) {

        int longestWordLen = countLongestWord(data);

        printHeader(data.get(0), longestWordLen);
        printContent(data, longestWordLen);

    }

    private void printHeader(String[] row, int longestWordLen) {

        for (String elem : row) {
            System.out.printf(elem + createSpaces(elem.length(),longestWordLen));
        }
        System.out.println();
    }

    private void printContent(List<String[]> data, int longestWordLen) {

        for (int i = 1; i < data.size(); i++) {
            System.out.println();
            for (String elem : data.get(i)) {
                System.out.printf(elem + createSpaces(elem.length(), longestWordLen));
            }
        }
        System.out.println("format table");
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
