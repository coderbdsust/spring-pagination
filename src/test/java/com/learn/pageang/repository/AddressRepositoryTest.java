package com.learn.pageang.repository;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class AddressRepositoryTest {

    public AddressRepositoryTest(){
        System.out.println("AddressRepositoryTest");
    }

    @Test
    public void saveAddress(){

    }
}
