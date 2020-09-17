package com.yzy.pmservice.service;

import com.yzy.pmservice.mapper.EmpdealMapper;
import com.yzy.pmservice.mapper.NewhousedealMapper;
import com.yzy.pmservice.pojo.Empdeal;
import com.yzy.pmservice.pojo.Newhousedeal;
import com.yzy.pmservice.pojo.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewhousedealService {

    @Autowired
    private NewhousedealMapper newhousedealMapper;

    public RespPageBean getNewhousedealByPage(Integer page, Integer size,String keyword) {
        if (page!=null && size!=null){
            page = (page-1)*size;
        }
        List<Newhousedeal> data = newhousedealMapper.getNewhousedealByPage(page,size,keyword);
        Long total = newhousedealMapper.getTotal(keyword);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Integer addNewhousedeal(Newhousedeal newhousedeal) {
        Integer result = newhousedealMapper.insertSelective(newhousedeal);

        return result;
    }

    public Integer maxWorkID() {
        return newhousedealMapper.maxWorkID();
    }

    public Integer deleteNewhousedealByEid(Integer id) {
        return newhousedealMapper.deleteByPrimaryKey(id);
    }

    public Integer updateNewhousedeal(Newhousedeal newhousedeal) {
        return newhousedealMapper.updateByPrimaryKeySelective(newhousedeal);
    }
}
