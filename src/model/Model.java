package model;

public class Model {

    private int modelNumber;
    private double commercialValue;
    private int idService;

    public Model(int modelNumber, double commercialValue, int idService) {
        this.modelNumber = modelNumber;
        this.commercialValue = commercialValue;
        this.idService = idService;
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

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }
}
