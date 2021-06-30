package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TollPass {

  private long purchaseTimeMillis;
  private Vehicle vehicle;
  private Double amount;
  private String tollId;
  private long validTimeMillis;

  public boolean isValid(String tollId) {
    return false;
  }
}
