package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.List;

public class DrawFigures extends JFrame implements MouseMotionListener{
    private final JLabel label;
    private final JPanel drawPanel;
    public DrawFigures() {

        this.setTitle("Projekt 2 - zadanie 2");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(700, 350);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(1,2));

        List<JToggleButton> buttons = Arrays.asList(
                new JToggleButton("Rectangle"),
                new JToggleButton("Oval"),
                new JToggleButton("Triangle")
        );
        drawPanel = new DrawPanel(buttons);

        label = new JLabel();
        label.setText(((DrawPanel)drawPanel).getField()+"px²");
        label.setSize(100,100);
        label.setHorizontalAlignment(0);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial Black", Font.PLAIN, 30));

        JPanel editPanel = new JPanel();
        editPanel.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.fill = GridBagConstraints.HORIZONTAL;
        g.ipady = 80;
        g.gridx = 0;
        g.gridy = 0;
        editPanel.add(label,g);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.ipady=25;
        g.weightx=3;
        g.gridx=0;
        g.gridy=1;
        editPanel.add(buttons.get(0),g);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.ipady=25;
        g.weightx=3;
        g.gridx=0;
        g.gridy=2;
        editPanel.add(buttons.get(1),g);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.ipady=25;
        g.weightx=3;
        g.gridx=0;
        g.gridy=3;
        editPanel.add(buttons.get(2),g);
        drawPanel.addMouseMotionListener(this);
        this.getContentPane().add(drawPanel);
        this.getContentPane().add(editPanel);
        buttons.get(0).setSelected(true);
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if(actionEvent.getActionCommand().equals("Rectangle")){
                    buttons.get(1).setSelected(false);
                    buttons.get(2).setSelected(false);
                }else if(actionEvent.getActionCommand().equals("Oval")){
                    buttons.get(0).setSelected(false);
                    buttons.get(2).setSelected(false);
                }else{
                    buttons.get(0).setSelected(false);
                    buttons.get(1).setSelected(false);
                }
            }
        };
        buttons.get(0).addActionListener(actionListener);
        buttons.get(1).addActionListener(actionListener);
        buttons.get(2).addActionListener(actionListener);
        this.setVisible(true);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        label.setText(((DrawPanel)drawPanel).getField()+"px²");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

}
