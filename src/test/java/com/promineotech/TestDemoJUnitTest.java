package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

    private TestDemo testDemo;

    @BeforeEach
    void setUp() throws Exception {
        testDemo = new TestDemo();
    }

    @ParameterizedTest
    @MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
    void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
        if (expectException) {
            assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
        } else {
            assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
        }
    }

    static Stream<Arguments> argumentsForAddPositive() {
        return Stream.of(
            arguments(2, 4, 6, false),
            arguments(0, 0, 0, false),
            arguments(-1, 5, 4, false),
            arguments(3, 4, 7, false),
            arguments(1, 1, 2, false),
            arguments(2, -3, -1, false),
            arguments(2, 3, 5, true),
            arguments(0, 0, 0, true)
        );
    }

    @Test
    void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
        // Test adding pairs of positive numbers
        assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
        assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
        // Add more test cases if needed
    }

    /**
     * Test for the factorial method with positive input.
     */
    @Test
    public void testFactorialPositiveInput() {
        int result = testDemo.factorial(5);
        assertEquals(120, result, "Factorial of 5 should be 120");
    }

    /**
     * Test for the factorial method with input 0.
     */
    @Test
    public void testFactorialZeroInput() {
        int result = testDemo.factorial(0);
        assertEquals(1, result, "Factorial of 0 should be 1");
    }

    /**
     * Test for the factorial method with input 1.
     */
    @Test
    public void testFactorialOneInput() {
        int result = testDemo.factorial(1);
        assertEquals(1, result, "Factorial of 1 should be 1");
    }

    /**
     * Test for the factorial method with negative input.
     */
    @Test
    public void testFactorialNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            testDemo.factorial(-5);
        }, "Factorial of a negative number should throw IllegalArgumentException");
    }

    @Test
    void assertThatNumberSquaredIsCorrect() {
        // Mocking the TestDemo class using Mockito.spy and configuring it to return 5
        TestDemo mockDemo = spy(testDemo);
        doReturn(5).when(mockDemo).getRandomInt();

        // Calling randomNumberSquared on the mocked TestDemo object
        int fiveSquared = mockDemo.randomNumberSquared();

        // Asserting that the value returned from randomNumberSquared is equal to 5 squared
        assertThat(fiveSquared).isEqualTo(25);
    }
}
