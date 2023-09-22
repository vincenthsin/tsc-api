package com.citi.techfest.ikigai.tsc.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "navigator")
@Data
public class Navigator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private String role;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "onboard_date")
    private String onboardDate;
}