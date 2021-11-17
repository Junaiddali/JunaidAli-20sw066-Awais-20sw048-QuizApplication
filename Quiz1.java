package com.secProject;
//25,225,0));
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz1 implements ActionListener{


        String[] questions ={
                "Write down the letter which occurs in each word in the following row: \n" +
                        "FALSE , SUGAR , GREASE , TORRENTS , DAYS , RESERVE , CARPETS , BOOKS.",

                " X, Y, Z, C, B, A, U, V, W, F, E, ..........?\n" +
                        "Select appropriate answer from following",

                " Complete the series: B, C, D, Y, X, W, F, G, H, U, T, S,.......?\n" +
                        "Select appropriate answer from following",

                "Complete the series: B, C, D, Y, X, W, F, G, H, U, T, S,.......?\n" +
                        "Select appropriate answer from following",

                "A men and a boy received Rs. 76 as wages for a work they did together. " +
                        "The man's skill in the work was three times that of the boy. " +
                        "How much did they boy get?",

                " A box contain 785 balls whose colours are red , white and blue. " +
                        "The red and white together number 605, and the white and blue number 471. " +
                        "How many of them are white?",

                "If in alphabet 'A' and 'B' , is written for 'C' and 'D' , 'C' is written for ' E' and 'F' and so on." +
                        " Which will be the third letter from the right end in the new scheme?",

                " Add one letter ( from the choices) to make new word\n" +
                        "OWL",

                " If the odd numbered alphabet be neglected what will be the central alphabet of the even number?",

                " In a certain code AWAKE is written as ZVZID. How is FRIEND written in that code?"
        };
        String [][] options ={
                {" R" , " T", " A" , "S"},
                {" R" , " W", " D" , "Z"},
                {" O" , " J", " I" , "K"},
                {" B" , " S", " D" , "T"},
                {"Rs. 28","Rs. 19","Rs. 57","Rs.28"},
                {"291","180","314","219"},
                {"U","K","I","J"},
                {"O","B","R","L"},
                {"K","N","J","I"},
                {"UOHDMF","EQHDMC","UHODMF","FMDHOU"}
        };
        char[] answers =    {
                'D',
                'C',
                'A',
                'D',
                'B',
                'D',
                'C',
                'A',
                'B',
                'B',

        };
        char guess;
        char answer;
        int index;
        int correct_guesses = 0;
        int total_questions = questions.length;
        int result;
        int seconds =10;

        JFrame frame = new JFrame();
        JTextField textField = new JTextField();
        JTextArea textArea = new JTextArea();
        JButton buttonA = new JButton();
        JButton buttonB = new JButton();
        JButton buttonC = new JButton();
        JButton buttonD = new JButton();
        JButton exit = new JButton();
        JButton menu = new JButton();
        JLabel answer_labelA = new JLabel();
        JLabel answer_labelB = new JLabel();
        JLabel answer_labelC = new JLabel();
        JLabel answer_labelD = new JLabel();
        JLabel time_label = new JLabel();
        JLabel seconds_left = new JLabel();
        JTextField number_right = new JTextField();
        JTextField percentage = new JTextField();

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds--;
                seconds_left.setText(String.valueOf(seconds));
                if(seconds<=0){
                    displayAnswer();
                }
            }
        });

    Quiz1()
    {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1300,650);
            frame.getContentPane().setBackground(new Color(50,50,50));
            frame.setLayout(null);
            frame.setResizable(false);

            textField.setBounds(0,0,1300,50);
            textField.setBackground(new Color(25,25,25));
            textField.setForeground(new Color(243,250,18));
            textField.setFont(new Font("Ink Free",Font.BOLD,30));
            textField.setBorder(BorderFactory.createBevelBorder(1));
            textField.setHorizontalAlignment(JTextField.CENTER);
            textField.setEditable(false);

            textArea.setBounds(0,50,1300,50);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setBackground(new Color(25,25,25));
            textArea.setForeground(new Color(243,250,18));
            textArea.setFont(new Font("MV Boli",Font.BOLD,15));
            textArea.setBorder(BorderFactory.createBevelBorder(1));
            textArea.setEditable(false);

            buttonA.setBounds(0,100,100,100);
            buttonA.setFont(new Font("MV Boli",Font.BOLD,25));
            buttonA.setFocusable(false);
            buttonA.addActionListener(this);
            buttonA.setText("A");

            buttonB.setBounds(0,200,100,100);
            buttonB.setFont(new Font("MV Boli",Font.BOLD,25));
            buttonB.setFocusable(false);
            buttonB.addActionListener(this);
            buttonB.setText("B");

            buttonC.setBounds(0,300,100,100);
            buttonC.setFont(new Font("MV Boli",Font.BOLD,25));
            buttonC.setFocusable(false);
            buttonC.addActionListener(this);
            buttonC.setText("C");

            buttonD.setBounds(0,400,100,100);
            buttonD.setFont(new Font("MV Boli",Font.BOLD,25));
            buttonD.setFocusable(false);
            buttonD.addActionListener(this);
            buttonD.setText("D");

            exit.setBounds( 160,510,100,70);
            exit.setFont(new Font("MV Boli",Font.BOLD,25));
            exit.setFocusable(false);
            exit.addActionListener(this);
            exit.setText("EXIT");

            menu.setBounds(0,510,150,70);
            menu.setFont(new Font("MV Boli",Font.BOLD,25));
            menu.setFocusable(false);
            menu.addActionListener(this);
            menu.setText("START");

            answer_labelA.setBounds(125,100,500,100);
            answer_labelA.setBackground(new Color(50,50,50));
            answer_labelA.setForeground(new Color(243,250,18));
            answer_labelA.setFont(new Font("MV Boli",Font.BOLD,35));

            answer_labelB.setBounds(125,200,500,100);
            answer_labelB.setBackground(new Color(50,50,50));
            answer_labelB.setForeground(new Color(243,250,18));
            answer_labelB.setFont(new Font("MV Boli",Font.BOLD,35));

            answer_labelC.setBounds(125,300,500,100);
            answer_labelC.setBackground(new Color(50,50,50));
            answer_labelC.setForeground(new Color(243,250,18));
            answer_labelC.setFont(new Font("MV Boli",Font.BOLD,35));

            answer_labelD.setBounds(125,400,500,100);
            answer_labelD.setBackground(new Color(50,50,50));
            answer_labelD.setForeground(new Color(243,250,18));
            answer_labelD.setFont(new Font("MV Boli",Font.BOLD,35));

            seconds_left.setBounds(535,510,100,100);
            seconds_left.setBackground(new Color(25,25,25));
            seconds_left.setForeground(new Color(255,0,0));
            seconds_left.setFont(new Font("Ink Free",Font.BOLD,60));
            seconds_left.setBorder(BorderFactory.createBevelBorder(1));
            seconds_left.setOpaque(true);
            seconds_left.setHorizontalAlignment(JTextField.CENTER);
            seconds_left.setText(String.valueOf(seconds));

            time_label.setBounds(555,475,100,25);
            time_label.setBackground(new Color(50,50,50));
            time_label.setForeground(new Color(255,0,0));
            time_label.setFont(new Font("MV Boli",Font.PLAIN,16));
            time_label.setHorizontalAlignment(JTextField.CENTER);
            time_label.setText("timer >:D");

            number_right.setBounds(525,225,200,100);
            number_right.setBackground(new Color(25,25,25));
            number_right.setForeground(new Color(25,225,0));
            number_right.setFont(new Font("Ink Free",Font.BOLD,50));
            number_right.setBorder(BorderFactory.createBevelBorder(1));
            number_right.setHorizontalAlignment(JTextField.CENTER);
            number_right.setEditable(false);

            percentage.setBounds(525,325,200,100);
            percentage.setBackground(new Color(25,25,25));
            percentage.setForeground(new Color(25,225,0));
            percentage.setFont(new Font("Ink Free",Font.BOLD,50));
            percentage.setBorder(BorderFactory.createBevelBorder(1));
            percentage.setHorizontalAlignment(JTextField.CENTER);
            percentage.setEditable(false);


            frame.add(time_label);
            frame.add(seconds_left);
            frame.add(answer_labelA);
            frame.add(answer_labelB);
            frame.add(answer_labelC);
            frame.add(answer_labelD);
            frame.add(buttonA);
            frame.add(buttonB);
            frame.add(buttonC);
            frame.add(buttonD);
            frame.add(textArea);
            frame.add(textField);
            frame.setVisible(true);

            nextQuestion();
        }
        public void nextQuestion()
        {
            if(index>=total_questions){
                result();
            }
            else{
                textField.setText("Question"+(index+1));
                textArea.setText(questions[index]);
                answer_labelA.setText(options[index][0]);
                answer_labelB.setText(options[index][1]);
                answer_labelC.setText(options[index][2]);
                answer_labelD.setText(options[index][3]);
                timer.start();
            }
        }


    @Override
    public void actionPerformed(ActionEvent e) {

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(e.getSource()==buttonA)
        {
            answer='A';
            if(answer == answers[index]){
                correct_guesses++;
            }
        }
        if(e.getSource()==buttonB)
        {
            answer='B';
            if(answer == answers[index]){
                correct_guesses++;
            }
        }
        if(e.getSource()==buttonC)
        {
            answer='C';
            if(answer == answers[index]){
                correct_guesses++;
            }
        }
        if(e.getSource()==buttonD)
        {
            answer='D';
            if(answer == answers[index]){
                correct_guesses++;
            }
        }
        if(e.getSource()==exit)
        {
            System.exit(0);
        }
        if(e.getSource()==menu)
        {
            frame.setVisible(false);
            new UI();
        }

        displayAnswer();
    }
        public void displayAnswer()
        {
            timer.stop();
            buttonA.setEnabled(false);
            buttonB.setEnabled(false);
            buttonC.setEnabled(false);
            buttonD.setEnabled(false);
            if(answers[index] !='A')
                answer_labelA.setForeground(new Color(255,0,0));
            if(answers[index] !='B')
                answer_labelB.setForeground(new Color(255,0,0));
            if(answers[index] !='C')
                answer_labelC.setForeground(new Color(255,0,0));
            if(answers[index] !='D')
                answer_labelD.setForeground(new Color(255,0,0));

            Timer pause = new Timer(2000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    answer_labelA.setForeground(new Color(243,250,18));
                    answer_labelB.setForeground(new Color(243,250,18));
                    answer_labelC.setForeground(new Color(243,250,18));
                    answer_labelD.setForeground(new Color(243,250,18));

                    answer = ' ';
                    seconds = 10;
                    seconds_left.setText(String.valueOf(seconds));
                    buttonA.setEnabled(true);
                    buttonB.setEnabled(true);
                    buttonC.setEnabled(true);
                    buttonD.setEnabled(true);
                    index++;
                    nextQuestion();
                }
            });
            pause.setRepeats(false);
            pause.start();
        }
        public void result()
        {
            buttonA.setEnabled(false);
            buttonB.setEnabled(false);
            buttonC.setEnabled(false);
            buttonD.setEnabled(false);

            result  = (int)((correct_guesses/(double)total_questions)*100);
            textField.setForeground(new Color(255,0,0));
            textField.setText("RESULTS!");
            textArea.setText(" ");
            answer_labelA.setText(" ");
            answer_labelB.setText(" ");
            answer_labelC.setText(" ");
            answer_labelD.setText(" ");

            number_right.setText("("+correct_guesses+"/"+total_questions+")");
            percentage.setText(result+"%");

            frame.add(number_right);
            frame.add(percentage);
            frame.add(menu);
            frame.add(exit);

        }

    }
