package lab13.prog2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class AddressForm extends JFrame {
    private JPanel topPanel, middlePanel, bottomPanel;
    private JTextField tfID,
            tfLastName,
            tfSSN,
            tfFirstName,
            tfStreet,
            tfCity,
            tfState,
            tfZIP;
    private JLabel tfInfo;

    private JPanel idPanel,
            lastNamePanel,
            ssnPanel,
            firstNamePanel,
            streetPanel,
            cityPanel,
            statePanel,
            twoPanel;

    public AddressForm() {
        initializeWindow();
        JPanel mainPanel = new JPanel(new BorderLayout());
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
        topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
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
        middlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        createStreetPanel();
        createCityPanel();
        createStatePanel();
        createZipPanel();
        middlePanel.add(streetPanel, BorderLayout.WEST);
        middlePanel.add(cityPanel, BorderLayout.EAST);
        middlePanel.add(statePanel, BorderLayout.EAST);
        middlePanel.add(twoPanel, BorderLayout.EAST);
    }

    private void createBottomPanel() {
        bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnSearch = new JButton("Search");
        btnSearch.setFont(makeSmallFont(btnSearch.getFont()));
        JButton btnSave = new JButton("Save");
        btnSave.setFont(makeSmallFont(btnSave.getFont()));
        JButton btnClear = new JButton("Clear");
        btnClear.setFont(makeSmallFont(btnClear.getFont()));
        ReadPerson readPerson = new ReadPerson();
        ReadAddress readAddress = new ReadAddress();
        btnSearch.addActionListener(e -> {
            if (tfID.getText().isEmpty()) {
                tfInfo.setText("ID field must not be empty!");
                return;
            }
            try {
                Person person = readPerson.getPerson(Long.parseLong(tfID.getText()));
                Address address = readAddress.getAddress(Long.parseLong(tfID.getText()));
                if (person != null && address != null) {
                    tfInfo.setText("Record found!");
                    tfFirstName.setText(person.firstName());
                    tfLastName.setText(person.lastName());
                    tfSSN.setText(person.ssn());
                    tfState.setText(address.state());
                    tfCity.setText(address.city());
                    tfZIP.setText(address.zip());
                    tfStreet.setText(address.street());
                } else {
                    tfInfo.setText("No records found");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (NumberFormatException ex){
                tfInfo.setText("ID wrong format");
            }
        });
        btnSave.addActionListener(e -> {
            if (!tfID.getText().isEmpty() || tfFirstName.getText().isEmpty() || tfLastName.getText().isEmpty() || tfSSN.getText().isEmpty()
                    || tfStreet.getText().isEmpty() || tfCity.getText().isEmpty() || tfState.getText().isEmpty() || tfZIP.getText().isEmpty()) {
                tfInfo.setText("To perform a Save, all fields but ID must be nonempty");
                return;
            }
            try {
                long i = readPerson.savePerson(new Person("dummy", tfFirstName.getText(), tfLastName.getText(), tfSSN.getText()));
                if (i > 0) {
                    int i1 = readAddress.saveAddress(new Address(i, tfStreet.getText(), tfCity.getText(), tfState.getText(), tfZIP.getText()));
                    if (i1 < 0) {
                        tfInfo.setText("Error occurred");
                    } else tfInfo.setText("Save successfully id " + i);
                } else tfInfo.setText("Error occurred");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        btnClear.addActionListener(e -> {
            tfID.setText(""); tfLastName.setText(""); tfSSN.setText("");
            tfFirstName.setText(""); tfStreet.setText(""); tfCity.setText("");
            tfState.setText(""); tfZIP.setText("");
        });
        bottomPanel.add(btnSearch);
        bottomPanel.add(btnSave);
        bottomPanel.add(btnClear);

        tfInfo = new JLabel();
        tfInfo.setFont(makeSmallFont(tfInfo.getFont()));
        tfInfo.setText("....");
        bottomPanel.add(tfInfo);
    }

    private void createIDPanel() {
        JPanel lblIDPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        JLabel lblID = new JLabel("ID:");
        lblID.setFont(makeSmallFont(lblID.getFont()));
        lblIDPanel.add(lblID);

        JPanel tfIDPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        tfID = new JTextField(10);
        tfID.setFont(makeSmallFont(tfID.getFont()));
        tfIDPanel.add(tfID);

        idPanel = new JPanel(new BorderLayout());
        idPanel.add(lblIDPanel, BorderLayout.NORTH);
        idPanel.add(tfIDPanel, BorderLayout.CENTER);
    }

    private void createLastNamePanel() {
        JPanel lblLastNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        JLabel lblStreet = new JLabel("Last Name:");
        lblStreet.setFont(makeSmallFont(lblStreet.getFont()));
        lblLastNamePanel.add(lblStreet);

        JPanel tfLastNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        tfLastName = new JTextField(10);
        tfLastName.setFont(makeSmallFont(tfLastName.getFont()));
        tfLastNamePanel.add(tfLastName);

        lastNamePanel = new JPanel(new BorderLayout());
        lastNamePanel.add(lblLastNamePanel, BorderLayout.NORTH);
        lastNamePanel.add(tfLastNamePanel, BorderLayout.CENTER);
    }

    private void createSSNPanel() {
        JPanel lblSSNPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        JLabel lblSSN = new JLabel("SSN:");
        lblSSN.setFont(makeSmallFont(lblSSN.getFont()));
        lblSSNPanel.add(lblSSN);

        JPanel tfSSNPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        tfSSN = new JTextField(10);
        tfSSN.setFont(makeSmallFont(tfSSN.getFont()));
        tfSSNPanel.add(tfSSN);

        ssnPanel = new JPanel(new BorderLayout());
        ssnPanel.add(lblSSNPanel, BorderLayout.NORTH);
        ssnPanel.add(tfSSNPanel, BorderLayout.SOUTH);
    }

    private void createFirstNamePanel() {
        JPanel lblFirstNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        JLabel lblFirstName = new JLabel("First Name:");
        lblFirstName.setFont(makeSmallFont(lblFirstName.getFont()));
        lblFirstNamePanel.add(lblFirstName);

        JPanel tfFirstNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        tfFirstName = new JTextField(10);
        tfFirstName.setFont(makeSmallFont(tfFirstName.getFont()));
        tfFirstNamePanel.add(tfFirstName);

        firstNamePanel = new JPanel(new BorderLayout());
        firstNamePanel.add(lblFirstNamePanel, BorderLayout.NORTH);
        firstNamePanel.add(tfFirstNamePanel, BorderLayout.SOUTH);
    }

    private void createStreetPanel() {
        JPanel lblStreetPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        JLabel lblStreet = new JLabel("Street:");
        lblStreet.setFont(makeSmallFont(lblStreet.getFont()));
        lblStreetPanel.add(lblStreet);

        JPanel tfStreetPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        tfStreet = new JTextField(10);
        tfStreet.setFont(makeSmallFont(tfStreet.getFont()));
        tfStreetPanel.add(tfStreet);

        streetPanel = new JPanel(new BorderLayout());
        streetPanel.add(lblStreetPanel, BorderLayout.NORTH);
        streetPanel.add(tfStreetPanel, BorderLayout.CENTER);
    }

    private void createCityPanel() {
        JPanel lblCityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        JLabel lblCity = new JLabel("City:");
        lblCity.setFont(makeSmallFont(lblCity.getFont()));
        lblCityPanel.add(lblCity);

        JPanel tfCityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        tfCity = new JTextField(10);
        tfCity.setFont(makeSmallFont(tfCity.getFont()));
        tfCityPanel.add(tfCity);

        cityPanel = new JPanel(new BorderLayout());
        cityPanel.add(lblCityPanel, BorderLayout.NORTH);
        cityPanel.add(tfCityPanel, BorderLayout.CENTER);
    }

    private void createStatePanel() {
        JPanel lblStatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        JLabel lblState = new JLabel("State:");
        lblState.setFont(makeSmallFont(lblState.getFont()));
        lblStatePanel.add(lblState);

        JPanel tfStatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        tfState = new JTextField(10);
        tfState.setFont(makeSmallFont(tfState.getFont()));
        tfStatePanel.add(tfState);

        statePanel = new JPanel(new BorderLayout());
        statePanel.add(lblStatePanel, BorderLayout.NORTH);
        statePanel.add(tfStatePanel, BorderLayout.CENTER);
    }

    private void createZipPanel() {
        JPanel lblZipPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        JLabel lblZip = new JLabel("ZIP:");
        lblZip.setFont(makeSmallFont(lblZip.getFont()));
        lblZipPanel.add(lblZip);

        JPanel tfZipPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        tfZIP = new JTextField(10);
        tfZIP.setFont(makeSmallFont(tfZIP.getFont()));
        tfZipPanel.add(tfZIP);

        twoPanel = new JPanel(new BorderLayout());
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
        setResizable(false);
    }

    private void handleWindowClosing() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent w) {
                dispose();
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
        EventQueue.invokeLater(() -> {
            AddressForm frame = new AddressForm();
            frame.setVisible(true);
        });
    }
}