package com.codecool.scc.views;

import com.codecool.scc.exeptions.WrongTypeException;
import org.springframework.stereotype.Component;

@Component
public class OutputFormatterFactory {

    public OutputFormatter createByFormat(String outputFormat) throws WrongTypeException  {

        switch (FormatType.valueOf(outputFormat)) {

            case xml:
                return new XmlOutputFormatter();

            case json:
                return new JsonOutputFormatter();

            case table:
                return new TableOutputFormatter();

            default:
                throw new WrongTypeException("Wrong type");
        }
    }
}