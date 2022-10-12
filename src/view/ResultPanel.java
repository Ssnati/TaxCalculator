package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ResultPanel extends JPanel {
    private JLabel taxTextLabel, taxValueLabel;
    private JButton liquidate;

    public ResultPanel(ActionListener listener) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        liquidate = new JButton("Liquidar");
        liquidate.setActionCommand("liquidateButton");
        liquidate.addActionListener(listener);
        taxTextLabel = new JLabel("El valor del impuesto es: $");
        taxValueLabel = new JLabel("0");
        updatePanel();
    }

    private void updatePanel() {
        add(liquidate);
        add(taxTextLabel);
        add(taxValueLabel);
    }

    public void setTaxValueLabel(String taxValue) {
        taxValueLabel.setText(taxValue);
    }

}
