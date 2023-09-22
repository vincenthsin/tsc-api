package com.citi.techfest.ikigai.tsc.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cabin")
@Data
public class Cabin {
    @Id
    @Column(name = "number")
    private Integer number;

    @Column(name = "available")
    private Boolean available;

    @Column(name = "location")
    private String location;

    @Column(name = "facility")
    private String facility;

    @ElementCollection
    private List<String> tenant;
}
