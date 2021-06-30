package com.example.service;

import com.example.model.PassType;
import com.example.model.SingleDayPass;
import com.example.model.TollPass;
import com.example.model.Vehicle;
import com.example.model.VehicleType;
import com.example.model.WeekPass;
import com.example.repository.PriceRepository;

public class TollPassFactory {

  public static TollPass createTollPass(String vehicleId, VehicleType vehicleType, PassType passType, String tollId) {
    TollPass tollPass = null;
    Vehicle vehicle = Vehicle.builder().identifier(vehicleId).type(vehicleType).build();
    Double passCost = PriceRepository.getPassCost(vehicleType, passType);
    long currentTime = System.currentTimeMillis();
    if(passType == PassType.SINGLE) {
      tollPass = new TollPass(currentTime, vehicle, passCost,tollId, currentTime);
    } else if(passType == PassType.WEEK_UNLIMITED) {
      tollPass = new WeekPass(currentTime, vehicle, passCost,tollId);
    } else {
      tollPass = new SingleDayPass(currentTime, vehicle, passCost,tollId);
    }
    return tollPass;
  }
}

// tollId | vehicleType | passType | price
