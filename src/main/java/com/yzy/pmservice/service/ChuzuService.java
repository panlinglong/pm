package com.yzy.pmservice.service;

import com.yzy.pmservice.mapper.ChuzuMapper;
import com.yzy.pmservice.mapper.EmployeeMapper;
import com.yzy.pmservice.pojo.Chuzu;
import com.yzy.pmservice.pojo.Employee;
import com.yzy.pmservice.pojo.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChuzuService {

    @Autowired
    private ChuzuMapper chuzuMapper;

    public RespPageBean getChuzuByPage(Integer page, Integer size,String keyword) {
        if (page!=null && size!=null){
            page = (page-1)*size;
        }
        List<Chuzu> data = chuzuMapper.getChuzuByPage(page,size,keyword);
        Long total = chuzuMapper.getTotal(keyword);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Integer addChuzu(Chuzu chuzu) {
        Integer result = chuzuMapper.insertSelective(chuzu);

        return result;
    }

    public Integer maxWorkID() {
        return chuzuMapper.maxWorkID();
    }

    public Integer deleteChuzuByEid(Integer id) {
        return chuzuMapper.deleteByPrimaryKey(id);
    }

    public Integer updateChuzu(Chuzu chuzu) {
        return chuzuMapper.updateByPrimaryKeySelective(chuzu);
    }
}
