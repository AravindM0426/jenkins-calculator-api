package com.jenkin.calci.harcoded.dto;

public record CalculatorDto(
        double value1,
        double value2,
        String action,
        double result
) {
    public static final double VAL1 = 10;
    public static final double VAL2 = 20;
}