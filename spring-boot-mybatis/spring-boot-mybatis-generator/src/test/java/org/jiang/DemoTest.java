package org.jiang;

import com.github.pagehelper.PageInfo;
import org.jiang.config.BaseConfig;
import org.jiang.model.Adjustsalary;
import org.jiang.model.Employee;
import org.jiang.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoTest {
    @Autowired
    private EmployeeService employeeService;

    @Test
    public void test() {
        PageInfo<Employee> info = employeeService.pageInfo(13, 50);
        List<Employee> employeeList = info.getList();
        employeeList.stream().forEach(System.out::println);
    }

    @Test
    public void test2() {
        Integer count = employeeService.count();
        System.out.println(count);
    }
}
