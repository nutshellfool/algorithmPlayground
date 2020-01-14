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
}
