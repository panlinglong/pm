package com.yzy.pmservice.mapper;


import com.yzy.pmservice.pojo.Chuzu;
import com.yzy.pmservice.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChuzuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Chuzu record);

    int insertSelective(Chuzu record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Chuzu record);

    int updateByPrimaryKey(Chuzu record);

    List<Chuzu> getChuzuByPage(@Param("page") Integer page,@Param("size") Integer size,@Param("keyword") String keyword);

    Long getTotal(@Param("keyword") String keyword);

    Integer maxWorkID();
}
