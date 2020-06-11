package me.lirui.algo.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LeetCodeBacktrackingSolutionTest {

  private LeetCodeBacktrackingSolution mSolution;

  @Before
  public void setUp() {
    mSolution = new LeetCodeBacktrackingSolution();
  }

  @Test
  public void combine() {
    List<List<Integer>> expectList = new ArrayList<>();
    List<Integer> itemList = new ArrayList<>();
    Collections.addAll(itemList, 2, 4);
    expectList.add(itemList);
    List<Integer> itemList1 = new ArrayList<>();
    Collections.addAll(itemList1, 3, 4);
    expectList.add(itemList1);
    List<Integer> itemList2 = new ArrayList<>();
    Collections.addAll(itemList2, 2, 3);
    expectList.add(itemList2);
    List<Integer> itemList3 = new ArrayList<>();
    Collections.addAll(itemList3, 1, 2);
    expectList.add(itemList3);
    List<Integer> itemList4 = new ArrayList<>();
    Collections.addAll(itemList4, 1, 3);
    expectList.add(itemList4);
    List<Integer> itemList5 = new ArrayList<>();
    Collections.addAll(itemList5, 1, 4);
    expectList.add(itemList5);

    List<List<Integer>> resultList = mSolution.combine(4, 2);
    Assert.assertNotNull(resultList);
    Assert.assertEquals(expectList.size(), resultList.size());
    Assert.assertTrue(expectList.containsAll(resultList) && resultList.containsAll(expectList));
  }
}