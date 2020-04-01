package com.hou.test;

import com.hou.test.user.AdminDao;
import com.hou.test.user.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


/**
 * @author houzheng
 * @WebMvcTest 不需要运行在web环境中, 但是要指明测试哪个Controller,
 * 只有一个的时候可以不指定
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {UserController.class})
public class TestController02 {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AdminDao adminDao;

    @Test
    public void test01() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user/name")) //建立请求url
                .andExpect(MockMvcResultMatchers.status().isOk()) //添加返回结果的状态
                .andExpect(MockMvcResultMatchers.content().string("yaozhen")); //添加返回结果的内容
    }

    @Test
    public void test02() throws Exception {            //设置请求参数
        mvc.perform(MockMvcRequestBuilders.get("/user/age").param("age", "24"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().string("24"));
    }

}
