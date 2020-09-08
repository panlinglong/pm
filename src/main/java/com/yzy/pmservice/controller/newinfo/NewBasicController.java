package com.yzy.pmservice.controller.newinfo;

import com.yzy.pmservice.pojo.Employee;
import com.yzy.pmservice.pojo.Newinfo;
import com.yzy.pmservice.pojo.RespBean;
import com.yzy.pmservice.pojo.RespPageBean;
import com.yzy.pmservice.service.EmployeeService;
import com.yzy.pmservice.service.NewinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/newinfo/basic")
public class NewBasicController {

    @Autowired
    private NewinfoService newinfoService;



    @GetMapping("/")
    public RespPageBean getNewinfoByPage(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer size,@RequestParam String keyword){
        return newinfoService.getNewinfoByPage(page,size,keyword);
    }

    @PostMapping("/")
    public RespBean addNew(@RequestBody Newinfo newinfo){
        if (newinfoService.addNew(newinfo)==1){
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteNewByEid(@PathVariable Integer id){
        if (newinfoService.deleteNewByEid(id)==1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @PutMapping("/")
    public RespBean updateNew(@RequestBody Newinfo newinfo){
        if (newinfoService.updateNew(newinfo)==1){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }



    @GetMapping("/maxWorkID")
    public RespBean maxWorkID(){
        return RespBean.ok("",String.format("%08d",newinfoService.maxWorkID()+1));
    }


}
