package com.codecool.views;

import org.springframework.stereotype.Component;

@Component
public class OutputFormatterFactory {

    public OutputFormatter createByFormat(String outputFormat) {

        switch (FormatType.valueOf(outputFormat)) {

            case xml:
                return new XmlOutputFormatter();

            case json:
                return new JsonOutputFormatter();

            case table:
                return new TableOutputFormatter();
        }
        return null;
    }
}