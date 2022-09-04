package be.techfix.kata.tdd.bowling;

import java.util.ArrayList;
import java.util.List;

class Frame {

    List<Integer> rolls = new ArrayList<>();
    int nbrPins = 0;
    private int bonus = 0;

    void roll(int knockedDownPins) {
        if (isEnded()) throw new IllegalStateException("Frame is ended");
        if (nbrPins + knockedDownPins > 10) throw new IllegalStateException("There are not so many pins");
        nbrPins += knockedDownPins;
        rolls.add(knockedDownPins);
    }

    boolean isEnded() {
        return rolls.size() == 2 || nbrPins == 10;
    }

    int score() {
        return nbrPins + bonus;
    }

    boolean isSpare() {
        return nbrPins == 10 && rolls.size() == 2;
    }

    public boolean isStrike() {
        return nbrPins == 10 && rolls.size() == 1;
    }

    public void addFirstBonus(int pins) {
        if(isSpare() || isStrike())
            bonus += pins;
    }

    public void addSecondBonus(int pins) {
        if(isStrike())
            bonus += pins;
    }
}
