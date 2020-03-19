package com.rent.rentApp.util;

import com.rent.rentApp.model.ApplicationEntity;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.net.SocketException;

public class ConnectFtpServer {
    @Autowired
    public ApplicationEntity ftp;
    public static FTPClient initFtpClient(ApplicationEntity ftp){
        FTPClient ftpClient = new FTPClient();
        ftpClient.setConnectTimeout(1000*30);//设置连接超时时间
        ftpClient.setControlEncoding("utf-8");
//        防止中文乱码
        ftpClient.setControlEncoding("GBK");
        ftpClient.enterLocalPassiveMode();
        try {
            //        连接服务器
            ftpClient.connect(ftp.getFtpHost(),ftp.getFtpPort());
            //        登录服务器
            ftpClient.login(ftp.getFtpUsername(),ftp.getFtpPassword());
            //         是否成功登录服务器
            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)){
                ftpClient.disconnect();
                System.out.println("未连接到ftp，用户名或密码错误");
                return null;
            }else {
                System.out.println("连接ftp成功");
                return ftpClient;
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("未连接到ftp端口错误");
            return null;
        }
    }
}
