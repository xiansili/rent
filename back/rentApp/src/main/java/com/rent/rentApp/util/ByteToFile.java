package com.rent.rentApp.util;

import java.io.*;

public class ByteToFile {
    public static File getFileFromBytes(byte[] bytes, String path) {
        try {
            // 根据绝对路径初始化文件
            File localFile = new File(path);
            if (!localFile.exists()) {
                localFile.createNewFile();
            }
            // 输出流
            OutputStream os = new FileOutputStream(localFile);
            os.write(bytes);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}