
import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel {

    private final GameController model = new GameController();
    private final GameRenderer gameRenderer = new GameRenderer(model);
    private final HudRenderer hudRenderer = new HudRenderer(model);
    private final Timer timer;

    public GamePanel() {
        setPreferredSize(new Dimension(980, 720));
        setFocusable(true);

        new InputHandler(this, model);

        timer = new Timer(100, e -> {
            model.tick();
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D g = (Graphics2D) graphics.create();

        g.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        hudRenderer.drawBackgroundAndHeader(g);
        gameRenderer.draw(g);
        hudRenderer.drawHud(g);

        g.dispose();
    }
}
