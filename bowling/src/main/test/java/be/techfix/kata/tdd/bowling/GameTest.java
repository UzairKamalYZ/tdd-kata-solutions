package be.techfix.kata.tdd.bowling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTest {

    @Test
    void gameIsEndedAfter10Frames() {
        Game game = new Game();
        for (int i = 0; i<10; i++) {
            game.roll(0);
            game.roll(0);
        }
        assertTrue(game.isEnded());
    }

    @Test
    void scoreIs18AfterRolling6_3And_7_2() {
        Game game = new Game();
        game.roll(6);
        game.roll(3);
        game.roll(7);
        game.roll(2);
        assertEquals(18, game.score());
    }

    @Test
    void scoreIs20AfterRolling5_5And5_0() {
        Game game = new Game();
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(0);
        assertEquals(20, game.score());
    }

    @Test
    void scoreIs28AfterRolling10And5_4() {
        Game game = new Game();
        game.roll(10);
        game.roll(5);
        game.roll(4);
        assertEquals(28, game.score());
    }

    @Test
    void scoreIs53AfterRolling10And10And5_4() {
        Game game = new Game();
        game.roll(10);
        game.roll(10);
        game.roll(5);
        game.roll(4);
        assertEquals(53, game.score());
    }

    @Test
    void perfectScoreIs300() {
        final Game game = new Game();
        for (int i = 0; i < 9; i++) {
            game.roll(10);
        }
        game.roll(10);
        game.roll(10);
        game.roll(10);

        assertTrue(game.isEnded());
        assertEquals(300, game.score());
    }
}
