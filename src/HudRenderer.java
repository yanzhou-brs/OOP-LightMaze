
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
        g.drawString("LIGHTMAZE - FOUR SEASONS", BOARD_X, 65);

        g.setFont(new Font("SansSerif", Font.PLAIN, 16));
        g.drawString("Season: " + seasonName(), BOARD_X, 95);
    }

    public void drawHud(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("SansSerif", Font.PLAIN, 16));

        int x = HUD_X;
        int y = BOARD_Y;

        // Game information
        g.drawString("Level: " + model.currentLevel + " / 4", x, y + 25);
        g.drawString("Season: " + seasonName(), x, y + 55);
        g.drawString("Moves: " + model.steps, x, y + 85);
        g.drawString("Time: " + model.elapsedTicks / 10 + " s", x, y + 115);

        // Keyboard controls
        g.drawString("CONTROLS", x, y + 165);
        g.drawString("Arrow Keys: Move", x, y + 195);
        g.drawString("R: Restart Game", x, y + 225);
        g.drawString("N: Next Level (after clearing)", x, y + 255);

        // Game status
        g.setFont(new Font("SansSerif", Font.BOLD, 17));

        switch (model.state) {
            case PLAYING:
                g.setColor(new Color(30, 120, 50));
                g.drawString("Find the green exit!", x, y + 315);
                break;

            case LEVEL_COMPLETE:
                g.setColor(new Color(30, 120, 50));
                g.drawString("LEVEL COMPLETE!", x, y + 315);
                g.drawString("Press N for next level", x, y + 345);
                break;

            case WON:
                g.setColor(new Color(30, 120, 50));
                g.drawString("YOU WON!", x, y + 315);
                g.drawString("All four seasons cleared!", x, y + 345);
                break;

            case LOST:
                g.setColor(Color.RED);
                g.drawString("GAME OVER!", x, y + 315);
                g.drawString("Press R to restart", x, y + 345);
                break;
        }
    }
}
