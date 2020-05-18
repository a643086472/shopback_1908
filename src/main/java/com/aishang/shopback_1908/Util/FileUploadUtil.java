package com.aishang.shopback_1908.Util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author 周城
 * @date 2020/1/8 14:27
 * @param 文件上传工具类
 */
@Component
public class FileUploadUtil {

    /**
     * 静态资源绝对路径
     */
    @Value("${file.uploadFolder}")
    private String uploadFolder;

    /**
     * 静态资源相对路径
     */
    @Value("${file.staticAccessPath}")
    private String staticAccessPath;

    /**
     * 获取文件项目相对路径
     * @Param path 相对路径
     * @return
     */
    public String getImgPath(String path){
        //将路径中的\换成/
        path=path.replaceAll("\\\\","/");
        staticAccessPath = staticAccessPath.split("\\*")[0];
        path = path.split(uploadFolder)[1];
        path=staticAccessPath+path;
        return path;
    }

    /**
     * 获取文件绝对路径
     * @Param path 绝对路径
     */
    public String getRealPath(String path){
        //将路径中的\换成/
        path=path.replaceAll("\\\\","/");
        path = path.split(uploadFolder)[1];
        staticAccessPath = staticAccessPath.split("\\*")[0];
        path=staticAccessPath+path;
        return path;
    }

    /**
     * 按日期打散目录
     */
    public File makeFullDirectoryObject(File storyDirectory) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateDirectory = sdf.format(new Date());
        //创建目录对象
        File file = new File(storyDirectory, dateDirectory);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /**
     * 批量上传文件
     * @param files 文件数组
     * @return  上传完成的file对象集合
     * @throws IOException
     */
    public List<File> doUpload(MultipartFile[] files) throws IOException {
        List<File> localFiles = new ArrayList<File>();
        for (MultipartFile file : files) {
            File localFile = doUpload(file);
            localFiles.add(localFile);
        }
        return localFiles;
    }

    /**
     * 上传文件
     * @param file  文件
     * @return  完成上传的file对象
     * @throws IOException
     */
    public File doUpload(MultipartFile file) throws IOException {
        File localFile = null;
        if (file.isEmpty()) {
            //此文件域未进行上传
            System.err.println("**************************** 请选择文件！**************************");
        } else {
            //如果文件夹不存在，创建新的文件夹
            File directory = new File(uploadFolder);
            File directoryFile = makeFullDirectoryObject(directory);
            // 把文件上传至path的路径，文件名改为为当前时间+原始文件名.扩展名
            localFile = new File(directoryFile, UUID.randomUUID()+ file.getOriginalFilename());
            //执行上传
            file.transferTo(localFile);
            System.out.println("**************************************");
            System.out.println("文件路径："+localFile.getPath());
            System.out.println("**************************************");
        }
        return localFile;
    }

    /**
     * 删除文件
     * @param path 项目路径+文件路径
     */
    public void delPic(String path) {
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
        //判断父文件夹是否为空
        String parentPath = getParentPath(path);
        File parentFile = new File(parentPath);
        String[] list = parentFile.list();
        //为空删除父文件夹
        if(parentFile.exists()){
            if (parentFile == null || list.length == 0) {
                delFolder(parentPath);
            }
        }
    }

    /**
     * 删除文件夹
     * @param folderPath 文件夹完整绝对路径
     */
    public void delFolder(String folderPath) {
        try {
            // delAllFile(folderPath); // 删除完里面所有内容
            String filePath = folderPath;
            filePath = filePath.toString();
            File myFilePath = new File(filePath);
            myFilePath.delete(); // 删除空文件夹
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * 删除指定文件夹下所有文件
     * @param path 文件夹完整绝对路径
     * @return
     */
    public boolean delAllFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                // 先删除文件夹里面的文件
                delAllFile(path + "/" + tempList[i]);
                // 再删除空文件夹
                delFolder(path + "/" + tempList[i]);
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 得到该文件的父类文件的路径
     * @param path 绝对路径
     * @return
     */
    public String getParentPath(String path) {
        File file = new File(path);
        StringBuilder sb = new StringBuilder();
        File temp = file;
        while (temp.getParentFile() != null
                && temp.getParentFile().getName().length() != 0) {
            sb.insert(0, "/" + temp.getParentFile().getName());
            temp = temp.getParentFile();
        }
        sb.append("/");
        return sb.toString();

    }
}