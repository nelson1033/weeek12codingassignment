package com.promineotech;

import java.util.Random;

public class TestDemo {

    public int addPositive(int a, int b) {
        if (a > 0 && b > 0) {
            return a + b;
        } else {
            throw new IllegalArgumentException("Both parameters must be positive!");
        }
    }
    
    /**
     * Calculates the factorial of a given integer.
     * @param n The integer for which to calculate the factorial.
     * @return The factorial of the given integer.
     * @throws IllegalArgumentException If the integer is negative.
     */
    public int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input must be non-negative!");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Returns the square of a random integer between 1 and 10.
     * @return The square of a random integer between 1 and 10.
     */
    public int randomNumberSquared() {
        int randomInt = getRandomInt(); // Call the getRandomInt method and store the result in a variable
        int result = randomInt * randomInt; // Square the random integer
        return result; // Return the squared result
    }
    
    // Package visibility method for generating a random integer between 1 and 10
    int getRandomInt() {
        Random random = new Random();
        return random.nextInt(10) + 1;
    }

    public static void main(String[] args) {
        TestDemo testDemo = new TestDemo();
        try {
            int result = testDemo.addPositive(5, 3);
            System.out.println("Result: " + result); // Output: Result: 8
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        try {
            int result = testDemo.addPositive(0, 3); // This will throw an exception
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage()); // Output: Exception caught: Both parameters must be positive!
        }

        int randomSquared = testDemo.randomNumberSquared();
        System.out.println("Random number squared: " + randomSquared);
    }
}
