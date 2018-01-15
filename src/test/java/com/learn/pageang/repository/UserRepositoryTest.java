package com.learn.pageang.repository;


import com.learn.pageang.service.UserService;
import org.assertj.core.api.Assertions;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;
import java.util.List;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class UserRepositoryTest {

    public UserRepositoryTest(){
        System.out.println("AddressRepositoryTest");
    }



    @Test
    public void allUser(){
//        assertThat(userRepository.findAll().iterator().hasNext(),true);
    }
}
