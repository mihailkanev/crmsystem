package com.crmsystem.ui;

import com.crmsystem.models.Client;
import com.crmsystem.models.Service;

import java.util.Scanner;

public class Ui {
    private Scanner scanner;

    public Ui(Scanner scanner) {
        this.scanner = scanner;
    }

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
}