package com.black.controller;

import com.black.model.FctCase;
import com.black.service.FctCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testboot")
public class TestController {

    @Autowired
    private FctCaseService fctCaseService;
    @RequestMapping(value = "getfctCase" , produces = {"application/json;charset=UTF-8"})
    public FctCase getUser(long id) {
        FctCase fctCase = fctCaseService.selectByPrimaryKey(id);
        return fctCase;
    }
}
