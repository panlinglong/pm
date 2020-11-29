package com.yzy.pmservice.mapper;


import com.yzy.pmservice.pojo.Employee;
import com.yzy.pmservice.pojo.Qiugoues;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QiugouesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Qiugoues record);

    int insertSelective(Qiugoues record);

    Qiugoues selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Qiugoues record);

    int updateByPrimaryKey(Qiugoues record);

    List<Qiugoues> getQiugouesByPage(@Param("page") Integer page,@Param("size") Integer size,@Param("keyword") String keyword);

    Long getTotal(@Param("keyword") String keyword);

    Integer maxWorkID();
}
