package edu.kpi.cg.lab2;

import edu.kpi.cg.lab1.Drawer;

import java.awt.BorderLayout;

import javax.swing.*;

public class Lab2 extends JFrame {
    Lab2() {
        setLayout(new BorderLayout());
        add(new Drawer(10, new PolarRose()), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        Lab2 frame = new Lab2();
        frame.setSize(700, 700);
        frame.setTitle("Lab2");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}