package com.yzy.pmservice.service;

import com.yzy.pmservice.mapper.ChuzuMapper;
import com.yzy.pmservice.mapper.EmployeeMapper;
import com.yzy.pmservice.pojo.Chuzu;
import com.yzy.pmservice.pojo.Employee;
import com.yzy.pmservice.pojo.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Component
@EnableScheduling
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

    @Scheduled(cron = "0 0 0 * * ?")
    public RespPageBean scheduledTask(){
        //得到数据
        List<Chuzu> data = chuzuMapper.getChuzu();

        //chuzu1存放合适的数据
        List chuzu1 = new ArrayList();

        //处理当前时间
        Date date = new Date();

        //取出数据
        for (int i = 0;i < data.size();i ++){
            Chuzu chuzu = data.get(i);
            //计算时间
            Date b = chuzu.getEndDate();
            if(b!=null) {
                int a = (int) ((b.getTime() - date.getTime()) / (1000 * 3600 * 24));
                if (a != 0 && a <= 30) {
                    //将数据存到chuzu1
                    chuzu1.add(chuzu);
                }
            }
        }

        RespPageBean bean = new RespPageBean();
        bean.setData(chuzu1);
        return bean;
    }


    public RespPageBean payAlarm(){
        //得到数据
        List<Chuzu> data = chuzuMapper.getChuzu();

        //chuzu1存放合适的数据
        List chuzu2 = new ArrayList();

        //处理当前时间
        Date date = new Date();

        //取出数据
        for (int i = 0;i < data.size();i ++){
            Chuzu chuzu = data.get(i);
            //计算时间
            Date b = chuzu.getAlarmDate();
            if(b!=null) {
                int a = (int) ((b.getTime() - date.getTime()) / (1000 * 3600 * 24));
                if (a <= 1) {
                    //将数据存到chuzu1
                    chuzu2.add(chuzu);
                }
            }
        }

        RespPageBean bean = new RespPageBean();
        bean.setData(chuzu2);
        return bean;
    }
}
