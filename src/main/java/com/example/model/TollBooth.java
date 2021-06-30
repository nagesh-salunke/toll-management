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

  @Builder.Default
  private List<TollPass> issuedTollPasses = new ArrayList<>();

  private Long numberOfVehicleProcessed = 0L;

  public TollBooth() {
    this.id = UUID.randomUUID().toString();
    this.issuedTollPasses = new ArrayList<>();
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
    sb.append("Total Amount : ")
        .append(getTotalAmount())
        .append(" Total vehicle processed : ")
        .append(numberOfVehicleProcessed);
    return sb.toString();
  }

  private Double getTotalAmount() {
    return issuedTollPasses.stream().map(TollPass::getAmount).reduce(0d, Double::sum);
  }
}
