package me.lirui.algo.hashmap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LeetCodeHashMapSolutionTest {

  LeetCodeHashMapSolution mSolution = new LeetCodeHashMapSolution();

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
    String s = null;
    String t = "rat";
    Boolean isAnagram = mSolution.isAnagramFinal(s, t);
    Assert.assertFalse(isAnagram);
  }

  @Test
  public void isAnagramNullParams() {
    String s = null;
    String t = "rat";
    Boolean isAnagram = mSolution.isAnagram(s, t);
    Assert.assertFalse(isAnagram);
  }

  @Test
  public void isAnagramSortNullParams() {
    String s = null;
    String t = "hat";
    Boolean isAnagram = mSolution.isAnagramSort(s, t);
    Assert.assertFalse(isAnagram);
  }

  @Test
  public void isAnagramFinalNullParamt() {
    String s = "art";
    String t = null;
    Boolean isAnagram = mSolution.isAnagramFinal(s, t);
    Assert.assertFalse(isAnagram);
  }

  @Test
  public void isAnagramNullParamt() {
    String s = "art";
    String t = null;
    Boolean isAnagram = mSolution.isAnagram(s, t);
    Assert.assertFalse(isAnagram);
  }

  @Test
  public void isAnagramSortNullParamt() {
    String s = "art";
    String t = null;
    Boolean isAnagram = mSolution.isAnagramSort(s, t);
    Assert.assertFalse(isAnagram);
  }

  @Test
  public void isAnagramFinalAllNullParams() {
    String s = null;
    String t = null;
    Boolean isAnagram = mSolution.isAnagramFinal(s, t);
    Assert.assertTrue(isAnagram);
  }

  @Test
  public void isAnagramAllNullParams() {
    String s = null;
    String t = null;
    Boolean isAnagram = mSolution.isAnagram(s, t);
    Assert.assertTrue(isAnagram);
  }

  @Test
  public void isAnagramSortAllNullParams() {
    String s = null;
    String t = null;
    Boolean isAnagram = mSolution.isAnagramSort(s, t);
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
}
