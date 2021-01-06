package com.demo.knowledge.controller;

import com.demo.knowledge.entity.TabEmployeeInfo;
import com.demo.knowledge.service.TabEmployeeService;
import com.demo.knowledge.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class UserController {

    @Autowired
    private TabEmployeeService tabEmployeeService;
    @Autowired
    private RedisUtil redisUtil;

    @GetMapping(value = "/name/{keyWord}")
    public List<TabEmployeeInfo> findListByEmployeeName(@PathVariable String keyWord) {
        Object cache = redisUtil.get(keyWord);
        if (cache != null) {
            return (List) cache;
        }
        List<TabEmployeeInfo> list = tabEmployeeService.findListByEmployeeName(keyWord);
        if (CollectionUtils.isEmpty(list)) {
            return list;
        }
        redisUtil.set(keyWord, list, 10);
        return list;
    }

}
