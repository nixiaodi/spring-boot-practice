package org.jiang.controller;

import org.jiang.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Description TODO
 * @Author jiang
 * @Create 2021/2/23
 * @Version 1.0
 */
@Controller
public class TestController {
    @Autowired
    private TestService testService;
}
