package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JLabel label1,label2,label3;
    JTextField textField2;
    JPasswordField passwordField3;
    JButton button1,button2,button3;

    Login(){
        super("Bank Management System");

        Color bg = new Color(255, 255, 255);
        Color bl = new Color(0,0,0);

        // Title - centered
        label1 = new JLabel("WELCOME TO ATM");
        label1.setForeground(Color.white);
        label1.setFont(new Font("AvantGrade",Font.BOLD,38));
        label1.setBounds(200,30,450,40);
        add(label1);

        // Card Number - aligned properly
        label2 = new JLabel("Card No: ");
        label2.setFont(new Font("Ralway",Font.BOLD,20));
        label2.setForeground(Color.white);
        label2.setBounds(200,130,100,30);
        add(label2);

        textField2 = new JTextField(15);
        textField2.setBounds(320,130,230,30);
        textField2.setFont(new Font("Arial", Font.BOLD,14));
        textField2.setBorder(BorderFactory.createLineBorder(bg, 1));
        add(textField2);

        // PIN - aligned with Card Number
        label3 = new JLabel("PIN: ");
        label3.setFont(new Font("Ralway",Font.BOLD,20));
        label3.setForeground(Color.white);
        label3.setBounds(200,180,100,30);
        add(label3);

        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(320,180,230,30);
        passwordField3.setFont(new Font("Arial", Font.BOLD,14));
        passwordField3.setBorder(BorderFactory.createLineBorder(bg, 1));
        add(passwordField3);

        // Buttons - symmetrical alignment
        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Arial",Font.BOLD,14));
        button1.setForeground(Color.white);
        button1.setBackground(Color.black);
        button1.addActionListener(this);
        button1.setBounds(320,250,100,30);
        button1.setBorder(BorderFactory.createLineBorder(bl, 1));
        button1.setFocusPainted(false);
        button1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(button1);

        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arial",Font.BOLD,14));
        button2.setForeground(Color.white);
        button2.setBackground(Color.black);
        button2.addActionListener(this);
        button2.setBounds(450,250,100,30);
        button2.setBorder(BorderFactory.createLineBorder(bl, 1));
        button2.setFocusPainted(false);
        button2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(button2);

        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial",Font.BOLD,14));
        button3.setForeground(Color.white);
        button3.setBackground(Color.black);
        button3.addActionListener(this);
        button3.setBorder(BorderFactory.createLineBorder(bl, 1));
        button3.setBounds(385,300,120,30);
        button3.setFocusPainted(false);
        button3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(button3);

        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image iii2 = iii1.getImage().getScaledInstance(850,500, Image.SCALE_SMOOTH);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0,0,850,500);
        add(iiimage);

        setLayout(null);
        setSize(850,500);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == button1){
                Con c = new Con();
                String cardno = textField2.getText();
                String pin = passwordField3.getText();
                String q = "select * from login where card_number='"+cardno+"' and pin ='"+pin+"'";
                ResultSet resultSet = c.statement.executeQuery(q);
                if (resultSet.next()){
                    setVisible(false);
                    new main_class(pin);
                } else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
                }
            } else if (e.getSource()==button2) {
                textField2.setText("");
                passwordField3.setText("");
            } else if (e.getSource()==button3) {
                new Signup();
                setVisible(false);
            }
        } catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
