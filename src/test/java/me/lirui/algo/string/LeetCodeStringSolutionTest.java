package me.lirui.algo.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LeetCodeStringSolutionTest {

  private LeetCodeStringSolution mSolution;

  @Before
  public void setUp() {
    mSolution = new LeetCodeStringSolution();
  }

  @Test
  public void generateParenthesis() {
    List<String> result = mSolution.generateParenthesis(1);
    Assert.assertNotNull(result);
    Assert.assertEquals(1, result.size());
    Assert.assertEquals("()", result.get(0));
  }

  @Test
  public void generateParenthesisTwo() {
    List<String> expect = new ArrayList<>();
    expect.add("(())");
    expect.add("()()");
    List<String> result = mSolution.generateParenthesis(2);
    Assert.assertNotNull(result);
    Assert.assertEquals(2, result.size());
    Assert.assertEquals(new HashSet<>(expect), new HashSet<>(result));
  }

  @Test
  public void strStr() {
    int index = mSolution.strStr("hello", "ll");
    Assert.assertEquals(2, index);
  }

  @Test
  public void strStr1() {
    int index = mSolution.strStr("aaaaa", "bba");
    Assert.assertEquals(-1, index);
  }

  @Test
  public void strStr2() {
    int index = mSolution.strStr("aaaa", "");
    Assert.assertEquals(0,index);
  }

  @Test
  public void strStrInstinct() {
    int index = mSolution.strStrInstinct("hello", "ll");
    Assert.assertEquals(2, index);
  }

  @Test
  public void strStrInstinct1() {
    int index = mSolution.strStrInstinct("aaaaa", "bba");
    Assert.assertEquals(-1, index);
  }

  @Test
  public void strStrInstinct2() {
    int index = mSolution.strStrInstinct("aaaa", "");
    Assert.assertEquals(0,index);
  }
}
