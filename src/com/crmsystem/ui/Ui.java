package com.crmsystem.ui;

import com.crmsystem.models.ClientService;
import com.crmsystem.models.Service;

public class Ui {
    private Service clientService;

    public void displayOptions() {

        System.out.println("Choose menu option:");
        System.out.println("1. Add client");
        System.out.println("2. Edit client");
        System.out.println("3. View clients");
        System.out.println("4. Search by ID");
        System.out.println("5. Search by name");
        System.out.println("6. Remove by ID");
        System.out.println("7. Save and Exit");
    }

    public void handleUserInput(int option) {
        switch (option) {
            case 1:
                // Add client logic
                break;
            case 2:
                // Edit client logic
                break;
            case 3:
                // View clients logic
                clientService.viewClients();
                break;
            case 4:
                // Search by Id
                break;
            case 5:
                //Search by Name
                break;
            case 6:
                // Remove by id
                break;
            case 7:
                // save and exit
                break;
            default:
                System.out.println("Invalid option");
        }
    }
}