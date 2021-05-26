package Graph;

import Board.BoardContent;
import Unit.UnitDetails;

import javax.swing.JPanel;
import javax.swing.*;

public class MyFrame extends JFrame {

    public MyFrame(BoardContent[][] boardContent, UnitDetails[] unitDetails) {
        super("Map");
        setSize(300, 100);
        setLocation(300, 0);
        JPanel panel = new MyPanel(boardContent,unitDetails);
        add(panel);
        pack();
        //setLayout(new FlowLayout());
        //add(new JButton("Przycisk 1"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}