package com.yzy.pmservice.controller.deal;

import com.yzy.pmservice.pojo.Empdeal;
import com.yzy.pmservice.pojo.Employee;
import com.yzy.pmservice.pojo.RespBean;
import com.yzy.pmservice.pojo.RespPageBean;
import com.yzy.pmservice.service.EmpdealService;
import com.yzy.pmservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/deal/basic")
public class DealEmpController {

    @Autowired
    private EmpdealService empdealService;

    @GetMapping("/")
    public RespPageBean getEmpdealByPage(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer size,@RequestParam String keyword){
        return empdealService.getEmpdealByPage(page,size,keyword);
    }

    @PostMapping("/")
    public RespBean addEmp(@RequestBody Empdeal empdeal){
        if (empdealService.addEmp(empdeal)==1){
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteEmpByEid(@PathVariable Integer id){
        if (empdealService.deleteEmpByEid(id)==1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @PutMapping("/")
    public RespBean updateEmp(@RequestBody Empdeal empdeal){
        if (empdealService.updateEmp(empdeal)==1){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }



    @GetMapping("/maxWorkID")
    public RespBean maxWorkID(){
        return RespBean.ok("",String.format("%08d",empdealService.maxWorkID()+1));
    }


}
