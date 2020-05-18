package com.aishang.shopback_1908.service.impl;

import com.aishang.shopback_1908.dao.CategoryMapper;
import com.aishang.shopback_1908.po.Category;
import com.aishang.shopback_1908.po.Categorysecond;
import com.aishang.shopback_1908.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    /**
     * @author 周城
     * @date 2020/1/6 17:35
     * @param 获取一级类目集合
     */
    @Override
    public List<Category> getAllCategories() {
        return categoryMapper.getAllCategories();
    }

    /**
     * @author 周城
     * @date 2020/1/7 8:38
     * @param 获取选定一级类目下二级类目的集合
     */
    @Override
    public List<Categorysecond> getAllCategorySeconds(Integer cid) {
        return categoryMapper.getAllCategorySeconds(cid);
    }
}
