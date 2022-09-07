package be.techfix.kata.tdd.bowling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class FrameTest {

    @Test
    void frameEndsAfter2Rolls() {
        Frame frame = new Frame();
        frame.roll(0);
        frame.roll(0);
        assertTrue(frame.isEnded());
    }

    @Test
    void frameEndsAfter10PinsKnockedDown() {
        Frame frame = new Frame();
        frame.roll(10);
        assertTrue(frame.isEnded());
    }

    @Test
    void cannotRollAfterFrameIsEnded() {
        Frame frame = new Frame();
        frame.roll(10);
        assertThrows(IllegalStateException.class, () -> frame.roll(0));
    }

    @Test
    void cannotRollMoreThan10InARoll() {
        Frame frame = new Frame();
        assertThrows(IllegalStateException.class, () -> frame.roll(11));
    }

    @Test
    void cannotRollMoreThan10InAFrame() {
        Frame frame = new Frame();
        frame.roll(6);
        assertThrows(IllegalStateException.class, () -> frame.roll(6));
    }

    @Test
    void frameScoreIsTheSumOfNbrOfPins() {
        Frame frame = new Frame();
        frame.roll(5);
        frame.roll(3);
        int score = frame.score();
        assertEquals(score, 8);
    }

    @Test
    void rolling10in2RollsIsASpare() {
        Frame frame = new Frame();
        frame.roll(9);
        frame.roll(1);
        assertTrue(frame.isSpare());
    }
    @Test
    void rolling0_10IsASpare() {
        Frame frame = new Frame();
        frame.roll(0);
        frame.roll(10);
        assertTrue(frame.isSpare());
    }

    @Test
    void rolling10InASingleRollIsAStrike() {
        Frame frame = new Frame();
        frame.roll(10);
        assertTrue(frame.isStrike());
    }
}