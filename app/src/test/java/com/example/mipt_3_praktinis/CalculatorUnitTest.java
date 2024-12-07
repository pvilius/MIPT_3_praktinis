package com.example.mipt_3_praktinis;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorUnitTest {

    @Test
    public void Given_ValidExpression_When_calculateResultIsCalled_Then_ReturnsCorrectResult() {
        Calculator calculator = new Calculator();
        final String givenExpression = "3+5";
        final String expectedResult = "8";
        final String actualResult = calculator.calculateResult(givenExpression);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_InvalidExpression_When_calculateResultIsCalled_Then_ReturnsError() {
        Calculator calculator = new Calculator();
        final String givenExpression = "3+/5";
        final String expectedResult = "Error";
        final String actualResult = calculator.calculateResult(givenExpression);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_ExpressionWithDecimalResult_When_calculateResultIsCalled_Then_ReturnsCorrectResult() {
        Calculator calculator = new Calculator();
        final String givenExpression = "3/2";
        final String expectedResult = "1.5";
        final String actualResult = calculator.calculateResult(givenExpression);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_ZeroDivision_When_calculateResultIsCalled_Then_ReturnsError() {
        Calculator calculator = new Calculator();
        final String givenExpression = "3/0";
        final String expectedResult = "Error";
        final String actualResult = calculator.calculateResult(givenExpression);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_ExpressionWithNegativeNumbers_When_calculateResultIsCalled_Then_ReturnsCorrectResult() {
        Calculator calculator = new Calculator();
        final String givenExpression = "-5+3";
        final String expectedResult = "-2";
        final String actualResult = calculator.calculateResult(givenExpression);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_ExpressionWithMultipleOperations_When_calculateResultIsCalled_Then_ReturnsCorrectResult() {
        Calculator calculator = new Calculator();
        final String givenExpression = "2+3*4";
        final String expectedResult = "14";
        final String actualResult = calculator.calculateResult(givenExpression);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_ExpressionWithParentheses_When_calculateResultIsCalled_Then_ReturnsCorrectResult() {
        Calculator calculator = new Calculator();
        final String givenExpression = "(2+3)*4";
        final String expectedResult = "20";
        final String actualResult = calculator.calculateResult(givenExpression);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_ExpressionWithExponentiation_When_calculateResultIsCalled_Then_ReturnsCorrectResult() {
        Calculator calculator = new Calculator();
        final String givenExpression = "2^3";
        final String expectedResult = "8";
        final String actualResult = calculator.calculateResult(givenExpression);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_ExpressionWithMultipleDecimalPoints_When_calculateResultIsCalled_Then_ReturnsCorrectResult() {
        Calculator calculator = new Calculator();
        final String givenExpression = "3.5+2.1";
        final String expectedResult = "5.6";
        final String actualResult = calculator.calculateResult(givenExpression);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_EmptyExpression_When_calculateResultIsCalled_Then_ReturnsError() {
        Calculator calculator = new Calculator();
        final String givenExpression = "";
        final String expectedResult = "Error";
        final String actualResult = calculator.calculateResult(givenExpression);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_ExpressionWithTrailingOperators_When_calculateResultIsCalled_Then_ReturnsAsIfZeroIsAdded() {
        Calculator calculator = new Calculator();
        final String givenExpression = "3+5+";
        final String expectedResult = "8";
        final String actualResult = calculator.calculateResult(givenExpression);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_SingleDigitExpression_When_calculateResultIsCalled_Then_ReturnsSameResult() {
        Calculator calculator = new Calculator();
        final String givenExpression = "7";
        final String expectedResult = "7";
        final String actualResult = calculator.calculateResult(givenExpression);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_LargeNumbers_When_calculateResultIsCalled_Then_ReturnsCorrectResult() {
        Calculator calculator = new Calculator();
        final String givenExpression = "1000000+1000000";
        final String expectedResult = "2000000";
        final String actualResult = calculator.calculateResult(givenExpression);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_ExpressionWithOperatorBeforeNumber_When_calculateResultIsCalled_Then_ReturnsAsZeroIsBeforeTheOperator() {
        Calculator calculator = new Calculator();
        final String givenExpression = "+5";
        final String expectedResult = "5";
        final String actualResult = calculator.calculateResult(givenExpression);
        assertEquals(expectedResult, actualResult);
    }
}
