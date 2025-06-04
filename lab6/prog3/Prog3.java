package prog3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class Prog3 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Prog3().createAndShowConversion());
    }

    private void createAndShowConversion() {
        JFrame frame = new JFrame("Metric Conversion Assistant");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 280);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel gridPanel = new JPanel(new GridLayout(4, 4, 10, 10));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(30, 5, 15, 10));

        // Labels and input fields
        JLabel mileLabel = new JLabel("Mile:");
        mileLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        JTextField mileField = new JTextField();

        JLabel kmLabel = new JLabel("Kilometer:");
        kmLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        JTextField kmField = new JTextField();
        kmField.setEditable(false);
        kmField.setFocusable(false);

        JLabel poundLabel = new JLabel("Pound:");
        poundLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        JTextField poundField = new JTextField();

        JLabel kgLabel = new JLabel("Kilogram:");
        kgLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        JTextField kgField = new JTextField();
        kgField.setEditable(false);
        kgField.setFocusable(false);

        JLabel gallonLabel = new JLabel("Gallon:");
        gallonLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        JTextField gallonField = new JTextField();

        JLabel literLabel = new JLabel("Litre:");
        literLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        JTextField literField = new JTextField();
        literField.setEditable(false);
        literField.setFocusable(false);

        JLabel fLabel = new JLabel("Fahrenheit:");
        fLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        JTextField fField = new JTextField();

        JLabel cLabel = new JLabel("Centigrade:");
        cLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        JTextField cField = new JTextField();
        cField.setEditable(false);
        cField.setFocusable(false);

        // Add to grid
        gridPanel.add(mileLabel);
        gridPanel.add(mileField);
        gridPanel.add(kmLabel);
        gridPanel.add(kmField);

        gridPanel.add(poundLabel);
        gridPanel.add(poundField);
        gridPanel.add(kgLabel);
        gridPanel.add(kgField);

        gridPanel.add(gallonLabel);
        gridPanel.add(gallonField);
        gridPanel.add(literLabel);
        gridPanel.add(literField);

        gridPanel.add(fLabel);
        gridPanel.add(fField);
        gridPanel.add(cLabel);
        gridPanel.add(cField);

        // Convert button
        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener((ActionEvent e) -> {
            try {
                double miles = Double.parseDouble(mileField.getText());
                double pounds = Double.parseDouble(poundField.getText());
                double gallons = Double.parseDouble(gallonField.getText());
                double fahrenheit = Double.parseDouble(fField.getText());

                kmField.setText(String.format("%.2f", miles * 1.60934));
                kgField.setText(String.format("%.2f", pounds * 0.453592));
                literField.setText(String.format("%.2f", gallons * 3.78541));
                cField.setText(String.format("%.2f", (fahrenheit - 32) * 5 / 9));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid numeric values.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Add everything
        mainPanel.add(gridPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(convertButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }
}