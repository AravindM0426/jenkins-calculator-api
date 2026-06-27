package com.jenkin.calci.harcoded.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jenkin.calci.harcoded.constant.ApiConstant;
import com.jenkin.calci.harcoded.dto.CalculatorDto;
import com.jenkin.calci.harcoded.service.CalculatorService;

/**
 * REST Controller responsible for exposing calculator operations.
 *
 * @author Aravind
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/add")
    public CalculatorDto add() {
        return calculatorService.execute(
                new CalculatorDto(CalculatorDto.VAL1, CalculatorDto.VAL2, ApiConstant.ADD, 0));
    }

    @GetMapping("/subtract")
    public CalculatorDto subtract() {
        return calculatorService.execute(
                new CalculatorDto(CalculatorDto.VAL1, CalculatorDto.VAL2, ApiConstant.SUBTRACT, 0));
    }

    @GetMapping("/multiply")
    public CalculatorDto multiply() {
        return calculatorService.execute(
                new CalculatorDto(CalculatorDto.VAL1, CalculatorDto.VAL2, ApiConstant.MULTIPLY, 0));
    }

    @GetMapping("/divide")
    public CalculatorDto divide() {
        return calculatorService.execute(
                new CalculatorDto(CalculatorDto.VAL1, CalculatorDto.VAL2, ApiConstant.DIVIDE, 0));
    }

    @GetMapping("/square")
    public CalculatorDto square() {
        return calculatorService.execute(
                new CalculatorDto(CalculatorDto.VAL1, CalculatorDto.VAL2, ApiConstant.SQUARE, 0));
    }

    @GetMapping("/sqrt")
    public CalculatorDto squareRoot() {
        return calculatorService.execute(
                new CalculatorDto(CalculatorDto.VAL1, CalculatorDto.VAL2, ApiConstant.SQRT, 0));
    }

    @GetMapping("/factorial")
    public CalculatorDto factorial() {
        return calculatorService.execute(
                new CalculatorDto(CalculatorDto.VAL1, CalculatorDto.VAL2, ApiConstant.FACTORIAL, 0));
    }

    @GetMapping("/percentage")
    public CalculatorDto percentage() {
        return calculatorService.execute(
                new CalculatorDto(CalculatorDto.VAL1, CalculatorDto.VAL2, ApiConstant.PERCENTAGE, 0));
    }
}