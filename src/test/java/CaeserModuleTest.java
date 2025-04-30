import org.example.modules.CaeserModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CaeserModuleTest {
    @Test
    void CaeserTest_Creation1() {
        CaeserModule testModule = new CaeserModule(3, "abcdefgh");
        String expected = "defghijk";

        Assertions.assertEquals(expected, testModule.getCaeserString());
    }

    @Test
    void CaeserTest_Creation2() {
        CaeserModule testModule = new CaeserModule(1, "zzzzzzzz");
        String expected = "aaaaaaaa";

        Assertions.assertEquals(expected, testModule.getCaeserString());
    }

    @Test
    void CaeserTest_Solve1() {
        CaeserModule testModule = new CaeserModule(3, "abcdefgh");

        Assertions.assertTrue(testModule.solve("abcdefgh"));
    }

    void CaeserTest_Solve2() {
        CaeserModule testModule = new CaeserModule(3, "abcdefgh");

        Assertions.assertFalse(testModule.solve(null));
    }
}
