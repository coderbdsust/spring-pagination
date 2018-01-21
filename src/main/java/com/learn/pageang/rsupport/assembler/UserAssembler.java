package com.learn.pageang.rsupport.assembler;

import com.learn.pageang.controller.UserController;
import com.learn.pageang.model.User;
import com.learn.pageang.rsupport.UserResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class UserAssembler extends ResourceAssemblerSupport<User, UserResource>{

    public UserAssembler() {
        super(UserController.class, UserResource.class);
    }

    @Override
    public UserResource toResource(User user) {
        UserResource userResource=new UserResource();
        userResource.setFirstName(user.getFirstName());
        userResource.setLastName(user.getLastName());
        userResource.setDateOfBirth(user.getDateOfBirth());
        userResource.setDesignation(user.getDesignation());
        userResource.setPermanentAddress(user.getPermanentAddress());
        userResource.setPresentAddress(user.getPresentAddress());
        userResource.setOfficialAddress(user.getOfficialAddress());
        userResource.removeLinks();
        userResource.add(linkTo(methodOn(UserController.class).getUser(user.getId())).withSelfRel());
        return userResource;
    }
}
