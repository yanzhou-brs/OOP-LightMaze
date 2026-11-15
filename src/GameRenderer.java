
import java.awt.*;

public class GameRenderer extends RenderBase {

    public GameRenderer(GameController model) {
        super(model);
    }

    public void draw(Graphics2D g) {
        drawMaze(g);
        drawPlayer(g);
    }

    private void drawMaze(Graphics2D g) {
        for (int row = 0; row < maze.getRows(); row++) {
            for (int col = 0; col < maze.getCols(); col++) {

                int x = BOARD_X + col * CELL;
                int y = BOARD_Y + row * CELL;

                g.setColor(
                    maze.isWall(row, col) ? Color.DARK_GRAY : Color.WHITE
                );
                g.fillRect(x, y, CELL, CELL);

                g.setColor(Color.LIGHT_GRAY);
                g.drawRect(x, y, CELL, CELL);

                if (maze.isExit(row, col)) {
                    g.setColor(Color.GREEN.darker());
                    g.fillRect(
                        x + 5, y + 5,
                        CELL - 10, CELL - 10
                    );
                }
            }
        }
    }

    private void drawPlayer(Graphics2D g) {
        g.setColor(Color.BLUE);

        g.fillOval(
            BOARD_X + player.getCol() * CELL + 4,
            BOARD_Y + player.getRow() * CELL + 4,
            CELL - 8,
            CELL - 8
        );
    }
}
