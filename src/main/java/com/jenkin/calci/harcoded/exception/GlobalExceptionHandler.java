package com.jenkin.calci.harcoded.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global Exception Handler for the Calculator application.
 *
 * <p>
 * This class intercepts all exceptions thrown by the application
 * and converts them into meaningful HTTP responses.
 * </p>
 *
 * <p>
 * Using a centralized exception handler keeps controller and service
 * classes clean by separating error handling from business logic.
 * </p>
 *
 * @author Aravind
 * @version 1.0
 * @since 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles all IllegalArgumentExceptions.
     *
     * @param exception exception thrown during request processing
     * @return standardized error response
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(
            IllegalArgumentException exception) {

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }

    /**
     * Handles ArithmeticException.
     * <p>
     * Example:
     * Division by zero.
     *
     * @param exception arithmetic exception
     * @return standardized error response
     */
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handleArithmeticException(
            ArithmeticException exception) {

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }

    /**
     * Handles all unexpected exceptions.
     *
     * @param exception unexpected exception
     * @return standardized internal server error response
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(
            Exception exception) {

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }

}