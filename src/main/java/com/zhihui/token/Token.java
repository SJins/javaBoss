package com.zhihui.token;

import com.zhihui.entity.User;

import java.util.LinkedHashMap;
import java.util.Map;

public class Token {

    public static Map<String, User> token;

    static {
        token = new LinkedHashMap<>();
    }
}
