package org.sharipov;

import org.sharipov.controller.MainController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        //adminjon
        //1234
//        MainController mainController = new MainController();
//        mainController.start();

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        MainController controller = context.getBean("mainController", MainController.class);
        controller.start();

    }
}