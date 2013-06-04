package Strategy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.Assert.assertEquals;

@RunWith(JUnit4.class)
public class InventoryTest {
  private Strategy.Inventory iWithFIFO;
  private Strategy.Inventory iWithLIFO;

  @Before
  public void setUp() {
    Strategy.COGS f = new FIFOStrategy();
    iWithFIFO = new Inventory(f);
    Strategy.COGS l = new LIFOStrategy();
    iWithLIFO = new Inventory(l);
  }

  @Test
  public void testNoPriceChangeSellFullLot() {
    iWithFIFO.addPurchase(5.00, 15.00);
    iWithFIFO.addPurchase(5.00, 15.00);
    assertEquals(15.00, iWithFIFO.getCOGS(5.00));
  }

  @Test
  public void testPriceDescreaseSellFullLot() {
    iWithFIFO.addPurchase(5.00, 15.00);
    iWithFIFO.addPurchase(5.00, 5.00);
    assertEquals(15.00, iWithFIFO.getCOGS(5.00));
  }

  @Test
  public void testPriceIncreaseSellFullLot() {
    iWithFIFO.addPurchase(5.00, 500.00);
    iWithFIFO.addPurchase(5.00, 15.00);
    assertEquals(500.00, iWithFIFO.getCOGS(5.00));
  }

  @Test
  public void testPriceIncreaseSellPartialLot() {
    iWithFIFO.addPurchase(5.00, 15.00);
    iWithFIFO.addPurchase(5.00, 500.00);
    assertEquals(115.00, iWithFIFO.getCOGS(6.00));
  }

  @Test
  public void testPriceIncreaseSellAllLot() {
    iWithFIFO.addPurchase(5.00, 15.00);
    iWithFIFO.addPurchase(5.00, 500.00);
    assertEquals(515.00, iWithFIFO.getCOGS(10.00));
  }

  @Test
  public void testPriceIncreaseSellPartial3Lot() {
    iWithFIFO.addPurchase(5.00, 15.00);
    iWithFIFO.addPurchase(5.00, 500.00);
    iWithFIFO.addPurchase(7.00, 35.00);
    assertEquals(530.00, iWithFIFO.getCOGS(13.00));
  }

  @Test
  public void testNoPriceChangeSellFullLot1() {
    iWithLIFO.addPurchase(5.00, 15.00);
    iWithLIFO.addPurchase(5.00, 15.00);
    assertEquals(15.00, iWithLIFO.getCOGS(5.00));
  }

  @Test
  public void testPriceDescreaseSellFullLot1() {
    iWithLIFO.addPurchase(5.00, 15.00);
    iWithLIFO.addPurchase(5.00, 5.00);
    assertEquals(5.00, iWithLIFO.getCOGS(5.00));
  }

  @Test
  public void testPriceIncreaseSellFullLot1() {
    iWithLIFO.addPurchase(5.00, 15.00);
    iWithLIFO.addPurchase(5.00, 500.00);
    assertEquals(500.00, iWithLIFO.getCOGS(5.00));
  }


  @Test
  public void testPriceIncreaseSellPartialLot1() {
    iWithLIFO.addPurchase(5.00, 15.00);
    iWithLIFO.addPurchase(5.00, 500.00);
    assertEquals(503.00, iWithLIFO.getCOGS(6.00));
  }

  @Test
  public void testPriceIncreaseSellAllLot1() {
    iWithLIFO.addPurchase(5.00, 15.00);
    iWithLIFO.addPurchase(5.00, 500.00);
    assertEquals(515.00, iWithLIFO.getCOGS(10.00));
  }

  @Test
  public void testPriceIncreaseSellPartial3Lot1() {
    iWithLIFO.addPurchase(5.00, 15.00);
    iWithLIFO.addPurchase(5.00, 500.00);
    iWithLIFO.addPurchase(7.00, 35.00);
    assertEquals(538.00, iWithLIFO.getCOGS(13.00));
  }

}
