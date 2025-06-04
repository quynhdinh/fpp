package prog1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Prog1 extends JFrame {
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    private JTextField tfName,
            tfStreet,
            tfCity,
            tfState,
            tfZip;

    private JPanel namePanel,
            streetPanel,
            cityPanel,
            statePanel,
            zipPanel;

    public Prog1() {
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

        createNamePanel();
        createeStreetPanel();
        createCityPanel();

        topPanel.add(namePanel, BorderLayout.WEST);
        topPanel.add(streetPanel, BorderLayout.CENTER);
        topPanel.add(cityPanel, BorderLayout.EAST);

    }

    private void createMiddlePanel() {
        middlePanel = new JPanel();
        middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        createStatePanel();
        createZipPanel();
        middlePanel.add(statePanel, BorderLayout.WEST);
        middlePanel.add(zipPanel, BorderLayout.EAST);
    }

    private void createBottomPanel() {
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setFont(makeSmallFont(btnSubmit.getFont()));
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = tfName.getText();
                String street = tfStreet.getText();
                String city = tfCity.getText();
                String state = tfState.getText();
                String zip = tfZip.getText();

                if (!zip.matches("\\d+")) {
                    JOptionPane.showMessageDialog(Prog1.this, "Zip code must be numeric!", "Invalid Input",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                System.out.println(name);
                System.out.println(street);
                System.out.println(city + ", " + state + " " + zip);
            }
        });
        bottomPanel.add(btnSubmit);
    }

    private void createNamePanel() {
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

        namePanel = new JPanel();
        namePanel.setLayout(new BorderLayout());
        namePanel.add(lblNamePanel, BorderLayout.NORTH);
        namePanel.add(tfNamePanel, BorderLayout.CENTER);
    }

    private void createeStreetPanel() {
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

        streetPanel = new JPanel();
        streetPanel.setLayout(new BorderLayout());
        streetPanel.add(lblStreetPanel, BorderLayout.NORTH);
        streetPanel.add(tfStreetPanel, BorderLayout.CENTER);
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
        cityPanel.add(tfCityPanel, BorderLayout.SOUTH);
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
        JLabel lblZip = new JLabel("Zip:");
        lblZip.setFont(makeSmallFont(lblZip.getFont()));
        lblZipPanel.add(lblZip);

        JPanel tfZipPanel = new JPanel();
        tfZipPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        tfZip = new JTextField(10);
        tfZip.setFont(makeSmallFont(tfZip.getFont()));
        tfZipPanel.add(tfZip);

        zipPanel = new JPanel();
        zipPanel.setLayout(new BorderLayout());
        zipPanel.add(lblZipPanel, BorderLayout.NORTH);
        zipPanel.add(tfZipPanel, BorderLayout.CENTER);
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
                Prog1 frame = new Prog1();
                frame.setVisible(true);
            }
        });
    }

}
