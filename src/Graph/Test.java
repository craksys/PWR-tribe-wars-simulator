package Graph;

import Board.BoardContent;

import java.awt.EventQueue;

public class Test {
    public void xd(BoardContent[][] boardContent) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyFrame(boardContent);
            }
        });
    }
}