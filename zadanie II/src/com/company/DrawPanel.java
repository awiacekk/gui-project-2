package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class DrawPanel extends JPanel {

    private int x1, y1, x2, y2;
    private final List<JToggleButton> buttons;
    private int field;

    public DrawPanel(List<JToggleButton> buttons) {

        this.buttons=buttons;

        this.addMouseListener(new PaintingPanelMouseAdapter());
        this.addMouseMotionListener(new PaintingPanelMouseAdapter());

        this.setSize(350, 350);
        this.setFocusable(true);
        this.setBackground(Color.white);

    }

    public void setField(int field) {
        this.field = field;
    }

    public String getField() {
        return field+"";
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(4));
        g2d.setColor(Color.RED);

        int px = Math.min(x1,x2);
        int py = Math.min(y1,y2);
        int pw=Math.abs(x1-x2);
        int ph=Math.abs(y1-y2);

        if(buttons.get(0).isSelected()){
            g2d.drawRect(px,py,pw,ph);
            setField(pw*ph);
        }
        if(buttons.get(1).isSelected()){
            g2d.drawOval(px,py,pw,ph);
            setField((int)(Math.PI*pw*ph));
        }
        if(buttons.get(2).isSelected()){
            g2d.drawPolygon(new int[]{x1, (x1+x2)-px-pw/2, x2},new int[]{y2, y1, y2},3);
            setField(pw*ph/2);
        }
    }

    class PaintingPanelMouseAdapter extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            x1 = e.getX();
            y1 = e.getY();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            x2 = e.getX();
            y2 = e.getY();
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            x2 = e.getX();
            y2 = e.getY();
            repaint();
        }
    }
}
