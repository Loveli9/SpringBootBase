package com.hou.test;

import com.hou.test.user.Admin;
import com.hou.test.user.AdminDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.TestCase;

/**
 * 测试步骤:在测试类上加上下面两个注解:
 *
 * @RunWith(SpringRunner.class)
 * @SpringBootTest 就可以直接从spring容器中直接获取bean
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfigApplication.class)  //加载测试配置类
public class UserDaoTest extends TestCase {

    @Autowired  //注入对象
    private AdminDao userDao;

    @Autowired
    private ApplicationContext context;

    //测试User对象是否在spring容器中
    @Test
    public void testUserNotNull() {
        Assert.assertNotNull(context.getBean(Admin.class));
        Assert.assertNotNull(context.getBean(Runnable.class));
    }

    //测试userdao方法
    @Test
    public void testAddUser() {
        //参数必须是对象
        Assert.assertEquals(Integer.valueOf(1), userDao.addUser("123456"));
        Assert.assertEquals(Integer.valueOf(0), userDao.addUser(null));
    }


}
