package me.lirui.algo.unionfind;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UnionFindTest {

  private UnionFind mUF;

  @Before
  public void setUp() {
    mUF = new UnionFind(5);
  }

  @Test
  public void union() {
    mUF.union(0, 1);
    Assert.assertTrue(mUF.connected(0, 1));
  }

  @Test
  public void connected() {
    boolean connected = mUF.connected(0, 1);
    Assert.assertFalse(connected);
  }
}