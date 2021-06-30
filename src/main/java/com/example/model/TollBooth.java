package com.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
public class TollBooth {

  @Getter
  private String id;

  private String name;

  @Builder.Default
  private List<TollPass> issuedTollPasses = new ArrayList<>();

  @Getter
  private Long numberOfVehicleProcessed = 0L;

  public TollBooth(String name) {
    this.id = UUID.randomUUID().toString();
    this.issuedTollPasses = new ArrayList<>();
    this.name = name;
  }

  public void addIssuePass(TollPass tollPass) {
    this.issuedTollPasses.add(tollPass);
    numberOfVehicleProcessed++;
  }

  public void vehicleProcessed(String vehicleId) {
    numberOfVehicleProcessed++;
  }

  public String getBoothReport() {
    StringBuilder sb = new StringBuilder();
    sb.append("Toll Booth : ")
        .append(this.name)
        .append(" Total Amount : ")
        .append(getTotalAmount())
        .append(" Total vehicle processed : ")
        .append(numberOfVehicleProcessed);
    return sb.toString();
  }

  public Double getTotalAmount() {
    return issuedTollPasses.stream().map(TollPass::getAmount).reduce(0d, Double::sum);
  }
}
