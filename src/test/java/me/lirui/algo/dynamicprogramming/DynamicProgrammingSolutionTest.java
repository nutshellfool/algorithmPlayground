package me.lirui.algo.dynamicprogramming;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DynamicProgrammingSolutionTest {

  long[] factorials = {1
      ,1
      ,2
      ,6
      ,24
      ,120
      ,720
      ,5040
      ,40320
      ,362880
      ,3628800
      ,39916800
      ,479001600 };

  private DynamicProgrammingSolution mSolution;

  @Before
  public void setUp() throws Exception {
    mSolution = new DynamicProgrammingSolution();
  }

  @Test
  public void factorial() {
    double factorialValue;
    for (int i = 0; i < factorials.length; i++) {
       factorialValue = mSolution.factorial(i);
       assertEquals(factorials[i], factorialValue, factorialValue * 0.08);
    }
  }

  @Test
  public void factorialRecursion() {
    long factorialValue;
    for (int i = 0; i < factorials.length; i++) {
      factorialValue = mSolution.factorialRecursion(i);
      assertEquals(factorials[i], factorialValue);
    }
  }

  @Test
  public void factorialRecursionWithMemo() {
    long factorialValue;
    for (int i = 0; i < factorials.length; i++) {
      factorialValue = mSolution.factorialRecursionWithMemo(i);
      assertEquals(factorials[i], factorialValue);
    }
  }

  @Test
  public void factorialDynamicProgramming() {
    long factorialValue;
    for (int i = 0; i < factorials.length; i++) {
      factorialValue = mSolution.factorialDynamicProgramming(i);
      assertEquals(factorials[i], factorialValue);
    }
  }
}