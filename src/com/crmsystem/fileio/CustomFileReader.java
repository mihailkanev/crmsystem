package com.crmsystem.fileio;

import com.crmsystem.models.Client;

import java.util.Map;

public interface CustomFileReader {
   Map<Integer, Client> readData();

}
