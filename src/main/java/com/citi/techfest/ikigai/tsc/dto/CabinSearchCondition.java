package com.citi.techfest.ikigai.tsc.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CabinSearchCondition {
    private Integer number;
    private Boolean available;
    private String location;
    private String facility;
}
