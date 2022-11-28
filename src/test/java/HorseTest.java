import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HorseTest {
    TestUtils testUtils = new TestUtils();
    private Horse threeParametersHorse;
    private Horse twoParametersHorse;

    @BeforeAll
    void beforeAll() {
        threeParametersHorse = new Horse(TestUtils.DEFAULT_NAME, TestUtils.DEFAULT_SPEED, TestUtils.DEFAULT_DISTANCE);
        twoParametersHorse = new Horse(TestUtils.DEFAULT_NAME, TestUtils.DEFAULT_SPEED);
    }

    @Test
    void getName() {
        assertEquals(TestUtils.DEFAULT_NAME, threeParametersHorse.getName());
        assertEquals(TestUtils.DEFAULT_NAME, twoParametersHorse.getName());
    }

    @Test
    void getSpeed() {
        assertEquals(TestUtils.DEFAULT_SPEED, threeParametersHorse.getSpeed());
        assertEquals(TestUtils.DEFAULT_SPEED, twoParametersHorse.getSpeed());
    }

    @Test
    void getDistance() {
        assertEquals(TestUtils.DEFAULT_DISTANCE, threeParametersHorse.getDistance());
        assertEquals(0, twoParametersHorse.getDistance());
    }

    @Test
    void move() {

    }

    @Test
    void getRandomDouble() {
    }
}