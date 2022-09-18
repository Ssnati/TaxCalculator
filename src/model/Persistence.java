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
    private String chain;

    public Persistence() throws FileNotFoundException {
        bufferedReader = new BufferedReader(new FileReader("persistence/Guia_CSV_298.csv"));
        fileLine = new ArrayList<>();
    }

    public String[] getFirstLine() throws IOException {
        String propertyName = bufferedReader.readLine();
        String[] firstLine = propertyName.split(",");
        return firstLine;
    }

    public List<String> getChain() throws IOException {
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
            for (int i = 0; i <a.length; i++) {
                if ((byte)a[i]!=34){
                    b+=a[i];
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
