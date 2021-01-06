package com.demo.knowledge.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class TabEmployeeInfo {

    @Id
    private String id;

    private String employeeCode;

    private String employeeName;

}
