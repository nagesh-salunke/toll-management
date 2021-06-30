package com.example.repository;

import com.example.exceptions.DuplicatePassException;
import com.example.model.TollPass;
import java.util.HashMap;
import java.util.Map;

public class TollPassRepository {

  private static Map<String, TollPass> tollPassDetails = new HashMap<>();

  private static TollPassRepository instance;

  public static TollPassRepository getInstance() {
    if(instance == null) {
      instance = new TollPassRepository();
    }
    return instance;
  }

  //returns null if not absent
  public static TollPass getTollPass(String identifier) {
    return tollPassDetails.get(identifier);
  }

  //returns null if not absent
  public static boolean hasValidTollPass(String vehicleId, String tollId) {
    TollPass tollPass = tollPassDetails.get(vehicleId);
    if(tollPass == null) {
      return false;
    }
    return tollPass.isValid(tollId);
  }

  public static void createTollPass(TollPass tollPass) throws DuplicatePassException {
    if(hasValidTollPass(tollPass.getVehicle().getIdentifier(), tollPass.getTollId())) {
      throw new DuplicatePassException();
    }
    tollPassDetails.put(tollPass.getVehicle().getIdentifier(), tollPass);
  }
}
