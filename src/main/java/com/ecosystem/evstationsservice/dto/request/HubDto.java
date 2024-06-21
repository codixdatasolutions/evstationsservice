package com.ecosystem.evstationsservice.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class HubDto {

    private Integer numberVehicle;  //No column got to mapp this  value in the number of existing tables

    private  Integer numberChargingStation;  //No column got to mapp this  value in the number of existing tables

    private Integer numberBatteries;  //No column got to mapp this  value in the number of existing tables

    private String hubName;
    private List<VehicleDto>  vehicleList;
    private  List<BatteryDto> batteryDto;
    private Integer numberFleets;

}
