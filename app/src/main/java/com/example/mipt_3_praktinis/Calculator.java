package com.example.mipt_3_praktinis;

import org.mariuszgromada.math.mxparser.Expression;

public class Calculator {

    public String calculateResult(String dataToCalculate) {
        try {
            Expression expression = new Expression(dataToCalculate);
            double result = expression.calculate();

            if (Double.isNaN(result)) {
                return "Error";
            } else {
                if (result == (int) result) {
                    return String.valueOf((int) result);
                } else {
                    return String.valueOf(result);
                }
            }
        } catch (Exception e) {
            return "Error";
        }
    }
}
