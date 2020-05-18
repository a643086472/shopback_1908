package com.aishang.shopback_1908.service;

import com.aishang.shopback_1908.po.Categorysecond;
import com.aishang.shopback_1908.po.Product;
import com.aishang.shopback_1908.po.ProductExt;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    /**
     * @author 周城
     * @date 2020/1/7 8:40
     * @param 获取一级类目集合
     */
    PageInfo<ProductExt> getAllProducts(ProductExt productExt);

    /**
     * @author 周城
     * @date 2020/1/8 11:46
     * @param 添加商品
     */
    void addProduct(MultipartFile multipartFile, Product product);
}
