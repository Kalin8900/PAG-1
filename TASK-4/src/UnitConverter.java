import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Converter {
    private String label;
    private String[] units;

    public Converter(String label, String[] units) {
        this.label = label;
        this.units = units;
    }

    public String getLabel() {
        return label;
    }

    public String[] getUnits() {
        return units;
    }


}


class UnitConverter {
    public static void main(String[] args) {
        var f = new JFrame("Conversion");

        Converter[] options = { new Converter("meters <-> inches", new String[]{"[m]", "[in]"}),
                                new Converter("degrees Celsius <-> degrees Fahrenheit", new String[]{"[\u00B0C]", "[\u00B0F]"}),
                                new Converter("kilograms <-> pounds", new String[]{"[kg]", "[lb]"})};
        var inputField = new JTextField(10);
        inputField.setBounds(50, 50, 200, 50);
        inputField.setText("0");

        var outputField = new JTextField(10);
        outputField.setBounds(350, 50, 200, 50);

        var inputLabel = new JLabel("[m]");
        inputLabel.setBounds(250, 50, 50, 50);

        var outputLabel = new JLabel("[in]");
        outputLabel.setBounds(550, 50, 50, 50);

        var optionsList = new JComboBox(new String[]{options[0].getLabel(), options[1].getLabel(), options[2].getLabel()});
        optionsList.setBounds(150, 200, 300, 50);

        var convertBtn = new JButton("Convert");
        convertBtn.setBounds(50, 450, 200, 50);

        var changeDirectionBtn = new JButton("Change direction");
        changeDirectionBtn.setBounds(350, 450, 200, 50);
        final boolean[] changed = {false};

        changeDirectionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputField.setText("");
                changed[0] = !changed[0];
                directioChange(changed, inputLabel, options, optionsList, outputLabel);
            }
        });

        optionsList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputField.setText("");
                directioChange(changed, inputLabel, options, optionsList, outputLabel);
            }
        });

        convertBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double value = 0;
                try {
                    value = Double.parseDouble(inputField.getText());
                } catch (NumberFormatException err) {
                    err.printStackTrace();
                }
                if (!changed[0]) {
                    switch (options[optionsList.getSelectedIndex()].getLabel()) {
                        case "meters <-> inches" -> outputField.setText(String.valueOf(value * 39.37));
                        case "degrees Celsius <-> degrees Fahrenheit" -> outputField.setText(String.valueOf(32 + value * 1.8));
                        case "kilograms <-> pounds" -> outputField.setText(String.valueOf(value * 2.2046));
                    }
                } else {
                    switch (options[optionsList.getSelectedIndex()].getLabel()) {
                        case "meters <-> inches" -> outputField.setText(String.valueOf(value / 39.37));
                        case "degrees Celsius <-> degrees Fahrenheit" -> outputField.setText(String.valueOf((value - 32) / 1.8));
                        case "kilograms <-> pounds" -> outputField.setText(String.valueOf(value / 2.2046));
                    }
                }
            }
        });

        f.getContentPane().setBackground(Color.PINK);
        f.setSize(600,600);
        f.setLayout(null);
        f.add(inputField);
        f.add(inputLabel);
        f.add(outputField);
        f.add(outputLabel);
        f.add(optionsList);
        f.add(convertBtn);
        f.add(changeDirectionBtn);
        f.setVisible(true);
    }

    private static void directioChange(boolean[] changed, JLabel inputLabel, Converter[] options, JComboBox optionsList, JLabel outputLabel) {
        if (!changed[0]) {
            inputLabel.setText(options[optionsList.getSelectedIndex()].getUnits()[0]);
            outputLabel.setText(options[optionsList.getSelectedIndex()].getUnits()[1]);
        } else {
            inputLabel.setText(options[optionsList.getSelectedIndex()].getUnits()[1]);
            outputLabel.setText(options[optionsList.getSelectedIndex()].getUnits()[0]);
        }
    }
}