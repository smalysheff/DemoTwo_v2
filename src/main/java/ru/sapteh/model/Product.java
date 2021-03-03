package ru.sapteh.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    private double cost;

    @Column
    private String description;

    @Column
    private String mainImatePath;

    @Column
    private int isActive;

    @ManyToOne()
    @JoinColumn(name = "ManufacturerID")
    private Manufacturer manufacturer;
}
