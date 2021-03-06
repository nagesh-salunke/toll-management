package com.example.model;

import lombok.Setter;

public class SingleDayPass extends TollPass {

  private static final long DAY_MILLIS = 24 * 60 * 60 * 1000;

  @Setter
  private boolean returnJourneyCompleted = false;

  public SingleDayPass(long purchaseTimeMillis, Vehicle vehicle, Double amount, String tollId) {
    super(purchaseTimeMillis, vehicle, amount, tollId, purchaseTimeMillis + DAY_MILLIS);
  }

  @Override
  public boolean isValid(String tollId) {
    if (returnJourneyCompleted) {
      return false;
    }
    if(!tollId.equals(this.getTollId())) {
      return false;
    }
    long currentTime = System.currentTimeMillis();
    if (currentTime  > getValidTimeMillis()) {
      return false;
    }
    return true;
  }
}
