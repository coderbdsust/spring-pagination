package com.learn.pageang.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class UserServiceTest {

    public UserServiceTest(){
        System.out.println("UserServiceTest");
    }

    @Test
    public void saveUser(){

    }
}
