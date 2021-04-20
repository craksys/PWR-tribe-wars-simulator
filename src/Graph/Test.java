package Graph;

import Board.Board_Content;

import java.awt.EventQueue;

public class Test {
    public void xd(Board_Content[][] board_content) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyFrame(board_content);
            }
        });
    }
}