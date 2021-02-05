package org.jiang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.jiang.mapper.AdjustsalaryMapper;
import org.jiang.mapper.EmployeeMapper;
import org.jiang.mapper.EmployeeecMapper;
import org.jiang.model.Adjustsalary;
import org.jiang.model.AdjustsalaryExample;
import org.jiang.model.Employee;
import org.jiang.model.EmployeeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public PageInfo<Employee> pageInfo(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        EmployeeExample example = new EmployeeExample();
        List<Employee> employeeList = employeeMapper.selectByExample(example);
        PageInfo<Employee> pageInfo = new PageInfo<>(employeeList,30);
        return pageInfo;
    }

    public Integer count() {
        EmployeeExample example = new EmployeeExample();
        List<Employee> employeeList = employeeMapper.selectByExample(example);
        return employeeList.size();
    }
}
