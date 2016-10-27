/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.JApplet;
import javax.swing.JOptionPane;

public class MyApplet1 extends JApplet implements ActionListener
{
    Button addBtn, subBtn, divBtn, mulBtn;
    TextField field1, field2;
    Label answerBoard;
    public void init()
    {
        //Turn layout manager off
        setLayout(null);    
        //Create buttons
        //Add
        addBtn = new Button();
        addBtn.setLabel("+");
        addBtn.addActionListener(this);
        addBtn.setBounds(90, 50, 25, 25);
        add(addBtn);
        //Subtract
        subBtn = new Button();
        subBtn.setLabel("-");
        subBtn.addActionListener(this);
        subBtn.setBounds(120, 50, 25, 25);
        add(subBtn);
        //Multiplication
        mulBtn = new Button();
        mulBtn.setLabel("*");
        mulBtn.addActionListener(this);
        mulBtn.setBounds(150, 50, 25, 25);
        add(mulBtn);
        //Divide
        divBtn = new Button();
        divBtn.setLabel("/");
        divBtn.addActionListener(this);
        divBtn.setBounds(180, 50, 25, 25);
        add(divBtn);
        //Label
        answerBoard = new Label("", answerBoard.CENTER);
        answerBoard.setBackground(new Color(192, 192, 192));
        answerBoard.setBounds(10, 5, 280, 35);
        add(answerBoard);
        //Text Fields
        field1 = new TextField(20);
        field1.setBounds(15, 50, 70, 25);
        add(field1);
        
        field2 = new TextField(20);
        field2.setBounds(210, 50, 70, 25);
        add(field2);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        //ADD
        if(e.getSource() == addBtn)
        {
            try
            {
                double num1 = Double.parseDouble(field1.getText());
                double num2 = Double.parseDouble(field2.getText());
                double ans = num1 + num2;
                answerBoard.setText(String.valueOf(ans));
            }
            catch(NumberFormatException ee)
            {
                JOptionPane.showMessageDialog(this,  "Operand cannot be parsed as a number.");
            }
        }
        //Subtract
        if(e.getSource() == subBtn)
        {
            try
            {
                double num1 = Double.parseDouble(field1.getText());
                double num2 = Double.parseDouble(field2.getText());
                double ans = num1 - num2;
                answerBoard.setText(String.valueOf(ans));
            }
            catch(NumberFormatException ee)
            {
                JOptionPane.showMessageDialog(this,  "Operand cannot be parsed as a number.");
            }
        }
        //Multiply
        if(e.getSource() == mulBtn)
        {
            try
            {
                double num1 = Double.parseDouble(field1.getText());
                double num2 = Double.parseDouble(field2.getText());
                double ans = num1 * num2;
                answerBoard.setText(String.valueOf(ans));
            }
            catch(NumberFormatException ee)
            {
                JOptionPane.showMessageDialog(this,  "Operand cannot be parsed as a number.");
            }
        }
        //Divide
        if(e.getSource() == divBtn)
        {
            try
            {
                double num1 = Double.parseDouble(field1.getText());
                double num2 = Double.parseDouble(field2.getText());
                double ans = num1 / num2;
                answerBoard.setText(String.valueOf(ans));
            }
            catch(NumberFormatException ee)
            {
                JOptionPane.showMessageDialog(this,  "Operand cannot be parsed as a number.");
            }
        }
    }
    

    
    public void paint(Graphics g)
    {
        //Color of Background
        g.setColor(new Color(0, 0, 153));
        g.fillRect(0, 0, 300, 125);
    }
}
