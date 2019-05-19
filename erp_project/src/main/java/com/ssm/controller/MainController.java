package com.ssm.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/17
 * @since 1.0.0
 */
@Controller
public class MainController {

    @RequestMapping("erp")
    public String ERPHomePage(Model model){
        return "home";
    }

    @RequestMapping("pic/upload")
    @ResponseBody
    public Map uploadImage(MultipartFile uploadFile, HttpServletRequest request) throws IOException {
        String filename = uploadFile.getOriginalFilename();
        //String fileType = filename.substring(filename.lastIndexOf("."));
        String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/image/pic/");
        File file = new File(realPath + filename);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        uploadFile.transferTo(file);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("error", 0);
        resultMap.put("url", request.getContextPath() + "/image/pic/" + filename);
        return resultMap;
    }

    @RequestMapping("file/upload")
    @ResponseBody
    public Map uploadFile(MultipartFile file, HttpServletRequest request) throws IOException {
        String filename = file.getOriginalFilename();
        //String fileType = filename.substring(filename.lastIndexOf("."));
        String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/file/");
        File newFile = new File(realPath + filename);
        if (!newFile.getParentFile().exists()) {
            newFile.getParentFile().mkdirs();
        }
        file.transferTo(newFile);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("error", 0);
        resultMap.put("url", request.getContextPath() + "/file/" + filename);
        return resultMap;
    }

    @RequestMapping("file/download")
    public ResponseEntity<byte[]> export(String fileName, HttpServletRequest request) throws IOException {

        String name = fileName.substring(fileName.lastIndexOf("/") + 1);
        //System.out.println(name);
        HttpHeaders headers = new HttpHeaders();
        String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/file/");
        File file = new File(realPath + name);
        System.out.println(file.getAbsolutePath());
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", name);

        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }

}
