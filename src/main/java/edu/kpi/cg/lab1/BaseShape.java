package edu.kpi.cg.lab1;

import java.awt.*;

public abstract class BaseShape {
    protected int x, y, width;
    protected Color color;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void paint(Graphics graphics);
}
