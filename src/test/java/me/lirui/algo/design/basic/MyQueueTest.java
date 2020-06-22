package me.lirui.algo.design.basic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyQueueTest {

  private MyQueue queue;

  @Before
  public void setUp() {
    queue = new MyQueue();
  }

  @Test
  public void happyCase() {
    queue.push(1);
    queue.push(2);
    int peeked = queue.peek();
    int poped = queue.pop();
    boolean isEmpty = queue.empty();

    Assert.assertEquals(1, peeked);
    Assert.assertEquals(1, poped);
    Assert.assertFalse(isEmpty);
  }
}