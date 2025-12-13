import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Reception extends JFrame {
    Reception(){
        //panel design korechii
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,160,1525,670);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);
        //panel detioo tar kaj korsii.
        JPanel panel1=new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,1525,150);
        panel1.setBackground(new Color(109,164,170));
        add(panel1);
        //image add korbo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/dr.png"));
        Image image=i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(image);
        JLabel label=new JLabel(i2);
        label.setBounds(1150,0,250,250);
        panel1.add(label);
        //dashboard button is here.
        //add patient er ta eikhane.
        JButton btn1=new JButton("Add New Patient");
        btn1.setBounds(30,15,200,30);
        btn1.setBackground(new Color(246,215,118));
        panel1.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    new NEW_PATIENT();
            }
        });
        //sesh eikhane;
        //Room start korsi
        JButton btn2=new JButton("Room");
        btn2.setBounds(30,58,200,30);
        btn2.setBackground(new Color(246,215,118));
        panel1.add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    new Room();
            }
        });

    //room eikhane sesh
        //DepartMent add koro
                JButton btn3= new JButton("Department");
                btn3.setBounds(30,100,200,30);
                btn3.setBackground(new Color(246,215,118));
                panel1.add(btn3);
                btn3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                             new Department();
                    }
                });
        //dept sesh korsi.
        //use all employee info
        JButton btn4= new JButton("All Employee info");
        btn4.setBounds(270,15,200,30);
        btn4.setBackground(new Color(246,215,118));
        panel1.add(btn4);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    new Employee_info();
            }
        });
        //btn 4 sesh
        //patient info
        JButton btn5= new JButton("Patient info");
        btn5.setBounds(270,58,200,30);
        btn5.setBackground(new Color(246,215,118));
        panel1.add(btn5);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                        new ALL_Patient_Info();
            }
        });

    //patient info sesh
        //Patient discharge
        JButton btn6= new JButton("Patient Discharge");
        btn6.setBounds(270,100,200,30);
        btn6.setBackground(new Color(246,215,118));
        panel1.add(btn6);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    new patient_discharge();
            }
        });
        //upt patient details
        JButton btn7= new JButton("Update Patient Details");
        btn7.setBounds(510,15,200,30);
        btn7.setBackground(new Color(246,215,118));
        panel1.add(btn7);
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                        new update_patient_details();
            }
        });
        //upt pnt sesh
        //Hopistal amb
        JButton btn8= new JButton("Ambulance Service");
        btn8.setBounds(510,58,200,30);
        btn8.setBackground(new Color(246,215,118));
        panel1.add(btn8);
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    new Ambulance();
            }
        });
        //end hos amb
    //Search room
        JButton btn9= new JButton("Search Room");
        btn9.setBounds(510,100,200,30);
        btn9.setBackground(new Color(246,215,118));
        panel1.add(btn9);
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    new SearchRoom();
            }
        });
        //search room start from here
        //log out is here
        JButton btn10= new JButton("Log Out");
        btn10.setBounds(750,15,200,30);
        btn10.setBackground(new Color(246,215,118));
        panel1.add(btn10);
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    new Login();
            }
        });
        //log out end here.
        //amb two
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/amb.png"));
        Image image1 = i11.getImage().getScaledInstance(250,250, Image.SCALE_DEFAULT);
        ImageIcon i22 = new ImageIcon(image1);

        JLabel label1 = new JLabel(i22);
        label1.setBounds(950, -40, 300, 200);  // Move upward
        panel1.add(label1);





        //image add sesh
        setUndecorated(true);
        setSize(1950,1090);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Reception();
    }
}
