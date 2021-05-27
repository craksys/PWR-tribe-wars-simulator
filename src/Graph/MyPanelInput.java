package Graph;


import java.awt.*;

import javax.swing.*;

public class MyPanelInput extends JPanel {
    public MyPanelInput() {
        setPreferredSize(new Dimension(400, 450));

    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        g2d.drawString("Szybkość Jednostek", 10, 70);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        g2d.drawString("Ilość Jednostek", 10, 110);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        g2d.drawString("Ilość Rund", 10, 150);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        g2d.drawString("Ilość Jedzenia", 10, 190);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        g2d.drawString("Ilość Drewna", 10, 230);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        g2d.drawString("Ilość Kamienia", 10, 270);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        g2d.drawString("Ilość Żelaza", 10, 310);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        g2d.drawString("Odświerzanie", 10, 350);

    }
}




