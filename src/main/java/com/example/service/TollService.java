package com.example.service;

import com.example.exceptions.DuplicatePassException;
import com.example.exceptions.PassNotFoundException;
import com.example.exceptions.TollBoothNotPresentException;
import com.example.model.PassType;
import com.example.model.SingleDayPass;
import com.example.model.Toll;
import com.example.model.TollBooth;
import com.example.model.TollPass;
import com.example.model.VehicleType;
import com.example.repository.TollPassRepository;
import com.example.repository.TollRepository;

public class TollService {

  public boolean hasValidPass(String vehicleId, String tollId) throws PassNotFoundException {
    return  TollPassRepository.hasValidTollPass(vehicleId, tollId);
  }

  public TollPass processVehicle(String vehicleId, String tollBoothId, String tollId)
      throws PassNotFoundException, TollBoothNotPresentException {
    Toll toll = TollRepository.getToll(tollId);
    TollBooth tollBooth = toll.getTollBooth(tollBoothId);
    if(TollPassRepository.hasValidTollPass(vehicleId, toll.getId())) {
      TollPass tollPass = TollPassRepository.getTollPass(vehicleId);
      if(tollPass instanceof SingleDayPass) {
        ((SingleDayPass) tollPass).setReturnJourneyCompleted(true);
      }
      tollBooth.vehicleProcessed(vehicleId);
      return tollPass;
    } else {
      throw new PassNotFoundException();
    }
  }

  public TollPass purchaseTollPass(String vehicleId, VehicleType vehicleType, String tollBoothId, String tollId, PassType passType)
      throws DuplicatePassException, TollBoothNotPresentException {
    Toll toll = TollRepository.getToll(tollId);
    TollBooth tollBooth = toll.getTollBooth(tollBoothId);
    TollPass tollPass = TollPassFactory.createTollPass(vehicleId, vehicleType, passType, tollId);
    TollPassRepository.createTollPass(tollPass);
    tollBooth.addIssuePass(tollPass);
    return tollPass;
  }

  public Toll createToll(String name) {
    Toll toll = new Toll(name);
    TollRepository.createToll(toll);
    return toll;
  }
}
