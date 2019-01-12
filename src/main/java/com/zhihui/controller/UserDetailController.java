package com.zhihui.controller;

import com.zhihui.service.UserDetailService;
import com.zhihui.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Api(produces = "用户详情类接口文档", value = "接口文档")
@RestController
public class UserDetailController {
    @Autowired
    private UserDetailService userDetailService;

    @ApiOperation(notes = "根据传来的token令牌查找到个人信息返回", value = "个人信息接口")
    @PostMapping("/user/myself.do")
    public ResultVo myself(String token) {
        return userDetailService.myselfMsg(token);
    }

    @ApiOperation(notes = "上传头像，通过token修改头像", value = "修改头像接口")
    @PostMapping("/user/updateHeadImg.do")
    public ResultVo updateMyselfHeadImg(@RequestParam MultipartFile headImg,String token, HttpServletRequest request) {
        try {
            String serverName = request.getSession().getServletContext().getRealPath("/");
            File file = new File(serverName);
            File parentFile = file.getParentFile();
            String path = parentFile.getPath();
            File upFile = new File(path, "/images");
            String path1 = upFile.getPath();
            String dirPath = "http://13.250.74.156:8080/images/";
            if (!headImg.isEmpty()) {
                if (!upFile.exists()) {
                    upFile.mkdirs();
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                String filename = sdf.format(new Date()) + headImg.getOriginalFilename();
                String headImgUrl = dirPath + filename;
                headImg.transferTo(new File(path1, filename));
                return userDetailService.updateMsg(token, headImgUrl);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResultVo.setERROR();
        }
        return ResultVo.setERROR();
    }


    @ApiOperation(notes = "传入token，性别1是男，0代表女，生日格式为yyyy年MM月dd日", value = "修改性别和生日的接口")
    @GetMapping("/user/updateMsg.do")
    public ResultVo updateSexAndBirthday(String token, Integer sex, Date birthday) {
        return userDetailService.updateSexAndBirthday(token, sex, birthday);
    }

}
