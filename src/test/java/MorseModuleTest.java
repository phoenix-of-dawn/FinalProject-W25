import org.example.modules.MorseModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MorseModuleTest {
    @Test
    void morseModule_Creation() {
        MorseModule morseModule = new MorseModule();

        Assertions.assertNotNull(morseModule.getCode());
        Assertions.assertNotNull(morseModule.getDecodedString());
    }

    @Test
    void morseModule_Solve() {
        MorseModule morseModule = new MorseModule("abcdef", "doesn't matter");

        Assertions.assertTrue(morseModule.solve("abcdef"));
        Assertions.assertFalse(morseModule.solve("abcde"));
    }
}
