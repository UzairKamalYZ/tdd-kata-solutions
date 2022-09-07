package be.techfix.kata.tdd.bowling;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class FinalFrameTest {

	@Test
	void frameEndsAfter2Rolls() {
		Frame frame = new FinalFrame();
		frame.roll(0);
		frame.roll(0);
		assertTrue(frame.isEnded());
	}

	@Test
	void frameEndsAfter3RollsIfStrike() {
		Frame frame = new FinalFrame();
		frame.roll(10);
		frame.roll(10);
		frame.roll(10);
		assertTrue(frame.isEnded());
	}

	@Test
	void frameEndsAfter3RollsIfSpare() {
		Frame frame = new FinalFrame();
		frame.roll(3);
		frame.roll(7);
		frame.roll(1);
		assertTrue(frame.isEnded());
	}

	@Test
	void cannotRollAfterFrameIsEnded() {
		Frame frame = new FinalFrame();
		frame.roll(0);
		frame.roll(0);
		assertThrows(IllegalStateException.class, () -> frame.roll(0));
	}

	@Test
	void cannotRollMoreThan10InARoll() {
		Frame frame = new FinalFrame();
		assertThrows(IllegalStateException.class, () -> frame.roll(11));
	}

	@Test
	void cannotRollMoreThan10InAFrame() {
		Frame frame = new FinalFrame();
		frame.roll(6);
		assertThrows(IllegalStateException.class, () -> frame.roll(6));
	}

	@Test
	void frameScoreIsTheSumOfNbrOfPins() {
		Frame frame = new FinalFrame();
		frame.roll(5);
		frame.roll(3);
		int score = frame.score();
		assertEquals(score, 8);
	}

	@Test
	void rolling10in2RollsIsASpare() {
		Frame frame = new FinalFrame();
		frame.roll(9);
		frame.roll(1);
		assertTrue(frame.isSpare());
	}
	@Test
	void rolling0_10IsASpare() {
		Frame frame = new FinalFrame();
		frame.roll(0);
		frame.roll(10);
		assertTrue(frame.isSpare());
	}

	@Test
	void rolling10InASingleRollIsAStrike() {
		Frame frame = new FinalFrame();
		frame.roll(10);
		assertTrue(frame.isStrike());
	}
}
