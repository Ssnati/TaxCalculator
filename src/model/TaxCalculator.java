package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaxCalculator {
    private List<Mark> markList;
    private RankList rankList;

    public TaxCalculator() throws IOException {
        markList = new ArrayList<>();
        rankList = new RankList();
        loadData();
    }

    public void loadData() throws IOException{
        Persistence persistence = new Persistence();
        String[] firstLine = persistence.getFirstLine();
        List<String> objects = persistence.getChain();
        persistence.closeData();
        for (String data : objects) {
            String[] splits = (data.split(","));
            String mark = splits[1];
            String line = splits[5];

            String[] modelAndValue = locateModel(splits, firstLine);//Obtiene el modelo y su valor, si no es 0
            int idService = Integer.parseInt(splits[9]);
            for (String separator : modelAndValue) {
                String[] modelsWithValue = separator.split(",");
                int model = Integer.parseInt(modelsWithValue[0]);
                double value = Double.parseDouble(modelsWithValue[1]) * 1000;
                generateObject(mark, line, model, value, idService);
            }

        }
    }

    public String[] locateModel(String[] valuesList, String[] modelsList) {
        List<String> modelAndValue = new ArrayList<>();
        for (int i = 11; i < valuesList.length; i++) {
            if ((modelsList[i].matches("[0-9]+")) && (Integer.parseInt(valuesList[i]) != 0)) {
                modelAndValue.add(modelsList[i] + "," + valuesList[i]);
            }
        }

        return modelAndValue.toArray(new String[0]);
    }

    public void generateObject(String mark, String line, int model, double value, int idService) {
        searchMark(mark).searchLine(line).searchModel(model).setCommercialValue(value);
        searchMark(mark).searchLine(line).searchModel(model).setIdService(idService);
    }

    public String getMarkList() {
        String auxList = "";
        for (Mark mark : markList) {
            auxList += "\n-: " + mark.getMarkName();
        }
        return auxList;
    }

    public void addMark(Mark mark) {
        markList.add(mark);
    }

    public void modifyRank(String propertyName, String value) throws IOException {
        rankList.changeValue(propertyName, value);
    }

    public Mark searchMark(String markName) {
        Mark markAux = null;
        for (Mark mark : markList) {
            if (mark.getMarkName().equals(markName.toUpperCase())) {
                markAux = mark;
            }
        }
        if (markAux == null) {
            Mark newMark = new Mark(markName);
            markList.add(newMark);
            markAux = newMark;
        }
        return markAux;
    }

    public double getValue(String mark, String line, int model) {
        return searchMark(mark).searchLine(line).searchModel(model).getCommercialValue();
    }

    public double calculateTotalValue(String mark, int model, String line, int timely, int boyaca) {
        double initialValue = getValue(mark, line, model);
        initialValue = calculateTaxWithRank(initialValue);
        if (timely == 1) {
            initialValue = generateTimelyDiscount(initialValue);
        }
        if (isPublic(mark, line, model)) {
            initialValue = generatePublicDiscount(initialValue);
        }
        if (boyaca == 1) {
            initialValue = generateBoyacaDiscount(initialValue);
        }
        return initialValue;
    }

    public boolean isPublic(String mark, String line, int model) {
        return searchMark(mark).searchLine(line).searchModel(model).getIdService() == 2;
    }

    private double generateTimelyDiscount(double value) {
        return value - (value * (rankList.getTimelyPaymentDiscount() / 100));
    }

    private double generatePublicDiscount(double value) {
        return value - rankList.getPublicTransportDiscount();
    }

    private double generateBoyacaDiscount(double value) {
        return value - (value * (rankList.getRegisteredInBoyacaDiscount() / 100));
    }

    private double calculateTaxWithRank(double commercialValue) {
        double value;
        if (commercialValue > 0 && commercialValue <= rankList.getMinimunValue()) {
            value = commercialValue * (rankList.getFirsRankDiscount() / 100);
        } else if (commercialValue > rankList.getMinimunValue() && commercialValue <= rankList.getMaximunValue()) {
            value = commercialValue * (rankList.getSecondRankDiscount() / 100);
        } else {
            value = commercialValue * (rankList.getThirdRankDiscount() / 100);
        }
        return value;
    }

}
