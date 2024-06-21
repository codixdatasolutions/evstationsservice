package com.ecosystem.evstationsservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "buildings")
public class Building {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "country")
    private  String country;

    @Column(name = "city")
    private String city;

    @Column(name = "pincode")
    private String pincode;

    @Column(name = "category")
    private String category;

    @Column(name = "gridpower")
    private Double gridPower;

    @Column(name = "fuelpower")
    private Double fuelPower;

    @Column(name = "greenpower")
    private  Double greenPower;

    @Column(name = "occupancy")
    private Integer occupancy;

    @Column(name = "population")
    private  Integer population;

    @Column(name = "projectname")
    private String projectname;

    @Column(name = "updatedon")
    private Date updatedOn;
}
