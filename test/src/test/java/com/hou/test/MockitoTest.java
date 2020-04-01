package com.hou.test;

import com.hou.test.user.UserMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;

//测试接口
@RunWith(SpringRunner.class)
@SpringBootTest
public class MockitoTest {

    // mock为一个interface提供一个虚拟的实现
    @MockBean
    private UserMapper userMapper;

    @Before
    public void init() {
        //给接口方法预测一个实现结果
        BDDMockito.given(userMapper.createUser("yaozhen")).willReturn(Integer.valueOf(1));
        BDDMockito.given(userMapper.createUser("")).willReturn(Integer.valueOf(0));
        BDDMockito.given(userMapper.createUser(null)).willThrow(NullPointerException.class);
    }

    @Test(expected = NullPointerException.class) //测试方法会抛出异常,防止测试不通过
    public void testInteface() {
        Assert.assertEquals(Integer.valueOf(1), userMapper.createUser("yaozhen"));
        Assert.assertEquals(Integer.valueOf(0), userMapper.createUser(""));
        Assert.assertEquals(Integer.valueOf(0), userMapper.createUser(null));

    }

}
