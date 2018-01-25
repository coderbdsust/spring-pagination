package com.learn.pageang.controller;

import com.learn.pageang.model.User;
import com.learn.pageang.rsupport.UserResource;
import com.learn.pageang.rsupport.assembler.UserAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.learn.pageang.service.IUserService;
import com.learn.pageang.service.UserService;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;

    @Autowired
    private PagedResourcesAssembler pagedResourcesAssembler;

    @Autowired
    private UserAssembler userAssembler;

    @GetMapping("")
    public ResponseEntity getUsers(@PageableDefault Pageable page){
        Page<User> pageData=userService.findAll(new PageRequest(page.getPageNumber(),page.getPageSize(),page.getSort()));
        PagedResources<User> resources=pagedResourcesAssembler.toResource(pageData, userAssembler);
        return ResponseEntity.ok().body(resources);
    }

    @PostMapping(value = "")
    public ResponseEntity save(User user){
        User saveUser=this.userService.saveOrUpdate(user);
        UserResource userResource=userAssembler.toResource(saveUser);
        return ResponseEntity.ok().body(userResource);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable Long id, @Validated User user){
        User saveUser=this.userService.saveOrUpdate(user);
        UserResource userResource=userAssembler.toResource(saveUser);
        return ResponseEntity.ok().body(userResource);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getUser(@PathVariable(name = "id") Long id){
        User user=userService.findById(id);
        UserResource userResource=userAssembler.toResource(user);
        return ResponseEntity.ok().body(userResource);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable() Long id){
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
