package Strategy;

import java.util.ArrayList;
import java.util.List;

public class LIFOStrategy implements COGS {
  private List<double[]> purchases;

  public LIFOStrategy() {
    purchases = new ArrayList<double[]>();
  }

  public void purchase(double quantity, double cost) {
    purchases.add(new double[] { quantity, cost });
  }

  @Override
  public double calculateCOGS(double sellQuantity) {
    double calculatedCOGS = 0;

    for(int i=purchases.size()-1; i >=0; i--) {
      double lotUnitCost = purchases.get(i)[1]/purchases.get(i)[0];
      double lotQuantity = purchases.get(i)[0];
      double lotCost = purchases.get(i)[1];

      if (sellQuantity >= lotQuantity) {
        sellQuantity -= lotQuantity;
        calculatedCOGS += lotCost;
      }
      else
        calculatedCOGS += lotUnitCost * sellQuantity;
    }

    return calculatedCOGS;
  }

}
