package bank.management.system;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {

    String pin;
    TextField textField;
    JButton b1, b2;

    Withdrawl(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1100,650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1100,650);
        add(l3);


        JLabel label1 = new JLabel("MAXIMUM WITHDRAWL IS Rs.10,000");
        label1.setForeground(Color.white);
        label1.setFont(new Font("System",Font.BOLD,12));
        label1.setBounds(335,120,400,45);
        l3.add(label1);

        JLabel label2 = new JLabel("Please enter your amount");
        label2.setForeground(Color.white);
        label2.setFont(new Font("System",Font.BOLD,12));
        label2.setBounds(365,165,200,45);
        l3.add(label2);

        textField = new TextField();
        textField.setBounds(335,210,220,25);
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.WHITE);
        textField.setFont(new Font("Raleway", Font.BOLD,16));
        l3.add(textField);

        b1 = new JButton("WITHDRAW");
        b1.setBounds(470,286,130,25);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(470,323,130,25);
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

        if (e.getSource()==b1){
            try {
                String amount = textField.getText();
                Date date = new Date();
                if (textField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdraw");
                } else {
                    Con con = new Con();
                    ResultSet resultset = con.statement.executeQuery("select * from bank where pin='"+pin+"'");
                    int balance = 0;
                    while (resultset.next()){
                        if (resultset.getString("type").equals("Deposit")){
                            balance += Integer.parseInt(resultset.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultset.getString("amount"));
                        }
                    }

                    if (balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insufficient balance");
                        return;
                    }
                    con.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Withdrawl','"+amount+"')");
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" debited successfully");
                    setVisible(false);
                    new main_class(pin);
                }
            }   catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource()==b2){
            setVisible(false);
            new main_class(pin);
        }
    }

    public static void main(String[] args) {
        new Withdrawl("");
    }
}
