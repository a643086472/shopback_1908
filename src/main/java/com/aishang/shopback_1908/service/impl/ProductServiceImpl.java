package com.aishang.shopback_1908.service.impl;

import com.aishang.shopback_1908.Util.FileUploadUtil;
import com.aishang.shopback_1908.dao.ProductMapper;
import com.aishang.shopback_1908.po.Product;
import com.aishang.shopback_1908.po.ProductExt;
import com.aishang.shopback_1908.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService
{

    @Resource
    private ProductMapper productMapper;
    @Resource
    private FileUploadUtil fileUploadUtil;



    /**
     * @author 周城
     * @date 2020/1/8 11:47
     * @param 分页信息
     */

    @Override
    public PageInfo<ProductExt> getAllProducts(ProductExt productExt) {
        // 设置分页的pageNow和pageSize
        PageHelper.startPage(productExt.getPageNow(),productExt.getPageSize());
        // 查询商品
        List<ProductExt> products = productMapper.getAllProducts(productExt);
        //
        PageInfo<ProductExt> pageInfo = new PageInfo(products,7);
        return pageInfo;
    }

    /**
     * @author 周城
     * @date 2020/1/8 11:47
     * @param 添加商品
     * TODO(事务)
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addProduct(MultipartFile multipartFile, Product product) {
        File localFile = null;

        try {
            // 完成上传的file对象
            localFile = fileUploadUtil.doUpload(multipartFile);
            // 存入上添加时间
            product.setPdate(new Date());
            // 存入图片地址
            product.setImage(fileUploadUtil.getImgPath(localFile.getPath()));
            // 上传商品信息导数据库
            productMapper.addProduct(product);
        } catch (IOException e) {
            e.printStackTrace();
            if(localFile!=null){
                // 上传失败，为保证事务要删除图片，数据信息库自动回滚
                fileUploadUtil.delPic(localFile.getPath());
            }
        }

    }
}
