package com.example.model;

import com.example.exceptions.TollBoothNotPresentException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Toll {

  @Getter
  private String id;

  private String name;

  @Default
  private Map<String, TollBooth> tollBoothMap = new HashMap<>();

  public Toll(String name) {
    this.name = name;
    this.id = UUID.randomUUID().toString();
    this.tollBoothMap = new HashMap<>();
  }

  public TollBooth getTollBooth(String id) throws TollBoothNotPresentException {
    if(!tollBoothMap.containsKey(id)) {
      throw new TollBoothNotPresentException();
    }
    return this.tollBoothMap.get(id);
  }

  public void addTollBooth(TollBooth tollBooth) {
    this.tollBoothMap.putIfAbsent(tollBooth.getId(), tollBooth);
  }

  public String getBoothWiseReport() {
    StringBuilder stringBuilder = new StringBuilder();
    List<TollBooth> tollBooths = tollBoothMap.values().stream()
        .sorted(Comparator.comparing(TollBooth::getTotalAmount).thenComparing(TollBooth::getNumberOfVehicleProcessed).reversed())
        .collect(Collectors.toList());
    stringBuilder.append("Toll Name : ").append(name).append("\n").append("------").append("\n");
    for(TollBooth tollBooth : tollBooths) {
      stringBuilder.append(tollBooth.getBoothReport())
          .append("\n");
    }
    return stringBuilder.toString();
  }
}
