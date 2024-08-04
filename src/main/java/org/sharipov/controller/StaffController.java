package org.sharipov.controller;


import org.sharipov.container.ComponentContainer;
import org.sharipov.util.ScannerUtil;

import java.util.Scanner;

public class StaffController {
    private BookController bookController;
    private StudentProfileController studentProfileController;
    private ScannerUtil scannerUtil;
    public void start() {
        boolean loop = true;
        while (loop) {
            showMenu();
            int action = scannerUtil.getAction();
            switch (action) {
                case 1:
                    bookController.start();
                    break;
                case 2:
                    studentProfileController.start();
                    break;
                case 0:
                    loop = false;
                    break;
                default:
                    System.out.println("Mazgi bu hatoku.");
            }

        }

    }


    public void showMenu() {
        System.out.println("*** Menu ***");
        System.out.println("1. Book");
        System.out.println("2. Student");
        System.out.println("0. Exit");
    }

    public void setBookController(BookController bookController) {
        this.bookController = bookController;
    }

    public void setStudentProfileController(StudentProfileController studentProfileController) {
        this.studentProfileController = studentProfileController;
    }

    public void setScannerUtil(ScannerUtil scannerUtil) {
        this.scannerUtil = scannerUtil;
    }
}
