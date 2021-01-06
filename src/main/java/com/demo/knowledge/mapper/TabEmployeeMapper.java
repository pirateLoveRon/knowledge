package com.demo.knowledge.mapper;

import com.demo.knowledge.entity.TabEmployeeInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TabEmployeeMapper {

    List<TabEmployeeInfo> findListByEmployeeName(String name);

}
