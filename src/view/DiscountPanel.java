package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DiscountPanel extends JPanel {
    private JCheckBox checkTimelyPayment, checkVehicleType, checkRegistrationInBoyaca;
    private JLabel labelTimelyPayment, labelVehicleType, labelRegistrationInBoyaca;


    public DiscountPanel(ActionListener listener) {
        initComponents(listener);
        setLayout(new GridLayout(3, 2));
        updatePanel();
    }

    private void initComponents(ActionListener listener) {
        checkTimelyPayment = new JCheckBox();
        checkVehicleType = new JCheckBox();
        checkRegistrationInBoyaca = new JCheckBox();
        setCheckBoxListener(listener);

        labelTimelyPayment = new JLabel("Pago a tiempo");
        labelVehicleType = new JLabel("Vehiculo de servicio publico");
        labelRegistrationInBoyaca = new JLabel("Matriculado en Boyaca");
    }

    public void setCheckBoxListener(ActionListener listener){
        checkTimelyPayment.addActionListener(listener);
        checkVehicleType.addActionListener(listener);
        checkRegistrationInBoyaca.addActionListener(listener);
    }

    public boolean isTimelyPaymentSelected(){
        return checkTimelyPayment.isSelected();
    }

    public boolean isVehicleTypeSelected(){
        return checkVehicleType.isSelected();
    }

    public boolean isRegistrationInBoyacaSelected(){
        return checkRegistrationInBoyaca.isSelected();
    }

    public void updatePanel(){
        add(labelTimelyPayment);
        add(checkTimelyPayment);
        add(labelVehicleType);
        add(checkVehicleType);
        add(labelRegistrationInBoyaca);
        add(checkRegistrationInBoyaca);
    }
}
