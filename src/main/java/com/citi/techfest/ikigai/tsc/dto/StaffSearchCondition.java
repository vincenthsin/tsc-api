package com.citi.techfest.ikigai.tsc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author: 陈嘉颖
 * @date: 2023/9/22 22:53
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffSearchCondition {

    private Integer page;
    private Integer paginationSize;
    private String orderFiled;
    private String orderType;
    private String name;
    private String gender;
    private String organization;
    private LocalDate onboardDateFrom;
    private LocalDate onboardDateTo;
}
