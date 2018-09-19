package edu.kpi.cg.lab1;

import java.awt.BorderLayout;


import javax.swing.*;

public class Lab1 extends JFrame {
    Lab1() {
        setLayout(new BorderLayout());
        add(new Drawer(50, new Cross()), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        Lab1 frame = new Lab1();
        frame.setSize(700, 700);
        frame.setTitle("Lab1");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}