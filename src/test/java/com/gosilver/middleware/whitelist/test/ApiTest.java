package com.gosilver.middleware.whitelist.test;

import cn.gosilver.middleware.whitelist.test.ApiTestApplication;
import cn.gosilver.middleware.whitelist.test.interfaces.UserController;
import cn.gosilver.middleware.whitelist.test.interfaces.UserInfo;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 单元测试
 * Author: chensh
 * Date: 2024/9/14 2:42 PM
 */
@SpringBootTest(classes = ApiTestApplication.class)
@RunWith(SpringRunner.class)
public class ApiTest {

    @Resource
    private UserController userController;

    @Test
    public void passCase() {
        UserInfo userInfo = userController.queryUserInfo("aaa");
        System.out.println(JSON.toJSONString(userInfo));
        assert Objects.equals(userInfo.getCode(), "0000");
    }

    @Test
    public void notPassCase() {
        UserInfo userInfo = userController.queryUserInfo("ddd");
        System.out.println(JSON.toJSONString(userInfo));
        assert Objects.equals(userInfo.getCode(), "1111");
    }
}
