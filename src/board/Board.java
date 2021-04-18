package board;


public class Board {

    LocateSources locatesources = new LocateSources();

    public void createmap(Board_Content[][] board_content){
        for(int i =0; i<1000; i++)
        {
            for(int k =0; k<1000 ; k++)
            {
                board_content[i][k] = new Board_Content();
            }
        }
        return;
    }
    public void placesupplies(Board_Content[][] board_content) {
        locatesources.randsupplies(board_content, 20000,1); //jedzenie i woda
        locatesources.randsupplies(board_content, 10000,2); //drewno
        locatesources.randsupplies(board_content, 10000,3); //kamien
        locatesources.randsupplies(board_content, 5000,4); //żelazo
        locatesources.randsupplies(board_content, 1000,5); //złoto
        return;
    }
}

