package com.codecool;


import com.codecool.controllers.ApplicationController;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConverterApplication {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationController appController = (ApplicationController) ctx.getBean("applicationController");

        appController.start(args);
    }


}
