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

    public String getLineList() {
        String auxList = "";
        for (Line line: lineList) {
            auxList += "\n-: " + line.getNameLine();
        }
        return auxList;
    }

    public String getMarkName() {
        return markName;
    }

    public void setLineList(List<Line> lineList) {
        this.lineList = lineList;
    }

    public void setMarkName(String markName) {
        this.markName = markName;
    }

    public void addLine(Line line) {
        lineList.add(line);
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

}

