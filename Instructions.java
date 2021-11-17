package com.secProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Instructions implements ActionListener {
    JFrame f;
    JLabel l1,l2;
    JButton b1,b2;

    Instructions(String userName)
    {
            b2 = new JButton("Start");
            b2.setBounds(400,500,100,30);
            b2.setBackground(new Color(146, 21, 37));
            b2.setForeground(new Color(225,225,225));
            b2.setFocusable(false);
            b2.addActionListener(this);

            b1 = new JButton("Back");
            b1.setBounds(250,500,100,30);
            b1.setBackground(new Color(146, 21, 37));
            b1.setForeground(new Color(225,225,225));
            b1.setFocusable(false);
            b1.addActionListener(this);


            l2 = new JLabel();
            l2.setFont(new Font("Tahoma",Font.PLAIN,16));
            l2.setForeground(new Color(146, 21, 37));
            l2.setBounds(20,90,600,350);
            l2.setText(
                    "<html>"+
                            "1. Choose the best option."+"<br><br>"+
                            "2. The time limit is 10 seconds."+"<br><br>"+
                            "3. After ten seconds the unmarked question will be considered false."+"<br><br>"+
                            "4. For hint after every selection the correct answer will be in yellow color & wrong answer will be in red color."+"<br><br>"+
                            "5. The ratio of correct answers over the wrong answers and the percentage is shown at the end of the quiz."
            );

            l1 = new JLabel("Welcome " + userName + " to the Quiz!");
            l1.setFont(new Font("Vainer Hand ITC",Font.BOLD,28));
            l1.setForeground(new Color(146, 21, 37));
            l1.setBounds(50,20,700,35);


            f = new JFrame("INSTRUCTIONS FOR QUIZ");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setSize(800,650);
            f.getContentPane().setBackground(Color.WHITE);
            f.setLayout(null);
            f.add(l1);
            f.add(l2);
            f.add(b1);
            f.add(b2);

            f.setVisible(true);
        }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)  //for back button
        {
            f.setVisible(false);
            new UI();
        }
        else if (e.getSource() == b2)  //for start button
        {
            f.setVisible(false);
            new Quiz1();

        }
    }
}
