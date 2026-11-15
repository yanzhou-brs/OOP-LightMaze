
import java.awt.*;

public class GameRenderer extends RenderBase {

    public GameRenderer(GameController model) {
        super(model);
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.BLUE);
        g.fillOval(100, 100, 40, 40);
    }
}
