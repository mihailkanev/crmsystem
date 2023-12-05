package com.crmsystem.fileio;

import com.crmsystem.models.Client;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CsvDataFile implements CustomFileWriter, CustomFileReader {
    private String filePath;

    public CsvDataFile(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Map<Integer, Client> readData() {
        Map<Integer, Client> clientMap = new HashMap<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();

            for (int i = 1; i < records.size(); i++) {
                String[] fields = records.get(i);

                int id = Integer.parseInt(fields[0].trim());
                String name = fields[1].trim();
                String industry = fields[2].trim();
                String contactPerson = fields[3].trim();
                double revenue = Double.parseDouble(fields[4].trim());

                Client client = new Client(id, name, industry, contactPerson, revenue);
                clientMap.put(id, client);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return clientMap;
    }

    @Override
    public void writeData(Map<Integer, Client> clientMap) {

    }
}
