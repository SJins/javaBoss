package com.zhihui.controller;

import com.zhihui.entity.UserDetail;
import com.zhihui.service.UserDetailService;
import com.zhihui.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation(notes = "修改个人信息以及上传头像", value = "修改信息")
    @PostMapping("/user/updateMsg.do")
    public ResultVo updateMsg(String token, HttpServletRequest request, UserDetail userDetail) throws IOException {
        String serverName = request.getSession().getServletContext().getRealPath("/");
        File file = new File(serverName);
        File parentFile = file.getParentFile();
        String path = parentFile.getPath();
        File upFile = new File(path, "/images");
        String sqlpath = null;
        String dirpath = "http://13.250.74.156:8080/images/";
        if (!userDetail.getFile().isEmpty()) {
            if (upFile.exists()) {
                upFile.mkdirs();
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            String filename = sdf.format(new Date()) + userDetail.getFile().getOriginalFilename();

            userDetail.getFile().transferTo(new File(dirpath, filename));
            userDetail.setImg(filename);
            return userDetailService.updateMsg(token, userDetail);
        }
        return ResultVo.setERROR();
    }


    //根据用户id,查找用户的个人资料
    @ApiOperation(notes = "个人资料接口",value = "个人资料")
    @GetMapping("findOneDetail.do")
    public ResultVo findOneDetail(Integer id){
        UserDetail detail = userDetailService.findOneDetail(id);
        return  ResultVo.setOK(detail);
    }
}
