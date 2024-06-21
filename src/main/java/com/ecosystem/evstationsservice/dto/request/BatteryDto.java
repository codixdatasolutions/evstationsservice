package com.ecosystem.evstationsservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BatteryDto {
    private String batteryName; // enter this value in batteryLog and Batteries table

    private Double batteryCapacityRatio; // this is in Batteries table Health (clomn)

    private Integer batterySwapTime; //This in batteryLogs table

    private Integer batteryHealth; // this in the batteryLogs

    private Integer batteryCycle; //chargeCycle in batteryLogs

    private Double  avgDistanceCharge; //Charge  in batteryLogs

    private Double avgTotalDistanceInDay; //Duration in history tables

    private String vehicle;

    private String chargingStationName;

    private String chargingStationType;

    private Long energyConsumption;


}
