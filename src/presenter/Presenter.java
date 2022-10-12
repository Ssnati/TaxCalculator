package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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

    @Override
    public void actionPerformed(ActionEvent event) {
        String eventAction = event.getActionCommand();
        switch (eventAction) {
            case "markComboBox":
                view.clearLines();
                view.setLineComboBox(taxCalculator.searchMark(view.getMarkItem()).getLineList());
//                System.out.println(taxCalculator.searchMark(view.getMarkItem()).getLineList());
                break;
            case "lineComboBox":
                view.clearModels();
                view.setModelComboBox(taxCalculator.searchMark(view.getMarkItem()).searchLine(view.getLineItem()).getModelList());
                break;
            case "searchButton":
                int commercialValue = (int) taxCalculator.searchMark(view.getMarkItem()).searchLine(view.getLineItem()).searchModel(view.getModelItem()).getCommercialValue();
                view.setLabelValue(String.valueOf(commercialValue));
                break;
            case "liquidateButton":
                double finalValue = taxCalculator.calculateTotalValue(view.getMarkItem(), view.getModelItem(), view.getLineItem(), view.isTimelyPaymentSelected(), view.isVehicleTypeSelected(), view.isRegistrationInBoyacaSelected());
                view.setTaxValue(String.valueOf(finalValue));
                break;
            default:
                break;
        }
    }
}
