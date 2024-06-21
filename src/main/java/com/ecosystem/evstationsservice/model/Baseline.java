package com.ecosystem.evstationsservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "Baseline")
public class Baseline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long  id;

    @Column(name = "type")
    private String type;

    @Column(name = "deviceid")
    private String deviceId;

    @Column(name = "devicename")
    private String deviceName;

    @Column(name = "baseline")
    private Double baseLine;

    @Column(name = "baselinedate")
    private Date baselineDate;
}
