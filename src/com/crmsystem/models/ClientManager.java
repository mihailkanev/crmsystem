package com.crmsystem.models;

import java.util.Scanner;

public class ClientManager implements Manager{
    private Service service;
    private Scanner scanner;

    public ClientManager(Service service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void performAction(String command) {

    }
}
