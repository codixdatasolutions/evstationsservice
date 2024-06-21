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
@Table(name = "Batterylogs")
public class Batterylogs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long  id;

    @Column(name = "name")
    private String name;

    @Column(name = "chargecycle")
    private Integer chargeCycle;

    @Column(name = "power")
    private  Double power;

    @Column(name = "health")
    private Integer health;

    @Column(name = "voltage")
    private  Integer voltage;

    @Column(name = "charge")
    private Double charge;

    @Column(name = "timestamp")
    private String timestamp;

    @Column(name = "vehicle")
    private String vechile; //the vechile name is consider as unique and using this we can also search  in vechiles table

    @Column(name = "batterysocin")
    private Double batterySocIn;

    @Column(name = "batterysocout")
    private Double batterySocOut;

    @Column(name = "batteryvoltagein")
    private Double batteryVoltageIn;

    @Column(name = "batteryvoltageout")
    private Double batteryVoltageOut;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "slot")
    private Integer slot;

    @Column(name = "swappedtime")
    private Date swappedTime;
}
