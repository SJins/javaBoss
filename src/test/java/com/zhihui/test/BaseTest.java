package com.zhihui.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)// 使用junit启动测试
@ContextConfiguration("/spring-bean.xml") // 加载spring的配置文件
@Transactional
public class BaseTest {
}
