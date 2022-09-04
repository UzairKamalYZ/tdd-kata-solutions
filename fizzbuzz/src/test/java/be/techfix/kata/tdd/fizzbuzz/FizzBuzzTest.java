package be.techfix.kata.tdd.fizzbuzz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    @ParameterizedTest
    @ValueSource(ints = {3,6,12,30, 99})
    void number_divisable_by_3_is_true(int i) {
        App app = new App();
        boolean isDivisable = app.isDivisableBy(i, 3);
        assertTrue(isDivisable);
    }

    @ParameterizedTest
    @ValueSource(ints = {4,7,11,98})
    void number_divisable_by_3_is_false(int i) {
        App app = new App();
        boolean isDivisable = app.isDivisableBy(i, 3);
        assertFalse(isDivisable);
    }

    @ParameterizedTest
    @ValueSource(ints = {5,10,55})
    void number_divisable_by_5_is_true(int i) {
        App app = new App();
        boolean isDivisable = app.isDivisableBy(i, 5);
        assertTrue(isDivisable);
    }

    @ParameterizedTest
    @MethodSource("fizzBuzzInput")
    void fizzBuzzTest(int i, String result) {
        App app = new App();
        String fizzbuzz = app.fizzbuzz(i);
        assertEquals(result, fizzbuzz);
    }

    static Stream<Arguments> fizzBuzzInput() {
        return Stream.of(
                Arguments.of(1, "1"),
                Arguments.of(3, "fizz"),
                Arguments.of(5, "buzz"),
                Arguments.of(15, "fizzbuzz")
                );
    }
}
