//package org.example.services;
//
//import org.junit.*;
//
//import java.util.Date;
//
//public class CalculatorServiceTest {
//    // test method of add two number
//
//    int counter=0;
//
//    @BeforeClass
//    public static void init(){
//        System.out.println("Before all test cases");
//        System.out.println("Start test:"+new Date());
//    }
//    @Before
//    public void beforeEach(){
//        System.out.println("Before Each test case");
//    }
//
//
//    @After
//    public void afterEach(){
//        System.out.println("After Each test case");
//    }
//
//    @Test
//    public void addTwoNumbersTest(){
//        for(int i=1; i<=20; i++){
//            counter+=i;
//        }
//        System.out.println("Test For addTwoNumberTest");
//        int result = CalculatorService.addTwoNumbers(12, 45);
//        System.out.println("counter first case"+counter);
//        int expected=57;
//
//        Assert.assertEquals(expected,result);
//    }
//    @Test
//    public void sumAnyNumberTest(){
//        for(int i=1; i<=5050; i++){
//            counter+=i;
//        }
//        System.out.println("Test For sumAnyNumberTest");
//        int result = CalculatorService.sumAnyNumbers(2, 7, 8, 9);
//        int expected=26;
//        System.out.println("counter second case"+counter);
//        Assert.assertEquals(expected,result);
//    }
//
//    @AfterClass
//    public static void cleanUp(){
//        System.out.println("After all test cases");
//        System.out.println("End test cases "+new Date());
//    }
//}


