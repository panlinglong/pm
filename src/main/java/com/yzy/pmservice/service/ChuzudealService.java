package com.yzy.pmservice.service;

import com.yzy.pmservice.mapper.ChuzudealMapper;
import com.yzy.pmservice.mapper.EmpdealMapper;
import com.yzy.pmservice.pojo.Chuzudeal;
import com.yzy.pmservice.pojo.Empdeal;
import com.yzy.pmservice.pojo.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChuzudealService {

    @Autowired
    private ChuzudealMapper chuzudealMapper;

    public RespPageBean getChuzudealByPage(Integer page, Integer size,String keyword) {
        if (page!=null && size!=null){
            page = (page-1)*size;
        }
        List<Chuzudeal> data = chuzudealMapper.getChuzudealByPage(page,size,keyword);
        Long total = chuzudealMapper.getTotal(keyword);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Integer addChuzudeal(Chuzudeal chuzudeal) {
        Integer result = chuzudealMapper.insertSelective(chuzudeal);

        return result;
    }

    public Integer maxWorkID() {
        return chuzudealMapper.maxWorkID();
    }

    public Integer deleteChuzudealByEid(Integer id) {
        return chuzudealMapper.deleteByPrimaryKey(id);
    }

    public Integer updateChuzudeal(Chuzudeal chuzudeal) {
        return chuzudealMapper.updateByPrimaryKeySelective(chuzudeal);
    }
}
