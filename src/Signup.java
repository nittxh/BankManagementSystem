package bank.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Signup extends JFrame implements ActionListener {

    private JTextField textName, textFName, textEmail, textAdd, textCity, textPin, textState;
    private JDateChooser dateChooser;
    private JRadioButton r1, r2, ms1, ms2, ms3;
    private JButton next;
    Connection connection;
    Statement statement;

    public Signup() {
        super("APPLICATION FORM");
        Con();
        initializeComponents();
        setupLayout();
        setFrameProperties();
    }
    Color bg = new Color(1, 24, 64);

    private void Con() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bankSystem",
                    "root",
                    "root"
            );
            statement = connection.createStatement();
        } catch (Exception e) {
            System.err.println("Connection failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void initializeComponents() {
        JLabel label1 = new JLabel("APPLICATION FORM");
        label1.setBounds(200, 30, 400, 40);
        label1.setFont(new Font("Arial", Font.BOLD, 28));
        label1.setForeground(new Color(255, 185, 21));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        add(label1);

        createNameFields();
        createDateField();
        createGenderFields();
        createEmailField();
        createMaritalStatusFields();
        createAddressFields();
        createNextButton();
    }



    private void createNameFields() {
        JLabel labelName = new JLabel("Name :");
        labelName.setFont(new Font("Arial", Font.BOLD, 16));
        labelName.setBounds(100, 110, 120, 25);
        labelName.setForeground(Color.WHITE);
        add(labelName);

        textName = new JTextField();
        textName.setFont(new Font("Arial", Font.PLAIN, 14));
        textName.setBounds(280, 110, 400, 28);
        textName.setBorder(BorderFactory.createLoweredBevelBorder());
        textName.setBackground(Color.WHITE);
        textName.setForeground(Color.BLACK);
        textName.setBorder(BorderFactory.createLineBorder(bg, 1));
        add(textName);

        JLabel labelFName = new JLabel("Father's Name :");
        labelFName.setFont(new Font("Arial", Font.BOLD, 16));
        labelFName.setBounds(100, 160, 140, 25);
        labelFName.setForeground(Color.WHITE);
        add(labelFName);

        textFName = new JTextField();
        textFName.setFont(new Font("Arial", Font.PLAIN, 14));
        textFName.setBounds(280, 160, 400, 28);
        textFName.setBorder(BorderFactory.createLoweredBevelBorder());
        textFName.setBackground(Color.WHITE);
        textFName.setForeground(Color.BLACK);
        textFName.setBorder(BorderFactory.createLineBorder(bg, 1));
        add(textFName);
    }

    private void createDateField() {
        JLabel dob = new JLabel("Date of Birth :");
        dob.setFont(new Font("Arial", Font.BOLD, 16));
        dob.setBounds(100, 210, 140, 25);
        dob.setForeground(Color.WHITE);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setFont(new Font("Arial", Font.PLAIN, 14));
        dateChooser.setBounds(280, 210, 400, 28);
        dateChooser.setBorder(BorderFactory.createLoweredBevelBorder());
        dateChooser.setBackground(Color.WHITE);

        JTextField dateField = (JTextField) dateChooser.getDateEditor().getUiComponent();
        dateField.setForeground(Color.BLACK);
        dateField.setBackground(Color.WHITE);
        dateField.setCaretColor(Color.BLACK);
        dateField.setFont(new Font("Arial", Font.PLAIN, 14));
        dateField.setDisabledTextColor(Color.BLACK);
        dateField.setSelectedTextColor(Color.WHITE);
        dateField.setBorder(BorderFactory.createLineBorder(bg, 1));
        dateField.setSelectionColor(new Color(0, 120, 215));

        dateField.putClientProperty("JTextField.placeholderText", "");

        dateField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                SwingUtilities.invokeLater(() -> dateField.setForeground(Color.BLACK));
            }
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                SwingUtilities.invokeLater(() -> dateField.setForeground(Color.BLACK));
            }
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                SwingUtilities.invokeLater(() -> dateField.setForeground(Color.BLACK));
            }
        });

        add(dateChooser);
    }

    private void createGenderFields() {
        JLabel labelG = new JLabel("Gender :");
        labelG.setFont(new Font("Arial", Font.BOLD, 16));
        labelG.setBounds(100, 260, 120, 25);
        labelG.setForeground(Color.WHITE);
        add(labelG);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Arial", Font.PLAIN, 14));
        r1.setBackground(new Color(1,24,64));
        r1.setBounds(280, 260, 80, 28);
        r1.setForeground(Color.white);
        r1.setFocusPainted(false);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Arial", Font.PLAIN, 14));
        r2.setBackground(new Color(1,24,64));
        r2.setBounds(380, 260, 90, 28);
        r2.setForeground(Color.white);
        r2.setFocusPainted(false);
        add(r2);

        ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);
    }

    private void createEmailField() {
        JLabel labelEmail = new JLabel("Email Address :");
        labelEmail.setFont(new Font("Arial", Font.BOLD, 16));
        labelEmail.setBounds(100, 310, 140, 25);
        labelEmail.setForeground(Color.WHITE);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Arial", Font.PLAIN, 14));
        textEmail.setBounds(280, 310, 400, 28);
        textEmail.setBorder(BorderFactory.createLoweredBevelBorder());
        textEmail.setBackground(Color.WHITE);
        textEmail.setForeground(Color.BLACK);
        textEmail.setBorder(BorderFactory.createLineBorder(bg, 1));
        add(textEmail);
    }

    private void createMaritalStatusFields() {
        JLabel status = new JLabel("Marital Status :");
        status.setFont(new Font("Arial", Font.BOLD, 16));
        status.setBounds(100, 360, 140, 25);
        status.setForeground(Color.WHITE);
        add(status);

        ms1 = new JRadioButton("Married");
        ms1.setBounds(280, 360, 90, 28);
        ms1.setFont(new Font("Arial", Font.PLAIN, 14));
        ms1.setBackground(new Color(1,24,64));
        ms1.setForeground(Color.white);
        ms1.setFocusPainted(false);
        ms1.setBorder(BorderFactory.createLineBorder(bg, 1));
        add(ms1);

        ms2 = new JRadioButton("Unmarried");
        ms2.setBounds(380, 360, 100, 28);
        ms2.setFont(new Font("Arial", Font.PLAIN, 14));
        ms2.setBackground(new Color(1,24,64));
        ms2.setFocusPainted(false);
        ms2.setForeground(Color.white);
        ms2.setBorder(BorderFactory.createLineBorder(bg, 1));
        add(ms2);

        ms3 = new JRadioButton("Other");
        ms3.setBounds(480, 360, 80, 28);
        ms3.setFont(new Font("Arial", Font.PLAIN, 14));
        ms3.setBackground(new Color(1,24,64));
        ms3.setForeground(Color.white);
        ms3.setFocusPainted(false);
        ms3.setBorder(BorderFactory.createLineBorder(bg, 1));
        add(ms3);

        ButtonGroup msg = new ButtonGroup();
        msg.add(ms1);
        msg.add(ms2);
        msg.add(ms3);
    }


    private void createAddressFields() {
        JLabel labelAdd = new JLabel("Address :");
        labelAdd.setFont(new Font("Arial", Font.BOLD, 16));
        labelAdd.setBounds(100, 410, 120, 25);
        labelAdd.setForeground(Color.WHITE);
        add(labelAdd);

        textAdd = new JTextField();
        textAdd.setFont(new Font("Arial", Font.PLAIN, 14));
        textAdd.setBounds(280, 410, 400, 28);
        textAdd.setBorder(BorderFactory.createLoweredBevelBorder());
        textAdd.setBackground(Color.WHITE);
        textAdd.setForeground(Color.BLACK);
        textAdd.setBorder(BorderFactory.createLineBorder(bg, 1));
        add(textAdd);

        JLabel labelCity = new JLabel("City :");
        labelCity.setFont(new Font("Arial", Font.BOLD, 16));
        labelCity.setBounds(100, 460, 120, 25);
        labelCity.setForeground(Color.WHITE);
        add(labelCity);

        textCity = new JTextField();
        textCity.setFont(new Font("Arial", Font.PLAIN, 14));
        textCity.setBounds(280, 460, 400, 28);
        textCity.setBorder(BorderFactory.createLoweredBevelBorder());
        textCity.setBackground(Color.WHITE);
        textCity.setForeground(Color.BLACK);
        textCity.setBorder(BorderFactory.createLineBorder(bg, 1));
        add(textCity);

        JLabel labelPin = new JLabel("PIN Code :");
        labelPin.setFont(new Font("Arial", Font.BOLD, 16));
        labelPin.setBounds(100, 510, 120, 25);
        labelPin.setForeground(Color.WHITE);
        add(labelPin);

        textPin = new JTextField();
        textPin.setFont(new Font("Arial", Font.PLAIN, 14));
        textPin.setBounds(280, 510, 400, 28);
        textPin.setBorder(BorderFactory.createLoweredBevelBorder());
        textPin.setBackground(Color.WHITE);
        textPin.setForeground(Color.BLACK);
        textPin.setBorder(BorderFactory.createLineBorder(bg, 1));
        add(textPin);

        JLabel labelState = new JLabel("State :");
        labelState.setFont(new Font("Arial", Font.BOLD, 16));
        labelState.setBounds(100, 560, 120, 25);
        labelState.setForeground(Color.WHITE);
        add(labelState);

        textState = new JTextField();
        textState.setFont(new Font("Arial", Font.PLAIN, 14));
        textState.setBounds(280, 560, 400, 28);
        textState.setBorder(BorderFactory.createLoweredBevelBorder());
        textState.setBackground(Color.WHITE);
        textState.setForeground(Color.BLACK);
        textState.setBorder(BorderFactory.createLineBorder(bg, 1));
        add(textState);
    }

    private void createNextButton() {
        next = new JButton("NEXT");
        next.setFont(new Font("Arial", Font.BOLD, 14));
        next.setBackground(new Color(255, 185, 21));
        next.setForeground(new Color(1,24,64));
        next.setBounds(587, 610, 90, 30);
        next.setCursor(new Cursor(Cursor.HAND_CURSOR));
        next.setFocusPainted(false);
        next.addActionListener(this);
        next.setBorder(BorderFactory.createLineBorder(bg, 1));
        add(next);
    }

    private void setupLayout() {
        getContentPane().setBackground(new Color(1,24,64));
        setLayout(null);
    }

    private void setFrameProperties() {
        setSize(850, 690);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        getContentPane().setBackground(new Color(1,24,64));
    }

    private boolean validateFields() {
        String name = textName.getText().trim();
        String fname = textFName.getText().trim();
        String email = textEmail.getText().trim();
        String address = textAdd.getText().trim();
        String city = textCity.getText().trim();
        String pincode = textPin.getText().trim();
        String state = textState.getText().trim();
        Date selectedDate = dateChooser.getDate();

        if (name.isEmpty() || fname.isEmpty() || email.isEmpty() ||
                address.isEmpty() || city.isEmpty() || pincode.isEmpty() ||
                state.isEmpty() || selectedDate == null ||
                (!r1.isSelected() && !r2.isSelected()) ||
                (!ms1.isSelected() && !ms2.isSelected() && !ms3.isSelected())) {

            JOptionPane.showMessageDialog(this, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid email address", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!pincode.matches("\\d{6}")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid 6-digit PIN code", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            if (!validateFields()) {
                return;
            }

            if (connection == null) {
                JOptionPane.showMessageDialog(this, "Database connection failed!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String name = textName.getText().trim();
            String fname = textFName.getText().trim();
            String email = textEmail.getText().trim();
            String address = textAdd.getText().trim();
            String city = textCity.getText().trim();
            String pincode = textPin.getText().trim();
            String state = textState.getText().trim();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dob = sdf.format(dateChooser.getDate());

            String gender = r1.isSelected() ? "Male" : "Female";
            String marital = ms1.isSelected() ? "Married" :
                    ms2.isSelected() ? "Unmarried" : "Other";

            try {
                String query = "INSERT INTO signup VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = connection.prepareStatement(query);

                pstmt.setString(1, name);
                pstmt.setString(2, fname);
                pstmt.setString(3, dob);
                pstmt.setString(4, gender);
                pstmt.setString(5, email);
                pstmt.setString(6, marital);
                pstmt.setString(7, address);
                pstmt.setString(8, city);
                pstmt.setString(9, pincode);
                pstmt.setString(10, state);

                pstmt.executeUpdate();
                pstmt.close();

                new Signup2();
                setVisible(false);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Signup());
    }
}
