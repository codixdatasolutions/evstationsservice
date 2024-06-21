package com.ecosystem.evstationsservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BatteryResopnse {
    private String batteryName;

    private String batterModelNumber;

    private Date batterySwapTime;

    private Double batteryHealth;

    private Integer batteryCycle;
}
