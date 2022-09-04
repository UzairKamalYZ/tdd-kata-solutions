package be.techfix.kata.tdd.bowling;

public class Game {

    private Frame[] frames = new Frame[] {
            new Frame(),
            new Frame(),
            new Frame(),
            new Frame(),
            new Frame(),
            new Frame(),
            new Frame(),
            new Frame(),
            new Frame(),
            new FinalFrame()
    };
    private int currentFrame = 0;
    private Frame eligibleForFirstBonus, eligibleForSecondBonus;

    void roll(int pins) {
        final Frame current = frames[currentFrame];
        current.roll(pins);
        updateBonuses(pins);
        if (current.isEnded()) {
            currentFrame++;
            eligibleForFirstBonus = current;
        }
    }

    private void updateBonuses(int pins) {
        if (eligibleForFirstBonus != null) {
            eligibleForFirstBonus.addFirstBonus(pins);
        }
        if (eligibleForSecondBonus != null) {
            eligibleForSecondBonus.addSecondBonus(pins);
        }
        eligibleForSecondBonus = eligibleForFirstBonus;
        eligibleForFirstBonus = null;
    }

    int score() {
        int result = 0;
        for(int i = 0; i < currentFrame; i++) {
            result += frames[i].score();
        }
        return result;
    }

    boolean isEnded() {
        return currentFrame == 10;
    }
}
