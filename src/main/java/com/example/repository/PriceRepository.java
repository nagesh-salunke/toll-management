package com.example.repository;

import com.example.model.PassType;
import com.example.model.VehicleType;

public class PriceRepository {

  public static Double getPassCost(VehicleType vehicleType, PassType passType) {
    if (vehicleType.equals(VehicleType.CAR)) {
      if (passType.equals(PassType.SINGLE)) {
        return 10.0d;
      } else if (passType.equals(PassType.DAY_RETURN)) {
        return 15.0d;
      } else {
        return 50.0d;
      }
    } else {
      if (passType.equals(PassType.SINGLE)) {
        return 5.0d;
      } else if (passType.equals(PassType.DAY_RETURN)) {
        return 8.0d;
      } else {
        return 25.0d;
      }
    }
  }
}
