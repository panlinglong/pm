package com.yzy.pmservice.controller.emp;

import com.yzy.pmservice.pojo.*;
import com.yzy.pmservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee/basic")
public class EmpBasicController {

    @Autowired
    private EmployeeService employeeService;



    @GetMapping("/")
    public RespPageBean getEmployeeByPage(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer size,@RequestParam String keyword){
        return employeeService.getEmployeeByPage(page,size,keyword);
    }

    @PostMapping("/")
    public RespBean addEmp(@RequestBody Employee employee){
        if (employeeService.addEmp(employee)==1){
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteEmpByEid(@PathVariable Integer id){
        if (employeeService.deleteEmpByEid(id)==1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @PutMapping("/")
    public RespBean updateEmp(@RequestBody Employee employee){
        if (employeeService.updateEmp(employee)==1){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }



    @GetMapping("/maxWorkID")
    public RespBean maxWorkID(){
        return RespBean.ok("",String.format("%08d",employeeService.maxWorkID()+1));
    }


}
