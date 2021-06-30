package com.example;

import com.example.exceptions.DuplicatePassException;
import com.example.exceptions.PassNotFoundException;
import com.example.model.PassType;
import com.example.model.Toll;
import com.example.model.TollBooth;
import com.example.model.VehicleType;
import com.example.service.TollService;

public class Main {

  public static void main(String[] args) throws PassNotFoundException, DuplicatePassException {

    TollService tollService = new TollService();

    Toll toll1 = tollService.createToll("Toll-1");
    Toll toll2 = tollService.createToll("Toll-2");
    TollBooth tollBooth1 = new TollBooth();
    TollBooth tollBooth2 = new TollBooth();
    TollBooth tollBooth3 = new TollBooth();

    toll1.addTollBooth(tollBooth1);
    toll1.addTollBooth(tollBooth2);
    toll1.addTollBooth(tollBooth3);

    TollBooth tollBooth21 = new TollBooth();
    toll2.addTollBooth(tollBooth21);

    tollService.purchaseTollPass("v1", VehicleType.CAR, tollBooth1.getId(), toll1.getId(), PassType.WEEK_UNLIMITED);

    if(tollService.hasValidPass("v1", toll1.getId())) {
      tollService.processVehicle("v1", VehicleType.CAR, tollBooth1.getId(), toll1.getId());
    }
    tollService.processVehicle("v1", VehicleType.CAR, tollBooth1.getId(), toll1.getId());

    tollService.processVehicle("v1", VehicleType.CAR, tollBooth21.getId(), toll2.getId());

    System.out.println(tollBooth1.getBoothReport());
    System.out.println(tollBooth21.getBoothReport());
  }
}
