package com.bobo.manager.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.bobo.deal.bean.Category;
import com.bobo.deal.bean.Reclassify;
import com.bobo.manager.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class CategoryService implements com.bobo.deal.ServiceInterface.CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    //一级分类
    public int addCategory(String category) {
        return categoryMapper.addCategory(category);
    }

    public List<Category> queryall(){
        return categoryMapper.queryall();
    }

    public Integer queryCount(){
        return categoryMapper.queryCount();
    }

    public int change(int id ,String category){
        return categoryMapper.change(id,category);
    }

    public int delete(int id){
        return categoryMapper.delete(id);
    }

    //二级分类
    public int addReclassify(int cid,String reclassify){
        return categoryMapper.addReclassify(cid,reclassify);
    }
    public List<Reclassify> querryReclassifyAll(int cid){
        return categoryMapper.queryReclassifyAll(cid);
    }

    public int setLogo(int id,String url){
        return categoryMapper.setLogo(id,url);
    }

    public int deleteReclassify(int id){
        return categoryMapper.deleteReclassify(id);
    }
}
