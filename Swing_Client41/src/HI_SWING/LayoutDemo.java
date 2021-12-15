package HI_SWING;

import javax.swing.*;
import java.awt.*;

public class LayoutDemo {

        public static final int WIDTH = 500;
        public static final int HEIGHT = 350;

        public static void main(String[] args) {
            JFrame win = new JFrame("MyLayoutDemo");
            win.setSize(WIDTH, HEIGHT);

            Container content = win.getContentPane();
            content.setLayout(new BorderLayout());
            content.add(new JLabel("Four Layout Managers:"), BorderLayout.NORTH);

            JPanel gridPane = new JPanel();
            gridPane.setLayout(new GridLayout(2, 2));
            gridPane.add(new JLabel("BorderLayout"));
            gridPane.add(new JLabel("FlowLayout"));
            gridPane.add(new JLabel("GridLayout"));
            gridPane.add(new JLabel("BoxLayout"));
            content.add(gridPane, BorderLayout.CENTER);

            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout());
            buttonPane.add(new JButton("OK"));
            buttonPane.add(new JButton("Cancel"));
            content.add(buttonPane, BorderLayout.SOUTH);
            win.setVisible(true);

        }

}

