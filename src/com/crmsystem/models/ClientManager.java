package com.crmsystem.models;

import com.crmsystem.fileio.DataValidation;

import javax.xml.crypto.Data;
import java.util.Map;
import java.util.Scanner;

public class ClientManager implements Manager {
    private Service service;
    private Scanner scanner;

    public ClientManager(Service service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void performAction(String command) {
        try {
            int option = Integer.parseInt(command.trim());
            switch (option) {
                case 1:
                    Client client = gatherClientInformation();
                    service.addClient(client);
                    break;
                case 2:
                    int clientToEdit = DataValidation.getInt("Enter ID: ");
                    Client existingClient = service.getClientById(clientToEdit);

                    if (existingClient != null) {
                        System.out.println("Existing Client Details");
                        System.out.println(existingClient);

                        Client updatedClient = gatherClientInformation();
                        service.editClient(clientToEdit, updatedClient);

                        System.out.println("Updated successfully");
                    } else {
                        System.out.println("No client with this ID");
                    }
                    break;
                case 3:
                    service.viewClients();
                    break;
                case 4:
                    int clientToFindById = DataValidation.getInt("Enter ID: ");
                    Client existingClientById = service.getClientById(clientToFindById);

                    if (existingClientById != null) {
                        service.searchClientById(clientToFindById);
                    } else {
                        System.out.println("No client with this ID");
                    }
                    break;
                case 5:
                    String clientToFindByName = DataValidation.getString("Enter Name: ");
                    Map<String, Client> matchingClients = service.searchClientByName(clientToFindByName);

                    if (!matchingClients.isEmpty()) {
                        for (Client clientMatch : matchingClients.values()) {
                            System.out.println("ID: " + clientMatch.getId() + ", Name: " + clientMatch.getName() +
                                    ", Industry: " + clientMatch.getIndustry() + ", ContactPerson: " + clientMatch.getContactPerson()
                                    + ", Revenue: " + clientMatch.getRevenue());
                        }
                    } else {
                        System.out.println("No client with this Name");
                    }
                    break;
                case 6:
                    int removeId = DataValidation.getInt("Enter user ID: ");
                    if (removeId != 0) {
                        service.removeClient(removeId);
                    } else {
                        System.out.println("Invalid ID. Please enter a valid ID.");
                    }
                    break;
                case 7:
                    service.saveAndExit();
                    break;
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    private Client gatherClientInformation() {
        System.out.println("Enter client details:");

        int id = DataValidation.getInt("ID: ");

        String name = DataValidation.getString("Name: ");

        String industry = DataValidation.getString("Industry: ");

        String contactPerson = DataValidation.getString("Contact Person: ");

        double revenue = DataValidation.getDouble("Revenue");

        return new Client(id, name, industry, contactPerson, revenue);
    }
}
