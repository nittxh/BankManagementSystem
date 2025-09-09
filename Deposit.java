package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String pin;
    TextField textField;
    JButton b1, b2;
    Color bg = new Color(65,125,128);
    Deposit(String pin){
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1100,650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1100,650);
        add(l3);

        JLabel label1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        label1.setForeground(Color.white);
        label1.setFont(new Font("System",Font.BOLD,12));
        label1.setBounds(325,150,400,45);
        l3.add(label1);

        textField = new TextField();
        textField.setBounds(335,190,220,25);
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.WHITE);
        textField.setFont(new Font("Raleway", Font.BOLD,16));
        l3.add(textField);

        b1 = new JButton("DEPOSIT");
        b1.setBounds(500,286,100,25);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(500,323,100,25);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        l3.add(b2);

        setLayout(null);
        setSize(1100,650);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String amount = textField.getText();
            Date date = new Date();
            if (e.getSource()==b1){
                if (textField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");
                } else {
                    Con c1 = new Con();
                    c1.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Deposit','"+amount+"')");
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" Deposit Successfully");
                    setVisible(false);
                    new main_class(pin);
                }
            } else if (e.getSource()==b2) {
                setVisible(false);
                new main_class(pin);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
