package com.crmsystem.models;

import com.crmsystem.fileio.CustomFileReader;
import com.crmsystem.fileio.CustomFileWriter;

import java.util.Map;

public class ClientService implements Service {
    private Map<Integer, Client> clientList;
    private CustomFileReader fileReader;
    private CustomFileWriter fileWriter;

    public ClientService(CustomFileReader fileReader, CustomFileWriter fileWriter) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        this.clientList = fileReader.readData();
    }


    @Override
    public void addClient(Client client) {

    }

    @Override
    public void editClient(int clientId, Client updateClient) {

    }

    @Override
    public void removeClient(int clientId) {

    }

    @Override
    public Client getClientById(int clientId) {
        return null;
    }

    @Override
    public Map<Integer, Client> viewClients() {
        return null;
    }

    @Override
    public void saveAndExit() {

    }
}
