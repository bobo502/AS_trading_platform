package com.bobo.deal.ServiceInterface;

import com.bobo.deal.bean.Category;
import com.bobo.deal.bean.Reclassify;

import java.util.List;

public interface CategoryService {
    int addCategory(String category);
    List<Category> queryall();
    Integer queryCount();
    int change(int id ,String category);
    int delete(int id);
    int addReclassify(int cid,String reclassify);
    List<Reclassify> querryReclassifyAll(int cid);
    int setLogo(int id,String url);
    int deleteReclassify(int id);
}
