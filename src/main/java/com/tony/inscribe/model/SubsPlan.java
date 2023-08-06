package com.tony.inscribe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "subs_plan")
public class SubsPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subs_id")
    int subsId;

    @Column(name = "name")
    String name;

    @Column(name = "monthly_price")
    int monthlyPrice;

    @Column(name = "quality")
    String quality;

    @Column(name = "resolution")
    String resolution;

    @Column(name = "devices")
    String devices;
}
