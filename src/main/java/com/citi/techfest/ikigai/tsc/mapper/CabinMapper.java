package com.citi.techfest.ikigai.tsc.mapper;

import com.citi.techfest.ikigai.tsc.entity.Cabin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: 陈嘉颖
 * @date: 2023/9/23 2:15
 * @description:
 */
@Mapper
public interface CabinMapper {

    List<Cabin> searchCabin(
            @Param("location") String location,
            @Param("facility") String facility,
            @Param("availability") Boolean availability,
            @Param("number") Integer number);
}
