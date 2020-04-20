package me.lirui.algo.unionfind;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LeetCodeUnionFindSolutionTest {

  private LeetCodeUnionFindSolution mSolution;

  @Before
  public void setUp() {
    mSolution = new LeetCodeUnionFindSolution();
  }

  @Test
  public void numIslands() {
    char[][] grid = {
        {'1', '1', '1', '1', '0'},
        {'1', '1', '0', '1', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '0', '0', '0'}};
    int numOfIslands = this.mSolution.numIslands(grid);
    Assert.assertEquals(1, numOfIslands);
  }

  @Test
  public void numIslands1() {
    char[][] grid = {
        {'1', '1', '0', '0', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '1', '0', '0'},
        {'0', '0', '0', '1', '1'}};
    int numOfIslands = this.mSolution.numIslands(grid);
    Assert.assertEquals(3, numOfIslands);
  }

  @Test
  public void numIslandsDFS() {
    char[][] grid = {
        {'1', '1', '1', '1', '0'},
        {'1', '1', '0', '1', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '0', '0', '0'}};
    int numOfIslands = this.mSolution.numIslandsDFS(grid);
    Assert.assertEquals(1, numOfIslands);
  }

  @Test
  public void numIslandsDFS1() {
    char[][] grid = {
        {'1', '1', '0', '0', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '1', '0', '0'},
        {'0', '0', '0', '1', '1'}};
    int numOfIslands = this.mSolution.numIslandsDFS(grid);
    Assert.assertEquals(3, numOfIslands);
  }

  @Test
  public void numIslandsDFSNoMoreExtraSpace() {
    char[][] grid = {
        {'1', '1', '1', '1', '0'},
        {'1', '1', '0', '1', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '0', '0', '0'}};
    int numOfIslands = this.mSolution.numIslandsDFSNoMoreExtraSpace(grid);
    Assert.assertEquals(1, numOfIslands);
  }

  @Test
  public void numIslandsDFSNoMoreExtraSpace1() {
    char[][] grid = {
        {'1', '1', '0', '0', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '1', '0', '0'},
        {'0', '0', '0', '1', '1'}};
    int numOfIslands = this.mSolution.numIslandsDFSNoMoreExtraSpace(grid);
    Assert.assertEquals(3, numOfIslands);
  }

  @Test
  public void findCircleNum() {
    int[][] grid = {
        {1,1,0},
        {1,1,0},
        {0,0,1}};
    int numOfIslands = this.mSolution.findCircleNum(grid);
    Assert.assertEquals(2, numOfIslands);
  }

  @Test
  public void findCircleNum1() {
    int[][] grid = {
        {1,1,0},
        {1,1,1},
        {0,1,1}};
    int numOfIslands = this.mSolution.findCircleNum(grid);
    Assert.assertEquals(1, numOfIslands);
  }

  @Test
  public void findCircleNum2() {
    int[][] grid = {
        {1,0,0,1},
        {0,1,1,0},
        {0,1,1,1},
        {1,0,1,1}};
    int numOfIslands = this.mSolution.findCircleNum(grid);
    Assert.assertEquals(1, numOfIslands);
  }
}