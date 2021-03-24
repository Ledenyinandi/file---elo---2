package com.codecool.chessopen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ChessResults {

    public List<String> getCompetitorsNamesFromFile(String fileName){
        return new ArrayList<>(sortMap(readFile(fileName)).keySet());
    }

    public Map<String, Integer> readFile(String fileName) {
        Map<String, Integer> results = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String[] inputFromFile;
            int points;
            String line;
            while ((line = br.readLine()) != null) {
                inputFromFile = line.split(",");
                points = Integer.parseInt(inputFromFile[1]) + Integer.parseInt(inputFromFile[2]) +
                        Integer.parseInt(inputFromFile[3]) + Integer.parseInt(inputFromFile[4]) +
                        Integer.parseInt(inputFromFile[5]);
                results.put(inputFromFile[0], points);
            }
        } catch (IOException e) {
            System.out.println("File not found!");
        }
        return results;
    }

    public Map<String, Integer> sortMap(Map<String, Integer> mapToSort) {
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        mapToSort.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        return sortedMap;
    }
}
