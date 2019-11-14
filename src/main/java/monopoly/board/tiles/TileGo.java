package monopoly.board.tiles;

import monopoly.Player;
import monopoly.board.Board;
import monopoly.board.IPassable;
import monopoly.board.Tile;

public class TileGo extends Tile implements IPassable {

    private int rewardAmount;

    public TileGo(String title, String texture, int rewardAmount) {
        super(title, texture);
        this.rewardAmount = rewardAmount;
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
