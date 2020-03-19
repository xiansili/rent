package com.rent.rentApp.util;

import com.rent.rentApp.model.ApplicationEntity;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import javax.security.auth.login.AppConfigurationEntry;
import java.io.*;
import java.util.UUID;

public class FileUtil {
    /**
     * @param file     文件
     * @param filePath 文件存放路径
     * @param fileName 源文件名
     */
    public static void upload(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);

//        如果文件夹不存在，则新建一个文件夹
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

  /*该类用来创建一个文件并向文件中写数据。如果该流在打开文件
  进行输出前，目标文件不存在，那么该流会创建该文件。*/
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        //        写入文件
        out.write(file);
        System.out.println("写入成功");
        out.flush();
        out.close();
    }

    /**
     *
     * @param inputStream
     * @param fileName
     * @param login
     * @param app
     * @return
     */
    public static String uploadFile(InputStream inputStream, String fileName, FTPClient login, ApplicationEntity app) {
        //        先判断是否登录
        if (login == null){
            System.out.println("请先登录ftp");
            return "请先登录ftp";
        }
        try {
//            让客户端告诉服务端开通一个端口用来数据传输
            login.enterLocalPassiveMode();
//            切换到文件保存的目录
            login.changeWorkingDirectory("/");
            FTPFile[] fs = login.listFiles();
//          调用ifFileExist放方法，判断文件名是否重复
            String newName = FileUtil.ifFileExist(fileName, fs);
//          如果缺省该句 传输txt正常 但图片和其他格式的文件传输出现乱码
            login.setFileType(FTP.BINARY_FILE_TYPE);
            boolean isSuccess = login.storeFile(newName, inputStream);
            if (!isSuccess){
               System.out.println("上传失败");
               return "上传失败";
            }else {
                System.out.println("上传成功");
//                关闭连接
                login.logout();
                return newName;
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("上传失败");
            return "上传失败";
        }finally {
            if (login.isConnected()){
                try {
                    login.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("关闭失败");
                }
            }
        }
    }

    /**
     *
     * @param fileName 文件名
     * @param fs FTP文件
     * @return
     */
    public static String ifFileExist(String fileName, FTPFile[] fs ){
        for (FTPFile ftpFile : fs){

//             如果文件名和ftp服务器上的文件名重复
            if (ftpFile.getName().equals(fileName)){
//              生成一个随机数
                return UUID.randomUUID().toString() +
                        fileName.substring(fileName.indexOf("."));
            }
        }
        return fileName;
    }
}
