package com.learn.pageang.controller;

import com.learn.pageang.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.learn.pageang.service.IUserService;
import com.learn.pageang.service.UserService;

@RestController(value = "/users")
public class UserController {

    IUserService userService;

    @Autowired
    private void setUserService(UserService userService){
        Assert.notNull(userService);
        this.userService=userService;
    }

    @GetMapping(value = "")
    public ResponseEntity getUsers(@PageableDefault Pageable page){
        Page<User> pageData=userService.findAll(new PageRequest(page.getPageNumber(),page.getPageSize(),page.getSort()));
        return ResponseEntity.ok().body(pageData);
    }



    @PostMapping(value = "")
    public ResponseEntity save(User user){
        User saveUser=this.userService.saveOrUpdate(user);
        return ResponseEntity.ok().body(saveUser);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getUser(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable() Long id){
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
