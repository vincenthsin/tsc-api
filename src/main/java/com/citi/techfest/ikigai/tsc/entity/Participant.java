package com.citi.techfest.ikigai.tsc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "participant")
@Data
public class Participant implements Serializable {
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

    @Column(name = "case_closure")
    private Boolean caseClosure;

    @Column(name = "case_closure_leave_date")
    private LocalDate caseClosureLeaveDate;

    @Column(name = "case_closure_leave_reason")
    private String caseClosureLeaveReason;

    @Column(name = "case_closure_comments")
    private String caseClosureComments;

    @Column(name = "assigned_navigator")
    private String assignedNavigator;

    @Column(name = "developGoal")
    private String developGoal;

    @Column(name = "condition_summary")
    private String conditionSummary;

    @OneToMany(mappedBy = "participant")
    @JsonBackReference
    private List<ServiceItem> serviceItemList;
}