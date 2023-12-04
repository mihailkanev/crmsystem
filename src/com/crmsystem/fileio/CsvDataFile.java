package com.crmsystem.fileio;

import com.crmsystem.models.Client;

import java.util.Map;

public class CsvDataFile implements CustomFileWriter, CustomFileReader{
    private String filePath;
    public CsvDataFile(String filePath){
        this.filePath = filePath;
    }
    @Override
    public Map<Integer, Client> readData() {
        return null;
    }

    @Override
    public void writeData(Map<Integer, Client> clientMap) {

    }
}
