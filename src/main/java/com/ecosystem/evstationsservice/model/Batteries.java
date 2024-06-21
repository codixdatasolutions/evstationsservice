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
@Table(name = "Batteries")
public class Batteries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long  id;

    @Column(name = "name")
    private String name;

    @Column(name = "health")
    private Integer health;

    @Column(name = "cycles")
    private Integer cycles;

    @Column(name = "updatedon")
    private Date updatedon;

}
