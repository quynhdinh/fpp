package prog2;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

class Prog2 extends JFrame {

    JLabel inputLabel, outputLabel;
    JTextField textBoxInput, textBoxOutput;
    JButton countButton, reverseButton, removeButton;

    public Prog2() {
        initializeWindow();
        textBoxInput = new JTextField(10);
        textBoxOutput = new JTextField(10);
        inputLabel = new JLabel("Input");
        outputLabel = new JLabel("Output");
        countButton = new JButton("Count Letters");
        reverseButton = new JButton("Reverse Letters");
        removeButton = new JButton("Remove Duplicates");

        countButton.addActionListener(e -> {
            String text = textBoxInput.getText();
            textBoxOutput.setText(String.valueOf(text.length()));
        });
        reverseButton.addActionListener(e -> {
            String text = textBoxInput.getText();
            textBoxOutput.setText(new StringBuilder(text).reverse().toString());
        });
        removeButton.addActionListener(e -> {
            String text = textBoxInput.getText();
            StringBuilder res = new StringBuilder();
            for (char c : text.toCharArray())
                if (res.indexOf(String.valueOf(c)) == -1)
                    res.append(c);
            textBoxOutput.setText(res.toString());
        });

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(3, 1, 10, 10));
        leftPanel.add(countButton);
        leftPanel.add(reverseButton);
        leftPanel.add(removeButton);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(2, 1, 10, 10)); // 2 rows, 2 columns, 10px gaps

        // Create labels and text boxes
        JPanel upperRight = new JPanel();
        upperRight.setLayout(new GridLayout(2, 1, 10, 1));
        inputLabel = new JLabel("Input");
        textBoxInput = new JTextField(10);
        upperRight.add(inputLabel);
        upperRight.add(textBoxOutput);


        JPanel lowerRight = new JPanel();
        lowerRight.setLayout(new GridLayout(2, 1, 10, 1));
        outputLabel = new JLabel("Output");
        textBoxOutput = new JTextField(10);
        lowerRight.add(outputLabel);
        lowerRight.add(textBoxOutput);

        // Add labels and text boxes to the panel
        rightPanel.add(upperRight);
        rightPanel.add(lowerRight);

        // Set frame visibility
        JPanel masterPanel = new JPanel();
        masterPanel.setLayout(new BorderLayout());
        masterPanel.add(leftPanel, BorderLayout.WEST);
        masterPanel.add(rightPanel, BorderLayout.EAST);
        getContentPane().add(masterPanel);
        setSize(320, 240);
        centerFrameOnDesktop(this);
    }

    public void initializeWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("String Utility");
        setResizable(false);
    }

    public static void centerFrameOnDesktop(Component f) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int height = toolkit.getScreenSize().height;
        int width = toolkit.getScreenSize().width;
        int frameHeight = f.getSize().height;
        int frameWidth = f.getSize().width;
        f.setLocation(((width - frameWidth) / 2), (height - frameHeight) / 3);
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Prog2 mf = new Prog2();
            mf.setVisible(true);
        });
    }

    @Serial
    private static final long serialVersionUID = -5565229515686514125L;
}