package model;

public class Model {

    private int modelNumber;
    private double commercialValue;

    public Model(int modelNumber, double commercialValue) {
        this.modelNumber = modelNumber;
        this.commercialValue = commercialValue;
    }

    public double getCommercialValue() {
        return commercialValue;
    }

    public int getModelNumber() {
        return modelNumber;
    }

    public void setCommercialValue(double commercialValue) {
        this.commercialValue = commercialValue;
    }
}
