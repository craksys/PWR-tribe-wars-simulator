package Graph;

import Board.BoardContent;

import javax.swing.JPanel;
import javax.swing.*;

public class MyFrame extends JFrame {

    public MyFrame(BoardContent[][] boardContent) {
        super("Map");
        setSize(300, 100);
        setLocation(300, 0);
        JPanel panel = new MyPanel(boardContent);
        add(panel);
        pack();
        //setLayout(new FlowLayout());
        //add(new JButton("Przycisk 1"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}