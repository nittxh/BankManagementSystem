package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JLabel label2;
    JButton b1;
    String pin;
    BalanceEnquiry(String pin){
        this.pin = pin;


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1100,650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1100,650);
        add(l3);


        JLabel label1 = new JLabel("Your current balance is Rs ");
        label1.setForeground(Color.white);
        label1.setFont(new Font("System",Font.BOLD,16));
        label1.setBounds(335,140,400,45);
        l3.add(label1);

        label2 = new JLabel();
        label2.setForeground(Color.white);
        label2.setFont(new Font("System",Font.BOLD,22));
        label2.setBounds(335,185,200,45);
        l3.add(label2);

        b1 = new JButton("Back");
        b1.setBounds(470,323,130,25);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        l3.add(b1);


        int balance = 0;
        try {
            Con con = new Con();
            ResultSet resultSet = con.statement.executeQuery("select * from bank where pin='"+pin+"'");
            while (resultSet.next()){
                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        label2.setText(""+balance);


        setLayout(null);
        setSize(1100,650);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new main_class(pin);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
