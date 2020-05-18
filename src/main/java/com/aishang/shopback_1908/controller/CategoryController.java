package com.aishang.shopback_1908.controller;

import com.aishang.shopback_1908.po.Category;
import com.aishang.shopback_1908.po.Categorysecond;
import com.aishang.shopback_1908.service.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    /**
     * @author 周城
     * @date 2020/1/7 8:44
     * @param 获取一级类目集合
     */
    @RequestMapping("/getAllCategories")
    public List<Category> getAllCategories(){

        return categoryService.getAllCategories();
    }

    /**
     * @author 周城
     * @date 2020/1/7 8:38
     * @param 获取选定一级类目下二级类目的集合
     */
    @RequestMapping("/getAllCategorySeconds")
    public List<Categorysecond> getAllCategorySeconds(Integer cid){
        List<Categorysecond> categoryseconds = categoryService.getAllCategorySeconds(cid);
        return categoryseconds;
    }
}
