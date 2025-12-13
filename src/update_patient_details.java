import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class update_patient_details extends JFrame {
    update_patient_details(){
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,150,200,200);
        panel.add(label);

        JLabel label1 = new JLabel("Update Patient Details");
        label1.setBounds(124,11,260,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2 = new JLabel("Name :");
        label2.setBounds(25,88,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,20));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(248,85,100,25);
        panel.add(choice);
        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM patient_info");
            while(resultSet.next()){
                choice.add(resultSet.getString("Name"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number :");
        label3.setBounds(25,129,200,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,20));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField textField = new JTextField();
        textField.setBounds(248,129,140,20);
        panel.add(textField);

        JLabel label4 = new JLabel("In-Time :");
        label4.setBounds(25,179,200,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,20));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textFieldtime = new JTextField();
        textFieldtime.setBounds(248,179,140,20);
        panel.add(textFieldtime);

        JLabel label5 = new JLabel("Amount Paid (Tk) :");
        label5.setBounds(25,219,200,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,20));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textFieldAmount = new JTextField();
        textFieldAmount.setBounds(248,219,140,20);
        panel.add(textFieldAmount);

        JLabel label6 = new JLabel("Amount-Due (Tk):");
        label6.setBounds(25,261,230,30);
        label6.setFont(new Font("Tahoma",Font.BOLD,20));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JTextField textFieldPending = new JTextField();
        textFieldPending.setBounds(248,265,140,20);
        panel.add(textFieldPending);

        JButton check = new JButton("CHECK");
        check.setBounds(281,378,89,23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    Conn c = new Conn();
                    String id = choice.getSelectedItem();
                    ResultSet resultSet = c.statement.executeQuery(
                            "SELECT * FROM patient_info WHERE Name = '" + id + "'"
                    );

                    if(resultSet.next()){
                        String room = resultSet.getString("Room_number");
                        String timer = resultSet.getString("Timer");
                        String deposit = resultSet.getString("Deposit");

                        textField.setText(room);
                        textFieldtime.setText(timer);
                        textFieldAmount.setText(deposit);

                        ResultSet resultSet1 = c.statement.executeQuery(
                                "SELECT * FROM Room WHERE Room_no = '" + room + "'"
                        );
                        if(resultSet1.next()){
                            String price = resultSet1.getString("Price");
                            int pendingAmount = Integer.parseInt(price) - Integer.parseInt(deposit);
                            textFieldPending.setText("" + pendingAmount);
                        }
                    }

                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        JButton Update = new JButton("Update");
        Update.setBounds(56,378,89,23);
        Update.setBackground(Color.BLACK);
        Update.setForeground(Color.WHITE);
        panel.add(Update);

        Update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    Conn c = new Conn();
                    String q = choice.getSelectedItem();
                    String room = textField.getText();
                    String timer = textFieldtime.getText();
                    String amount = textFieldAmount.getText();

                    c.statement.executeUpdate(
                            "UPDATE patient_info SET Room_number = '" + room + "', Timer = '" + timer + "', Deposit = '" + amount + "' WHERE Name = '" + q + "'"
                    );

                    JOptionPane.showMessageDialog(null, "Patient details updated successfully");

                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        JButton  back= new JButton("Back");
        back.setBounds(176,378,89,23);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
            }
        });
        setUndecorated(true);
        setSize(850,550);
        setLayout(null);
        setLocation(300,250);
        setVisible(true);
    }

    public static void main(String[] args){
        new update_patient_details();
    }
}
