package com.secProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UI implements ActionListener {
    JFrame f ;
    JLabel l1,l2,l3;
    JTextField t1;
    JButton b1,b2;
    JPanel p1 ;
    UI() {

        b1 = new JButton("Rules");
        b1.setBounds(35, 300, 120, 25);
        b1.setBackground(new Color(0, 0, 0));
        b1.setForeground(new Color(225, 225, 225));
        b1.setFocusable(false);
        b1.addActionListener(this);

        b2 = new JButton("Exit");
        b2.setBounds(215, 300, 120, 25);
        b2.setBackground(new Color(0, 0, 0));
        b2.setForeground(new Color(225, 225, 225));
        b2.setFocusable(false);
        b2.addActionListener(this);

        t1 = new JTextField();
        t1.setBounds(30, 230, 300, 25);
        t1.setFont(new Font("Times New Roman ", Font.PLAIN, 18));

        l3 = new JLabel("Enter your name");
        l3.setFont(new Font("Mongolian Bait", Font.BOLD, 18));
        l3.setForeground(new Color(0, 0, 0));
        l3.setBounds(100, 180, 300, 20);

        l2 = new JLabel("INTELLIGENCE QUESTIONS");
        l2.setFont(new Font("BoldItalic", Font.BOLD, 25));
        l2.setForeground(new Color(0, 0, 0));
        l2.setBounds(20, 80, 340, 45);

        ImageIcon i1 = new ImageIcon("pink.jpg");

        l1 = new JLabel();
        l1.setBounds(50, 50, 480, 500);
        l1.setIcon(i1);


        p1 = new JPanel();
        p1.setBounds(100, 100, 370, 400);
        p1.setBackground(new Color(152, 152, 152, 70));
        p1.setLayout(null);
        p1.add(l2);
        p1.add(l3);
        p1.add(t1);
        p1.add(b1);
        p1.add(b2);

        f = new JFrame("QUIZ");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(620, 650);
        f.setResizable(false);
        f.getContentPane().setBackground(new Color(146, 21, 37));
        f.setLayout(null);
        f.add(p1);
        f.add(l1);

        f.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
            String name = t1.getText();
            f.setVisible(false);
            new Instructions(name);

        }
        else
        {
            System.exit(0);
        }

    }
    }
