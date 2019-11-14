package monopoly.board;

import monopoly.Banker;
import monopoly.Player;
import monopoly.items.ChanceCard;
import monopoly.items.ChestCard;
import monopoly.rendering.IRenderable;
import monopoly.util.CircularlyLinkedList;
import monopoly.util.Node;
import monopoly.util.Queue;

import java.util.HashMap;
import java.util.Map;

public class Board implements IRenderable{

    private final CircularlyLinkedList<Tile> tileList;
    private final Queue<ChanceCard> chanceQueue;
    private final Queue<ChestCard> chestQueue;
    private final Map<Player, Node<Tile>> playerMap;
    private final Banker bank;

    public Board() {
        this.tileList = new CircularlyLinkedList<>();
        this.chanceQueue = new Queue<>();
        this.chestQueue = new Queue<>();
        this.playerMap = new HashMap<>();
        bank = new Banker("Bank", null);
        initBoard();
    }

    private void initBoard() {
        //TODO: load property cards and tiles
        // resources/board.json

        //TODO: create and load chance cards
        // resources/chance.json

        //TODO: create and load chest cards
        // resources/chest.json
    }

    public void addPlayer(Player player) {
        //TODO: add player to playerMap
    }

    public Queue<ChanceCard> getChanceQueue() {
        return this.chanceQueue;
    }

    public Queue<ChestCard> getChestQueue() {
        return this.chestQueue;
    }

    public void updateBoard(Player currentPlayer) {

    }

}
