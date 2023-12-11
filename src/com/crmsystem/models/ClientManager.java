package com.crmsystem.models;

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
                    System.out.println("Enter ID:");
                    int clientToEdit = Integer.parseInt(scanner.nextLine().trim());
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
                    System.out.println("Enter ID:");
                    int clientToFindById = Integer.parseInt(scanner.nextLine().trim());
                    Client existingClientById = service.getClientById(clientToFindById);

                    if (existingClientById != null) {
                        service.searchClientById(clientToFindById);
                    } else {
                        System.out.println("No client with this ID");
                    }
                    break;
                case 5:
                    System.out.println("Enter Name:");
                    String clientToFindByName = scanner.nextLine().trim();
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
                    System.out.println("Enter user ID");
                    int removeId = Integer.parseInt(scanner.nextLine().trim());
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

        System.out.print("ID: ");
        int id = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Industry: ");
        String industry = scanner.nextLine();

        System.out.print("Contact Person: ");
        String contactPerson = scanner.nextLine();

        System.out.print("Revenue: ");
        double revenue = scanner.nextDouble();

        scanner.nextLine();

        return new Client(id, name, industry, contactPerson, revenue);
    }
}
