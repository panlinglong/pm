package com.yzy.pmservice.service;

import com.yzy.pmservice.mapper.EmployeeMapper;
import com.yzy.pmservice.mapper.ImgpathMapper;
import com.yzy.pmservice.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Resource
    private ImgpathMapper imgpathMapper;

    public RespPageBean getEmployeeByPage(Integer page, Integer size,String keyword) {
        if (page!=null && size!=null){
            page = (page-1)*size;
        }
        List<Employee> data = employeeMapper.getEmployeeByPage(page,size,keyword);
        Long total = employeeMapper.getTotal(keyword);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Integer addEmp(Employee employee) {
        Integer result = employeeMapper.insertSelective(employee);

        return result;
    }

    public Integer maxWorkID() {
        return employeeMapper.maxWorkID();
    }

    public Integer deleteEmpByEid(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    public Integer updateEmp(Employee employee) {
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public Integer deleteById(Integer id) {
        String imgpaths = "D:/yzy/PMSystem/PMSystem/pmui/static"+imgpathMapper.getImgPathById(id);
        File file = new File(imgpaths);
        file.delete();
        return imgpathMapper.deleteById(id);
    }

    public Integer addImgpath(Imgpath imgpath) {

        Integer result = imgpathMapper.insertSelective(imgpath);
        return result;
    }
    public RespPageBean getImg(String workid){
        List<Imgpath> data = imgpathMapper.getImgByWorkid(workid);
//        String[] a = new String[20];
//        for(int i=0;i<data.size();i++){
//            System.out.println(data.get(i).getImagepath());
//            a[i] = data.get(i).getImagepath();
//        }
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        return bean;
    }

}
