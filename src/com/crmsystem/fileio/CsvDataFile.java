package com.crmsystem.fileio;

import com.crmsystem.models.Client;
import com.opencsv.CSVReader;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVFormat;

import com.opencsv.exceptions.CsvException;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class CsvDataFile implements CustomFileWriter, CustomFileReader {
    private String filePath;

    public CsvDataFile(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Map<Integer, Client> readData() {
        Map<Integer, Client> clientMap = new HashMap<>();

        try (Reader reader = new FileReader(filePath);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader())) {

            for (CSVRecord csvRecord : csvParser) {
                int id = Integer.parseInt(csvRecord.get("ID"));
                String name = csvRecord.get("Name");
                String industry = csvRecord.get("Industry");
                String contactPerson = csvRecord.get("ContactPerson");
                double revenue = Double.parseDouble(csvRecord.get("Revenue"));

                Client client = new Client(id, name, industry, contactPerson, revenue);
                clientMap.put(id, client);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return clientMap;
    }

    @Override
    public void writeData(Map<Integer, Client> clientMap) {
        try (CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(filePath), CSVFormat.DEFAULT
                .withHeader("ID", "Name", "Industry", "ContactPerson", "Revenue"))) {

            for (Client client : clientMap.values()) {
                csvPrinter.printRecord(
                        client.getId(),             // ID as int
                        client.getName(),
                        client.getIndustry(),
                        client.getContactPerson(),
                        client.getRevenue()          // Assuming client.getRevenue() returns a double
                );
            }

            System.out.println("Data written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
