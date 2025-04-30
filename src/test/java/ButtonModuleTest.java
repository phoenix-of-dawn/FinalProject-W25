import org.example.modules.ButtonModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ButtonModuleTest {
    @Test
    void ButtonTest_Creation1() {
        ButtonModule buttonModule = new ButtonModule();

        Assertions.assertNotNull(buttonModule.getButtonColor());
    }

    @Test
    void ButtonTest_Creation2() {
        ButtonModule buttonModule = new ButtonModule(ButtonModule.ButtonColor.RED);

        Assertions.assertEquals(ButtonModule.ButtonColor.RED, buttonModule.getButtonColor());
    }

    @Test
    void ButtonTest_solveRed() {
        ButtonModule buttonModule = new ButtonModule(ButtonModule.ButtonColor.RED);

        Assertions.assertTrue(buttonModule.solve("press"));
    }

    @Test
    void ButtonTest_solveBlue() {
        ButtonModule buttonModule = new ButtonModule(ButtonModule.ButtonColor.BLUE);

        Assertions.assertTrue(buttonModule.solve("hold 3"));
    }

    @Test
    void ButtonTest_solveGreen() {
        ButtonModule buttonModule = new ButtonModule(ButtonModule.ButtonColor.GREEN);

        Assertions.assertTrue(buttonModule.solve("hold 1"));
    }

    @Test
    void ButtonTest_solveYellow() {
        ButtonModule buttonModule = new ButtonModule(ButtonModule.ButtonColor.YELLOW);

        Assertions.assertTrue(buttonModule.solve("hold 10"));
    }

    @Test
    void ButtonTest_solveWhite() {
        ButtonModule buttonModule = new ButtonModule(ButtonModule.ButtonColor.WHITE);

        Assertions.assertTrue(buttonModule.solve("press"));
    }
}
