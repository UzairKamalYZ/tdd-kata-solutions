package be.techfix.kata.tdd.bowling;

public class FinalFrame extends Frame {

	void roll(int knockedDownPins) {
		if (isEnded()) throw new IllegalStateException("Frame is ended");
		if (knockedDownPins > 10) throw new IllegalStateException("There are not so many pins");
		if (rolls.size() == 1 && !isStrike() && rolls.get(0) + knockedDownPins > 10) throw new IllegalStateException("There are not so many pins");
		nbrPins += knockedDownPins;
		rolls.add(knockedDownPins);
	}

	boolean isEnded() {
		return rolls.size() == 3 || (rolls.size() == 2 && nbrPins < 10);
	}

	boolean isSpare() {
		return rolls.size() >= 2
				&& rolls.get(0) != 10
				&& rolls.get(0) + rolls.get(1) == 10;
	}

	public boolean isStrike() {
		return rolls.size() >= 1
				&& rolls.get(0) == 10;
	}
}
