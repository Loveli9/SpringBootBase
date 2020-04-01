package com.hou.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.EnvironmentTestUtils;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;

import static org.junit.Assert.assertEquals;

/**
 * spring会优先加载测试环境下的配置文件
 * 测试环境没有才会加载正式环境的配置文件
 */
@SpringBootTest(properties = {"app.version=1.5"}) //添加配置项
@RunWith(SpringRunner.class)
public class EnvTest {

    @Autowired
    private ConfigurableEnvironment env;

    //添加配置项
    @Before
    public void init() {
        EnvironmentTestUtils.addEnvironment(env, "app.admin=yaozhen");
        EnvironmentTestUtils.addEnvironment(env, "app.dept=eastsoftware");
    }

    //测试配置项
    @Test
    public void testEnv() {
        assertEquals("springboottest", env.getProperty("app.name"));
        Assert.assertEquals("yaozhen", env.getProperty("app.admin"));
        Assert.assertEquals("eastsoftware", env.getProperty("app.dept"));
        Assert.assertEquals("1.5", env.getProperty("app.version"));
        //Assert.assertEquals("springboot", env.getProperty("app.name")); 正式环境测试不通过
    }

}
