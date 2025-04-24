package daffodil.student.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateStudent extends JFrame implements ActionListener {
    JTextField tfname, taddress, tphone, taadhar, temail, tregnumber, tdepartment, tprogramme;
    JLabel tstudentid, tname, tdob;
    JButton update, back;
    String studentID;

    UpdateStudent(String studentID) {
        this.studentID = studentID;
        getContentPane().setBackground(new Color(163, 255, 188));

        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);

        tname = new JLabel();
        tname.setBounds(200, 150, 150, 30);
        tname.setBackground(new Color(177, 252, 197));
        add(tname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        tfname.setBackground(new Color(177, 252, 197));
        add(tfname);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(dob);

        tdob = new JLabel();
        tdob.setBounds(200, 200, 150, 30);
        tdob.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(tdob);

        JLabel regnumber = new JLabel("Reg. Number");
        regnumber.setBounds(400, 200, 150, 30);
        regnumber.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(regnumber);

        tregnumber = new JTextField();
        tregnumber.setBounds(600, 200, 150, 30);
        tregnumber.setBackground(new Color(177, 252, 197));
        add(tregnumber);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        taddress.setBackground(new Color(177, 252, 197));
        add(taddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600, 250, 150, 30);
        tphone.setBackground(new Color(177, 252, 197));
        add(tphone);

        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(email);

        temail = new JTextField();
        temail.setBounds(200, 300, 150, 30);
        temail.setBackground(new Color(177, 252, 197));
        add(temail);

        JLabel programme = new JLabel("Programme");
        programme.setBounds(400, 300, 150, 30);
        programme.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(programme);

        tprogramme = new JTextField();
        tprogramme.setBounds(600, 300, 150, 30);
        tprogramme.setBackground(new Color(177, 252, 197));
        add(tprogramme);

        JLabel aadhar = new JLabel("ID Number");
        aadhar.setBounds(400, 350, 150, 30);
        aadhar.setFont(new Font("SAN_SERIF Петра", Font.BOLD, 20));
        add(aadhar);

        taadhar = new JTextField();
        //taadhar = new JLabel();
        taadhar.setBounds(600, 350, 150, 30);
        taadhar.setBackground(new Color(177, 252, 197));
        add(taadhar);

        JLabel studentid = new JLabel("Student ID");
        studentid.setBounds(50, 400, 150, 30);
        studentid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(studentid);

        tstudentid = new JLabel();
        tstudentid.setBounds(200, 400, 150, 30);
        tstudentid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tstudentid.setForeground(Color.RED);
        add(tstudentid);

        JLabel department = new JLabel("Department");
        department.setBounds(50, 350, 150, 30);
        department.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(department);

        tdepartment = new JTextField();
        tdepartment.setBounds(200, 350, 150, 30);
        tdepartment.setBackground(new Color(177, 252, 197));
        add(tdepartment);

        try {
            DatabaseConnection c = new DatabaseConnection();
            String query = "SELECT * FROM student WHERE studentID = '" + studentID + "'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()) {
                tname.setText(resultSet.getString("name"));
                tfname.setText(resultSet.getString("fname"));
                tdob.setText(resultSet.getString("dob"));
                taddress.setText(resultSet.getString("address"));
                tregnumber.setText(resultSet.getString("regnumber"));
                tphone.setText(resultSet.getString("phone"));
                temail.setText(resultSet.getString("email"));
                tprogramme.setText(resultSet.getString("programme"));
                taadhar.setText(resultSet.getString("aadhar"));
                tstudentid.setText(resultSet.getString("studentID"));
                tdepartment.setText(resultSet.getString("department"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        update = new JButton("UPDATE");
        update.setBounds(450, 550, 150, 40);
        update.setBackground(Color.black);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        back = new JButton("BACK");
        back.setBounds(250, 550, 150, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLayout(null);
        setLocation(300, 50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {
            String fname = tfname.getText();
            String regnumber = tregnumber.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String programme = tprogramme.getText();
            String department = tdepartment.getText();

            try {
                DatabaseConnection c = new DatabaseConnection();
                String query = "UPDATE student SET fname = '" + fname + "', regnumber = '" + regnumber + "', address = '" + address + "', phone = '" + phone + "', email = '" + email + "', programme = '" + programme + "', department = '" + department + "' WHERE studentID = '" + studentID + "'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Student details updated successfully");
                setVisible(false);
                new MainFrame();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            setVisible(false);
            new ViewStudent();
        }
    }

    public static void main(String[] args) {
        new UpdateStudent("");
    }
}