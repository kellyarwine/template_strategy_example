package com.TemplateMethod;

public abstract class COGS {
  public double quantity;
  public double lotQuantity;
  public double lotCost;
  public double lotUnitCost;

  public double doCalculation() {
    double calculatedCOGS = 0;

    if (quantity >= lotQuantity) {
      quantity -= lotQuantity;
      return lotCost;
    }
    else
      return lotUnitCost * quantity;
  }
}
