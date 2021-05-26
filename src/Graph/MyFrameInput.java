package Graph;

import javax.swing.*;

public class MyFrameInput extends JFrame {

    public MyFrameInput() {
        super("Wprowadź dane");
        setSize(300, 100);
        setLocation(300, 0);
        JPanel panel = new MyPanelInput();
        add(panel);
        pack();
        //setLayout(new FlowLayout());
        //add(new JButton("Przycisk 1"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}