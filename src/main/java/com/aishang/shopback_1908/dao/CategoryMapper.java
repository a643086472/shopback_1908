package com.aishang.shopback_1908.dao;

import com.aishang.shopback_1908.po.Category;
import com.aishang.shopback_1908.po.Categorysecond;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.MyMapper;

import java.util.List;
@Mapper
public interface CategoryMapper extends MyMapper<Category> {

    @Select("select * from category")

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
    @Select("select * from categorysecond where cid=#{cid}")
    List<Categorysecond> getAllCategorySeconds(Integer cid);
}