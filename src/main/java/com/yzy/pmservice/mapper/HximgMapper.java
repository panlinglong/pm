package com.yzy.pmservice.mapper;

import com.yzy.pmservice.pojo.Hximg;
import com.yzy.pmservice.pojo.Imgpath;

import java.util.List;

public interface HximgMapper {


    int insert(Hximg record);

    int insertSelective(Hximg record);

    List<Hximg> getImgByWorkid(String workid);

    String getImgPathById(Integer id);

    int deleteById(Integer id);

    int deleteHximgById(Integer id);


}