package com.yzy.pmservice.service;

import com.yzy.pmservice.mapper.MenuMapper;
import com.yzy.pmservice.mapper.Menu_roleMapper;
import com.yzy.pmservice.mapper.RoleMapper;
import com.yzy.pmservice.pojo.Menu;
import com.yzy.pmservice.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private Menu_roleMapper menu_roleMapper;

    public List<Integer> getMidsByRid(Integer rid) {
        return menuMapper.getMidsByRid(rid);
    }

    public List<Role> getAllRoles(){
        return roleMapper.getAllRoles();
    }

    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }

    @Transactional
    public boolean updateMenuRole(Integer rid, Integer[] mids) {
        menu_roleMapper.deleteByRid(rid);
        if (mids == null || mids.length == 0){
            return true;
        }
        Integer result = menu_roleMapper.insertRecord(rid,mids);
        return result==mids.length;
    }

    public Integer addRole(Role role) {
        if (!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_"+role.getName());
        }
        return roleMapper.insert(role);
    }

    public Integer deleteRoleById(Integer rid) {
        return roleMapper.deleteByPrimaryKey(rid);

    }
}
