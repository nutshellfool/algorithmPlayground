package me.lirui.algo.design.basic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyStackTest {

  private MyStack myStack;

  @Before
  public void setUp() {
    myStack = new MyStack();
  }

  @Test
  public void happyCase() {
    myStack.push(1);
    myStack.push(2);
    int top = myStack.top();
    int param2 = myStack.pop();
    boolean isEmpty = myStack.empty();

    Assert.assertEquals(2, top);
    Assert.assertEquals(2, param2);
    Assert.assertFalse(isEmpty);
  }
}