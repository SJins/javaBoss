package com.zhihui.filter;


import com.alibaba.druid.support.json.JSONUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhihui.token.Token;
import com.zhihui.vo.ResultVo;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.*;
import java.io.IOException;

public class TokenFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getParameter("token");
        System.out.println("进入");
        if (Token.token.get(token) != null) {
            System.out.println("成功");
            chain.doFilter(request, response);
        }else{
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("失败");
            response.getWriter().write(mapper.writeValueAsString(ResultVo.setERROR()));
        }

    }

    @Override
    public void destroy() {

    }
}
