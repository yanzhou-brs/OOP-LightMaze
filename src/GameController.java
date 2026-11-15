
public class GameController {

    int currentLevel = 1, elapsedTicks = 0, steps = 0;

    public GameController() {
    }

    public void tick() {
        elapsedTicks++;
    }
}
