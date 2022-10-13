package model;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private String nameLine;
    private List<Model> modelList;

    public Line(String nameLine) {
        this.nameLine = nameLine;
        modelList = new ArrayList<>();
    }

    public List<String> getModelList() {
        List<String> modelListAux = new ArrayList<>();
        for (Model model : modelList) {
            modelListAux.add(model.getModelNumber()+"");
        }
        return modelListAux;
    }

    public String getNameLine() {
        return nameLine;
    }

    public Model searchModel(int modelNumber) {
        Model modelAux = null;
        for (Model model : modelList) {
            if (model.getModelNumber() == modelNumber) {
                modelAux = model;
            }
        }
        return modelAux;
    }

    public void sortModelList() {
        for (int i = 0; i < modelList.size(); i++) {
            for (int j = 0; j < modelList.size() - 1; j++) {
                if (modelList.get(j).getModelNumber() > modelList.get(j + 1).getModelNumber()) {
                    Model aux = modelList.get(j);
                    modelList.set(j, modelList.get(j + 1));
                    modelList.set(j + 1, aux);
                }
            }
        }
    }

    public void addModel(int model, double value) {
        Model modelAux = new Model(model, value);
        if (searchModel(model) == null) {
            modelList.add(modelAux);
        }
    }
}
