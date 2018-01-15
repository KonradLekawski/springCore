package com.codecool.scc.daos;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
public class FileReader {

    public List<String[]> readData(String file) {
        List<String[]> table = new ArrayList<>();

        String fileContent = readLineByLine(file);

        String[] rows= fileContent.split("[\\r\\n]+");

        for (String row : rows) {
            table.add(row.split("\\s*,\\s*"));
        }

        return table;
    }

    private String readLineByLine(String file) {
        StringBuilder fileContent = new StringBuilder();

        try (Stream<String> stream = Files.lines( Paths.get(file), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> fileContent.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return fileContent.toString();
    }
}

