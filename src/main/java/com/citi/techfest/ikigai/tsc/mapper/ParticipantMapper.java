package com.citi.techfest.ikigai.tsc.mapper;

import com.citi.techfest.ikigai.tsc.entity.Participant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface ParticipantMapper {
    List<Participant> searchBeneficiary(
            @Param("caseClosure") Boolean caseClosure,
            @Param("developGoal") String developGoal,
            @Param("gender") String gender,
            @Param("navigator") String navigator,
            @Param("name") String name,
            @Param("sortField") String sortField,
            @Param("sortOrder") String sortOrder);
}
