package com.citi.techfest.ikigai.tsc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeneficiarySearchCondition {

    private Integer page;
    private Integer paginationSize;
    private String orderFiled;
    private String orderType;
    private String name;
    private String gender;
    private String navigator;
    private String developGoal;
    private String services;
    private Boolean caseClosure;


}
