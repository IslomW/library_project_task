package org.sharipov.service;

import java.util.Scanner;

public class ScannerService {
//    public static Scanner scannerText = new Scanner(System.in);
//    public static Scanner scannerNumber = new Scanner(System.in);
    private Scanner scannerText;
    private Scanner scannerNumber;

    public ScannerService() {
        this.scannerNumber = new Scanner(System.in);
        this.scannerText = new Scanner(System.in);
    }

    public Scanner getScannerText() {
        return scannerText;
    }

    public Scanner getScannerNumber() {
        return scannerNumber;
    }

    public void setScannerNumber(Scanner scannerNumber) {
        this.scannerNumber = scannerNumber;
    }
}
