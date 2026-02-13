import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class SnapTest {

    @Test
    @DisplayName("Check correct timer delay is set for 1")
    void setDelayByChoice1Test() {
        Assertions.assertTrue(SnapDelayTimer.setDelayByChoice(1) == 3500);
    }

    @Test
    @DisplayName("Check correct timer delay is set for 2")
    void setDelayByChoice2Test() {
        Assertions.assertTrue(SnapDelayTimer.setDelayByChoice(2) == 2500);
    }

    @Test
    @DisplayName("Check correct timer delay is set for 2")
    void setDelayByChoice3Test() {
        Assertions.assertTrue(SnapDelayTimer.setDelayByChoice(3) == 1500);
    }
}
