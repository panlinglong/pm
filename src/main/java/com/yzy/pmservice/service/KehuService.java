package com.yzy.pmservice.service;

import com.yzy.pmservice.mapper.KehuMapper;
import com.yzy.pmservice.pojo.Kehu;
import com.yzy.pmservice.pojo.Kehu_a;
import com.yzy.pmservice.pojo.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KehuService {

    @Autowired
    private KehuMapper kehuMapper;

    public RespPageBean getKehuByPage(Integer page, Integer size,String keyword) {
        if (page!=null && size!=null){
            page = (page-1)*size;
        }
        List<Kehu> data = kehuMapper.getKehuByPage(page,size,keyword);
        for (Kehu kehu:data){
            List<Kehu_a> kehu_as = kehuMapper.getKehuAByKeHuId(kehu.getKehuid());
            kehu.setKehuAs(kehu_as);
        }
        Long total = kehuMapper.getTotal(keyword);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Integer addKehu(Kehu kehu) {
        Integer result = kehuMapper.insertSelective(kehu);

        return result;
    }

    public Integer maxWorkID() {
        return kehuMapper.maxWorkID();
    }

    public Integer deleteKehuByEid(Integer id) {
        return kehuMapper.deleteByPrimaryKey(id);
    }

    public Integer updateKehu(Kehu kehu) {
        return kehuMapper.updateByPrimaryKeySelective(kehu);
    }
}
