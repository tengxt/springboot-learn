package com.tengxt.springboottesting;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTestingApplicationTests {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setupMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    /*@BeforeClass
    public static void beforeClassTest(){
        System.out.println("before class test");
    }

    @Before
    public void beforeTest(){
        System.out.println("before test");
    }

    @Test
    public void test1() {
        System.out.println("test 1 + 1 = 2");
        Assert.assertEquals(2, 1 + 1);
    }

    @Test
    public void test2(){
        System.out.println("test 2 + 2 = 4");
        Assert.assertEquals(4, 2 + 2);
    }

    @After
    public void afterTest(){
        System.out.println("after test");
    }

    @AfterClass
    public static void afterClassTest(){
        System.out.println("after class test");
    }
*/
}
