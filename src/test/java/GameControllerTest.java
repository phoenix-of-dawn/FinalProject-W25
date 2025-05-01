import org.example.GameController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class GameControllerTest {
    @Test
    void GameControllerTest_Creation() {
        GameController game = GameController.getInstance();

        Assertions.assertNotNull(game);
        Assertions.assertNotNull(game.getModules());
        Assertions.assertEquals(3, game.getStrikesLeft());
    }

    @Test
    void GameControllerTest_ModuleUniqueness() {
        GameController game = GameController.getInstance();

        Set<Module> seen = new HashSet<>();
        for (Module module : game.getModules()) {
            Assertions.assertNotNull(module);
            Assertions.assertFalse(seen.contains(module));

            seen.add(module);
        }
    }
}
