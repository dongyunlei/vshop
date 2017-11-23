package com.dong.vshop.service.impl;

import com.dong.vshop.common.util.FtpUtils;
import com.dong.vshop.common.util.IDUtils;
import com.dong.vshop.common.util.PropKit;
import com.dong.vshop.service.FileService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class FileServiceImpl implements FileService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Map<String, Object> uploadImage(MultipartFile upfile) {
        Map<String, Object> map = new HashMap<>();
        try {
            String name = "ftp.properties";
            String host = PropKit.use(name).get("ftp.address");
            int port = PropKit.use(name).getInt("ftp.port");
            String username = PropKit.use(name).get("ftp.username");
            String password = PropKit.use(name).get("ftp.password");
            String basePath = PropKit.use(name).get("ftp.basePath");
            String filePath = new DateTime().toString("/yyyy/MM/dd");
            String original = upfile.getOriginalFilename();
            String fileType = original.substring(original.lastIndexOf("."));
            String fileName = IDUtils.genImageName();
            fileName += fileType;
            InputStream is = upfile.getInputStream();

            boolean b = FtpUtils.uploadFile(host, port, username, password, basePath, filePath, fileName, is);
            if (b) {
                map.put("state", "SUCCESS");
                map.put("title", fileName);
                map.put("original", original);
                map.put("type", fileType);
                map.put("url", filePath + "/" + fileName);
                map.put("size", upfile.getSize());
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return map;
    }
}
