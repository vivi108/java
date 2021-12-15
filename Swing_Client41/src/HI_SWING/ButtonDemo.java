package HI_SWING;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonDemo extends JFrame implements ActionListener {
    public static final int WIDTH  = 500;
    public static final int HEIGHT = 350;

    public ButtonDemo() {

        setSize(WIDTH, HEIGHT);
        setTitle("Button Demo");

        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        JButton goButton = new JButton("Green");
        goButton.addActionListener(this);
        contentPane.add(goButton);

        JButton stopButton = new JButton("Red");
        stopButton.addActionListener(this);
        contentPane.add(stopButton);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Container contentPane = getContentPane();
        if (e.getActionCommand().equals("Green"))
            contentPane.setBackground(Color.GREEN);
        if (e.getActionCommand().equals("Red"))
            contentPane.setBackground(Color.RED);
    }
    public static void main(String[] args) {
        new ButtonDemo().setVisible(true);

    }
}

