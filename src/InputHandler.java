
import javax.swing.*;
import java.awt.event.*;

public class InputHandler {

    private final GamePanel panel;
    private final GameController model;

    public InputHandler(GamePanel panel, GameController model) {
        this.panel = panel;
        this.model = model;
        setupKeys();
    }

    private void setupKeys() {
        bindMove(KeyEvent.VK_UP, "up", -1, 0);
        bindMove(KeyEvent.VK_DOWN, "down", 1, 0);
        bindMove(KeyEvent.VK_LEFT, "left", 0, -1);
        bindMove(KeyEvent.VK_RIGHT, "right", 0, 1);

        bind(KeyEvent.VK_R, "restart", () -> model.restartGame());
        bind(KeyEvent.VK_N, "next", () -> model.nextLevel());
    }

    private void bindMove(int code, String name, int dr, int dc) {
        bind(code, name, () -> model.movePlayer(dr, dc));
    }

    private void bind(int code, String name, Runnable action) {
        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
             .put(KeyStroke.getKeyStroke(code, 0), name);

        panel.getActionMap().put(name, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.run();
                panel.repaint();
            }
        });
    }
}
