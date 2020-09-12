package com.yzy.pmservice.mapper;

import com.yzy.pmservice.pojo.Kehu_a;
import com.yzy.pmservice.pojo.Kehu_aExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Kehu_aMapper {
    int countByExample(Kehu_aExample example);

    int deleteByExample(Kehu_aExample example);

    int insert(Kehu_a record);

    int insertSelective(Kehu_a record);

    List<Kehu_a> selectByExample(Kehu_aExample example);

    int updateByExampleSelective(@Param("record") Kehu_a record, @Param("example") Kehu_aExample example);

    int updateByExample(@Param("record") Kehu_a record, @Param("example") Kehu_aExample example);

    int deleteKehuaById(Integer id);
}