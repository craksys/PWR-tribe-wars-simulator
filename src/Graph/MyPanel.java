package Graph;

import Board.Board_Content;

import java.awt.*;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
    Board_Content[][] board_content;
    public MyPanel(Board_Content[][] board_content) {
        this.board_content = board_content;
        setPreferredSize(new Dimension(400, 400));

    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

            for (int i = 0; i < 1000; i++) {
                for (int k = 0; k < 1000; k++) {
                    if (board_content[i][k].occupied) {
                        g2d.setColor(new Color(0, 0, 0));
                    } else {
                        g2d.setColor(new Color(0, 128, 0));
                    }
                    g2d.drawRect(i, k, 1, 1);
                }
            }


    }

}