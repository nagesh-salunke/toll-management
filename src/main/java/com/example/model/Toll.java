package com.example.model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
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

  public TollBooth getTollBooth(String id) {
    return this.tollBoothMap.get(id);
  }

  public void addTollBooth(TollBooth tollBooth) {
    this.tollBoothMap.putIfAbsent(tollBooth.getId(), tollBooth);
  }
}
