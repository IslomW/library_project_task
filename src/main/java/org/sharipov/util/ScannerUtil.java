package org.sharipov.util;



import org.sharipov.container.ComponentContainer;
import org.sharipov.service.ScannerService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerUtil {
private ScannerService scannerService;
    public int getAction() {
        System.out.print("Enter action: ");
        try {
            return scannerService.getScannerNumber().nextInt();
        } catch (InputMismatchException e) {
            scannerService.setScannerNumber(new Scanner(System.in));
            System.out.println("\nPlease enter number.\n");
            return -1;
        }
    }

    public void setScannerService(ScannerService scannerService) {
        this.scannerService = scannerService;
    }
}
