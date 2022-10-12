package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Persistence {
    private BufferedReader bufferedReader;
    private List<String> fileLine;

    public Persistence() throws FileNotFoundException {
        bufferedReader = new BufferedReader(new FileReader("persistence/Guia_CSV_298.csv"));
        fileLine = new ArrayList<>();
    }

    public String[] getFirstLine() throws IOException {
        String propertyName = bufferedReader.readLine();
        return propertyName.split(",");
    }

    public List<String> getChain() throws IOException {
        String chain;
        while ((chain = bufferedReader.readLine()) != null) {
            fileLine.add(chain);
        }
        fileLine = removeQuotes(fileLine);
        return fileLine;
    }

    public List<String> removeQuotes(List<String> listToRemove) {
        List<String> auxList = new ArrayList<>();
        for (String line : listToRemove) {
            char[] a = line.toCharArray();
            String b = "";
            for (char c : a) {
                if ((byte) c != 34) {
                    b += c;
                }
            }
            auxList.add(b);
        }
        return auxList;
    }

    public void closeData() throws IOException {
        bufferedReader.close();
    }
}
