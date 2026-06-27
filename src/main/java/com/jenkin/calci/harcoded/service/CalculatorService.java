package com.jenkin.calci.harcoded.service;

import com.jenkin.calci.harcoded.constant.ApiConstant;
import com.jenkin.calci.harcoded.dto.CalculatorDto;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    /**
     * Executes the requested calculator operation.
     *
     * @param dto Calculator request
     * @return Calculator response with calculated result
     */
    public CalculatorDto execute(CalculatorDto dto) {

        double result;

        switch (dto.action()) {

            case ApiConstant.ADD:
                result = add(dto.value1(), dto.value2());
                break;

            case ApiConstant.SUBTRACT:
                result = subtract(dto.value1(), dto.value2());
                break;

            case ApiConstant.MULTIPLY:
                result = multiply(dto.value1(), dto.value2());
                break;

            case ApiConstant.DIVIDE:
                result = divide(dto.value1(), dto.value2());
                break;

            case ApiConstant.SQUARE:
                result = square(dto.value1());
                break;

            case ApiConstant.SQRT:
                result = squareRoot(dto.value1());
                break;

            case ApiConstant.FACTORIAL:
                result = factorial((int) dto.value1());
                break;

            case ApiConstant.PERCENTAGE:
                result = percentage(dto.value1(), dto.value2());
                break;

            default:
                throw new IllegalArgumentException("Invalid calculator action : " + dto.action());
        }

        return new CalculatorDto(
                dto.value1(),
                dto.value2(),
                dto.action(),
                result);
    }

    private double add(double value1, double value2) {
        return value1 + value2;
    }

    private double subtract(double value1, double value2) {
        return value1 - value2;
    }

    private double multiply(double value1, double value2) {
        return value1 * value2;
    }

    private double divide(double value1, double value2) {

        if (value2 == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }

        return value1 / value2;
    }

    private double square(double value) {
        return value * value;
    }

    private double squareRoot(double value) {

        if (value < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed.");
        }

        return Math.sqrt(value);
    }

    private double factorial(int number) {

        if (number < 0) {
            throw new IllegalArgumentException("Negative factorial is not allowed.");
        }

        double factorial = 1;

        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }

        return factorial;
    }

    private double percentage(double value, double percentage) {
        return (value * percentage) / 100;
    }

}