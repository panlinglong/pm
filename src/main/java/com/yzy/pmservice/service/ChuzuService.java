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
        List chuzu1 = new List() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public Object[] toArray(Object[] a) {
                return new Object[0];
            }

            @Override
            public boolean add(Object o) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection c) {
                return false;
            }

            @Override
            public boolean addAll(Collection c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Object get(int index) {
                return null;
            }

            @Override
            public Object set(int index, Object element) {
                return null;
            }

            @Override
            public void add(int index, Object element) {

            }

            @Override
            public Object remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator listIterator() {
                return null;
            }

            @Override
            public ListIterator listIterator(int index) {
                return null;
            }

            @Override
            public List subList(int fromIndex, int toIndex) {
                return null;
            }
        } ;

        //处理当前时间
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = df.format(date);
        ParsePosition pos = new ParsePosition(8);
        Date currentTime_2 = df.parse(nowDate, pos);
        //取出数据
        for (int i = 0;i < data.size();i ++){
            Chuzu chuzu = data.get(i);
            //计算时间
            String end = df.format(chuzu.getEndDate());
            Date end2 = df.parse(end , pos);
            int a =  (int) ((end2.getTime() - currentTime_2.getTime()) / (1000*3600*24));
            if(a<=30){
                //将数据存到chuzu1
               chuzu1.add(chuzu);
            }

        }
        RespPageBean bean = new RespPageBean();
        bean.setData(chuzu1);
        return bean;
    }
}
