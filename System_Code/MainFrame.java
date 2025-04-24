package daffodil.student.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    MainFrame() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/main.gif"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 1120, 630);
        add(img);

        JLabel heading = new JLabel("Daffodil Student Management System");
        heading.setBounds(340, 155, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        img.add(heading);

        JButton add = new JButton("Add Student");
        add.setBounds(335, 270, 150, 40);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.black);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddStudent();
                setVisible(false);
            }
        });
        img.add(add);

        JButton view = new JButton("View Student");
        view.setBounds(565, 270, 150, 40);
        view.setForeground(Color.WHITE);
        view.setBackground(Color.black);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewStudent();
                setVisible(false);
            }
        });
        img.add(view);

        JButton rem = new JButton("Remove Student");
        rem.setBounds(440, 370, 150, 40);
        rem.setForeground(Color.WHITE);
        rem.setBackground(Color.black);
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveStudent();
            }
        });
        img.add(rem);

        JButton assignCourse = new JButton("Assign Course");
        assignCourse.setBounds(440, 450, 150, 40);
        assignCourse.setForeground(Color.WHITE);
        assignCourse.setBackground(Color.black);
        assignCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AssignCourse();
                setVisible(false);
            }
        });
        img.add(assignCourse);

        setSize(1120, 630);
        setLocation(250, 100);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}