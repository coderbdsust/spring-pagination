package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import service.IUserService;
import service.UserService;

@RestController(value = "/users")
public class UserController {

    IUserService userService;

    @Autowired
    private void setUserService(UserService userService){
        Assert.notNull(userService);
        this.userService=userService;
    }

    @GetMapping(value = {"","/"})
    public ResponseEntity getUsers(@PageableDefault Pageable pageable){
        return ResponseEntity.ok().body(userService.findAll(pageable));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity getUser(@PathVariable Long id){
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @PostMapping(value = {"","/"})
    public ResponseEntity save(User user){
        User saveUser=this.userService.saveOrUpdate(user);
        return ResponseEntity.ok().body(saveUser);
    }

    @PostMapping(value = "{id}")
    public ResponseEntity delete(@PathVariable Long id){
        this.userService.delete(id);
        return ResponseEntity.ok().body(id);
    }

}
