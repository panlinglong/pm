package com.yzy.pmservice.mapper;


import com.yzy.pmservice.pojo.Qiugoues;
import com.yzy.pmservice.pojo.Qiugouzf;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QiugouzfMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Qiugouzf record);

    int insertSelective(Qiugouzf record);

    Qiugouzf selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Qiugouzf record);

    int updateByPrimaryKey(Qiugouzf record);

    List<Qiugouzf> getQiugouzfByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("keyword") String keyword);

    Long getTotal(@Param("keyword") String keyword);

    Integer maxWorkID();
}
