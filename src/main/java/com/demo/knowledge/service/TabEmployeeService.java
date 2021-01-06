package com.demo.knowledge.service;

import com.demo.knowledge.entity.TabEmployeeInfo;
import com.demo.knowledge.repository.TabEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TabEmployeeService {

    @Autowired
    private TabEmployeeRepository tabEmployeeRepository;

    public List<TabEmployeeInfo> findListByEmployeeName(String name) {
        return tabEmployeeRepository.findListByEmployeeName(name);
    }

}
