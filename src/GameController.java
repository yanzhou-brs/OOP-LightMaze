
public class GameController {

    final Maze maze = new Maze();
    final Player player = new Player(1, 1);

    GameState state = GameState.PLAYING;

    int currentLevel = 1, elapsedTicks = 0, steps = 0;

    public GameController() {
    }

    public void movePlayer(int dr, int dc) {
        if (state != GameState.PLAYING) return;

        int r = player.getRow();
        int c = player.getCol();

        player.tryMove(dr, dc, maze);

        if (r != player.getRow() || c != player.getCol()) {
            steps++;
        }

        checkGameState();
    }

    public void tick() {
        if (state != GameState.PLAYING) return;

        elapsedTicks++;
        checkGameState();
    }

    private void checkGameState() {
        if (maze.isExit(player.getRow(), player.getCol())) {
            state = currentLevel < 4
                    ? GameState.LEVEL_COMPLETE
                    : GameState.WON;
        }
    }

    public void nextLevel() {
        if (state == GameState.LEVEL_COMPLETE && currentLevel < 4) {
            currentLevel++;
            resetLevel();
        }
    }

    public void replayLevel() {
        if (state == GameState.LEVEL_COMPLETE) {
            resetLevel();
        }
    }

    public void restartGame() {
        currentLevel = 1;
        resetLevel();
    }

    private void resetLevel() {
        maze.setLevel(currentLevel);
        player.setPosition(1, 1);

        elapsedTicks = 0;
        steps = 0;
        state = GameState.PLAYING;
    }
}
