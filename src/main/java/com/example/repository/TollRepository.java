package com.example.repository;

import com.example.model.Toll;
import java.util.HashMap;
import java.util.Map;

public class TollRepository {

  private static Map<String, Toll> tollsMap = new HashMap<>();

  private static TollRepository instance;

  public static TollRepository getInstance() {
    if(instance == null) {
      instance = new TollRepository();
    }
    return instance;
  }

  public static void createToll(Toll toll) {
    //TODO : Add exception on duplicate etc.
    tollsMap.putIfAbsent(toll.getId(), toll);
  }

  public static Toll getToll(String id) {
    return tollsMap.get(id);
  }
}
