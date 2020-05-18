package com.aishang.shopback_1908.dao;

import com.aishang.shopback_1908.po.Product;
import com.aishang.shopback_1908.po.ProductExt;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.MyMapper;

import java.util.List;

@Mapper
public interface ProductMapper extends MyMapper<Product> {
    /**
     * @author 周城
     * @date 2020/1/6 11:41
     * @param 查询商品集合
     */
    List<ProductExt> getAllProducts(ProductExt productExt);

    /**
     * @author 周城
     * @date 2020/1/8 14:58
     * @param 添加商品
     */
    @Insert("insert into product values(default,#{pname},#{marketPrice},#{shopPrice},#{image},#{pdesc},#{isHot},#{pdate},#{csid})")
    void addProduct(Product product);
}