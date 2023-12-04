package com.crmsystem.models;

import java.util.Map;

public interface Service {
    void addClient(Client client);

    void editClient(int clientId, Client updateClient);

    void removeClient(int clientId);

    Client getClientById(int clientId);

    Map<Integer, Client> viewClients();

    void saveAndExit();
}
