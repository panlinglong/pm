package com.yzy.pmservice.service;

import com.yzy.pmservice.mapper.EmpdealMapper;
import com.yzy.pmservice.mapper.QiugouesMapper;
import com.yzy.pmservice.pojo.Empdeal;
import com.yzy.pmservice.pojo.Qiugoues;
import com.yzy.pmservice.pojo.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QiugouesService {

    @Autowired
    private QiugouesMapper qiugouesMapper;

    public RespPageBean getQiugouesByPage(Integer page, Integer size,String keyword) {
        if (page!=null && size!=null){
            page = (page-1)*size;
        }
        List<Qiugoues> data = qiugouesMapper.getQiugouesByPage(page,size,keyword);
        Long total = qiugouesMapper.getTotal(keyword);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Integer addQiugoues(Qiugoues qiugoues) {
        Integer result = qiugouesMapper.insertSelective(qiugoues);

        return result;
    }

    public Integer maxWorkID() {
        return qiugouesMapper.maxWorkID();
    }

    public Integer deleteQiugouesByEid(Integer id) {
        return qiugouesMapper.deleteByPrimaryKey(id);
    }

    public Integer updateQiugoues(Qiugoues qiugoues) {
        return qiugouesMapper.updateByPrimaryKeySelective(qiugoues);
    }
}
