package monopoly.board.tiles;

import monopoly.Player;
import monopoly.board.Board;
import monopoly.board.Tile;
import monopoly.rendering.Mesh;

public class TileJailGoTo extends Tile {

    public TileJailGoTo(String title, Mesh mesh) {
        super(title, mesh);
    }

    @Override
    public void onLanded(Player player, Board board) {

    }

}
