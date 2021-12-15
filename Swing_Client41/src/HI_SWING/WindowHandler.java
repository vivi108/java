package HI_SWING;

import java.awt.event.*;
import javax.swing.*;

public class WindowHandler extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        JOptionPane.showMessageDialog(null,
                "Window is closing", "Message", JOptionPane.INFORMATION_MESSAGE);
        super.windowClosing(e);
    }
}