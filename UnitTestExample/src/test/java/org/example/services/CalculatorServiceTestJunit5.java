package org.example.services;

import org.junit.jupiter.api.*;

public class CalculatorServiceTestJunit5 {

    @BeforeAll
    public static void init(){
        System.out.println("This is single time logic");
    }

    @AfterAll
    public static void cleanUp(){
        System.out.println("After all testcase logic");
    }
    @BeforeEach
    public void beforeEachTestCases(){
        System.out.println("Before Each");
    }
    @AfterEach
    public void afterEachTestCases(){
        System.out.println("After each");
    }

    @Test
    public void addTwoNumbersTest(){
        System.out.println("First Test Case");
        int actualResult = CalculatorService.addTwoNumbers(12, 12);
        int expectedResult = 24;
        Assertions.assertEquals(expectedResult,actualResult,"Test Fail");
    }
    @Test
    @Disabled
    public void addAnyNumbersTest(){
        System.out.println("Second Test Case");
        int actualResult = CalculatorService.sumAnyNumbers(12, 1, 2, 3);
        int expectedResult=18;
        Assertions.assertEquals(expectedResult,actualResult,"Test Fail");
    }
}
