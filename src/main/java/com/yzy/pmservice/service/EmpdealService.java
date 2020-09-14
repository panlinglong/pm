package com.yzy.pmservice.service;

import com.yzy.pmservice.mapper.EmpdealMapper;
import com.yzy.pmservice.mapper.EmployeeMapper;
import com.yzy.pmservice.pojo.Empdeal;
import com.yzy.pmservice.pojo.Employee;
import com.yzy.pmservice.pojo.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpdealService {

    @Autowired
    private EmpdealMapper empdealMapper;

    public RespPageBean getEmpdealByPage(Integer page, Integer size,String keyword) {
        if (page!=null && size!=null){
            page = (page-1)*size;
        }
        List<Empdeal> data = empdealMapper.getEmpdealByPage(page,size,keyword);
        Long total = empdealMapper.getTotal(keyword);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Integer addEmp(Empdeal empdeal) {
        Integer result = empdealMapper.insertSelective(empdeal);

        return result;
    }

    public Integer maxWorkID() {
        return empdealMapper.maxWorkID();
    }

    public Integer deleteEmpByEid(Integer id) {
        return empdealMapper.deleteByPrimaryKey(id);
    }

    public Integer updateEmp(Empdeal empdeal) {
        return empdealMapper.updateByPrimaryKeySelective(empdeal);
    }
}
