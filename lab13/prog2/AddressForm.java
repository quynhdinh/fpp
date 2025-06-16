package lab13.prog2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddressForm extends JFrame {
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    private JTextField tfName,
            tfLastName,
            tfSSN,
            tfFirstName,
            tfStreet,
            tfCity,
            tfState,
            tfZIP;

    private JPanel idPanel,
            lastNamePanel,
            ssnPanel,
            firstNamePanel,
            stateStreet,
            cityPanel,
            statePanel,
            twoPanel;

    public AddressForm() {
        initializeWindow();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        createTopPanel();
        createMiddlePanel();
        createBottomPanel();
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(middlePanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        wrapper.add(mainPanel);

        getContentPane().add(wrapper);
        pack();
        centerFrameOnDesktop(this);

    }

    private void createTopPanel() {
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        createIDPanel();
        createFirstNamePanel();
        createLastNamePanel();
        createSSNPanel();

        topPanel.add(idPanel, BorderLayout.WEST);
        topPanel.add(firstNamePanel, BorderLayout.EAST);
        topPanel.add(lastNamePanel, BorderLayout.CENTER);
        topPanel.add(ssnPanel, BorderLayout.EAST);

    }

    private void createMiddlePanel() {
        middlePanel = new JPanel();
        middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        createStreetPanel();
        createCityPanel();
        createStatePanel();
        createZipPanel();
        middlePanel.add(stateStreet, BorderLayout.WEST);
        middlePanel.add(cityPanel, BorderLayout.EAST);
        middlePanel.add(statePanel, BorderLayout.EAST);
        middlePanel.add(twoPanel, BorderLayout.EAST);
    }

    private void createBottomPanel() {
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setFont(makeSmallFont(btnSubmit.getFont()));
        JButton btnSave = new JButton("Save");
        btnSave.setFont(makeSmallFont(btnSubmit.getFont()));
        JButton btnClear = new JButton("Clear");
        btnClear.setFont(makeSmallFont(btnSubmit.getFont()));
        btnSubmit.addActionListener(e -> {

            String name = tfName.getText();
            String street = tfLastName.getText();
            String city = tfSSN.getText();
            String state = tfStreet.getText();
            String zip = tfCity.getText();

            if (!zip.matches("\\d+")) {
                JOptionPane.showMessageDialog(AddressForm.this, "Zip code must be numeric!", "Invalid Input",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            System.out.println(name);
            System.out.println(street);
            System.out.println(city + ", " + state + " " + zip);
        });
        btnClear.addActionListener(e -> {
            tfName.setText("");
            tfLastName.setText("");
            tfSSN.setText("");
            tfFirstName.setText("");
            tfStreet.setText("");
            tfCity.setText("");
            tfState.setText("");
            tfZIP.setText("");
        });
        bottomPanel.add(btnSubmit);
        bottomPanel.add(btnSave);
        bottomPanel.add(btnClear);
    }

    private void createIDPanel() {
        JPanel lblNamePanel = new JPanel();
        lblNamePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        JLabel lblName = new JLabel("Name:");
        lblName.setFont(makeSmallFont(lblName.getFont()));
        lblNamePanel.add(lblName);

        JPanel tfNamePanel = new JPanel();
        tfNamePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        tfName = new JTextField(10);
        tfName.setFont(makeSmallFont(tfName.getFont()));
        tfNamePanel.add(tfName);

        idPanel = new JPanel();
        idPanel.setLayout(new BorderLayout());
        idPanel.add(lblNamePanel, BorderLayout.NORTH);
        idPanel.add(tfNamePanel, BorderLayout.CENTER);
    }

    private void createLastNamePanel() {
        JPanel lblLastNamePanel = new JPanel();
        lblLastNamePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        JLabel lblStreet = new JLabel("Last Name:");
        lblStreet.setFont(makeSmallFont(lblStreet.getFont()));
        lblLastNamePanel.add(lblStreet);

        JPanel tfLastNamePanel = new JPanel();
        tfLastNamePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        tfLastName = new JTextField(10);
        tfLastName.setFont(makeSmallFont(tfLastName.getFont()));
        tfLastNamePanel.add(tfLastName);

        lastNamePanel = new JPanel();
        lastNamePanel.setLayout(new BorderLayout());
        lastNamePanel.add(lblLastNamePanel, BorderLayout.NORTH);
        lastNamePanel.add(tfLastNamePanel, BorderLayout.CENTER);
    }

    private void createSSNPanel() {
        JPanel lblSSNPanel = new JPanel();
        lblSSNPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        JLabel lblSSN = new JLabel("SSN:");
        lblSSN.setFont(makeSmallFont(lblSSN.getFont()));
        lblSSNPanel.add(lblSSN);

        JPanel tfSSNPanel = new JPanel();
        tfSSNPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        tfSSN = new JTextField(10);
        tfSSN.setFont(makeSmallFont(tfSSN.getFont()));
        tfSSNPanel.add(tfSSN);

        ssnPanel = new JPanel();
        ssnPanel.setLayout(new BorderLayout());
        ssnPanel.add(lblSSNPanel, BorderLayout.NORTH);
        ssnPanel.add(tfSSNPanel, BorderLayout.SOUTH);
    }

    private void createFirstNamePanel() {
        JPanel lblFirstNamePanel = new JPanel();
        lblFirstNamePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        JLabel lblFirstName = new JLabel("First Name:");
        lblFirstName.setFont(makeSmallFont(lblFirstName.getFont()));
        lblFirstNamePanel.add(lblFirstName);

        JPanel tfFirstNamePanel = new JPanel();
        tfFirstNamePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        tfFirstName = new JTextField(10);
        tfFirstName.setFont(makeSmallFont(tfFirstName.getFont()));
        tfFirstNamePanel.add(tfFirstName);

        firstNamePanel = new JPanel();
        firstNamePanel.setLayout(new BorderLayout());
        firstNamePanel.add(lblFirstNamePanel, BorderLayout.NORTH);
        firstNamePanel.add(tfFirstNamePanel, BorderLayout.SOUTH);
    }

    private void createStreetPanel() {
        JPanel lblStreetPanel = new JPanel();
        lblStreetPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        JLabel lblStreet = new JLabel("Street:");
        lblStreet.setFont(makeSmallFont(lblStreet.getFont()));
        lblStreetPanel.add(lblStreet);

        JPanel tfStreetPanel = new JPanel();
        tfStreetPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        tfStreet = new JTextField(10);
        tfStreet.setFont(makeSmallFont(tfStreet.getFont()));
        tfStreetPanel.add(tfStreet);

        stateStreet = new JPanel();
        stateStreet.setLayout(new BorderLayout());
        stateStreet.add(lblStreetPanel, BorderLayout.NORTH);
        stateStreet.add(tfStreetPanel, BorderLayout.CENTER);
    }

    private void createCityPanel() {
        JPanel lblCityPanel = new JPanel();
        lblCityPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        JLabel lblCity = new JLabel("City:");
        lblCity.setFont(makeSmallFont(lblCity.getFont()));
        lblCityPanel.add(lblCity);

        JPanel tfCityPanel = new JPanel();
        tfCityPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        tfCity = new JTextField(10);
        tfCity.setFont(makeSmallFont(tfCity.getFont()));
        tfCityPanel.add(tfCity);

        cityPanel = new JPanel();
        cityPanel.setLayout(new BorderLayout());
        cityPanel.add(lblCityPanel, BorderLayout.NORTH);
        cityPanel.add(tfCityPanel, BorderLayout.CENTER);
    }

    private void createStatePanel() {
        JPanel lblStatePanel = new JPanel();
        lblStatePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        JLabel lblState = new JLabel("State:");
        lblState.setFont(makeSmallFont(lblState.getFont()));
        lblStatePanel.add(lblState);

        JPanel tfStatePanel = new JPanel();
        tfStatePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        tfState = new JTextField(10);
        tfState.setFont(makeSmallFont(tfState.getFont()));
        tfStatePanel.add(tfState);

        statePanel = new JPanel();
        statePanel.setLayout(new BorderLayout());
        statePanel.add(lblStatePanel, BorderLayout.NORTH);
        statePanel.add(tfStatePanel, BorderLayout.CENTER);
    }

    private void createZipPanel() {
        JPanel lblZipPanel = new JPanel();
        lblZipPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        JLabel lblZip = new JLabel("ZIP:");
        lblZip.setFont(makeSmallFont(lblZip.getFont()));
        lblZipPanel.add(lblZip);

        JPanel tfZipPanel = new JPanel();
        tfZipPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        tfZIP = new JTextField(10);
        tfZIP.setFont(makeSmallFont(tfZIP.getFont()));
        tfZipPanel.add(tfZIP);

        twoPanel = new JPanel();
        twoPanel.setLayout(new BorderLayout());
        twoPanel.add(lblZipPanel, BorderLayout.NORTH);
        twoPanel.add(tfZipPanel, BorderLayout.CENTER);
    }

    public static Font makeSmallFont(Font f) {
        return new Font(f.getName(), f.getStyle(), (f.getSize() - 2));
    }

    private void initializeWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Address Form");

        handleWindowClosing();
        // setSize(320,250);
        setResizable(false);
    }

    private void handleWindowClosing() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent w) {
                dispose();
                // other clean-up
                System.exit(0);
            }
        });
    }

    public static void centerFrameOnDesktop(Component f) {
        final int SHIFT_AMOUNT = 0;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int height = toolkit.getScreenSize().height;
        int width = toolkit.getScreenSize().width;
        int frameHeight = f.getSize().height;
        int frameWidth = f.getSize().width;
        f.setLocation(((width - frameWidth) / 2) - SHIFT_AMOUNT, (height - frameHeight) / 3);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddressForm frame = new AddressForm();
                frame.setVisible(true);
            }
        });
    }
}