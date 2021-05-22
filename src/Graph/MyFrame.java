package Graph;
import Board.Board_Content;
import Unit.Unit_Details;

import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame {

    public MyFrame(Board_Content[][] board_content) {
        super("Map");
        setSize(300, 100);
        setLocation(300,0);
        JPanel panel = new MyPanel(board_content);
        add(panel);
        pack();
        //setLayout(new FlowLayout());
        //add(new JButton("Przycisk 1"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}