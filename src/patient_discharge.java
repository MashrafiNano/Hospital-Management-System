import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class patient_discharge extends JFrame {
    patient_discharge(){
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);
        //check out korvo
        JLabel label=new JLabel("Check Out");
        label.setBounds(100,20,150,20);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setBackground(Color.WHITE);
        panel.add(label);

        JLabel label2=new JLabel("Customer Id");
        label2.setBounds(30,80,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setBackground(Color.WHITE);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(200,80,150,20);
        panel.add(choice);
        try{
            Conn c= new Conn();
            ResultSet resultSet = c.statement.executeQuery("select *from patient_info");
            while(resultSet.next()){
                choice.add(resultSet.getString("number"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }



        JLabel label3=new JLabel("Room Number");
        label3.setBounds(30,130,150,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setBackground(Color.WHITE);
        panel.add(label3);

        JLabel RNo=new JLabel();
        RNo.setBounds(200,130,150,20);
        RNo.setFont(new Font("Tahoma",Font.BOLD,14));
        RNo.setBackground(Color.WHITE);
        panel.add(RNo);

        JLabel label4=new JLabel("In Time");
        label4.setBounds(30,180,150,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setBackground(Color.WHITE);
        panel.add(label4);

        JLabel label5=new JLabel("Out Time");
        label5.setBounds(30,230,150,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setBackground(Color.WHITE);
        panel.add(label5);

        Date date=new Date();
        JLabel OUTTime=new JLabel(" " + date);
        OUTTime.setBounds(200,230,250,20);
        OUTTime.setFont(new Font("Tahoma",Font.BOLD,14));
        OUTTime.setForeground(Color.WHITE);
        panel.add(OUTTime);

        JLabel INTime=new JLabel();
        INTime.setBounds(200,180,250,20);
        INTime.setFont(new Font("Tahoma",Font.BOLD,14));
        INTime.setBackground(Color.WHITE);
        panel.add(INTime);

        JButton discharge=new JButton("Discharge");
        discharge.setBounds(30,300,120,30);
        discharge.setBackground(Color.BLACK);
        discharge.setForeground(Color.WHITE);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Conn c=new Conn();
                try {
                    c.statement.executeUpdate("DELETE FROM patient_info WHERE Number = '" + choice.getSelectedItem() + "'");
                    c.statement.executeUpdate("UPDATE Room SET Availability = 'Available' WHERE Room_no = '" + RNo.getText() + "'");
                    JOptionPane.showMessageDialog(null, "Done");
                    setVisible(false);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        JButton check=new JButton("Check");
        check.setBounds(170,300,120,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Conn c= new Conn();
                try{

                    ResultSet resultSet = c.statement.executeQuery(
                            "SELECT * FROM patient_info WHERE number = '" + choice.getSelectedItem() + "'"
                    );
                    while(resultSet.next()){
                        RNo.setText(resultSet.getString("Room_number"));
                        INTime.setText(resultSet.getString("Timer"));
                    }

                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        JButton Back=new JButton("Back");
        Back.setBounds(300,300,120,30);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        panel.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(850, 550);
        setLayout(null);
        setLocation(300, 250);
        setVisible(true);
    }
    public static void main(String[] args){
        new patient_discharge();
    }
}
