package com.yzy.pmservice.controller.emp;

import com.yzy.pmservice.pojo.*;
import com.yzy.pmservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@CrossOrigin
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


    @RequestMapping("/img")
    public String FileUpdate (HttpServletRequest request,MultipartFile file) {
        String str=request.getServletContext().getRealPath("/images/");
        //得到上传时的文件名字
        String originalname=file.getOriginalFilename();
        //substring(originalname.lastIndexOf(".")截取图片名后缀
        String newName= originalname.substring(originalname.lastIndexOf("."));
        //利用UUidUtil工具类生成新的文件名字
        newName =(UUID.randomUUID().toString())+newName;

        System.out.println(newName);
        System.out.println(str);
        File newFile=new File(str,newName);

        //获得文件目录，判断是否存在
        if(!newFile.getParentFile().exists()) {
            //如果path路径不存在，创建一个文件夹，存在则使用当前文件夹
            newFile.getParentFile().mkdirs();
        }
        try {
            //保存文件到指定路径之中
            file.transferTo(newFile);
        } catch (IllegalStateException | IOException e) {

            e.printStackTrace();
        }
        System.out.println("str: "+str+" newName: "+newName);
        String newSrc = "src/main/resources/images/"+newName;
        try
        {

            FileInputStream fis = new FileInputStream(str+newName);//创建输入流对象
            FileOutputStream fos = new FileOutputStream(newSrc); //创建输出流对象
            byte datas[] = new byte[1024*8];//创建搬运工具
            int len = 0;//创建长度
            while((len = fis.read(datas))!=-1)//循环读取数据
            {
                fos.write(datas,0,len);
            }
            fis.close();//释放资源
            fos.close();//释放资源
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        return newSrc;
    }

}
