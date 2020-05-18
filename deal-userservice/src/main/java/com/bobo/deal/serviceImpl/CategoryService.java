package com.bobo.deal.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.bobo.deal.ServiceInterface.UserCategoryService;
import com.bobo.deal.bean.Category;
import com.bobo.deal.bean.Reclassify;
import com.bobo.deal.bean.ReclassifyList;
import com.bobo.deal.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CategoryService implements UserCategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    public List query() {
        List responce= new ArrayList();
        List<Category> categories = categoryMapper.queryall();
        for (Category categorie : categories){
            HashMap hashMap = new HashMap();
            ArrayList<ReclassifyList> reclassifyLists = new ArrayList<ReclassifyList>();
            List<Reclassify> reclassifies = categoryMapper.queryByid(categorie.getId());
            for (Reclassify reclassify : reclassifies){
                ReclassifyList list=new ReclassifyList();
                list.setReclassify_id(reclassify.getReclassify_id());
                list.setLabel(reclassify.getReclassify());
                list.setValue(reclassify.getCid());
                list.setUrl(reclassify.getUrl());
                reclassifyLists.add(list);
            }
            hashMap.put("value",categorie.getId());
            hashMap.put("label",categorie.getCategory());
            hashMap.put("children",reclassifyLists);
            responce.add(hashMap);
        }
        return responce;
    }
}
