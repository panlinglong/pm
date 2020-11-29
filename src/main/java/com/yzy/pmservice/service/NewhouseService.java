package com.yzy.pmservice.service;

import com.yzy.pmservice.mapper.EmpdealMapper;
import com.yzy.pmservice.mapper.HximgMapper;
import com.yzy.pmservice.mapper.ImgpathMapper;
import com.yzy.pmservice.mapper.NewhouseMapper;
import com.yzy.pmservice.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

@Service
public class NewhouseService {

    @Autowired
    private NewhouseMapper newhouseMapper;

    @Resource
    private HximgMapper hximgMapper;

    public RespPageBean getNewhouseByPage(Integer page, Integer size,String keyword) {
        if (page!=null && size!=null){
            page = (page-1)*size;
        }
        List<Newhouse> data = newhouseMapper.getNewhouseByPage(page,size,keyword);
        Long total = newhouseMapper.getTotal(keyword);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Integer addNewhouse(Newhouse newhouse) {
        Integer result = newhouseMapper.insertSelective(newhouse);

        return result;
    }

    public Integer maxWorkID() {
        return newhouseMapper.maxWorkID();
    }

    public Integer deleteNewhouseByEid(Integer id) {
        return newhouseMapper.deleteByPrimaryKey(id);
    }

    public Integer updateNewhouse(Newhouse newhouse) {
        return newhouseMapper.updateByPrimaryKeySelective(newhouse);
    }

    public Integer deleteById(Integer id) {
        String imgpaths = "D:/yzy/PMSystem/PMSystem/pmui/static"+hximgMapper.getImgPathById(id);
        File file = new File(imgpaths);
        file.delete();
        return hximgMapper.deleteById(id);
    }

    public Integer addImgpath(Hximg hximg) {

        Integer result = hximgMapper.insertSelective(hximg);
        return result;
    }
    public RespPageBean getImg(String workid){
        List<Hximg> data = hximgMapper.getImgByWorkid(workid);
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
