package edu.kpi.cg.lab1;

import java.awt.*;

public class Cross extends BaseShape {

    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(color);

        graphics.drawLine(x + width, y + width, x - width, y - width);
        graphics.drawLine(x + width, y - width, x - width, y + width);
    }
}
