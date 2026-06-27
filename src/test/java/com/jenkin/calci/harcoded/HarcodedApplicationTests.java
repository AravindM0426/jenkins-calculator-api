package com.jenkin.calci.harcoded;

import com.jenkin.calci.harcoded.constant.ApiConstant;
import com.jenkin.calci.harcoded.dto.CalculatorDto;
import com.jenkin.calci.harcoded.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HarcodedApplicationTests {

	@Autowired
	private CalculatorService calculatorService;

	@Test
	void contextLoads() {
		assertNotNull(calculatorService);
	}

	@Test
	void testAddition() {

		CalculatorDto dto =
				new CalculatorDto(10,20, ApiConstant.ADD,0);

		CalculatorDto result = calculatorService.execute(dto);

		assertEquals(30,result.result());
	}

	@Test
	void testSubtraction() {

		CalculatorDto dto =
				new CalculatorDto(10,20, ApiConstant.SUBTRACT,0);

		CalculatorDto result = calculatorService.execute(dto);

		assertEquals(-10,result.result());
	}

	@Test
	void testMultiplication() {

		CalculatorDto dto =
				new CalculatorDto(10,20, ApiConstant.MULTIPLY,0);

		CalculatorDto result = calculatorService.execute(dto);

		assertEquals(200,result.result());
	}

	@Test
	void testDivision() {

		CalculatorDto dto =
				new CalculatorDto(10,20, ApiConstant.DIVIDE,0);

		CalculatorDto result = calculatorService.execute(dto);

		assertEquals(0.5,result.result());
	}

	@Test
	void testSquare() {

		CalculatorDto dto =
				new CalculatorDto(10,20, ApiConstant.SQUARE,0);

		CalculatorDto result = calculatorService.execute(dto);

		assertEquals(100,result.result());
	}

	@Test
	void testSquareRoot() {

		CalculatorDto dto =
				new CalculatorDto(10,20, ApiConstant.SQRT,0);

		CalculatorDto result = calculatorService.execute(dto);

		assertEquals(Math.sqrt(10),result.result());
	}

	@Test
	void testFactorial() {

		CalculatorDto dto =
				new CalculatorDto(10,20, ApiConstant.FACTORIAL,0);

		CalculatorDto result = calculatorService.execute(dto);

		assertEquals(3628800,result.result());
	}

	@Test
	void testPercentage() {

		CalculatorDto dto =
				new CalculatorDto(10,20, ApiConstant.PERCENTAGE,0);

		CalculatorDto result = calculatorService.execute(dto);

		assertEquals(2,result.result());
	}

	@Test
	void testDivideByZero() {

		CalculatorDto dto =
				new CalculatorDto(10,0, ApiConstant.DIVIDE,0);

		assertThrows(
				ArithmeticException.class,
				() -> calculatorService.execute(dto)
		);
	}

	@Test
	void testNegativeSquareRoot() {

		CalculatorDto dto =
				new CalculatorDto(-10,20, ApiConstant.SQRT,0);

		assertThrows(
				IllegalArgumentException.class,
				() -> calculatorService.execute(dto)
		);
	}

	@Test
	void testNegativeFactorial() {

		CalculatorDto dto =
				new CalculatorDto(-5,20, ApiConstant.FACTORIAL,0);

		assertThrows(
				IllegalArgumentException.class,
				() -> calculatorService.execute(dto)
		);
	}

	@Test
	void testInvalidAction() {

		CalculatorDto dto =
				new CalculatorDto(10,20,"INVALID",0);

		assertThrows(
				IllegalArgumentException.class,
				() -> calculatorService.execute(dto)
		);
	}

	/*
	 * ============================================================
	 * INTENTIONAL FAILURE TESTS FOR JENKINS DEMO
	 * Uncomment whenever you want Jenkins build to FAIL.
	 * ============================================================
	 */

    
    @Test
    void testAdditionFailure() {

        CalculatorDto dto =
                new CalculatorDto(10,20, ApiConstant.ADD,0);

        CalculatorDto result = calculatorService.execute(dto);

        assertEquals(999,result.result());
    }

    @Test
    void testMultiplicationFailure() {

        CalculatorDto dto =
                new CalculatorDto(10,20, ApiConstant.MULTIPLY,0);

        CalculatorDto result = calculatorService.execute(dto);

        assertEquals(1000,result.result());
    }


}