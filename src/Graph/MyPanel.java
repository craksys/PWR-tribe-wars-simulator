package Graph;

import Board.ArrayOfPlaces;
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
                g2d.setColor(new Color(0, 128, 0));
                g2d.drawRect(i, k, 1, 1);

            }
        }
        for(int u=0; u< ArrayOfPlaces.x_food.size(); u++) {
            g2d.setColor(new Color(128, 0, 0));
            g2d.drawRect(ArrayOfPlaces.x_food.get(u), ArrayOfPlaces.y_food.get(u), 1, 1);
        }
        for(int u=0; u< ArrayOfPlaces.x_iron.size(); u++) {
            g2d.setColor(new Color(161, 157, 148));
            g2d.drawRect(ArrayOfPlaces.x_iron.get(u), ArrayOfPlaces.y_iron.get(u), 1, 1);
        }
        for(int u=0; u< ArrayOfPlaces.x_stone.size(); u++) {
            g2d.setColor(new Color(136, 140, 141));
            g2d.drawRect(ArrayOfPlaces.x_stone.get(u), ArrayOfPlaces.y_stone.get(u), 1, 1);
        }
        for(int u=0; u< ArrayOfPlaces.x_wood.size(); u++) {
            g2d.setColor(new Color(133, 94, 55));
            g2d.drawRect(ArrayOfPlaces.x_wood.get(u), ArrayOfPlaces.y_wood.get(u), 1, 1);
        }

        System.out.println(ArrayOfPlaces.x_food.size());

            for (int i = 0; i < 1000; i++) {
                for (int k = 0; k < 1000; k++) {
                    if (board_content[i][k].occupied) {
                        for(int l=0; l<2;l++){
                            for(int m =0; m<2;m++){
                                g2d.setColor(new Color(0, 0, 0));
                                g2d.drawRect(i+l, k+m, 1, 1);
                            }

                        }
                    }

                }
            }


    }

}