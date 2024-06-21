package com.ecosystem.evstationsservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VehicleDto {

    private String name;

    private String vin;

    private String type;

   private String vehicleModelType1;
   private String vehicleModelType2;
   private String vehicleModelType3;
   private Integer vehicleNo1;

   private Integer vehicleNo2;
   private Integer vehicleNo3;

    private Integer status;

    private Date installationDate;

    private String country;

    private String city;


}
