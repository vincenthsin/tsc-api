package com.citi.techfest.ikigai.tsc.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
        import java.util.List;

@Entity
@Table(name = "participant")
@Data
public class Participant {
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

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "cabin_number")
    private String cabinNumber;

    @Column(name = "move_in_date")
    private LocalDate moveInDate;

    @Column(name = "leave_date")
    private LocalDate leaveDate;

    @Column(name = "leave_reason")
    private String leaveReason;

    @Column(name = "comments")
    private String comments;

    @Column(name = "assigned_navigator")
    private String assignedNavigator;

    @ElementCollection
    private List<String> developGoal;

    @Column(name = "condition_summary")
    private String conditionSummary;

    @OneToMany(mappedBy = "participant")
    private List<ServiceItem> serviceItemList;
}