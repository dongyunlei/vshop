package com.dong.vshop.web;

import com.dong.vshop.service.FileService;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Map;

@Controller
public class FileAction {

    @Autowired
    private FileService fileService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @RequestMapping(value = "/file/upload", method = RequestMethod.GET)
    public void config(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //设置请求流和响应流的字符集，相应内容的文档类型
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        String action = request.getParameter("action");
        if ("config".equals(action)) {
            InputStream is = this.getClass().getClassLoader().getResourceAsStream("config.json");
            PrintWriter out = response.getWriter();
            IOUtils.copy(is, out, "UTF-8");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/file/upload", method = RequestMethod.POST)
    public Map<String, Object> upload(MultipartFile upfile) {
        Map<String, Object> map = null;
        try {
            map = fileService.uploadImage(upfile);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return map;
    }
}
