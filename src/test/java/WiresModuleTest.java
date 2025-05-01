import org.example.modules.WiresModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WiresModuleTest {
    @Test
    void wiresTest_Creation() {
        WiresModule wires = new WiresModule();

        Assertions.assertNotNull(wires.getWireColors());
        Assertions.assertEquals(5, wires.getWireColors().size());

        for (WiresModule.WireColor color : wires.getWireColors()) {
            Assertions.assertNotNull(color);
        }
    }

    @Test
    void wiresTest_SolveBlackLast() {
        List<WiresModule.WireColor> wires = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            wires.add(WiresModule.WireColor.BLACK);
        }

        WiresModule wiresModule = new WiresModule(wires);

        Assertions.assertTrue(wiresModule.solve("1"));
        Assertions.assertFalse(wiresModule.solve("4"));
    }

    @Test
    void wiresTest_solveRedSecond() {
        List<WiresModule.WireColor> wires = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            wires.add(WiresModule.WireColor.RED);
        }

        WiresModule wiresModule = new WiresModule(wires);

        Assertions.assertTrue(wiresModule.solve("3"));
        Assertions.assertFalse(wiresModule.solve("4"));
    }

    @Test
    void wiresTest_solveBlueFourth() {
        List<WiresModule.WireColor> wires = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            wires.add(WiresModule.WireColor.BLUE);
        }

        WiresModule wiresModule = new WiresModule(wires);

        Assertions.assertTrue(wiresModule.solve("4"));
        Assertions.assertFalse(wiresModule.solve("1"));
    }

    @Test
    void wiresTest_solveOrangeFourth() {
        List<WiresModule.WireColor> wires = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            wires.add(WiresModule.WireColor.ORANGE);
        }

        WiresModule wiresModule = new WiresModule(wires);

        Assertions.assertTrue(wiresModule.solve("2"));
        Assertions.assertFalse(wiresModule.solve("1"));
    }

    @Test
    void wiresTest_solveOtherwise() {
        List<WiresModule.WireColor> wires = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            wires.add(WiresModule.WireColor.WHITE);
        }

        WiresModule wiresModule = new WiresModule(wires);

        Assertions.assertTrue(wiresModule.solve("5"));
        Assertions.assertFalse(wiresModule.solve("2"));
    }
}
