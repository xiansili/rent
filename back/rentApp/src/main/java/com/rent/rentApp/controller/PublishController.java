package com.rent.rentApp.controller;

import com.rent.rentApp.model.ApplicationEntity;
import com.rent.rentApp.model.Product;
import com.rent.rentApp.service.impl.PublishServiceImpl;
import com.rent.rentApp.util.ConnectFtpServer;
import com.rent.rentApp.util.FileUtil;
import com.rent.rentApp.util.MsgResponse;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
//不加报错Could not resolve view with name  in servlet with name 'dispatcherServlet'
@RestController
public class PublishController {
    @Autowired
    private PublishServiceImpl publishService;
    @Autowired
    private ApplicationEntity applicationEntity;

    private String fileName = null;
    private byte[] image = null;
    Product product = new Product();
    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public MsgResponse publish(@RequestParam("file")MultipartFile[] files,
                               @RequestParam("productName") String productName,
                               @RequestParam("productBrand") String productBrand,
                               @RequestParam("productDescribe") String productDescribe,
                               @RequestParam("productType") String productType,
                               @RequestParam("productPrice") Double productPrice){
            //判断文件是否为空
            if (files != null && files.length > 0){
                String allImagePath = "";
                String rootPath = "http://localhost:9090/";
                for (int i=0; i<files.length;i++){
                        fileName = files[i].getOriginalFilename();
                    try {
//                        获得输入流
                        InputStream inputStream = files[i].getInputStream();
//                        登录ftp返回ftp
                        FTPClient login = ConnectFtpServer.initFtpClient(applicationEntity);
//                         上传文件
                        String newName = FileUtil.uploadFile(inputStream, fileName, login, applicationEntity);
//                        判断最后一位，如果是最后一位就不用加","
                        if (i==files.length - 1){
                            allImagePath +=rootPath + newName;
                        }else {
                            allImagePath +=rootPath + newName + ",";
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                product.setImage(allImagePath);
            }else {
                return MsgResponse.err("图片为空");
            }
        product.setProductName(productName);
        product.setProductBrand(productBrand);
        product.setProductDescribe(productDescribe);
        product.setProductPrice(productPrice);
        product.setProductType(productType);
        product.setUserId(123);
//        调用service层，存入数据库
        MsgResponse publish = publishService.publish(product);
        return publish;
    }
}
