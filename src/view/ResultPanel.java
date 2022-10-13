package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ResultPanel extends JPanel {
    private JLabel taxTextLabel, taxValueLabel;
    private JButton liquidate, clean;

    public ResultPanel(ActionListener listener) {
        initComponents(listener);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        updatePanel();
    }

    private void initComponents(ActionListener listener) {
        taxTextLabel = new JLabel("El valor del impuesto es: $");
        taxValueLabel = new JLabel("0");

        liquidate = new JButton("Liquidar");
        liquidate.setActionCommand("liquidateButton");
        liquidate.addActionListener(listener);

        clean = new JButton("Limpiar");
        clean.setActionCommand("cleanButton");
        clean.addActionListener(listener);
    }

    private void updatePanel() {
        add(liquidate);
        add(taxTextLabel);
        add(taxValueLabel);
        add(clean);
    }

    public void setTaxValueLabel(String taxValue) {
        taxValueLabel.setText(taxValue);
    }

}
