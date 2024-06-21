package com.ecosystem.evstationsservice.model;


import com.ecosystem.evstationsservice.enums.VehicleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Vehicles")
public class Vehicles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "vin")
    private String vin;

    @Enumerated
    @Column(name = "type")
    private VehicleType type;

    @Column(name = "model")
    private String model;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "hub")
    private String hub;

    @Column(name = "fleet")
    private String fleet;

    @Column(name = "status")
    private Integer status;

    @Column(name = "installationdate")
    private Date installationDate;

}
