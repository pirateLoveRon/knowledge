package com.demo.knowledge.repository;

import com.demo.knowledge.entity.TabEmployeeInfo;
import com.demo.knowledge.mapper.TabEmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TabEmployeeRepository {

    @Autowired
    private TabEmployeeMapper tabEmployeeMapper;

    public List<TabEmployeeInfo> findListByEmployeeName(String name) {
        return tabEmployeeMapper.findListByEmployeeName(name);
    }

}
