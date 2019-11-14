package monopoly.board;

import monopoly.Player;
import monopoly.enums.RenderOrientation;
import monopoly.rendering.IRenderable;

public abstract class Tile implements IRenderable {

    private String title;
    private String texture;
    private RenderOrientation renderOrientation;

    protected Tile(String title, String texture) {
        this.title = title;
        this.texture = texture;
    }
    
    public abstract void onLanded(Player player, Board board);

    public abstract void renderMarker();

    public String getTitle() {
        return this.title;
    }

    public String getTexture() {
        return this.texture;
    }

    public RenderOrientation getRenderOrientation() {
        return this.renderOrientation;
    }
}
