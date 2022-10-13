package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import view.*;
import model.*;

public class Presenter implements ActionListener {

    private View view;
    private TaxCalculator taxCalculator;

    public Presenter() {
        view = new View(this);
        try {
            taxCalculator = new TaxCalculator();
            view.setMarkComboBox(taxCalculator.getMarkList());
        } catch (IOException e) {
            view.setLabelValue("Error");
            view.setTaxValue("Error");
        }
    }

    public static void main(String[] args) {
        new Presenter();
    }

    public boolean areEquals(List<String> list1, List<String> list2) {
        boolean result = false;
        if (list1.size() != list2.size()) {
            result = false;
        } else {
            for (int i = 0; i < list1.size(); i++) {
                result = list1.get(i).equals(list2.get(i));
            }
        }

        return result;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String eventAction = event.getActionCommand();
        String mark = view.getMarkItem();
        switch (eventAction) {
            case "markComboBox":
                if(!mark.equals("Seleccionar marca")&&!(mark.equals("null"))) {
                    view.clearLines();
                    view.setLineComboBox(taxCalculator.searchMark(view.getMarkItem()).getLineList());
                }
                break;
            case "lineComboBox":
                mark = view.getMarkItem();
                if ((!mark.equals("Seleccionar marca"))) {
                    List<String> lineChecker = taxCalculator.searchMark(mark).getLineList();
                    lineChecker.add(0, "Seleccionar linea");
                    if (areEquals(lineChecker, view.getLineList())) {
                        view.clearModels();
                        view.setModelComboBox(taxCalculator.searchMark(view.getMarkItem()).searchLine(view.getLineItem()).getModelList());
                    }
                }
                break;
            case "searchButton":
                int commercialValue = (int) taxCalculator.searchMark(view.getMarkItem()).searchLine(view.getLineItem()).searchModel(view.getModelItem()).getCommercialValue();
                view.setLabelValue(String.valueOf(commercialValue));
                break;
            case "liquidateButton":
                double finalValue = taxCalculator.calculateTotalValue(view.getMarkItem(), view.getModelItem(), view.getLineItem(), view.isTimelyPaymentSelected(), view.isVehicleTypeSelected(), view.isRegistrationInBoyacaSelected());
                view.setTaxValue(String.valueOf(finalValue));
                break;
                case "cleanButton":
                    view.setLabelValue("0");
                    view.setTaxValue("0");
                    view.clearMarks();
                    view.clearModels();
                    view.clearLines();
                    view.clearAllCheckBoxes();
                    view.setMarkComboBox(taxCalculator.getMarkList());
                    break;
            default:
                break;
        }
    }
}
