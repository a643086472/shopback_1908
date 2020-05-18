package com.aishang.shopback_1908.service;

import com.aishang.shopback_1908.po.Category;
import com.aishang.shopback_1908.po.Categorysecond;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {

    /**
     * @author 周城
     * @date 2020/1/7 8:38
     * @param 获取一级类目集合
     */
    List<Category> getAllCategories();

    /**
     * @author 周城
     * @date 2020/1/7 8:38
     * @param 获取选定一级类目下二级类目的集合
     */
    List<Categorysecond> getAllCategorySeconds(Integer cid);
}
