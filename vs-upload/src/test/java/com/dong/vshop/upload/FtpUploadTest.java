package com.dong.vshop.upload;

import com.dong.vshop.common.util.FtpUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

public class FtpUploadTest {

    @Test
    public void testFtpUpload() throws Exception {
//        FTPClient ftpClient = new FTPClient();
//        ftpClient.connect("47.96.15.39", 21);
//        ftpClient.login("ftpuser","123456");
//        FileInputStream fis = new FileInputStream(new File("g:\\2.jpg"));
//        ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
//        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
//        ftpClient.storeFile("hell.jpg",fis);
//        fis.close();
//        ftpClient.logout();
//        FileInputStream fs = new FileInputStream("g:\\3.jpg");
//        FtpUtils.uploadFile("47.96.15.39", 21, "ftpuser", "123456", "/home/ftpuser/www/images",
//                "/2017/11/20", "hello.jpg", fs);
//        fs.close();
    }
}
