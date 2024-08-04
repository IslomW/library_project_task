package org.sharipov.controller;


import org.sharipov.container.ComponentContainer;
import org.sharipov.enums.ProfileRole;
import org.sharipov.enums.ProfileStatus;
import org.sharipov.service.ProfileService;
import org.sharipov.service.ScannerService;
import org.sharipov.util.ScannerUtil;

import java.util.Scanner;

public class StudentProfileController {

    private ScannerService scannerService;
    private ProfileService profileService;
    private ScannerUtil scannerUtil;
    public void start() {
        boolean loop = true;
        while (loop) {
            showMenu();
            int action = scannerUtil.getAction();
            switch (action) {
                case 1:
                    profileService.studentList();
                    break;
                case 2:
                    search();
                    break;
                case 3:
                    blockStudent();
                    break;
                case 4:
                    activeStudent();
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
        System.out.println("*** Student ***");
        System.out.println("1. Student list");
        System.out.println("2. Search student");
        System.out.println("3. Block student");
        System.out.println("3. Activate student");
        System.out.println("4. Student by book");
        System.out.println("0. Exits");
    }


    public void search() {
        System.out.print("Enter query: ");
        String query = scannerService.getScannerText().next();
        profileService.search(query, ProfileRole.STUDENT);
    }

    public void blockStudent() {
        System.out.print("Enter id: ");
        Integer id = scannerService.getScannerNumber().nextInt();
        profileService.changeStudentStatus(id, ProfileStatus.BLOCK);
    }

    public void activeStudent() {
        System.out.print("Enter id: ");
        Integer id = scannerService.getScannerNumber().nextInt();
        profileService.changeStudentStatus(id, ProfileStatus.ACTIVE);
    }

    public void setScannerService(ScannerService scannerService) {
        this.scannerService = scannerService;
    }

    public void setProfileService(ProfileService profileService) {
        this.profileService = profileService;
    }

    public void setScannerUtil(ScannerUtil scannerUtil) {
        this.scannerUtil = scannerUtil;
    }
}
