package com.ecosystem.evstationsservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseLineDto {

    private  String  country;

    private String city;

    private String pinCode;

    private Date baseLineStartDate;

    private String projectName;//country of the building

    private Double baseLine;

    private String deviceName;

    private String deviceId;

    private Integer numberHubs;

    private String  Type;

   private List<HubDto> hubDetails;

}
