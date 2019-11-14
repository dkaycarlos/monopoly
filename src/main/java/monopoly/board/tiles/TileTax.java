package monopoly.board.tiles;

import monopoly.Player;
import monopoly.board.Board;
import monopoly.board.Tile;

public class TileTax extends Tile {

    private int taxAmount;

    public TileTax(String title, String texture, int taxAmount) {
        super(title, texture);
        this.taxAmount = taxAmount;
    }

    @Override
    public void onLanded(Player player, Board board) {

    }

    @Override
    public void renderMarker() {

    }
}
