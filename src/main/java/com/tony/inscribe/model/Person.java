package com.tony.inscribe.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "email",unique = true)
    String email;

    @Column(name = "password")
    String password;

    @ManyToOne
    @JoinColumn(name = "subs_id")
    SubsPlan subsPlan;

    @Column(name = "plan_period")
    int plan_period;
}
