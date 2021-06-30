package com.example.model;

public class WeekPass extends TollPass {

  private static final long WEEK_MILLIS = 7 * 24 * 60 * 60 * 1000;

  public WeekPass(long purchaseTimeMillis, Vehicle vehicle, Double amount, String tollId) {
    super(purchaseTimeMillis, vehicle, amount, tollId);
  }

  @Override
  public boolean isValid(String tollId) {
    long currentTime = System.currentTimeMillis();
    if ((currentTime - getPurchaseTimeMillis()) > WEEK_MILLIS) {
      return false;
    }
    return true;
  }
}
