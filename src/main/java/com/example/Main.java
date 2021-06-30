package com.example;

import com.example.exceptions.DuplicatePassException;
import com.example.exceptions.PassNotFoundException;
import com.example.exceptions.TollBoothNotPresentException;
import com.example.model.PassType;
import com.example.model.Toll;
import com.example.model.TollBooth;
import com.example.model.VehicleType;
import com.example.service.TollService;

public class Main {

  public static void main(String[] args)
      throws PassNotFoundException, DuplicatePassException, TollBoothNotPresentException {

    TollService tollService = new TollService();

    Toll toll1 = tollService.createToll("Toll-1");
    Toll toll2 = tollService.createToll("Toll-2");
    TollBooth tollBooth1 = new TollBooth("Booth-1");
    TollBooth tollBooth2 = new TollBooth("Booth-2");
    TollBooth tollBooth3 = new TollBooth("Booth-3");

    toll1.addTollBooth(tollBooth1);
    toll1.addTollBooth(tollBooth2);
    toll1.addTollBooth(tollBooth3);

    TollBooth tollBooth21 = new TollBooth("Booth-4");
    toll2.addTollBooth(tollBooth21);

    //Week pass
    tollService.purchaseTollPass("v1", VehicleType.CAR, tollBooth1.getId(), toll1.getId(), PassType.WEEK_UNLIMITED);

    if(tollService.hasValidPass("v1", toll1.getId())) {
      tollService.processVehicle("v1", tollBooth1.getId(), toll1.getId());
    }
    tollService.processVehicle("v1", tollBooth1.getId(), toll1.getId());

    tollService.processVehicle("v1", tollBooth21.getId(), toll2.getId());

    //single pass
    tollService.purchaseTollPass("v2", VehicleType.MOTORBIKE, tollBooth2.getId(), toll1.getId(), PassType.SINGLE);

    System.out.println(toll1.getBoothWiseReport());
    System.out.println(toll2.getBoothWiseReport());
  }
}
