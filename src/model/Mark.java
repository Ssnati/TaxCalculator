package model;

import java.util.ArrayList;
import java.util.List;

public class Mark {
    private String markName;
    private List<Line> lineList;

    public Mark(String markName) {
        this.markName = markName;
        lineList =  new ArrayList<>();
    }

    public List<String> getLineList() {
        List<String> lineListAux = new ArrayList<>();
        for (Line line : lineList) {
            lineListAux.add(line.getNameLine());
        }
        return lineListAux;
    }

    public String getMarkName() {
        return markName;
    }

    public Line searchLine(String nameLine) {
        Line lineAux = null;
        for (Line line : lineList) {
            if (line.getNameLine().equals(nameLine.toUpperCase())) {
                lineAux = line;
            }
        }

        if (lineAux == null) {
            Line newLine = new Line(nameLine);
            lineList.add(newLine);
            lineAux = newLine;
        }
        return lineAux;
    }
    public void sortLineList() {
        for (int i = 0; i < lineList.size(); i++) {
            for (int j = 0; j < lineList.size() - 1; j++) {
                if (lineList.get(j).getNameLine().compareTo(lineList.get(j + 1).getNameLine()) > 0) {
                    Line aux = lineList.get(j);
                    lineList.set(j, lineList.get(j + 1));
                    lineList.set(j + 1, aux);
                }
            }
        }
        sortModelList();
    }

    public void sortModelList() {
        for (Line line : lineList) {
            line.sortModelList();
        }
    }
}

