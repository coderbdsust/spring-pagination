package com.learn.pageang.service;

import com.learn.pageang.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


public interface IUserService {

    Page<User> findAll(PageRequest pageRequest);

    User saveOrUpdate(User user);

    void delete(User user);

    void delete(Long userId);

    User findById(Long userId);
}
