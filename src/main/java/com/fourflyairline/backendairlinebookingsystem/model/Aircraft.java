package com.fourflyairline.backendairlinebookingsystem.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String variant;
    private String manufacturerName;
    private Double maxLoad;
    private Double fuelCapacity;
    private Double averageSpeed;
    private Long economySeatCapacity;
    private Long platinumSeatCapacity;
    private Long businessSeatCapacity;


}
