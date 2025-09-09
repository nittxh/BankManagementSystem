package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton s, c;

    Signup3() {
        setLayout(null);
        setSize(850,690);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(new Color(1, 24, 64));

        Color bg = new Color(1,24,64);

        // Centered heading
        JLabel l1 = new JLabel("ACCOUNT DETAILS");
        l1.setFont(new Font("Manrope", Font.BOLD, 28));
        l1.setBounds(270, 30, 850, 40);
        l1.setForeground(new Color(255, 185, 21));
        add(l1);

        // Account type section
        JLabel l2 = new JLabel("Account type :");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));
        l2.setBounds(100,100,200,30);
        l2.setForeground(Color.WHITE);
        add(l2);

        r1 = new JRadioButton("Saving Account");
        r2 = new JRadioButton("Fixed Deposit Account");
        r3 = new JRadioButton("Current Account");
        r4 = new JRadioButton("Recurring deposit Account");
        JRadioButton[] radios = {r1, r2, r3, r4};
        int radioStartY = 140;
        for(int i=0; i<radios.length; i++) {
            radios[i].setFont(new Font("Raleway", Font.PLAIN, 16));
            radios[i].setBackground(new Color(1, 24, 64));
            radios[i].setBounds(100 + (i%2)*350, radioStartY + (i/2)*40, 250, 30);
            radios[i].setForeground(Color.WHITE);
            add(radios[i]);
        }
        ButtonGroup buttonGroup = new ButtonGroup();
        for(JRadioButton btn : radios) buttonGroup.add(btn);

        // Card number section
        JLabel l3 = new JLabel("Card No :");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        l3.setBounds(100,230,150,30);
        l3.setForeground(Color.WHITE);
        add(l3);

        JLabel l5 = new JLabel("XXXX-XXXX-XXXX-4841");
        l5.setFont(new Font("Raleway", Font.BOLD, 18));
        l5.setBounds(320,230,250,30);
        l5.setForeground(Color.WHITE);
        add(l5);

        JLabel l4 = new JLabel("(Your 16-Digits Card Number)");
        l4.setFont(new Font("Raleway", Font.PLAIN, 10));
        l4.setBounds(100,250,200,20);
        l4.setForeground(Color.WHITE);
        add(l4);

        JLabel l6 = new JLabel("(It would appear on atm card/cheque book and statements)");
        l6.setFont(new Font("Raleway", Font.PLAIN, 10));
        l6.setBounds(320,250,350,20);
        l6.setForeground(Color.WHITE);
        add(l6);

        // PIN section
        JLabel l7 = new JLabel("PIN :");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));
        l7.setBounds(100,280,150,30);
        l7.setForeground(Color.WHITE);
        add(l7);

        JLabel l8 = new JLabel("XXXX");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        l8.setBounds(320,280,100,30);
        l8.setForeground(Color.WHITE);
        add(l8);

        JLabel l9 = new JLabel("(4-digit Password)");
        l9.setFont(new Font("Raleway", Font.PLAIN, 12));
        l9.setBounds(100,300,200,30);
        l9.setForeground(Color.WHITE);
        add(l9);

        // Services required section
        JLabel l10 = new JLabel("Services Required :");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));
        l10.setBounds(100,340,250,30);
        l10.setForeground(Color.WHITE);
        add(l10);

        // Two columns for checkboxes
        c1 = new JCheckBox("ATM CARD");
        c2 = new JCheckBox("Internet Banking");
        c3 = new JCheckBox("Mobile Banking");
        c4 = new JCheckBox("Email Alerts");
        c5 = new JCheckBox("Cheque Book");
        c6 = new JCheckBox("E-Statement");

        JCheckBox[] col1 = {c1, c3, c5};
        JCheckBox[] col2 = {c2, c4, c6};

        for(int i=0; i<col1.length; i++) {
            col1[i].setFont(new Font("Raleway", Font.PLAIN, 16));
            col1[i].setBackground(new Color(1, 24, 64));
            col1[i].setForeground(Color.WHITE);
            col1[i].setBounds(100, 380 + i*50, 200, 30);
            add(col1[i]);
        }
        for(int i=0; i<col2.length; i++) {
            col2[i].setFont(new Font("Raleway", Font.PLAIN, 16));
            col2[i].setBackground(new Color(1, 24, 64));
            col2[i].setForeground(Color.WHITE);
            col2[i].setBounds(350, 380 + i*50, 200, 30);
            add(col2[i]);
        }

        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.", true);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBackground(new Color(1, 24, 64));
        c7.setForeground(Color.WHITE);
        c7.setBounds(100,550,650,20);
        add(c7);

        // Centered buttons
        s = new JButton("Submit");
        s.setFont(new Font("Raleway", Font.BOLD,14));
        s.setBackground(new Color(255, 185, 21));
        s.setForeground(new Color(1, 24, 64));
        s.setBounds(250,600,120,40);
        s.setFocusPainted(false);
        s.setCursor(new Cursor(Cursor.HAND_CURSOR));
        s.addActionListener(this);
        s.setBorder(BorderFactory.createLineBorder(bg, 1));
        add(s);

        c = new JButton("Cancel");
        c.setFont(new Font("Raleway", Font.BOLD,14));
        c.setBackground(new Color(255, 185, 21));
        c.setForeground(new Color(1, 24, 64));
        c.setBounds(480,600,120,40);
        c.setFocusPainted(false);
        c.setCursor(new Cursor(Cursor.HAND_CURSOR));
        c.addActionListener(this);
        c.setBorder(BorderFactory.createLineBorder(bg, 1));
        add(c);

        setVisible(true);
        getContentPane().requestFocusInWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String aType = "";
        if (r1.isSelected()){
            aType = "Saving Account";
        } else if (r2.isSelected()) {
            aType = "Fixed Deposit Account";
        } else if (r3.isSelected()) {
            aType = "Current Account";
        } else if (r4.isSelected()) {
            aType = "Recurring deposit Account";
        }

        Random ran = new Random();
        long first7 = (ran.nextLong()%90000000L) + 1409963000000000L;
        String cardno = "" + Math.abs(first7);

        long first3 = (ran.nextLong()%9000L) + 1000L;
        String pin = "" + Math.abs(first3);


        String fac = "";
        if (c1.isSelected()){
            fac += "ATM CARD";
        } else if (c2.isSelected()) {
            fac += "Internet Banking";
        } else if (c3.isSelected()) {
            fac += "Mobile Banking";
        } else if (c4.isSelected()) {
            fac += "Email Alerts";
        } else if (c5.isSelected()) {
            fac += "Cheque Book";
        } else if (c6.isSelected()) {
            fac += "E-Statement";
        }

        try {
            if (e.getSource()==s){
                if (aType.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Fill all the fields");
                } else {
                    Con c1 = new Con();
                    String q1 = "insert into signupthree values('"+aType+"','"+cardno+"','"+pin+"','"+fac+"')";
                    String q2 = "insert into login values('"+cardno+"','"+pin+"')";
                    c1.statement.executeUpdate(q1);
                    c1.statement.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null,"Card Number : "+cardno+"\n Pin : "+pin);
                    new Deposit(pin);
                    setVisible(false);
                }
            } else if (e.getSource()==c) {
                System.exit(0);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Signup3();
    }
}
