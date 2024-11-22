package ua.ithillel.javapro;

import ua.ithillel.javapro.util.CountUpperCaseUtil;
import ua.ithillel.javapro.util.RandomNumberGeneratorUtil;

import java.util.function.Consumer;

public class Application {
    private static final Consumer<String> printResult = System.out::println;
    static final int FIRST_NUMBER = 5;
    static final int SECOND_NUMBER = 2;
    static final String TEXT = "Some text";
    static final int MIN_NUMBER_OF_RANGE = 1;
    static final int MAX_NUMBER_OF_RANGE = 100;


    public static void main(String[] args) {

        //Multiplication of two numbers(MathOperation)
        MathOperation mathOperation = new MathOperation() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };
        printResult.accept(String.format("___MathOperation___%nNumbers: %d, %d%nThe result of the addition is: %d%n"
                , FIRST_NUMBER, SECOND_NUMBER, mathOperation.operate(FIRST_NUMBER, SECOND_NUMBER)));

        // Converting to uppercase(StringManipulator)
        StringManipulator stringManipulator = String::toUpperCase;
        String resultStringManipulator = stringManipulator.manipulate(TEXT);
        printResult.accept(String.format("___StringManipulator___%nResult of converting to uppercase is: %s%n", resultStringManipulator));

        // Counting  all uppercase letters of string  (CountUpperCase)
        int resultCountUpperCase = CountUpperCaseUtil.countUpperCaseUtil(resultStringManipulator, StringListProcessor::countUpperCase);
        printResult.accept(String.format("___CountUpperCase___%nString: %s%nAmount of uppercase: %d %n"
                , resultStringManipulator, resultCountUpperCase));

        // Generating a random number (RandomNumberGenerator)
        int resultRandomNumbersGenerator = RandomNumberGeneratorUtil.getRandomNumber(
                () -> RandomNumberGenerator.generateRandomNumber(MIN_NUMBER_OF_RANGE, MAX_NUMBER_OF_RANGE));
        printResult.accept(String.format("___RandomNumberGenerator___%n Random numbers: %d"
                , resultRandomNumbersGenerator));
    }
}



