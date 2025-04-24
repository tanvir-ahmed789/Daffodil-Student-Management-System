package daffodil.student.management.system;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewStudent extends JFrame implements ActionListener {
    JTable table;
    Choice choiceStudent;
    JButton searchBtn, print, update, back;

    ViewStudent() {
        getContentPane().setBackground(new Color(255, 131, 122));
        JLabel search = new JLabel("Search by Student ID");
        search.setBounds(20, 20, 150, 20);
        add(search);

        choiceStudent = new Choice();
        choiceStudent.setBounds(180, 20, 150, 20);
        add(choiceStudent);

        try {
            DatabaseConnection c = new DatabaseConnection();
            ResultSet resultSet = c.statement.executeQuery("select * from student");
            while (resultSet.next()) {
                choiceStudent.add(resultSet.getString("studentID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        try {
            DatabaseConnection c = new DatabaseConnection();
            ResultSet resultSet = c.statement.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0, 100, 900, 600);
        add(jp);

        searchBtn = new JButton("Search");
        searchBtn.setBounds(20, 70, 80, 20);
        searchBtn.addActionListener(this);
        add(searchBtn);

        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLayout(null);
        setLocation(300, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchBtn) {
            String query = "select * from student where studentID = '" + choiceStudent.getSelectedItem() + "'";
            try {
                DatabaseConnection c = new DatabaseConnection();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try {
                table.print();
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == update) {
            setVisible(false);
            new UpdateStudent(choiceStudent.getSelectedItem());
        } else {
            setVisible(false);
            new MainFrame();
        }
    }

    public static void main(String[] args) {
        new ViewStudent();
    }
}