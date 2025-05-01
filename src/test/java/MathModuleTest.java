import org.example.modules.MathModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MathModuleTest {
    @Test
    void MathTest_Creation() {
        MathModule math = new MathModule();

        Assertions.assertDoesNotThrow(() -> new MathModule());
        Assertions.assertNotNull(math.getExpression());
        Assertions.assertNotNull(math.getOperation());
    }

    @Test
    void MathTest_initAnswerValid() {
        MathModule math = new MathModule("02 + 02 = ?", "+");
        int expected = 4;

        Assertions.assertEquals(4, math.getAnswer());
    }

    @Test
    void MathTest_initAnswerNotValid() {
        Assertions.assertThrows(IllegalStateException.class, () -> new MathModule("", "/"));
    }

    @Test
    void MathTest_Solve() {
        MathModule math = new MathModule("02 + 02 = ?", "+");

        Assertions.assertTrue(math.solve("4"));
        Assertions.assertFalse(math.solve("2"));
        Assertions.assertFalse(math.solve(""));
    }
}
