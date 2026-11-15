
import java.awt.*;

public class HudRenderer extends RenderBase {

    public HudRenderer(GameController model) {
        super(model);
    }

    public void drawBackgroundAndHeader(Graphics2D g) {
        g.setColor(new Color(235, 235, 235));
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.BLACK);
        g.setFont(new Font("SansSerif", Font.BOLD, 22));
        g.drawString("LIGHTMAZE - STARTER", BOARD_X, 65);
    }

    public void drawHud(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("SansSerif", Font.PLAIN, 16));

        g.drawString("Level: " + model.currentLevel, HUD_X, BOARD_Y + 25);
        g.drawString("Moves: " + model.steps, HUD_X, BOARD_Y + 55);
        g.drawString("Elapsed ticks: " + model.elapsedTicks, HUD_X, BOARD_Y + 85);
        g.drawString("Arrows: move | R: restart", HUD_X, BOARD_Y + 115);
    }
}
