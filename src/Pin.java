package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {
    JButton b1,b2;
    JPasswordField p1,p2;
    String pin;

    Pin(String pin){
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1100,650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1100,650);
        add(l3);

        JLabel label1 = new JLabel("CHANGE YOUR PIN");
        label1.setForeground(Color.white);
        label1.setFont(new Font("System",Font.BOLD,22));
        label1.setBounds(345,110,400,45);
        l3.add(label1);

        JLabel label2 = new JLabel("NEW PIN: ");
        label2.setForeground(Color.white);
        label2.setFont(new Font("System",Font.BOLD,14));
        label2.setBounds(295,170,200,25);
        l3.add(label2);

        p1 = new JPasswordField();
        p1.setBounds(460,175,140,20);
        p1.setBackground(new Color(65,125,128));
        p1.setForeground(Color.WHITE);
        p1.setFont(new Font("Raleway", Font.BOLD,16));
        l3.add(p1);

        JLabel label3 = new JLabel("RE-ENTER NEW PIN: ");
        label3.setForeground(Color.white);
        label3.setFont(new Font("System",Font.BOLD,14));
        label3.setBounds(295,215,200,20);
        l3.add(label3);

        p2 = new JPasswordField();
        p2.setBounds(460,215,140,20);
        p2.setBackground(new Color(65,125,128));
        p2.setForeground(Color.WHITE);
        p2.setFont(new Font("Raleway", Font.BOLD,16));
        l3.add(p2);


        b1 = new JButton("CHANGE");
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
            String pin1 = p1.getText();
            String pin2 = p2.getText();

            if (!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null,"Entered PIN doesn't match!");
                return;
            }
            if (e.getSource()==b1){
                if (p1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter new PIN");
                    return;
                }
                if (p2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Re-enter new PIN");
                    return;
                }

                Con con = new Con();
                String q1 = "update bank set pin='"+pin1+"' where pin='"+pin+"'";
                String q2 = "update login set pin='"+pin1+"' where pin='"+pin+"'";
                String q3 = "update signupthree set pin='"+pin1+"' where pin='"+pin+"'";


                con.statement.executeUpdate(q1);
                con.statement.executeUpdate(q2);
                con.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null,"PIN changed successfully");
                setVisible(false);
                new main_class(pin);

            } else if (e.getSource()==b2) {
                new main_class(pin);
                setVisible(false);
            }

        } catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Pin("");
    }
}
