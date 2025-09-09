package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup2 extends JFrame implements ActionListener {
    JComboBox comboBox, comboBox2, comboBox3, comboBox4, comboBox5;
    JTextField textPan, textAadhar;
    JRadioButton r1, r2, e1, e2;
    JButton next;

    Signup2(){

        super("form");

        Color bg = new Color(1, 24, 64);


        JLabel l1 = new JLabel("ADDITIONAL DETAILS");
        l1.setFont(new Font("Arial", Font.BOLD,28));
        l1.setBounds(260,40,400,48);
        l1.setForeground(new Color(255, 185, 21));
        add(l1);

        JLabel l2 = new JLabel("Religion :");
        l2.setFont(new Font("Raleway", Font.BOLD,18));
        l2.setBounds(100,140,100,30);
        l2.setForeground(Color.WHITE);
        add(l2);

        String religion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        comboBox = new JComboBox(religion);
        comboBox.setBackground(Color.WHITE);
        comboBox.setForeground(Color.DARK_GRAY);
        comboBox.setFont(new Font("SansSerif", Font.PLAIN,15));
        comboBox.setBounds(350,140,320,30);
        add(comboBox);

        JLabel l3 = new JLabel("Category :");
        l3.setFont(new Font("Raleway", Font.BOLD,18));
        l3.setBounds(100,190,100,30);
        l3.setForeground(Color.WHITE);
        add(l3);

        String category[] = {"General","OBC", "SC", "ST" , "Other"};
        comboBox2 = new JComboBox(category);
        comboBox2.setBackground(Color.WHITE);
        comboBox2.setForeground(Color.DARK_GRAY);
        comboBox2.setFont(new Font("SansSerif", Font.PLAIN,15));
        comboBox2.setBounds(350,190,320,30);
        add(comboBox2);

        JLabel l4 = new JLabel("Income :");
        l4.setFont(new Font("Raleway", Font.BOLD,18));
        l4.setBounds(100,240,100,30);
        l4.setForeground(Color.WHITE);
        add(l4);

        String income[] = {"Null","<1,50,000", "<2,50,000", "<5,00,000" , "upto 10,00,000", "Above 10,00,000"};
        comboBox3 = new JComboBox(income);
        comboBox3.setBackground(Color.WHITE);
        comboBox3.setForeground(Color.DARK_GRAY);
        comboBox3.setFont(new Font("SansSerif", Font.PLAIN,15));
        comboBox3.setBounds(350,240,320,30);
        add(comboBox3);

        JLabel l5 = new JLabel("Education :");
        l5.setFont(new Font("Raleway", Font.BOLD,18));
        l5.setBounds(100,290,150,30);
        l5.setForeground(Color.WHITE);
        add(l5);

        String education[] = {"Non-Graduate","Graduation", "Post Graduation", "Doctrate" , "Other"};
        comboBox4 = new JComboBox(education);
        comboBox4.setBackground(Color.WHITE);
        comboBox4.setForeground(Color.DARK_GRAY);
        comboBox4.setFont(new Font("SansSerif", Font.PLAIN,15));
        comboBox4.setBounds(350,290,320,30);
        add(comboBox4);

        JLabel l6 = new JLabel("Occupation :");
        l6.setFont(new Font("Raleway", Font.BOLD,18));
        l6.setBounds(100,340,150,30);
        l6.setForeground(Color.WHITE);
        add(l6);

        String occupation[] = {"Salaried","Self employed", "Business", "Student" , "Retired", "Other"};
        comboBox5 = new JComboBox(occupation);
        comboBox5.setBackground(Color.WHITE);
        comboBox5.setForeground(Color.DARK_GRAY);
        comboBox5.setFont(new Font("SansSerif", Font.PLAIN,15));
        comboBox5.setBounds(350,340,320,30);
        comboBox5.setBorder(BorderFactory.createLineBorder(bg, 1));
        add(comboBox5);

        JLabel l7 = new JLabel("PAN No :");
        l7.setFont(new Font("Raleway", Font.BOLD,18));
        l7.setBounds(100,390,150,30);
        l7.setForeground(Color.WHITE);
        add(l7);

        textPan = new JTextField();
        textPan.setFont(new Font("Raleway", Font.BOLD,18));
        textPan.setBounds(350,390,320,30);
        textPan.setBorder(BorderFactory.createLineBorder(bg, 1));
        add(textPan);

        JLabel l8 = new JLabel("Aadhar No :");
        l8.setFont(new Font("Raleway", Font.BOLD,18));
        l8.setBounds(100,440,200,30);
        l8.setForeground(Color.WHITE);
        add(l8);

        textAadhar = new JTextField();
        textAadhar.setFont(new Font("Raleway", Font.BOLD,18));
        textAadhar.setBounds(350,440,320,30);
        textAadhar.setBorder(BorderFactory.createLineBorder(bg, 1));
        add(textAadhar);

        JLabel l9 = new JLabel("Senior Citizen :");
        l9.setFont(new Font("Raleway", Font.BOLD,18));
        l9.setBounds(100,490,180,30);
        l9.setForeground(Color.WHITE);
        add(l9);

        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway", Font.BOLD,18));
        r1.setBackground(new Color(1, 24, 64));
        r1.setBounds(350,490,100,30);
        r1.setForeground(Color.WHITE);
        r1.setBorder(BorderFactory.createLineBorder(r1.getBackground(), 1));
        add(r1);

        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway", Font.BOLD,18));
        r2.setBackground(new Color(1, 24, 64));
        r2.setBounds(460,490,100,30);
        r2.setForeground(Color.WHITE);
        r2.setBorder(BorderFactory.createLineBorder(r1.getBackground(), 1));
        add(r2);

        JLabel l10 = new JLabel("Existing Account :");
        l10.setFont(new Font("Raleway", Font.BOLD,18));
        l10.setBounds(100,540,180,30);
        l10.setForeground(Color.WHITE);
        add(l10);

        e1 = new JRadioButton("Yes");
        e1.setFont(new Font("Raleway", Font.BOLD,18));
        e1.setBackground(new Color(1, 24, 64));
        e1.setBounds(350,540,100,30);
        e1.setForeground(Color.WHITE);
        add(e1);

        e2 = new JRadioButton("No");
        e2.setFont(new Font("Raleway", Font.BOLD,18));
        e2.setBackground(new Color(1, 24, 64));
        e2.setBounds(460,540,100,30);
        e2.setForeground(Color.WHITE);
        add(e2);

        ButtonGroup sc = new ButtonGroup();
        sc.add(r1);
        sc.add(r2);

        ButtonGroup ae = new ButtonGroup();
        ae.add(e1);
        ae.add(e2);

        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 16));
        next.setBackground(new Color(255, 185, 21));
        next.setForeground(new Color(1, 24, 64));
        next.setBounds(575,590,90,30);
        next.addActionListener(this);
        next.setCursor(new Cursor(Cursor.HAND_CURSOR));
        next.setFocusPainted(false);
        next.setBorder(BorderFactory.createLineBorder(bg, 1));
        add(next);

        setLayout(null);
        setSize(850,690);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(new Color(1, 24, 64));
        getContentPane().requestFocusInWindow();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String rel = (String) comboBox.getSelectedItem();
        String cat = (String) comboBox2.getSelectedItem();
        String inc = (String) comboBox3.getSelectedItem();
        String edu = (String) comboBox4.getSelectedItem();
        String occ = (String) comboBox5.getSelectedItem();
        String pan = textPan.getText();
        String aadhar = textAadhar.getText();

        String sCitizen = " ";
        if (r1.isSelected()){
            sCitizen = "yes";
        } else if (r2.isSelected()) {
            sCitizen = "no";
        }

        String eAccount = " ";
        if (e1.isSelected()){
            eAccount = "yes";
        } else if (e2.isSelected()) {
            eAccount = "no";
        }

        try {
            if (textPan.getText().isEmpty() || textAadhar.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Fill all the fields");
            } else {
                Con c1 = new Con();
                String q = "insert into signuptwo values('"+rel+"','"+cat+"','"+inc+"','"+edu+"','"+occ+"','"+pan+"','"+aadhar+"','"+sCitizen+"','"+eAccount+"')";
                c1.statement.executeUpdate(q);
                new Signup3();
                setVisible(false);
            }
        } catch (Exception Ex){
            Ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Signup2();
    }
}
