package Strategy;

public class Inventory {
  private COGS itsCOGS;

  public Inventory(COGS cogs) {
    itsCOGS = cogs;
  }

  public void addPurchase(double quantity, double cost) {
    itsCOGS.purchase(quantity, cost);
  }


  public double getCOGS(double sellQuantity) {
    double calculatedCOGS = 0;

    return itsCOGS.calculateCOGS(sellQuantity);
  }
}
