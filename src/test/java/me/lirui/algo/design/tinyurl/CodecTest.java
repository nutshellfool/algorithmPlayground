package me.lirui.algo.design.tinyurl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CodecTest {

  private Codec mTinyURL;

  @Before
  public void setUp() {
    mTinyURL = new Codec();
  }

  @After
  public void tearDown() {
  }

  @Test
  public void happyCaseTest() {
    String originURL = "https://leetcode.com/problems/design-tinyurl";
    String encoded = mTinyURL.encode(originURL);
    String decoded = mTinyURL.decode(encoded);

    Assert.assertNotNull(encoded);
    Assert.assertNotNull(decoded);
    Assert.assertEquals(originURL, decoded);
    Assert.assertTrue(encoded.length() < decoded.length());
  }

  @Test(expected = RuntimeException.class)
  public void negativeValueHexDecimalToBase62Test() {
    int negative1 = -1;
    mTinyURL.hexDecimalTo62BaseDecimal(negative1);
  }

  @Test
  public void withInRangeHexDecimalToBase62LowBoundaryTest() {
    int value = 61;
    String base62Str = mTinyURL.hexDecimalTo62BaseDecimal(value);
    Assert.assertNotNull(base62Str);
    Assert.assertEquals("9", base62Str);
  }

  @Test
  public void withInRangeHexDecimalToBase62BoundaryTest() {
    int value = 62;
    String base62Str = mTinyURL.hexDecimalTo62BaseDecimal(value);
    Assert.assertNotNull(base62Str);
    Assert.assertEquals("ba", base62Str);
  }

  @Test
  public void withInRangeHexDecimalToBase62HighBoundaryTest() {
    int value = 63;
    String base62Str = mTinyURL.hexDecimalTo62BaseDecimal(value);
    Assert.assertNotNull(base62Str);
    Assert.assertEquals("bb", base62Str);
  }
}