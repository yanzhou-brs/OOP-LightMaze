import java.awt.*;

abstract class RenderBase {

    protected static final int WIDTH=980, HEIGHT=720, CELL=26,
                               BOARD_X=34, BOARD_Y=142, HUD_X=568;

    protected final GameController model;

    protected RenderBase(GameController model) {
        this.model=model;
    }

    protected int currentLevel() {
        return model.currentLevel;
    }

    protected Color accentColor() {
        return switch(model.currentLevel) {
            case 1 -> new Color(255,174,79);
            case 2 -> new Color(111,207,255);
            case 3 -> new Color(103,238,170);
            default -> new Color(255,126,73);
        };
    }

    protected String seasonName() {
        return switch(model.currentLevel) {
            case 1 -> "AUTUMN";
            case 2 -> "WINTER";
            case 3 -> "SPRING";
            default -> "SUMMER";
        };
    }
}
