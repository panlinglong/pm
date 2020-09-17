package com.yzy.pmservice.mapper;


import com.yzy.pmservice.pojo.Empdeal;
import com.yzy.pmservice.pojo.Newhousedeal;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewhousedealMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Newhousedeal record);

    int insertSelective(Newhousedeal record);

    Newhousedeal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Newhousedeal record);

    int updateByPrimaryKey(Newhousedeal record);

    List<Newhousedeal> getNewhousedealByPage(@Param("page") Integer page,@Param("size") Integer size,@Param("keyword") String keyword);

    Long getTotal(@Param("keyword") String keyword);

    Integer maxWorkID();
}
