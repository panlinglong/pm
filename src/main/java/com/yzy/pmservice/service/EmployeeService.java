package com.yzy.pmservice.service;

import com.yzy.pmservice.mapper.EmployeeMapper;
import com.yzy.pmservice.pojo.Employee;
import com.yzy.pmservice.pojo.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public RespPageBean getEmployeeByPage(Integer page, Integer size,String keyword) {
        if (page!=null && size!=null){
            page = (page-1)*size;
        }
        List<Employee> data = employeeMapper.getEmployeeByPage(page,size,keyword);
        Long total = employeeMapper.getTotal(keyword);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Integer addEmp(Employee employee) {
        Integer result = employeeMapper.insertSelective(employee);

        return result;
    }

    public Integer maxWorkID() {
        return employeeMapper.maxWorkID();
    }

    public Integer deleteEmpByEid(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    public Integer updateEmp(Employee employee) {
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }
}
