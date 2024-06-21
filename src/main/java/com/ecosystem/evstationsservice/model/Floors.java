package com.ecosystem.evstationsservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Floors")
public class Floors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "buildingid")
    private  Long buildingsId;

    @Column(name = "name")
    private String name;

    @Column(name = "area")
    private  Long  area;

}
