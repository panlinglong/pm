package com.yzy.pmservice.mapper;


import com.yzy.pmservice.pojo.Empdeal;
import com.yzy.pmservice.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpdealMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Empdeal record);

    int insertSelective(Empdeal record);

    Empdeal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Empdeal record);

    int updateByPrimaryKey(Empdeal record);

    List<Empdeal> getEmpdealByPage(@Param("page") Integer page,@Param("size") Integer size,@Param("keyword") String keyword);

    Long getTotal(@Param("keyword") String keyword);

    Integer maxWorkID();
}
