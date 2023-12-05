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
            // handle other options...
            default:
                System.out.println("Invalid option");
        }
    }
}