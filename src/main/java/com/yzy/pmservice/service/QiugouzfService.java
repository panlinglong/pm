package com.yzy.pmservice.service;

import com.yzy.pmservice.mapper.QiugouesMapper;
import com.yzy.pmservice.mapper.QiugouzfMapper;
import com.yzy.pmservice.pojo.Qiugoues;
import com.yzy.pmservice.pojo.Qiugouzf;
import com.yzy.pmservice.pojo.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QiugouzfService {

    @Autowired
    private QiugouzfMapper qiugouzfMapper;

    public RespPageBean getQiugouzfByPage(Integer page, Integer size,String keyword) {
        if (page!=null && size!=null){
            page = (page-1)*size;
        }
        List<Qiugouzf> data = qiugouzfMapper.getQiugouzfByPage(page,size,keyword);
        Long total = qiugouzfMapper.getTotal(keyword);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Integer addQiugouzf(Qiugouzf qiugouzf) {
        Integer result = qiugouzfMapper.insertSelective(qiugouzf);

        return result;
    }

    public Integer maxWorkID() {
        return qiugouzfMapper.maxWorkID();
    }

    public Integer deleteQiugouzfByEid(Integer id) {
        return qiugouzfMapper.deleteByPrimaryKey(id);
    }

    public Integer updateQiugouzf(Qiugouzf qiugouzf) {
        return qiugouzfMapper.updateByPrimaryKeySelective(qiugouzf);
    }
}
