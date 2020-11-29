package com.yzy.pmservice.mapper;


import com.yzy.pmservice.pojo.Employee;
import com.yzy.pmservice.pojo.Newhouse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewhouseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Newhouse record);

    int insertSelective(Newhouse record);

    Newhouse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Newhouse record);

    int updateByPrimaryKey(Newhouse record);

    List<Newhouse> getNewhouseByPage(@Param("page") Integer page,@Param("size") Integer size,@Param("keyword") String keyword);

    Long getTotal(@Param("keyword") String keyword);

    Integer maxWorkID();
}
