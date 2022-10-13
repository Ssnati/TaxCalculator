package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class VehicleSelectionPanel extends JPanel {
    private JLabel markLabel, lineLabel, modelLabel, priceLabel, priceValueLabel;
    private JComboBox<String> markComboBox, lineComboBox, modelComboBox;
    private JButton searchButton;

    public VehicleSelectionPanel(ActionListener listener) {
        initComponents(listener);
        setLayout(new GridLayout(5,2));
        updatePanel();
    }

    public void initComponents(ActionListener listener) {
        markComboBox(listener);
        lineComboBox(listener);
        modelComboBox(listener);
        priceLabel = new JLabel("Precio: $");
        priceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        priceValueLabel = new JLabel("0");
        searchButton(listener);
    }

    private void searchButton(ActionListener listener) {
        searchButton = new JButton("Buscar");
        searchButton.setActionCommand("searchButton");
        searchButton.addActionListener(listener);
    }

    private void modelComboBox(ActionListener listener) {
        modelLabel = new JLabel("Modelo");
        modelLabel.setHorizontalAlignment(SwingConstants.CENTER);

        modelComboBox = new JComboBox<>();
        modelComboBox.addItem("Seleccionar modelo");
        modelComboBox.setActionCommand("modelComboBox");
        modelComboBox.addActionListener(listener);
    }

    public void markComboBox(ActionListener listener){
        markLabel = new JLabel("Marca");
        markLabel.setHorizontalAlignment(SwingConstants.CENTER);

        markComboBox = new JComboBox<>();
        markComboBox.addItem("Seleccionar marca");
        markComboBox.addActionListener(listener);
        markComboBox.setActionCommand("markComboBox");
    }

    public void lineComboBox(ActionListener listener){
        lineLabel = new JLabel("Linea");
        lineLabel.setHorizontalAlignment(SwingConstants.CENTER);

        lineComboBox = new JComboBox<>();
        lineComboBox.addItem("Seleccionar linea");
        lineComboBox.addActionListener(listener);
        lineComboBox.setActionCommand("lineComboBox");
    }

    public void setPriceValueLabel(String price){
        priceValueLabel.setText(price);
    }

    public void setMarkComboBox(List<String> marks){
        for (String mark : marks) {
            markComboBox.addItem(mark);
        }
    }

    public void setLineComboBox(List<String> lines){
        for (String line : lines) {
            lineComboBox.addItem(line);
        }
    }

    public List<String> getListLineItems(){
        List<String> lines = new ArrayList<>();
        int count = lineComboBox.getItemCount();
        for (int i = 0; i < count; i++) {
            lines.add(lineComboBox.getItemAt(i));
        }
        return lines;
    }

    public void setModelComboBox(List<String> models){
        for (String model : models) {
            modelComboBox.addItem(model);
        }
    }

    public void updatePanel(){
        add(markLabel);
        add(markComboBox);
        add(lineLabel);
        add(lineComboBox);
        add(modelLabel);
        add(modelComboBox);
        add(priceLabel);
        add(priceValueLabel);
        add(searchButton);
    }

    public String getItemMarkComboBox() {
        return String.valueOf(markComboBox.getSelectedItem());
    }

    public String getItemLineComboBox() {
        return String.valueOf(lineComboBox.getSelectedItem());
    }

    public String getItemModelComboBox() {
        return String.valueOf(modelComboBox.getSelectedItem());
    }

    public void clearMarkComboBox() {
        markComboBox.removeAllItems();
        markComboBox.addItem("Seleccionar marca");
    }

    public void clearLineComboBox() {
        lineComboBox.removeAllItems();
        lineComboBox.addItem("Seleccionar linea");
    }

    public void clearModelComboBox(){
        modelComboBox.removeAllItems();
        modelComboBox.addItem("Seleccionar modelo");
    }
}
