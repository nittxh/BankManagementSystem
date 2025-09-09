package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class mini extends JFrame implements ActionListener {
    String pin;
    JButton button;
    mini(String pin){
        this.pin = pin;

        setSize(400,600);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255,204,204));
        setLayout(null);

        JLabel label1 = new JLabel();
        label1.setBounds(20,100,400,260);
        add(label1);

        JLabel label3 = new JLabel();
        label3.setBounds(20,20,300,60);
        add(label3);

        JLabel label4 = new JLabel();
        label4.setBounds(20,400,300,40);
        add(label4);




        try {
            Con con = new Con();
            ResultSet resultSet = con.statement.executeQuery("select * from login where pin='"+pin+"'");
            while (resultSet.next()){
                label3.setText("Card Number: "+resultSet.getString("card_number").substring(0,4)+"XXXXXXXX"+resultSet.getString("card_number").substring(12));
            }
        } catch (Exception E){
            E.printStackTrace();
        }

        try {
            int balance = 0;
            Con con = new Con();
            ResultSet resultSet = con.statement.executeQuery("select * from bank where pin='"+pin+"'");
            while (resultSet.next()){
                label1.setText(label1.getText()+"<html>"+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+"<br><br><html>");
                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }

            label4.setText("Your total balance is Rs. "+balance);

        } catch (Exception E){
            E.printStackTrace();
        }

        button = new JButton("EXIT");
        button.setBounds(20,500,100,25);
        button.addActionListener(this);
        button.setBackground(new Color(1,24,64));
        button.setForeground(new Color(255, 185, 21));
        add(button);


        setFocusable(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new mini("");
    }
}
