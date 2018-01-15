package com.codecool.scc;

import com.codecool.scc.controllers.ApplicationController;
import com.codecool.scc.exeptions.ArgsLenException;
import com.codecool.scc.exeptions.NotCsvException;
import com.codecool.scc.exeptions.WrongTypeException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class ConverterApplication {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationController appController = (ApplicationController) ctx.getBean("applicationController");

        try {
            appController.start(args);
        } catch (ArgsLenException e) {
            System.out.println("Length of args is not proper");
        } catch (WrongTypeException e) {
            System.out.println("Wrong type choosen");
        } catch (NotCsvException e) {
            System.out.println("File should be in CSV format");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
