package com.yzy.pmservice.controller.qiugou;

import com.yzy.pmservice.pojo.Empdeal;
import com.yzy.pmservice.pojo.Qiugoues;
import com.yzy.pmservice.pojo.RespBean;
import com.yzy.pmservice.pojo.RespPageBean;
import com.yzy.pmservice.service.EmpdealService;
import com.yzy.pmservice.service.QiugouesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/qiugou/ershou")
public class QiugouesController {

    @Autowired
    private QiugouesService qiugouesService;

    @GetMapping("/")
    public RespPageBean getQiugouesByPage(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer size,@RequestParam String keyword){
        return qiugouesService.getQiugouesByPage(page,size,keyword);
    }

    @PostMapping("/")
    public RespBean addQiugoues(@RequestBody Qiugoues qiugoues){
        if (qiugouesService.addQiugoues(qiugoues)==1){
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteQiugouesByEid(@PathVariable Integer id){
        if (qiugouesService.deleteQiugouesByEid(id)==1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @PutMapping("/")
    public RespBean updateQiugoues(@RequestBody Qiugoues qiugoues){
        if (qiugouesService.updateQiugoues(qiugoues)==1){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }



    @GetMapping("/maxWorkID")
    public RespBean maxWorkID(){
        return RespBean.ok("",String.format("%08d",qiugouesService.maxWorkID()+1));
    }


}
