package me.lirui.algo.map;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LeetCodeHashMapSolutionTest {

  private final LeetCodeHashMapSolution mSolution = new LeetCodeHashMapSolution();

  @Before
  public void setUp() {}

  @After
  public void tearDown() {}

  //
  //  Valid Anagram - https://leetcode.com/problems/valid-anagram/
  //
  @Test
  public void isAnagramFinal() {
    String s = "art";
    String t = "rat";
    Boolean isAnagram = mSolution.isAnagramFinal(s, t);
    Assert.assertTrue(isAnagram);
  }

  @Test
  public void isAnagram() {
    String s = "art";
    String t = "rat";
    Boolean isAnagram = mSolution.isAnagram(s, t);
    Assert.assertTrue(isAnagram);
  }

  @Test
  public void isAnagramSort() {
    String s = "art";
    String t = "rat";
    Boolean isAnagram = mSolution.isAnagramSort(s, t);
    Assert.assertTrue(isAnagram);
  }

  @Test
  public void isAnagramFinalNot() {
    String s = "art";
    String t = "hat";
    Boolean isAnagram = mSolution.isAnagramFinal(s, t);
    Assert.assertFalse(isAnagram);
  }

  @Test
  public void isAnagramNot() {
    String s = "art";
    String t = "hat";
    Boolean isAnagram = mSolution.isAnagram(s, t);
    Assert.assertFalse(isAnagram);
  }

  @Test
  public void isAnagramSortNot() {
    String s = "art";
    String t = "hat";
    Boolean isAnagram = mSolution.isAnagramSort(s, t);
    Assert.assertFalse(isAnagram);
  }

  @Test
  public void isAnagramFinalNullParams() {
    String t = "rat";
    Boolean isAnagram = mSolution.isAnagramFinal(null, t);
    Assert.assertFalse(isAnagram);
  }

  @Test
  public void isAnagramNullParams() {
    String t = "rat";
    Boolean isAnagram = mSolution.isAnagram(null, t);
    Assert.assertFalse(isAnagram);
  }

  @Test
  public void isAnagramSortNullParams() {
    String t = "hat";
    Boolean isAnagram = mSolution.isAnagramSort(null, t);
    Assert.assertFalse(isAnagram);
  }

  @Test
  public void isAnagramFinalNullParamt() {
    String s = "art";
    Boolean isAnagram = mSolution.isAnagramFinal(s, null);
    Assert.assertFalse(isAnagram);
  }

  @Test
  public void isAnagramNullParamt() {
    String s = "art";
    Boolean isAnagram = mSolution.isAnagram(s, null);
    Assert.assertFalse(isAnagram);
  }

  @Test
  public void isAnagramSortNullParamt() {
    String s = "art";
    Boolean isAnagram = mSolution.isAnagramSort(s, null);
    Assert.assertFalse(isAnagram);
  }

  @Test
  public void isAnagramFinalAllNullParams() {
    Boolean isAnagram = mSolution.isAnagramFinal(null, null);
    Assert.assertTrue(isAnagram);
  }

  @Test
  public void isAnagramAllNullParams() {
    Boolean isAnagram = mSolution.isAnagram(null, null);
    Assert.assertTrue(isAnagram);
  }

  @Test
  public void isAnagramSortAllNullParams() {
    Boolean isAnagram = mSolution.isAnagramSort(null, null);
    Assert.assertTrue(isAnagram);
  }

  @Test
  public void isAnagramFinalLength() {
    String s = "accept";
    String t = "accepted";
    Boolean isAnagram = mSolution.isAnagramFinal(s, t);
    Assert.assertFalse(isAnagram);
  }

  @Test
  public void isAnagramLength() {
    String s = "accept";
    String t = "accepted";
    Boolean isAnagram = mSolution.isAnagram(s, t);
    Assert.assertFalse(isAnagram);
  }

  @Test
  public void isAnagramSortLength() {
    String s = "accept";
    String t = "accepted";
    Boolean isAnagram = mSolution.isAnagramSort(s, t);
    Assert.assertFalse(isAnagram);
  }
  //
  //  Valid Anagram - https://leetcode.com/problems/valid-anagram/
  //  End
  //

  //
  //  Two Sum - https://leetcode.com/problems/two-sum/
  //
  @Test
  public void twoSum() {
    int[] arr = {2, 7, 11, 15};
    int[] tar = {1, 0};
    int[] res = mSolution.twoSum(arr, 9);

    Arrays.sort(res);
    Arrays.sort(tar);

    Assert.assertNotNull(res);
    Assert.assertTrue(Arrays.equals(res, tar));
  }

  @Test
  public void twoSumBrutalforceWay() {
    int[] arr = {2, 7, 11, 15};
    int[] tar = {0, 1};
    int[] res = mSolution.twoSumInBrutalForceWay(arr, 9);

    Arrays.sort(tar);
    Arrays.sort(res);

    Assert.assertNotNull(res);
    Assert.assertTrue(Arrays.equals(res, tar));
  }

  //
  //  Two Sum - https://leetcode.com/problems/two-sum/
  //  End

  //
  //  3Sum - https://leetcode.com/problems/3sum/
  //
  @Test
  public void threeSum() {
    int[] arr = {-1, 0, 1, 2, -1, -4};

    List<List<Integer>> res = mSolution.threeSum(arr);

    Assert.assertNotNull(res);
    Assert.assertEquals(2, res.size());
    Set<List<Integer>> resultSet = new HashSet<>(res);
    Set<List<Integer>> expected = new HashSet<>();
    Integer[] a = {-1, -1, 2};
    expected.add(Arrays.asList(a));
    Integer[] b = {-1, 0, 1};
    expected.add(Arrays.asList(b));

    Assert.assertEquals(expected, resultSet);
    //    Assert.assertTrue(resultSet.contains(a));
    //    Assert.assertTrue(resultSet.contains(b));
    //    System.out.printf(res.toString());
    //    System.out.printf("\n");
  }

  @Test
  public void threeSumWithMap() {
    int[] arr = {-1, 0, 1, 2, -1, -4};

    List<List<Integer>> res = mSolution.threeSumWithMap(arr);

    Assert.assertNotNull(res);
    Assert.assertEquals(2, res.size());
    Set<List<Integer>> resultSet = new HashSet<>(res);
    Set<List<Integer>> expected = new HashSet<>();
    Integer[] a = {-1, -1, 2};
    expected.add(Arrays.asList(a));
    Integer[] b = {-1, 0, 1};
    expected.add(Arrays.asList(b));

    Assert.assertEquals(expected, resultSet);
    //    System.out.printf(res.toString());
    //    System.out.printf("\n");
  }

  @Test
  public void threeSumInBrutalForceWay() {
    int[] arr = {-1, 0, 1, 2, -1, -4};

    List<List<Integer>> res = mSolution.threeSumInBrutalForceWay(arr);

    Assert.assertNotNull(res);
    Assert.assertEquals(2, res.size());
    Set<List<Integer>> resultSet = new HashSet<>(res);
    Set<List<Integer>> expected = new HashSet<>();
    Integer[] a = {-1, -1, 2};
    expected.add(Arrays.asList(a));
    Integer[] b = {-1, 0, 1};
    expected.add(Arrays.asList(b));

    Assert.assertEquals(expected, resultSet);
    //    System.out.printf(res.toString());
    //    System.out.printf("\n");
  }

  //
  //  3Sum - https://leetcode.com/problems/3sum/
  //  End

  //
  //  4Sum - https://leetcode.com/problems/4sum/
  //
  @Test
  public void fourSum() {
    int[] arr = {1, 0, -1, 0, -2, 2};

    List<List<Integer>> res = mSolution.fourSum(arr, 0);
    Assert.assertNotNull(res);
    Assert.assertEquals(3, res.size());
    Set<List<Integer>> resultSet = new HashSet<>(res);

    Set<List<Integer>> expected = new HashSet<>();
    Integer[] a = {-2, -1, 1, 2};
    expected.add(Arrays.asList(a));
    Integer[] b = {-2, 0, 0, 2};
    expected.add(Arrays.asList(b));
    Integer[] c = {-1, 0, 0, 1};
    expected.add(Arrays.asList(c));

    Assert.assertEquals(expected, resultSet);
  }

  @Test
  public void fourSumWithMap() {
    int[] arr = {1, 0, -1, 0, -2, 2};

    List<List<Integer>> res = mSolution.fourSumWithMap(arr, 0);
    Assert.assertNotNull(res);
    Assert.assertEquals(3, res.size());
    Set<List<Integer>> resultSet = new HashSet<>(res);

    Set<List<Integer>> expected = new HashSet<>();
    Integer[] a = {-2, -1, 1, 2};
    expected.add(Arrays.asList(a));
    Integer[] b = {-2, 0, 0, 2};
    expected.add(Arrays.asList(b));
    Integer[] c = {-1, 0, 0, 1};
    expected.add(Arrays.asList(c));

    Assert.assertEquals(expected, resultSet);
  }

  @Test
  public void fourSumInBrutalForceWay() {
    int[] arr = {1, 0, -1, 0, -2, 2};

    List<List<Integer>> res = mSolution.fourSumInBrutalForceWay(arr, 0);
    Assert.assertNotNull(res);
    Assert.assertEquals(3, res.size());
    Set<List<Integer>> resultSet = new HashSet<>(res);

    Set<List<Integer>> expected = new HashSet<>();
    Integer[] a = {-2, -1, 1, 2};
    expected.add(Arrays.asList(a));
    Integer[] b = {-2, 0, 0, 2};
    expected.add(Arrays.asList(b));
    Integer[] c = {-1, 0, 0, 1};
    expected.add(Arrays.asList(c));

    Assert.assertEquals(expected, resultSet);
  }
  //
  //  4Sum - https://leetcode.com/problems/4sum/
  //  End
}
