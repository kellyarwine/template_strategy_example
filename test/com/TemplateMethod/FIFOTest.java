package com.TemplateMethod;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.Assert.assertEquals;

@RunWith(JUnit4.class)
public class FIFOTest {
  private FIFO f;

  @Before
  public void setUp() {
    f = new FIFO();
  }

  @Test
  public void testNoPriceChangeSellFullLot() {
    f.purchase(5.00, 15.00);
    f.purchase(5.00, 15.00);
    assertEquals(15.00, f.calculateCOGS(5.00));
  }

  @Test
  public void testPriceDescreaseSellFullLot() {
    f.purchase(5.00, 15.00);
    f.purchase(5.00, 5.00);
    assertEquals(15.00, f.calculateCOGS(5.00));
  }

  @Test
  public void testPriceIncreaseSellFullLot() {
    f.purchase(5.00, 500.00);
    f.purchase(5.00, 15.00);
    assertEquals(500.00, f.calculateCOGS(5.00));
  }


  @Test
  public void testPriceIncreaseSellPartialLot() {
    f.purchase(5.00, 15.00);
    f.purchase(5.00, 500.00);
    assertEquals(115.00, f.calculateCOGS(6.00));
  }

  @Test
  public void testPriceIncreaseSellAllLot() {
    f.purchase(5.00, 15.00);
    f.purchase(5.00, 500.00);
    assertEquals(515.00, f.calculateCOGS(10.00));
  }

  @Test
  public void testPriceIncreaseSellPartial3Lot() {
    f.purchase(5.00, 15.00);
    f.purchase(5.00, 500.00);
    f.purchase(7.00, 35.00);
    assertEquals(530.00, f.calculateCOGS(13.00));
  }

}
