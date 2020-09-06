package com.yzy.pmservice.mapper;


import com.yzy.pmservice.pojo.Hr_role;
import org.apache.ibatis.annotations.Param;

public interface Hr_roleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr_role record);

    int insertSelective(Hr_role record);

    Hr_role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr_role record);

    int updateByPrimaryKey(Hr_role record);

    void deleteByHrid(Integer hrid);

    Integer addRole(@Param("hrid") Integer hrid,@Param("rids") Integer[] rids);
}
