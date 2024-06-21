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
@Table(name = "History")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "gridpower")
    private Double gridPower;

    @Column(name = "fuelpower")
    private Double fuelPower;

    @Column(name = "greenpower")
    private  Double greenPower;

    @Column(name = "distance")
    private Double distance;

    @Column(name = "addedon")
    private Date addedon;
}
