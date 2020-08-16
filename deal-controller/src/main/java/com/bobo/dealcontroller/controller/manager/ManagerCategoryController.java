package com.bobo.dealcontroller.controller.manager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bobo.deal.ServiceInterface.CategoryService;
import com.bobo.deal.bean.Category;
import com.bobo.deal.bean.Reclassify;
import com.bobo.deal.bean.RespBean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 管理员分类信息处理
 */
@RestController
@RequestMapping("/manager")
public class ManagerCategoryController {
    @Reference
    CategoryService categoryService;

    //新增一级分类
    @PostMapping("/category/add")
    public RespBean add(@RequestParam("category") String category){
        if (categoryService.addCategory(category)==1){
            return new RespBean("success","新增一级分类成功！");
        }
        else return new RespBean("error","新增失败，请重试！");
    }
    //获取一级分类所有信息
    @GetMapping("/category/queryall")
    public List<Category> queryall(){
        return categoryService.queryall();
    }
    //获取一级分类的条数
    @GetMapping("/category/querycount")
    public Integer querycount(){
        return categoryService.queryCount();
    }
    //修改一级分类
    @PostMapping("/category/change")
    public RespBean change(int id,String category){
        if (categoryService.change(id,category)==1){
            return new RespBean("success","修改成功");
        }
        else return new RespBean("error","修改失败");
    }
    //删除一级分类
    @PostMapping("/category/delete")
    public RespBean delete(int id){
        if (categoryService.delete(id)==1){
            return new RespBean("success","删除成功");
        }
        else return new RespBean("error","删除失败");
    }

    //新增二级分类信息
    @PostMapping("/reclassify/add")
    public RespBean add(@RequestParam("cid") int cid,@RequestParam("reclassify") String reclassify){
        if (categoryService.addReclassify(cid,reclassify)==1){
            return new RespBean("success","新增成功");
        }
        else return new RespBean("error","新增失败");
    }
    //查出一级分类下的所有二级分类
    @PostMapping("/reclassify/queryall")
    public List<Reclassify> query(@RequestParam("cid") int  cid){
        return categoryService.querryReclassifyAll(cid);
    }
    @PostMapping("/reclassify/delete")
    public RespBean delete2(int rid){
        if (categoryService.deleteReclassify(rid)==1){
            return new RespBean("success","删除成功");
        }
        else return new RespBean("error","删除失败");
    }
}
