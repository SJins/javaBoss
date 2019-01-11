package com.zhihui.Utils;


import com.zhihui.vo.ResultVo;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class EmailUtil {

    private static HtmlEmail email;

    static {
        email = new HtmlEmail();
    }

    public static ResultVo sendCodeToEmail(String emailPath, String Msg){
        try {
            email.setHostName("smtp.163.com");
            email.setCharset("utf-8");
            email.addTo(emailPath);
            email.setFrom("15836107077@163.com","bear_rain");
            email.setAuthentication("15836107077@163.com","yu1212chuan521");
            email.setSubject("智慧商城集团会员邮箱验证");
            email.setMsg("<p>您好 O(∩_∩)O~~<br><br>欢迎加入智慧商城!<br><br>" +
                    "帐户需要验证邮箱才可以注册，赶紧验证成为智慧商城正式的一员吧:)<br><br>请在3分钟内输入下面的验证码立即验证帐户："
                    + "<br><span style='border-bottom: 1px dashed rgb(204, 204, 204); z-index: 1; position: static; " +
                    "font-size: 25px; color: #f60; margin-left: 275px;' >" + Msg + "</span><br>此为系统邮件，请勿回复");
            email.send();
            return ResultVo.setOK("发送成功");
        } catch (EmailException e) {
            return ResultVo.setERROR();
        }
    }
}
