package com.yzy.pmservice.mapper;

import com.yzy.pmservice.pojo.Imgpath;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImgpathMapper {


    int insert(Imgpath record);

    int insertSelective(Imgpath record);

    List<Imgpath> getImgByWorkid(String workid);

    String getImgPathById(Integer id);

    int deleteById(Integer id);

    int deleteImgpathById(Integer id);


}