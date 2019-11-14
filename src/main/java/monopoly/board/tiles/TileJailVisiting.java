package monopoly.board.tiles;

import monopoly.Player;
import monopoly.board.Board;
import monopoly.board.IPassable;
import monopoly.board.Tile;

public class TileJailVisiting extends Tile implements IPassable {

    public TileJailVisiting(String title, String texture) {
        super(title, texture);
    }

    @Override
    public void onLanded(Player player, Board board) {

    }

    @Override
    public void renderMarker() {

    }

    @Override
    public void onPassed(Player player) {

    }
}
