package daffodil.student.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AssignCourse extends JFrame implements ActionListener {
    Choice choiceStudent, choiceCourse;
    JButton assign, back;

    AssignCourse() {
        setLayout(null);

        JLabel heading = new JLabel("Assign Course to Student");
        heading.setBounds(120, 20, 300, 30);
        heading.setFont(new Font("Raleway", Font.BOLD, 20));
        add(heading);

        JLabel studentLabel = new JLabel("Select Student ID:");
        studentLabel.setBounds(50, 80, 150, 20);
        add(studentLabel);

        choiceStudent = new Choice();
        choiceStudent.setBounds(200, 80, 150, 20);
        add(choiceStudent);

        JLabel courseLabel = new JLabel("Select Course:");
        courseLabel.setBounds(50, 120, 150, 20);
        add(courseLabel);

        choiceCourse = new Choice();
        choiceCourse.setBounds(200, 120, 150, 20);
        add(choiceCourse);

        try {
            DatabaseConnection c = new DatabaseConnection();
            ResultSet rs1 = c.statement.executeQuery("SELECT studentID FROM student");
            while (rs1.next()) {
                choiceStudent.add(rs1.getString("studentID"));
            }

            ResultSet rs2 = c.statement.executeQuery("SELECT courseName FROM courses");
            while (rs2.next()) {
                choiceCourse.add(rs2.getString("courseName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        assign = new JButton("Assign");
        assign.setBounds(80, 180, 100, 30);
        assign.addActionListener(this);
        add(assign);

        back = new JButton("Back");
        back.setBounds(220, 180, 100, 30);
        back.addActionListener(this);
        add(back);

        setSize(400, 300);
        setLocation(500, 250);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == assign) {
            String studentID = choiceStudent.getSelectedItem();
            String course = choiceCourse.getSelectedItem();

            try {
                DatabaseConnection c = new DatabaseConnection();
                String query = "INSERT INTO assigned_courses (studentID, courseName) VALUES ('" + studentID + "', '" + course + "')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Course Assigned Successfully!");
                setVisible(false);
                new MainFrame();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new MainFrame();
        }
    }

    public static void main(String[] args) {
        new AssignCourse();
    }
}