package com.TemplateMethod;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.Assert.assertEquals;

@RunWith(JUnit4.class)
public class LIFOTest {
  private LIFO l;

  @Before
  public void setUp() {
    l = new LIFO();
  }

  @Test
  public void testNoPriceChangeSellFullLot() {
    l.purchase(5.00, 15.00);
    l.purchase(5.00, 15.00);
    assertEquals(15.00, l.calculateCOGS(5.00));
  }

  @Test
  public void testPriceDescreaseSellFullLot() {
    l.purchase(5.00, 15.00);
    l.purchase(5.00, 5.00);
    assertEquals(5.00, l.calculateCOGS(5.00));
  }

  @Test
  public void testPriceIncreaseSellFullLot() {
    l.purchase(5.00, 15.00);
    l.purchase(5.00, 500.00);
    assertEquals(500.00, l.calculateCOGS(5.00));
  }


  @Test
  public void testPriceIncreaseSellPartialLot() {
    l.purchase(5.00, 15.00);
    l.purchase(5.00, 500.00);
    assertEquals(503.00, l.calculateCOGS(6.00));
  }

  @Test
  public void testPriceIncreaseSellAllLot() {
    l.purchase(5.00, 15.00);
    l.purchase(5.00, 500.00);
    assertEquals(515.00, l.calculateCOGS(10.00));
  }

  @Test
  public void testPriceIncreaseSellPartial3Lot() {
    l.purchase(5.00, 15.00);
    l.purchase(5.00, 500.00);
    l.purchase(7.00, 35.00);
    assertEquals(538.00, l.calculateCOGS(13.00));
  }


}
