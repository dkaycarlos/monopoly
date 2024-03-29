package monopoly;

import monopoly.inventory.Inventory;
import monopoly.inventory.InventoryHolder;
import monopoly.board.Tile;
import monopoly.rendering.Mesh;

import java.util.ArrayList;

public class Player extends InventoryHolder {

    public static final float MOVEMENT_SPEED = 0.05f;

    private Tile renderLocation;
    private Tile advanceTile;
    private Tile moveTile;

    private int spacesToMove;

    private Banker banker;

    public Player(String name, Mesh mesh) {
        super(name,mesh);
        this.inventory = new Inventory(new ArrayList<>(), false);
    }

    /**
     * Moves the player a number of spaces on the board.
     * <code>spaces</code> can be negative to move the player backwards.
     *
     * @param spaces number of spaces to move player
     */
    public void moveSpaces(int spaces) {
        this.spacesToMove += spaces;
    }

    /**
     * Moves a player along the board to a tile.
     * While being moved by this method, the player will pass each tile
     * along the way, calling <code>IPassable.onPassed()</code> on each tile.
     *
     * @param targetTile the tile the player will be moved to
     */
    public void advanceToTile(Tile targetTile) {
        this.advanceTile = targetTile;
    }

    /**
     * Moves player to a tile without passing other tiles.
     * When moved by this method, the player will NOT pass any other tile.
     * The player will be moved directly to <code>advanceTile</code>.
     *
     * @param targetTile the tile the player will be moved to
     */
    public void moveToTile(Tile targetTile) {
        this.moveTile = targetTile;
    }

    public Banker getBanker() {
        return this.banker;
    }

    public void getMoney(int amount) {
        getBanker().getInventory().getCashStack().trade(this.getInventory(), amount);
    }



}
