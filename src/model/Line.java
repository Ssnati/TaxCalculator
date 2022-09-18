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

    public String getModelList() {
        String auxList ="";
        for (Model model : modelList) {
            auxList += "\n-: " + model.getModelNumber();
        }
        return auxList;
    }

    public String getNameLine() {
        return nameLine;
    }

    public void setModelList(List<Model> modelList) {
        this.modelList = modelList;
    }

    public void setNameLine(String nameLine) {
        this.nameLine = nameLine;
    }

    public void addModel(Model model){
        modelList.add(model);
    }

    public Model searchModel(int modelNumber) {
        Model modelAux = null;
        for (Model model : modelList) {
            if (model.getModelNumber()==modelNumber) {
                modelAux = model;
            }
        }
        if (modelAux == null) {
            Model newModel = new Model(modelNumber, 0, 0);
            modelList.add(newModel);
            modelAux = newModel;
        }
        return modelAux;
    }
}
