package com.yzy.pmservice.mapper;

import com.yzy.pmservice.pojo.Imgpath;
import com.yzy.pmservice.pojo.ImgpathExample;
import com.yzy.pmservice.pojo.Kehu_a;
import com.yzy.pmservice.pojo.Kehu_aExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImgpathMapper {
    int countByExample(ImgpathExample example);

    int deleteByExample(ImgpathExample example);

    int insert(Imgpath record);

    int insertSelective(Imgpath record);

    List<Imgpath> selectByExample(ImgpathExample example);

    int updateByExampleSelective(@Param("record") Imgpath record, @Param("example") ImgpathExample example);

    int updateByExample(@Param("record") Imgpath record, @Param("example") ImgpathExample example);

    int deleteImgpathById(Integer id);


}