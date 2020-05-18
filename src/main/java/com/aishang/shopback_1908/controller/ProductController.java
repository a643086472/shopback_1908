package com.aishang.shopback_1908.controller;



import com.aishang.shopback_1908.po.Categorysecond;
import com.aishang.shopback_1908.po.Product;
import com.aishang.shopback_1908.po.ProductExt;
import com.aishang.shopback_1908.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Resource
    private ProductService productService;




    /**
     * @author 周城
     * @date 2020/1/7 8:37
     * @param 获取商品集合
     */
    @RequestMapping("/getAllProducts")
    public  PageInfo<ProductExt> getAllProducts(@RequestBody ProductExt productExt){
        PageInfo<ProductExt> allProducts = productService.getAllProducts(productExt);

        return allProducts;
    }

    /**
     * @author 周城
     * @date 2020/1/8 11:10
     * @param 添加商品
     */
    @RequestMapping("/addProduct")
    public String addProduct(@RequestParam("file")MultipartFile multipartFile, Product product){

        productService.addProduct(multipartFile,product);
        return "ok";
    }





}
