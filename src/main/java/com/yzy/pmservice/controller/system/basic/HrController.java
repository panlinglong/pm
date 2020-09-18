package com.yzy.pmservice.controller.system.basic;

import com.yzy.pmservice.pojo.Chuzudeal;
import com.yzy.pmservice.pojo.Hr;
import com.yzy.pmservice.pojo.RespBean;
import com.yzy.pmservice.pojo.Role;
import com.yzy.pmservice.service.HrService;
import com.yzy.pmservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/hr")
public class HrController {

    @Autowired
    private HrService hrService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/")
    public List<Hr> getAllHrs(String keywords){
        return hrService.getAllHrs(keywords);
    }

    @PutMapping("/")
    public RespBean updateHr(@RequestBody Hr hr){
        if (hrService.updateHr(hr) == 1){
            return RespBean.ok("更新成功！");
        }else {
            return RespBean.error("更新失败！");
        }
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @PutMapping("/role")
    public RespBean updateHrRole(Integer hrid,Integer[] rids){
        if (hrService.updateHrRole(hrid,rids)){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteHrById(@PathVariable Integer id){
        if (hrService.deleteHrById(id)==1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @PostMapping("/")
    public RespBean addHr(@RequestBody Hr hr){
        if (hrService.addHr(hr)==1){
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }
}
