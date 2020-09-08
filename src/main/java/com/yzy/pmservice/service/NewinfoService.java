package com.yzy.pmservice.service;

import com.yzy.pmservice.mapper.EmployeeMapper;
import com.yzy.pmservice.mapper.NewinfoMapper;
import com.yzy.pmservice.pojo.Employee;
import com.yzy.pmservice.pojo.Newinfo;
import com.yzy.pmservice.pojo.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewinfoService {

    @Autowired
    private NewinfoMapper newinfoMapper;

    public RespPageBean getNewinfoByPage(Integer page, Integer size,String keyword) {
        if (page!=null && size!=null){
            page = (page-1)*size;
        }
        List<Newinfo> data = newinfoMapper.getNewinfoByPage(page,size,keyword);
        Long total = newinfoMapper.getTotal(keyword);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Integer addNew(Newinfo newinfo) {
        Integer result = newinfoMapper.insertSelective(newinfo);

        return result;
    }

    public Integer maxWorkID() {
        return newinfoMapper.maxWorkID();
    }

    public Integer deleteNewByEid(Integer id) {
        return newinfoMapper.deleteByPrimaryKey(id);
    }

    public Integer updateNew(Newinfo newinfo) {
        return newinfoMapper.updateByPrimaryKeySelective(newinfo);
    }
}
