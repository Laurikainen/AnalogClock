import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestIfCorrectAngles {

    private AnalogClock analogClock = new AnalogClock();

    @Test
    public void AngleWhenMinuteHandHasNotPassed12OClock() {
        assertEquals(75, analogClock.CalculateAngle(3, 30));
        assertEquals(75, analogClock.CalculateAngle(15, 30));
    }

    @Test
    public void AngleWhenMinuteHandHasPassed12OClock() {
        assertEquals(325, analogClock.CalculateAngle(3, 10));
        assertEquals(325, analogClock.CalculateAngle(15, 10));
    }

    @Test
    public void AngleWhenMinutesIsZero() {
        assertEquals(270, analogClock.CalculateAngle(3, 0));
        assertEquals(270, analogClock.CalculateAngle(15, 0));
    }

    @Test
    public void AngleWhenItIs12OClock() {
        assertEquals(0, analogClock.CalculateAngle(24, 0));
        assertEquals(0, analogClock.CalculateAngle(12, 0));
        assertEquals(0, analogClock.CalculateAngle(0, 0));
    }

    @Test
    public void IncorrectValues() {
        assertEquals(-1, analogClock.CalculateAngle(26, 0));
        assertEquals(-1, analogClock.CalculateAngle(-2, 0));
        assertEquals(-1, analogClock.CalculateAngle(12, 67));
        assertEquals(-1, analogClock.CalculateAngle(12, -9));
    }
}
