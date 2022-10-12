package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class View extends JFrame {

    private VehicleSelectionPanel firstPanel;
    private DiscountPanel secondPanel;
    private ResultPanel thirdPanel;

    public View(ActionListener listener) {
        setTitle("Tax Calculator");
        this.setSize(300,600);
        initComponents(listener);
        setLayout(new GridLayout(3,1));
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    private void initComponents(ActionListener listener) {
        firstPanel = new VehicleSelectionPanel(listener);
        secondPanel = new DiscountPanel(listener);
        thirdPanel = new ResultPanel(listener);
        firstPanel.setBackground(Color.GRAY);
        secondPanel.setBackground(Color.WHITE);
        thirdPanel.setBackground(Color.GRAY);
        this.getContentPane().add(firstPanel);
        this.getContentPane().add(secondPanel);
        this.getContentPane().add(thirdPanel);
    }

    public String getMarkItem(){
        return firstPanel.getMarkComboBox();
    }

    public String getLineItem() {
        return firstPanel.getLineComboBox();
    }

    public int getModelItem() {
        return Integer.parseInt(firstPanel.getModelComboBox());
    }

    public void setLabelValue(String value){
        firstPanel.setPriceValueLabel(value);
    }

    public void setTaxValue(String value){
        thirdPanel.setTaxValueLabel(value);
    }

    public void setMarkComboBox(List<String> marks){
        firstPanel.setMarkComboBox(marks);
    }

    public void setLineComboBox(List<String> lines){
        firstPanel.setLineComboBox(lines);
    }

    public void setModelComboBox(List<String> models){
        firstPanel.setModelComboBox(models);
    }

    public void clearModels() {
        firstPanel.clearModelComboBox();
    }

    public boolean isTimelyPaymentSelected(){
        return secondPanel.isTimelyPaymentSelected();
    }

    public boolean isVehicleTypeSelected(){
        return secondPanel.isVehicleTypeSelected();
    }

    public boolean isRegistrationInBoyacaSelected(){
        return secondPanel.isRegistrationInBoyacaSelected();
    }

    public void clearLines() {
        firstPanel.clearLineComboBox();
    }
}