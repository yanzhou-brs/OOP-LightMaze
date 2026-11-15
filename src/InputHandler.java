
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
        bind(KeyEvent.VK_R, "restart", () -> model.elapsedTicks = 0);
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
