package com.crmsystem.models;

import com.crmsystem.fileio.CustomFileReader;
import com.crmsystem.fileio.CustomFileWriter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClientService implements Service {
    private Map<Integer, Client> clientList;
    private CustomFileReader fileReader;
    private CustomFileWriter fileWriter;
    private Scanner scanner;

    public ClientService(CustomFileReader fileReader, CustomFileWriter fileWriter) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        this.clientList = fileReader.readData();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void addClient(Client client) {
        clientList.put(client.getId(), client);
        fileWriter.writeData(clientList);
    }


    @Override
    public void editClient(int clientId, Client updateClient) {
        if (clientList.containsKey(clientId)) {
            clientList.remove(clientId);
            clientList.put(updateClient.getId(), updateClient);
            fileWriter.writeData(clientList);
        } else {
            System.out.println("No found ID");
        }
    }

    @Override
    public void removeClient(int clientId) {
        if (clientList.containsKey(clientId)) {
            clientList.remove(clientId);
            fileWriter.writeData(clientList);
            System.out.println("Client with ID " + clientId + " removed successfully.");
        } else {
            System.out.println("No client found with ID " + clientId);

        }
    }

    @Override
    public Client getClientById(int clientId) {
        return clientList.get(clientId);
    }

    @Override
    public Client getClientByName(String clientName) {
        return clientList.get(clientName);
    }

    @Override
    public Map<Integer, Client> viewClients() {
        if (clientList.isEmpty()) {
            System.out.println("the list is empty");
        } else {
            for (Client client : clientList.values()) {
                System.out.println("ID: " + client.getId() + ", Name: " + client.getName() +
                        ", Industry: " + client.getIndustry() + ", ContactPerson: " + client.getContactPerson()
                        + ", Revenue: " + client.getRevenue());
            }
        }
        return clientList;
    }

    @Override
    public Map<Integer, Client> searchClientById(int clientId) {
        if (clientList.isEmpty()) {
            System.out.println("The list is Empty");
        } else {
            for (Client client : clientList.values()) {
                if (client.getId() == clientId) {
                    System.out.println("ID: " + client.getId() + ", Name: " + client.getName() +
                            ", Industry: " + client.getIndustry() + ", ContactPerson: " + client.getContactPerson()
                            + ", Revenue: " + client.getRevenue());
                }
            }
        }
        return clientList;
    }

    @Override
    public Map<String, Client> searchClientByName(String name) {
        Map<String, Client> matchingClients = new HashMap<>();

        if (!clientList.isEmpty()) {
            for (Client client : clientList.values()) {
                if (client.getName().equals(name)) {
                    matchingClients.put(client.getName(), client);
                }
            }
        }
        return matchingClients;
    }


    @Override
    public void saveAndExit() {
        System.out.println("Saving data and exiting...");
        fileWriter.writeData(clientList);
        scanner.close();
        System.out.println("Data saved successfully. Exiting...");
        System.exit(0);
    }
}
