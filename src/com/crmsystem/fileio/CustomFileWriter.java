package com.crmsystem.fileio;

import com.crmsystem.models.Client;

import java.util.Map;

public interface CustomFileWriter {
    void writeData(Map<Integer, Client> clientMap);
}
