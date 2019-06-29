package com.jr.api.resource.controller;

import com.jr.api.resource.config.OssConfig;
import com.jr.api.resource.util.OSSUtil;
import com.jr.common.config.ProjectConfig;
import com.jr.common.util.FileUtil;
import com.jr.common.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
public class ResourceController {
    @Autowired
    private OssConfig ossConfig;
    //oss方式上传
    @PostMapping("/api/resource/fileupload.do")
    public R fileUpload(MultipartFile file, HttpServletRequest request) throws IOException {
        OSSUtil oss = ossConfig.createOSS();
        if (!file.isEmpty()){
            String path = oss.uploadFile(FileUtil.renameFile(file.getOriginalFilename()), file.getInputStream());
            return R.setOK("OK",path);
        }else{
            return R.setERROR("请选择上传文件");
        }
    }
}
