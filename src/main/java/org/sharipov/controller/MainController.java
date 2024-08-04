package org.sharipov.controller;


import org.sharipov.container.ComponentContainer;
import org.sharipov.dto.Profile;
import org.sharipov.service.*;
import org.sharipov.util.ScannerUtil;

public class MainController {
    private InitService initService;
    private BookService bookService;
    private AuthService authService;
    private CategoryService categoryService;
    private ScannerService scannerService;
    private ScannerUtil scannerUtil;

    public void setInitService(InitService initService) {
        this.initService = initService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void setScannerService(ScannerService scannerService) {
        this.scannerService = scannerService;
    }

    public void setScannerUtil(ScannerUtil scannerUtil) {
        this.scannerUtil = scannerUtil;
    }

    // lesson finished
    public void start() {


        initService.initCreateFile();
        initService.initAdmin();
        initService.initTestStudent();

        boolean loop = true;
        while (loop) {
            showMenu();
            int action = scannerUtil.getAction();
            switch (action) {
                case 1:
                    bookService.all();//
                    break;
                case 2:
                    search();
                    break;
                case 3:
                    byCategory();
                    break;
                case 4:
                    login();
                    break;
                case 5:
                    registration();
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
        System.out.println("*** Main Menu ***");
        System.out.println("1. BookList");
        System.out.println("2. Search");
        System.out.println("3. By category");
        System.out.println("4. Login");
        System.out.println("5. Registration");
        System.out.println("0. Exit");
    }

    public void login() {
        System.out.print("Enter login: ");
        String login = scannerService.getScannerText().next();//

        System.out.print("scannerText password: ");
        String password = scannerService.getScannerText().next();//
        //
        authService.login(login, password); //
    }

    public void registration() {
        System.out.print("Enter name: ");
        String name = scannerService.getScannerText().next();

        System.out.print("Enter surname: ");
        String surname = scannerService.getScannerText().next();

        System.out.print("Enter phone: ");
        String phone = scannerService.getScannerText().next();

        System.out.print("Enter login: ");
        String login = scannerService.getScannerText().next();

        System.out.print("Enter password: ");
        String password = scannerService.getScannerText().next();

        Profile profile = new Profile();
        profile.setName(name.trim());
        profile.setSurname(surname.trim());
        profile.setPhone(phone.trim());

        profile.setLogin(login.trim()); // valish
        profile.setPassword(password.trim()); // 222

        authService.registration(profile);//
    }

    public void search() {
        System.out.print("Enter query:");
        String query = scannerService.getScannerText().next();
        bookService.search(query);//
    }

    public void byCategory() {
       categoryService.list();//
        System.out.print("Enter category id:");
        Integer categoryId = scannerService.getScannerNumber().nextInt();
        bookService.byCategoryId(categoryId);
    }


}
