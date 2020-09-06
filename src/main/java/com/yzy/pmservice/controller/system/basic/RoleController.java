package com.yzy.pmservice.controller.system.basic;

import com.yzy.pmservice.pojo.Menu;
import com.yzy.pmservice.pojo.RespBean;
import com.yzy.pmservice.pojo.Role;
import com.yzy.pmservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @GetMapping("/menu")
    public List<Menu> getAllMenus(){
        return roleService.getAllMenus();
    }

    @GetMapping("/mids/{rid}")
    public List<Integer> getMidsByRid(@PathVariable Integer rid){
        return roleService.getMidsByRid(rid);
    }

    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid,Integer[] mids){
        if (roleService.updateMenuRole(rid,mids)){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @PostMapping("/")
    public RespBean addRole(@RequestBody Role role){
        if (roleService.addRole(role) == 1){
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @DeleteMapping("/{rid}")
    public RespBean deleteRoleById(@PathVariable Integer rid){
        if (roleService.deleteRoleById(rid) == 1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
}
