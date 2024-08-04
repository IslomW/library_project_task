package org.sharipov.controller;


import org.sharipov.container.ComponentContainer;
import org.sharipov.dto.Category;
import org.sharipov.service.CategoryService;
import org.sharipov.service.ScannerService;
import org.sharipov.util.ScannerUtil;

public class CategoryController {

    private CategoryService categoryService;
    private ScannerService scannerService;
    private ScannerUtil scannerUtil;

    public void start() {
        boolean loop = true;
        while (loop) {
            showMenu();
            int action = scannerUtil.getAction();
            switch (action) {
                case 1:
                    categoryService.list();
                    break;
                case 2:
                    deleteCategory();
                    break;
                case 3:
                    addCategory();
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
        System.out.println("*** Category ***");
        System.out.println("1. Category list");
        System.out.println("2. Delete category");
        System.out.println("3. Add category");
        System.out.println("0. Exit");
    }

    public void addCategory() {
        System.out.print("Enter name: ");
        String name = scannerService.getScannerText().next();
        //
        Category category = new Category();
        category.setName(name);

       categoryService.create(category);
    }

    public void deleteCategory() {
        System.out.print("Enter id: ");
        Integer id = scannerService.getScannerNumber().nextInt();

        categoryService.delete(id);
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
}
